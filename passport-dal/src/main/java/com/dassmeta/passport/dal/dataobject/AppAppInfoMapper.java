package com.dassmeta.passport.dal.dataobject;

import com.dassmeta.passport.dal.dataobject.AppAppInfo;
import com.dassmeta.passport.dal.dataobject.AppAppInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppAppInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_app_info
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    int countByExample(AppAppInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_app_info
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    int deleteByExample(AppAppInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_app_info
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_app_info
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    int insert(AppAppInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_app_info
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    int insertSelective(AppAppInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_app_info
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    List<AppAppInfo> selectByExample(AppAppInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_app_info
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    AppAppInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_app_info
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    int updateByExampleSelective(@Param("record") AppAppInfo record, @Param("example") AppAppInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_app_info
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    int updateByExample(@Param("record") AppAppInfo record, @Param("example") AppAppInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_app_info
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    int updateByPrimaryKeySelective(AppAppInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_app_info
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    int updateByPrimaryKey(AppAppInfo record);
}