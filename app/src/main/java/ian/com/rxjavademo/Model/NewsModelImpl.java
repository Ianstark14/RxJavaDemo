package ian.com.rxjavademo.Model;

import java.util.List;

import ian.com.rxjavademo.Bean.NewsBean;
import ian.com.rxjavademo.Bean.RespondBean;
import ian.com.rxjavademo.NetInterface.HeadlineNetService;
import ian.com.rxjavademo.Utils.LogUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class NewsModelImpl implements INewsModel {
    private String BASE_URL = "http://v.juhe.cn/";
    private String KEY = "c661a7afff3498b35d6661cf1941ea3b";

    @Override
    public void loadNews(String type, final OnLoadedListener listener) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        HeadlineNetService netService = retrofit.create(HeadlineNetService.class);
        Call<RespondBean> call = netService.getHeadline(type, KEY);
        call.enqueue(new Callback<RespondBean>() {
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