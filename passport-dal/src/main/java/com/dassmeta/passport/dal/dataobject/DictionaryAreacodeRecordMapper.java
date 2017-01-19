package com.dassmeta.passport.dal.dataobject;

import com.dassmeta.passport.dal.dataobject.DictionaryAreacodeRecord;
import com.dassmeta.passport.dal.dataobject.DictionaryAreacodeRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictionaryAreacodeRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dictionary_areacode_record
     *
     * @mbggenerated Thu Jan 19 13:52:34 CST 2017
     */
    int countByExample(DictionaryAreacodeRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dictionary_areacode_record
     *
     * @mbggenerated Thu Jan 19 13:52:34 CST 2017
     */
    int deleteByExample(DictionaryAreacodeRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dictionary_areacode_record
     *
     * @mbggenerated Thu Jan 19 13:52:34 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dictionary_areacode_record
     *
     * @mbggenerated Thu Jan 19 13:52:34 CST 2017
     */
    int insert(DictionaryAreacodeRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dictionary_areacode_record
     *
     * @mbggenerated Thu Jan 19 13:52:34 CST 2017
     */
    int insertSelective(DictionaryAreacodeRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dictionary_areacode_record
     *
     * @mbggenerated Thu Jan 19 13:52:34 CST 2017
     */
    List<DictionaryAreacodeRecord> selectByExample(DictionaryAreacodeRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dictionary_areacode_record
     *
     * @mbggenerated Thu Jan 19 13:52:34 CST 2017
     */
    DictionaryAreacodeRecord selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dictionary_areacode_record
     *
     * @mbggenerated Thu Jan 19 13:52:34 CST 2017
     */
    int updateByExampleSelective(@Param("record") DictionaryAreacodeRecord record, @Param("example") DictionaryAreacodeRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dictionary_areacode_record
     *
     * @mbggenerated Thu Jan 19 13:52:34 CST 2017
     */
    int updateByExample(@Param("record") DictionaryAreacodeRecord record, @Param("example") DictionaryAreacodeRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dictionary_areacode_record
     *
     * @mbggenerated Thu Jan 19 13:52:34 CST 2017
     */
    int updateByPrimaryKeySelective(DictionaryAreacodeRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dictionary_areacode_record
     *
     * @mbggenerated Thu Jan 19 13:52:34 CST 2017
     */
    int updateByPrimaryKey(DictionaryAreacodeRecord record);
}