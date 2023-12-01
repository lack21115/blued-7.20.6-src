package com.blued.android.framework.web;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.collection.ArrayMap;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.alipay.sdk.cons.b;
import com.alipay.sdk.util.i;
import com.anythink.china.common.d;
import com.anythink.core.common.b.g;
import com.anythink.core.common.l;
import com.blued.android.chat.grpc.backup.MsgBackupManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.R;
import com.blued.android.framework.http.HappyDnsUtils;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.permission.PermissionManager;
import com.blued.android.framework.provider.ProviderHolder;
import com.blued.android.framework.urlroute.BluedURIRouter;
import com.blued.android.framework.urlroute.BluedUrlParser;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.LocaleUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.utils.Tools;
import com.blued.android.framework.web.BluedWebView;
import com.blued.android.framework.web.BluedWebView.WebCallback;
import com.blued.android.module.common.web.LoaderConstants;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.statistics.BluedStatistics;
import com.blued.das.CommonProtos;
import com.bytedance.applog.tracker.Tracker;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/web/BluedWebView.class */
public class BluedWebView<T extends WebCallback> implements View.OnCreateContextMenuListener {
    private static final boolean a = HappyDnsUtils.b();
    private static String[] y = BluedURIRouter.a().e();
    private static Map<String, String> z = new ConcurrentHashMap();
    private BluedWebView<T>.RectPosition d;
    private DisplayMetrics e;
    private int g;
    private Fragment h;
    private WebView i;
    private ViewGroup j;
    private T k;
    private WebUploadFile l;
    private String o;
    private View p;
    private WebChromeClient.CustomViewCallback q;
    private String v;
    private boolean b = false;
    private final String c = "blued_httpdns=1";
    private int f = 0;
    private JSExecutor m = null;
    private DownloaderJSCallback n = null;
    private String r = "";
    private String s = "";
    private String t = "";
    private boolean u = false;
    private int w = -1;
    private Map<String, Long> x = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.framework.web.BluedWebView$6  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/web/BluedWebView$6.class */
    public class AnonymousClass6 extends FileHttpResponseHandler {
        AnonymousClass6() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(File file) {
            Context d = AppInfo.d();
            d.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + file.getAbsolutePath())));
            if (Tools.a(BluedWebView.this.h)) {
                AppMethods.a((CharSequence) (AppInfo.d().getString(R.string.pic_save) + file.getAbsolutePath()));
            }
        }

        @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        /* renamed from: a */
        public void onSuccess(final File file) {
            if (file == null || !file.exists()) {
                return;
            }
            AppInfo.n().post(new Runnable() { // from class: com.blued.android.framework.web.-$$Lambda$BluedWebView$6$yKG-Cd7OhwT4hNgO2pOQduq04IY
                @Override // java.lang.Runnable
                public final void run() {
                    BluedWebView.AnonymousClass6.this.b(file);
                }
            });
        }

        @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        /* renamed from: a */
        public void onFailure(Throwable th, int i, File file) {
            super.onFailure(th, i, file);
            AppMethods.d(R.string.imagefailed_save_failed);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/web/BluedWebView$InJavaScriptBluedNativeObject.class */
    public final class InJavaScriptBluedNativeObject {
        InJavaScriptBluedNativeObject() {
        }

        @JavascriptInterface
        public void getH5ViewPagerInfo(int i, int i2, int i3, int i4) {
            BluedWebView bluedWebView = BluedWebView.this;
            bluedWebView.d = new RectPosition(i, i2, i3, i4);
        }

        @JavascriptInterface
        public void registerResumeJs(String str) {
            BluedWebView.this.o = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/web/BluedWebView$InJavaScriptLocalObj.class */
    public final class InJavaScriptLocalObj {
        InJavaScriptLocalObj() {
        }

        @JavascriptInterface
        public void setCallPopularizeMsg(final String str) {
            BluedWebView.this.i.post(new Runnable() { // from class: com.blued.android.framework.web.BluedWebView.InJavaScriptLocalObj.3
                @Override // java.lang.Runnable
                public void run() {
                    if (BluedWebView.this.k == null || TextUtils.isEmpty(str)) {
                        return;
                    }
                    BluedWebView.this.k.b(str);
                }
            });
        }

        @JavascriptInterface
        public void setOptionMenu(final String str) {
            BluedWebView.this.i.post(new Runnable() { // from class: com.blued.android.framework.web.BluedWebView.InJavaScriptLocalObj.2
                @Override // java.lang.Runnable
                public void run() {
                    if (BluedWebView.this.k != null) {
                        BluedWebView.this.k.a(str);
                    }
                }
            });
        }

        @JavascriptInterface
        public void shareTo(String str, String str2, String str3, String str4, String str5) {
            shareTo(str, str2, str3, "", "", "0", "0", str4, str5);
        }

        @JavascriptInterface
        public void shareTo(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8, final String str9) {
            if (BluedWebView.this.h == null) {
                return;
            }
            Runnable runnable = new Runnable() { // from class: com.blued.android.framework.web.BluedWebView.InJavaScriptLocalObj.1
                @Override // java.lang.Runnable
                public void run() {
                    if (BluedWebView.this.k != null) {
                        BluedWebView.this.k.a(str, str2, str3, str4, str5, str6, str7, str8, str9, BluedWebView.this);
                    }
                }
            };
            if (BluedWebView.this.h instanceof BaseFragment) {
                ((BaseFragment) BluedWebView.this.h).postDelaySafeRunOnUiThread(runnable, 500L);
            }
            if (BluedWebView.this.h instanceof BaseDialogFragment) {
                BluedWebView.this.h.a(runnable, 500L);
            }
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/web/BluedWebView$RectPosition.class */
    class RectPosition {
        private int b;
        private int c;
        private int d;
        private int e;

        public RectPosition(int i, int i2, int i3, int i4) {
            this.b = i2;
            this.c = i;
            this.d = i3;
            this.e = i4;
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/web/BluedWebView$WebCallback.class */
    public interface WebCallback {
        void a();

        void a(BluedWebView bluedWebView, int i);

        void a(BluedWebView bluedWebView, int i, String str, String str2);

        void a(BluedWebView bluedWebView, String str);

        void a(BluedWebView bluedWebView, String str, boolean z);

        void a(String str);

        void a(String str, String str2, Fragment fragment, BluedWebView bluedWebView);

        void a(String str, String str2, String str3, String str4, int i, Map<String, String> map, BluedWebView bluedWebView);

        void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, BluedWebView bluedWebView);

        void a(Map<String, String> map, BluedWebView bluedWebView);

        boolean a(Context context, String str);

        boolean a(BluedWebView bluedWebView, BluedUrlParser bluedUrlParser);

        void b();

        void b(BluedWebView bluedWebView, String str, boolean z);

        void b(String str);

        boolean c(String str);
    }

    public BluedWebView(Fragment fragment, WebView webView, ViewGroup viewGroup, T t) {
        this.h = fragment;
        this.i = webView;
        this.j = viewGroup;
        this.k = t;
        o();
    }

    private Locale a(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? configuration.getLocales().get(0) : configuration.locale;
    }

    public static void a(ConcurrentHashMap<String, String> concurrentHashMap) {
        z = concurrentHashMap;
    }

    public static boolean a(Context context, String str, WebCallback webCallback) {
        if (AppInfo.m()) {
            Log.v("webTest", "preOverrideUrlLoad(), url:" + str);
        }
        if (TextUtils.isEmpty(str) || CommonUrlHandler.a(context, str)) {
            return true;
        }
        Uri f = BluedURIRouter.a().f(str);
        if ((webCallback == null || !webCallback.a(context, str)) && !BluedURIRouter.a().a(context, f)) {
            if (str.startsWith("http://") || str.startsWith("https://") || str.startsWith("blued://") || str.startsWith("iblued://") || str.startsWith("www.")) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            try {
                if (AppMethods.a(intent)) {
                    Log.v("webTest", "system handle it: " + str);
                    context.startActivity(intent);
                    return true;
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }
        return true;
    }

    public static void b(Context context) {
        if (!AppMethods.c(21)) {
            CookieSyncManager.createInstance(context);
            p();
            CookieSyncManager.getInstance().sync();
            return;
        }
        CookieManager p = p();
        if (p != null) {
            p.flush();
        }
    }

    public static void c(Context context) {
        CookieManager p = p();
        if (p == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            p.removeSessionCookies(null);
            p.removeAllCookies(null);
            p.flush();
            return;
        }
        CookieSyncManager.createInstance(context);
        p.removeSessionCookie();
        p.removeAllCookie();
        CookieSyncManager.getInstance().sync();
        CookieSyncManager.getInstance().startSync();
    }

    private void c(String str) {
        if (this.b) {
            return;
        }
        this.b = !TextUtils.isEmpty(str) && str.contains("blued_httpdns=1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        FileDownloader.a(str, Tools.a() + File.separator + (System.currentTimeMillis() + ".jpg"), new AnonymousClass6(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(String str) {
        boolean a2 = a((Context) this.h.getActivity(), str, (WebCallback) this.k);
        boolean z2 = a2;
        if (!a2) {
            z2 = f(str);
        }
        return z2;
    }

    private boolean f(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        BluedUrlParser a2 = BluedUrlParser.a(str);
        int i = 0;
        if (a2 != null && Tools.a(this.h)) {
            String str9 = null;
            String str10 = null;
            String str11 = null;
            if ("changetitle".equals(a2.a())) {
                if (a2.b() != null) {
                    str11 = a2.b().get("title");
                }
                if (TextUtils.isEmpty(str11)) {
                    return true;
                }
                this.t = str11;
                T t = this.k;
                if (t != null) {
                    t.a(this, str11);
                    return true;
                }
                return true;
            } else if ("download".equals(a2.a())) {
                if (a2.b() != null) {
                    str7 = a2.b().get("opt");
                    str8 = a2.b().get(g.c.b);
                    str9 = a2.b().get("url");
                } else {
                    str7 = null;
                    str8 = null;
                }
                if (TextUtils.isEmpty(str9)) {
                    return true;
                }
                WebDownloaderManager.a().a(this.m.b(), str9, str7, str8);
                return true;
            } else if ("jscb".equals(a2.a())) {
                if (a2.b() != null) {
                    str10 = a2.b().get("opt");
                    str6 = a2.b().get("fun");
                } else {
                    str6 = null;
                }
                if (TextUtils.isEmpty(str10) || TextUtils.isEmpty(str6)) {
                    return true;
                }
                if ("register_download".equals(str10)) {
                    if (this.n == null) {
                        this.n = new DownloaderJSCallback(this.m);
                        WebDownloaderManager.a().a(this.n);
                    }
                    this.n.a(this.m.b(), str6);
                    return true;
                } else if ("get_uid".equals(str10)) {
                    String a3 = ProviderHolder.a().b().a();
                    JSExecutor jSExecutor = this.m;
                    jSExecutor.a(jSExecutor.b(), BridgeUtil.JAVASCRIPT_STR + str6 + "('" + a3 + "')");
                    return true;
                } else {
                    return true;
                }
            } else if (LoaderConstants.CLOSE.equals(a2.a())) {
                T t2 = this.k;
                if (t2 != null) {
                    t2.a(a2.b(), this);
                }
                DialogFragment dialogFragment = this.h;
                if (dialogFragment instanceof DialogFragment) {
                    dialogFragment.dismiss();
                    return true;
                }
                dialogFragment.getActivity().finish();
                return true;
            } else if (!"webshare".equals(a2.a())) {
                T t3 = this.k;
                return t3 != null && t3.a(this, a2);
            } else {
                String str12 = this.r;
                Map<String, String> b = a2.b();
                str2 = "";
                if (b != null) {
                    String str13 = a2.b().get("type");
                    if (!StringUtils.b(str13)) {
                        i = Integer.valueOf(str13).intValue();
                    }
                    String str14 = b.containsKey("title") ? b.get("title") : "";
                    str4 = b.containsKey(l.y) ? b.get(l.y) : "";
                    str2 = b.containsKey("to") ? b.get("to") : "";
                    if (b.containsKey("url")) {
                        str12 = b.get("url");
                    }
                    String str15 = str14;
                    str3 = str2;
                    str5 = str15;
                } else {
                    str3 = "";
                    i = 0;
                    str4 = str2;
                    str5 = str3;
                }
                T t4 = this.k;
                if (t4 != null) {
                    t4.a(str3, str12, str5, str4, i, b, this);
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String g(String str) {
        if (str == null) {
            return null;
        }
        return str.split(i.b)[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String h(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(i.b);
        if (split.length <= 1) {
            return null;
        }
        String str2 = split[1];
        if (str2.contains("=")) {
            return str2.substring(str2.indexOf("=") + 1);
        }
        return null;
    }

    private void m() {
        this.i.getSettings().setUseWideViewPort(true);
        this.i.getSettings().setJavaScriptEnabled(true);
        this.i.getSettings().setGeolocationEnabled(true);
        if (this.h.getActivity() != null) {
            this.i.getSettings().setGeolocationDatabasePath(this.h.getActivity().getFilesDir().getPath());
        }
        this.i.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.i.getSettings().setLoadWithOverviewMode(true);
        this.i.getSettings().setBuiltInZoomControls(true);
        this.i.getSettings().setSupportZoom(true);
        if (AppMethods.c(21)) {
            n();
        }
        this.i.getSettings().setDomStorageEnabled(true);
        this.i.getSettings().setAppCacheEnabled(true);
        this.i.setScrollBarStyle(33554432);
        this.i.getSettings().setSavePassword(false);
        this.i.addJavascriptInterface(new InJavaScriptBluedNativeObject(), "bluedNative");
        this.i.addJavascriptInterface(new InJavaScriptLocalObj(), MsgBackupManager.PLATFORM_ANDROID);
        this.i.addJavascriptInterface(new InJavaScriptBluedNativeObject(), "bluedNative");
        this.i.addJavascriptInterface(new InJavaScriptLocalObj(), MsgBackupManager.PLATFORM_ANDROID);
    }

    private void n() {
        try {
            this.i.getSettings().setMixedContentMode(2);
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
        }
    }

    private void o() {
        T t = this.k;
        if (t != null) {
            t.b();
        }
        r();
        this.g = StatusBarHelper.a(this.i.getContext());
        JSExecutor jSExecutor = new JSExecutor();
        this.m = jSExecutor;
        jSExecutor.a(this.i);
        m();
        a((Context) this.h.getActivity());
        try {
            this.i.getSettings().setUserAgentString(AppMethods.b(this.i.getSettings().getUserAgentString(), "ibb/1.0.0"));
        } catch (Exception e) {
        }
        this.i.setOnCreateContextMenuListener(this);
        this.i.setWebChromeClient(new BluedWebChromeClient() { // from class: com.blued.android.framework.web.BluedWebView.1
            @Override // com.blued.android.framework.web.BluedWebChromeClient, android.webkit.WebChromeClient
            public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
                callback.invoke(str, true, false);
            }

            @Override // android.webkit.WebChromeClient
            public void onHideCustomView() {
                if (BluedWebView.this.p == null) {
                    return;
                }
                if (BluedWebView.this.h != null && BluedWebView.this.h.getActivity() != null) {
                    BluedWebView.this.h.getActivity().setRequestedOrientation(1);
                }
                if (BluedWebView.this.j != null) {
                    BluedWebView.this.j.removeView(BluedWebView.this.p);
                    if (BluedWebView.this.q != null) {
                        BluedWebView.this.q.onCustomViewHidden();
                    }
                    BluedWebView.this.p = null;
                    BluedWebView.this.q = null;
                }
            }

            @Override // com.blued.android.framework.web.BluedWebChromeClient, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (BluedWebView.this.k != null) {
                    BluedWebView.this.k.a(BluedWebView.this, i);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                BluedWebView.this.t = str;
                if (BluedWebView.this.k != null) {
                    BluedWebView.this.k.a(BluedWebView.this, str);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                if (BluedWebView.this.p != null) {
                    customViewCallback.onCustomViewHidden();
                } else if (BluedWebView.this.h == null || BluedWebView.this.h.getActivity() == null) {
                } else {
                    BluedWebView.this.h.getActivity().setRequestedOrientation(0);
                    if (BluedWebView.this.j != null) {
                        BluedWebView.this.j.addView(view);
                        BluedWebView.this.p = view;
                        BluedWebView.this.q = customViewCallback;
                    }
                }
            }

            @Override // com.blued.android.framework.web.BluedWebChromeClient, android.webkit.WebChromeClient
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                if (BluedWebView.this.l == null) {
                    BluedWebView bluedWebView = BluedWebView.this;
                    bluedWebView.l = new WebUploadFile(bluedWebView.h);
                }
                BluedWebView.this.l.a(webView, valueCallback, fileChooserParams);
                return true;
            }
        });
        this.e = this.i.getContext().getResources().getDisplayMetrics();
        this.i.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.framework.web.BluedWebView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float rawY = motionEvent.getRawY();
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                BluedWebView.this.j();
                if (BluedWebView.this.d != null) {
                    int i = BluedWebView.this.d.b;
                    int i2 = BluedWebView.this.d.e;
                    int i3 = (int) (i * BluedWebView.this.e.density);
                    int i4 = BluedWebView.this.g;
                    int i5 = BluedWebView.this.f;
                    int i6 = (int) (i2 * BluedWebView.this.e.density);
                    int i7 = BluedWebView.this.g;
                    int i8 = BluedWebView.this.f;
                    if (rawY <= i3 + i4 + i5 || rawY >= i6 + i7 + i8) {
                        BluedWebView.this.i.requestDisallowInterceptTouchEvent(false);
                        return false;
                    }
                    BluedWebView.this.i.requestDisallowInterceptTouchEvent(true);
                    return false;
                }
                return false;
            }
        });
        this.i.setWebViewClient(new WebViewClient() { // from class: com.blued.android.framework.web.BluedWebView.3
            private boolean b = false;

            /* JADX WARN: Code restructure failed: missing block: B:120:0x0292, code lost:
                if ((r17 instanceof java.net.HttpURLConnection) != false) goto L87;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private java.net.URLConnection a(java.lang.String r8, final java.lang.String r9, android.webkit.WebResourceRequest r10, boolean r11) {
                /*
                    Method dump skipped, instructions count: 1006
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.android.framework.web.BluedWebView.AnonymousClass3.a(java.lang.String, java.lang.String, android.webkit.WebResourceRequest, boolean):java.net.URLConnection");
            }

            @Override // android.webkit.WebViewClient
            public void doUpdateVisitedHistory(WebView webView, String str, boolean z2) {
                if (AppInfo.m()) {
                    Log.v("webTest", "doUpdateVisitedHistory(), url:" + str);
                }
                BluedWebView.this.r = str;
                super.doUpdateVisitedHistory(webView, str, z2);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                if (Tools.a(BluedWebView.this.h)) {
                    if (AppInfo.m()) {
                        Log.v("webTest", "onPageFinished(), url:" + str);
                    }
                    super.onPageFinished(webView, str);
                    Long l = (Long) BluedWebView.this.x.remove(str);
                    if (l != null) {
                        BluedStatistics.b().a(str, SystemClock.uptimeMillis() - l.longValue());
                    }
                    if (BluedWebView.this.m != null) {
                        BluedWebView.this.m.a(str);
                    }
                    if (!BluedWebView.this.u) {
                        BluedWebView.this.u = true;
                        BluedWebView.this.k.a(BluedWebView.this.r, BluedWebView.this.s, BluedWebView.this.h, BluedWebView.this);
                    }
                    if (BluedWebView.this.k != null) {
                        BluedWebView.this.k.b(BluedWebView.this, str, true ^ this.b);
                    }
                    BluedWebView.this.i();
                    BluedWebView.this.q();
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                if (AppInfo.m()) {
                    Log.v("webTest", "onPageStarted(), url:" + str);
                }
                BluedWebView.this.r = str;
                super.onPageStarted(webView, str, bitmap);
                BluedWebView.this.x.put(str, Long.valueOf(SystemClock.uptimeMillis()));
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                if (AppInfo.m()) {
                    Log.v("webTest", "onReceivedError(), failingUrl:" + str2 + ", errorCode:" + i + ", description:" + str);
                }
                long j = -1;
                Long l = (Long) BluedWebView.this.x.remove(str2);
                if (l != null) {
                    j = SystemClock.uptimeMillis() - l.longValue();
                }
                BluedStatistics.b().a(str2, j, i, str);
                if (BluedWebView.this.k != null) {
                    BluedWebView.this.k.a(BluedWebView.this, i, str, str2);
                }
            }

            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                int i;
                Uri url;
                if (AppInfo.m()) {
                    Log.v("webTest", "onReceivedError(), request:" + webResourceRequest + ", error:" + webResourceError);
                }
                String str = "";
                String uri = (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) ? "" : url.toString();
                if (webResourceError != null) {
                    i = webResourceError.getErrorCode();
                    CharSequence description = webResourceError.getDescription();
                    if (description != null) {
                        str = description.toString();
                    }
                } else {
                    i = 0;
                }
                long j = -1;
                Long l = (Long) BluedWebView.this.x.remove(uri);
                if (l != null) {
                    j = SystemClock.uptimeMillis() - l.longValue();
                }
                BluedStatistics.b().a(uri, j, i, str);
                if (BluedWebView.this.k == null || !BluedWebView.this.r.equals(uri)) {
                    return;
                }
                BluedWebView.this.k.a(BluedWebView.this, i, str, uri);
            }

            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                if (BluedWebView.this.b || BluedWebView.a) {
                    if (webResourceRequest != null && webResourceRequest.getUrl() != null && webResourceRequest.getMethod().equalsIgnoreCase("get")) {
                        String host = webResourceRequest.getUrl().getHost();
                        if (TextUtils.isEmpty(host)) {
                            return super.shouldInterceptRequest(webView, webResourceRequest);
                        }
                        if (!BluedWebView.this.b && !host.endsWith("bldimg.com") && !host.endsWith("blued.cn") && !host.endsWith("blued.com") && !host.endsWith("blued.tw") && !host.endsWith("blued.us") && !host.endsWith("bluedapp.com") && !host.endsWith("bluedofficial.tumblr.com")) {
                            return super.shouldInterceptRequest(webView, webResourceRequest);
                        }
                        String trim = webResourceRequest.getUrl().getScheme().trim();
                        String uri = webResourceRequest.getUrl().toString();
                        com.blued.android.core.utils.Log.b("webTest", "shouldInterceptRequest url: " + uri);
                        if (trim.equalsIgnoreCase("http") || trim.equalsIgnoreCase(b.a)) {
                            try {
                                URLConnection a2 = a(uri, host, webResourceRequest, false);
                                if (a2 == null) {
                                    return null;
                                }
                                com.blued.android.core.utils.Log.b("webTest", "ContentType: " + a2.getContentType());
                                String contentType = a2.getContentType();
                                return new WebResourceResponse(BluedWebView.this.g(contentType), BluedWebView.this.h(contentType), a2.getInputStream());
                            } catch (MalformedURLException e2) {
                                e2.printStackTrace();
                                com.blued.android.core.utils.Log.b("webTest", "shouldInterceptRequest MalformedURLException:" + e2);
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                com.blued.android.core.utils.Log.b("webTest", "shouldInterceptRequest IOException:" + e3);
                            }
                        }
                    }
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }

            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                return super.shouldInterceptRequest(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (AppInfo.m()) {
                    Log.v("webTest", "shouldOverrideUrlLoading(), url:" + str);
                }
                boolean e2 = BluedWebView.this.e(str);
                this.b = e2;
                if (BluedWebView.this.k != null) {
                    BluedWebView.this.k.a(BluedWebView.this, str, !e2);
                }
                return e2;
            }
        });
        this.i.setDownloadListener(new DownloadListener() { // from class: com.blued.android.framework.web.BluedWebView.4
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (Tools.a(BluedWebView.this.h)) {
                    if (AppInfo.m()) {
                        Log.v("webTest", "onDownloadStart(), url:" + str);
                    }
                    BluedWebView.this.h.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                }
            }
        });
    }

    private static CookieManager p() {
        String[] strArr = y;
        CookieManager cookieManager = null;
        if (strArr == null || strArr.length == 0) {
            if (AppInfo.m()) {
                Log.w("webTest", "cookieDomains is empty!");
                return null;
            }
            return null;
        }
        try {
            CookieManager cookieManager2 = CookieManager.getInstance();
            cookieManager2.setAcceptCookie(true);
            StringBuilder sb = new StringBuilder();
            sb.append("token=");
            sb.append(TextUtils.isEmpty(ProviderHolder.a().b().b()) ? "" : AesCrypto.a(ProviderHolder.a().b().b()));
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("uid=");
            sb3.append(TextUtils.isEmpty(ProviderHolder.a().b().a()) ? "" : AesCrypto.a(ProviderHolder.a().b().a()));
            String sb4 = sb3.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("app=");
            sb5.append(ProviderHolder.a().e().a());
            String sb6 = sb5.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append("Accept-Language=");
            sb7.append(LocaleUtils.b());
            String sb8 = sb7.toString();
            CommonProtos.Common b = BluedStatistics.a().b();
            StringBuilder sb9 = new StringBuilder();
            sb9.append("net_op=");
            sb9.append(URLEncoder.encode(b.getNetOp(), "UTF-8"));
            String sb10 = sb9.toString();
            StringBuilder sb11 = new StringBuilder();
            sb11.append("net=");
            sb11.append(b.getNet());
            String sb12 = sb11.toString();
            StringBuilder sb13 = new StringBuilder();
            sb13.append("lat=");
            sb13.append(b.getLat());
            String sb14 = sb13.toString();
            StringBuilder sb15 = new StringBuilder();
            sb15.append("lon=");
            sb15.append(b.getLon());
            String sb16 = sb15.toString();
            StringBuilder sb17 = new StringBuilder();
            sb17.append("channel=");
            sb17.append(b.getChannel());
            String sb18 = sb17.toString();
            StringBuilder sb19 = new StringBuilder();
            sb19.append("screen_width=");
            sb19.append(String.valueOf(b.getScreenWidth()));
            String sb20 = sb19.toString();
            StringBuilder sb21 = new StringBuilder();
            sb21.append("screen_high=");
            sb21.append(String.valueOf(b.getScreenHigh()));
            String sb22 = sb21.toString();
            StringBuilder sb23 = new StringBuilder();
            sb23.append("device=");
            sb23.append(b.getDevice());
            String sb24 = sb23.toString();
            StringBuilder sb25 = new StringBuilder();
            sb25.append("imei=");
            sb25.append(b.getImei());
            String sb26 = sb25.toString();
            StringBuilder sb27 = new StringBuilder();
            sb27.append("smid=");
            sb27.append(b.getSmid());
            String sb28 = sb27.toString();
            StringBuilder sb29 = new StringBuilder();
            sb29.append("dev_dna=");
            sb29.append(b.getDevDna());
            String sb30 = sb29.toString();
            StringBuilder sb31 = new StringBuilder();
            sb31.append("timezone=");
            sb31.append(b.getTimezone());
            String sb32 = sb31.toString();
            String[] strArr2 = y;
            int length = strArr2.length;
            int i = 0;
            while (true) {
                int i2 = i;
                cookieManager = cookieManager2;
                if (i2 >= length) {
                    break;
                }
                String str = strArr2[i2];
                int i3 = i2;
                String[] strArr3 = strArr2;
                cookieManager = cookieManager2;
                if (z != null) {
                    Iterator<Map.Entry<String, String>> it = z.entrySet().iterator();
                    while (true) {
                        i3 = i2;
                        strArr3 = strArr2;
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry<String, String> next = it.next();
                        StringBuilder sb33 = new StringBuilder();
                        sb33.append(next.getKey());
                        sb33.append("=");
                        sb33.append(next.getValue());
                        cookieManager2.setCookie(str, sb33.toString());
                    }
                }
                cookieManager2.setCookie(str, sb2);
                cookieManager2.setCookie(str, sb4);
                cookieManager2.setCookie(str, "native=1");
                cookieManager2.setCookie(str, sb6);
                cookieManager2.setCookie(str, sb8);
                cookieManager2.setCookie(str, sb10);
                cookieManager2.setCookie(str, sb12);
                cookieManager2.setCookie(str, sb14);
                cookieManager2.setCookie(str, sb16);
                cookieManager2.setCookie(str, sb18);
                cookieManager2.setCookie(str, sb20);
                cookieManager2.setCookie(str, sb22);
                cookieManager2.setCookie(str, sb24);
                cookieManager2.setCookie(str, sb26);
                cookieManager2.setCookie(str, sb28);
                cookieManager2.setCookie(str, sb30);
                cookieManager2.setCookie(str, sb32);
                strArr2 = strArr3;
                i = i3 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cookieManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        String string = this.h.getActivity().getString(R.string.web_js_call_popularize);
        WebView webView = this.i;
        Tracker.loadUrl(webView, BridgeUtil.JAVASCRIPT_STR + string);
        Tracker.loadUrl(this.i, "javascript:checkCallPopularizeFunction()");
    }

    private void r() {
        Locale c = LocaleUtils.c();
        if (c == null || Build.VERSION.SDK_INT < 17) {
            return;
        }
        Resources resources = AppInfo.d().getResources();
        Configuration configuration = resources.getConfiguration();
        if (a(configuration).equals(c)) {
            return;
        }
        Locale.setDefault(c);
        Configuration configuration2 = new Configuration(configuration);
        configuration2.setLocale(c);
        resources.updateConfiguration(configuration2, resources.getDisplayMetrics());
    }

    public Fragment a() {
        return this.h;
    }

    public void a(int i) {
        this.f = i;
    }

    public void a(Context context) {
        if (AppMethods.c(21)) {
            d(context);
            return;
        }
        CookieSyncManager.createInstance(context);
        p();
        CookieSyncManager.getInstance().sync();
    }

    public boolean a(int i, int i2, Intent intent) {
        if (this.l == null || i != WebUploadFile.a) {
            return false;
        }
        this.l.a(i, i2, intent);
        return true;
    }

    public boolean a(String str) {
        return a(str, this.t);
    }

    public boolean a(String str, String str2) {
        String[] strArr;
        T t = this.k;
        if (t == null || !t.c(str)) {
            T t2 = this.k;
            if (t2 != null) {
                t2.a();
            }
            this.r = str;
            this.s = str;
            this.t = str2;
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("Accept-Language", LocaleUtils.b());
            String b = ProviderHolder.a().e().b();
            if (!TextUtils.isEmpty(b)) {
                arrayMap.put("X-CLIENT-COLOR", b);
            }
            this.i.getSettings().setDefaultTextEncodingName("utf-8");
            if (AppInfo.m() && (strArr = y) != null && strArr.length > 0) {
                int length = strArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    String str3 = strArr[i2];
                    String cookie = CookieManager.getInstance().getCookie(str3);
                    Log.i("webTest", "== " + str3 + " ==↓↓↓↓↓↓");
                    if (cookie != null) {
                        String[] split = cookie.split(i.b);
                        int length2 = split.length;
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 < length2) {
                                Log.v("webTest", split[i4]);
                                i3 = i4 + 1;
                            }
                        }
                    }
                    Log.i("webTest", "== " + str3 + " ==↑↑↑↑↑↑↑");
                    i = i2 + 1;
                }
            }
            c(str);
            Tracker.loadUrl(this.i, str, arrayMap);
            return true;
        }
        return false;
    }

    public int b() {
        return this.w;
    }

    public void b(int i) {
        this.w = i;
    }

    public void b(String str) {
        T t = this.k;
        if (t != null) {
            t.a(str, this.r, "", "", 0, null, this);
        }
    }

    public WebView c() {
        return this.i;
    }

    public String d() {
        return this.r;
    }

    public void d(Context context) {
        CookieManager p = p();
        WebView webView = this.i;
        if (webView != null) {
            p.setAcceptThirdPartyCookies(webView, true);
        }
        if (p != null) {
            p.flush();
        }
    }

    public String e() {
        return this.t;
    }

    public void f() {
        JSExecutor jSExecutor;
        this.i.onResume();
        if (TextUtils.isEmpty(this.o) || (jSExecutor = this.m) == null) {
            return;
        }
        jSExecutor.a(jSExecutor.b(), this.o);
    }

    public void g() {
        this.i.onPause();
    }

    public void h() {
        JSExecutor jSExecutor = this.m;
        if (jSExecutor != null) {
            jSExecutor.a();
        }
        if (this.n != null) {
            WebDownloaderManager.a().b(this.n);
        }
        this.i.clearCache(true);
        this.i.setVisibility(8);
        this.i.destroy();
    }

    public void i() {
        String string = this.h.getActivity().getString(R.string.web_js_get_option_menu);
        WebView webView = this.i;
        Tracker.loadUrl(webView, BridgeUtil.JAVASCRIPT_STR + string);
        Tracker.loadUrl(this.i, "javascript:getOptionMenuFunction()");
    }

    public void j() {
        Tracker.loadUrl(this.i, "javascript:getBannerPosition()");
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        WebView.HitTestResult hitTestResult;
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = new MenuItem.OnMenuItemClickListener() { // from class: com.blued.android.framework.web.BluedWebView.5
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                Tracker.onMenuItemClick(menuItem);
                if (menuItem.getItemId() != 1 || TextUtils.isEmpty(BluedWebView.this.v)) {
                    return false;
                }
                PermissionManager.a(new PermissionCallbacks() { // from class: com.blued.android.framework.web.BluedWebView.5.1
                    @Override // com.blued.android.framework.permission.PermissionCallbacks
                    public void U_() {
                        BluedWebView.this.d(BluedWebView.this.v);
                    }

                    @Override // com.blued.android.framework.permission.PermissionCallbacks
                    public void a(String[] strArr) {
                    }
                }, d.b, "android.permission.READ_EXTERNAL_STORAGE");
                return true;
            }
        };
        if (!(view instanceof WebView) || (hitTestResult = ((WebView) view).getHitTestResult()) == null) {
            return;
        }
        int type = hitTestResult.getType();
        if (type == 5 || type == 8) {
            this.v = hitTestResult.getExtra();
            contextMenu.add(0, 1, 0, R.string.web_save_picture).setOnMenuItemClickListener(onMenuItemClickListener);
        }
    }
}
