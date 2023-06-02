package cn.itsource.mapper;

import cn.itsource.domain.Activity;
import cn.itsource.query.ActivityQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface IActivityMapper {
    List<Activity> selectAll();
    Activity selectById(Long id);
    void add(Activity activity);
    void update(Activity activity);
    void delete(Long id);
    List<Activity>selectByPage(ActivityQuery query);
    Long count(ActivityQuery  query);
    void batchRemove(List<Long> ids);
}
