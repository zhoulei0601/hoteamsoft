package com.hoteamsoft.modules.project.entity;


import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 项目甘特图表(ProjectGantt)表实体类
 *
 * @author makejava
 * @since 2022-04-27 18:23:46
 */
@SuppressWarnings("serial")
@Data
@Accessors(chain = true)
@EqualsAndHashCode
@ApiModel("项目甘特图表")
@TableName("pj_project_gantt")
public class ProjectGantt implements Serializable  {
    /**
     * 主键
     */
    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 任务/项目名称
     */
    @ApiModelProperty("任务/项目名称")
    private String projectName;
    /**
     * 项目状态
     */
    @ApiModelProperty("项目状态")
    private String projectState;
    /**
     * 项目编码
     */
    @ApiModelProperty("项目编码")
    private String projectCode;
    /**
     * 项目类型
     */
    @ApiModelProperty("项目类型")
    private String projectType;
    /**
     * 项目级别
     */
    @ApiModelProperty("项目级别")
    private String projectLevel;
    /**
     * 父级项目/任务名称
     */
    @ApiModelProperty("父级项目/任务名称")
    private Long pid;
    /**
     * 开始时间
     */
    @ApiModelProperty("开始时间")
    private LocalDateTime startTime;
    /**
     * 结束时间
     */
    @ApiModelProperty("结束时间")
    private LocalDateTime finishTime;
    /**
     * 持续时长
     */
    @ApiModelProperty("持续时长")
    private Integer duration;
    /**
     * 进展状态
     */
    @ApiModelProperty("进展状态")
    private String processState;
    /**
     * 计划进度
     */
    @ApiModelProperty("计划进度")
    private Object planProgressPercent;
    /**
     * 实际进度
     */
    @ApiModelProperty("实际进度")
    private Object realProgressPercent;
    /**
     * 项目经理
     */
    @ApiModelProperty("项目经理")
    private String managerId;
    /**
     * 删除标志 1-删除，0-未删除
     */
    @ApiModelProperty("删除标志 1-删除，0-未删除")
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private String delFlag;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    @TableField(fill = FieldFill.INSERT)
    private String createUser;
    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;
    /**
     * 更新人
     */
    @ApiModelProperty("更新人")
    @TableField(fill = FieldFill.UPDATE)
    private String updateUser;

    /**
    * 是否展开
    */
    @TableField(exist = false)
    private boolean open = true;

}

