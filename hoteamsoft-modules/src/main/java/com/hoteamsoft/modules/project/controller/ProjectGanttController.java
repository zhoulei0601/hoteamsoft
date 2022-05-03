package com.hoteamsoft.modules.project.controller;


import com.hoteamsoft.base.BaseResult;
import com.hoteamsoft.modules.project.entity.ProjectGantt;
import com.hoteamsoft.modules.project.model.ProjectManttLinkModel;
import com.hoteamsoft.modules.project.service.ProjectGanttService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * 项目甘特图表(ProjectGantt)表控制层
 *
 * @author makejava
 * @since 2022-04-27 18:23:46
 */
@Api(tags = "项目甘特图表(ProjectGantt)")
@RestController
@RequestMapping("projectGantt")
public class ProjectGanttController {
    /**
     * 服务对象
     */
    @Autowired
    private ProjectGanttService projectGanttService;

    /**
     * 查询所有甘特图及依赖关系
     *
     * @param projectGantt 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "分页查询所有数据")
    @GetMapping("getTaskLinks")
    public BaseResult<ProjectManttLinkModel> selectAll(ProjectGantt projectGantt) {
        return BaseResult.ok(this.projectGanttService.selectGranttLists(projectGantt));
    }

    /**
     * 保存task和link
     *
     * @param model 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "保存task和link")
    @PostMapping("saveTaskLink")
    public BaseResult selectAll(@RequestBody ProjectManttLinkModel model) {
        System.out.println(model);
        return BaseResult.ok(1);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "根据id查询 项目甘特图表")
    @GetMapping("{id}")
    public BaseResult<ProjectGantt> selectOne(@PathVariable Serializable id) {
        return BaseResult.ok(this.projectGanttService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param projectGantt 实体对象
     * @return 新增结果
     */
    @ApiOperation(value = "新增 项目甘特图表")
    @PostMapping
    public BaseResult insert(@RequestBody ProjectGantt projectGantt) {
        return BaseResult.ok(this.projectGanttService.save(projectGantt));
    }

    /**
     * 修改数据
     *
     * @param projectGantt 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "修改 项目甘特图表")
    @PutMapping
    public BaseResult update(@RequestBody ProjectGantt projectGantt) {
        return BaseResult.ok(this.projectGanttService.updateById(projectGantt));
    }

    /**
     * 批量删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @ApiOperation(value = "删除 项目甘特图表")
    @DeleteMapping
    public BaseResult deletes(@RequestParam("idList") List<Long> idList) {
        return BaseResult.ok(this.projectGanttService.removeByIds(idList));
    }

    /**
     * 根据id删除数据
     *
     * @param id 主键
     * @return 删除结果
     */
    @ApiOperation(value = "根据id删除数据")
    @DeleteMapping("{id}")
    public BaseResult delete(@PathVariable("id") Long id) {
        return BaseResult.ok(this.projectGanttService.removeById(id));
    }
}

