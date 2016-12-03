package ian.com.rxjavademo.View;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import ian.com.rxjavademo.NewsApplication;
import ian.com.rxjavademo.R;

public class MorePop extends PopupWindow {
    private View mView;
    Button mBtn_top;
    Button mBtn_entertainment;
    Button mBtn_fashion;
    Button mBtn_finance;
    Button mBtn_international;
    Button mBtn_military;
    Button mBtn_society;
    Button mBtn_sport;
    private onPopItemClickListener mListener;


    public MorePop(Activity context) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = layoutInflater.inflate(R.layout.pop_layout, null);
        setContentView(mView);
        setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setFocusable(true);
        setTouchable(true);
        setBackgroundDrawable(new ColorDrawable());
        setAnimationStyle(R.style.pop_animation);
        bindButton();
    }

    public void showPopupWindow(View parent) {
        if (!this.isShowing()) {
            this.showAsDropDown(parent, parent.getLayoutParams().width / 2, 24);
        } else {
            this.dismiss();
        }
    }

    private void bindButton() {
        mBtn_entertainment = (Button) mView.findViewById(R.id.btn_entertainment);
        mBtn_fashion = (Button) mView.findViewById(R.id.btn_fashion);
        mBtn_finance = (Button) mView.findViewById(R.id.btn_finance);
        mBtn_international = (Button) mView.findViewById(R.id.btn_international);
        mBtn_military = (Button) mView.findViewById(R.id.btn_military);
        mBtn_society = (Button) mView.findViewById(R.id.btn_society);
        mBtn_sport = (Button) mView.findViewById(R.id.btn_sport);
        mBtn_top = (Button) mView.findViewById(R.id.btn_top);
        mBtn_entertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(NewsApplication.getTagEntertainment());
            }
        });
        mBtn_fashion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(NewsApplication.getTagFashion());
            }
        });
        mBtn_finance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(NewsApplication.getTagFinance());
            }
        });
        mBtn_society.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(NewsApplication.getTagSociety());
            }
        });
        mBtn_military.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(NewsApplication.getTagMilitary());
            }
        });
        mBtn_international.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(NewsApplication.getTagInternational());
            }
        });
        mBtn_sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(NewsApplication.getTagSport());
            }
        });
        mBtn_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(NewsApplication.getTagTop());
            }
        });
    }

    public interface onPopItemClickListener {
        void onItemClick(String tag);
    }

    public void setOnPopClickListener(onPopItemClickListener listener) {
        this.mListener = listener;
    }
}
