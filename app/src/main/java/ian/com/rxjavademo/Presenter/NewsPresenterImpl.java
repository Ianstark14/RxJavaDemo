package ian.com.rxjavademo.Presenter;

import java.util.List;

import ian.com.rxjavademo.Bean.NewsBean;
import ian.com.rxjavademo.Fragment.NewsFragment;
import ian.com.rxjavademo.Model.NewsModelImpl;
import ian.com.rxjavademo.Utils.PromptState;


public class NewsPresenterImpl implements INewsPresenter, NewsModelImpl.OnLoadedListener {
    private NewsFragment mNewsFragment;
    private NewsModelImpl mNewsModelImpl;

    public NewsPresenterImpl(NewsFragment mNewsFragment) {
        this.mNewsFragment = mNewsFragment;
        this.mNewsModelImpl = new NewsModelImpl();
    }

    @Override
    public void getNews(String type) {
        mNewsFragment.showProcess("正在加载", false);
        mNewsModelImpl.loadNewsByRxJava(type, this);
    }

    @Override
    public void onSuccess(List<NewsBean> newsList) {
        mNewsFragment.closeProcess();
        mNewsFragment.addNews(newsList);
    }

    @Override
    public void onFailure(String errorMsg) {
        mNewsFragment.closeProcess();
        mNewsFragment.toast(errorMsg, PromptState.ERROR);
    }
}
