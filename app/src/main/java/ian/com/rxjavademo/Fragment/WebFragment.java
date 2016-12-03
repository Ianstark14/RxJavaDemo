package ian.com.rxjavademo.Fragment;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

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
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                showProcess("正在跳转", false);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                closeProcess();
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                super.onReceivedSslError(view, handler, error);
                toast(error.toString());
            }
        });
    }
}
