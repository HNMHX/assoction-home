package cn.itsource.query;

import lombok.Data;

@Data
public class ActivityQuery {

    private Integer currentPage=1;
    private Integer pageSize=5;
    public Integer getStart(){
        return (this.currentPage-1)*pageSize;
    }
    private String keyword;

}
