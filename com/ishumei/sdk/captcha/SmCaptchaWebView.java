package com.ishumei.sdk.captcha;

import android.content.ClipDescription;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.applog.tracker.Tracker;
import com.umeng.analytics.pro.bh;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/sdk/captcha/SmCaptchaWebView.class */
public class SmCaptchaWebView extends WebView {
    private static final int MESSAGE_TIMEOUT = 1;
    public static final String MODE_ICON_SELECT = "icon_select";
    public static final String MODE_SELECT = "select";
    public static final String MODE_SEQ_SELECT = "seq_select";
    public static final String MODE_SLIDE = "slide";
    public static final String MODE_SPATIAL_SELECT = "spatial_select";
    public static int SMCAPTCHA_JS_INIT_ERROR = 2004;
    public static int SMCAPTCHA_JS_OPTION_ERROR = 2003;
    public static int SMCAPTCHA_JS_RESOURCE_ERROR = 2001;
    public static int SMCAPTCHA_JS_SERVER_ERROR = 2002;
    public static int SMCAPTCHA_SDK_NOLISTENER = 1004;
    public static int SMCAPTCHA_SDK_OPTION_EMPTY = 1001;
    public static int SMCAPTCHA_SDK_OPTION_NOAPPID = 1003;
    public static int SMCAPTCHA_SDK_OPTION_NOORG = 1002;
    public static int SMCAPTCHA_SUCCESS = 0;
    public static int SMCAPTCHA_WV_NETWORK_ERROR = 1005;
    public static int SMCAPTCHA_WV_RESULT_ERROR = 1006;
    private static final String SM_CA_HTML = "https://castatic.fengkongcloud.com/pr/v1.0.3/index.html";
    private static final int SM_CA_LOAD_HTML_RETRY = 2;
    private static final int SM_CA_LOAD_HTML_TIMEOUT = 10000;
    private static final String SM_CA_OS = "android";
    private static final String SM_CA_SDK_VERSION = "1.2.4";
    public static int SMcAPTCHA_JS_NETWORK_ERROR = 2005;
    private static final String TAG = "SmCaptchaWebView";
    private String compatHijackUrl;
    private ResultListener listener;
    private SmOption option;
    private int retry;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/sdk/captcha/SmCaptchaWebView$O0000O000000oO.class */
    public class O0000O000000oO extends WebViewClient {
        private final Timer O0000O000000oO = new Timer();
        private Handler O000O00000OoO = new HandlerC0291O0000O000000oO();
        final /* synthetic */ SmOption O000O00000o0O;

        /* renamed from: com.ishumei.sdk.captcha.SmCaptchaWebView$O0000O000000oO$O0000O000000oO  reason: collision with other inner class name */
        /* loaded from: source-7994992-dex2jar.jar:com/ishumei/sdk/captcha/SmCaptchaWebView$O0000O000000oO$O0000O000000oO.class */
        class HandlerC0291O0000O000000oO extends Handler {
            HandlerC0291O0000O000000oO() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != 1) {
                    return;
                }
                O0000O000000oO.this.O0000O000000oO();
            }
        }

        /* loaded from: source-7994992-dex2jar.jar:com/ishumei/sdk/captcha/SmCaptchaWebView$O0000O000000oO$O000O00000OoO.class */
        class O000O00000OoO extends TimerTask {
            O000O00000OoO() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Message message = new Message();
                message.what = 1;
                O0000O000000oO.this.O000O00000OoO.sendMessage(message);
                O0000O000000oO.this.O000O00000OoO();
            }
        }

        O0000O000000oO(SmOption smOption) {
            this.O000O00000o0O = smOption;
        }

        private void O0000O000000oO(TimerTask timerTask, long j, long j2) {
            synchronized (this.O0000O000000oO) {
                try {
                    this.O0000O000000oO.schedule(timerTask, j, j2);
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void O000O00000OoO() {
            synchronized (this.O0000O000000oO) {
                try {
                    this.O0000O000000oO.cancel();
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        }

        void O0000O000000oO() {
            if (SmCaptchaWebView.this.retry >= this.O000O00000o0O.getRetry()) {
                SmCaptchaWebView.this.notifyWebLoadError(SmCaptchaWebView.SMCAPTCHA_WV_NETWORK_ERROR);
                return;
            }
            Tracker.loadUrl(SmCaptchaWebView.this, "about:blank");
            SmCaptchaWebView.this.reloadCaptcha();
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            O000O00000OoO();
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (SmCaptchaWebView.this.compatHijackUrl == null || !SmCaptchaWebView.this.compatHijackUrl.equals(str)) {
                SmCaptchaWebView.this.compatHijackUrl = null;
                super.onPageStarted(webView, str, bitmap);
            }
            O0000O000000oO(new O000O00000OoO(), this.O000O00000o0O.getTimeout(), 1L);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (this.O000O00000o0O.getCaptchaHtml().equals(str2)) {
                O0000O000000oO();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.O000O00000o0O.getCaptchaHtml().equals(webResourceRequest.getUrl().toString())) {
                    O0000O000000oO();
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.O000O00000o0O.getCaptchaHtml().equals(webResourceRequest.getUrl().toString())) {
                    O0000O000000oO();
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.cancel();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if (Build.VERSION.SDK_INT < 21 || !SmCaptchaWebView.this.dispatchPersonalSchemeUrl(webView, webResourceRequest.getUrl())) {
                return super.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (SmCaptchaWebView.this.dispatchPersonalSchemeUrl(webView, Uri.parse(str))) {
                SmCaptchaWebView.this.compatHijackUrl = str;
                try {
                    SmCaptchaWebView.this.stopLoading();
                    return true;
                } catch (Throwable th) {
                    return true;
                }
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/sdk/captcha/SmCaptchaWebView$ResultListener.class */
    public interface ResultListener {
        void onError(int i);

        void onReady();

        void onSuccess(CharSequence charSequence, boolean z);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/sdk/captcha/SmCaptchaWebView$SmOption.class */
    public static class SmOption {
        private String appId;
        private String cdnHost;
        private String channel;
        private String deviceId;
        private Map<String, String> extData;
        private Map<String, Object> extOption;
        private String host;
        private String organization;
        private String tipMessage;
        private String captchaHtml = SmCaptchaWebView.SM_CA_HTML;
        private String mode = SmCaptchaWebView.MODE_SLIDE;
        private boolean https = true;
        private int retry = 2;
        private int timeout = 10000;

        private String genCustomHtml() {
            boolean isEmpty = TextUtils.isEmpty(this.cdnHost);
            String str = SmCaptchaWebView.SM_CA_HTML;
            if (!isEmpty) {
                try {
                    str = SmCaptchaWebView.SM_CA_HTML.replace(new URL(this.captchaHtml).getHost(), this.cdnHost);
                } catch (Throwable th) {
                    str = SmCaptchaWebView.SM_CA_HTML;
                }
            }
            return isHttps() ? str.replaceFirst("http://", "https://") : str.replaceFirst("https://", "http://");
        }

        public String getAppId() {
            return this.appId;
        }

        String getCaptchaHtml() {
            return !TextUtils.equals(this.captchaHtml, SmCaptchaWebView.SM_CA_HTML) ? this.captchaHtml : genCustomHtml();
        }

        public String getChannel() {
            return this.channel;
        }

        public String getDeviceId() {
            return this.deviceId;
        }

        public Map<String, String> getExtData() {
            return this.extData;
        }

        public Map<String, Object> getExtOption() {
            return this.extOption;
        }

        public String getHost() {
            return this.host;
        }

        public String getMode() {
            return this.mode;
        }

        public String getOrganization() {
            return this.organization;
        }

        public int getRetry() {
            return this.retry;
        }

        public int getTimeout() {
            return this.timeout;
        }

        public String getTipMessage() {
            return this.tipMessage;
        }

        public boolean isHttps() {
            return (TextUtils.isEmpty(this.captchaHtml) || TextUtils.equals(this.captchaHtml, SmCaptchaWebView.SM_CA_HTML)) ? this.https : this.captchaHtml.startsWith("https://");
        }

        public void setAppId(String str) {
            this.appId = str;
        }

        public void setCaptchaHtml(String str) {
            this.captchaHtml = str;
        }

        public void setCdnHost(String str) {
            this.cdnHost = str;
        }

        public void setChannel(String str) {
            this.channel = str;
        }

        public void setDeviceId(String str) {
            this.deviceId = str;
        }

        public void setExtData(Map<String, String> map) {
            this.extData = map;
        }

        public void setExtOption(Map<String, Object> map) {
            this.extOption = map;
        }

        public void setHost(String str) {
            this.host = str;
        }

        public void setHttps(boolean z) {
            this.https = z;
        }

        public void setMode(String str) {
            this.mode = str;
        }

        public void setOrganization(String str) {
            this.organization = str;
        }

        public void setRetry(int i) {
            this.retry = i;
        }

        public void setTimeout(int i) {
            this.timeout = i;
        }

        public void setTipMessage(String str) {
            this.tipMessage = str;
        }
    }

    public SmCaptchaWebView(Context context) {
        super(context);
        this.retry = 0;
    }

    public SmCaptchaWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.retry = 0;
    }

    public SmCaptchaWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.retry = 0;
    }

    public SmCaptchaWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.retry = 0;
    }

    public SmCaptchaWebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i, z);
        this.retry = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dispatchPersonalSchemeUrl(WebView webView, Uri uri) {
        if (TextUtils.equals(uri.getScheme(), "shumei")) {
            if (!TextUtils.equals(uri.getAuthority(), "onresult")) {
                if (TextUtils.equals(uri.getAuthority(), "requestnativeparams")) {
                    Tracker.loadUrl(webView, getInjectJSdeliverNativeParams());
                    return true;
                }
                return true;
            }
            try {
                JSONObject jSONObject = new JSONObject(uri.getQueryParameter("data"));
                String string = jSONObject.getString("method");
                if (O000O00000OoO.O0000O000000oO(string, "onError")) {
                    notifyWebLoadError(jSONObject.getInt("code"));
                } else if (O000O00000OoO.O0000O000000oO(string, "onSuccess")) {
                    onSuccess(jSONObject.getString("rid"), jSONObject.getBoolean("pass"));
                } else if (O000O00000OoO.O0000O000000oO(string, "onReady")) {
                    onReady();
                }
                return true;
            } catch (JSONException e) {
                e.getMessage();
                notifyWebLoadError(SMCAPTCHA_WV_RESULT_ERROR);
                return true;
            }
        }
        return false;
    }

    private String getInjectJSdeliverNativeParams() {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("organization", this.option.getOrganization());
            hashMap.put("appId", this.option.getAppId());
            hashMap.put("channel", this.option.getChannel());
            hashMap.put("mode", this.option.getMode());
            hashMap.put("https", Boolean.valueOf(this.option.isHttps()));
            if (this.option.getExtOption() != null) {
                for (Map.Entry<String, Object> entry : this.option.getExtOption().entrySet()) {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
            }
            if (!TextUtils.isEmpty(this.option.getHost())) {
                hashMap.put("domains", Collections.singletonList(this.option.getHost()));
            }
            HashMap hashMap2 = new HashMap();
            if (this.option.getExtData() != null) {
                for (Map.Entry<String, String> entry2 : this.option.getExtData().entrySet()) {
                    hashMap2.put(entry2.getKey(), entry2.getValue());
                }
            }
            if (O000O00000OoO.O000O00000OoO(this.option.getDeviceId())) {
                hashMap2.put("deviceId", this.option.getDeviceId());
            }
            hashMap2.put(bh.x, "android");
            hashMap2.put("sdkver", "1.2.4");
            hashMap.put("data", hashMap2);
            if (!TextUtils.isEmpty(this.option.getTipMessage())) {
                HashMap hashMap3 = new HashMap();
                hashMap3.put("sliderPlaceholder", this.option.getTipMessage());
                hashMap.put("tipsMessage", hashMap3);
            }
            String replaceAll = O000O00000o0O.O0000O000000oO((Map<?, ?>) hashMap).toString().replaceAll("'", "\\\\'");
            return "javascript:deliverNativeParams('" + replaceAll + "')";
        } catch (Exception e) {
            return "";
        }
    }

    private void initStyle() {
        getSettings().setJavaScriptEnabled(true);
        getSettings().setUseWideViewPort(false);
        getSettings().setSupportZoom(true);
        getSettings().setLoadWithOverviewMode(false);
        getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        getSettings().setCacheMode(2);
        getSettings().setAllowFileAccess(true);
        getSettings().setNeedInitialFocus(false);
        getSettings().setBuiltInZoomControls(false);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        getSettings().setLoadsImagesAutomatically(true);
        getSettings().setUseWideViewPort(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyWebLoadError(int i) {
        loadDefaultHtml();
        ResultListener resultListener = this.listener;
        if (resultListener != null) {
            resultListener.onError(i);
        }
    }

    private void onReady() {
        ResultListener resultListener = this.listener;
        if (resultListener != null) {
            resultListener.onReady();
        }
    }

    private void onSuccess(String str, boolean z) {
        ResultListener resultListener = this.listener;
        if (resultListener != null) {
            resultListener.onSuccess(str, z);
        }
    }

    public void disableCaptcha() {
        Tracker.loadUrl(this, "javascript:SMCaptcha.disableCaptcha();");
    }

    public void enableCaptcha() {
        Tracker.loadUrl(this, "javascript:SMCaptcha.enableCaptcha();");
    }

    public int initWithOption(SmOption smOption, ResultListener resultListener) {
        if (smOption == null) {
            return SMCAPTCHA_SDK_OPTION_EMPTY;
        }
        if (O000O00000OoO.O0000O000000oO(smOption.getOrganization())) {
            return SMCAPTCHA_SDK_OPTION_NOORG;
        }
        if (O000O00000OoO.O0000O000000oO(smOption.getAppId())) {
            return SMCAPTCHA_SDK_OPTION_NOAPPID;
        }
        this.option = smOption;
        if (resultListener == null) {
            return SMCAPTCHA_SDK_NOLISTENER;
        }
        if (smOption.getMode() == null) {
            smOption.setMode(MODE_SLIDE);
        }
        smOption.setHttps(smOption.getCaptchaHtml().startsWith("https"));
        this.listener = resultListener;
        initStyle();
        setWebViewClient(new O0000O000000oO(smOption));
        com.ishumei.sdk.captcha.O0000O000000oO.O0000O000000oO(smOption.getCaptchaHtml());
        reloadCaptcha();
        return SMCAPTCHA_SUCCESS;
    }

    public void loadDefaultHtml() {
        Tracker.loadData(this, com.ishumei.sdk.captcha.O0000O000000oO.O0000O000000oO(), ClipDescription.MIMETYPE_TEXT_HTML, "utf-8");
    }

    public void reloadCaptcha() {
        Tracker.loadUrl(this, this.option.getCaptchaHtml());
        this.retry++;
    }
}
