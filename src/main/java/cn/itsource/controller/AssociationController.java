package cn.itsource.controller;

import cn.itsource.domain.Association;
import cn.itsource.query.AssociationQuery;
import cn.itsource.service.AssociationService;
import cn.itsource.until.JsonReslut;
import cn.itsource.until.PageList;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//controller+responseBody
@RequestMapping("/ass")
public class AssociationController {
    @Autowired
    private AssociationService associationService;
    //查询所有
    @GetMapping
    @ApiOperation("查询所有")
    private List<Association>queryAll(){
        return associationService.selectAll();
    }
    //根据id查询
    @GetMapping("{id}")
    @ApiOperation("根据id查询")
    public Association queryById(@PathVariable("id")Long id){
        return associationService.selectById(id);
    }
    @PostMapping
    @ApiOperation("分页")
    public PageList<Association> queryByPage(@RequestBody AssociationQuery query){
        return associationService.queryByPage(query);
    }
    //新增+修改
    @PutMapping
    @ApiOperation("新增+修改")
    public JsonReslut addOrupdate(@RequestBody Association association){
        try{
            if(association.getId()==null){
                associationService.add(association);
            }else {
                associationService.update(association);
            }
            return new JsonReslut();
        }catch (Exception e){
            e.printStackTrace();
            return  new JsonReslut(false,"操作失败");
        }
    }
    //删除
    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public JsonReslut deleteById(@PathVariable("id")Long id){
        try {
            associationService.deleteById(id);
            return new JsonReslut();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonReslut(false,"删除失败");
        }
    }
    @PatchMapping
    @ApiOperation("批量删除")
    public JsonReslut bathDelete(@RequestBody List<Long>ids){
        try {
            associationService.batchDelete(ids);
            return new JsonReslut();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonReslut(false,"删除失败");
        }
    }

}