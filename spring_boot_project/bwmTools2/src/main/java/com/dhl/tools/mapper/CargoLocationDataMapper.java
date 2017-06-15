package com.dhl.tools.mapper;

import com.dhl.tools.domain.CargoLocationData;
import com.dhl.tools.domain.CargoLocationDataExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CargoLocationDataMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CargoLocation_Data
     *
     * @mbg.generated
     */
    long countByExample(CargoLocationDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CargoLocation_Data
     *
     * @mbg.generated
     */
    int deleteByExample(CargoLocationDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CargoLocation_Data
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CargoLocation_Data
     *
     * @mbg.generated
     */
    int insert(CargoLocationData record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CargoLocation_Data
     *
     * @mbg.generated
     */
    int insertSelective(CargoLocationData record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CargoLocation_Data
     *
     * @mbg.generated
     */
    List<CargoLocationData> selectByExample(CargoLocationDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CargoLocation_Data
     *
     * @mbg.generated
     */
    CargoLocationData selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CargoLocation_Data
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") CargoLocationData record, @Param("example") CargoLocationDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CargoLocation_Data
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") CargoLocationData record, @Param("example") CargoLocationDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CargoLocation_Data
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(CargoLocationData record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CargoLocation_Data
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(CargoLocationData record);
}