package ian.com.rxjavademo.Model;

import java.util.List;

import ian.com.rxjavademo.Bean.NewsBean;
import ian.com.rxjavademo.Bean.RespondBean;
import ian.com.rxjavademo.NetInterface.HeadlineNetService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class NewsModelImpl implements INewsModel {
    private String BASE_URL = "http://v.juhe.cn/";
    private String KEY = "c661a7afff3498b35d6661cf1941ea3b";

    @Override
    public void loadNewsByRxJava(String type, final OnLoadedListener listener) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HeadlineNetService.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HeadlineNetService netService = retrofit.create(HeadlineNetService.class);
        netService.getHeadlinebyRx(type, HeadlineNetService.KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RespondBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onFailure("Failure to get new list");
                    }

                    @Override
                    public void onNext(RespondBean respondBean) {
                        if (respondBean != null && respondBean.getResult() != null) {
                            List<NewsBean> list = respondBean.getResult().getData();
                            if (list != null && list.size() != 0) {
                                listener.onSuccess(list);
                            } else {
                                listener.onFailure("Failure to get new list");
                            }
                        } else {
                            listener.onFailure("Failure to get new list");
                        }
                    }
                });

    }

    @Override
    public void loadNews(String type, final OnLoadedListener listener) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HeadlineNetService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HeadlineNetService netService = retrofit.create(HeadlineNetService.class);
        netService.getHeadline(type, HeadlineNetService.KEY).enqueue(new Callback<RespondBean>() {
            @Override
            public void onResponse(Call<RespondBean> call, Response<RespondBean> response) {
                if (response.body() != null && response.body().getResult() != null) {
                    List<NewsBean> list = response.body().getResult().getData();
                    if (list != null && list.size() != 0) {
                        listener.onSuccess(list);
                    } else {
                        listener.onFailure("Failure to get new list");
                    }
                } else {
                    listener.onFailure("Failure to get new list");
                }
            }

            @Override
            public void onFailure(Call<RespondBean> call, Throwable t) {
                listener.onFailure("Failure to get new list");
            }
        });
    }

    public interface OnLoadedListener {
        void onSuccess(List<NewsBean> newsList);

        void onFailure(String errorMsg);
    }

}
