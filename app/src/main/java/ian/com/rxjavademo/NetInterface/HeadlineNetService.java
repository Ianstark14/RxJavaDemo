package ian.com.rxjavademo.NetInterface;

import ian.com.rxjavademo.Bean.RespondBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface HeadlineNetService {
    @GET("toutiao/index")
    Observable<RespondBean> getHeadlinebyRx(@Query("type") String type, @Query("key") String key);

    Call<RespondBean> getHeadline(@Query("type") String type, @Query("key") String key);
}
