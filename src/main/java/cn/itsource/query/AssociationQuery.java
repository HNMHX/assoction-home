package cn.itsource.query;
import lombok.Data;

@Data
public class AssociationQuery {
    //当前页
    private Integer currentPage=1;
    //每页显示的页数
    private Integer pageSize=5;
    //计算起始行
    public Integer getStart(){
        return (this.currentPage-1)*pageSize;
    }
    //条件查询
    private String keyword;
}
