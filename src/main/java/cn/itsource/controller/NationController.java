package cn.itsource.controller;

import cn.itsource.domain.Nation;
import cn.itsource.query.NationQuery;
import cn.itsource.service.INationService;
import cn.itsource.until.JsonReslut;
import cn.itsource.until.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nat")
public class NationController {
    @Autowired
    private INationService nationService;
    //查询所有
    @GetMapping
    public List<Nation> queryAll(){
        return nationService.selectAll();
    }
    //根据id查询
    @GetMapping("/{id}")
    public Nation queryById(@PathVariable("id")Long id){
        return nationService.selectById(id);
    }
    //分页查询+条件查询+统计条数
    @PostMapping
    public PageList<Nation> queryByPage(@RequestBody NationQuery query){
        return nationService.queryByPage(query);
    }
    //新增+修改
    @PutMapping
    public JsonReslut addOrupdate(@RequestBody Nation nation){
        try{
            if(nation.getId()==null){
                nationService.add(nation);
            }else{
                nationService.update((nation));
            }
            return new JsonReslut();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonReslut(false,"操作失败");
        }
    }
    //根据id删除
    @DeleteMapping("/{id}")
    public JsonReslut deleteById(@PathVariable("id")Long id){
        try{
            nationService.deleteById(id);
            return new JsonReslut();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonReslut(false,"删除失败");
        }
    }
    //批量删除
    @PatchMapping
    public JsonReslut bathDelete(@RequestBody List<Long>ids){
        try{
            nationService.batchDelete(ids);
            return new JsonReslut();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonReslut(false,"删除失败");
        }
    }
}
