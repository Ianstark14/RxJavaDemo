package ian.com.rxjavademo.Utils;

/**
 * @author justin on 2016/04/26 13:56
 *         justin@magicare.me
 * @version V1.0
 */
public interface IToast {
    void toast(String msg);
    void toast(String msg, PromptState state);
}
