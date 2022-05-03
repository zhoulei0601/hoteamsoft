package com.hoteamsoft.modules.project.controller;

import com.alibaba.fastjson.JSON;
import com.hoteamsoft.modules.project.entity.ProjectGantt;
import com.hoteamsoft.modules.project.model.ProjectManttLinkModel;
import com.hoteamsoft.modules.project.service.ProjectGanttService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;


@SpringBootTest
@DisplayName("甘特图-单元测试")
class ProjectGanttControllerTest {
    @Autowired
    private ProjectGanttService projectGanttService;


    @Test
    @DisplayName("查询甘特图")
    void selectAll() {
        ProjectManttLinkModel model = projectGanttService.selectGranttLists(null);
        System.out.println(JSON.toJSON(model));
    }

    @Test
    void selectOne() {
    }

    @Test
    @DisplayName("保存甘特图")
    void insert() {
        boolean b = projectGanttService.save(new ProjectGantt()
                .setProjectName("测试")
                .setStartTime(LocalDateTime.now())
                .setFinishTime(LocalDateTime.now()));
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}