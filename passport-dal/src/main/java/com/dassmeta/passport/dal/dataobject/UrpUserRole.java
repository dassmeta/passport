package com.dassmeta.passport.dal.dataobject;

import java.util.Date;

public class UrpUserRole {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column urp_user_role.id
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column urp_user_role.user_id
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column urp_user_role.role_id
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    private Long roleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column urp_user_role.create_time
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column urp_user_role.modify_time
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    private Date modifyTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column urp_user_role.id
     *
     * @return the value of urp_user_role.id
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column urp_user_role.id
     *
     * @param id the value for urp_user_role.id
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column urp_user_role.user_id
     *
     * @return the value of urp_user_role.user_id
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column urp_user_role.user_id
     *
     * @param userId the value for urp_user_role.user_id
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column urp_user_role.role_id
     *
     * @return the value of urp_user_role.role_id
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column urp_user_role.role_id
     *
     * @param roleId the value for urp_user_role.role_id
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column urp_user_role.create_time
     *
     * @return the value of urp_user_role.create_time
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column urp_user_role.create_time
     *
     * @param createTime the value for urp_user_role.create_time
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column urp_user_role.modify_time
     *
     * @return the value of urp_user_role.modify_time
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column urp_user_role.modify_time
     *
     * @param modifyTime the value for urp_user_role.modify_time
     *
     * @mbggenerated Thu Jan 19 13:57:36 CST 2017
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}