package com.tencent.tendinsv.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.applog.tracker.Tracker;
import com.tencent.tendinsv.R;
import com.tencent.tendinsv.c.e;
import com.tencent.tendinsv.utils.d;
import com.tencent.tendinsv.utils.l;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/view/CaptchaActivity.class */
public class CaptchaActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private WebView f25428a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f25429c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/view/CaptchaActivity$a.class */
    public class a {
        private a() {
        }

        @JavascriptInterface
        public void getCaptchaCallBacks(String str, String str2, String str3, String str4, String str5) {
            e a2;
            int i;
            CaptchaActivity.this.finish();
            if ("0".equals(str)) {
                a2 = e.a();
                i = 1000;
            } else {
                a2 = e.a();
                i = 1001;
            }
            a2.a(i, d.a(str, str2, str3, str4, str5));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/view/CaptchaActivity$b.class */
    public class b extends WebViewClient {
        b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            WebView webView2 = CaptchaActivity.this.f25428a;
            Tracker.loadUrl(webView2, "javascript:startTencentCaptcha(" + CaptchaActivity.this.b + ",'" + CaptchaActivity.this.f25429c + "')");
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            CaptchaActivity.this.finish();
            e.a().a(1014, d.a("2", "", CaptchaActivity.this.b, CaptchaActivity.this.f25429c, "onReceivedError"));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
            try {
                AlertDialog.Builder builder = new AlertDialog.Builder(webView.getContext());
                builder.setMessage("SSL认证失败，是否继续访问？");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.tencent.tendinsv.view.CaptchaActivity.b.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Tracker.onClick(dialogInterface, i);
                        sslErrorHandler.proceed();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.tencent.tendinsv.view.CaptchaActivity.b.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Tracker.onClick(dialogInterface, i);
                        sslErrorHandler.cancel();
                    }
                });
                builder.create().show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            return super.shouldOverrideKeyEvent(webView, keyEvent);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Tracker.loadUrl(webView, str);
            return true;
        }
    }

    private void a() {
        Intent intent = getIntent();
        this.b = intent.getStringExtra("captchaId");
        this.f25429c = intent.getStringExtra("customContent");
    }

    private static void a(Window window) {
        try {
            if (Build.VERSION.SDK_INT < 21) {
                if (Build.VERSION.SDK_INT >= 19) {
                    window.addFlags(67108864);
                    return;
                }
                return;
            }
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(1024);
            if (Build.VERSION.SDK_INT >= 23) {
                window.getDecorView().setSystemUiVisibility(9216);
            }
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        } catch (Exception e) {
            e.printStackTrace();
            l.d(com.tencent.tendinsv.b.F, "initSystemBarTint--Exception_e=" + e.toString());
        }
    }

    private void b() {
        a(getWindow());
        WebView webView = (WebView) findViewById(R.id.captcha_web);
        this.f25428a = webView;
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setSavePassword(false);
        settings.setCacheMode(2);
        settings.setSupportMultipleWindows(true);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setPluginState(WebSettings.PluginState.ON);
        this.f25428a.setBackgroundColor(0);
        this.f25428a.setWebViewClient(new b());
        this.f25428a.addJavascriptInterface(new a(), "JsBridge");
        Tracker.loadUrl(this.f25428a, "file:///android_asset/web/captcha.html");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_tendinsv_captcha);
        try {
            b();
            a();
        } catch (Exception e) {
            e.printStackTrace();
            e.a().a(1014, d.a("2", "", this.b, this.f25429c, "onCreate"));
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            try {
                if (keyEvent.getRepeatCount() == 0) {
                    finish();
                    e.a().a(1001, d.a("2", "", this.b, this.f25429c, "onKeyDown"));
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                e.a().a(1014, d.a("2", "", this.b, this.f25429c, "onKeyDown"));
            }
        }
        return super.onKeyDown(i, keyEvent);
    }
}
