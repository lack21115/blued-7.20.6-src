package com.soft.blued.ui.discover.fragment;

import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import com.app.share.ShareUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.provider.ProviderHolder;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.utils.LocaleUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.web.BluedWebView;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.views.WebBtmOptions;
import com.blued.android.web.SimpleWebCallBack;
import com.bytedance.applog.tracker.Tracker;
import com.google.common.net.HttpHeaders;
import com.huawei.hms.framework.common.ContainerUtils;
import com.igexin.push.core.b;
import com.soft.blued.R;
import com.soft.blued.app.InitTaskUtil;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.discover.fragment.YouZanDetailFragment;
import com.soft.blued.ui.discover.model.YouZanLoginFailModel;
import com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.StringUtils;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.youzan.androidsdk.YouzanSDK;
import com.youzan.androidsdk.YouzanToken;
import com.youzan.androidsdk.YzLoginCallback;
import com.youzan.androidsdk.event.AbsAuthEvent;
import com.youzan.androidsdk.event.AbsCheckAuthMobileEvent;
import com.youzan.androidsdk.event.AbsChooserEvent;
import com.youzan.androidsdk.event.AbsShareEvent;
import com.youzan.androidsdk.model.goods.GoodsShareModel;
import com.youzan.androidsdkx5.YouzanBrowser;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/discover/fragment/YouZanDetailFragment.class */
public class YouZanDetailFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    public View f16142a;
    public Context b;

    /* renamed from: c  reason: collision with root package name */
    public YouzanBrowser f16143c;
    public View d;
    public String e;
    public String f;
    public ShareOptionRecyclerAdapter.ShareOptionsItemClickListener g;
    private WebBtmOptions h;
    private ImageView i;
    private View j;
    private ImageView k;
    private ImageView l;
    private TextView m;
    private String n = "https://web.bldimg.com/cblued/static/61511555575852_.pic.1d8nopvtobuess.jpg";
    private Map<String, String> o = new ArrayMap();
    private boolean p = false;
    private View q;
    private View r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.discover.fragment.YouZanDetailFragment$3  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/discover/fragment/YouZanDetailFragment$3.class */
    public class AnonymousClass3 implements YzLoginCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f16146a;

        AnonymousClass3(String str) {
            this.f16146a = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(YouzanToken youzanToken) {
            YouZanDetailFragment.this.f16143c.sync(youzanToken);
        }

        @Override // com.youzan.androidsdk.YzLoginCallback
        public void onFail(String str) {
            BluedStatistics.c().a("YZ_LOGIN_CB", 0L, -1, str);
            try {
                YouZanLoginFailModel youZanLoginFailModel = (YouZanLoginFailModel) AppInfo.f().fromJson(str, (Class<Object>) YouZanLoginFailModel.class);
                if (youZanLoginFailModel == null || youZanLoginFailModel.code != 200 || youZanLoginFailModel.data == null) {
                    return;
                }
                YouZanDetailFragment.this.a(this.f16146a, youZanLoginFailModel.data.yz_open_id);
            } catch (Exception e) {
            }
        }

        @Override // com.youzan.androidsdk.YzLoginCallback
        public void onSuccess(final YouzanToken youzanToken) {
            YouZanDetailFragment.this.f16143c.post(new Runnable() { // from class: com.soft.blued.ui.discover.fragment.-$$Lambda$YouZanDetailFragment$3$JtPPozGSpFBow-ltWNhl02GQ2Ww
                @Override // java.lang.Runnable
                public final void run() {
                    YouZanDetailFragment.AnonymousClass3.this.a(youzanToken);
                }
            });
            BluedStatistics.c().a("YZ_LOGIN_CB", 0L, 0, (String) null);
            YouZanDetailFragment.this.a(this.f16146a, youzanToken.getYzOpenId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Tracker.onClick(view);
        this.f16143c.reload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        return BluedWebView.a(getActivity(), str, new SimpleWebCallBack());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        Tracker.onClick(view);
        this.f16143c.sharePage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        boolean z;
        String[] split;
        String[] split2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] split3 = str.split(ContainerUtils.FIELD_DELIMITER);
        int length = split3.length;
        int i = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (true) {
            z = z3;
            if (i >= length) {
                break;
            }
            String str2 = split3[i];
            boolean z4 = z2;
            if (str2 != null) {
                z4 = z2;
                if (!TextUtils.isEmpty(str2)) {
                    z4 = z2;
                    if (str2.contains("bg_color")) {
                        if (str2.split("=").length >= 2) {
                            int parseColor = Color.parseColor("#" + split2[1]);
                            Logger.c("ljx_color", new Object[]{"bg_color=#" + split2[1]});
                            this.q.setBackground(new ColorDrawable(parseColor));
                        }
                        z4 = true;
                    }
                }
            }
            boolean z5 = z;
            if (str2 != null) {
                z5 = z;
                if (!TextUtils.isEmpty(str2)) {
                    z5 = z;
                    if (str2.contains("font_color")) {
                        if (str2.split("=").length >= 2) {
                            int parseColor2 = Color.parseColor("#" + split[1]);
                            Logger.c("ljx_color", new Object[]{"font_color=#" + split[1]});
                            this.m.setTextColor(parseColor2);
                        }
                        z5 = true;
                    }
                }
            }
            i++;
            z2 = z4;
            z3 = z5;
        }
        if (!z2) {
            Logger.c("ljx_color", new Object[]{"恢复原始背景色"});
            this.q.setBackgroundColor(BluedSkinUtils.a(this.b, 2131101780));
        }
        if (z) {
            return;
        }
        Logger.c("ljx_color", new Object[]{"恢复原始字体颜色"});
        this.m.setTextColor(BluedSkinUtils.a(this.b, 2131102254));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        Tracker.onClick(view);
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str) {
        ArrayList arrayList = new ArrayList(Arrays.asList(this.b.getResources().getStringArray(R.array.youzan_uid_whitelist)));
        Uri parse = Uri.parse(str);
        boolean z = false;
        for (int i = 0; i < arrayList.size(); i++) {
            z = z || (!TextUtils.isEmpty(parse.getHost()) && parse.getHost().contains(((String) arrayList.get(i)).toLowerCase()));
        }
        return (StringUtils.d(str) || str.toLowerCase().contains("uid") || !z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(String str) {
        String str2;
        String str3;
        String sb;
        if (StringUtils.d(str)) {
            return str;
        }
        if (str.contains("#") && str.split("#").length == 2) {
            str3 = str.split("#")[0];
            str2 = str.split("#")[1];
        } else {
            str2 = "";
            str3 = str;
        }
        String str4 = str3;
        try {
            if (str3.contains("?")) {
                String str5 = str3;
                StringBuilder sb2 = new StringBuilder();
                String str6 = str3;
                sb2.append(str3);
                String str7 = str3;
                sb2.append(ContainerUtils.FIELD_DELIMITER);
                String str8 = str3;
                sb = sb2.toString();
            } else {
                StringBuilder sb3 = new StringBuilder();
                String str9 = str3;
                sb3.append(str3);
                String str10 = str3;
                sb3.append("?");
                String str11 = str3;
                sb = sb3.toString();
            }
            String str12 = sb;
            StringBuilder sb4 = new StringBuilder();
            String str13 = sb;
            sb4.append(sb);
            String str14 = sb;
            sb4.append("uid=");
            String str15 = sb;
            sb4.append(AesCrypto.a(UserInfo.getInstance().getLoginUserInfo().getUid()));
            str4 = sb;
            str4 = sb4.toString();
        } catch (Exception e) {
        }
        if (StringUtils.d(str2)) {
            return str4;
        }
        return str4 + "#" + str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        Tracker.onClick(view);
        onBackPressed();
    }

    public static void show(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("KEY_URL", str);
        TerminalActivity.a(bundle);
        TerminalActivity.d(context, YouZanDetailFragment.class, bundle);
    }

    public void a() {
        this.q = this.f16142a.findViewById(R.id.title_bg);
        View findViewById = this.f16142a.findViewById(R.id.title_btm_line);
        this.r = findViewById;
        findViewById.setVisibility(8);
        this.q.setPadding(0, StatusBarHelper.a(this.b), 0, 0);
        ImageView imageView = (ImageView) this.f16142a.findViewById(2131363120);
        this.i = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.discover.fragment.-$$Lambda$YouZanDetailFragment$Sq6dgjj-6qjHjX2OAZhyF3IemuI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YouZanDetailFragment.this.d(view);
            }
        });
        View findViewById2 = this.f16142a.findViewById(R.id.ctt_close_layout);
        this.j = findViewById2;
        findViewById2.setVisibility(0);
        ImageView imageView2 = (ImageView) this.f16142a.findViewById(R.id.ctt_close);
        this.k = imageView2;
        imageView2.setVisibility(0);
        this.k.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.discover.fragment.-$$Lambda$YouZanDetailFragment$5U45OMLI_zn7GM13wUlXmVMs6R8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YouZanDetailFragment.this.c(view);
            }
        });
        ImageView imageView3 = (ImageView) this.f16142a.findViewById(2131363126);
        this.l = imageView3;
        imageView3.setVisibility(0);
        this.l.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.discover.fragment.-$$Lambda$YouZanDetailFragment$XeAHBZt189NUmKA_Vv84wPyXiIE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YouZanDetailFragment.this.b(view);
            }
        });
        this.m = (TextView) this.f16142a.findViewById(2131363108);
        View findViewById3 = this.f16142a.findViewById(R.id.ll_page_not_found);
        this.d = findViewById3;
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.discover.fragment.-$$Lambda$YouZanDetailFragment$agV8jW079YBjjQPGQ0MaEfGxSEo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YouZanDetailFragment.this.a(view);
            }
        });
        YouzanBrowser youzanBrowser = (YouzanBrowser) this.f16142a.findViewById(R.id.youzan_browser);
        this.f16143c = youzanBrowser;
        youzanBrowser.setWebChromeClient(new WebChromeClient() { // from class: com.soft.blued.ui.discover.fragment.YouZanDetailFragment.1
            @Override // com.tencent.smtt.sdk.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                Tracker.onProgressChanged(this, webView, i);
                super.onProgressChanged(webView, i);
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                YouZanDetailFragment.this.m.setText(str);
            }
        });
        this.f16143c.setWebViewClient(new WebViewClient() { // from class: com.soft.blued.ui.discover.fragment.YouZanDetailFragment.2
            @Override // com.tencent.smtt.sdk.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                YouZanDetailFragment.this.f = str;
                YouZanDetailFragment.this.p = false;
            }

            @Override // com.tencent.smtt.sdk.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                YouZanDetailFragment.this.f16143c.setVisibility(0);
            }

            @Override // com.tencent.smtt.sdk.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
            }

            @Override // com.tencent.smtt.sdk.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }

            @Override // com.tencent.smtt.sdk.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                boolean a2 = YouZanDetailFragment.this.a(str);
                YouZanDetailFragment.this.b(str);
                if (a2) {
                    return true;
                }
                if (!YouZanDetailFragment.this.c(str) || YouZanDetailFragment.this.p) {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                String d = YouZanDetailFragment.this.d(str);
                YouZanDetailFragment.this.onBackPressed();
                YouZanDetailFragment.this.f16143c.loadUrl(d, YouZanDetailFragment.this.o);
                return true;
            }
        });
    }

    public void a(String str, String str2) {
        LoginRegisterHttpUtils.a(str, str2, new BluedUIHttpResponse(getFragmentActive()) { // from class: com.soft.blued.ui.discover.fragment.YouZanDetailFragment.4
            public void onUIUpdate(BluedEntity bluedEntity) {
            }
        }, (IRequestHost) getFragmentActive());
    }

    public void b() {
        String b = EncryptTool.b(UserInfo.getInstance().getLoginUserInfo().uid);
        YouzanSDK.yzlogin(b, UserInfo.getInstance().getLoginUserInfo().avatar, "", UserInfo.getInstance().getLoginUserInfo().name, "", new AnonymousClass3(b));
    }

    public void c() {
        try {
            if (this.f16143c != null) {
                this.f16143c.subscribe(new AbsCheckAuthMobileEvent() { // from class: com.soft.blued.ui.discover.fragment.YouZanDetailFragment.5
                    @Override // com.youzan.androidsdk.event.AbsCheckAuthMobileEvent, com.youzan.androidsdk.event.Event
                    public String subscribe() {
                        return super.subscribe();
                    }
                });
                this.f16143c.subscribe(new AbsAuthEvent() { // from class: com.soft.blued.ui.discover.fragment.YouZanDetailFragment.6
                    @Override // com.youzan.androidsdk.event.AbsAuthEvent
                    public void call(Context context, boolean z) {
                        BluedStatistics.c().a("YZ_LOGIN_CB", 0L, 0, "need login");
                        YouZanDetailFragment.this.b();
                    }
                });
                this.g = new ShareOptionRecyclerAdapter.ShareOptionsItemClickListener() { // from class: com.soft.blued.ui.discover.fragment.YouZanDetailFragment.7
                    @Override // com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter.ShareOptionsItemClickListener
                    public void onItemClick(int i) {
                        if (i == 2131887355) {
                            InstantLog.b("web_page_options_click", 0);
                            if (Build.VERSION.SDK_INT < 11 || Build.VERSION.SDK_INT == 18) {
                                ((ClipboardManager) YouZanDetailFragment.this.getActivity().getSystemService(Context.CLIPBOARD_SERVICE)).setText(YouZanDetailFragment.this.f);
                            } else {
                                try {
                                    ((android.content.ClipboardManager) YouZanDetailFragment.this.getActivity().getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("simple url", YouZanDetailFragment.this.f));
                                } catch (Exception e) {
                                }
                            }
                            AppMethods.d((int) R.string.copy_done);
                        } else if (i != 2131891181) {
                            if (i != 2131891459) {
                                return;
                            }
                            InstantLog.b("web_page_options_click", 2);
                            YouZanDetailFragment.this.f16143c.reload();
                        } else {
                            InstantLog.b("web_page_options_click", 1);
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setData(Uri.parse(YouZanDetailFragment.this.f));
                            if (AppUtils.a(intent)) {
                                YouZanDetailFragment.this.startActivity(intent);
                            }
                        }
                    }
                };
                this.h = new WebBtmOptions(getActivity(), new View.OnClickListener() { // from class: com.soft.blued.ui.discover.fragment.YouZanDetailFragment.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        InstantLog.b("web_page_options_click", 3);
                    }
                });
                this.f16143c.subscribe(new AbsShareEvent() { // from class: com.soft.blued.ui.discover.fragment.YouZanDetailFragment.9
                    @Override // com.youzan.androidsdk.event.AbsShareEvent
                    public void call(Context context, GoodsShareModel goodsShareModel) {
                        com.soft.blued.utils.Logger.c("YouZanDetailFragment", "share event", goodsShareModel == null ? b.l : goodsShareModel.getTitle());
                        if (goodsShareModel == null || StringUtils.d(goodsShareModel.getLink())) {
                            AppMethods.a(YouZanDetailFragment.this.b.getResources().getString(R.string.can_not_share_this_page));
                            return;
                        }
                        String d = BluedHttpUrl.d(goodsShareModel.getLink());
                        String string = StringUtils.d(goodsShareModel.getTitle()) ? YouZanDetailFragment.this.b.getResources().getString(R.string.yz_share_default_title) : goodsShareModel.getTitle();
                        String string2 = StringUtils.d(goodsShareModel.getDesc()) ? YouZanDetailFragment.this.b.getResources().getString(R.string.yz_share_default_desc) : goodsShareModel.getDesc();
                        YouZanDetailFragment.this.h.a(ShareUtils.a().a(StringUtils.d(goodsShareModel.getImgUrl()) ? YouZanDetailFragment.this.n : goodsShareModel.getImgUrl(), YouZanDetailFragment.this.f16143c, d, string, string2, string2, 0), YouZanDetailFragment.this.g);
                    }
                });
                this.f16143c.subscribe(new AbsChooserEvent() { // from class: com.soft.blued.ui.discover.fragment.YouZanDetailFragment.10
                    @Override // com.youzan.androidsdk.event.AbsChooserEvent
                    public void call(Context context, Intent intent, int i) throws ActivityNotFoundException {
                        YouZanDetailFragment.this.startActivityForResult(intent, i);
                    }
                });
                this.o.put(HttpHeaders.ACCEPT_LANGUAGE, LocaleUtils.b());
                String b = ProviderHolder.a().e().b();
                if (!TextUtils.isEmpty(b)) {
                    this.o.put("X-CLIENT-COLOR", b);
                }
                try {
                    this.o.put("UID", AesCrypto.a(UserInfo.getInstance().getLoginUserInfo().getUid()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.f16143c.needLoading(false);
                this.f16143c.loadUrl(this.e, this.o);
            }
        } catch (Exception e2) {
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f16143c.receiveFile(i, intent);
    }

    public boolean onBackPressed() {
        YouzanBrowser youzanBrowser = this.f16143c;
        if (youzanBrowser == null) {
            getActivity().finish();
            return super.onBackPressed();
        }
        this.p = true;
        try {
            if (youzanBrowser.pageCanGoBack()) {
                this.f16143c.pageGoBack();
                return true;
            }
            getActivity().finish();
            return super.onBackPressed();
        } catch (Exception e) {
            getActivity().finish();
            return super.onBackPressed();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InitTaskUtil.initYouZanSDK();
        this.b = getActivity();
        View view = this.f16142a;
        if (view == null) {
            this.f16142a = layoutInflater.inflate(R.layout.fragment_youzan_detail, viewGroup, false);
            a();
            if (getArguments() != null) {
                String string = getArguments().getString("KEY_URL");
                this.e = string;
                if (c(string)) {
                    this.e = d(this.e);
                }
                b(this.e);
                if (!StringUtils.d(this.e)) {
                    try {
                        this.e = URLDecoder.decode(this.e, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
            c();
            BluedWebView.b(getActivity());
            if (YouzanSDK.isReady()) {
                b();
            }
        } else if (view.getParent() != null) {
            ((ViewGroup) this.f16142a.getParent()).removeView(this.f16142a);
        }
        return this.f16142a;
    }
}
