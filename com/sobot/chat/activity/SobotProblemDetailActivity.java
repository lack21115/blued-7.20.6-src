package com.sobot.chat.activity;

import android.content.ClipDescription;
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
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.SobotApi;
import com.sobot.chat.activity.base.SobotBaseHelpCenterActivity;
import com.sobot.chat.api.model.Information;
import com.sobot.chat.api.model.StDocModel;
import com.sobot.chat.api.model.StHelpDocModel;
import com.sobot.chat.core.channel.SobotMsgManager;
import com.sobot.chat.listener.SobotFunctionType;
import com.sobot.chat.utils.ChatUtils;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.SobotOption;
import com.sobot.chat.utils.ToastUtil;
import com.sobot.chat.utils.ZhiChiConstant;
import com.sobot.network.http.callback.StringResultCallBack;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/activity/SobotProblemDetailActivity.class */
public class SobotProblemDetailActivity extends SobotBaseHelpCenterActivity implements View.OnClickListener {
    public static final String DEFAULT_STYLE = "<style>*,body,html,div,p,img{border:0;margin:0;padding:0;} </style>";
    public static final String EXTRA_KEY_DOC = "extra_key_doc";
    private static final int REQUEST_CODE_ALBUM = 273;
    private View mBottomBtn;
    private StDocModel mDoc;
    private TextView mProblemTitle;
    private WebView mWebView;
    private TextView tvOnlineService;
    private TextView tv_sobot_layout_online_service;
    private TextView tv_sobot_layout_online_tel;
    private ValueCallback<Uri> uploadMessage;
    private ValueCallback<Uri[]> uploadMessageAboveL;

    /* JADX INFO: Access modifiers changed from: private */
    public void chooseAlbumPic() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Image Chooser"), 273);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void imgReset() {
        Tracker.loadUrl(this.mWebView, "javascript:(function(){var objs = document.getElementsByTagName('img'); for(var i=0;i<objs.length;i++)  {var img = objs[i];       img.style.maxWidth = '100%'; img.style.height = 'auto';  }})()");
    }

    private void initWebView() {
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
            } catch (Exception e) {
            }
        }
        this.mWebView.setDownloadListener(new DownloadListener() { // from class: com.sobot.chat.activity.SobotProblemDetailActivity.2
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.addFlags(268435456);
                intent.setData(Uri.parse(str));
                SobotProblemDetailActivity.this.startActivity(intent);
            }
        });
        this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        this.mWebView.getSettings().setDefaultFontSize(14);
        this.mWebView.getSettings().setTextZoom(100);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.getSettings().setAllowFileAccess(false);
        this.mWebView.getSettings().setCacheMode(-1);
        this.mWebView.setBackgroundColor(0);
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
        this.mWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.sobot.chat.activity.SobotProblemDetailActivity.3
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                SobotProblemDetailActivity.this.imgReset();
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (SobotOption.hyperlinkListener == null) {
                    return SobotOption.newHyperlinkListener != null && SobotOption.newHyperlinkListener.onUrlClick(SobotProblemDetailActivity.this.getSobotBaseActivity(), str);
                }
                SobotOption.hyperlinkListener.onUrlClick(str);
                return true;
            }
        });
        this.mWebView.setWebChromeClient(new WebChromeClient() { // from class: com.sobot.chat.activity.SobotProblemDetailActivity.4
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                Tracker.onProgressChanged(this, webView, i);
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                SobotProblemDetailActivity.this.uploadMessageAboveL = valueCallback;
                SobotProblemDetailActivity.this.chooseAlbumPic();
                return true;
            }
        });
    }

    public static Intent newIntent(Context context, Information information, StDocModel stDocModel) {
        Intent intent = new Intent(context, SobotProblemDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(ZhiChiConstant.SOBOT_BUNDLE_INFO, information);
        intent.putExtra(ZhiChiConstant.SOBOT_BUNDLE_INFORMATION, bundle);
        intent.putExtra(EXTRA_KEY_DOC, stDocModel);
        return intent;
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public int getContentViewResId() {
        return getResLayoutId("sobot_activity_problem_detail");
    }

    @Override // com.sobot.chat.activity.base.SobotBaseHelpCenterActivity, com.sobot.chat.activity.base.SobotBaseActivity
    public void initBundleData(Bundle bundle) {
        super.initBundleData(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.mDoc = (StDocModel) intent.getSerializableExtra(EXTRA_KEY_DOC);
        }
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initData() {
        SobotMsgManager.getInstance(getApplicationContext()).getZhiChiApi().getHelpDocByDocId(this, this.mInfo.getApp_key(), this.mDoc.getDocId(), new StringResultCallBack<StHelpDocModel>() { // from class: com.sobot.chat.activity.SobotProblemDetailActivity.1
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str) {
                ToastUtil.showToast(SobotProblemDetailActivity.this.getApplicationContext(), str);
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(StHelpDocModel stHelpDocModel) {
                SobotProblemDetailActivity.this.mProblemTitle.setText(stHelpDocModel.getQuestionTitle());
                String answerDesc = stHelpDocModel.getAnswerDesc();
                if (TextUtils.isEmpty(answerDesc)) {
                    return;
                }
                String str = "<!DOCTYPE html>\n<html>\n    <head>\n        <meta charset=\"utf-8\">\n        <title></title>\n        <style>\n body{color:" + ResourceUtils.getColorById(SobotProblemDetailActivity.this, "sobot_common_wenzi_black") + ";}\n            img{\n                width: auto;\n                height:auto;\n                max-height: 100%;\n                max-width: 100%;\n            }\n        </style>\n    </head>\n    <body>" + answerDesc + "  </body>\n</html>";
                Tracker.loadDataWithBaseURL(SobotProblemDetailActivity.this.mWebView, "about:blank", SobotProblemDetailActivity.DEFAULT_STYLE + str.replace("<p> </p>", "<br/>").replace("<p></p>", "<br/>"), ClipDescription.MIMETYPE_TEXT_HTML, "utf-8", null);
            }
        });
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initView() {
        showLeftMenu(getResDrawableId("sobot_btn_back_grey_selector"), "", true);
        setTitle(getResString("sobot_problem_detail_title"));
        this.mBottomBtn = findViewById(getResId("ll_bottom"));
        this.tv_sobot_layout_online_service = (TextView) findViewById(getResId("tv_sobot_layout_online_service"));
        this.tv_sobot_layout_online_tel = (TextView) findViewById(getResId("tv_sobot_layout_online_tel"));
        this.mProblemTitle = (TextView) findViewById(getResId("sobot_text_problem_title"));
        this.mWebView = (WebView) findViewById(getResId("sobot_webView"));
        TextView textView = (TextView) findViewById(getResId("tv_sobot_layout_online_service"));
        this.tvOnlineService = textView;
        textView.setText(ResourceUtils.getResString(this, "sobot_help_center_online_service"));
        this.tv_sobot_layout_online_service.setOnClickListener(this);
        this.tv_sobot_layout_online_tel.setOnClickListener(this);
        if (this.mInfo == null || TextUtils.isEmpty(this.mInfo.getHelpCenterTelTitle()) || TextUtils.isEmpty(this.mInfo.getHelpCenterTel())) {
            this.tv_sobot_layout_online_tel.setVisibility(8);
        } else {
            this.tv_sobot_layout_online_tel.setVisibility(0);
            this.tv_sobot_layout_online_tel.setText(this.mInfo.getHelpCenterTelTitle());
        }
        initWebView();
        displayInNotch(this.mWebView);
        displayInNotch(this.mProblemTitle);
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
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view == this.tv_sobot_layout_online_service) {
            SobotApi.startSobotChat(getApplicationContext(), this.mInfo);
        }
        if (view != this.tv_sobot_layout_online_tel || TextUtils.isEmpty(this.mInfo.getHelpCenterTel())) {
            return;
        }
        if (SobotOption.functionClickListener != null) {
            SobotOption.functionClickListener.onClickFunction(getSobotBaseActivity(), SobotFunctionType.ZC_PhoneCustomerService);
        }
        ChatUtils.callUp(this.mInfo.getHelpCenterTel(), getSobotBaseActivity());
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
}
