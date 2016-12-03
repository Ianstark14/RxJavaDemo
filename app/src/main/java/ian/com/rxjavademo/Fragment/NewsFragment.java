package ian.com.rxjavademo.Fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.List;

import butterknife.BindView;
import ian.com.rxjavademo.Activity.MainActivity;
import ian.com.rxjavademo.Adapter.NewsAdapter;
import ian.com.rxjavademo.Bean.NewsBean;
import ian.com.rxjavademo.NewsApplication;
import ian.com.rxjavademo.Presenter.NewsPresenterImpl;
import ian.com.rxjavademo.R;
import ian.com.rxjavademo.Utils.IFragment;
import ian.com.rxjavademo.View.INewsView;
import ian.com.rxjavademo.View.MorePop;

public class NewsFragment extends IFragment implements INewsView {
    @BindView(R.id.sr_news)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.rv_news)
    RecyclerView mRecyclerView;
    @BindView(R.id.iv_more)
    ImageView mIv_more;
    @BindView(R.id.rl_title)
    RelativeLayout mRl_title;
    private MorePop mPop;
    private NewsAdapter mAdapter;
    private NewsPresenterImpl mPresenter;
    private String mTag = NewsApplication.getTagTop();

    @Override
    public int getLayout() {
        return R.layout.fragment_news;
    }

    @Override
    public void initData(Bundle args) {

    }

    @Override
    public void bindViews() {
        mPop = new MorePop(getActivity());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        mSwipeRefreshLayout.setProgressBackgroundColorSchemeResource(R.color.normal_green);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.bg_normal);
        mPresenter = new NewsPresenterImpl(this);
        mPresenter.getNews(mTag);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getNews(mTag);
            }
        });
        mIv_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPop.setOnPopClickListener(new MorePop.onPopItemClickListener() {
                    @Override
                    public void onItemClick(String tag) {
                        mPresenter.getNews(tag);
                        mTag = tag;
                        mPop.dismiss();
                    }
                });
                mPop.showPopupWindow(mIv_more);
            }
        });

    }

    @Override
    public void addNews(List<NewsBean> newsList) {
        if (mAdapter == null) {
            mAdapter = new NewsAdapter(this.getContext(), newsList);
            mAdapter.setOnItemClickListener(new NewsAdapter.onItemClickListener() {
                @Override
                public void onItemClick(String url) {
                    Bundle bundle = new Bundle();
                    bundle.putString("url", url);
                    WebFragment webFragment = new WebFragment();
                    webFragment.setArguments(bundle);
                    ((MainActivity) getActivity()).changeView(webFragment);
                }
            });
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setList(newsList);
            stopFresh();
        }
    }

    public void stopFresh() {
        mSwipeRefreshLayout.setRefreshing(false);
    }
}
