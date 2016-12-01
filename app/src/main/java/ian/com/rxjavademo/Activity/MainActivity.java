package ian.com.rxjavademo.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import ian.com.rxjavademo.Fragment.NewsFragment;
import ian.com.rxjavademo.R;
import ian.com.rxjavademo.Utils.IActivity;
import ian.com.rxjavademo.Utils.IFragment;

public class MainActivity extends IActivity {
    private IFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NewsFragment newsFragment = new NewsFragment();
        mFragment = newsFragment;
        changeView(newsFragment);
    }

    public void changeView(Fragment f) {
        String TAG = f.getClass().getName();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.frameLayout, f, TAG);
        ft.addToBackStack(TAG);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() == 1) {
            finish();
        } else {
            super.onBackPressed();
        }
    }
}
