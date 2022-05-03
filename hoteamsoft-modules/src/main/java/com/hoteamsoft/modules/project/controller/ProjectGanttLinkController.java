package com.hoteamsoft.modules.project.controller;


import com.hoteamsoft.base.BaseResult;
import com.hoteamsoft.modules.project.entity.ProjectGanttLink;
import com.hoteamsoft.modules.project.service.ProjectGanttLinkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 项目甘特图-依赖关系(ProjectGanttLink)表控制层
 *
 * @author makejava
 * @since 2022-04-27 18:23:46
 */
@Api(tags = "项目甘特图-依赖关系(ProjectGanttLink)")
@RestController
@RequestMapping("projectGanttLink")
public class ProjectGanttLinkController {
    /**
     * 服务对象
     */
    @Autowired
    private ProjectGanttLinkService projectGanttLinkService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "根据id查询 项目甘特图-依赖关系")
    @GetMapping("{id}")
    public BaseResult selectOne(@PathVariable Serializable id) {
        return BaseResult.ok(this.projectGanttLinkService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param projectGanttLink 实体对象
     * @return 新增结果
     */
    @ApiOperation(value = "新增 项目甘特图-依赖关系")
    @PostMapping
    public BaseResult insert(@RequestBody ProjectGanttLink projectGanttLink) {
        return BaseResult.ok(this.projectGanttLinkService.save(projectGanttLink));
    }

    /**
     * 修改数据
     *
     * @param projectGanttLink 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "修改 项目甘特图-依赖关系")
    @PutMapping
    public BaseResult update(@RequestBody ProjectGanttLink projectGanttLink) {
        return BaseResult.ok(this.projectGanttLinkService.updateById(projectGanttLink));
    }

    /**
     * 批量删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @ApiOperation(value = "删除 项目甘特图-依赖关系")
    @DeleteMapping
    public BaseResult deletes(@RequestParam("idList") List<Long> idList) {
        return BaseResult.ok(this.projectGanttLinkService.removeByIds(idList));
    }

    /**
     * 批量删除数据
     *
     * @param id 主键
     * @return 删除结果
     */
    @ApiOperation(value = "删除 项目甘特图-依赖关系")
    @DeleteMapping("{id}")
    public BaseResult delete(@PathVariable("id") Long id) {
        return BaseResult.ok(this.projectGanttLinkService.removeById(id));
    }
}

