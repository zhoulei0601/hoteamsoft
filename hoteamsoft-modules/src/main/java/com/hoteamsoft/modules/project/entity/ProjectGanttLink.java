package com.hoteamsoft.modules.project.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import nonapi.io.github.classgraph.json.Id;

import java.io.Serializable;

/**
 * 项目甘特图-依赖关系(ProjectGanttLink)表实体类
 *
 * @author makejava
 * @since 2022-04-27 18:23:46
 */
@SuppressWarnings("serial")
@Data
@Accessors(chain = true)
@EqualsAndHashCode
@ApiModel("项目甘特图-依赖关系")
@TableName("pj_project_gantt_link")
public class ProjectGanttLink implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 源项目/任务id
     */
    @ApiModelProperty("源项目/任务id")
    private Long source;
    /**
     * 目的项目/任务id
     */
    @ApiModelProperty("目的项目/任务id")
    private Long target;
    /**
     * 依赖类型
     */
    @ApiModelProperty("依赖类型")
    private String type;

}

