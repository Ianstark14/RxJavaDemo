package ian.com.rxjavademo.Model;


public interface INewsModel {
    void loadNewsByRxJava(String type, NewsModelImpl.OnLoadedListener listener);
    void loadNews(String type, NewsModelImpl.OnLoadedListener listener);
}
