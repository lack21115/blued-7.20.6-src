package com.blued.android.web;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.anythink.core.common.res.d;
import com.app.share.ShareUtils;
import com.app.share.model.ShareEntity;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.utils.Md5;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.urlroute.BluedURIRouter;
import com.blued.android.framework.urlroute.BluedUrlParser;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.utils.FileUtils;
import com.blued.android.framework.web.CommonUrlHandler;
import com.blued.android.framework.web.DownloaderJSCallback;
import com.blued.android.framework.web.JSExecutor;
import com.blued.android.framework.web.WebDownloaderManager;
import com.blued.android.framework.web.WebUploadFile;
import com.blued.android.framework.web.cache.BluedWebViewCacheClient;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.widget.emoticon.manager.EmotionManager;
import com.blued.android.module.common.widget.emoticon.manager.EmotionPackWebDownload;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.views.WebBtmOptions;
import com.blued.android.web.BaseWebView;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.openalliance.ad.constant.s;
import com.soft.blued.R;
import com.soft.blued.http.AppHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.io.File;
import java.net.URL;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/web/BaseWebView.class */
public class BaseWebView implements View.OnCreateContextMenuListener {

    /* renamed from: a  reason: collision with root package name */
    public ShareOptionRecyclerAdapter.ShareOptionsItemClickListener f18755a;
    public WebBtmOptions b;

    /* renamed from: c  reason: collision with root package name */
    public String f18756c;
    public String d;
    public String e;
    private RectPosition f;
    private DisplayMetrics g;
    private int h;
    private int i;
    private Fragment j;
    private WebView k;
    private ViewGroup l;
    private WebCallback m;
    private WebUploadFile n;
    private JSExecutor o;
    private DownloaderJSCallback p;
    private String q;
    private View r;
    private WebChromeClient.CustomViewCallback s;
    private String t;
    private String u;
    private String v;
    private boolean w;
    private String x;
    private int y;
    private Map<String, Long> z;

    /* renamed from: com.blued.android.web.BaseWebView$1  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/web/BaseWebView$1.class */
    class AnonymousClass1 implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            InstantLog.b("web_page_options_click", 3);
        }
    }

    /* renamed from: com.blued.android.web.BaseWebView$2  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/web/BaseWebView$2.class */
    class AnonymousClass2 extends BluedWebChromeClient {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BaseWebView f18757a;

        @Override // com.blued.android.web.BluedWebChromeClient, android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            callback.invoke(str, true, false);
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            Logger.a("webTest", "onHideCustomView()");
            if (this.f18757a.r == null) {
                return;
            }
            if (this.f18757a.j != null && this.f18757a.j.getActivity() != null) {
                this.f18757a.j.getActivity().setRequestedOrientation(1);
            }
            if (this.f18757a.l != null) {
                this.f18757a.l.removeView(this.f18757a.r);
                if (this.f18757a.s != null) {
                    this.f18757a.s.onCustomViewHidden();
                }
                this.f18757a.r = null;
                this.f18757a.s = null;
            }
        }

        @Override // com.blued.android.web.BluedWebChromeClient, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (this.f18757a.m != null) {
                this.f18757a.m.a(this.f18757a, i);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            this.f18757a.v = str;
            if (this.f18757a.m != null) {
                this.f18757a.m.a(this.f18757a, str);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            Logger.a("webTest", "onShowCustomView()");
            if (this.f18757a.r != null) {
                customViewCallback.onCustomViewHidden();
            } else if (this.f18757a.j == null || this.f18757a.j.getActivity() == null) {
            } else {
                this.f18757a.j.getActivity().setRequestedOrientation(0);
                if (this.f18757a.l != null) {
                    this.f18757a.l.addView(view);
                    this.f18757a.r = view;
                    this.f18757a.s = customViewCallback;
                }
            }
        }

        @Override // com.blued.android.web.BluedWebChromeClient, android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            if (this.f18757a.n == null) {
                BaseWebView baseWebView = this.f18757a;
                baseWebView.n = new WebUploadFile(baseWebView.j);
            }
            this.f18757a.n.a(webView, valueCallback, fileChooserParams);
            return true;
        }

        @Override // com.blued.android.web.BluedWebChromeClient, android.webkit.WebChromeClient
        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            if (this.f18757a.n == null) {
                BaseWebView baseWebView = this.f18757a;
                baseWebView.n = new WebUploadFile(baseWebView.j);
            }
            this.f18757a.n.a(valueCallback, str, str2);
        }
    }

    /* renamed from: com.blued.android.web.BaseWebView$3  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/web/BaseWebView$3.class */
    class AnonymousClass3 implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BaseWebView f18758a;

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            float rawY = motionEvent.getRawY();
            if (motionEvent.getAction() != 0) {
                return false;
            }
            this.f18758a.c();
            if (this.f18758a.f != null) {
                int i = this.f18758a.f.b;
                int i2 = this.f18758a.f.e;
                int i3 = (int) (i * this.f18758a.g.density);
                int i4 = this.f18758a.i;
                int i5 = this.f18758a.h;
                int i6 = (int) (i2 * this.f18758a.g.density);
                int i7 = this.f18758a.i;
                int i8 = this.f18758a.h;
                if (rawY <= i3 + i4 + i5 || rawY >= i6 + i7 + i8) {
                    this.f18758a.k.requestDisallowInterceptTouchEvent(false);
                    return false;
                }
                this.f18758a.k.requestDisallowInterceptTouchEvent(true);
                return false;
            }
            return false;
        }
    }

    /* renamed from: com.blued.android.web.BaseWebView$4  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/web/BaseWebView$4.class */
    class AnonymousClass4 extends BluedWebViewCacheClient {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BaseWebView f18759a;
        private boolean b;

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (CommonTools.a(this.f18759a.j)) {
                Logger.a("webTest", "onPageFinished(), url:" + str);
                super.onPageFinished(webView, str);
                Long l = (Long) this.f18759a.z.remove(str);
                if (l != null) {
                    BluedStatistics.b().a(str, SystemClock.uptimeMillis() - l.longValue());
                }
                if (this.f18759a.o != null) {
                    this.f18759a.o.a(str);
                }
                if (this.f18759a.m != null) {
                    this.f18759a.m.b(this.f18759a, str, !this.b);
                }
                if (!this.f18759a.w) {
                    this.f18759a.w = true;
                    BaseWebView baseWebView = this.f18759a;
                    baseWebView.a(baseWebView.t, this.f18759a.u);
                }
                this.f18759a.b();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Logger.a("webTest", "onPageStarted(), url:" + str);
            this.f18759a.t = str;
            super.onPageStarted(webView, str, bitmap);
            this.f18759a.z.put(str, Long.valueOf(SystemClock.uptimeMillis()));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Logger.a("webTest", "onReceivedError(), failingUrl:" + str2 + ", errorCode:" + i + ", description:" + str);
            Long l = (Long) this.f18759a.z.remove(str2);
            BluedStatistics.b().a(str2, l != null ? SystemClock.uptimeMillis() - l.longValue() : -1L, i, str);
            if (this.f18759a.m != null) {
                this.f18759a.m.a(this.f18759a, i, str, str2);
            }
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            Uri url;
            int i = 0;
            Logger.a("webTest", "onReceivedError(), request:" + webResourceRequest + ", error:" + webResourceError);
            String uri = (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) ? "" : url.toString();
            String str = "";
            if (webResourceError != null) {
                int errorCode = webResourceError.getErrorCode();
                CharSequence description = webResourceError.getDescription();
                i = errorCode;
                str = "";
                if (description != null) {
                    str = description.toString();
                    i = errorCode;
                }
            }
            long j = -1;
            Long l = (Long) this.f18759a.z.remove(uri);
            if (l != null) {
                j = SystemClock.uptimeMillis() - l.longValue();
            }
            BluedStatistics.b().a(uri, j, i, str);
            if (this.f18759a.m == null || !this.f18759a.t.equals(uri)) {
                return;
            }
            this.f18759a.m.a(this.f18759a, i, str, uri);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Logger.a("webTest", "shouldOverrideUrlLoading(), url:" + str);
            boolean a2 = this.f18759a.a(str);
            this.b = a2;
            if (this.f18759a.m != null) {
                this.f18759a.m.a(this.f18759a, str, !a2);
            }
            return a2;
        }
    }

    /* renamed from: com.blued.android.web.BaseWebView$5  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/web/BaseWebView$5.class */
    class AnonymousClass5 implements DownloadListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BaseWebView f18760a;

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (CommonTools.a(this.f18760a.j)) {
                Logger.a("webTest", "onDownloadStart(), url:" + str);
                this.f18760a.j.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            }
        }
    }

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/web/BaseWebView$InJavaScriptBluedNativeObject.class */
    final class InJavaScriptBluedNativeObject {
        InJavaScriptBluedNativeObject() {
        }

        @JavascriptInterface
        public void getH5ViewPagerInfo(int i, int i2, int i3, int i4) {
            BaseWebView baseWebView = BaseWebView.this;
            baseWebView.f = new RectPosition(i, i2, i3, i4);
        }

        @JavascriptInterface
        public void registerResumeJs(String str) {
            BaseWebView.this.q = str;
        }
    }

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/web/BaseWebView$InJavaScriptLocalObj.class */
    final class InJavaScriptLocalObj {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BaseWebView f18768a;

        @JavascriptInterface
        public void setOptionMenu(final String str) {
            this.f18768a.k.post(new Runnable() { // from class: com.blued.android.web.BaseWebView.InJavaScriptLocalObj.2
                @Override // java.lang.Runnable
                public void run() {
                    InJavaScriptLocalObj.this.f18768a.m.a(str);
                }
            });
        }

        @JavascriptInterface
        public void shareTo(final String str, String str2, final String str3, final String str4, final String str5) {
            if (this.f18768a.j == null) {
                return;
            }
            Runnable runnable = new Runnable() { // from class: com.blued.android.web.BaseWebView.InJavaScriptLocalObj.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        FragmentActivity activity = InJavaScriptLocalObj.this.f18768a.j.getActivity();
                        JSONObject jSONObject = new JSONObject(str);
                        if (StringUtils.d(jSONObject.getString("title"))) {
                            jSONObject.put("title", "No Title");
                        }
                        JSONArray jSONArray = jSONObject.getJSONArray("thumb");
                        String string = jSONArray.length() > 0 ? jSONArray.getString(0) : null;
                        String string2 = jSONObject.getString("description");
                        String string3 = jSONObject.getString("title");
                        String string4 = jSONObject.getString("url");
                        int intValue = Integer.valueOf(str3).intValue();
                        if (!StringUtils.d(str4)) {
                            string3 = str4;
                        } else if (StringUtils.d(string3)) {
                            string3 = !StringUtils.d(InJavaScriptLocalObj.this.f18768a.v) ? InJavaScriptLocalObj.this.f18768a.v : activity.getResources().getString(R.string.biao_common_share);
                        }
                        if (!StringUtils.d(str5)) {
                            string2 = str5;
                        } else if (StringUtils.d(string2) || string2.equalsIgnoreCase(string3)) {
                            string2 = InJavaScriptLocalObj.this.f18768a.t;
                        }
                        if (InJavaScriptLocalObj.this.f18768a.y == 11) {
                            string3 = activity.getResources().getString(2131892585);
                        }
                        ShareEntity a2 = ShareUtils.a().a(string, InJavaScriptLocalObj.this.f18768a.a(), string4, string3, string2, string2, intValue);
                        a2.o = jSONObject.getString("activity_secret_code");
                        a2.p = jSONObject.getString("activity_secret_text");
                        a2.q = jSONObject.getString("activity_secret_copy");
                        InJavaScriptLocalObj.this.f18768a.f18756c = jSONObject.getString("activity_secret_code");
                        InJavaScriptLocalObj.this.f18768a.d = jSONObject.getString("activity_secret_text");
                        InJavaScriptLocalObj.this.f18768a.e = jSONObject.getString("activity_secret_copy");
                        Log.v("drb", "secretCode:" + InJavaScriptLocalObj.this.f18768a.f18756c);
                        Log.v("drb", "secretText:" + InJavaScriptLocalObj.this.f18768a.d);
                        Log.v("drb", "secretCopy:" + InJavaScriptLocalObj.this.f18768a.e);
                        InJavaScriptLocalObj.this.f18768a.b.a(a2, InJavaScriptLocalObj.this.f18768a.f18755a);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            };
            if (this.f18768a.j instanceof BaseFragment) {
                ((BaseFragment) this.f18768a.j).postDelaySafeRunOnUiThread(runnable, 500L);
            }
            if (this.f18768a.j instanceof BaseDialogFragment) {
                ((BaseDialogFragment) this.f18768a.j).a(runnable, 500L);
            }
        }
    }

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/web/BaseWebView$RectPosition.class */
    class RectPosition {
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f18773c;
        private int d;
        private int e;

        public RectPosition(int i, int i2, int i3, int i4) {
            this.b = i2;
            this.f18773c = i;
            this.d = i3;
            this.e = i4;
        }
    }

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/web/BaseWebView$WebCallback.class */
    public interface WebCallback {
        void a(BaseWebView baseWebView, int i);

        void a(BaseWebView baseWebView, int i, String str, String str2);

        void a(BaseWebView baseWebView, String str);

        void a(BaseWebView baseWebView, String str, boolean z);

        void a(String str);

        boolean a(BaseWebView baseWebView, BluedUrlParser bluedUrlParser);

        void b(BaseWebView baseWebView, int i);

        void b(BaseWebView baseWebView, String str, boolean z);
    }

    private static boolean a(Context context, Uri uri, JSExecutor jSExecutor) {
        if (uri == null || jSExecutor == null) {
            return false;
        }
        String queryParameter = uri.getQueryParameter("action");
        if (TextUtils.isEmpty(queryParameter)) {
            return false;
        }
        if (!"remove_emotion".equals(queryParameter)) {
            if ("liveplay".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("lid");
                String queryParameter3 = uri.getQueryParameter("uid");
                String str = queryParameter3;
                if (!TextUtils.isEmpty(queryParameter3)) {
                    str = EncryptTool.a(queryParameter3);
                }
                String queryParameter4 = uri.getQueryParameter("from");
                String str2 = queryParameter4;
                if (TextUtils.isEmpty(queryParameter4)) {
                    str2 = s.B;
                }
                LiveRoomInfoChannel.a(context, new LiveRoomData(CommonTools.a(queryParameter2), 0, str2, str, "", "", 0));
                return true;
            }
            return false;
        }
        String queryParameter5 = uri.getQueryParameter("fun");
        if (TextUtils.isEmpty(queryParameter5)) {
            return false;
        }
        String queryParameter6 = uri.getQueryParameter("code");
        jSExecutor.a(jSExecutor.b(), "javascript:" + queryParameter5 + "('1', '" + queryParameter6 + "')");
        return false;
    }

    public static boolean a(Context context, String str, JSExecutor jSExecutor) {
        Logger.a("webTest", "preOverrideUrlLoad(), url:" + str);
        if (TextUtils.isEmpty(str) || CommonUrlHandler.a(context, str)) {
            return true;
        }
        Uri f = BluedURIRouter.a().f(str);
        if (a(context, f, jSExecutor) || BluedURIRouter.a().a(context, f)) {
            InstantLog.a("url_to_native", str);
            return true;
        } else if (str.startsWith("http://") || str.startsWith("https://") || str.startsWith("blued://") || str.startsWith("iblued://") || str.startsWith("www.")) {
            return false;
        } else {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            try {
                if (AppMethods.a(intent)) {
                    Logger.a("webTest", "system handle it: " + str);
                    context.startActivity(intent);
                    return true;
                }
                return true;
            } catch (SecurityException e) {
                e.printStackTrace();
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        boolean a2 = a(this.j.getActivity(), str, this.o);
        boolean z = a2;
        if (!a2) {
            z = b(str);
        }
        return z;
    }

    private boolean b(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        BluedUrlParser a2 = BluedUrlParser.a(str);
        int i = 0;
        if (a2 != null && CommonTools.a(this.j)) {
            String str9 = null;
            if ("changetitle".equals(a2.a())) {
                String str10 = null;
                if (a2.b() != null) {
                    str10 = a2.b().get("title");
                }
                if (TextUtils.isEmpty(str10)) {
                    return true;
                }
                this.v = str10;
                WebCallback webCallback = this.m;
                if (webCallback != null) {
                    webCallback.a(this, str10);
                    return true;
                }
                return true;
            } else if ("download".equals(a2.a())) {
                if (a2.b() != null) {
                    str9 = a2.b().get("opt");
                    str7 = a2.b().get("code");
                    str8 = a2.b().get("url");
                } else {
                    str7 = null;
                    str8 = null;
                }
                if ("emotionpack".equals(str9)) {
                    EmotionPackWebDownload.a(this.j.getActivity(), str7, this.o.b(), str9);
                    return true;
                } else if (TextUtils.isEmpty(str8)) {
                    return true;
                } else {
                    WebDownloaderManager.a().a(this.o.b(), str8, str9, str7);
                    return true;
                }
            } else if (!"jscb".equals(a2.a())) {
                if ("close".equals(a2.a())) {
                    this.j.getActivity().finish();
                    return false;
                } else if (!"webshare".equals(a2.a())) {
                    WebCallback webCallback2 = this.m;
                    boolean z = false;
                    if (webCallback2 != null) {
                        z = false;
                        if (webCallback2.a(this, a2)) {
                            z = true;
                        }
                    }
                    return z;
                } else {
                    InstantLog.a("url_to_native", str);
                    String str11 = this.t;
                    Map<String, String> b = a2.b();
                    String str12 = "";
                    if (b != null) {
                        String str13 = a2.b().get("type");
                        if (!StringUtils.d(str13)) {
                            i = Integer.valueOf(str13).intValue();
                        }
                        str3 = b.containsKey("title") ? b.get("title") : "";
                        str4 = b.containsKey("content") ? b.get("content") : "";
                        str2 = b.containsKey("to") ? b.get("to") : "";
                        if (b.containsKey("url")) {
                            str11 = b.get("url");
                        }
                        if (b.containsKey("src_url")) {
                            str12 = b.get("src_url");
                        }
                    } else {
                        str2 = "";
                        str3 = str2;
                        str4 = str3;
                        str12 = str4;
                        i = 0;
                    }
                    a(str2, str11, str3, str4, i, str12);
                    return true;
                }
            } else {
                if (a2.b() != null) {
                    str6 = a2.b().get("opt");
                    str5 = a2.b().get("fun");
                } else {
                    str5 = null;
                    str6 = null;
                }
                if (TextUtils.isEmpty(str6) || TextUtils.isEmpty(str5)) {
                    return true;
                }
                if ("register_download".equals(str6)) {
                    if (this.p == null) {
                        this.p = new DownloaderJSCallback(this.o);
                        WebDownloaderManager.a().a(this.p);
                    }
                    this.p.a(this.o.b(), str5);
                    return true;
                } else if ("emotion_list".equals(str6)) {
                    String f = EmotionManager.f();
                    JSExecutor jSExecutor = this.o;
                    jSExecutor.a(jSExecutor.b(), "javascript:" + str5 + "('" + f + "')");
                    return true;
                } else if ("get_uid".equals(str6)) {
                    String uid = UserInfo.getInstance().getLoginUserInfo().getUid();
                    JSExecutor jSExecutor2 = this.o;
                    jSExecutor2.a(jSExecutor2.b(), "javascript:" + str5 + "('" + uid + "')");
                    return true;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public WebView a() {
        return this.k;
    }

    public void a(final String str, final String str2) {
        boolean z = this.y == 9;
        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
            AppHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<JudgeWebUrlParseJson>>() { // from class: com.blued.android.web.BaseWebView.7
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<JudgeWebUrlParseJson> bluedEntityA) {
                    if (!CommonTools.a(BaseWebView.this.j) || bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                        return;
                    }
                    int i = bluedEntityA.data.get(0).verification;
                    if (BaseWebView.this.m != null) {
                        BaseWebView.this.m.b(BaseWebView.this, i);
                    }
                    if (i != -1) {
                        WebBlackListPreference.b(str);
                        WebBlackListPreference.b(str2);
                        return;
                    }
                    if (!WebBlackListPreference.c(str)) {
                        WebBlackListPreference.a(str);
                    }
                    if (WebBlackListPreference.c(str2)) {
                        return;
                    }
                    WebBlackListPreference.a(str2);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i, String str3) {
                    if (BaseWebView.this.m != null) {
                        BaseWebView.this.m.b(BaseWebView.this, 0);
                        return true;
                    }
                    return true;
                }
            }, z, str2, str);
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, String str5) {
        String str6;
        try {
            str6 = new URL(str2).getHost();
        } catch (Exception e) {
            str6 = d.f6907a;
        }
        String string = this.j.getActivity().getString(R.string.web_js_get_share_info);
        WebView webView = this.k;
        Tracker.loadUrl(webView, "javascript:" + string);
        WebView webView2 = this.k;
        Tracker.loadUrl(webView2, "javascript:getShareInfoFunction('" + str2 + "','" + str6 + "','" + str3 + "','" + str4 + "','" + str + "','" + i + "','" + str5 + "')");
    }

    public void b() {
        String string = this.j.getActivity().getString(2131892783);
        WebView webView = this.k;
        Tracker.loadUrl(webView, "javascript:" + string);
        Tracker.loadUrl(this.k, "javascript:getOptionMenuFunction()");
    }

    public void c() {
        Tracker.loadUrl(this.k, "javascript:getBannerPosition()");
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        WebView.HitTestResult hitTestResult;
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = new MenuItem.OnMenuItemClickListener() { // from class: com.blued.android.web.BaseWebView.6

            /* renamed from: com.blued.android.web.BaseWebView$6$1  reason: invalid class name */
            /* loaded from: source-5382004-dex2jar.jar:com/blued/android/web/BaseWebView$6$1.class */
            class AnonymousClass1 extends FileHttpResponseHandler {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ String f18762a;
                final /* synthetic */ String b;

                AnonymousClass1(String str, String str2) {
                    this.f18762a = str;
                    this.b = str2;
                }

                @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
                /* renamed from: a */
                public void onSuccess(File file) {
                    PermissionUtils.f(new PermissionCallbacks() { // from class: com.blued.android.web.BaseWebView.6.1.1

                        /* renamed from: com.blued.android.web.BaseWebView$6$1$1$1  reason: invalid class name and collision with other inner class name */
                        /* loaded from: source-5382004-dex2jar.jar:com/blued/android/web/BaseWebView$6$1$1$1.class */
                        class C02881 extends ThreadExecutor {
                            C02881(String str) {
                                super(str);
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public static /* synthetic */ void a(String str) {
                                Context d = AppInfo.d();
                                d.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + str)));
                                AppMethods.a((CharSequence) (AppInfo.d().getString(2131891268) + str));
                            }

                            @Override // com.blued.android.framework.pool.ThreadExecutor
                            public void execute() {
                                File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                                final String str = externalStoragePublicDirectory.getAbsolutePath() + File.separator + "blued" + File.separator + AnonymousClass1.this.f18762a;
                                FileUtils.a(AnonymousClass1.this.b, str, AnonymousClass1.this.f18762a);
                                AppInfo.n().post(new Runnable() { // from class: com.blued.android.web.-$$Lambda$BaseWebView$6$1$1$1$x722J3Sq6N_eRbwTFzOj0rWbdDo
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        BaseWebView.AnonymousClass6.AnonymousClass1.C02871.C02881.a(String.this);
                                    }
                                });
                            }
                        }

                        @Override // com.blued.android.framework.permission.PermissionCallbacks
                        public void U_() {
                            ThreadManager.a().a((ThreadExecutor) new C02881("CopyImageToPicDir"));
                        }

                        @Override // com.blued.android.framework.permission.PermissionCallbacks
                        public void a(String[] strArr) {
                        }
                    });
                }

                @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
                /* renamed from: a */
                public void onFailure(Throwable th, int i, File file) {
                    super.onFailure(th, i, file);
                    AppMethods.d(2131889003);
                }
            }

            @Override // android.view.MenuItem.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                Tracker.onMenuItemClick(menuItem);
                if (menuItem.getItemId() != 1 || TextUtils.isEmpty(BaseWebView.this.x)) {
                    return false;
                }
                String str = RecyclingUtils.a() + File.separator + "blued";
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdir();
                }
                String str2 = Md5.a(BaseWebView.this.x.toLowerCase().trim()) + ".jpg";
                String str3 = str + File.separator + str2;
                FileDownloader.a(BaseWebView.this.x, str3, new AnonymousClass1(str2, str3), null);
                return true;
            }
        };
        if (!(view instanceof WebView) || (hitTestResult = ((WebView) view).getHitTestResult()) == null) {
            return;
        }
        int type = hitTestResult.getType();
        if (type == 5 || type == 8) {
            this.x = hitTestResult.getExtra();
            contextMenu.add(0, 1, 0, 2131892791).setOnMenuItemClickListener(onMenuItemClickListener);
        }
    }
}
