package cn.itsource.domain;

import lombok.Data;

@Data
public class Department {
    private Long id;
    private String sn;
    private String name;
    private String dirPath;
    private Integer state;
    private Employee manager;//管理员
    private Long manager_id;
    private Long parent_id;
    private  Department parent;//上级部门
}
