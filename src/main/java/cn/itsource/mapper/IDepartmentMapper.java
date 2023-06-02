package cn.itsource.mapper;

import cn.itsource.domain.Department;
import cn.itsource.query.DepartmentQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Mapper
public interface IDepartmentMapper {
    //查询所有
    List<Department> selectAll();
    //根据id查询单条数据
    Department selectById(Long id);
    //新增
    void add(Department department);
    //编辑
    void update(Department department);
    //删除
    void deleteById(Long id);
    //分页+条件查询
    List<Department> selectByPage(DepartmentQuery query);
    //总条数
    Long count(DepartmentQuery query);

    void batchDelete(List<Long> ids);
}
