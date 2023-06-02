package cn.itsource.mapper;

import cn.itsource.domain.Position;
import cn.itsource.domain.Employee;
import cn.itsource.domain.Position;
import cn.relyol.query.PositionQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IPositionMapper {
    //查询所有
    List<Position> selectAll();
    //根据id查询单条数据
    Position selectById(Long id);
    //新增
    void add(Position position);
    //编辑
    void update(Position position);
    //删除
    void  deleteById(Long id);
    //分页+条件查询
    List<Position> selectByPage(PositionQuery query);
    //总条数
    Long count(PositionQuery query);
    //批量删除
    void batchDelete(List<Long> ids);


}
