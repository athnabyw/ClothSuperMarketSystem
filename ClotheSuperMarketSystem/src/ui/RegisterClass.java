package ui;

import bean.User;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.BussinessException;

/**
 * Description：用户注册界面
 * Author: 百里凌
 * Date: Created in 2019/11/22 下午 7:47
 * Version: 0.0.1
 * Modified By:
 */
public class RegisterClass extends BaseClass {

    //用户注册的界面（显示和业务）
    public void register() throws BussinessException {
        println(getString("input.username"));  //注册的提示语句
        String username = input.nextLine();
        println(getString("input.password"));   //注册的提示语句
        String password = input.nextLine();
        User user = new User(username, password);    //封装username和password
        UserService userService = new UserServiceImpl();   //new一个业务工具（服务）类
        userService.register(user);                   //调用业务类的注册方法


    }

}
