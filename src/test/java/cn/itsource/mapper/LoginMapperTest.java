package cn.itsource.mapper;

import cn.itsource.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes= App.class)

public class LoginMapperTest {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Test

    public void selectByUsername() {

    }
}