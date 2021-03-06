package com.dhl.tools.mapper;

import com.dhl.tools.domain.CargoLocationType;
import com.dhl.tools.domain.CargoLocationTypeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CargoLocationTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CargoLocationType
     *
     * @mbg.generated
     */
    long countByExample(CargoLocationTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CargoLocationType
     *
     * @mbg.generated
     */
    int deleteByExample(CargoLocationTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CargoLocationType
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CargoLocationType
     *
     * @mbg.generated
     */
    int insert(CargoLocationType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CargoLocationType
     *
     * @mbg.generated
     */
    int insertSelective(CargoLocationType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CargoLocationType
     *
     * @mbg.generated
     */
    List<CargoLocationType> selectByExample(CargoLocationTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CargoLocationType
     *
     * @mbg.generated
     */
    CargoLocationType selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CargoLocationType
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") CargoLocationType record, @Param("example") CargoLocationTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CargoLocationType
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") CargoLocationType record, @Param("example") CargoLocationTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CargoLocationType
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(CargoLocationType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CargoLocationType
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(CargoLocationType record);
}