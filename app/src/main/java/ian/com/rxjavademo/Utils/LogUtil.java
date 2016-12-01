package ian.com.rxjavademo.Utils;


import android.util.Log;

public class LogUtil {
    private static final String TAG = "IanLog";

    public static void d(String logInfo) {
        Log.d(TAG, logInfo);
    }

    public static void e(String logInfo) {
        Log.e(TAG, logInfo);
    }
}
