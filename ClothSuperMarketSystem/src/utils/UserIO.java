package utils;

import bean.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Description： 工具类     对user对象进行存储和取出（文件）
 * Author: 百里凌
 * Date: Created in 2019/11/22 下午 7:57
 * Version: 0.0.1
 * Modified By:
 */
public class UserIO  {
    private static List<User> users = new ArrayList<>();  //储存user的集合
    private static String USER_FILE = "src/res/user.obj";     //存放数据的文件的地址

    //存用户数据到文件
    public boolean writeUsers()throws BussinessException{
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(USER_FILE));
            out.writeObject(users);
            out.close();
            return true;
        } catch (IOException e) {
           throw new BussinessException("io.write.error");
        }

    }

    //从文件取用户数据
    public boolean readUsers()throws BussinessException{
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(USER_FILE));
            users = (ArrayList<User>) in.readObject();
            in.close();
            return true;
        } catch (IOException | ClassNotFoundException e) {
           throw new BussinessException("io.read.error");
        }
    }

    //添加一个新用户数据到集合
    public void addUser(User user){
        user.setId(users.size()+1);   //设置user的id   取list的现有元素编号
        users.add(user);
    }

    //根据用户输入的数据（用户名和密码）查找user
    public User findByUsernameAndPassword(String username,String password){
        for (User user:users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }


}
