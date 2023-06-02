package cn.itsource.mapper;

import cn.itsource.domain.Association;
import cn.itsource.query.AssociationQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface AssociationMapper {
    //查询所有
    List<Association> selectAll();
    //根据id查询单条数据
    Association selectById(Long id);
    //新增
    void add(Association association);
    //编辑
    void update(Association association);
    //删除
    void deleteById(Long id);
    //分页+条件查询
    //总条数
    Long count(AssociationQuery query);
    List<Association> selectByPage(AssociationQuery query);

    void batchDelete(List<Long> ids);
}
