package com.bupt.ctrl.dao;

import com.bupt.ctrl.model.Chapter;
import com.bupt.ctrl.model.ChapterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChapterMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sdrb..chapter
     *
     * @mbggenerated Fri Jul 05 08:34:32 CST 2019
     */
    int countByExample(ChapterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sdrb..chapter
     *
     * @mbggenerated Fri Jul 05 08:34:32 CST 2019
     */
    int deleteByExample(ChapterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sdrb..chapter
     *
     * @mbggenerated Fri Jul 05 08:34:32 CST 2019
     */
    int deleteByPrimaryKey(Integer chapterId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sdrb..chapter
     *
     * @mbggenerated Fri Jul 05 08:34:32 CST 2019
     */
    int insert(Chapter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sdrb..chapter
     *
     * @mbggenerated Fri Jul 05 08:34:32 CST 2019
     */
    int insertSelective(Chapter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sdrb..chapter
     *
     * @mbggenerated Fri Jul 05 08:34:32 CST 2019
     */
    List<Chapter> selectByExample(ChapterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sdrb..chapter
     *
     * @mbggenerated Fri Jul 05 08:34:32 CST 2019
     */
    Chapter selectByPrimaryKey(Integer chapterId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sdrb..chapter
     *
     * @mbggenerated Fri Jul 05 08:34:32 CST 2019
     */
    int updateByExampleSelective(@Param("record") Chapter record, @Param("example") ChapterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sdrb..chapter
     *
     * @mbggenerated Fri Jul 05 08:34:32 CST 2019
     */
    int updateByExample(@Param("record") Chapter record, @Param("example") ChapterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sdrb..chapter
     *
     * @mbggenerated Fri Jul 05 08:34:32 CST 2019
     */
    int updateByPrimaryKeySelective(Chapter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sdrb..chapter
     *
     * @mbggenerated Fri Jul 05 08:34:32 CST 2019
     */
    int updateByPrimaryKey(Chapter record);
}