package ian.com.rxjavademo.Fragment;

import android.os.Bundle;
import android.webkit.WebView;

import butterknife.BindView;
import ian.com.rxjavademo.R;
import ian.com.rxjavademo.Utils.IFragment;


public class WebFragment extends IFragment {
    private String mUrl;
    @BindView(R.id.wv_news)
    WebView mWebView;

    @Override
    public int getLayout() {
        return R.layout.fragment_web;
    }

    @Override
    public void initData(Bundle args) {
        mUrl = args.getString("url");
    }

    @Override
    public void bindViews() {
        mWebView.loadUrl(mUrl);
        mWebView.setFindListener(new WebView.FindListener() {
            @Override
            public void onFindResultReceived(int activeMatchOrdinal, int numberOfMatches, boolean isDoneCounting) {

            }
        });
    }
}
