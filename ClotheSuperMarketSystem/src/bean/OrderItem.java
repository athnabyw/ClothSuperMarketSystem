package bean;

import java.io.Serializable;

/**
 * Description：订单明细类
 * Author: 百里凌
 * Date: Created in 2019/11/21 下午 9:22
 * Version: 0.0.1
 * Modified By:
 */
public class OrderItem implements Serializable {
    private int itemId;
    private Clothes clothes; //商品
    private int shoppingNum;
    private float sum;  //购买金额

    public OrderItem() {
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public int getShoppingNum() {
        return shoppingNum;
    }

    public void setShoppingNum(int shoppingNum) {
        this.shoppingNum = shoppingNum;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }
}
