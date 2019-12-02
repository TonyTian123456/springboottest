package com.example.mapper.database2;

import com.example.domain.database2.NotifyResult;
import com.example.domain.database2.NotifyResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface NotifyResultMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notify_result
     *
     * @mbg.generated Mon Dec 02 13:39:52 CST 2019
     */
    long countByExample(NotifyResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notify_result
     *
     * @mbg.generated Mon Dec 02 13:39:52 CST 2019
     */
    int deleteByExample(NotifyResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notify_result
     *
     * @mbg.generated Mon Dec 02 13:39:52 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notify_result
     *
     * @mbg.generated Mon Dec 02 13:39:52 CST 2019
     */
    int insert(NotifyResult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notify_result
     *
     * @mbg.generated Mon Dec 02 13:39:52 CST 2019
     */
    int insertSelective(NotifyResult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notify_result
     *
     * @mbg.generated Mon Dec 02 13:39:52 CST 2019
     */
    List<NotifyResult> selectByExample(NotifyResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notify_result
     *
     * @mbg.generated Mon Dec 02 13:39:52 CST 2019
     */
    NotifyResult selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notify_result
     *
     * @mbg.generated Mon Dec 02 13:39:52 CST 2019
     */
    int updateByExampleSelective(@Param("record") NotifyResult record, @Param("example") NotifyResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notify_result
     *
     * @mbg.generated Mon Dec 02 13:39:52 CST 2019
     */
    int updateByExample(@Param("record") NotifyResult record, @Param("example") NotifyResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notify_result
     *
     * @mbg.generated Mon Dec 02 13:39:52 CST 2019
     */
    int updateByPrimaryKeySelective(NotifyResult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notify_result
     *
     * @mbg.generated Mon Dec 02 13:39:52 CST 2019
     */
    int updateByPrimaryKey(NotifyResult record);
}