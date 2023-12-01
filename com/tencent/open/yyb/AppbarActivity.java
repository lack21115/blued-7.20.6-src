package com.tencent.open.yyb;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ZoomButtonsController;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.bytedance.applog.tracker.Tracker;
import com.igexin.assist.util.AssistUtils;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzoneShare;
import com.tencent.open.a.f;
import com.tencent.open.utils.SystemUtils;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/yyb/AppbarActivity.class */
public class AppbarActivity extends Activity implements View.OnClickListener {
    private static final int FLOATING_DIALOG_HEIGHT = 100;
    public static final String MYAPP_CACHE_PATH = "/tencent/tassistant";
    private static final String TAG = "openSDK_LOG.AppbarActivity";
    private static final String UA_PREFIX = "qqdownloader/";
    private static final String WEBVIEW_PATH = "/webview_cache";
    private static ArrayList<String> specialModel;
    private String appid;
    private AppbarJsBridge jsBridge;
    private final DownloadListener mDownloadListener = new DownloadListener() { // from class: com.tencent.open.yyb.AppbarActivity.5
        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            f.a(AppbarActivity.TAG, "-->(AppbarActivity)onDownloadStart : url = " + str);
            try {
                AppbarActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Exception e) {
                f.b(AppbarActivity.TAG, "-->(AppbarActivity)onDownloadStart : activity aciton_view not found.");
            }
            QQToken token = AppbarActivity.this.getToken();
            if (token != null) {
                com.tencent.open.yyb.a.a(token.getAppId(), BasicPushStatus.SUCCESS_CODE, "SDK.APPBAR.HOME ACTION");
            }
        }
    };
    private MoreFloatingDialog mFloatingDialog;
    protected ProgressDialog mProgressDialog;
    private LinearLayout mRootView;
    private TitleBar mTitleBar;
    private QQToken mToken;
    private com.tencent.open.c.b mWebView;
    private ShareModel model;
    private Tencent tencent;
    private int titlebarTop;
    private String url;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/yyb/AppbarActivity$a.class */
    public interface a {
        void a(byte[] bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/yyb/AppbarActivity$b.class */
    public static class b extends AsyncTask<String, Void, byte[]> {

        /* renamed from: a  reason: collision with root package name */
        private a f38301a;

        public b(a aVar) {
            this.f38301a = aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(byte[] bArr) {
            super.onPostExecute(bArr);
            this.f38301a.a(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public byte[] doInBackground(String... strArr) {
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(strArr[0]).openConnection();
                    httpURLConnection.setConnectTimeout(5000);
                    try {
                        httpURLConnection.setRequestMethod("GET");
                        try {
                            InputStream inputStream = httpURLConnection.getInputStream();
                            try {
                                if (httpURLConnection.getResponseCode() != 200) {
                                    return null;
                                }
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read == -1) {
                                        byteArrayOutputStream.close();
                                        inputStream.close();
                                        return byteArrayOutputStream.toByteArray();
                                    }
                                    byteArrayOutputStream.write(bArr, 0, read);
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                                return null;
                            }
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            return null;
                        }
                    } catch (ProtocolException e3) {
                        e3.printStackTrace();
                        return null;
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                    return null;
                }
            } catch (MalformedURLException e5) {
                e5.printStackTrace();
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/yyb/AppbarActivity$c.class */
    public class c extends WebChromeClient {
        private c() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            Tracker.onProgressChanged(this, webView, i);
            super.onProgressChanged(webView, i);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            AppbarActivity.this.mTitleBar.setTitle(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/yyb/AppbarActivity$d.class */
    public class d extends WebViewClient {
        private d() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            AppbarActivity.this.setSupportZoom(true);
            AppbarActivity.this.jsBridge.ready();
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            AppbarActivity.this.setSupportZoom(false);
            if (str.startsWith("http")) {
                return;
            }
            str.startsWith("https");
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            f.a(AppbarActivity.TAG, "-->(AppbarDialog)shouldOverrideUrlLoading : url = " + str);
            boolean z = false;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (str.startsWith("http") || str.startsWith("https")) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            if (str.startsWith(AppbarJsBridge.JS_BRIDGE_SCHEME)) {
                AppbarActivity.this.jsBridge.invoke(str);
                return true;
            } else if (str.equals("about:blank;") || str.equals(com.anythink.core.common.res.d.f6907a)) {
                if (Build.VERSION.SDK_INT < 11) {
                    z = true;
                }
                return z;
            } else {
                return false;
            }
        }
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        specialModel = arrayList;
        arrayList.add("MT870");
        specialModel.add("XT910");
        specialModel.add("XT928");
        specialModel.add("MT917");
        specialModel.add("Lenovo A60");
    }

    private String buildTransaction(String str) {
        if (str == null) {
            return String.valueOf(System.currentTimeMillis());
        }
        return str + System.currentTimeMillis();
    }

    private void createViews() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.mWebView.setLayoutParams(layoutParams);
        this.mRootView = new LinearLayout(this);
        layoutParams.gravity = 17;
        this.mRootView.setLayoutParams(layoutParams);
        this.mRootView.setOrientation(1);
        TitleBar titleBar = new TitleBar(this);
        this.mTitleBar = titleBar;
        titleBar.getBackBtn().setOnClickListener(this);
        this.mTitleBar.getSharBtn().setOnClickListener(this);
        this.mRootView.addView(this.mTitleBar);
        this.mRootView.addView(this.mWebView);
        setContentView(this.mRootView);
    }

    private String getCommonPath(String str) {
        String commonRootDir = getCommonRootDir();
        String str2 = commonRootDir;
        if (!TextUtils.isEmpty(str)) {
            str2 = commonRootDir + str;
        }
        return getPath(str2, false);
    }

    private String getCommonRootDir() {
        File filesDir;
        String str;
        if (isSDCardExistAndCanWrite()) {
            str = Environment.getExternalStorageDirectory().getPath() + MYAPP_CACHE_PATH;
        } else {
            if (getFilesDir() == null) {
                return "";
            }
            str = filesDir.getAbsolutePath() + MYAPP_CACHE_PATH;
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private MoreFloatingDialog getFloatingDialg() {
        if (this.mFloatingDialog == null) {
            MoreFloatingDialog moreFloatingDialog = new MoreFloatingDialog(this);
            this.mFloatingDialog = moreFloatingDialog;
            moreFloatingDialog.setCanceledOnTouchOutside(true);
            this.mFloatingDialog.getQQItem().setOnClickListener(this);
            this.mFloatingDialog.getQzoneItem().setOnClickListener(this);
        }
        return this.mFloatingDialog;
    }

    private String getPath(String str, boolean z) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
            if (z) {
                try {
                    new File(str + File.separator + MediaStore.MEDIA_IGNORE_FILENAME).createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return file.getAbsolutePath();
    }

    private Tencent getTencent() {
        if (this.tencent == null) {
            this.tencent = Tencent.createInstance(this.appid, this);
        }
        return this.tencent;
    }

    private int getTitbarTop() {
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels - rect.height();
        this.titlebarTop = height;
        return height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QQToken getToken() {
        if (this.mToken == null) {
            this.mToken = getTencent().getQQToken();
        }
        return this.mToken;
    }

    private String getWebViewCacheDir() {
        return getCommonPath(WEBVIEW_PATH);
    }

    private void initViews() {
        WebSettings settings = this.mWebView.getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setUserAgentString(settings.getUserAgentString() + BridgeUtil.SPLIT_MARK + UA_PREFIX + this.jsBridge.getVersion() + "/sdk");
        settings.setJavaScriptEnabled(true);
        Class<?> cls = settings.getClass();
        try {
            Method method = cls.getMethod("setPluginsEnabled", Boolean.TYPE);
            if (method != null) {
                method.invoke(settings, true);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            try {
                Method method2 = cls.getMethod("setDomStorageEnabled", Boolean.TYPE);
                if (method2 != null) {
                    method2.invoke(settings, true);
                }
            } catch (SecurityException e2) {
                e2.printStackTrace();
            }
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e3) {
        }
        settings.setAppCachePath(getWebViewCacheDir());
        settings.setDatabasePath(getWebViewCacheDir());
        settings.setDatabaseEnabled(true);
        settings.setAppCacheEnabled(true);
        if (supportWebViewFullScreen()) {
            settings.setUseWideViewPort(true);
            if (Build.VERSION.SDK_INT >= 7) {
                try {
                    cls.getMethod("setLoadWithOverviewMode", Boolean.TYPE).invoke(settings, true);
                } catch (Exception e4) {
                }
            }
            if (SystemUtils.isSupportMultiTouch()) {
                try {
                    if (SystemUtils.getAndroidSDKVersion() < 11) {
                        Field declaredField = WebView.class.getDeclaredField("mZoomButtonsController");
                        declaredField.setAccessible(true);
                        ZoomButtonsController zoomButtonsController = new ZoomButtonsController(this.mWebView);
                        zoomButtonsController.getZoomControls().setVisibility(8);
                        declaredField.set(this.mWebView, zoomButtonsController);
                    } else {
                        this.mWebView.getSettings().getClass().getMethod("setDisplayZoomControls", Boolean.TYPE).invoke(this.mWebView.getSettings(), false);
                    }
                } catch (Exception e5) {
                }
            }
        }
        this.mWebView.setWebViewClient(new d());
        this.mWebView.setWebChromeClient(new c());
        this.mWebView.setDownloadListener(this.mDownloadListener);
        this.mWebView.loadUrl(this.url);
    }

    private boolean isSDCardExistAndCanWrite() {
        try {
            if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
                return Environment.getExternalStorageDirectory().canWrite();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSupportZoom(boolean z) {
        com.tencent.open.c.b bVar = this.mWebView;
        if (bVar != null) {
            bVar.getSettings().setSupportZoom(z);
        }
    }

    private void shareToWX(boolean z) {
        f.a(TAG, "-->shareToWX : wx_appid = wx8e8dc60535c9cd93");
        if (TextUtils.isEmpty(this.model.f38307c)) {
            return;
        }
        showProgressDialog(this, "", "");
        new b(new a() { // from class: com.tencent.open.yyb.AppbarActivity.4
            @Override // com.tencent.open.yyb.AppbarActivity.a
            public void a(byte[] bArr) {
                AppbarActivity.this.mProgressDialog.dismiss();
            }
        }).execute(this.model.f38307c);
    }

    private boolean supportWebViewFullScreen() {
        String str = Build.MODEL;
        return (str.contains(AssistUtils.BRAND_VIVO) || specialModel.contains(str)) ? false : true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    public void login() {
        f.b(TAG, "-->login : activity~~~");
        getTencent().login(this, "all", new IUiListener() { // from class: com.tencent.open.yyb.AppbarActivity.1
            @Override // com.tencent.tauth.IUiListener
            public void onCancel() {
                f.b(AppbarActivity.TAG, "-->(AppbarJsBridge)openLoginActivity onCancel");
                AppbarActivity.this.jsBridge.responseFail(AppbarJsBridge.CALLBACK_LOGIN, 0, null, -2);
            }

            @Override // com.tencent.tauth.IUiListener
            public void onComplete(Object obj) {
                f.b(AppbarActivity.TAG, "-->(AppbarJsBridge)openLoginActivity onComplete");
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.optInt("ret", -1) != 0) {
                    AppbarActivity.this.jsBridge.responseFail(AppbarJsBridge.CALLBACK_LOGIN, 0, null, -5);
                    return;
                }
                try {
                    String string = jSONObject.getString("openid");
                    String string2 = jSONObject.getString("access_token");
                    jSONObject.getString("expires_in");
                    String appId = AppbarActivity.this.getToken().getAppId();
                    AppbarActivity appbarActivity = AppbarActivity.this;
                    com.tencent.open.yyb.a.a(appbarActivity, appbarActivity.mWebView.getUrl(), string, string2, appId);
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("logintype", "SSO");
                        jSONObject2.put("openid", string);
                        jSONObject2.put("accesstoken", string2);
                        AppbarActivity.this.jsBridge.response(AppbarJsBridge.CALLBACK_LOGIN, 0, null, jSONObject2.toString());
                        Intent intent = new Intent();
                        intent.putExtra(Constants.LOGIN_INFO, jSONObject.toString());
                        AppbarActivity.this.setResult(-1, intent);
                    } catch (JSONException e) {
                        AppbarActivity.this.jsBridge.responseFail(AppbarJsBridge.CALLBACK_LOGIN, 0, null, -5);
                        f.b(AppbarActivity.TAG, "-->(AppbarJsBridge)openLoginActivity onComplete: put keys callback failed.");
                    }
                } catch (JSONException e2) {
                    AppbarActivity.this.jsBridge.responseFail(AppbarJsBridge.CALLBACK_LOGIN, 0, null, -5);
                    f.b(AppbarActivity.TAG, "-->(AppbarJsBridge)openLoginActivity onComplete: get keys failed.");
                }
            }

            @Override // com.tencent.tauth.IUiListener
            public void onError(UiError uiError) {
                f.b(AppbarActivity.TAG, "-->(AppbarJsBridge)openLoginActivity onError" + uiError.errorMessage);
                AppbarActivity.this.jsBridge.responseFail(AppbarJsBridge.CALLBACK_LOGIN, 0, null, -5);
            }
        });
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        MoreFloatingDialog floatingDialg = getFloatingDialg();
        if (floatingDialg == null || !floatingDialg.isShowing()) {
            super.onBackPressed();
        } else {
            floatingDialg.dismiss();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        MoreFloatingDialog floatingDialg = getFloatingDialg();
        if (view == this.mTitleBar.getSharBtn()) {
            this.jsBridge.clickCallback();
        } else if (view == floatingDialg.getQQItem()) {
            shareToQQ();
        } else if (view == floatingDialg.getQzoneItem()) {
            shareToQzone();
        } else if (view == floatingDialg.getWXItem()) {
            shareToWX();
        } else if (view == floatingDialg.getTimelineItem()) {
            shareToTimeline();
        } else if (view == this.mTitleBar.getBackBtn()) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.appid = getIntent().getStringExtra("appid");
        this.url = getIntent().getStringExtra("url");
        f.a(TAG, "-->(AppbarActivity)onCreate : appid = " + this.appid + " url = " + this.url);
        com.tencent.open.c.b bVar = new com.tencent.open.c.b(this);
        this.mWebView = bVar;
        this.jsBridge = new AppbarJsBridge(this, bVar);
        createViews();
        initViews();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.tencent.open.c.b bVar = this.mWebView;
        if (bVar != null) {
            bVar.removeAllViews();
            this.mWebView.setVisibility(8);
            this.mWebView.stopLoading();
            this.mWebView.clearHistory();
            this.mWebView.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        MoreFloatingDialog floatingDialg = getFloatingDialg();
        if (floatingDialg == null || !floatingDialg.isShowing()) {
            return;
        }
        floatingDialg.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public void setAppbarTitle(String str) {
        this.mTitleBar.setTitle(str);
    }

    public void setShareModel(ShareModel shareModel) {
        this.model = shareModel;
    }

    public void setShareVisibility(boolean z) {
        this.mTitleBar.getSharBtn().setVisibility(z ? 0 : 4);
    }

    public void shareToQQ() {
        final QQToken token = getToken();
        if (token == null) {
            return;
        }
        QQShare qQShare = new QQShare(this, token);
        Bundle bundle = new Bundle();
        bundle.putString("title", this.model.f38306a);
        bundle.putString("targetUrl", this.model.d);
        bundle.putString("summary", this.model.b);
        bundle.putString("imageUrl", this.model.f38307c);
        f.a(TAG, "-->(AppbarActivity)shareToQQ : model.mTitle = " + this.model.f38306a);
        f.a(TAG, "-->(AppbarActivity)shareToQQ : model.mTargetUrl = " + this.model.d);
        f.a(TAG, "-->(AppbarActivity)shareToQQ : model.mDescription = " + this.model.b);
        f.a(TAG, "-->(AppbarActivity)shareToQQ : model.mIconUrl = " + this.model.f38307c);
        qQShare.shareToQQ(this, bundle, new IUiListener() { // from class: com.tencent.open.yyb.AppbarActivity.2
            @Override // com.tencent.tauth.IUiListener
            public void onCancel() {
                f.b(AppbarActivity.TAG, "-->(AppbarActivity)shareToQQ onCancel");
                AppbarActivity.this.jsBridge.responseShareFail(1);
            }

            @Override // com.tencent.tauth.IUiListener
            public void onComplete(Object obj) {
                f.b(AppbarActivity.TAG, "-->(AppbarActivity)shareToQQ onComplete");
                AppbarActivity.this.jsBridge.responseShare(1);
                com.tencent.open.yyb.a.a(token.getAppId(), "400", "SDK.APPBAR.HOME.SHARE.QQ");
            }

            @Override // com.tencent.tauth.IUiListener
            public void onError(UiError uiError) {
                f.b(AppbarActivity.TAG, "-->(AppbarActivity)shareToQQ onError" + uiError.errorMessage);
                AppbarActivity.this.jsBridge.responseShareFail(1);
            }
        });
        com.tencent.open.yyb.a.a(token.getAppId(), BasicPushStatus.SUCCESS_CODE, "SDK.APPBAR.HOME.SHARE.QQ");
    }

    public void shareToQzone() {
        final QQToken token = getToken();
        if (token == null) {
            return;
        }
        QzoneShare qzoneShare = new QzoneShare(this, token);
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 1);
        bundle.putString("title", this.model.f38306a);
        bundle.putString("summary", this.model.b);
        bundle.putString("targetUrl", this.model.d);
        ArrayList<String> arrayList = new ArrayList<>();
        f.a(TAG, "-->shareToQzone : mIconUrl = " + this.model.f38307c);
        arrayList.add(this.model.f38307c);
        bundle.putStringArrayList("imageUrl", arrayList);
        qzoneShare.shareToQzone(this, bundle, new IUiListener() { // from class: com.tencent.open.yyb.AppbarActivity.3
            @Override // com.tencent.tauth.IUiListener
            public void onCancel() {
                f.b(AppbarActivity.TAG, "-->(AppbarActivity)shareToQzone onCancel");
                AppbarActivity.this.jsBridge.responseShareFail(2);
            }

            @Override // com.tencent.tauth.IUiListener
            public void onComplete(Object obj) {
                f.b(AppbarActivity.TAG, "-->(AppbarActivity)shareToQzone onComplete");
                AppbarActivity.this.jsBridge.responseShare(2);
                com.tencent.open.yyb.a.a(token.getAppId(), "400", "SDK.APPBAR.HOME.SHARE.QZ");
            }

            @Override // com.tencent.tauth.IUiListener
            public void onError(UiError uiError) {
                f.b(AppbarActivity.TAG, "-->(AppbarActivity)shareToQzone onError" + uiError.errorMessage);
                AppbarActivity.this.jsBridge.responseShareFail(2);
            }
        });
        com.tencent.open.yyb.a.a(token.getAppId(), BasicPushStatus.SUCCESS_CODE, "SDK.APPBAR.HOME.SHARE.QZ");
    }

    public void shareToTimeline() {
        shareToWX(true);
    }

    public void shareToWX() {
        shareToWX(false);
    }

    public void showFloatingDialog() {
        MoreFloatingDialog floatingDialg = getFloatingDialg();
        floatingDialg.show();
        Window window = floatingDialg.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 48;
        attributes.y = getTitbarTop() + this.mTitleBar.getHeight();
        Display defaultDisplay = floatingDialg.getWindow().getWindowManager().getDefaultDisplay();
        attributes.height = floatingDialg.dip2px(100.0f);
        attributes.width = ((int) (defaultDisplay.getWidth() * 0.95d)) / 2;
        attributes.x = attributes.width / 2;
        f.b(TAG, "-->(AppbarDialog)showFloatingDialog : params.x = " + attributes.x);
        window.setAttributes(attributes);
    }

    protected void showProgressDialog(Context context, String str, String str2) {
        String str3 = str;
        if (TextUtils.isEmpty(str)) {
            str3 = "请稍候";
        }
        String str4 = str2;
        if (TextUtils.isEmpty(str2)) {
            str4 = "正在加载...";
        }
        ProgressDialog show = ProgressDialog.show(context, str3, str4);
        this.mProgressDialog = show;
        show.setCancelable(true);
    }
}
