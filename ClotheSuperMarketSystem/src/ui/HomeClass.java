package ui;

import bean.Clothes;
import bean.Order;
import bean.OrderItem;

import service.ClothesService;
import service.OrderService;
import service.impl.ClothesServiceImpl;
import service.impl.OrderServiceImpl;
import utils.BussinessException;
import utils.ConsoleTabler;
import utils.DateUtil;


import java.util.Date;
import java.util.List;

/**
 * Description：主界面
 * Author: 百里凌
 * Date: Created in 2019/11/26 下午 8:48
 * Version: 0.0.1
 * Modified By:
 */
public class HomeClass extends BaseClass {

    private OrderService orderService = new OrderServiceImpl();
    private ClothesService clothesService = new ClothesServiceImpl();

    public void show() {
        showProducts(); //打印有内容的列表
        System.out.println("Welcome " + currUser.getUsername() + " !");
        boolean flag = true;
        while (flag) {
            System.out.println(getString("home.function"));
            System.out.println(getString("info.select"));
            String choice = input.nextLine();
            switch (choice) {
                case "1":  //1、查询所有订单
                    findList();
                    flag = false;
                    break;
                case "2":  //2、查找订单
                    findOrderById();
                    flag = false;
                    break;
                case "3":  // 3、购买商品
                    try {
                        buyProducts();
                        flag = false;
                    }catch (BussinessException e){
                        println(e.getMessage());
                    }
                    break;
                case "0":  // 0、退出
                    flag = false;
                    System.exit(0);
                default:
                    System.out.println(getString("input.error"));

            }
        }
    }

    /**
     * @Description: 购买商品的方法
     * @Date 下午 10:14 2019/12/5
     **/
    private void buyProducts() {
        int count = 1;
        boolean flag = true;
        Order order = new Order();  //大订单
        float sum = 0.0f;

        while (flag) {
            print(getString("product.input.id"));  //输入要购买的商品id
            String id = input.nextLine();
            print(getString("product.input.shoppingNum"));  //输入数量
            String shoppingNum = input.nextLine();
            Clothes clothes = clothesService.findById(id);

            //判断用户输入的购买数量是否大于库存数
            int num_store = clothes.getNum();
            int num_buy = Integer.parseInt(shoppingNum);
            if (num_buy > num_store) {   //异常
                throw new BussinessException(getString("product.num.error"));
            }

            //创建一个订单明细，并设置各种属性
            OrderItem orderItem = new OrderItem();
            orderItem.setShoppingNum(num_buy);
            orderItem.setClothes(clothes);
            orderItem.setSum(clothes.getPrice() * num_buy);
            orderItem.setItemId(count++);

            //将每个订单明细加入到订单中，并设置各种属性
            sum += orderItem.getSum();
            order.getOrderItemList().add(orderItem);

            //是否继续购买
            println(getString("product.buy.continue"));
            String choice = input.nextLine();
            switch (choice) {
                case "1":
                    break;
                case "2":
                    flag = false;
                    break;
                default:
                    break;
            }

        }
        //订单设置各种属性
        order.setCreateDate(DateUtil.toDate(new Date()));
        order.setUserId(currUser.getId());
        order.setSum(sum); //总金额
        order.setOrderId(orderService.list().size() + 1);
        orderService.buyProduct(order);

    }

    private void findOrderById() {

    }

    private void findList() {

    }

    private void showProducts() {
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
        for (Clothes clothes : list) {
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
