package com.hoteamsoft.modules.project.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.hoteamsoft.modules.project.entity.ProjectGantt;

/**
 * 项目甘特图表(ProjectGantt)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-27 18:23:46
 */
public interface ProjectGanttMapper extends BaseMapper<ProjectGantt> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ProjectGantt> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ProjectGantt> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ProjectGantt> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ProjectGantt> entities);

}

