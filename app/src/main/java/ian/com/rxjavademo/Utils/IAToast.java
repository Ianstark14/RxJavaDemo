package ian.com.rxjavademo.Utils;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import ian.com.rxjavademo.R;


/**
 * @author justin on 2016/04/26 14:09
 *         justin@magicare.me
 * @version V1.0
 */
public class IAToast extends BaseContextObject {

    private final Toast sToast;
    private ImageView ivIcon;
    private TextView tvContent;

    public IAToast(Context context) {
        super(context);
        sToast = new Toast(context);
        init();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.toast, null);
        sToast.setView(view);
        sToast.setGravity(Gravity.CENTER, 0, 0);
        sToast.setDuration(Toast.LENGTH_SHORT);
        tvContent = (TextView) view.findViewById(R.id.tv_content);
        ivIcon = (ImageView) view.findViewById(R.id.iv_icon);
    }

    public void show(String msg, PromptState state) {
        int icon = 0;
        if (state != null) {
            switch (state){
                case SUCCESS:
                    icon = R.drawable.ic_toast_success;
                    break;
                case ERROR:
                    icon = R.drawable.ic_toast_error;
                    break;
                case WARNING:
                    icon = R.drawable.ic_toast_warning;
                    break;
            }
        }
        if(icon == 0) {
            ivIcon.setVisibility(View.GONE);
        }else {
            ivIcon.setVisibility(View.VISIBLE);
            ivIcon.setImageResource(icon);
        }
        tvContent.setText(msg);
        sToast.show();
    }

    public void close() {
        sToast.cancel();
    }
}
