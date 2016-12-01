package ian.com.rxjavademo;

import android.app.Application;


public class NewsApplication extends Application {
    private static final String TAG_SPORT = "tiyu";
    private static final String TAG_SOCIETY = "shehui";
    private static final String TAG_INTERNATION = "guoji";
    private static final String TAG_ENTARTAINMENT = "yule";
    private static final String TAG_MILITARY = "junshi";
    private static final String TAG_TECHNOLOGY = "keji";
    private static final String TAG_FINANCE = "caijing";
    private static final String TAG_FASHION = "shishang";

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static String getTagSport() {
        return TAG_SPORT;
    }

    public static String getTagSociety() {
        return TAG_SOCIETY;
    }

    public static String getTagInternation() {
        return TAG_INTERNATION;
    }

    public static String getTagEntartainment() {
        return TAG_ENTARTAINMENT;
    }

    public static String getTagMilitary() {
        return TAG_MILITARY;
    }

    public static String getTagTechnology() {
        return TAG_TECHNOLOGY;
    }

    public static String getTagFinance() {
        return TAG_FINANCE;
    }

    public static String getTagFashion() {
        return TAG_FASHION;
    }
}
