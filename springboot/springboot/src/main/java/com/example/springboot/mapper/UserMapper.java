package com.example.springboot.mapper;

import com.example.springboot.entity.User;
import com.example.springboot.entity.UserLogin;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserMapper {
    @Select("select * from commonadmin")
    List<User> findAll();

    @Insert("INSERT into commonadmin(admin_name,admin_account,admin_pd,admin_sex,admin_phone,admin_email) " +
            "VALUES (#{admin_name},#{admin_account},#{admin_pd},#{admin_sex},#{admin_phone},#{admin_email})")
    int insert( User user);

    int update(User user);
    // 查询账号是否存在的方法
    @Select("SELECT COUNT(*) FROM commonadmin WHERE admin_account = #{admin_account}")
    Integer checkAccountExists(String admin_account);

    @Delete("delete from commonadmin  where admin_id = #{admin_id}")
    Integer deleteById(@Param("admin_id") Integer admin_id);

    @Select("select * from commonadmin where admin_name like concat ('%',#{admin_name},'%') " +
            "limit #{pageNum},#{pageSize}")
    List<User> selectPage(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize,@Param("admin_name")
                          String admin_name);
    @Select("select count(*) from commonadmin where admin_name like concat ('%',#{admin_name},'%')  ")
    Integer selectTotal(@Param("admin_name")String admin_name);

    @Select("select * from commonadmin where admin_name like concat ('%',#{admin_name},'%') " +
            "AND admin_id = #{admin_id} " +
            "limit #{pageNum},#{pageSize}")
    List<User> selectPageWithId(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize,@Param("admin_name")
            String admin_name,@Param("admin_id") Integer admin_id);

    @Select("SELECT COUNT(*) FROM commonadmin WHERE admin_name LIKE CONCAT('%',#{admin_name},'%') " +
            "AND admin_id = #{admin_id}")
    Integer selectTotalWithId(@Param("admin_name") String admin_name,
                        @Param("admin_id") Integer admin_id);

    @Select("select * from commonadmin where admin_account=#{admin_account}")
    UserLogin findBySuperAccount(String admin_account);
}
