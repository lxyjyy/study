package com.dhl.tools.mapper;

import com.dhl.tools.domain.CargoLocation;
import com.dhl.tools.domain.CargoLocationExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CargoLocationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CargoLocation
     *
     * @mbg.generated
     */
    long countByExample(CargoLocationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CargoLocation
     *
     * @mbg.generated
     */
    int deleteByExample(CargoLocationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CargoLocation
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CargoLocation
     *
     * @mbg.generated
     */
    int insert(CargoLocation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CargoLocation
     *
     * @mbg.generated
     */
    int insertSelective(CargoLocation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CargoLocation
     *
     * @mbg.generated
     */
    List<CargoLocation> selectByExample(CargoLocationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CargoLocation
     *
     * @mbg.generated
     */
    CargoLocation selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CargoLocation
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") CargoLocation record, @Param("example") CargoLocationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CargoLocation
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") CargoLocation record, @Param("example") CargoLocationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CargoLocation
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(CargoLocation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CargoLocation
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(CargoLocation record);
}