package cn.itsource.mapper;

import cn.itsource.domain.Nation;
import cn.itsource.query.NationQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface INationMapper {
    //查询全部
    List<Nation> selectAll();
    //根据id查询单条数据
    Nation selectById(Long id);
    //新增
    void add(Nation nation);
    //编辑
    void update(Nation nation);
    //删除
    void deleteById(Long id);
    //分页+条件查询
    List<Nation> selectByPage(NationQuery query);
    //总条数
    Long count(NationQuery query);

    void batchDelete(List<Long> ids);
}
