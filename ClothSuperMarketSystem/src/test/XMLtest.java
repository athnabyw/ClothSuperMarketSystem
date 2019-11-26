package test;

import bean.Clothes;
import org.junit.Test;
import utils.ProductsXMLUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Description：
 * Author: 百里凌
 * Date: Created in 2019/11/26 下午 8:31
 * Version: 0.0.1
 * Modified By:
 */
public class XMLtest {
    @Test
    public void test(){
        List<Clothes> clothes = ProductsXMLUtils.paraserProductFromXML();
        System.out.println(Arrays.toString(clothes.toArray()));
    }
}
