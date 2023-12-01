package com.anythink.expressad.atsignalcommon.base;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.youzan.androidsdk.tool.WebParameter;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/base/BaseWebView.class */
public class BaseWebView extends WebView {

    /* renamed from: a  reason: collision with root package name */
    private View.OnTouchListener f4230a;
    private View.OnTouchListener b;
    protected Context e;
    public long lastTouchTime;
    public b mWebViewClient;

    public BaseWebView(Context context) {
        super(context);
        this.lastTouchTime = 0L;
        this.f4230a = new View.OnTouchListener() { // from class: com.anythink.expressad.atsignalcommon.base.BaseWebView.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    BaseWebView.this.lastTouchTime = System.currentTimeMillis();
                }
                if (BaseWebView.this.b != null) {
                    return BaseWebView.this.b.onTouch(view, motionEvent);
                }
                return false;
            }
        };
        this.e = context;
        a();
    }

    public BaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lastTouchTime = 0L;
        this.f4230a = new View.OnTouchListener() { // from class: com.anythink.expressad.atsignalcommon.base.BaseWebView.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    BaseWebView.this.lastTouchTime = System.currentTimeMillis();
                }
                if (BaseWebView.this.b != null) {
                    return BaseWebView.this.b.onTouch(view, motionEvent);
                }
                return false;
            }
        };
        this.e = context;
        a();
    }

    public BaseWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lastTouchTime = 0L;
        this.f4230a = new View.OnTouchListener() { // from class: com.anythink.expressad.atsignalcommon.base.BaseWebView.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    BaseWebView.this.lastTouchTime = System.currentTimeMillis();
                }
                if (BaseWebView.this.b != null) {
                    return BaseWebView.this.b.onTouch(view, motionEvent);
                }
                return false;
            }
        };
        this.e = context;
        a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0043, code lost:
        if (r0.contains(com.anythink.expressad.foundation.h.r.a()) == false) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.lang.String a(java.lang.String r5) {
        /*
            r4 = this;
            r0 = r5
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r8 = r0
            r0 = 0
            r7 = r0
            r0 = r7
            r6 = r0
            r0 = r8
            if (r0 != 0) goto L49
            r0 = r5
            java.lang.String r1 = "../"
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L1d
        L18:
            r0 = 1
            r6 = r0
            goto L49
        L1d:
            r0 = r7
            r6 = r0
            r0 = r5
            java.lang.String r1 = "file"
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L49
            r0 = r5
            android.net.Uri r0 = android.net.Uri.parse(r0)
            java.lang.String r0 = r0.getPath()
            r9 = r0
            r0 = r9
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L18
            r0 = r7
            r6 = r0
            r0 = r9
            java.lang.String r1 = com.anythink.expressad.foundation.h.r.a()
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L49
            goto L18
        L49:
            r0 = r5
            r9 = r0
            r0 = r6
            if (r0 == 0) goto L63
            java.lang.String r0 = "anythink_express"
            java.lang.String r1 = "illegal URL: "
            r2 = r5
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r1 = r1.concat(r2)
            int r0 = android.util.Log.e(r0, r1)
            java.lang.String r0 = "about:blank"
            r9 = r0
        L63:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.atsignalcommon.base.BaseWebView.a(java.lang.String):java.lang.String");
    }

    public void a() {
        if (this.mWebViewClient == null) {
            b bVar = new b();
            this.mWebViewClient = bVar;
            setWebViewClient(bVar);
        }
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        requestFocus();
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setAppCacheMaxSize(5242880L);
        settings.setAllowFileAccess(true);
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setSupportZoom(false);
        settings.setSavePassword(false);
        settings.setDatabaseEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                settings.setSafeBrowsingEnabled(false);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (Build.VERSION.SDK_INT >= 17) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        try {
            if (Build.VERSION.SDK_INT >= 16) {
                settings.setAllowUniversalAccessFromFileURLs(true);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        settings.setDatabaseEnabled(true);
        String path = this.e.getDir(WebParameter.PATH_DATABASE, 0).getPath();
        settings.setDatabasePath(path);
        settings.setGeolocationEnabled(true);
        settings.setGeolocationDatabasePath(path);
        try {
            Method declaredMethod = WebSettings.class.getDeclaredMethod("setDisplayZoomControls", Boolean.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(settings, Boolean.FALSE);
        } catch (Exception e2) {
        }
        super.setOnTouchListener(this.f4230a);
    }

    public b getBaseWebViewClient() {
        return this.mWebViewClient;
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        super.loadDataWithBaseURL(a(str), str2, str3, str4, str5);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        super.loadUrl(a(str));
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        super.loadUrl(a(str), map);
    }

    @Override // android.webkit.WebView
    public void reload() {
        super.reload();
    }

    public void setFilter(a aVar) {
        b bVar = this.mWebViewClient;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.b = onTouchListener;
    }

    public void setTransparent() {
        setLayerType(1, null);
        setBackgroundColor(0);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof b) {
            this.mWebViewClient = (b) webViewClient;
        }
    }
}
