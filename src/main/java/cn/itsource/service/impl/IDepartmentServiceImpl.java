package cn.itsource.service.impl;

import cn.itsource.domain.Department;
import cn.itsource.mapper.IDepartmentMapper;
import cn.itsource.query.DepartmentQuery;
import cn.itsource.service.IDepartmentService;
import cn.itsource.until.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class IDepartmentServiceImpl implements IDepartmentService {
    @Autowired
    public IDepartmentMapper departmentMapper;
    @Override
    public List<Department> selectAll() {
        return departmentMapper.selectAll();
    }
    @Override
    public Department selectById(Long id) {
        return departmentMapper.selectById(id);
    }
    @Override
    public void add(Department department) {
        departmentMapper.add(department);
    }
    @Override
    public void update(Department department) {
        departmentMapper.update(department);
    }
    @Override
    public void deleteById(Long id) {
        departmentMapper.deleteById(id);
    }
    @Override
    public PageList<Department> queryByPage(DepartmentQuery query){
        PageList<Department> pageList=new PageList<>();
        List<Department> rows=departmentMapper.selectByPage(query);
        pageList.setRows(rows);
        Long total=departmentMapper.count(query);
        pageList.setTotal(total);
        return pageList;
    }

    @Override
    public void batchDelete(List<Long> ids) {
        departmentMapper.batchDelete(ids);
    }
}
