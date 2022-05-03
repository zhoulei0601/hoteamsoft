package com.hoteamsoft.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

/**
* @description: mybatis-plus 公共字段处理配置类
* @author zhoul
* @date 2022/4/28 8:30
* @version 1.0
*/
@Configuration
public class MybatisMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "createUser", String.class, this.getCurrUser());
        this.strictInsertFill(metaObject, "delFlag", String.class,"0");
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        this.strictUpdateFill(metaObject, "updateUser", String.class, this.getCurrUser());
    }

    private String getCurrUser(){
        return "1";
    }
}
