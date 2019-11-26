package ui;

import utils.BussinessException;
import utils.UserIO;

/**
 * Description： 欢迎界面
 * Author: 百里凌
 * Date: Created in 2019/11/22 下午 7:18
 * Version: 0.0.1
 * Modified By:
 */
public class WelcomeClass extends BaseClass {

    public void start() {
        boolean flag = true;  //控制循环的结束
        //欢迎界面的显示语句
        println(getString("info.welcome"));

        //读取文件中的用户数据（初始化）  储存在uers里（内存）
        UserIO userIO = new UserIO();
        userIO.readUsers();


        //开始界面的主循环
        //输入不正确则一直循环
        while (flag) {
            println(getString("info.login.reg"));
            println(getString("info.select"));

            String select = input.nextLine();

            switch (select) {
                case "1":  //登录
                   try {
                       new LoginClass().login();  //new 登录界面  调用login方法
                       println(getString("login.success"));   //登录 成功
                       flag = false;
                   }catch (BussinessException e){
                       e.printStackTrace();    //追踪异常位置(这里是最上层，控制台打印)
                       println(getString("login.error")); //失败  抛出异常
                   }

                    break;
                case "2":  //注册
                   try {
                       new RegisterClass().register(); //new 注册界面  调用register方法
                       println(getString("reg.success"));  //注册 成功
                       flag = false;
                   }catch (BussinessException e){
                        e.printStackTrace();    //追踪异常位置(这里是最上层，控制台打印)
                        println(getString("reg.error"));  //失败（可能是读取失败或者其他）抛出异常
                   }
                    break;
                default:
                    println(getString("input.error"));  //输入非法 打印提示语句
            }
        }

        HomeClass homeClass = new HomeClass();
        homeClass.show();

    }
}
