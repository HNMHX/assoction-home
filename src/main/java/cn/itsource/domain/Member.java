package cn.itsource.domain;

import lombok.Data;

import java.util.Date;

/**
 * Create By  on 2022/12/16.
 */
@Data
public class Member {
    private Long id;
    private String user_id;
    private String fname;
    private String work_id;
    private Date ftime;
    private String ass_id;
    private String phone;
    private String email;
}
