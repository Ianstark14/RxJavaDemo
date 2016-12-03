package ian.com.rxjavademo.NetInterface;

import ian.com.rxjavademo.Bean.RespondBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface HeadlineNetService {
    String BASE_URL = "http://v.juhe.cn/";
    String KEY = "c661a7afff3498b35d6661cf1941ea3b";

    @GET("toutiao/index")
    Observable<RespondBean> getHeadlinebyRx(@Query("type") String type, @Query("key") String key);

    Call<RespondBean> getHeadline(@Query("type") String type, @Query("key") String key);
}
