package com.dhl.tools.mapper;

import com.dhl.tools.domain.RoleInfoAuthorityInfo;
import com.dhl.tools.domain.RoleInfoAuthorityInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleInfoAuthorityInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RoleInfo_AuthorityInfo
     *
     * @mbg.generated
     */
    long countByExample(RoleInfoAuthorityInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RoleInfo_AuthorityInfo
     *
     * @mbg.generated
     */
    int deleteByExample(RoleInfoAuthorityInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RoleInfo_AuthorityInfo
     *
     * @mbg.generated
     */
    int insert(RoleInfoAuthorityInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RoleInfo_AuthorityInfo
     *
     * @mbg.generated
     */
    int insertSelective(RoleInfoAuthorityInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RoleInfo_AuthorityInfo
     *
     * @mbg.generated
     */
    List<RoleInfoAuthorityInfo> selectByExample(RoleInfoAuthorityInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RoleInfo_AuthorityInfo
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") RoleInfoAuthorityInfo record, @Param("example") RoleInfoAuthorityInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RoleInfo_AuthorityInfo
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") RoleInfoAuthorityInfo record, @Param("example") RoleInfoAuthorityInfoExample example);
}