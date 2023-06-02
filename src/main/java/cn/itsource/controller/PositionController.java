package cn.itsource.controller;

import cn.itsource.domain.Position;
import cn.itsource.until.PageList;
import cn.itsource.domain.Position;
import cn.relyol.query.PositionQuery;
import cn.relyol.service.IPositionService;
import cn.itsource.until.JsonReslut;
import cn.itsource.until.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pos")
public class PositionController {
    @Autowired
    private IPositionService positionService;
    //查询所有
    @GetMapping
    private List<Position>queryAll(){

        return  positionService.selectAll();
    }
    //根据id查询
    @GetMapping("/{id}")
    public Position queryById(@PathVariable("id")Long id){

        return positionService.selectById(id);
    }
    //分页查询+条件查询+统计条数
    @PostMapping
    public PageList<Position> queryByPage(@RequestBody PositionQuery query){

        return positionService.queryByPage(query);
    }
    //新增+修改
    @PutMapping
    public JsonReslut addOrupdate(@RequestBody Position position){
        try{
            if (position.getId()==null){
                positionService.add(position);
            }else {
                positionService.update(position);
            }
            return  new JsonReslut();
        }catch (Exception e){
            e.printStackTrace();
            return  new JsonReslut(false,"操作失败");
        }
    }
    //根据id删除
    @DeleteMapping("/{id}")
    public JsonReslut deleteById(@PathVariable("id")Long id){
        try{
            positionService.deleteById(id);
            return  new JsonReslut();
        }catch (Exception e){
            e.printStackTrace();
            return  new JsonReslut(false,"删除失败");
        }

    }
    //批量删除接口
    @PatchMapping
    public JsonReslut batchDelete(@RequestBody List<Long>ids){
        try{
            positionService.batchDelete(ids);
            return new JsonReslut();
        }catch (Exception e){
            e.printStackTrace();
            return  new JsonReslut(false,"删除失败");
        }
    }
}
