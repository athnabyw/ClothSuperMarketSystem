package ui;

import bean.User;

import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Description：UI里的公用数据和方法
 * Author: 百里凌
 * Date: Created in 2019/11/22 下午 5:30
 * Version: 0.0.1
 * Modified By:
 */
public abstract class BaseClass {
    protected static Scanner input = new Scanner(System.in);
    protected static User currUser; //当前用户对象（已登录），方便各种UI界面类获得用户对象

    //使用JavaBean从properties文件中提取数据
    private static ResourceBundle r = ResourceBundle.getBundle("res.r");


    /**
     * @Description:  封装一些简易的方法
     * @Date 下午 9:04 2019/11/22
     **/
    //从properties文件中提取文字
    public static String getString(String key) {
        String string = r.getString(key);
        return string;
    }

    //打印（println函数）
    public static void println(String s){
        System.out.println(s);
    }

    //打印（print函数）
    public static void print(String s){
        System.out.print(s);
    }
}
