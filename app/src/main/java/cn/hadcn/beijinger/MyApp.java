package cn.hadcn.beijinger;

import android.app.Application;

import com.flurry.android.FlurryAgent;

/**
 *
 * Created by chris on 9/8/16.
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FlurryAgent.setLogEnabled(false);
        FlurryAgent.init(this, "C77CKV3JKHCCCZRJWZK6");
    }
}
