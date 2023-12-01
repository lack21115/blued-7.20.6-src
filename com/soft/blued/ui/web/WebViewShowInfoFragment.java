package com.soft.blued.ui.web;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.app.share.ShareUtils;
import com.app.share.model.ShareEntity;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageFileWrapper;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.FixAndroid7WebviewCrashActivity;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.urlroute.BluedUrlParser;
import com.blued.android.framework.urlroute.BluedUrlUtils;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.ImageUtils;
import com.blued.android.framework.utils.RegExpUtils;
import com.blued.android.framework.web.BluedWebView;
import com.blued.android.module.common.utils.ActivityChangeAnimationUtils;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.web.LoaderConstants;
import com.blued.android.module.common.web.ModelLoaderRegistry;
import com.blued.android.module.common.web.jsbridge.BridgeHandler;
import com.blued.android.module.common.web.jsbridge.BridgeManager;
import com.blued.android.module.common.web.jsbridge.CallBackFunction;
import com.blued.android.module.common.web.jsbridge.CallJsModel;
import com.blued.android.module.common.web.modelloader.fetcher.DataFetcher;
import com.blued.android.module.common.web.modelloader.utils.ResponseUtil;
import com.blued.android.module.common.widget.dialog.BluedAlertDialog;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.web.modelloader.loader.WebPaBeansLoader;
import com.blued.android.module.yy_china.web.modelloader.model.WebBuyBeansModel;
import com.blued.android.views.WebBtmOptions;
import com.blued.android.web.SimpleWebCallBack;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.utils.CommunityPreferences;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.customview.WebViewProgressBar;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.live.utils.LiveUtils;
import com.soft.blued.ui.msg.controller.tools.MediaUtils;
import com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter;
import com.soft.blued.ui.web.WebLinkManager;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.ui.web.modelloader.loader.PageInfoLoader;
import com.soft.blued.ui.web.modelloader.loader.WebHeadMenuLoader;
import com.soft.blued.ui.web.modelloader.loader.WebShareLoader;
import com.soft.blued.ui.web.modelloader.model.DeviceModel;
import com.soft.blued.ui.web.modelloader.model.FeedCustomModel;
import com.soft.blued.ui.web.modelloader.model.LatLonModel;
import com.soft.blued.ui.web.modelloader.model.SaveImageModel;
import com.soft.blued.ui.web.modelloader.model.WebHeadMenuModel;
import com.soft.blued.ui.web.modelloader.model.WebShareModel;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.NetworkUtils;
import com.soft.blued.utils.StringUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/web/WebViewShowInfoFragment.class */
public class WebViewShowInfoFragment extends BaseFragment implements View.OnClickListener {
    private ImageView A;
    private ImageView B;
    private ImageView C;
    private FrameLayout D;
    private WebViewProgressBar E;
    private Context F;
    private SimpleWebCallBack G;
    private BridgeManager H;
    private View I;
    protected ViewGroup b;

    /* renamed from: c  reason: collision with root package name */
    protected BluedWebView f34481c;
    protected LinearLayout d;
    protected LinearLayout e;
    protected LinearLayout f;
    protected TextView g;
    protected FrameLayout h;
    protected TextView i;
    protected ImageView j;
    public ShareOptionRecyclerAdapter.ShareOptionsItemClickListener k;
    private boolean m;
    private ViewGroup x;
    private TextView y;
    private TextView z;
    private int n = 0;
    private boolean o = false;

    /* renamed from: a  reason: collision with root package name */
    protected String f34480a = "";
    private String p = "";
    private boolean q = false;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;
    private boolean w = false;
    private boolean J = false;
    public boolean l = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.web.WebViewShowInfoFragment$11  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/web/WebViewShowInfoFragment$11.class */
    public class AnonymousClass11 implements BridgeHandler {
        AnonymousClass11() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(View view) {
            Tracker.onClick(view);
            InstantLog.b("web_page_options_click", 3);
        }

        @Override // com.blued.android.module.common.web.jsbridge.BridgeHandler
        public void handler(String str, CallBackFunction callBackFunction) {
            if (WebViewShowInfoFragment.this.G.f18775c == null) {
                WebViewShowInfoFragment.this.G.f18775c = new WebBtmOptions(WebViewShowInfoFragment.this.f34481c.a().getActivity(), new View.OnClickListener() { // from class: com.soft.blued.ui.web.-$$Lambda$WebViewShowInfoFragment$11$SmBVN6OFa2tkZVHRp4_tJSRo_Ts
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WebViewShowInfoFragment.AnonymousClass11.a(view);
                    }
                });
            }
            WebShareModel webShareModel = (WebShareModel) AppInfo.f().fromJson(str, (Class<Object>) WebShareModel.class);
            if (webShareModel != null) {
                WebViewShowInfoFragment.this.G.b = webShareModel.activitySecretText;
                Log.v("drb", "shareImgUrl:" + webShareModel.imgUrl + " -- shareUrl:" + webShareModel.shareUrl + " -- shareTitle:" + webShareModel.title + " -- shareContent:" + webShareModel.description + " -- shareType:" + webShareModel.shareType);
                WebViewShowInfoFragment.this.G.f18775c.a(ShareUtils.a().a(webShareModel.imgUrl, WebViewShowInfoFragment.this.f34481c.c(), webShareModel.shareUrl, webShareModel.title, webShareModel.description, webShareModel.description, 0), WebViewShowInfoFragment.this.G.f18774a);
            }
        }
    }

    /* renamed from: com.soft.blued.ui.web.WebViewShowInfoFragment$19  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/web/WebViewShowInfoFragment$19.class */
    class AnonymousClass19 implements CallBackFunction {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WebViewShowInfoFragment f34494a;

        @Override // com.blued.android.module.common.web.jsbridge.CallBackFunction
        public void onCallBack(String str) {
            ShareEntity shareEntity = (ShareEntity) AppInfo.f().fromJson(str, (Class<Object>) ShareEntity.class);
            if (shareEntity != null) {
                this.f34494a.G.b = shareEntity.p;
                this.f34494a.G.f18775c.a(shareEntity, this.f34494a.G.f18774a);
            }
        }
    }

    public static void a(Context context, String str, String str2, int i) {
        a(context, str, str2, true, i, false);
    }

    public static void a(Context context, String str, String str2, boolean z, int i) {
        a(context, str, str2, z, i, false);
    }

    public static void a(Context context, String str, String str2, boolean z, int i, boolean z2) {
        a(context, str, str2, z, i, z2, true);
    }

    public static void a(Context context, String str, String str2, boolean z, int i, boolean z2, boolean z3) {
        WebLinkManager.LinkType a2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (z3 && i != 9 && ((a2 = WebLinkManager.f34474a.a(str)) == WebLinkManager.LinkType.BLACK || a2 == WebLinkManager.LinkType.NORMAL)) {
            WebViewLinkPromptFragment.a(context, str, str2, z, i, z2, a2);
        } else if (BluedWebView.a(context, str, new SimpleWebCallBack())) {
            if (i == 14) {
                LiveEventBus.get("live_back_to_two_level").post("");
            }
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("web_url", str);
            bundle.putString("title_name", str2);
            bundle.putInt("from_tag", i);
            bundle.putBoolean("auto_finish", z);
            if ("true".equals(BluedUrlUtils.a(str, "is_invasion"))) {
                z2 = true;
            }
            bundle.putBoolean("Screen_Invasion", z2);
            for (Map.Entry<String, String> entry : BluedUrlUtils.b(str).entrySet()) {
                bundle.putString(entry.getKey(), entry.getValue());
            }
            if (z2) {
                TerminalActivity.a(bundle);
                TerminalActivity.b(bundle);
            }
            FixAndroid7WebviewCrashActivity.b(context, WebViewShowInfoFragment.class, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        this.s = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), 2130772122);
        if (i == -1) {
            this.d.setBackgroundColor(getResources().getColor(2131101294));
            this.z.setText(R.string.first_visit_web_in_black_hint);
            this.d.setVisibility(0);
            this.d.startAnimation(loadAnimation);
            postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.web.WebViewShowInfoFragment.17
                @Override // java.lang.Runnable
                public void run() {
                    if (CommonTools.a(WebViewShowInfoFragment.this) && WebViewShowInfoFragment.this.s) {
                        WebViewShowInfoFragment.this.s = false;
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(WebViewShowInfoFragment.this.getActivity(), 2130772123);
                        WebViewShowInfoFragment.this.d.setVisibility(8);
                        WebViewShowInfoFragment.this.d.startAnimation(loadAnimation2);
                    }
                }
            }, 3500L);
        } else if (i == 1) {
            this.d.setVisibility(8);
        } else {
            this.d.setBackgroundColor(getResources().getColor(2131099829));
            this.z.setText(R.string.not_blued_web_hint);
            this.d.setVisibility(0);
            this.d.startAnimation(loadAnimation);
            AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.web.WebViewShowInfoFragment.18
                @Override // java.lang.Runnable
                public void run() {
                    if (CommonTools.a(WebViewShowInfoFragment.this) && WebViewShowInfoFragment.this.s) {
                        WebViewShowInfoFragment.this.s = false;
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(WebViewShowInfoFragment.this.getActivity(), 2130772123);
                        WebViewShowInfoFragment.this.d.setVisibility(8);
                        WebViewShowInfoFragment.this.d.startAnimation(loadAnimation2);
                    }
                }
            }, 3500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(int i) {
        switch (i) {
            case R.string.copy_link /* 2131887355 */:
                InstantLog.b("web_page_options_click", 0);
                if (Build.VERSION.SDK_INT < 11 || Build.VERSION.SDK_INT == 18) {
                    ((ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE)).setText(this.f34481c.d());
                } else {
                    try {
                        ((android.content.ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("simple url", this.G.f18775c.f9210a.linkUrl));
                    } catch (Exception e) {
                    }
                }
                AppMethods.d((int) R.string.copy_done);
                return;
            case R.string.open_in_browser /* 2131891181 */:
                InstantLog.b("web_page_options_click", 1);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(this.G.f18775c.f9210a.linkUrl));
                if (AppUtils.a(intent)) {
                    startActivity(intent);
                    return;
                }
                return;
            case R.string.refresh /* 2131891459 */:
                InstantLog.b("web_page_options_click", 2);
                this.f34481c.c().reload();
                this.f34481c.c().setVisibility(0);
                this.e.setVisibility(8);
                return;
            case 2131891705:
                if (TextUtils.isEmpty(this.G.b)) {
                    return;
                }
                if (Build.VERSION.SDK_INT < 11 || Build.VERSION.SDK_INT == 18) {
                    ((ClipboardManager) this.F.getSystemService(Context.CLIPBOARD_SERVICE)).setText(RegExpUtils.a(this.G.b));
                } else {
                    try {
                        ((android.content.ClipboardManager) this.F.getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("simple text", RegExpUtils.a(this.G.b)));
                    } catch (Exception e2) {
                    }
                }
                AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.web.WebViewShowInfoFragment.4
                    @Override // java.lang.Runnable
                    public void run() {
                        WebViewShowInfoFragment.this.h.setVisibility(0);
                        EventTrackFeed.a(FeedProtos.Event.SHARE_PASSWORD_POP_SHOW, WebViewShowInfoFragment.this.G.b, false);
                    }
                }, 320L);
                return;
            default:
                return;
        }
    }

    private void d() {
        LiveEventBus.get("LIVE_WEB_PAGE_REFRESH", String.class).observe(this, new Observer<String>() { // from class: com.soft.blued.ui.web.WebViewShowInfoFragment.1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                if (WebViewShowInfoFragment.this.f34481c != null) {
                    WebViewShowInfoFragment.this.f34481c.c().reload();
                    WebViewShowInfoFragment.this.f34481c.c().setVisibility(0);
                }
                if (WebViewShowInfoFragment.this.e != null) {
                    WebViewShowInfoFragment.this.e.setVisibility(8);
                }
            }
        });
    }

    private void i() {
        this.H = new BridgeManager(this.f34481c);
        final ModelLoaderRegistry modelLoaderRegistry = new ModelLoaderRegistry();
        modelLoaderRegistry.add(LoaderConstants.OPEN_SHARE, new WebShareLoader.Factory());
        modelLoaderRegistry.add(LoaderConstants.SET_HEAD_MENU, new WebHeadMenuLoader.Factory(this.H, this.x, getActivity()));
        modelLoaderRegistry.add(LoaderConstants.PAGE_INFO, new PageInfoLoader.Factory(this.H, getLifecycle()));
        modelLoaderRegistry.add(LoaderConstants.YY_BUY_BEANS, new WebPaBeansLoader.Factory());
        this.H.registerHandler(LoaderConstants.SET_HEAD_MENU, new BridgeHandler() { // from class: com.soft.blued.ui.web.WebViewShowInfoFragment.6
            @Override // com.blued.android.module.common.web.jsbridge.BridgeHandler
            public void handler(String str, CallBackFunction callBackFunction) {
                Log.v("drb", "收到js data:" + str);
                if (!TextUtils.isEmpty(str)) {
                    try {
                        WebHeadMenuModel webHeadMenuModel = (WebHeadMenuModel) AppInfo.f().fromJson(str, (Class<Object>) WebHeadMenuModel.class);
                        if (webHeadMenuModel.leftOption != null) {
                            for (WebHeadMenuModel.LeftOption leftOption : webHeadMenuModel.leftOption) {
                                if (!TextUtils.isEmpty(leftOption.optionType) && leftOption.optionType.equals(LoaderConstants.INTERCEPT_GO_BACK)) {
                                    WebViewShowInfoFragment.this.w = true;
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                modelLoaderRegistry.getLoadData(LoaderConstants.SET_HEAD_MENU).fetcher.loadData(str, callBackFunction, new DataFetcher.DataFetcherCallback() { // from class: com.soft.blued.ui.web.WebViewShowInfoFragment.6.1
                    @Override // com.blued.android.module.common.web.modelloader.fetcher.DataFetcher.DataFetcherCallback
                    public void onLoadFailed(Exception exc) {
                    }

                    @Override // com.blued.android.module.common.web.modelloader.fetcher.DataFetcher.DataFetcherCallback
                    public void onLoadSuccess() {
                        WebViewShowInfoFragment.this.I.setVisibility(8);
                    }
                });
            }
        });
        this.H.registerHandler(LoaderConstants.GET_NETWORK_TYPE, new BridgeHandler() { // from class: com.soft.blued.ui.web.WebViewShowInfoFragment.7
            @Override // com.blued.android.module.common.web.jsbridge.BridgeHandler
            public void handler(String str, CallBackFunction callBackFunction) {
                Log.v("drb", "获取网络状态:" + NetworkUtils.a());
                callBackFunction.onCallBack(ResponseUtil.makeResponse(1, "获取网络状态成功！", NetworkUtils.a()));
            }
        });
        this.H.registerHandler(LoaderConstants.GET_CURRENT_LOCATION, new BridgeHandler() { // from class: com.soft.blued.ui.web.WebViewShowInfoFragment.8
            @Override // com.blued.android.module.common.web.jsbridge.BridgeHandler
            public void handler(String str, CallBackFunction callBackFunction) {
                callBackFunction.onCallBack(ResponseUtil.makeResponse(1, "获取地理位置成功！", AppInfo.f().toJson(new LatLonModel(CommonPreferences.v(), CommonPreferences.u()))));
            }
        });
        modelLoaderRegistry.getLoadData(LoaderConstants.PAGE_INFO).fetcher.loadData("", null, null);
        this.H.registerHandler("device", new BridgeHandler() { // from class: com.soft.blued.ui.web.WebViewShowInfoFragment.9
            @Override // com.blued.android.module.common.web.jsbridge.BridgeHandler
            public void handler(String str, CallBackFunction callBackFunction) {
                int i;
                String str2 = AppInfo.j + "";
                String str3 = Build.MANUFACTURER + Build.MODEL;
                String str4 = Build.VERSION.RELEASE;
                String c2 = DeviceUtils.c();
                int width = WebViewShowInfoFragment.this.f34481c.c().getWidth();
                int height = WebViewShowInfoFragment.this.f34481c.c().getHeight();
                if (Build.VERSION.SDK_INT >= 23) {
                    FragmentActivity activity = WebViewShowInfoFragment.this.getActivity();
                    Context unused = WebViewShowInfoFragment.this.F;
                    i = ((BatteryManager) activity.getSystemService(Context.BATTERY_SERVICE)).getIntProperty(4);
                } else {
                    i = 0;
                }
                DeviceModel deviceModel = new DeviceModel(str2, str3, str4, c2, width, height, i);
                Log.v("drb", "手机系统元素：" + deviceModel.toString());
                callBackFunction.onCallBack(ResponseUtil.makeResponse(1, "获取手机系统元素成功！", AppInfo.f().toJson(deviceModel)));
            }
        });
        this.H.registerHandler(LoaderConstants.VIBRATE, new BridgeHandler() { // from class: com.soft.blued.ui.web.WebViewShowInfoFragment.10
            @Override // com.blued.android.module.common.web.jsbridge.BridgeHandler
            public void handler(String str, CallBackFunction callBackFunction) {
                MediaUtils.a().a(1000L);
                callBackFunction.onCallBack(ResponseUtil.makeResponse(1, "震动成功！"));
            }
        });
        this.H.registerHandler(LoaderConstants.OPEN_SHARE, new AnonymousClass11());
        this.H.registerHandler(LoaderConstants.FEED_CUSTOM_RECOMMEND, new BridgeHandler() { // from class: com.soft.blued.ui.web.WebViewShowInfoFragment.12
            @Override // com.blued.android.module.common.web.jsbridge.BridgeHandler
            public void handler(String str, CallBackFunction callBackFunction) {
                FeedCustomModel feedCustomModel = (FeedCustomModel) AppInfo.f().fromJson(str, (Class<Object>) FeedCustomModel.class);
                if (feedCustomModel != null) {
                    CommunityPreferences.b(feedCustomModel.isOpen);
                }
            }
        });
        this.H.registerHandler("close", new BridgeHandler() { // from class: com.soft.blued.ui.web.WebViewShowInfoFragment.13
            @Override // com.blued.android.module.common.web.jsbridge.BridgeHandler
            public void handler(String str, CallBackFunction callBackFunction) {
                WebViewShowInfoFragment.this.b();
            }
        });
        this.H.registerHandler(LoaderConstants.YY_BUY_BEANS, new BridgeHandler() { // from class: com.soft.blued.ui.web.WebViewShowInfoFragment.14
            @Override // com.blued.android.module.common.web.jsbridge.BridgeHandler
            public void handler(String str, CallBackFunction callBackFunction) {
                WebBuyBeansModel webBuyBeansModel;
                if (StringUtils.d(str) || (webBuyBeansModel = (WebBuyBeansModel) AppInfo.f().fromJson(str, (Class<Object>) WebBuyBeansModel.class)) == null || StringUtils.d(webBuyBeansModel.prop_id)) {
                    return;
                }
                YYRoomInfoManager.e().a(webBuyBeansModel, WebViewShowInfoFragment.this);
            }
        });
        this.H.registerHandler(LoaderConstants.SAVE_IMAGE, new BridgeHandler() { // from class: com.soft.blued.ui.web.WebViewShowInfoFragment.15

            /* renamed from: com.soft.blued.ui.web.WebViewShowInfoFragment$15$1  reason: invalid class name */
            /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/web/WebViewShowInfoFragment$15$1.class */
            class AnonymousClass1 implements PermissionCallbacks {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ SaveImageModel f34489a;
                final /* synthetic */ CallBackFunction b;

                AnonymousClass1(SaveImageModel saveImageModel, CallBackFunction callBackFunction) {
                    this.f34489a = saveImageModel;
                    this.b = callBackFunction;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static /* synthetic */ void a(CallBackFunction callBackFunction, File file, Exception exc) {
                    if (file != null && file.exists()) {
                        ImageUtils.a(ImageUtils.a(file));
                        callBackFunction.onCallBack(ResponseUtil.makeResponse(1, "保存图片成功"));
                        return;
                    }
                    callBackFunction.onCallBack(ResponseUtil.makeResponse(0, "保存图片异常:" + exc.toString()));
                }

                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void U_() {
                    ImageFileWrapper a2 = ImageFileLoader.a(WebViewShowInfoFragment.this.getFragmentActive()).a(this.f34489a.imgUrl);
                    final CallBackFunction callBackFunction = this.b;
                    a2.a(new ImageFileLoader.OnLoadFileListener() { // from class: com.soft.blued.ui.web.-$$Lambda$WebViewShowInfoFragment$15$1$A781R4N72Chx7dPu153L42sovpk
                        @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
                        public final void onUIFinish(File file, Exception exc) {
                            WebViewShowInfoFragment.AnonymousClass15.AnonymousClass1.a(CallBackFunction.this, file, exc);
                        }
                    }).a();
                }

                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void a(String[] strArr) {
                    this.b.onCallBack(ResponseUtil.makeResponse(0, "保存图片失败，权限申请异常"));
                }
            }

            @Override // com.blued.android.module.common.web.jsbridge.BridgeHandler
            public void handler(String str, CallBackFunction callBackFunction) {
                try {
                    SaveImageModel saveImageModel = (SaveImageModel) AppInfo.f().fromJson(str, (Class<Object>) SaveImageModel.class);
                    if (saveImageModel != null) {
                        if (TextUtils.isEmpty(saveImageModel.imgUrl)) {
                            callBackFunction.onCallBack(ResponseUtil.makeResponse(0, "imgUrl字段为空"));
                            return;
                        }
                        Log.v("drb", "model.imgUrl:" + saveImageModel.imgUrl);
                        PermissionUtils.f(new AnonymousClass1(saveImageModel, callBackFunction));
                    }
                } catch (Exception e) {
                    callBackFunction.onCallBack(ResponseUtil.makeResponse(0, "保存图片异常:" + e.toString()));
                }
            }
        });
        this.H.registerHandler(LoaderConstants.GO_BACK, new BridgeHandler() { // from class: com.soft.blued.ui.web.WebViewShowInfoFragment.16
            @Override // com.blued.android.module.common.web.jsbridge.BridgeHandler
            public void handler(String str, CallBackFunction callBackFunction) {
                WebViewShowInfoFragment.this.g();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.f34481c.c().canGoBack()) {
            this.D.setVisibility(0);
            Log.v("drb", "webView.setCloseVisible 展示");
            return;
        }
        this.D.setVisibility(4);
        Log.v("drb", "webView.setCloseVisible 隐藏");
    }

    public static void show(Context context, String str) {
        a(context, str, "", -1);
    }

    public static void show(Context context, String str, int i) {
        a(context, str, "", i);
    }

    public static void show(Context context, String str, int i, boolean z) {
        a(context, str, "", true, i, z);
    }

    public ViewGroup a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (ViewGroup) layoutInflater.inflate(R.layout.activity_webview_showinfo, viewGroup, false);
    }

    public void a() {
        int i = this.n;
        if (i == 10 || i == 11 || i == 16) {
            getActivity().getWindow().setSoftInputMode(18);
        }
        this.E = (WebViewProgressBar) this.b.findViewById(2131368383);
        this.C = (ImageView) this.b.findViewById(R.id.tv_hint_close);
        this.d = (LinearLayout) this.b.findViewById(R.id.ll_hint);
        this.z = (TextView) this.b.findViewById(2131371675);
        LinearLayout linearLayout = (LinearLayout) this.b.findViewById(R.id.ll_page_not_found);
        this.e = linearLayout;
        linearLayout.setOnClickListener(this);
        this.e.setVisibility(8);
        this.g = (TextView) this.e.findViewById(2131371262);
        this.f = (LinearLayout) this.b.findViewById(R.id.ll_stop_visit);
        this.h = (FrameLayout) this.b.findViewById(R.id.share_code_layout);
        this.i = (TextView) this.b.findViewById(R.id.share_to_code_go_wechat);
        this.j = (ImageView) this.b.findViewById(R.id.share_to_code_close);
        this.f.setVisibility(8);
        this.C.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.h.setOnClickListener(this);
        WebView webView = (WebView) this.b.findViewById(R.id.wv);
        webView.setBackgroundColor(0);
        webView.requestFocus(130);
        this.G = new SimpleWebCallBack() { // from class: com.soft.blued.ui.web.WebViewShowInfoFragment.3
            @Override // com.blued.android.web.SimpleWebCallBack, com.blued.android.framework.web.BluedWebView.WebCallback
            public void a(BluedWebView bluedWebView, int i2) {
                WebViewShowInfoFragment.this.E.setProgress(i2);
            }

            @Override // com.blued.android.web.SimpleWebCallBack, com.blued.android.framework.web.BluedWebView.WebCallback
            public void a(BluedWebView bluedWebView, int i2, String str, String str2) {
                bluedWebView.c().setVisibility(8);
                WebViewShowInfoFragment.this.e.setVisibility(0);
                WebViewShowInfoFragment.this.f.setVisibility(8);
                WebViewShowInfoFragment.this.g.setText(String.format(WebViewShowInfoFragment.this.F.getResources().getString(R.string.page_not_exists), str2));
            }

            @Override // com.blued.android.web.SimpleWebCallBack, com.blued.android.framework.web.BluedWebView.WebCallback
            public void a(BluedWebView bluedWebView, String str) {
                if (CommonTools.a(WebViewShowInfoFragment.this)) {
                    WebViewShowInfoFragment.this.c(str);
                }
            }

            @Override // com.blued.android.web.SimpleWebCallBack, com.blued.android.framework.web.BluedWebView.WebCallback
            public void a(BluedWebView bluedWebView, String str, boolean z) {
                if (WebViewShowInfoFragment.this.H != null) {
                    WebViewShowInfoFragment.this.H.onLoadPageOverrideLoad(bluedWebView, str, z);
                }
                if (z) {
                    WebViewShowInfoFragment.this.t = true;
                    Map<String, String> b = BluedUrlUtils.b(str);
                    if (b == null || b.size() <= 0 || !b.containsKey("blued_mode")) {
                        return;
                    }
                    String str2 = b.get("blued_mode");
                    if (!StringUtils.d(str2)) {
                        if (str2.contains("fullscreen")) {
                            WebViewShowInfoFragment.this.m = true;
                            WebViewShowInfoFragment.this.getActivity().getWindow().setFlags(1024, 1024);
                            WebViewShowInfoFragment.this.x.setVisibility(8);
                        }
                        if (str2.contains("hide_opt")) {
                            WebViewShowInfoFragment.this.B.setVisibility(8);
                        }
                    }
                    String str3 = b.get("screen_orientation");
                    if (Camera.Parameters.SCENE_MODE_LANDSCAPE.equalsIgnoreCase(str3)) {
                        WebViewShowInfoFragment.this.getActivity().setRequestedOrientation(0);
                    } else if (Camera.Parameters.SCENE_MODE_PORTRAIT.equalsIgnoreCase(str3)) {
                        WebViewShowInfoFragment.this.getActivity().setRequestedOrientation(1);
                    } else if (WebViewShowInfoFragment.this.r) {
                    } else {
                        WebViewShowInfoFragment.this.getActivity().setRequestedOrientation(4);
                    }
                }
            }

            @Override // com.blued.android.web.SimpleWebCallBack, com.blued.android.framework.web.BluedWebView.WebCallback
            public void a(String str) {
                if ("show".equals(str)) {
                    WebViewShowInfoFragment.this.B.setVisibility(0);
                } else if ("hide".equals(str)) {
                    WebViewShowInfoFragment.this.B.setVisibility(8);
                }
            }

            @Override // com.blued.android.web.SimpleWebCallBack, com.blued.android.framework.web.BluedWebView.WebCallback
            public boolean a(BluedWebView bluedWebView, BluedUrlParser bluedUrlParser) {
                return WebViewShowInfoFragment.this.a(bluedWebView, bluedUrlParser);
            }

            @Override // com.blued.android.web.SimpleWebCallBack
            public void b(BluedWebView bluedWebView, final int i2) {
                WebViewShowInfoFragment.this.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.web.WebViewShowInfoFragment.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WebViewShowInfoFragment.this.b(i2);
                    }
                });
            }

            @Override // com.blued.android.web.SimpleWebCallBack, com.blued.android.framework.web.BluedWebView.WebCallback
            public void b(BluedWebView bluedWebView, String str, boolean z) {
                if (WebViewShowInfoFragment.this.H != null) {
                    WebViewShowInfoFragment.this.H.onLoadPageFinished(bluedWebView, str);
                }
                if (z) {
                    WebViewShowInfoFragment.this.t = true;
                }
                if (CommonTools.a((Activity) WebViewShowInfoFragment.this.getActivity())) {
                    WebViewShowInfoFragment.this.j();
                    WebViewShowInfoFragment.this.f();
                }
            }

            @Override // com.blued.android.web.SimpleWebCallBack, com.blued.android.framework.web.BluedWebView.WebCallback
            public void b(String str) {
                Log.e("xufangmu", "onCallPopularizeMsg: --->" + str);
                WebViewShowInfoFragment.this.J = TextUtils.equals(str, "call/popularize");
            }
        };
        ShareOptionRecyclerAdapter.ShareOptionsItemClickListener shareOptionsItemClickListener = new ShareOptionRecyclerAdapter.ShareOptionsItemClickListener() { // from class: com.soft.blued.ui.web.-$$Lambda$WebViewShowInfoFragment$5GI89cAy0uUoDYsq7rWuudjjQZA
            @Override // com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter.ShareOptionsItemClickListener
            public final void onItemClick(int i2) {
                WebViewShowInfoFragment.this.c(i2);
            }
        };
        this.k = shareOptionsItemClickListener;
        this.G.a(shareOptionsItemClickListener);
        this.f34481c = new BluedWebView(this, webView, this.b, this.G);
        i();
        this.f34481c.b(this.n);
        if (this.n == 13) {
            this.f34481c.c().getSettings().setBuiltInZoomControls(false);
            this.f34481c.a(DensityUtils.a(getActivity(), 44.0f));
            return;
        }
        BridgeManager bridgeManager = this.H;
        if (bridgeManager == null || bridgeManager.hasJSUrl(this.f34480a)) {
            return;
        }
        webView.setOnTouchListener(new View.OnTouchListener() { // from class: com.soft.blued.ui.web.WebViewShowInfoFragment.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    if (WebViewShowInfoFragment.this.f34481c.c().canGoBack()) {
                        Log.v("drb", "webView.setOnTouchListener 展示");
                        WebViewShowInfoFragment.this.D.setVisibility(0);
                    } else {
                        Log.v("drb", "webView.setOnTouchListener 隐藏");
                        WebViewShowInfoFragment.this.D.setVisibility(4);
                    }
                    String d = WebViewShowInfoFragment.this.f34481c.d();
                    if (StringUtils.d(d) || !d.contains("file:///android_asset/")) {
                        return false;
                    }
                    WebViewShowInfoFragment.this.f34481c.c().clearCache(false);
                    WebViewShowInfoFragment webViewShowInfoFragment = WebViewShowInfoFragment.this;
                    webViewShowInfoFragment.b(webViewShowInfoFragment.f34480a);
                    return false;
                }
                return false;
            }
        });
    }

    public void a(int i) {
    }

    public void a(String str, String str2) {
        BluedWebView bluedWebView = this.f34481c;
        if (bluedWebView == null || bluedWebView.a(str, str2)) {
            return;
        }
        this.f.setVisibility(0);
        this.y.setText("");
        this.e.setVisibility(8);
        this.f34481c.c().setVisibility(8);
    }

    public boolean a(BluedWebView bluedWebView, BluedUrlParser bluedUrlParser) {
        return false;
    }

    public void b() {
        if (getFragmentActive() == null || !getFragmentActive().isActive() || this.l) {
            return;
        }
        getActivity().finish();
    }

    public void b(String str) {
        a(str, this.p);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        ViewGroup viewGroup = this.b;
        if (viewGroup != null) {
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.web_title);
            this.x = viewGroup2;
            if (this.v) {
                viewGroup2.setVisibility(8);
            } else {
                viewGroup2.setVisibility(0);
            }
            if (this.o) {
                LinearLayout linearLayout = (LinearLayout) this.x.findViewById(R.id.ctt_bg);
                int a2 = StatusBarHelper.a(getContext());
                linearLayout.getLayoutParams().height += a2;
                linearLayout.setPadding(0, a2, 0, 0);
            }
            ImageView imageView = (ImageView) this.x.findViewById(2131363120);
            this.A = imageView;
            imageView.setOnClickListener(this);
            TextView textView = (TextView) this.x.findViewById(2131363108);
            this.y = textView;
            textView.setText(getResources().getString(R.string.biao_web_pageing));
            ImageView imageView2 = (ImageView) this.x.findViewById(2131363126);
            this.B = imageView2;
            imageView2.setOnClickListener(this);
            this.D = (FrameLayout) this.x.findViewById(R.id.ctt_close_layout);
            this.I = this.x.findViewById(R.id.title_btm_line);
            this.D.setOnClickListener(this);
            int i = this.n;
            if (i == 0) {
                this.B.setVisibility(8);
                this.r = true;
                this.q = false;
            } else if (i == 1) {
                this.B.setVisibility(8);
                this.r = true;
                this.q = true;
            } else if (i == 2) {
                this.B.setVisibility(0);
                this.r = true;
                this.q = true;
            } else if (i == 7) {
                this.B.setVisibility(0);
                this.r = false;
                this.q = false;
            } else if (i == 15) {
                this.B.setVisibility(8);
                this.r = false;
                this.q = false;
            } else if (i != 16) {
                switch (i) {
                    case 9:
                        this.B.setVisibility(0);
                        this.r = false;
                        this.q = false;
                        break;
                    case 10:
                        this.B.setVisibility(8);
                        this.r = true;
                        this.q = false;
                        break;
                    case 11:
                        this.B.setVisibility(0);
                        this.r = false;
                        this.q = false;
                        break;
                    default:
                        this.B.setVisibility(0);
                        this.r = false;
                        this.q = false;
                        break;
                }
            } else {
                this.B.setVisibility(8);
                this.r = true;
                this.q = true;
            }
            if (this.m) {
                this.x.setVisibility(8);
            }
        }
    }

    public void c(String str) {
        if (StringUtils.d(str)) {
            this.y.setText("");
        } else {
            this.y.setText(str);
        }
        if (StringUtils.d(this.p) || !this.q) {
            return;
        }
        this.y.setText(this.p);
    }

    public String e() {
        String str = this.f34480a;
        return str != null ? str : "";
    }

    public void f() {
        if (getResources().getString(R.string.biao_web_pageing).equals(this.y.getText().toString())) {
            c("");
        }
    }

    public boolean g() {
        if (BluedPreferences.fx()) {
            ActivityStackManager.a().b();
            BluedPreferences.af(false);
            return false;
        }
        BluedWebView bluedWebView = this.f34481c;
        if (bluedWebView == null || !bluedWebView.c().canGoBack()) {
            b();
            return false;
        }
        this.f34481c.c().goBack();
        return true;
    }

    public void h() {
        Log.v("xxx", "NATIVE_TO_JS notifyJsBackPressed");
        this.H.callHandler(LoaderConstants.NATIVE_TO_JS, AppInfo.f().toJson(new CallJsModel(LoaderConstants.INTERCEPT_GO_BACK)), new CallBackFunction() { // from class: com.soft.blued.ui.web.WebViewShowInfoFragment.20
            @Override // com.blued.android.module.common.web.jsbridge.CallBackFunction
            public void onCallBack(String str) {
                Log.v("drb", "NATIVE_TO_JS notifyJsBackPressed onCallBack：" + str);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.f34481c.a(i, i2, intent)) {
            return;
        }
        YYRoomInfoManager.e().a(i, i2, intent, this);
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        if (this.w) {
            Log.e("xxx", "onBackPressed() interceptGoBack");
            h();
            return true;
        }
        Log.e("xxx", "onBackPressed()");
        a(4);
        return g();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case R.id.ctt_close_layout /* 2131363118 */:
                b();
                return;
            case 2131363120:
                onBackPressed();
                return;
            case 2131363126:
                this.f34481c.b("");
                return;
            case R.id.ll_page_not_found /* 2131368116 */:
                this.f34481c.c().reload();
                this.f34481c.c().setVisibility(0);
                this.e.setVisibility(8);
                return;
            case R.id.share_to_code_close /* 2131369791 */:
                this.h.setVisibility(8);
                return;
            case R.id.share_to_code_go_wechat /* 2131369792 */:
                EventTrackFeed.a(FeedProtos.Event.SHARE_PASSWORD_POP_PASTE_CLICK, this.G.b, false);
                startActivity(getActivity().getPackageManager().getLaunchIntentForPackage("com.tencent.mm"));
                this.h.setVisibility(8);
                return;
            case R.id.tv_hint_close /* 2131371676 */:
                this.s = false;
                if (this.d.getVisibility() == 0) {
                    Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), 2130772123);
                    this.d.setVisibility(8);
                    this.d.startAnimation(loadAnimation);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        ViewGroup viewGroup;
        super.onConfigurationChanged(configuration);
        if (!this.m) {
            if (configuration.orientation == 1 || (viewGroup = this.x) == null) {
                this.x.setVisibility(0);
            } else {
                viewGroup.setVisibility(8);
            }
        }
        if (configuration.orientation == 1 && getActivity() != null) {
            final BluedAlertDialog a2 = CommonAlertDialog.a(getActivity(), "", "", "", (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null, 0);
            AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.web.WebViewShowInfoFragment.2
                @Override // java.lang.Runnable
                public void run() {
                    a2.dismiss();
                }
            });
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.n = getArguments().getInt("from_tag");
            this.o = getArguments().getBoolean("Screen_Invasion");
        }
        if (this.n == 14) {
            ActivityChangeAnimationUtils.b(getActivity());
            LiveEventBus.get("live_back_to_two_level").post("");
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.F = getActivity();
        ActivityStackManager.a().a(new WeakReference<>(getActivity()));
        getActivity().getWindow().setSoftInputMode(18);
        ViewGroup viewGroup2 = this.b;
        if (viewGroup2 == null) {
            try {
                this.b = a(layoutInflater, viewGroup);
                if (getArguments() != null) {
                    String string = getArguments().getString("web_url");
                    String str2 = string;
                    if (!string.contains("://")) {
                        str2 = "http://" + string;
                    }
                    this.f34480a = str2;
                    Log.v("drb", "跳转到webview页面载入链接：" + this.f34480a);
                    this.p = getArguments().getString("title_name");
                    this.v = getArguments().getBoolean("hide_title");
                    this.u = getArguments().getBoolean("auto_finish", false);
                    str = str2;
                    if ("fullscreen".equals(getArguments().getString("blued_mode"))) {
                        this.m = true;
                        getActivity().getWindow().setFlags(1024, 1024);
                        str = str2;
                    }
                } else {
                    str = "";
                }
                c();
                a();
                a(str, this.p);
            } catch (InflateException e) {
                getActivity().finish();
                AppMethods.a((CharSequence) "请前往系统应用商店安装系统浏览器~");
                return null;
            }
        } else if (viewGroup2.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BluedWebView bluedWebView = this.f34481c;
        if (bluedWebView != null) {
            bluedWebView.h();
        }
        LiveUtils.a("", "", 0);
        if (this.J) {
            ChatHttpUtils.a();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        BluedWebView bluedWebView = this.f34481c;
        if (bluedWebView != null) {
            bluedWebView.g();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        BluedWebView bluedWebView = this.f34481c;
        if (bluedWebView != null) {
            bluedWebView.f();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.t || !this.u) {
            return;
        }
        b();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        d();
    }
}
