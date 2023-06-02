package cn.itsource.controller;

import cn.itsource.domain.Department;
import cn.itsource.query.DepartmentQuery;
import cn.itsource.service.IDepartmentService;
import cn.itsource.until.JsonReslut;
import cn.itsource.until.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//controller+responseBody
@RequestMapping("/dept")
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;
    //查询所有
    @GetMapping
    private List<Department>queryAll(){
        return departmentService.selectAll();
    }
    //根据id查询
    @GetMapping("{id}")
    public Department queryById(@PathVariable("id")Long id){
        return departmentService.selectById(id);
    }
    @PostMapping
    public PageList<Department> queryByPage(@RequestBody DepartmentQuery query){
        return departmentService.queryByPage(query);
    }
    //新增+修改
    @PutMapping
    public JsonReslut addOrupdate(@RequestBody Department department){
        try{
            if(department.getId()==null){
                departmentService.add(department);
            }else {
                departmentService.update(department);
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
            departmentService.deleteById(id);
            return new JsonReslut();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonReslut(false,"删除失败");
        }
    }
    @PatchMapping
    public JsonReslut bathDelete(@RequestBody List<Long>ids){
        try {
            departmentService.batchDelete(ids);
            return new JsonReslut();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonReslut(false,"删除失败");
        }
    }
}
