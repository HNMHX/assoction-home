package cn.itsource.until;

import cn.itsource.domain.Department;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PageList<T>{
    //设置一个字段来接收当前页面查询到的数据
    List<T>rows=new ArrayList<>();
    //设置一个介绍条数
    Long total;
}
