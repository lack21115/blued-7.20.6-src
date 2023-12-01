package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.bytedance.applog.tracker.Tracker;
import com.bytedance.sdk.openadsdk.R;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.constants.EventConstants;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/compliance/AppPrivacyPolicyActivity.class */
public class AppPrivacyPolicyActivity extends Activity {
    private long b;
    private String h;
    private long hj;
    private ImageView mb;
    private WebView ox;

    public static void mb(Activity activity, long j) {
        Intent intent = new Intent(activity, AppPrivacyPolicyActivity.class);
        intent.putExtra("app_info_id", j);
        activity.startActivity(intent);
    }

    private void mb(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface(Context.ACCESSIBILITY_SERVICE);
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
        }
    }

    private boolean mb() {
        this.b = getIntent().getLongExtra("app_info_id", 0L);
        com.ss.android.downloadlib.addownload.model.ox mb = b.mb().mb(this.b);
        if (mb == null) {
            return false;
        }
        this.hj = mb.ox;
        String str = mb.lz;
        this.h = str;
        if (TextUtils.isEmpty(str)) {
            this.h = x.lz().optString("ad_privacy_backup_url", "https://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html");
            return true;
        }
        return true;
    }

    private void ox() {
        this.mb = (ImageView) findViewById(R.id.iv_privacy_back);
        this.ox = (WebView) findViewById(R.id.privacy_webview);
        this.mb.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                h.mb(EventConstants.Refer.LP_APP_PRIVACY_CLICK_CLOSE, AppPrivacyPolicyActivity.this.hj);
                AppPrivacyPolicyActivity.this.finish();
            }
        });
        WebSettings settings = this.ox.getSettings();
        settings.setDefaultFontSize(16);
        settings.setCacheMode(-1);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        this.ox.setWebViewClient(new WebViewClient() { // from class: com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.2
            private boolean mb(Uri uri) {
                String scheme = uri.getScheme();
                return ("http".equals(scheme) || "https".equals(scheme)) ? false : true;
            }

            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                if (Build.VERSION.SDK_INT < 26) {
                    return super.onRenderProcessGone(webView, renderProcessGoneDetail);
                }
                if (renderProcessGoneDetail.didCrash()) {
                    com.ss.android.downloadlib.utils.x.mb("The WebView rendering process crashed!");
                    if (webView != null) {
                        ((ViewGroup) webView.getParent()).removeView(webView);
                        webView.destroy();
                        return true;
                    }
                    return true;
                }
                com.ss.android.downloadlib.utils.x.mb("System killed the WebView rendering process to reclaim memory. Recreating...");
                if (webView != null) {
                    ((ViewGroup) webView.getParent()).removeView(webView);
                    webView.destroy();
                    return true;
                }
                return true;
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                return mb(webResourceRequest.getUrl());
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return mb(Uri.parse(str));
            }
        });
        mb(this.ox);
        this.ox.setScrollBarStyle(0);
        Tracker.loadUrl(this.ox, this.h);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        h.mb(EventConstants.Refer.LP_APP_PRIVACY_CLICK_CLOSE, this.hj);
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ttdownloader_activity_app_privacy_policy);
        if (mb()) {
            ox();
        } else {
            com.ss.android.socialbase.appdownloader.b.mb((Activity) this);
        }
    }
}
