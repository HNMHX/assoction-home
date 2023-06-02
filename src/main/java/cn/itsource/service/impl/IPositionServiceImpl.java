package cn.itsource.service.impl;

import cn.itsource.domain.Position;
import cn.itsource.mapper.IPositionMapper;
import cn.itsource.domain.Department;
import cn.itsource.domain.Position;
import cn.itsource.mapper.EmployeeMapper;
import cn.itsource.mapper.IPositionMapper;
import cn.relyol.query.PositionQuery;
import cn.relyol.service.IPositionService;
import cn.itsource.until.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class IPositionServiceImpl implements IPositionService {
    @Autowired
    private IPositionMapper positionMapper;
    @Override
    public List<Position> selectAll() {
        return positionMapper.selectAll();
    }

    @Override
    public Position selectById(Long id) {
        return positionMapper.selectById(id);
    }

    @Override
    public void add(Position position) {
        positionMapper.add(position);
    }

    @Override
    public void update(Position position) {
        positionMapper.update(position);
    }

    @Override
    public void deleteById(Long id) {
        positionMapper.deleteById(id);
    }

    @Override
    public PageList<Position> queryByPage(PositionQuery query) {
        //new一个 PageList来接收参数
        PageList<Position> pageList=new PageList<>();
        //查询当前页面数据
        List<Position> rows = positionMapper.selectByPage(query);
        pageList.setRows(rows);
        //查询统计条数
        Long total = positionMapper.count(query);
        pageList.setTotal(total);
        return  pageList;
    }

    @Override
    public void batchDelete(List<Long> ids) {
        positionMapper.batchDelete(ids);
    }
}
