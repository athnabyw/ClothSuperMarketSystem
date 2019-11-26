package bean;

import java.io.Serializable;

/**
 * Description：商品类
 * Author: 百里凌
 * Date: Created in 2019/11/21 下午 9:06
 * Version: 0.0.1
 * Modified By:
 */
public class Clothes implements Serializable {
    private String id;
    private String brand;
    private String style;
    private String color;
    private String size;
    private int num;
    private float price;
    private String description; //商品描述

    public Clothes() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
