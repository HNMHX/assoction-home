package cn.itsource.service.impl;

import cn.itsource.config.MD5Utils;
import cn.itsource.domain.Employee;
import cn.itsource.domain.Login;
import cn.itsource.mapper.EmployeeMapper;
import cn.itsource.query.EmployeeQuery;
import cn.itsource.service.EmployeeService;
import cn.itsource.until.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    public EmployeeMapper employeeMapper;

    @Override
    public List<Employee> selectAll() {
        return employeeMapper.selectAll();
    }
    @Override
    public Employee selectById(Long id) {
        return employeeMapper.selectById(id);
    }
    @Override
    public void add(Employee employee) {
        employeeMapper.add(employee);
    }
    @Override
    public void update(Employee employee) {
        employeeMapper.update(employee);
    }
    @Override
    public void deleteById(Long id) {
        employeeMapper.deleteById(id);
    }
    @Override
    public PageList<Employee> queryByPage(EmployeeQuery query){
        PageList<Employee> pageList=new PageList<>();
        List<Employee> rows=employeeMapper.selectByPage(query);
        pageList.setRows(rows);
        Long total=employeeMapper.count(query);
        pageList.setTotal(total);
        return pageList;
    }
    @Override
    public void batchDelete(List<Long> ids) {
        employeeMapper.batchDelete(ids);
    }

    @Override
    public String checkPassWord(Login login) {
        Employee employee=employeeMapper.selectByUsername(login.getUsername());
        System.out.println(MD5Utils.string2MD5(login.getPassword()));
        if (employee==null){
            return "账号为空";
        }
        if (employee.getPassword().equals(MD5Utils.string2MD5(login.getPassword()))){
            return "密码正确";
        }
        return "非法请求";
    }

}
