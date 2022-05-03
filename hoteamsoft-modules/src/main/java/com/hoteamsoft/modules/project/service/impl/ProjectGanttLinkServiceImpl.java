package com.hoteamsoft.modules.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hoteamsoft.modules.project.mapper.ProjectGanttLinkMapper;
import com.hoteamsoft.modules.project.entity.ProjectGanttLink;
import com.hoteamsoft.modules.project.service.ProjectGanttLinkService;
import org.springframework.stereotype.Service;

/**
 * 项目甘特图-依赖关系(ProjectGanttLink)表服务实现类
 *
 * @author makejava
 * @since 2022-04-27 18:23:46
 */
@Service("projectGanttLinkService")
public class ProjectGanttLinkServiceImpl extends ServiceImpl<ProjectGanttLinkMapper, ProjectGanttLink> implements ProjectGanttLinkService {

}

