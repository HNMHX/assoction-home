package cn.itsource.service;

import cn.itsource.domain.Activity;
import cn.itsource.query.ActivityQuery;
import cn.itsource.until.PageList;

import java.util.List;

public interface IActivityService {
        List<Activity>queryAll();
        Activity queryId(Long id);
        void insert(Activity activity);
        void update(Activity activity);
        void deleteById(long id);
        PageList<Activity> queryByPage(ActivityQuery query);

        void batchRemove(List<Long> ids);

    //List<Activity> getTree(Activity activity);
}
