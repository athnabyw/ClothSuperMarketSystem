package ui;

import bean.User;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.BussinessException;

/**
 * Description：登录的界面
 * Author: 百里凌
 * Date: Created in 2019/11/22 下午 9:24
 * Version: 0.0.1
 * Modified By:
 */
public class LoginClass extends BaseClass{
    public void login(){
        println(getString("input.username"));  //登录的提示文本
        String username = input.nextLine();
        println(getString("input.password"));
        String password = input.nextLine();
       // User user = new User(username, password);  //封装username和password
        UserService userService = new UserServiceImpl();  //new一个业务工具（服务）类
        User user = userService.login(username, password);//调用业务类的登录方法 , 返回查找到（或者不到）的user
        if (null != user){
            currUser = user;
        }else {
            throw new BussinessException("login.error");
        }


    }
}
