package ian.com.rxjavademo.Utils;

/**
 * Created by Ian on 2016/11/19.
 */

public interface IProgress {
    void showProcess(String msg,boolean cancelable);

    void closeProcess();
}
