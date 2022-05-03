package com.hoteamsoft.modules.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hoteamsoft.modules.project.entity.ProjectGantt;
import com.hoteamsoft.modules.project.model.ProjectManttLinkModel;

/**
 * 项目甘特图表(ProjectGantt)表服务接口
 *
 * @author makejava
 * @since 2022-04-27 18:23:46
 */
public interface ProjectGanttService extends IService<ProjectGantt> {

    ProjectManttLinkModel selectGranttLists(ProjectGantt projectGantt);
}

