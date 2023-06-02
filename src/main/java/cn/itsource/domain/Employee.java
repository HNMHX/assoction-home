package cn.itsource.domain;

import lombok.Data;

@Data
public class Employee {
    private Long id;
    private String username;
    private String email;
    private String phone;
    private String salt;
    private String password;
    private Integer age;
    private Integer state;
    private Long department_id;
    private Long logininfo_id;
    private Long shop_id;
}
