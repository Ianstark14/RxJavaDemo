package ian.com.rxjavademo.View;

import java.util.List;

import ian.com.rxjavademo.Bean.NewsBean;

public interface INewsView {
    void addNews(List<NewsBean> newsList);
}
