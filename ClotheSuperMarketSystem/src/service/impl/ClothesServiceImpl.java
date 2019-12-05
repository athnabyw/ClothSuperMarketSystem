package service.impl;

import bean.Clothes;
import service.ClothesService;
import utils.ClothesIO;
import utils.ProductsXMLUtils;

import java.util.List;

/**
 * Description：ClothesService实现类
 * Author: 百里凌
 * Date: Created in 2019/11/26 下午 9:09
 * Version: 0.0.1
 * Modified By:
 */
public class ClothesServiceImpl implements ClothesService {

    private ClothesIO clothesIO = new ClothesIO();
    //获得所有Clothes （list）
    @Override
    public List<Clothes>  list() {
        return clothesIO.list();
    }

    //根据id查找一种衣服（Clothes）的信息
    @Override
    public Clothes findById(String cid) {
        return clothesIO.findById(cid);
    }
}
