package cn.itsource.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Nation {
    private Long id;
    private String title;
    private String content;
    private Date create_time;
    private Long user_id;
    private Member name;
}
