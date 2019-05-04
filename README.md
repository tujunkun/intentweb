```

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent);
        webView=(WebView)findViewById(R.id.webView);
        Intent intent=this.getIntent();
        String url=intent.getData().toString();
        webView.loadUrl(url);

        webView.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;//设为true 否则调用系统浏览器
            }

        });
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);//加载页面优先使用缓存加载
    }
}
```
```
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.viewwebactivity">
    <uses-permission android:name="android.permission.INTERNET"></uses-permission>

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme"
        android:usesCleartextTraffic="true">
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
            <intent-filter>
                <action android:name="android.intent.action.VIEW" />
                <category android:name="android.intent.category.DEFAULT" />
                <category android:name="android.intent.category.BROWSABLE"/>
                <category android:name="android.intent.category.MY_CATEGORY" />
                <data android:scheme="https" />
                <data android:scheme="http" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```
![image](https://github.com/tujunkun/intentweb/blob/master/b1.png)
![image](https://github.com/tujunkun/intentweb/blob/master/b2.png)
