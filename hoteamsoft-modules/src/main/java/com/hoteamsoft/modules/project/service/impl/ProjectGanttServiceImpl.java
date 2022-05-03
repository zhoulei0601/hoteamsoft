package com.hoteamsoft.modules.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hoteamsoft.modules.project.entity.ProjectGanttLink;
import com.hoteamsoft.modules.project.mapper.ProjectGanttMapper;
import com.hoteamsoft.modules.project.model.ProjectManttLinkModel;
import com.hoteamsoft.modules.project.service.ProjectGanttLinkService;
import com.hoteamsoft.modules.project.service.ProjectGanttService;
import com.hoteamsoft.modules.project.entity.ProjectGantt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 项目甘特图表(ProjectGantt)表服务实现类
 *
 * @author makejava
 * @since 2022-04-27 18:23:46
 */
@Service("projectGanttService")
public class ProjectGanttServiceImpl extends ServiceImpl<ProjectGanttMapper, ProjectGantt> implements ProjectGanttService {
    @Autowired
    private ProjectGanttLinkService linkService;
    @Override
    public ProjectManttLinkModel selectGranttLists(ProjectGantt projectGantt) {
        List<ProjectGantt> list = this.list(new QueryWrapper<ProjectGantt>(projectGantt));
        ProjectManttLinkModel manttLinkModel = new ProjectManttLinkModel().setData(list);
        if(list != null){
            List<Long> granttIds = list.stream().map(e -> e.getId()).collect(Collectors.toList());
            LambdaQueryWrapper<ProjectGanttLink> wrapper = new LambdaQueryWrapper<>();
            wrapper.in(ProjectGanttLink::getSource,granttIds);
            List<ProjectGanttLink> links = linkService.list(wrapper);
            manttLinkModel.setLinks(links);
        }
        return manttLinkModel;
    }
}

