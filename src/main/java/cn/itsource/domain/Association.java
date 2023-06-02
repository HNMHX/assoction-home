package cn.itsource.domain;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Association {
    private Long id;
    private String ass_id;
    private String ass_name;
    private Timestamp create_time;
    private String user_id;
    private Member name;
}
