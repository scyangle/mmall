package com.scy.mall.dao;

import com.scy.mall.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int checkUserName(String username);

    int checkEmail(String email);

    User selectLogin(@Param("username") String username, @Param("password") String password);

    String selectQuestionByName(String username);

    int checkAmswer(@Param("username") String username, @Param("question") String question,@Param("answer") String answer);

    int updatePasswordByUsername(@Param("username") String username,@Param("md5Password") String md5Password);

    int checkPassword(@Param("password") String password, @Param("id") Integer id);

    int checkEmailByUserId(@Param("email") String email, @Param("id") Integer id);

}