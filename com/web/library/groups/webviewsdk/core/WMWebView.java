package com.web.library.groups.webviewsdk.core;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.applog.tracker.Tracker;
import com.bytedance.applog.util.WebViewJsUtil;
import com.google.common.net.HttpHeaders;
import com.web.library.groups.webviewsdk.c.c;
import com.web.library.groups.webviewsdk.c.d;
import com.web.library.groups.webviewsdk.core.WebViewSdk;
import com.youzan.androidsdk.tool.WebParameter;
import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/web/library/groups/webviewsdk/core/WMWebView.class */
public class WMWebView extends WebView {

    /* renamed from: a  reason: collision with root package name */
    private Context f27463a;
    private com.web.library.groups.webviewsdk.core.a b;

    /* renamed from: c  reason: collision with root package name */
    private ValueCallback<Uri> f27464c;
    private ValueCallback<Uri[]> d;
    private final int e;
    private String f;
    private boolean g;
    private final String[] h;
    private WMWebStateClient stateClient;

    /* loaded from: source-8829756-dex2jar.jar:com/web/library/groups/webviewsdk/core/WMWebView$WMWebStateClient.class */
    public interface WMWebStateClient {
        void onProgressChanged(WebView webView, int i);

        void onReceivedTitle(WebView webView, String str);

        void pageFinished(WebView webView, String str);

        void pageStarted(WebView webView, String str, Bitmap bitmap);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/web/library/groups/webviewsdk/core/WMWebView$a.class */
    public class a extends WebChromeClient {
        public a() {
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            Log.e("wmwebview", "[" + consoleMessage.messageLevel() + "] " + consoleMessage.message() + "(" + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber() + ")");
            return super.onConsoleMessage(consoleMessage);
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsHidePrompt() {
            super.onGeolocationPermissionsHidePrompt();
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            callback.invoke(str, true, true);
            super.onGeolocationPermissionsShowPrompt(str, callback);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            Tracker.onProgressChanged(this, webView, i);
            super.onProgressChanged(webView, i);
            if (WMWebView.this.stateClient != null) {
                WMWebView.this.stateClient.onProgressChanged(webView, i);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (WMWebView.this.stateClient != null) {
                WMWebView.this.stateClient.onReceivedTitle(webView, str);
            }
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            if (WMWebView.this.f27463a instanceof Activity) {
                WMWebView.this.d = valueCallback;
                try {
                    ((Activity) WMWebView.this.f27463a).startActivityForResult(fileChooserParams.createIntent(), 10011);
                    return true;
                } catch (ActivityNotFoundException e) {
                    WMWebView.this.d = null;
                    return false;
                }
            }
            return false;
        }

        public final void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            if (WMWebView.this.f27463a instanceof Activity) {
                WMWebView.this.f27464c = valueCallback;
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                ((Activity) WMWebView.this.f27463a).startActivityForResult(Intent.createChooser(intent, "File Chooser"), 10011);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/web/library/groups/webviewsdk/core/WMWebView$b.class */
    public class b extends com.web.library.groups.webviewsdk.b.a {
        private final Context b;

        public b(Context context) {
            this.b = context;
        }

        private boolean c(WebView webView, String str) {
            Log.e("ek===>processUrl ", str);
            if (d.a(str)) {
                return false;
            }
            String str2 = WebViewSdk.getInstance().getScheme() + "://";
            if (str.startsWith("https://wx.tenpay.com/") && !str.contains("wmreqmodify=1")) {
                String[] split = str.split("\\?");
                String str3 = (split == null || split.length <= 0) ? "" : split[0];
                Map<String, String> a2 = com.web.library.groups.webviewsdk.c.a.a(str, false);
                String str4 = a2.get("redirect_url");
                if (a2 == null) {
                    return true;
                }
                try {
                    WMWebView.this.f = URLDecoder.decode(str4, "utf-8");
                    a2.put("redirect_url", URLEncoder.encode(str2 + str4, "utf-8"));
                    a2.put("wmreqmodify", "1");
                    String a3 = com.web.library.groups.webviewsdk.c.a.a(a2);
                    if (!d.a(a3)) {
                        str = str3 + "?" + a3;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(HttpHeaders.REFERER, URLDecoder.decode(str4, "utf-8"));
                    Tracker.loadUrl(webView, str, hashMap);
                    return true;
                } catch (Exception e) {
                    e = e;
                }
            } else if (str.startsWith("weixin://")) {
                WMWebView.this.g = false;
                try {
                    Intent parseUri = Intent.parseUri(str.toString(), 1);
                    parseUri.setFlags(536870912);
                    parseUri.addCategory(Intent.CATEGORY_BROWSABLE);
                    parseUri.setComponent(null);
                    parseUri.setSelector(null);
                    if (this.b instanceof Activity) {
                        this.b.startActivity(parseUri);
                        return true;
                    }
                    return true;
                } catch (Exception e2) {
                    e = e2;
                }
            } else if (str.startsWith("alipays://platformapi/startApp")) {
                try {
                    Intent parseUri2 = Intent.parseUri(str, 1);
                    parseUri2.addCategory(Intent.CATEGORY_BROWSABLE);
                    parseUri2.setComponent(null);
                    if (this.b instanceof Activity) {
                        this.b.startActivity(parseUri2);
                        return false;
                    }
                    return false;
                } catch (Exception e3) {
                    return false;
                }
            } else if (str.startsWith(WebViewSdk.getInstance().getScheme())) {
                return true;
            } else {
                if (!str.startsWith("https://www.weimob.com")) {
                    if (str.startsWith(com.tencent.smtt.sdk.WebView.SCHEME_TEL)) {
                        if (WMWebView.this.b != null) {
                            WMWebView.this.b.callPhone(str);
                            return true;
                        }
                        return true;
                    }
                    return false;
                }
                Map<String, String> a4 = com.web.library.groups.webviewsdk.c.a.a(str, false);
                if (a4 == null) {
                    return false;
                }
                String str5 = a4.get("action");
                if (d.a(str5) || !str5.equalsIgnoreCase("weimobsdk")) {
                    return false;
                }
                try {
                    WebViewSdk.getInstance().setWebUrl(URLDecoder.decode(a4.get("redirect_url"), "utf-8"));
                    WebViewSdk.getInstance().authExpired();
                    return true;
                } catch (Exception e4) {
                    e = e4;
                }
            }
            WMWebView.this.f = "";
            e.printStackTrace();
            return true;
        }

        @Override // com.web.library.groups.webviewsdk.b.a
        public void a(WebView webView, String str) {
            if (WMWebView.this.stateClient != null) {
                WMWebView.this.stateClient.pageFinished(webView, str);
            }
        }

        @Override // com.web.library.groups.webviewsdk.b.a
        public void a(WebView webView, String str, Bitmap bitmap) {
            if (WMWebView.this.stateClient != null) {
                WMWebView.this.stateClient.pageStarted(webView, str, bitmap);
            }
        }

        @Override // com.web.library.groups.webviewsdk.b.a
        public final boolean b(WebView webView, String str) {
            return c(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            sslErrorHandler.proceed();
        }
    }

    public WMWebView(Context context) {
        super(context);
        this.f27463a = null;
        this.e = 10011;
        this.f = "";
        this.g = false;
        this.h = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};
        a(context);
    }

    public WMWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f27463a = null;
        this.e = 10011;
        this.f = "";
        this.g = false;
        this.h = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};
        a(context);
    }

    public WMWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f27463a = null;
        this.e = 10011;
        this.f = "";
        this.g = false;
        this.h = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};
        a(context);
    }

    private String a(String str, String str2) {
        Map<String, String> a2 = com.web.library.groups.webviewsdk.c.a.a(str);
        if (a2.size() <= 0) {
            if (str.contains("?")) {
                return str + "appTicket=" + str2 + "&wmchannel=wmsdk";
            }
            return str + "?appTicket=" + str2 + "&wmchannel=wmsdk";
        }
        a2.put("appTicket", str2);
        a2.put("wmchannel", "wmsdk");
        String a3 = com.web.library.groups.webviewsdk.c.a.a(a2);
        String[] split = str.split("\\?");
        String str3 = (split == null || split.length <= 0) ? "" : split[0];
        String str4 = str;
        if (!d.a(a3)) {
            str4 = str;
            if (!d.a(str3)) {
                str4 = str3 + "?" + a3;
            }
        }
        return str4;
    }

    private void a(Context context) {
        this.f27463a = context;
        b();
        a(getSettings());
        WebViewSdk.getInstance().setOnAppTicketChangeListener(new WebViewSdk.a() { // from class: com.web.library.groups.webviewsdk.core.WMWebView.1
            @Override // com.web.library.groups.webviewsdk.core.WebViewSdk.a
            public void a(String str) {
                if (d.a(WebViewSdk.getInstance().getWebUrl())) {
                    return;
                }
                WMWebView.this.loadUrl(WebViewSdk.getInstance().getWebUrl());
            }
        });
        this.b = new com.web.library.groups.webviewsdk.core.a(context, this);
        c();
        setWebChromeClient(new a());
    }

    private void a(WebSettings webSettings) {
        String userAgentString = webSettings.getUserAgentString();
        String str = " wmchannel=wmsdk";
        if (userAgentString != null) {
            str = userAgentString + " wmchannel=wmsdk";
        }
        webSettings.setUserAgentString(str);
    }

    private void b() {
        setWebViewClient(new b(this.f27463a));
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(false);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowContentAccess(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setAllowContentAccess(true);
        settings.setCacheMode(2);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDatabaseEnabled(true);
        String path = this.f27463a.getDir(WebParameter.PATH_DATABASE, 0).getPath();
        settings.setGeolocationEnabled(true);
        settings.setGeolocationDatabasePath(path);
        settings.setAppCacheEnabled(true);
        settings.setAppCachePath(this.f27463a.getApplicationContext().getDir("cache", 0).getPath());
        settings.setAllowFileAccess(true);
        if (Build.VERSION.SDK_INT >= 21) {
            getSettings().setMixedContentMode(0);
        }
    }

    private void c() {
        addJavascriptInterface(this.b, "wmsdk");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        WebViewSdk.getInstance().authExpired();
    }

    @Override // android.webkit.WebView
    public void destroy() {
        super.destroy();
        this.b.release();
    }

    @Override // android.webkit.WebView
    public void goBack() {
        int i;
        Context context;
        Context context2;
        WebBackForwardList copyBackForwardList = copyBackForwardList();
        if (copyBackForwardList == null) {
            super.goBack();
            return;
        }
        int currentIndex = copyBackForwardList.getCurrentIndex();
        int i2 = currentIndex;
        while (true) {
            i = i2 - 1;
            if (i >= 0) {
                String url = copyBackForwardList.getItemAtIndex(i) == null ? null : copyBackForwardList.getItemAtIndex(i).getUrl();
                if (d.a(url) || (!url.startsWith("https://wx.tenpay.com/") && !url.startsWith("weixin://") && !url.contains("/checkPayStatus"))) {
                    break;
                } else if (i == 0 && (context2 = this.f27463a) != null && (context2 instanceof Activity)) {
                    ((Activity) context2).finish();
                    return;
                } else {
                    i2 = i;
                }
            } else {
                break;
            }
        }
        if (i >= 0 || (context = this.f27463a) == null || !(context instanceof Activity)) {
            goBackOrForward((-currentIndex) + i);
        } else {
            ((Activity) context).finish();
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        Log.e("ek===>loadUrl ", str);
        if (d.a(str)) {
            return;
        }
        String appTicket = WebViewSdk.getInstance().getAppTicket();
        String str2 = str;
        if (!str.startsWith(WebViewSdk.getInstance().getScheme())) {
            str2 = str;
            if (!str.startsWith("https://wx.tenpay.com/")) {
                str2 = str;
                if (!str.startsWith("weixin://")) {
                    str2 = str;
                    if (!str.startsWith(WebViewJsUtil.JS_URL_PREFIX)) {
                        str2 = str;
                        if (!d.a(appTicket)) {
                            WebViewSdk.getInstance().setWebUrl(str);
                            str2 = a(str, appTicket);
                        }
                    }
                }
            }
        }
        Log.e("ek===>addticketloadUrl ", str2);
        super.loadUrl(str2);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        if (i != 10011 || i2 != -1 || intent == null) {
            if (i == 10011 && i2 == 0) {
                Log.e("wmwebview", "RESULT_CANCELED resultUri=====>");
                ValueCallback<Uri[]> valueCallback = this.d;
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(new Uri[0]);
                    this.d = null;
                    return;
                }
                this.f27464c.onReceiveValue(null);
                this.f27464c = null;
            }
        } else if (c.a(this.f27463a, this.h)) {
            if (this.f27464c == null && this.d == null) {
                return;
            }
            Uri data = intent.getData();
            Uri uri = data;
            if (data != null) {
                String a2 = com.web.library.groups.webviewsdk.c.b.a(this.f27463a, data);
                uri = data;
                if (a2 != null) {
                    uri = Uri.fromFile(new File(a2));
                }
            }
            if (uri != null) {
                Log.e("wmwebview", "resultUri=====>" + uri);
                ValueCallback<Uri[]> valueCallback2 = this.d;
                if (valueCallback2 != null) {
                    valueCallback2.onReceiveValue(new Uri[]{uri});
                    this.d = null;
                    return;
                }
                this.f27464c.onReceiveValue(uri);
                this.f27464c = null;
            }
        }
    }

    @Override // android.webkit.WebView
    public void onResume() {
        super.onResume();
        if (this.g || TextUtils.isEmpty(this.f)) {
            return;
        }
        loadUrl(this.f);
        this.f = "";
        this.g = true;
    }

    @Override // android.webkit.WebView
    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        if (!(webChromeClient instanceof a)) {
            throw new RuntimeException("ChromeCliente not extends WMWebChromeClient");
        }
        super.setWebChromeClient(webChromeClient);
    }

    public void setWebStateClient(WMWebStateClient wMWebStateClient) {
        this.stateClient = wMWebStateClient;
    }

    @Override // android.webkit.WebView
    public final void setWebViewClient(WebViewClient webViewClient) {
        if (webViewClient != null && !(webViewClient instanceof b)) {
            throw new RuntimeException("client not extends WMWebViewClient");
        }
        super.setWebViewClient(webViewClient);
    }
}
