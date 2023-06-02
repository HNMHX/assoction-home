package cn.itsource.service;

import cn.itsource.domain.Association;
import cn.itsource.domain.Login;
import cn.itsource.query.AssociationQuery;
import cn.itsource.until.PageList;

import java.util.List;

public interface AssociationService {
    List<Association> selectAll();

    Association selectById(Long id);

    void add(Association association);

    void update(Association association);

    void deleteById(Long id);
    //分页查询+条件查询
    PageList<Association> queryByPage(AssociationQuery query);


    void batchDelete(List<Long> ids);
}
