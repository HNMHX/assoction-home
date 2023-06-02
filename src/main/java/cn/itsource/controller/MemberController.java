package cn.itsource.controller;

import cn.itsource.domain.Member;
import cn.itsource.query.MemberQuery;
import cn.itsource.until.JsonReslut;
import cn.itsource.until.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Create By  on 2022/12/16.
 */
@RestController//Controller+ResponseBody
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private cn.itsource.service.IMemberService memberService;
    //查询所有
    @GetMapping
    public List<Member>queryAll() {
        return memberService.selectAll();
    }
    //根据id查询
    @GetMapping("{id}")
    public Member queryById(@PathVariable("id")Long id){
        return memberService.selectById(id);
        }
    //分页查询+条件查询+统计条数
    @PostMapping
    public PageList<Member> queryByPage(@RequestBody MemberQuery query){
        return memberService.queryByPage(query);
    }
    //新增+修改
    @PutMapping
    public JsonReslut addOrUpdate(@RequestBody Member member){
        try {
            if(member.getId()==null || member.getId()==0){
                memberService.add(member);
            }else{
                memberService.update(member);
            }
            return new JsonReslut();
        }catch(Exception e){
            e.printStackTrace();
            return new JsonReslut(false,"操作失败");
        }
    }
    //根据id删除
    @DeleteMapping("/{id}")
    public JsonReslut deleteById(@PathVariable("id")Long id){
        try{
            memberService.deleteById(id);
            return new JsonReslut();
        }catch(Exception e){
            e.printStackTrace();
            return new JsonReslut(false,"删除失败");
        }
    }
    //批量删除
    @PatchMapping
    public JsonReslut bathDelete(@RequestBody List<Long>ids){
        try{
            memberService.batchDelete(ids);
            return new JsonReslut();
        }catch(Exception e){
            e.printStackTrace();
            return new JsonReslut(false,"删除失败");
        }
    }
}
