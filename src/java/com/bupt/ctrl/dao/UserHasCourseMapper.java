package com.bupt.ctrl.dao;

import com.bupt.ctrl.model.UserHasCourse;
import com.bupt.ctrl.model.UserHasCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserHasCourseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sdrb..user_has_course
     *
     * @mbggenerated Fri Jul 05 08:34:32 CST 2019
     */
    int countByExample(UserHasCourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sdrb..user_has_course
     *
     * @mbggenerated Fri Jul 05 08:34:32 CST 2019
     */
    int deleteByExample(UserHasCourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sdrb..user_has_course
     *
     * @mbggenerated Fri Jul 05 08:34:32 CST 2019
     */
    int insert(UserHasCourse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sdrb..user_has_course
     *
     * @mbggenerated Fri Jul 05 08:34:32 CST 2019
     */
    int insertSelective(UserHasCourse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sdrb..user_has_course
     *
     * @mbggenerated Fri Jul 05 08:34:32 CST 2019
     */
    List<UserHasCourse> selectByExample(UserHasCourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sdrb..user_has_course
     *
     * @mbggenerated Fri Jul 05 08:34:32 CST 2019
     */
    int updateByExampleSelective(@Param("record") UserHasCourse record, @Param("example") UserHasCourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sdrb..user_has_course
     *
     * @mbggenerated Fri Jul 05 08:34:32 CST 2019
     */
    int updateByExample(@Param("record") UserHasCourse record, @Param("example") UserHasCourseExample example);
}