package utils;

/**
 * Description：业务的异常
 * Author: 百里凌
 * Date: Created in 2019/11/22 下午 7:49
 * Version: 0.0.1
 * Modified By:
 */
public class BussinessException extends RuntimeException {
    public BussinessException() {

    }

    public BussinessException(String message) {
        super(ui.BaseClass.getString(message));
    }
}
