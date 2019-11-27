package ui;

import bean.Clothes;
import service.ClothesService;
import service.impl.ClothesServiceImpl;
import utils.ConsoleTabler;

import java.util.List;

/**
 * Description：主界面
 * Author: 百里凌
 * Date: Created in 2019/11/26 下午 8:48
 * Version: 0.0.1
 * Modified By:
 */
public class HomeClass extends BaseClass{

    public void show(){
        showProducts(); //打印有内容的列表
        System.out.println("Welcome " + currUser.getUsername() + " !");
        boolean flag = true;
        while (flag){
            System.out.println(getString("home.function"));
            System.out.println(getString("info.select"));
            String choice = input.nextLine();
            switch (choice){
                case "1":  //1、查询所有订单
                    findList();
                    flag = false;
                    break;
                case "2":  //2、查找订单
                    findOrderById();
                    flag = false;
                    break;
                case "3":  // 3、购买商品
                    buyProducts();
                    flag = false;
                    break;
                case "0":  // 0、退出
                    flag = false;
                    System.exit(0);
                default:
                    System.out.println(getString("input.error"));

            }
        }
    }

    private void buyProducts() {
    }

    private void findOrderById() {
    }

    private void findList() {
    }

    private void showProducts() {
        ClothesService clothesService = new ClothesServiceImpl();
        List<Clothes> list = clothesService.list();
        ConsoleTabler t = new ConsoleTabler(8, true);
        t.appendRow();
        t.appendColum("id")
                .appendColum("brand")
                .appendColum("style")
                .appendColum("color")
                .appendColum("size")
                .appendColum("num")
                .appendColum("price")
                .appendColum("description");
        for (Clothes clothes : list){
            t.appendRow();
            t.appendColum(clothes.getId())
                    .appendColum(clothes.getBrand())
                    .appendColum(clothes.getStyle())
                    .appendColum(clothes.getColor())
                    .appendColum(clothes.getSize())
                    .appendColum(clothes.getNum())
                    .appendColum(clothes.getPrice())
                    .appendColum(clothes.getDescription());
        }

        System.out.println(t.toString());
    }
}
