package ian.com.rxjavademo.Utils;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public abstract class IFragment extends Fragment implements IToast {

    private View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initData(getArguments());
        mRootView = inflater.inflate(getLayout(), null);
        ButterKnife.bind(this, mRootView);
        mRootView.setClickable(true);
        bindViews();
        return mRootView;
    }

    @Override
    public void toast(String msg) {
        ((IToast) getActivity()).toast(msg);
    }

    @Override
    public void toast(String msg, PromptState state) {
        ((IToast) getActivity()).toast(msg, state);
    }


    public void showProcess(String msg, boolean cancelable) {
        ((IProgress) getActivity()).showProcess(msg, cancelable);

    }

    public void closeProcess() {
        ((IProgress) getActivity()).closeProcess();
    }

    /**
     * fragment layout设置
     */
    @LayoutRes
    public abstract int getLayout();

    /**
     * 所有Fragment 启动传参数都使用该方法
     *
     * @param args 保存的参数
     */
    public abstract void initData(Bundle args);

    /**
     * 绑定View此时的data已经初始化完成
     */
    public abstract void bindViews();

    public View getRootView() {
        return mRootView;
    }
}
