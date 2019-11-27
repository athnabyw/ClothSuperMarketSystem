package service;

import bean.Clothes;

import java.util.List;

/**
 * Description：Products （list） 业务接口
 * Author: 百里凌
 * Date: Created in 2019/11/26 下午 9:06
 * Version: 0.0.1
 * Modified By:
 */
public interface ClothesService {
    //以下是所有涉及Clothes（clothe的list） 的方法（功能）

    public List<Clothes> list();  //获得list（clothe的list）
}
