package cn.itsource.controller;

import cn.itsource.domain.Employee;
import cn.itsource.query.EmployeeQuery;
import cn.itsource.service.EmployeeService;
import cn.itsource.until.JsonReslut;
import cn.itsource.until.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//controller+responseBody
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    //查询所有
    @GetMapping
    private List<Employee>queryAll(){
        return employeeService.selectAll();
    }
    //根据id查询
    @GetMapping("{id}")
    public Employee queryById(@PathVariable("id")Long id){
        return employeeService.selectById(id);
    }
    @PostMapping
    public PageList<Employee> queryByPage(@RequestBody EmployeeQuery query){
        return employeeService.queryByPage(query);
    }
    //新增+修改
    @PutMapping
    public JsonReslut addOrupdate(@RequestBody Employee employee){
        try{
            if(employee.getId()==null){
                employeeService.add(employee);
            }else {
                employeeService.update(employee);
            }
            return new JsonReslut();
        }catch (Exception e){
            e.printStackTrace();
            return  new JsonReslut(false,"操作失败");
        }
    }
    //删除
    @DeleteMapping("/{id}")
    public JsonReslut deleteById(@PathVariable("id")Long id){
        try {
            employeeService.deleteById(id);
            return new JsonReslut();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonReslut(false,"删除失败");
        }
    }
    @PatchMapping
    public JsonReslut bathDelete(@RequestBody List<Long>ids){
        try {
            employeeService.batchDelete(ids);
            return new JsonReslut();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonReslut(false,"删除失败");
        }
    }
}