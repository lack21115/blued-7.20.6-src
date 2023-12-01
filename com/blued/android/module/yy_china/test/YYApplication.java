package com.blued.android.module.yy_china.test;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.android.internal.telephony.PhoneConstants;
import com.anythink.china.common.d;
import com.anythink.core.api.ATSDK;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.AppHandoverListener;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.MemoryRequest;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.HappyDnsUtils;
import com.blued.android.framework.provider.IAppInfoProvider;
import com.blued.android.framework.provider.IUserInfoProvider;
import com.blued.android.framework.provider.ProviderHolder;
import com.blued.android.framework.urlroute.BluedURIRouter;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.web.cache.BluedWebViewCache;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.url.Host;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.BluedSharedPreferences;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.widget.refresh.BluedLoadMoreView;
import com.blued.android.module.common.widget.refresh.BluedRefreshView;
import com.blued.android.module.svgaplayer.SVGAParser;
import com.blued.android.module.svgaplayer.utils.log.SVGALogger;
import com.blued.android.module.yy_china.R;
import com.blued.android.statistics.BluedStatistics;
import com.mcxiaoke.packer.helper.PackerNg;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/test/YYApplication.class */
public final class YYApplication extends Application implements AppHandoverListener {
    private final boolean DEBUG_HTTP;
    private final boolean TEST_SERVER;

    private final void initMMVK(Application application) {
        BluedSharedPreferences.a(application);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initSmartRefresh$lambda-0  reason: not valid java name */
    public static final RefreshHeader m10844initSmartRefresh$lambda0(Context context, RefreshLayout layout) {
        Intrinsics.e(context, "context");
        Intrinsics.e(layout, "layout");
        layout.c(new int[]{R.color.transparent, com.android.internal.R.color.transparent});
        return new BluedRefreshView(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initSmartRefresh$lambda-1  reason: not valid java name */
    public static final RefreshFooter m10845initSmartRefresh$lambda1(Context context, RefreshLayout layout) {
        Intrinsics.e(context, "context");
        Intrinsics.e(layout, "layout");
        layout.f(30.0f);
        return new BluedLoadMoreView(context);
    }

    public final boolean getDEBUG_HTTP() {
        return this.DEBUG_HTTP;
    }

    public final boolean getTEST_SERVER() {
        return this.TEST_SERVER;
    }

    public final void initAppInfo(Application app) {
        Intrinsics.e(app, "app");
        if (!AppInfo.c()) {
            AppInfo.a(app, "1", this.DEBUG_HTTP);
            AppInfo.s = 0.1f;
            AppInfo.a(true, R.color.syc_b, R.color.syc_b);
            AppInfo.a((AppHandoverListener) this);
        }
        AppInfo.t();
        setChannel();
        setMEI();
    }

    public final void initBluedFramework() {
        ProviderHolder.a().a(new IUserInfoProvider() { // from class: com.blued.android.module.yy_china.test.YYApplication$initBluedFramework$1
            @Override // com.blued.android.framework.provider.IUserInfoProvider
            public String a() {
                String str = UserInfo.getInstance().getLoginUserInfo().uid;
                Intrinsics.c(str, "getInstance().loginUserInfo.uid");
                return str;
            }

            @Override // com.blued.android.framework.provider.IUserInfoProvider
            public void a(String str) {
            }

            @Override // com.blued.android.framework.provider.IUserInfoProvider
            public String b() {
                String accessToken = UserInfo.getInstance().getAccessToken();
                Intrinsics.c(accessToken, "getInstance().accessToken");
                return accessToken;
            }

            @Override // com.blued.android.framework.provider.IUserInfoProvider
            public void c() {
            }

            @Override // com.blued.android.framework.provider.IUserInfoProvider
            public void d() {
            }
        });
        ProviderHolder.a().a(new IAppInfoProvider() { // from class: com.blued.android.module.yy_china.test.YYApplication$initBluedFramework$2
            @Override // com.blued.android.framework.provider.IAppInfoProvider
            public String a() {
                return "1";
            }

            @Override // com.blued.android.framework.provider.IAppInfoProvider
            public String b() {
                return "light";
            }
        });
        BluedURIRouter.a().d("bd_uri_router.json");
        BluedURIRouter.a().e("bd_uri_prefix.json");
        BluedURIRouter.a().c("com.blued.android.similarity_operation_provider.BluedURIRouterAdapter");
        BluedWebViewCache.a("https://web.bldimg.com", "https://www.bldimg.com");
        BluedWebViewCache.b("css", "js");
    }

    public final void initHttpHost() {
        Host.a();
        if (this.TEST_SERVER) {
            BluedHttpUrl.y();
        }
    }

    public final void initHttpManager(Context context) {
        Intrinsics.e(context, "context");
        if (HttpManager.a()) {
            return;
        }
        new HttpManager.Builder(context).a(this.DEBUG_HTTP).a();
    }

    public final void initSkinSdk(Application app) {
        Intrinsics.e(app, "app");
        try {
            BluedSkinUtils.a(app);
        } catch (Exception e) {
        }
    }

    public final void initSmartRefresh() {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() { // from class: com.blued.android.module.yy_china.test.-$$Lambda$YYApplication$KQlWTeWbXFb5L2vZ63zwjPsZY3k
            public final RefreshHeader createRefreshHeader(Context context, RefreshLayout refreshLayout) {
                RefreshHeader m10844initSmartRefresh$lambda0;
                m10844initSmartRefresh$lambda0 = YYApplication.m10844initSmartRefresh$lambda0(context, refreshLayout);
                return m10844initSmartRefresh$lambda0;
            }
        });
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() { // from class: com.blued.android.module.yy_china.test.-$$Lambda$YYApplication$LtdUzqN4gURK0pg7nDgLt9O5clA
            public final RefreshFooter createRefreshFooter(Context context, RefreshLayout refreshLayout) {
                RefreshFooter m10845initSmartRefresh$lambda1;
                m10845initSmartRefresh$lambda1 = YYApplication.m10845initSmartRefresh$lambda1(context, refreshLayout);
                return m10845initSmartRefresh$lambda1;
            }
        });
    }

    public final void initTopOnAdSDK() {
        GlobalSetting.setAgreePrivacyStrategy(false);
        ATSDK.setNetworkLogDebug(AppInfo.m());
        ATSDK.integrationChecking(AppInfo.d());
        ATSDK.init(AppInfo.d(), "a6088f098f2534", "a11c38eb18d1d5ade5bfe7053852313b");
    }

    public final void initUserInfo() {
        UserInfo.getInstance().getLoginUserInfo();
    }

    @Override // com.blued.android.core.AppHandoverListener
    public void onAppBack() {
    }

    @Override // com.blued.android.core.AppHandoverListener
    public void onAppFore(Activity activity) {
        if (Build.VERSION.SDK_INT < 29 || !TestPreferences.c()) {
            TestPreferences.b(false);
            return;
        }
        TestPreferences.b(true);
        TestPreferences.a(BluedSkinUtils.a(activity));
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        YYApplication yYApplication = this;
        initMMVK(yYApplication);
        initSkinSdk(yYApplication);
        initAppInfo(yYApplication);
        initUserInfo();
        initHttpHost();
        YYApplication yYApplication2 = this;
        initHttpManager(yYApplication2);
        initBluedFramework();
        initSmartRefresh();
        initTopOnAdSDK();
        Host.a(1);
        if (UserInfo.getInstance().isLogin()) {
            IMManager.a().b();
            ChatManager.getInstance().setServerInfo(BluedHttpUrl.t(), BluedHttpUrl.u(), BluedHttpUrl.v(), HappyDnsUtils.d(), HappyDnsUtils.a(), BluedHttpUrl.h());
        }
        SVGAParser.a.b().a(yYApplication2);
        SVGALogger.a.a(true);
        YYRoomInfoLocalChannel.a.a(yYApplication);
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        ImageLoader.b();
        if (AppInfo.c()) {
            MemoryRequest.a().b();
        }
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        ImageLoader.a(i);
        if (AppInfo.c()) {
            MemoryRequest.a().a(i);
        }
    }

    public final void setChannel() {
        String a = PackerNg.a(AppInfo.d());
        String str = a;
        if (TextUtils.isEmpty(a)) {
            try {
                ApplicationInfo applicationInfo = AppInfo.d().getPackageManager().getApplicationInfo(AppInfo.d().getPackageName(), 128);
                Intrinsics.c(applicationInfo, "getAppContext().packageM…TA_DATA\n                )");
                str = a;
                if (applicationInfo.metaData != null) {
                    str = applicationInfo.metaData.getString("UMENG_CHANNEL");
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                str = a;
            }
        }
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = "a9999a";
        }
        LogUtils.c(Intrinsics.a("setChannel: ", (Object) str2));
        AppInfo.a(str2);
    }

    public final void setMEI() {
        if (PermissionUtils.a(d.a)) {
            Object systemService = AppInfo.d().getSystemService(PhoneConstants.PHONE_KEY);
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
            }
            String str = null;
            try {
                str = ((TelephonyManager) systemService).getDeviceId();
            } catch (SecurityException e) {
                e.printStackTrace();
            }
            LogUtils.c(Intrinsics.a("IMEI: ", (Object) str));
            if (AppMethods.c(str)) {
                AppInfo.c(str);
            } else {
                str = "";
            }
            BluedStatistics.a().i(str);
        }
        try {
            Class.forName("android.os.AsyncTask");
        } catch (Throwable th) {
        }
    }
}
