package com.example.springboot.mapper;

import com.example.springboot.entity.Bridge;
import com.example.springboot.entity.Inspector;
import com.example.springboot.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface InspectorMapper {


    @Select("select *from inspector")
    List<Inspector> finall();

    @Select("select * from inspector where inspector_name like concat ('%',#{inspector_name},'%')" +
            "limit #{pageNum},#{pageSize}")
    List<Inspector> selectPage(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("inspector_name")
            String inspector_name);

    @Select("select count(*) from inspector where inspector_name like concat ('%',#{inspector_name},'%') ")
    Integer selectTotal(@Param("inspector_name") String inspector_name);

    @Select("select * from inspector where inspector_name like concat ('%',#{inspector_name},'%') " +
            "AND inspector_id = #{inspector_id} " +
            "limit #{pageNum},#{pageSize}")
    List<Inspector> selectPageWithId(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("inspector_name")
            String inspector_name, @Param("inspector_id") Integer inspector_id);

    @Select("SELECT COUNT(*) FROM inspector WHERE inspector_name LIKE CONCAT('%',#{inspector_name},'%') " +
            "AND inspector_id = #{inspector_id}")
    Integer selectTotalWithId(@Param("inspector_name") String inspector_name,
                              @Param("inspector_id") Integer inspector_id);


    @Select("select * from bridge where direct_inspector=#{inspector_id} ")
    List<Bridge> selectPageOnlyId(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,
                                  @Param("inspector_id") Integer inspector_id);
    @Select("select  count(*) from bridge where  direct_inspector=#{inspector_id}")
    Integer selectTotalOnlyId(@Param("inspector_id") Integer inspector_id);

    //增加和修改
    @Insert("INSERT into inspector(inspector_name,inspector_account,inspector_pd,inspector_sex,inspector_phone,inspector_email) " +
            "VALUES (#{inspector_name},#{inspector_account},#{inspector_pd},#{inspector_sex},#{inspector_phone},#{inspector_email})")
    Integer insert(Inspector inspector);
    Integer update(Inspector inspector);
    @Delete("delete from inspector  where inspector_id = #{inspector_id}")
    Integer deleteById(@Param("inspector_id") Integer inspector_id);


}
