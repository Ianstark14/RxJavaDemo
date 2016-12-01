package ian.com.rxjavademo.Model;


public interface INewsModel {
    void loadNews(String type,NewsModelImpl.OnLoadedListener listener);
}
