package cn.itsource.service.impl;

import cn.itsource.config.MD5Utils;
import cn.itsource.domain.Association;
import cn.itsource.domain.Login;
import cn.itsource.mapper.AssociationMapper;
import cn.itsource.query.AssociationQuery;
import cn.itsource.service.AssociationService;
import cn.itsource.until.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class AssociationServiceImpl implements AssociationService {
    @Autowired
    public AssociationMapper associationMapper;

    @Override
    public List<Association> selectAll() {
        return associationMapper.selectAll();
    }
    @Override
    public Association selectById(Long id) {
        return associationMapper.selectById(id);
    }
    @Override
    public void add(Association association) {
        associationMapper.add(association);
    }
    @Override
    public void update(Association association) {
        associationMapper.update(association);
    }
    @Override
    public void deleteById(Long id) {
        associationMapper.deleteById(id);
    }
    @Override
    public PageList<Association> queryByPage(AssociationQuery query){
        PageList<Association> pageList=new PageList<>();
        List<Association> rows=associationMapper.selectByPage(query);
        pageList.setRows(rows);
        Long total=associationMapper.count(query);
        pageList.setTotal(total);
        return pageList;
    }

    @Override
    public void batchDelete(List<Long> ids) {
        associationMapper.batchDelete(ids);
    }

}
