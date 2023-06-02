package cn.itsource.mapper;

import cn.itsource.domain.Employee;
import cn.itsource.query.EmployeeQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface EmployeeMapper {
    //查询所有
    List<Employee> selectAll();
    //根据id查询单条数据
    Employee selectById(Long id);
    //新增
    void add(Employee employee);
    //编辑
    void update(Employee employee);
    //删除
    void deleteById(Long id);
    //分页+条件查询
   // List<Employee> selectByPage(EmployeeQuery query);
    //总条数
    Long count(EmployeeQuery query);

    void batchDelete(List<Long> ids);

    List<Employee> selectByPage(EmployeeQuery query);
    Employee selectByUsername(String username);
}
