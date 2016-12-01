package ian.com.rxjavademo.Utils;

import android.app.ProgressDialog;
import android.content.Context;


public class IAProgress extends BaseContextObject {
    private ProgressDialog myDialog;

    public IAProgress(Context context) {
        super(context);
    }

    public void show(String msg, boolean cancelable) {
        close();
        if (myDialog == null) {
            myDialog = new ProgressDialog(getContext());
            myDialog.getWindow().setFlags(IActivity.FLAG_HOMEKEY_DISPATCHED, IActivity.FLAG_HOMEKEY_DISPATCHED);
        }
        myDialog.setMessage(msg);
        myDialog.setCancelable(cancelable);
        myDialog.show();
    }

    public void close() {
        if (myDialog != null && myDialog.isShowing()) {
            myDialog.dismiss();
        }
    }
}
