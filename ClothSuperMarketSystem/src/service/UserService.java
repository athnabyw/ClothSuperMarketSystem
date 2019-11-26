package service;

import bean.User;
import utils.BussinessException;

/**
 * Description：用户业务类的接口
 * Author: 百里凌
 * Date: Created in 2019/11/22 下午 7:52
 * Version: 0.0.1
 * Modified By:
 */
public interface UserService {
    //以下为user业务的所有功能


    //用户的注册 方法（接口）
    public User register(User user) throws BussinessException;

    //用户的登录 方法（接口）
    public User login(String username,String password) throws BussinessException;
}
