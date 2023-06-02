package cn.itsource.service;

import cn.itsource.domain.Nation;
import cn.itsource.domain.Login;
import cn.itsource.query.NationQuery;
import cn.itsource.until.PageList;

import java.util.List;

public interface INationService {
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
    PageList<Nation>queryByPage(NationQuery query);

    void batchDelete(List<Long> ids);
}
