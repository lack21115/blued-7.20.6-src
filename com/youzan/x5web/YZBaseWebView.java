package com.youzan.x5web;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.youzan.jsbridge.JsBridgeManager;
import com.youzan.spiderman.cache.CacheHandler;
import com.youzan.spiderman.cache.SpiderCacheCallback;
import com.youzan.spiderman.cache.SpiderMan;
import com.youzan.x5web.event.PreviewImageSubscriber;
import java.io.File;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/x5web/YZBaseWebView.class */
public class YZBaseWebView extends WebView {
    private static final String TAG = "YZBaseWebView";
    private CacheHandler cacheHandler;
    private WebChromeClientWrapper mChromeClient;
    private JsBridgeManager mJsBridgeManager;
    private JsInjecter mJsInjecter;
    private WebViewClientWrapper mWebViewClient;

    public YZBaseWebView(Context context) {
        super(context);
        init(context);
    }

    public YZBaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public YZBaseWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    @Deprecated
    public YZBaseWebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i, z);
        init(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callCacheStatistic(String str, String str2, Map<String, String> map) {
        try {
            SpiderCacheCallback spiderCacheCallback = SpiderMan.getInstance().getSpiderCacheCallback();
            if (spiderCacheCallback != null) {
                spiderCacheCallback.onStatistic(str, str2, map);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private String getWebViewCachePath() {
        File file = new File(getContext().getApplicationContext().getCacheDir(), "zan_webview");
        if (file.exists()) {
            if (!file.isDirectory()) {
                Log.e(TAG, "创建WebView缓存目录失败，文件名已被占用", new Throwable());
            }
        } else if (!file.mkdir()) {
            Log.e(TAG, "创建WebView缓存目录失败", new Throwable());
        }
        return file.getAbsolutePath();
    }

    private void init(Context context) {
        JsInjecter jsInjecter = new JsInjecter(this);
        this.mJsInjecter = jsInjecter;
        this.mJsBridgeManager = new JsBridgeManager(jsInjecter.getDispatcher(), this.mJsInjecter.getDispatcherCompat());
        initSettings(context);
        this.mChromeClient = new WebChromeClientWrapper(this.mJsInjecter);
        this.mWebViewClient = new WebViewClientWrapper(this.mJsInjecter);
        super.setWebChromeClient(this.mChromeClient);
        super.setWebViewClient(this.mWebViewClient);
        injectCache();
        this.mJsBridgeManager.subscribe(new PreviewImageSubscriber());
    }

    private void initSettings(Context context) {
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAppCachePath(getWebViewCachePath());
        settings.setAppCacheEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setCacheMode(-1);
        settings.setUserAgentString(settings.getUserAgentString() + " youzan_container_android/" + BuildConfig.VERSION_NAME);
        if (Build.VERSION.SDK_INT >= 19 && (context.getApplicationInfo().flags & 2) != 0) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setGeolocationEnabled(true);
        settings.setGeolocationDatabasePath(context.getFilesDir().getPath());
        settings.setBuiltInZoomControls(false);
        settings.setTextZoom(100);
    }

    private void injectCache() {
        CacheHandler cacheHandler = new CacheHandler(getContext(), new CacheHandler.HandlerCallback() { // from class: com.youzan.x5web.YZBaseWebView.1
            @Override // com.youzan.spiderman.cache.CacheHandler.HandlerCallback
            public void onCacheStatistic(Map<String, String> map) {
                YZBaseWebView.this.callCacheStatistic("yz_webview_load_request", "WebView 加载时间统计", map);
            }

            @Override // com.youzan.spiderman.cache.CacheHandler.HandlerCallback
            public void onHtmlStatistic(Map<String, String> map) {
                YZBaseWebView.this.callCacheStatistic("yz_webview_html_prefetch", "html prefetch统计", map);
            }
        });
        this.cacheHandler = cacheHandler;
        this.mWebViewClient.setCacheHandler(cacheHandler);
        this.mChromeClient.setCacheHandler(this.cacheHandler);
        SpiderMan.getInstance().initLru();
    }

    @Override // com.tencent.smtt.sdk.WebView
    public void destroy() {
        super.destroy();
        this.cacheHandler.destory();
    }

    public JsBridgeManager getJsBridgeManager() {
        return this.mJsBridgeManager;
    }

    @Override // com.tencent.smtt.sdk.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        if (webChromeClient instanceof WebChromeClientWrapper) {
            super.setWebChromeClient(webChromeClient);
        } else {
            this.mChromeClient.setDelegate(webChromeClient);
        }
    }

    @Override // com.tencent.smtt.sdk.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        if (webViewClient instanceof WebViewClientWrapper) {
            super.setWebViewClient(webViewClient);
        } else {
            this.mWebViewClient.setDelegate(webViewClient);
        }
    }
}
