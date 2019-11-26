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
