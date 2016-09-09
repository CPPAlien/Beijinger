package cn.hadcn.beijinger;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private final static String BEIJINGER_URL = "http://www.thebeijinger.com/";
    private WebView mWvCtn;
    private RelativeLayout mRlWelcome;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWvCtn = (WebView)findViewById(R.id.main_content);
        mRlWelcome = (RelativeLayout)findViewById(R.id.main_welcome);

        mWvCtn.getSettings().setJavaScriptEnabled(true);
        mWvCtn.loadUrl(BEIJINGER_URL);

        mWvCtn.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });

        mWvCtn.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if ( newProgress >= 100 ) {
                    mRlWelcome.setVisibility(View.GONE);
                }
                super.onProgressChanged(view, newProgress);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWvCtn.canGoBack()) {
            mWvCtn.goBack();// 返回前一个页面
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
