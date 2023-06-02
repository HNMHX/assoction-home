package cn.itsource.controller;

import cn.itsource.domain.Activity;
import cn.itsource.query.ActivityQuery;
import cn.itsource.service.IActivityService;
import cn.itsource.until.JsonReslut;
import cn.itsource.until.PageList;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Table3")
public class Activitycontroller {

    @Autowired
    private IActivityService activityService;

    @GetMapping()
    @ApiOperation("查询所有")
    public List<Activity>queryAll(){
        return  activityService.queryAll();
    }


    @GetMapping("/{id}")
    @ApiOperation("根据id查询")
    public Activity queryById(@PathVariable ("id") Long id){
       return activityService.queryId(id);
    }
    @PostMapping()
    @ApiOperation("分页")
    public PageList<Activity> queryByPage(@RequestBody ActivityQuery query){
        return activityService.queryByPage(query);




    }

    @PutMapping()
    @ApiOperation("增加与修改")
    public JsonReslut addOrUpdate(@RequestBody Activity activity){
        try {
            if (activity.getId() == null){
                activityService.insert(activity);
            }else{
                activityService.update(activity);
            }
            return new JsonReslut();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonReslut(false,"操作失败");
        }

    }
    @DeleteMapping("/{id}")
    @ApiOperation("删除数据")
    public JsonReslut deleteById(@PathVariable("id") Long id){
        try{
            activityService.deleteById(id);
            return  new JsonReslut();

        }catch (Exception e){
            e.printStackTrace();
            return  new JsonReslut(false,"删除失败");
        }
    }
    @PatchMapping()
    public JsonReslut batchRemove(@RequestBody List<Long> ids){
        try{
            activityService.batchRemove(ids);
            return  new JsonReslut();

        }catch (Exception e){
            e.printStackTrace();
            return  new JsonReslut(false,"删除失败");
        }
    }
    /*@GetMapping("/tree3")
    public List<Activity>getTree(Activity activity){
        return activityService.getTree(activity);
    }*/
}
