package cn.itsource.impl;

import cn.itsource.App;
import cn.itsource.domain.Association;
import cn.itsource.mapper.AssociationMapper;
import cn.itsource.query.AssociationQuery;
import cn.itsource.service.AssociationService;
import cn.itsource.until.PageList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = {App.class}
)
public class AssociationServiceImplTest {
    @Autowired
    private AssociationService associationService;
    private AssociationMapper associationMapper;
    public AssociationServiceImplTest() {
    }

    @Test
    public void selectAll() {
        List var10000 = this.associationMapper.selectAll();
        PrintStream var10001 = System.out;
        var10000.forEach(var10001::println);
    }

    @Test
    public void queryByPage() {
        AssociationQuery query=new AssociationQuery();
        query.setCurrentPage(2);
        query.setPageSize(5);
        PageList<Association> pageList=associationService.queryByPage(query);
        System.out.println(pageList);
    }
}