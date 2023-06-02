package cn.itsource.service.impl;

import cn.itsource.domain.Department;
import cn.itsource.domain.Login;
import cn.itsource.domain.Nation;
import cn.itsource.mapper.INationMapper;
import cn.itsource.query.NationQuery;
import cn.itsource.service.INationService;
import cn.itsource.until.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class INationServiceImpl implements INationService {
    @Autowired
    private INationMapper nationMapper;
    @Override
    public List<Nation> selectAll() {
        return nationMapper.selectAll();
    }

    @Override
    public Nation selectById(Long id) {
        return nationMapper.selectById(id);
    }

    @Override
    public void add(Nation nation) {
        nationMapper.add(nation);
    }

    @Override
    public void update(Nation nation) {
        nationMapper.update(nation);
    }

    @Override
    public void deleteById(Long id) {
        nationMapper.deleteById(id);
    }

    @Override
    public PageList<Nation> queryByPage(NationQuery query) {
        //new一个pageList对象来接受数据
        PageList<Nation> pageList = new PageList<>();
        //查询当前页的数据
        List<Nation> rows = nationMapper.selectByPage(query);
        pageList.setRows(rows);
        //统计条数
        Long total = nationMapper.count(query);
        pageList.setTotal(total);
        return pageList;
    }

    @Override
    public void batchDelete(List<Long> ids) {
        nationMapper.batchDelete(ids);
    }
}
