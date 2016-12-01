package ian.com.rxjavademo.Adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ian.com.rxjavademo.Bean.NewsBean;
import ian.com.rxjavademo.R;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.BaseHolder> {
    private final List<NewsBean> mList;
    private Context mContext;
    private onItemClickListener mOnItemClickListener;

    public NewsAdapter(Context context, List<NewsBean> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
        holder.bindView(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setList(List<NewsBean> list) {
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
    }

    class BaseHolder extends RecyclerView.ViewHolder {
        private TextView mTv_title;
        private TextView mTv_data;
        private ImageView mIv_pic;
        private LinearLayout mLl_item;

        public BaseHolder(View itemView) {
            super(itemView);
            mIv_pic = (ImageView) itemView.findViewById(R.id.iv_pic);
            mTv_data = (TextView) itemView.findViewById(R.id.tv_data);
            mTv_title = (TextView) itemView.findViewById(R.id.tv_title);
            mLl_item = (LinearLayout) itemView.findViewById(R.id.ll_item);
        }

        public void bindView(final NewsBean newsBean) {
            mTv_title.setText(newsBean.getTitle());
            mTv_data.setText(newsBean.getDate());
            Picasso.with(mContext).load(newsBean.getThumbnail_pic_s03()).into(mIv_pic);
            mLl_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(newsBean.getUrl());
                }
            });
        }
    }

    public void setOnItemClickListener(onItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public interface onItemClickListener {
        void onItemClick(String url);
    }
}

