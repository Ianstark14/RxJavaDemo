package ian.com.rxjavademo.Utils;

import android.content.Context;


public class BaseContextObject {
    private final Context context;

    public BaseContextObject(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }
}
