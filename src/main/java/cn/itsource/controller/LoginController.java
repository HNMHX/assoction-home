package cn.itsource.controller;

import cn.itsource.domain.Login;
import cn.itsource.service.EmployeeService;
import cn.itsource.until.JsonReslut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/login")
    public JsonReslut checkPassWord(@RequestBody Login login){
        String result=employeeService.checkPassWord(login);
        if (result.equals("密码正确")) {
            return new JsonReslut();
        }else {
            return new JsonReslut(false,"登录失败");
        }
    }
}
