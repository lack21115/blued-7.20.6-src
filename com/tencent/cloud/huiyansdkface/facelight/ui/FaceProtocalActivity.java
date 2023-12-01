package com.tencent.cloud.huiyansdkface.facelight.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.core.channel.Const;
import com.tencent.cloud.huiyansdkface.R;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceError;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceVerifyResult;
import com.tencent.cloud.huiyansdkface.facelight.c.b.e;
import com.tencent.cloud.huiyansdkface.facelight.c.f;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.facelight.process.d;
import com.tencent.cloud.huiyansdkface.facelight.ui.widget.c;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import java.net.URLEncoder;
import java.util.Properties;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/ui/FaceProtocalActivity.class */
public class FaceProtocalActivity extends com.tencent.cloud.huiyansdkface.facelight.ui.a.a {

    /* renamed from: a  reason: collision with root package name */
    private static int f35671a;
    private d b;

    /* renamed from: c  reason: collision with root package name */
    private e f35672c = new e(Const.SOCKET_CHECK_CHANNEL);
    private c d;
    private LinearLayout e;
    private ImageView f;
    private WebView g;
    private String h;
    private String i;
    private boolean j;
    private boolean k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/ui/FaceProtocalActivity$a.class */
    public static class a implements c.b {

        /* renamed from: a  reason: collision with root package name */
        private d f35678a;
        private Activity b;

        public a(d dVar, Activity activity) {
            this.f35678a = dVar;
            this.b = activity;
        }

        @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.c.b
        public void a() {
            WLogger.d("FaceProtocalActivity", "onHomePressed");
            KycWaSDK.getInstance().trackCustomKVEvent(this.b, "authpage_detailpage_exit_self", "点击home键返回", null);
            this.f35678a.e(true);
            if (this.f35678a.y() != null) {
                WbFaceVerifyResult wbFaceVerifyResult = new WbFaceVerifyResult();
                wbFaceVerifyResult.setIsSuccess(false);
                wbFaceVerifyResult.setOrderNo(this.f35678a.w());
                wbFaceVerifyResult.setSign(null);
                WbFaceError wbFaceError = new WbFaceError();
                wbFaceError.setDomain(WbFaceError.WBFaceErrorDomainNativeProcess);
                wbFaceError.setCode(WbFaceError.WBFaceErrorCodeUserCancle);
                wbFaceError.setDesc("用户取消");
                wbFaceError.setReason("home键：用户授权详情中取消");
                wbFaceVerifyResult.setError(wbFaceError);
                Properties properties = new Properties();
                properties.setProperty("errorDesc", wbFaceError.toString());
                this.f35678a.a(this.b, WbFaceError.WBFaceErrorCodeUserCancle, properties);
                this.f35678a.y().onFinish(wbFaceVerifyResult);
            }
            this.b.finish();
        }

        @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.c.b
        public void b() {
            WLogger.d("FaceProtocalActivity", "onHomeLongPressed");
        }
    }

    private void b() {
        int i;
        WLogger.i("FaceProtocalActivity", "setThemeAndTitleBar");
        String J = this.b.x().J();
        this.i = J;
        if (WbCloudFaceContant.BLACK.equals(J)) {
            i = R.style.wbcfFaceProtocolThemeBlack;
        } else if ("custom".equals(this.i)) {
            i = R.style.wbcfFaceProtocolThemeCustom;
        } else {
            WLogger.e("FaceProtocalActivity", "set default WHITE");
            this.i = WbCloudFaceContant.WHITE;
            i = R.style.wbcfFaceProtocolThemeWhite;
        }
        setTheme(i);
        a(this.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Tracker.loadUrl(this.g, str);
    }

    private void c() {
        Drawable mutate;
        Resources resources;
        int i;
        String str;
        c cVar = new c(this);
        this.d = cVar;
        cVar.a(new a(this.b, this));
        String U = this.b.x().U();
        WLogger.d("FaceProtocalActivity", "protocolCorpName=" + U);
        String replace = U.replace("$$$", "|");
        WLogger.d("FaceProtocalActivity", "after protocolCorpName=" + replace);
        String[] split = replace.split("\\|");
        String str2 = "";
        String str3 = null;
        int i2 = 0;
        while (i2 < split.length) {
            WLogger.d("FaceProtocalActivity", "tmp[" + i2 + "]=" + split[i2]);
            if (i2 == 0) {
                str = split[0];
            } else {
                str = str3;
                if (i2 == 1) {
                    str2 = split[1];
                    str = str3;
                }
            }
            i2++;
            str3 = str;
        }
        WLogger.d("FaceProtocalActivity", "corpName=" + str3 + ",channel=" + str2);
        String appId = Param.getAppId();
        String V = this.b.x().V();
        this.h = com.tencent.cloud.huiyansdkface.facelight.c.c.a(this.b.x().X(), this.b.x().P(), false) + "/s/h5/protocolCDN.html?appId=" + appId + "&protocolNo=" + V + "&name=" + URLEncoder.encode(str3) + "&channel=" + str2 + "&lang=" + f.a(this.b.x().H());
        StringBuilder sb = new StringBuilder();
        sb.append("url=");
        sb.append(this.h);
        WLogger.d("FaceProtocalActivity", sb.toString());
        KycWaSDK.getInstance().trackCustomKVEvent(getApplicationContext(), "authpage_detailpage_enter", this.h, null);
        this.f = (ImageView) findViewById(R.id.wbcf_protocol_back);
        if (!this.i.equals(WbCloudFaceContant.WHITE)) {
            if (this.i.equals("custom")) {
                mutate = DrawableCompat.wrap(ContextCompat.getDrawable(this, R.mipmap.wbcf_back)).mutate();
                resources = getResources();
                i = R.color.wbcf_custom_auth_back_tint;
            }
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.wbcf_protocol_left_button);
            this.e = linearLayout;
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceProtocalActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (FaceProtocalActivity.this.g.canGoBack()) {
                        WLogger.d("FaceProtocalActivity", "左上角返回键，回到上一页");
                        FaceProtocalActivity.this.g.goBack();
                        return;
                    }
                    WLogger.d("FaceProtocalActivity", "左上角返回键，无上一页，退出授权sdk");
                    KycWaSDK.getInstance().trackCustomKVEvent(FaceProtocalActivity.this.getApplicationContext(), "authpage_detailpage_exit_self", "左上角返回", null);
                    FaceProtocalActivity.this.d();
                    FaceProtocalActivity.this.finish();
                }
            });
            WebView webView = (WebView) findViewById(R.id.wbcf_protocol_webview);
            this.g = webView;
            webView.setBackgroundColor(0);
            a();
        }
        mutate = DrawableCompat.wrap(ContextCompat.getDrawable(this, R.mipmap.wbcf_back)).mutate();
        resources = getResources();
        i = R.color.wbcf_guide_black_bg;
        DrawableCompat.setTint(mutate, resources.getColor(i));
        this.f.setImageDrawable(mutate);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.wbcf_protocol_left_button);
        this.e = linearLayout2;
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceProtocalActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (FaceProtocalActivity.this.g.canGoBack()) {
                    WLogger.d("FaceProtocalActivity", "左上角返回键，回到上一页");
                    FaceProtocalActivity.this.g.goBack();
                    return;
                }
                WLogger.d("FaceProtocalActivity", "左上角返回键，无上一页，退出授权sdk");
                KycWaSDK.getInstance().trackCustomKVEvent(FaceProtocalActivity.this.getApplicationContext(), "authpage_detailpage_exit_self", "左上角返回", null);
                FaceProtocalActivity.this.d();
                FaceProtocalActivity.this.finish();
            }
        });
        WebView webView2 = (WebView) findViewById(R.id.wbcf_protocol_webview);
        this.g = webView2;
        webView2.setBackgroundColor(0);
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        WLogger.d("FaceProtocalActivity", "backToGuideActivity");
        this.j = true;
        Intent intent = new Intent();
        intent.putExtra("isChecked", this.k);
        intent.setClass(this, FaceGuideActivity.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    protected void a() {
        if (Build.VERSION.SDK_INT >= 16) {
            this.g.setImportantForAccessibility(4);
        }
        this.g.setWebViewClient(new WebViewClient() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceProtocalActivity.2
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                WLogger.d("FaceProtocalActivity", "onPageFinished:" + System.currentTimeMillis());
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                WLogger.d("FaceProtocalActivity", "onPageStarted:" + System.currentTimeMillis());
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
                WLogger.e("FaceProtocalActivity", "webview访问网址ssl证书无效！询问客户");
                AlertDialog.Builder builder = new AlertDialog.Builder(FaceProtocalActivity.this);
                builder.setMessage("当前页面证书不可信，是否继续访问?");
                builder.setPositiveButton("继续", new DialogInterface.OnClickListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceProtocalActivity.2.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Tracker.onClick(dialogInterface, i);
                        sslErrorHandler.proceed();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceProtocalActivity.2.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Tracker.onClick(dialogInterface, i);
                        sslErrorHandler.cancel();
                    }
                });
                builder.create().show();
            }

            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                return super.shouldInterceptRequest(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                WLogger.d("FaceProtocalActivity", str);
                if (str.startsWith("https://")) {
                    FaceProtocalActivity.this.b(str);
                    return true;
                }
                return false;
            }
        });
        WebSettings settings = this.g.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        settings.setSupportMultipleWindows(false);
        settings.setLoadWithOverviewMode(true);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setGeolocationEnabled(true);
        settings.setDatabasePath(getDir("databases", 0).getPath());
        settings.setGeolocationDatabasePath(getDir("geolocation", 0).getPath());
        settings.setPluginState(WebSettings.PluginState.ON_DEMAND);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        if (Build.VERSION.SDK_INT < 33) {
            settings.setAppCacheEnabled(false);
            settings.setAppCacheMaxSize(0L);
            settings.setAppCachePath(getDir("appcache", 0).getPath());
        }
        settings.setAllowUniversalAccessFromFileURLs(false);
        if (Build.VERSION.SDK_INT <= 19) {
            this.g.removeJavascriptInterface("searchBoxJavaBridge_");
            this.g.removeJavascriptInterface(Context.ACCESSIBILITY_SERVICE);
            this.g.removeJavascriptInterface("accessibilityTraversal");
        }
        if (Build.VERSION.SDK_INT >= 11) {
            this.g.removeJavascriptInterface("searchBoxJavaBridge_");
        }
        this.g.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceProtocalActivity.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        b(this.h);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.g.canGoBack()) {
            WLogger.d("FaceProtocalActivity", "返回键，回到上一页");
            this.g.goBack();
            return;
        }
        WLogger.d("FaceProtocalActivity", "返回键，无上一页可回，退出授权页面");
        super.onBackPressed();
        KycWaSDK.getInstance().trackCustomKVEvent(getApplicationContext(), "authpage_detailpage_exit_self", "返回键", null);
        d();
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        WLogger.d("FaceProtocalActivity", "onCreate：" + getRequestedOrientation());
        WLogger.d("FaceProtocalActivity", "setActivityOrientation:" + getWindowManager().getDefaultDisplay().getRotation());
        d z = d.z();
        this.b = z;
        z.e(false);
        f35671a++;
        b();
        super.onCreate(bundle);
        setContentView(R.layout.wbcf_face_protocol_layout);
        if (getIntent() != null) {
            this.k = getIntent().getBooleanExtra("isChecked", false);
        }
        c();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        WLogger.i("FaceProtocalActivity", "onDestroy");
    }

    @Override // android.app.Activity
    public void onPause() {
        WLogger.d("FaceProtocalActivity", "onPause");
        super.onPause();
        c cVar = this.d;
        if (cVar != null) {
            cVar.b();
        }
        this.f35672c.a();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        WLogger.d("FaceProtocalActivity", "onResume");
        c cVar = this.d;
        if (cVar != null) {
            cVar.a();
        }
        this.f35672c.a(getApplicationContext());
    }

    @Override // android.app.Activity
    public void onStart() {
        WLogger.d("FaceProtocalActivity", "onStart");
        super.onStart();
    }

    @Override // android.app.Activity
    public void onStop() {
        WLogger.i("FaceProtocalActivity", "onStop");
        super.onStop();
        int i = f35671a - 1;
        f35671a = i;
        if (i != 0) {
            WLogger.e("FaceProtocalActivity", "not same activity ");
        } else if (this.j) {
            WLogger.d("FaceProtocalActivity", "backToGuide,no return");
        } else {
            WLogger.d("FaceProtocalActivity", "same activity ");
            if (this.b.t()) {
                return;
            }
            WLogger.i("FaceProtocalActivity", "onStop quit authDetailpage");
            KycWaSDK.getInstance().trackCustomKVEvent(getApplicationContext(), "authpage_detailpage_exit_forced", "onStop, 应用被动离开前台", null);
            if (this.b.y() != null) {
                WbFaceVerifyResult wbFaceVerifyResult = new WbFaceVerifyResult();
                wbFaceVerifyResult.setIsSuccess(false);
                wbFaceVerifyResult.setOrderNo(this.b.w());
                wbFaceVerifyResult.setSign(null);
                WbFaceError wbFaceError = new WbFaceError();
                wbFaceError.setDomain(WbFaceError.WBFaceErrorDomainNativeProcess);
                wbFaceError.setCode(WbFaceError.WBFaceErrorCodeUserCancle);
                wbFaceError.setDesc("用户取消");
                wbFaceError.setReason("用户取消，授权详情中回到后台activity onStop");
                wbFaceVerifyResult.setError(wbFaceError);
                Properties properties = new Properties();
                properties.setProperty("errorDesc", wbFaceError.toString());
                this.b.a(this, WbFaceError.WBFaceErrorCodeUserCancle, properties);
                this.b.y().onFinish(wbFaceVerifyResult);
            }
            finish();
        }
    }
}
