package utils;

/**
 * Description：判断字符串是否为空
 * Author: 百里凌
 * Date: Created in 2019/11/22 下午 9:30
 * Version: 0.0.1
 * Modified By:
 */
public class EmptyUtil {
    public static boolean isEmpty(String s) {
        if ("".equals(s) || null == s) {
            return true;
        }else {
            return false;
        }
    }
}
