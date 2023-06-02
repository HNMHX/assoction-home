package cn.relyol.query;

import lombok.Data;

@Data
public class PositionQuery {
    //当前页
    private Integer currentPage=1;
    //每页显示条数
    private  Integer pageSize=5;
    //计算起始行
    private  Integer getStart(){
        return (this.currentPage-1)*pageSize;
    }
    //条件查询
    private String keyword;
}
