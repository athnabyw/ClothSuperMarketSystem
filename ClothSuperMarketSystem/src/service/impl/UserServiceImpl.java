package service.impl;

import bean.User;
import service.UserService;
import utils.BussinessException;
import utils.EmptyUtil;
import utils.UserIO;

/**
 * Description：用户业务类的实现类
 * Author: 百里凌
 * Date: Created in 2019/11/22 下午 7:54
 * Version: 0.0.1
 * Modified By:
 */
public class UserServiceImpl implements UserService {

    //注册用户的方法（实现）
    @Override
    public User register(User user) throws BussinessException {
        UserIO userIO = new UserIO();
        userIO.addUser(user);
        userIO.writeUsers();
        return user;
    }

    //用户登录的方法（实现）
    @Override
    public User login(String username, String password) throws BussinessException {
        if (EmptyUtil.isEmpty(username)){
            throw new BussinessException("username.notnull");
        }
        if (EmptyUtil.isEmpty(password)){
            throw new BussinessException("password.notnull");
        }
        UserIO userIO = new UserIO();
        User user = userIO.findByUsernameAndPassword(username, password);

        return user;
    }
}
