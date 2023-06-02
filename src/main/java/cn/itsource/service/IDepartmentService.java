package cn.itsource.service;

import cn.itsource.domain.Department;
import cn.itsource.query.DepartmentQuery;
import cn.itsource.until.PageList;

import java.util.List;

public interface IDepartmentService {
    List<Department> selectAll();

    Department selectById(Long id);

    void add(Department department);

    void update(Department department);

    void deleteById(Long id);
    //分页查询+条件查询
    PageList<Department> queryByPage(DepartmentQuery query);

    void batchDelete(List<Long> ids);
}
