package com.example.springboot.mapper;

import com.example.springboot.entity.Bridge;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BridgeMapper  {

    @Select("select * from bridge")
    List<Bridge> findall();

    @Insert("INSERT into bridge(bridge_id,bridge_name,bridge_address,create_date," +
            " bridge_type,bridge_length,bridge_width,design_life,design_load, direct_inspector) " +
            "VALUES (#{bridge_id},#{bridge_name},#{bridge_address},#{create_date},#{bridge_type}," +
            "#{bridge_length},#{bridge_width},#{design_life},#{design_load},#{direct_inspector})")
    Integer save(Bridge bridge);
    Integer update(Bridge bridge);

    @Select("select * from bridge where bridge_name like concat('%',#{bridge_name},'%')" +
            "limit #{pageNum},#{pageSize} ")
    List<Bridge> selectPage(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize, @Param("bridge_name") String bridge_name);


    @Select("select count(*) from bridge where bridge_name like concat('%',#{bridge_name},'%')")
    Integer selectTotal(@Param("bridge_name") String bridge_name);

    @Select("SELECT * FROM bridge WHERE bridge_name LIKE CONCAT('%',#{bridge_name},'%') " +
            "AND bridge_id = #{bridge_id} " +
            "LIMIT #{pageNum}, #{pageSize}")
    List<Bridge> selectPageWithId(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("bridge_name")
            String bridge_name, @Param("bridge_id") Integer bridge_id);

    @Select("SELECT COUNT(*) FROM bridge WHERE bridge_name LIKE CONCAT('%',#{bridge_name},'%') " +
            "AND bridge_id = #{bridge_id}")
    Integer selectTotalWithId(@Param("bridge_name") String bridge_name,
                              @Param("bridge_id") Integer bridge_id);



    @Delete("delete from bridge where bridge_id=#{bridge_id}")
    Integer deleteById(@Param("bridge_id") Integer bridge_id);


}
