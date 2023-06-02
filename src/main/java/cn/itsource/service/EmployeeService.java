package cn.itsource.service;

import cn.itsource.domain.Employee;
import cn.itsource.domain.Login;
import cn.itsource.query.EmployeeQuery;
import cn.itsource.until.PageList;

import java.util.List;

public interface EmployeeService {
    List<Employee> selectAll();

    Employee selectById(Long id);

    void add(Employee employee);

    void update(Employee employee);

    void deleteById(Long id);
    //分页查询+条件查询
    PageList<Employee> queryByPage(EmployeeQuery query);

    void batchDelete(List<Long> ids);

    String checkPassWord(Login login);
}
