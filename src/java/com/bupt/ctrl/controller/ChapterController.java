package com.bupt.ctrl.controller;

import com.bupt.ctrl.model.*;
import com.bupt.ctrl.common.commonPath;
import com.bupt.ctrl.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class ChapterController {

    @Autowired
    ChapterService chapterService;

    @Autowired
    CommentService commentService;

    @Autowired
    CourseService courseService;

    @Autowired
    UserService userService;

    @Autowired
    UserHasChapterService userHasChapterService;
    @RequestMapping("/singleChapter")
    public String getSingleChapter(@RequestParam(value="chapter_id") Integer chapter_id,
                                   @RequestParam(value="user_id",required = false) Integer user_id,
                                   @RequestParam(value="teacher_id") Integer teacher_id,
                                   Model model){
        Chapter chapter = chapterService.getChapter(chapter_id);
        model.addAttribute("chapter", chapter);
        Course course = courseService.getCourseByID(chapter.getCourseCourseId());
        model.addAttribute("course", course);
        Integer commentNum = commentService.getCommentNum(chapter_id);
        model.addAttribute("commentNum", commentNum);
        User teacher = userService.getUserByID(teacher_id);
        model.addAttribute("teacher", teacher);
        List<Comment> parentCommentList = commentService.getParentComment(chapter_id);
        System.out.println("parentCommentList Size: " + parentCommentList.size());
        List<GroupComment> groupCommentList = new ArrayList<>();
        for(int i = 0; i < parentCommentList.size(); i ++){
            Comment parentComment = (Comment)parentCommentList.get(i);
            User parentUser = userService.getUserByID(parentComment.getUserUserId());
            CommentAndUser parentCommentAndUser = new CommentAndUser(parentComment, parentUser);
            List<Comment> sonCommentList = commentService.getSonComment(parentComment.getCommentId());
            System.out.println("sonCommentList Size: " + sonCommentList.size());
            List<CommentAndUserAndPreviousUser> sonCommentAndUserList = new ArrayList<>();
            for(int j = 0; j < sonCommentList.size(); j ++){
                Comment sonComment = (Comment)sonCommentList.get(j);
                User sonUser = userService.getUserByID(sonComment.getUserUserId());
                Comment previousComment = commentService.getComment(sonComment.getCommentTo());
                User previousUser = userService.getUserByID(previousComment.getUserUserId());
                CommentAndUserAndPreviousUser sonCommentAndUser = new CommentAndUserAndPreviousUser(sonComment, sonUser, previousUser);
                sonCommentAndUserList.add(sonCommentAndUser);
            }
            System.out.println("Parent:  " + parentCommentAndUser.getUser().getUserId());
            System.out.println("Son:    " + sonCommentAndUserList.size());
            GroupComment groupComment = new GroupComment(parentCommentAndUser, sonCommentAndUserList);
            groupCommentList.add(groupComment);
        }

        //添加学习进度
        UserHasChapter userHasChapter=userHasChapterService.getHasLearned(user_id,chapter_id);
        if(userHasChapter != null){
            model.addAttribute("userHasChapter",userHasChapter);
        }


        model.addAttribute("groupCommentList", groupCommentList);
        System.out.println("groupCommentList Size:    " + groupCommentList.size());
        return "single-chapter";
    }

    //创建课程
    @RequestMapping(value = "/addChapter", method = RequestMethod.POST)
    public ModelAndView addChapter(@RequestParam(value = "course_id")int course_id, @RequestParam("chapterVideoFile") CommonsMultipartFile chapterVideoFile, Chapter chapter, HttpServletRequest request) throws IOException {

        ModelAndView mav = new ModelAndView("添加章节失败");

        String chapterVideoPath = request.getServletContext().getRealPath("/upload/videos/");//路径修改为服务器地址！！！
        String filename = chapterVideoFile.getOriginalFilename();//获取文件名

        String suffix = filename.substring(filename.lastIndexOf(".") + 1);//获取原文件后缀名

        int flag = 0;
        chapter.setCourseCourseId(course_id);
        flag = chapterService.addChapter(chapter);

        String prefix = String.valueOf(chapter.getChapterId());//用文件id做文件名，唯一标识
        String realChapterVideo = prefix + "." + suffix;//最终文件上传名
        String videoPath = chapterVideoPath + realChapterVideo;

        File videoFile = new File(videoPath);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）

        //判断目标文件夹是否存在，不存在则创建
        if (!videoFile.getParentFile().exists()) {
            videoFile.getParentFile().mkdirs();
        }

        chapterVideoFile.transferTo(videoFile);//复制文件

        if (flag == 1 && videoFile.exists()) {
            chapter.setChapterVideo(videoPath);
            chapterService.modifyChapterVideo(chapter);
            String c_id = String.valueOf(course_id);//转化course_id类型
            String success = "singleCourse?course_id=" + c_id;
            mav.setViewName("redirect:/" + success);//调用singleCourse
            return mav;
        }
        return mav;
    }

    @RequestMapping("/getProgress")
    public String getProgress(@RequestParam(value = "chapter_id") Integer chapter_id,@RequestParam(value = "user_id") Integer user_id,Model model){
        UserHasChapter userHasChapter=userHasChapterService.getHasLearned(user_id,chapter_id);
        model.addAttribute("userHasChapter",userHasChapter);
        return "single-chapter";
    }

    //更新进度
    @RequestMapping(value = "/updateProgress", method = RequestMethod.POST)
    public void updeteProgress(@RequestParam(value = "chapter_id") Integer chapter_id,@RequestParam(value = "user_id") Integer user_id,@RequestParam(value = "has_leared") Integer has_learned){
        System.out.print("has_learnt  ");
        System.out.println(has_learned);
        UserHasChapter userHasChapter=new UserHasChapter();
        userHasChapter.setUserHasLearned(has_learned);
        userHasChapter.setChapterChapterId(chapter_id);
        userHasChapter.setUserUserId(user_id);
        userHasChapterService.setHasLearned(userHasChapter);
        System.out.println(has_learned);
    }
}
