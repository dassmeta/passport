package com.dassmeta.passport.dal.dataobject;

import com.dassmeta.passport.dal.dataobject.UrpPermission;
import com.dassmeta.passport.dal.dataobject.UrpPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UrpPermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table urp_permission
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    int countByExample(UrpPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table urp_permission
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    int deleteByExample(UrpPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table urp_permission
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table urp_permission
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    int insert(UrpPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table urp_permission
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    int insertSelective(UrpPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table urp_permission
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    List<UrpPermission> selectByExample(UrpPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table urp_permission
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    UrpPermission selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table urp_permission
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    int updateByExampleSelective(@Param("record") UrpPermission record, @Param("example") UrpPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table urp_permission
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    int updateByExample(@Param("record") UrpPermission record, @Param("example") UrpPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table urp_permission
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    int updateByPrimaryKeySelective(UrpPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table urp_permission
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    int updateByPrimaryKey(UrpPermission record);
}