package ian.com.rxjavademo.Utils;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class IActivity extends AppCompatActivity implements IToast,IProgress {

    private IAToast mToast;
    private IAProgress mProgress;
    public static final int FLAG_HOMEKEY_DISPATCHED = 0x80000000;


    public Application getMApplication(){
        return getApplication();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(FLAG_HOMEKEY_DISPATCHED, FLAG_HOMEKEY_DISPATCHED);
    }

    @Override
    public void toast(String msg){
        toast(msg,null);
    }

    @Override
    public void toast(String msg, PromptState state) {
        if(isFinishing()||isDestroyed()){
            return;
        }
        if(mToast == null){
            mToast = new IAToast(this);
        }
        mToast.show(msg,state);
    }


    @Override
    public void showProcess(String msg,boolean cancelable) {
        if(mProgress == null){
            mProgress = new IAProgress(this);
        }
        mProgress.show(msg,cancelable);
    }

    @Override
    public void closeProcess() {
        mProgress.close();
    }

    /**
     * 启动其他activity，不关闭当前Activity
     *
     * @param targetClass 目标activity
     */
    protected void changeView(Class<? extends Activity> targetClass) {
        changeView(targetClass, null, false);
    }

    /**
     * 启动其他activity
     *
     * @param targetClass 需要启动的activity
     * @param bundle      需要启动的activity
     */
    protected void changeView(Class<? extends Activity> targetClass, Bundle bundle) {
        changeView(targetClass, bundle, false);
    }

    /**
     * 启动其他activity
     *
     * @param targetClass 需要启动的activity
     * @param isFinish    需要启动的activity
     */
    protected void changeView(Class<? extends Activity> targetClass, boolean isFinish) {
        changeView(targetClass, null, isFinish);
    }

    /**
     * 启动其他activity
     *
     * @param targetClass 需要启动的activity
     * @param bundle      所携带的参数
     * @param isFinish    是否关闭当前activity
     */
    protected void changeView(Class<? extends Activity> targetClass, Bundle bundle, boolean isFinish) {
        Intent intent = new Intent(this, targetClass);
        if (null != bundle) {
            intent.putExtra("bundle", bundle);
        }
        startActivity(intent);
        if (isFinish) {
            this.finish();
        }
    }
}
