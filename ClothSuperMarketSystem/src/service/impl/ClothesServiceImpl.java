package service.impl;

import bean.Clothes;
import service.ClothesService;
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
    //获得Clothes（list）
    @Override
    public List<Clothes>  list() {
        List<Clothes> clothes = ProductsXMLUtils.paraserProductFromXML();
        return clothes;
    }
}
