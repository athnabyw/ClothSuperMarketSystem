package utils;

import bean.Clothes;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;
import test.XMLtest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Description：解析products(XML) 生成 clothe 的 list  或者反过来
 * Author: 百里凌
 * Date: Created in 2019/11/26 下午 7:21
 * Version: 0.0.1
 * Modified By:
 */
public class ProductsXMLUtils {

    /**
     * @Description: 解析products(XML) 生成 clothe 的 list
     * @Date 下午 8:03 2019/11/26
     **/
    public static List<Clothes> paraserProductFromXML(){
         List<Clothes> products = new ArrayList<>();
        XStream xStream = new XStream(new Xpp3Driver());
        XStream.setupDefaultSecurity(xStream);    //设置默认xstream安全级 ，不然会有警告！
        xStream.allowTypesByWildcard(new String[] {    //设置允许访问的类
                "bean.Clothes"
        });
        xStream.alias("list", products.getClass());
        xStream.alias("clothes", Clothes.class);
        xStream.useAttributeFor(Clothes.class, "id");

        BufferedInputStream inputStream = null;
        try {
            inputStream = new BufferedInputStream(
                    new FileInputStream("src/res/products.xml"));
            products = (List<Clothes>) xStream.fromXML(inputStream);
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }

    /**
     * @Description:  clothe 的 list 写成 XML文件
     * @Date 下午 8:04 2019/11/26
     **/
    public static void paraserProductsToXML(List<Clothes> products){
        XStream xStream = new XStream(new Xpp3Driver());
        XStream.setupDefaultSecurity(xStream);   //设置默认xstream安全级 ，不然会有警告！
        xStream.allowTypesByWildcard(new String[] {  //设置允许访问的类
                        "bean.Clothes"
                });
        xStream.alias("list", products.getClass());
        xStream.alias("clothes", Clothes.class);
        xStream.useAttributeFor(Clothes.class, "id");

        try {
            BufferedOutputStream outputStream = new BufferedOutputStream(
                    new FileOutputStream("src/res/products.xml"));
            outputStream.write("<?xml version=\"1.0\" encoding=\"utf-8\" ?>".getBytes());
            //头句Xstream不会写，需要自己写
            xStream.toXML(products, outputStream);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
