package com.example.springboot.mapper;

import com.example.springboot.entity.SuperLogin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SuperMapper {


    @Select("SELECT * FROM superadmin WHERE super_account = #{super_account}")
    SuperLogin findBySuperAccount(String super_account);
}
