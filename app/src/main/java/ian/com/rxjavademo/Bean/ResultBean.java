package ian.com.rxjavademo.Bean;


import java.util.List;

public class ResultBean extends BaseBean {
    private int stat;
    private List<NewsBean> data;

    public int getStat() {
        return stat;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }

    public List<NewsBean> getData() {
        return data;
    }

    public void setData(List<NewsBean> newsList) {
        this.data = newsList;
    }
}
