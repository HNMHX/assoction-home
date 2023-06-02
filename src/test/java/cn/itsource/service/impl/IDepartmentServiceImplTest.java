package cn.itsource.service.impl;

import cn.itsource.App;
import cn.itsource.domain.Department;
import cn.itsource.query.DepartmentQuery;
import cn.itsource.service.IDepartmentService;
import cn.itsource.until.PageList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class IDepartmentServiceImplTest {
@Autowired
    private IDepartmentService departmentService;
    @Test
    public void queryByPage() {
        DepartmentQuery query=new DepartmentQuery();
        query.setCurrentPage(2);
        query.setPageSize(5);
        PageList<Department> pageList= departmentService.queryByPage(query);
        System.out.println(pageList);
    }
}