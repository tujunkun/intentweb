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
![image](https://github.com/tujunkun/intentweb/blob/master/b1.png)
![image](https://github.com/tujunkun/intentweb/blob/master/b2.png)
