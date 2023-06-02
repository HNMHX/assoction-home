package cn.relyol.service;


import cn.itsource.domain.Position;
import cn.relyol.query.PositionQuery;
import cn.itsource.until.PageList;

import java.util.List;

public interface IPositionService {
    //查询所有
    List<Position> selectAll();
    //根据id查询单条数据
    Position selectById(Long id);
    //新增
    void add(Position position);
    //编辑
    void update(Position position);
    //删除
    void deleteById(Long id);
    //分页查询+查询总数
    PageList<Position>queryByPage(PositionQuery query);

    void batchDelete(List<Long> ids);
}
