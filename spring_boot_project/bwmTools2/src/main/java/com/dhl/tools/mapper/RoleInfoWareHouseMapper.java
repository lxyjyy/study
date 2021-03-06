package com.dhl.tools.mapper;

import com.dhl.tools.domain.RoleInfoWareHouse;
import com.dhl.tools.domain.RoleInfoWareHouseExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleInfoWareHouseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RoleInfo_WareHouse
     *
     * @mbg.generated
     */
    long countByExample(RoleInfoWareHouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RoleInfo_WareHouse
     *
     * @mbg.generated
     */
    int deleteByExample(RoleInfoWareHouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RoleInfo_WareHouse
     *
     * @mbg.generated
     */
    int insert(RoleInfoWareHouse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RoleInfo_WareHouse
     *
     * @mbg.generated
     */
    int insertSelective(RoleInfoWareHouse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RoleInfo_WareHouse
     *
     * @mbg.generated
     */
    List<RoleInfoWareHouse> selectByExample(RoleInfoWareHouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RoleInfo_WareHouse
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") RoleInfoWareHouse record, @Param("example") RoleInfoWareHouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RoleInfo_WareHouse
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") RoleInfoWareHouse record, @Param("example") RoleInfoWareHouseExample example);
}