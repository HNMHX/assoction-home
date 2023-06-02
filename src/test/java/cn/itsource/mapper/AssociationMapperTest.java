//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package cn.itsource.mapper;

import cn.itsource.App;
import java.io.PrintStream;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = {App.class}
)
public class AssociationMapperTest {
    @Autowired
    private AssociationMapper associationMapper;

    public AssociationMapperTest() {
    }

    @Test
    public void selectAll() {
        List var10000 = this.associationMapper.selectAll();
        PrintStream var10001 = System.out;
        var10000.forEach(var10001::println);
    }
}
