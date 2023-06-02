package cn.itsource.service.impl;

import cn.itsource.domain.Activity;
import cn.itsource.mapper.IActivityMapper;
import cn.itsource.service.IActivityService;
import cn.itsource.until.PageList;
import cn.itsource.query.ActivityQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class IActivityServiceImpl implements IActivityService {

    @Autowired
    public IActivityMapper activityMapper;

    @Override
    public List<Activity> queryAll() {
        return activityMapper.selectAll();
    }

    @Override
    public Activity queryId(Long id) {

        return activityMapper.selectById(id);
    }

    @Override
    public void insert(Activity activity) {
        activityMapper.add(activity);
        this.update(activity);
    }

    @Override
    public void update(Activity activity) {
        /*String dirPath="";
        if(activity.getParent()==null){
            dirPath="/"+ activity.getId();
        }else{
            Activity parent = activityMapper.selectById(activity.getParent().getId());
            dirPath=parent.getDirPath()+"/"+ activity.getId();
        }
        activity.setDirPath(dirPath);
        activityMapper.update(activity);*/
    }

    @Override
    public void deleteById(long id) {
            activityMapper.delete(id);
    }

    @Override
    public PageList<Activity> queryByPage(ActivityQuery query) {

        PageList<Activity> PageList = new PageList<>();
        List<Activity> rows = activityMapper.selectByPage(query);
        Long total = activityMapper.count(query);
        PageList.setRows((rows));
        PageList.setTotal(total);
        return PageList;

    }

    @Override
    public void batchRemove(List<Long> ids) {
        activityMapper.batchRemove(ids);
    }

    /*@Override
    public List<Activity> getTree(Activity activity) {
        List<Activity> activities = activityMapper.selectAll();
        List<Activity>level1=new ArrayList<>();
        for(Activity dept: activities){
            if(dept.getParent_id()==null){
                level1.add(dept);
            }else{
                for(Activity dept2: activities){
                    if(dept.getParent_id()==dept2.getId()){
                        dept2.getChildren().add(dept);
                    }
                }
            }
        }
        return level1;
    }*/
}
