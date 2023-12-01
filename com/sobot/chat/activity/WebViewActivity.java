package com.sobot.chat.activity;

import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.SobotUIConfig;
import com.sobot.chat.activity.base.SobotBaseActivity;
import com.sobot.chat.utils.CommonUtils;
import com.sobot.chat.utils.LogUtils;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.StringUtils;
import com.sobot.chat.utils.ToastUtil;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/activity/WebViewActivity.class */
public class WebViewActivity extends SobotBaseActivity implements View.OnClickListener {
    private static final int REQUEST_CODE_ALBUM = 273;
    private ProgressBar mProgressBar;
    private WebView mWebView;
    private Button sobot_btn_reconnect;
    private RelativeLayout sobot_rl_net_error;
    private TextView sobot_textReConnect;
    private TextView sobot_txt_loading;
    private ImageView sobot_webview_copy;
    private ImageView sobot_webview_forward;
    private ImageView sobot_webview_goback;
    private ImageView sobot_webview_reload;
    private LinearLayout sobot_webview_toolsbar;
    private ValueCallback<Uri> uploadMessage;
    private ValueCallback<Uri[]> uploadMessageAboveL;
    private String mUrl = "";
    private boolean isUrlOrText = true;

    /* JADX INFO: Access modifiers changed from: private */
    public void chooseAlbumPic() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Image Chooser"), 273);
    }

    private void copyUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            LogUtils.i("API是大于11");
            ClipboardManager clipboardManager = (ClipboardManager) getApplicationContext().getSystemService(Context.CLIPBOARD_SERVICE);
            clipboardManager.setText(str);
            clipboardManager.getText();
        } else {
            LogUtils.i("API是小于11");
            android.text.ClipboardManager clipboardManager2 = (android.text.ClipboardManager) getApplicationContext().getSystemService(Context.CLIPBOARD_SERVICE);
            clipboardManager2.setText(str);
            clipboardManager2.getText();
        }
        ToastUtil.showToast(getApplicationContext(), CommonUtils.getResString(this, "sobot_ctrl_v_success"));
    }

    private void initWebView() {
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
            } catch (Exception e) {
            }
        }
        this.mWebView.setDownloadListener(new DownloadListener() { // from class: com.sobot.chat.activity.WebViewActivity.1
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.addFlags(268435456);
                intent.setData(Uri.parse(str));
                WebViewActivity.this.startActivity(intent);
                WebViewActivity.this.finish();
            }
        });
        this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        this.mWebView.getSettings().setDefaultFontSize(16);
        this.mWebView.getSettings().setTextZoom(100);
        this.mWebView.getSettings().setAllowFileAccess(false);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.getSettings().setCacheMode(-1);
        this.mWebView.getSettings().setDomStorageEnabled(true);
        this.mWebView.getSettings().setLoadsImagesAutomatically(true);
        this.mWebView.getSettings().setBlockNetworkImage(false);
        this.mWebView.getSettings().setSavePassword(false);
        if (Build.VERSION.SDK_INT >= 21) {
            this.mWebView.getSettings().setMixedContentMode(0);
        }
        this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        this.mWebView.removeJavascriptInterface(Context.ACCESSIBILITY_SERVICE);
        this.mWebView.removeJavascriptInterface("accessibilityTraversal");
        this.mWebView.getSettings().setDatabaseEnabled(true);
        this.mWebView.getSettings().setAppCacheEnabled(true);
        this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.sobot.chat.activity.WebViewActivity.2
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                WebViewActivity.this.sobot_webview_goback.setEnabled(WebViewActivity.this.mWebView.canGoBack());
                WebViewActivity.this.sobot_webview_forward.setEnabled(WebViewActivity.this.mWebView.canGoForward());
                if (WebViewActivity.this.isUrlOrText && !WebViewActivity.this.mUrl.replace("http://", "").replace("https://", "").equals(webView.getTitle()) && SobotUIConfig.sobot_webview_title_display) {
                    WebViewActivity.this.setTitle(webView.getTitle());
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return false;
            }
        });
        this.mWebView.setWebChromeClient(new WebChromeClient() { // from class: com.sobot.chat.activity.WebViewActivity.3
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                Tracker.onProgressChanged(this, webView, i);
                if (i > 0 && i < 100) {
                    WebViewActivity.this.mProgressBar.setVisibility(0);
                    WebViewActivity.this.mProgressBar.setProgress(i);
                } else if (i == 100) {
                    WebViewActivity.this.mProgressBar.setVisibility(8);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                LogUtils.i("网页--title---：" + str);
                if (WebViewActivity.this.isUrlOrText && !WebViewActivity.this.mUrl.replace("http://", "").replace("https://", "").equals(str) && SobotUIConfig.sobot_webview_title_display) {
                    WebViewActivity.this.setTitle(str);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                WebViewActivity.this.uploadMessageAboveL = valueCallback;
                WebViewActivity.this.chooseAlbumPic();
                return true;
            }
        });
    }

    private void resetViewDisplay() {
        if (CommonUtils.isNetWorkConnected(getApplicationContext())) {
            this.mWebView.setVisibility(0);
            this.sobot_webview_toolsbar.setVisibility(0);
            this.sobot_rl_net_error.setVisibility(8);
            return;
        }
        this.mWebView.setVisibility(8);
        this.sobot_webview_toolsbar.setVisibility(8);
        this.sobot_rl_net_error.setVisibility(0);
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public int getContentViewResId() {
        return getResLayoutId("sobot_activity_webview");
    }

    public Context getContext() {
        return this;
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initBundleData(Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("url");
            this.mUrl = string;
            this.isUrlOrText = StringUtils.isURL(string);
        } else if (getIntent() == null || TextUtils.isEmpty(getIntent().getStringExtra("url"))) {
        } else {
            String stringExtra = getIntent().getStringExtra("url");
            this.mUrl = stringExtra;
            this.isUrlOrText = StringUtils.isURL(stringExtra);
        }
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initData() {
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initView() {
        setTitle("");
        showLeftMenu(getResDrawableId("sobot_btn_back_selector"), "", true);
        this.mWebView = (WebView) findViewById(getResId("sobot_mWebView"));
        this.mProgressBar = (ProgressBar) findViewById(getResId("sobot_loadProgress"));
        this.sobot_rl_net_error = (RelativeLayout) findViewById(getResId("sobot_rl_net_error"));
        this.sobot_webview_toolsbar = (LinearLayout) findViewById(getResId("sobot_webview_toolsbar"));
        Button button = (Button) findViewById(getResId("sobot_btn_reconnect"));
        this.sobot_btn_reconnect = button;
        button.setText(ResourceUtils.getResString(this, "sobot_reunicon"));
        this.sobot_btn_reconnect.setOnClickListener(this);
        TextView textView = (TextView) findViewById(getResId("sobot_textReConnect"));
        this.sobot_textReConnect = textView;
        textView.setText(ResourceUtils.getResString(this, "sobot_try_again"));
        this.sobot_txt_loading = (TextView) findViewById(getResId("sobot_txt_loading"));
        this.sobot_webview_goback = (ImageView) findViewById(getResId("sobot_webview_goback"));
        this.sobot_webview_forward = (ImageView) findViewById(getResId("sobot_webview_forward"));
        this.sobot_webview_reload = (ImageView) findViewById(getResId("sobot_webview_reload"));
        this.sobot_webview_copy = (ImageView) findViewById(getResId("sobot_webview_copy"));
        this.sobot_webview_goback.setOnClickListener(this);
        this.sobot_webview_forward.setOnClickListener(this);
        this.sobot_webview_reload.setOnClickListener(this);
        this.sobot_webview_copy.setOnClickListener(this);
        this.sobot_webview_goback.setEnabled(false);
        this.sobot_webview_forward.setEnabled(false);
        displayInNotch(this.mWebView);
        resetViewDisplay();
        initWebView();
        if (this.isUrlOrText) {
            Tracker.loadUrl(this.mWebView, this.mUrl);
            this.sobot_webview_copy.setVisibility(0);
        } else {
            String str = "<!DOCTYPE html>\n<html>\n    <head>\n        <meta charset=\"utf-8\">\n        <title></title>\n        <style>\n            img{\n                width: auto;\n                height:auto;\n                max-height: 100%;\n                max-width: 100%;\n            }\n        </style>\n    </head>\n    <body>" + this.mUrl + "  </body>\n</html>";
            this.mUrl = str;
            Tracker.loadDataWithBaseURL(this.mWebView, "about:blank", str.replace("<p> </p>", "<br/>").replace("<p></p>", "<br/>"), ClipDescription.MIMETYPE_TEXT_HTML, "utf-8", null);
        }
        LogUtils.i("webViewActivity---" + this.mUrl);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 273) {
            if (this.uploadMessage == null && this.uploadMessageAboveL == null) {
                return;
            }
            if (i2 != -1) {
                ValueCallback<Uri> valueCallback = this.uploadMessage;
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                    this.uploadMessage = null;
                }
                ValueCallback<Uri[]> valueCallback2 = this.uploadMessageAboveL;
                if (valueCallback2 != null) {
                    valueCallback2.onReceiveValue(null);
                    this.uploadMessageAboveL = null;
                }
            }
            if (i2 == -1) {
                Uri data = (i == 273 && intent != null) ? intent.getData() : null;
                ValueCallback<Uri> valueCallback3 = this.uploadMessage;
                if (valueCallback3 != null) {
                    valueCallback3.onReceiveValue(data);
                    this.uploadMessage = null;
                }
                ValueCallback<Uri[]> valueCallback4 = this.uploadMessageAboveL;
                if (valueCallback4 != null) {
                    valueCallback4.onReceiveValue(new Uri[]{data});
                    this.uploadMessageAboveL = null;
                }
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        WebView webView = this.mWebView;
        if (webView != null && webView.canGoBack()) {
            this.mWebView.goBack();
            return;
        }
        super.onBackPressed();
        finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view == this.sobot_btn_reconnect) {
            if (TextUtils.isEmpty(this.mUrl)) {
                return;
            }
            resetViewDisplay();
        } else if (view == this.sobot_webview_forward) {
            this.mWebView.goForward();
        } else if (view == this.sobot_webview_goback) {
            this.mWebView.goBack();
        } else if (view == this.sobot_webview_reload) {
            this.mWebView.reload();
        } else if (view == this.sobot_webview_copy) {
            copyUrl(this.mUrl);
        }
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.removeAllViews();
            ViewGroup viewGroup = (ViewGroup) this.mWebView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.mWebView);
            }
            this.mWebView.destroy();
        }
        super.onDestroy();
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void onLeftMenuClick(View view) {
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.onPause();
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.onResume();
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("url", this.mUrl);
        super.onSaveInstanceState(bundle);
    }
}
