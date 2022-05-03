package com.hoteamsoft.modules.project.model;

import com.google.common.collect.Lists;
import com.hoteamsoft.modules.project.entity.ProjectGantt;
import com.hoteamsoft.modules.project.entity.ProjectGanttLink;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author zhoul
 * @version 1.0
 * @description: gantt图数据模型
 * @date 2022/4/28 12:17
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class ProjectManttLinkModel {
    private List<ProjectGantt> data = Lists.newArrayList();
    private List<ProjectGanttLink> links = Lists.newArrayList();
}
