package cn.itsource.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Activity {
    private Long id;
    private String active_name;
    private String fcontent;
    private Integer state;
    private Long user_id;
    private Employee manager;
}
