package com.soft.blued.app;

import android.app.Application;
import android.content.Context;
import android.graphics.Point;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import com.amap.api.services.core.ServiceSettings;
import com.anythink.core.api.ATSDK;
import com.baidu.mobads.sdk.api.BDAdConfig;
import com.blued.android.chat.BluedChat;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.utils.PageTimeUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.HappyDnsUtils;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.init.InitTask;
import com.blued.android.framework.init.InitTaskManager;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.LocaleUtils;
import com.blued.android.framework.utils.SharedPreferencesUtils;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshHelper;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.ImgURLMap;
import com.blued.android.module.common.utils.NetworkUtils;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.widget.emoticon.manager.EmotionManager;
import com.blued.android.module.common.widget.refresh.BluedLoadMoreView;
import com.blued.android.module.common.widget.refresh.BluedRefreshView;
import com.blued.android.module.device_identity.library.BluedDeviceIdentity;
import com.blued.android.module.live_china.common.ZegoCommonHelper;
import com.blued.android.modules.ModulesHelper;
import com.blued.android.pulltorefresh.WaveLoadingLayout;
import com.blued.android.statistics.BluedStatistics;
import com.blued.login.utils.LoginPreLoad;
import com.blued.track.bytedance.ByteDanceLogHelper;
import com.heytap.msp.mobad.api.InitParams;
import com.heytap.msp.mobad.api.MobAdManager;
import com.heytap.msp.mobad.api.listener.IInitListener;
import com.huawei.hms.ads.HwAds;
import com.huawei.openalliance.ad.inter.HiAd;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsInitCallback;
import com.kwad.sdk.api.SdkConfig;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.soft.blued.BluedConstant;
import com.soft.blued.http.AppHttpUtils;
import com.soft.blued.push.PushManager;
import com.soft.blued.service.AutoStartService;
import com.soft.blued.tinker.service.PatchCheckUpdateUtils;
import com.soft.blued.ui.msg.controller.tools.IMManager;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.BuglyCrashRecorder;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.third.BluedFingerPrintUtils;
import com.soft.blued.utils.third.TTAdManagerHolder;
import com.soft.blued.utils.third.YouMengUtils;
import com.soft.blued.utils.third.YouZanUtils;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.map.lib.models.AccessibleTouchItem;
import com.tencent.tendinsv.OneKeyLoginManager;
import com.tencent.tendinsv.listener.InitListener;
import com.umeng.commonsdk.UMConfigure;
import com.web.library.groups.webviewsdk.core.WebViewSdk;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/app/InitTaskUtil.class */
public class InitTaskUtil {
    private static String TAG = "InitTaskUtil";
    private static boolean startAutoStartService = true;

    public static InitTaskManager.OnTaskListBuilder generateTaskListBuilder() {
        return new InitTaskManager.OnTaskListBuilder() { // from class: com.soft.blued.app.InitTaskUtil.1
            @Override // com.blued.android.framework.init.InitTaskManager.OnTaskListBuilder
            public void onBuild(Application application, ArrayList<InitTask> arrayList) {
                ArrayList<InitTask> arrayList2 = arrayList;
                if (arrayList == null) {
                    arrayList2 = new ArrayList<>();
                }
                arrayList2.add(new InitTask("BluedConfig") { // from class: com.soft.blued.app.InitTaskUtil.1.1
                    @Override // com.blued.android.framework.init.InitTask
                    public void b() {
                        BluedConfig.a();
                    }

                    @Override // com.blued.android.framework.init.InitTask
                    public boolean d() {
                        return true;
                    }
                });
                arrayList2.add(new InitTask("hookSP") { // from class: com.soft.blued.app.InitTaskUtil.1.2
                    @Override // com.blued.android.framework.init.InitTask
                    public void b() {
                        SharedPreferencesUtils.c();
                    }
                });
                arrayList2.add(new InitTask("refreshUserInfo & 需要用户资料的一些初始化") { // from class: com.soft.blued.app.InitTaskUtil.1.3
                    @Override // com.blued.android.framework.init.InitTask
                    public void b() {
                        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
                            UserInfo.getInstance().getLoginUserInfo();
                        }
                    }

                    @Override // com.blued.android.framework.init.InitTask
                    public boolean d() {
                        return true;
                    }
                });
                arrayList2.add(new InitTask("BluedAPM") { // from class: com.soft.blued.app.InitTaskUtil.1.4
                    @Override // com.blued.android.framework.init.InitTask
                    public void b() {
                        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
                            InitTaskUtil.initBluedAPM();
                        }
                        IMManager.a().c();
                    }
                });
                arrayList2.add(new InitTask("requestLoginSplash") { // from class: com.soft.blued.app.InitTaskUtil.1.5
                    @Override // com.blued.android.framework.init.InitTask
                    public void b() {
                        if ((BluedPreferences.aC() == 1 || BluedPreferences.aD()) && !UserInfo.getInstance().isLogin()) {
                            LoginPreLoad.f20592a.b();
                        }
                    }

                    @Override // com.blued.android.framework.init.InitTask
                    public boolean d() {
                        return true;
                    }
                });
                arrayList2.add(new InitTask("友盟预初始化") { // from class: com.soft.blued.app.InitTaskUtil.1.6
                    @Override // com.blued.android.framework.init.InitTask
                    public void b() {
                        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
                            InitTaskUtil.initUMeng();
                        }
                    }
                });
                arrayList2.add(new InitTask(AccessibleTouchItem.MAP_DEFAULT_CONTENT_DESCRIPTION) { // from class: com.soft.blued.app.InitTaskUtil.1.7
                    @Override // com.blued.android.framework.init.InitTask
                    public void b() {
                        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
                            InitTaskUtil.initMap();
                        }
                    }
                });
                arrayList2.add(new InitTask("语言设置&下拉刷新") { // from class: com.soft.blued.app.InitTaskUtil.1.8
                    @Override // com.blued.android.framework.init.InitTask
                    public void b() {
                        LocaleUtils.d();
                        BluedApplicationLike.initAppLanguage();
                        BluedPreferences.b(0L);
                        PullToRefreshHelper.a(WaveLoadingLayout.class.getName());
                        WaveLoadingLayout.preloadLoadingAnimation(AppInfo.d());
                        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() { // from class: com.soft.blued.app.InitTaskUtil.1.8.1
                            @Override // com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator
                            public RefreshHeader createRefreshHeader(Context context, RefreshLayout refreshLayout) {
                                refreshLayout.c(2131102388, 17170445);
                                return new BluedRefreshView(context);
                            }
                        });
                        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() { // from class: com.soft.blued.app.InitTaskUtil.1.8.2
                            @Override // com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator
                            public RefreshFooter createRefreshFooter(Context context, RefreshLayout refreshLayout) {
                                refreshLayout.f(30.0f);
                                return new BluedLoadMoreView(context);
                            }
                        });
                    }
                });
                arrayList2.add(new InitTask("友盟") { // from class: com.soft.blued.app.InitTaskUtil.1.9
                    @Override // com.blued.android.framework.init.InitTask
                    public void b() {
                        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
                            YouMengUtils.a();
                        }
                    }
                });
                if (!PushManager.b()) {
                    arrayList2.add(new InitTask("connectIm") { // from class: com.soft.blued.app.InitTaskUtil.1.10
                        @Override // com.blued.android.framework.init.InitTask
                        public void b() {
                            try {
                                BluedChat.getInstance().startIMService(AppInfo.d());
                            } catch (Throwable th) {
                            }
                        }
                    });
                }
                arrayList2.add(new InitTask("AutoStartService") { // from class: com.soft.blued.app.InitTaskUtil.1.11
                    @Override // com.blued.android.framework.init.InitTask
                    public void b() {
                        EmotionManager.b(BluedHttpUrl.q());
                        AppInfo.n().post(new Runnable() { // from class: com.soft.blued.app.InitTaskUtil.1.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (InitTaskUtil.getStartAutoStartService() && BluedApplicationLike.isMainApplication(AppInfo.d())) {
                                    AutoStartService.startService(AppInfo.d());
                                }
                            }
                        });
                    }

                    @Override // com.blued.android.framework.init.InitTask
                    public boolean d() {
                        return true;
                    }
                });
                arrayList2.add(new InitTask("广点通") { // from class: com.soft.blued.app.InitTaskUtil.1.12
                    @Override // com.blued.android.framework.init.InitTask
                    public void b() {
                        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
                            GlobalSetting.setAgreePrivacyStrategy(false);
                            GDTAdSdk.init(AppInfo.d(), BluedConstant.a());
                        }
                    }
                });
                arrayList2.add(new InitTask("穿山甲SDK初始化") { // from class: com.soft.blued.app.InitTaskUtil.1.13
                    @Override // com.blued.android.framework.init.InitTask
                    public void b() {
                        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
                            Log.v("drb", "InitTask 穿山甲SDK初始化");
                            InitTaskUtil.initTTAdSDK();
                        }
                    }
                });
                arrayList2.add(new InitTask("百度SDK初始化") { // from class: com.soft.blued.app.InitTaskUtil.1.14
                    @Override // com.blued.android.framework.init.InitTask
                    public void b() {
                        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
                            Log.v("drb", "InitTask 百度SDK初始化");
                            InitTaskUtil.initBDSDK();
                        }
                    }
                });
                arrayList2.add(new InitTask("oppoSDK初始化") { // from class: com.soft.blued.app.InitTaskUtil.1.15
                    @Override // com.blued.android.framework.init.InitTask
                    public void b() {
                        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
                            InitTaskUtil.initOPPOAdSDK();
                        }
                    }
                });
                arrayList2.add(new InitTask("IMEI&AsyncTask") { // from class: com.soft.blued.app.InitTaskUtil.1.16
                    @Override // com.blued.android.framework.init.InitTask
                    public void b() {
                        if (BluedPreferences.aD() && PermissionUtils.a("android.permission.READ_PHONE_STATE")) {
                            String str = null;
                            try {
                                str = ((TelephonyManager) AppInfo.d().getSystemService("phone")).getDeviceId();
                            } catch (SecurityException e) {
                                e.printStackTrace();
                            }
                            if (AppMethods.c(str)) {
                                AppInfo.c(str);
                            } else {
                                str = "";
                            }
                            BluedStatistics.a().i(str);
                            BluedStatistics.a().l(BluedConfig.a().b().vip_grade + "");
                        }
                        try {
                            Class.forName("android.os.AsyncTask");
                        } catch (Throwable th) {
                        }
                    }
                });
                arrayList2.add(new InitTask("激活统计") { // from class: com.soft.blued.app.InitTaskUtil.1.17
                    @Override // com.blued.android.framework.init.InitTask
                    public void b() {
                        BluedPreferences.i();
                        if (!BluedPreferences.bm()) {
                            AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.app.InitTaskUtil.1.17.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
                                        AppHttpUtils.a(new BluedUIHttpResponse() { // from class: com.soft.blued.app.InitTaskUtil.1.17.1.1
                                            @Override // com.blued.android.framework.http.BluedUIHttpResponse
                                            public void onUIUpdate(BluedEntity bluedEntity) {
                                                BluedPreferences.bn();
                                            }
                                        });
                                    }
                                }
                            }, 2000L);
                        }
                        BluedPreferences.I(false);
                    }
                });
                arrayList2.add(new InitTask("下拉刷新字符串") { // from class: com.soft.blued.app.InitTaskUtil.1.18
                    @Override // com.blued.android.framework.init.InitTask
                    public void b() {
                        PullToRefreshHelper.a(2131891361, 2131891364, 2131891363, 2131887218, 2131890386);
                    }
                });
                arrayList2.add(new InitTask("Patch更新") { // from class: com.soft.blued.app.InitTaskUtil.1.19
                    @Override // com.blued.android.framework.init.InitTask
                    public void b() {
                        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.app.InitTaskUtil.1.19.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
                                    PatchCheckUpdateUtils.a();
                                }
                            }
                        }, 2000L);
                    }
                });
                arrayList2.add(new InitTask("其他模块") { // from class: com.soft.blued.app.InitTaskUtil.1.20
                    @Override // com.blued.android.framework.init.InitTask
                    public void b() {
                        ModulesHelper.a();
                    }
                });
                arrayList2.add(new InitTask("页面时长") { // from class: com.soft.blued.app.InitTaskUtil.1.21
                    @Override // com.blued.android.framework.init.InitTask
                    public void b() {
                        PageTimeUtils.a("pagebiz_table.json");
                    }

                    @Override // com.blued.android.framework.init.InitTask
                    public boolean d() {
                        return true;
                    }
                });
                arrayList2.add(new InitTask("zego") { // from class: com.soft.blued.app.InitTaskUtil.1.22
                    @Override // com.blued.android.framework.init.InitTask
                    public void b() {
                        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
                            InitTaskUtil.initZego();
                        }
                    }
                });
                arrayList2.add(new InitTask("设备标识") { // from class: com.soft.blued.app.InitTaskUtil.1.23
                    @Override // com.blued.android.framework.init.InitTask
                    public void b() {
                        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
                            BluedDeviceIdentity a2 = BluedDeviceIdentity.a();
                            Context d = AppInfo.d();
                            a2.a(d, BluedHttpUrl.q() + "/blued/device", 2);
                        }
                    }
                });
                arrayList2.add(new InitTask("TopOn") { // from class: com.soft.blued.app.InitTaskUtil.1.24
                    @Override // com.blued.android.framework.init.InitTask
                    public void b() {
                        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
                            InitTaskUtil.initTopOnAdSDK();
                        }
                    }
                });
                arrayList2.add(new InitTask(GlobalSetting.KS_SDK_WRAPPER) { // from class: com.soft.blued.app.InitTaskUtil.1.25
                    @Override // com.blued.android.framework.init.InitTask
                    public void b() {
                        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
                            InitTaskUtil.initKSSDK();
                        }
                    }
                });
                arrayList2.add(new InitTask("HW") { // from class: com.soft.blued.app.InitTaskUtil.1.26
                    @Override // com.blued.android.framework.init.InitTask
                    public void b() {
                        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
                            InitTaskUtil.initHWADSDK();
                        }
                    }
                });
                arrayList2.add(new InitTask("Bugly") { // from class: com.soft.blued.app.InitTaskUtil.1.27
                    @Override // com.blued.android.framework.init.InitTask
                    public void b() {
                        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
                            InitTaskUtil.initBuglyCrash(AppInfo.d());
                        }
                    }
                });
                arrayList2.add(new InitTask("ByteDanceLog") { // from class: com.soft.blued.app.InitTaskUtil.1.28
                    @Override // com.blued.android.framework.init.InitTask
                    public void b() {
                        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
                            try {
                                InitTaskUtil.initByteDanceSDK();
                            } catch (Exception e) {
                            }
                        }
                    }
                });
                arrayList2.add(new InitTask("推送") { // from class: com.soft.blued.app.InitTaskUtil.1.29
                    @Override // com.blued.android.framework.init.InitTask
                    public void b() {
                        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
                            InitTaskUtil.initPush();
                        }
                    }

                    @Override // com.blued.android.framework.init.InitTask
                    public boolean d() {
                        return true;
                    }

                    @Override // com.blued.android.framework.init.InitTask
                    public boolean e() {
                        return false;
                    }
                });
                arrayList2.add(new InitTask("腾讯一键登录") { // from class: com.soft.blued.app.InitTaskUtil.1.30
                    @Override // com.blued.android.framework.init.InitTask
                    public void b() {
                        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
                            InitTaskUtil.initTXSDK();
                        }
                    }

                    @Override // com.blued.android.framework.init.InitTask
                    public boolean d() {
                        return true;
                    }

                    @Override // com.blued.android.framework.init.InitTask
                    public boolean e() {
                        return false;
                    }
                });
                arrayList2.add(new InitTask("YouZanSDK初始化") { // from class: com.soft.blued.app.InitTaskUtil.1.31
                    @Override // com.blued.android.framework.init.InitTask
                    public void b() {
                        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
                            InitTaskUtil.initYouZanSDK();
                        }
                    }

                    @Override // com.blued.android.framework.init.InitTask
                    public boolean d() {
                        return true;
                    }

                    @Override // com.blued.android.framework.init.InitTask
                    public boolean e() {
                        return false;
                    }
                });
                arrayList2.add(new InitTask("自研设备指纹SDK初始化") { // from class: com.soft.blued.app.InitTaskUtil.1.32
                    @Override // com.blued.android.framework.init.InitTask
                    public void b() {
                        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
                            BluedFingerPrintUtils.a();
                        }
                    }
                });
                arrayList2.add(new InitTask("微盟SDK初始化") { // from class: com.soft.blued.app.InitTaskUtil.1.33
                    @Override // com.blued.android.framework.init.InitTask
                    public void b() {
                        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
                            InitTaskUtil.initWMSDK();
                        }
                    }
                });
                arrayList2.add(new InitTask("网络图片本地映射MAP") { // from class: com.soft.blued.app.InitTaskUtil.1.34
                    @Override // com.blued.android.framework.init.InitTask
                    public void b() {
                        ImgURLMap.f10885a.a();
                    }
                });
            }
        };
    }

    public static boolean getStartAutoStartService() {
        return startAutoStartService;
    }

    public static void initBDSDK() {
        new BDAdConfig.Builder().setAppName("Blued").setAppsid("d51aa9ea").setHttps(false).build(AppInfo.d()).init();
    }

    public static void initBluedAPM() {
        BluedStatistics.a(AppInfo.d(), BluedHttpUrl.w(), 443, HappyDnsUtils.d());
        DisplayMetrics displayMetrics = AppInfo.d().getResources().getDisplayMetrics();
        BluedStatistics.a().g("android_china").e(AppInfo.f9487c).h(AppInfo.g).a(AppInfo.h).b(NetworkUtils.d()).a(DeviceUtils.d()).a(new Point(displayMetrics.widthPixels, displayMetrics.heightPixels));
    }

    public static void initBuglyCrash(Context context) {
        CrashReport.setIsDevelopmentDevice(context, false);
        CrashReport.UserStrategy userStrategy = new CrashReport.UserStrategy(context);
        userStrategy.setUploadProcess(BluedApplicationLike.isMainApplication(context));
        userStrategy.setCrashHandleCallback((CrashReport.CrashHandleCallback) new BuglyCrashRecorder());
        String str = "7.20.6.3";
        Log.i("initBuglyCrash", str);
        userStrategy.setAppVersion(str);
        CrashReport.setIsDevelopmentDevice(context, false);
        CrashReport.initCrashReport(context, "cf53dd5a91", false, userStrategy);
    }

    public static void initByteDanceSDK() {
        ByteDanceLogHelper.a(AppUtils.a(), AppInfo.f9487c);
        ByteDanceLogHelper.a(UserInfo.getInstance().getLoginUserInfo().getUid());
    }

    public static void initHWADSDK() {
        HwAds.init(AppInfo.d());
        HiAd.getInstance(AppInfo.d()).enableUserInfo(true);
        HiAd.getInstance(AppInfo.d()).initLog(true, 4);
    }

    public static void initKSSDK() {
        KsAdSDK.init(AppInfo.d(), new SdkConfig.Builder().appId("683400001").showNotification(true).debug(AppInfo.m()).setInitCallback(new KsInitCallback() { // from class: com.soft.blued.app.InitTaskUtil.4
            @Override // com.kwad.sdk.api.KsInitCallback
            public void onFail(int i, String str) {
                Log.i("drb", "init fail code:" + i + "--msg:" + str);
            }

            @Override // com.kwad.sdk.api.KsInitCallback
            public void onSuccess() {
                Log.i("drb", "init success");
            }
        }).build());
    }

    public static void initLoginSplash() {
        LoginPreLoad.f20592a.b();
    }

    public static void initMap() {
        ServiceSettings.updatePrivacyShow(AppUtils.a(), true, true);
        ServiceSettings.updatePrivacyAgree(AppUtils.a(), true);
    }

    public static void initOPPOAdSDK() {
        MobAdManager.getInstance().init(AppInfo.d(), "403632", new InitParams.Builder().setDebug(AppInfo.m()).build(), new IInitListener() { // from class: com.soft.blued.app.InitTaskUtil.3
            @Override // com.heytap.msp.mobad.api.listener.IInitListener
            public void onFailed(String str) {
                Log.v("drb", "oppo初始化失败：" + str);
            }

            @Override // com.heytap.msp.mobad.api.listener.IInitListener
            public void onSuccess() {
                Log.v("drb", "oppo初始化成功");
            }
        });
    }

    public static void initPush() {
        PushManager.a().a(AppInfo.d());
    }

    public static void initTTAdSDK() {
        TTAdManagerHolder.b(AppInfo.d());
    }

    public static void initTXSDK() {
        OneKeyLoginManager.getInstance().init(AppInfo.d(), BluedApplicationLike.TX_LOGIN_APPKEY, new InitListener() { // from class: com.soft.blued.app.InitTaskUtil.2
            @Override // com.tencent.tendinsv.listener.InitListener
            public void getInitStatus(int i, String str) {
                Log.v("drb", "腾讯一键登录SDK初始化 code：" + i + " result：" + str);
            }
        });
    }

    public static void initTopOnAdSDK() {
        GlobalSetting.setAgreePrivacyStrategy(false);
        ATSDK.deniedUploadDeviceInfo("mac");
        ATSDK.setNetworkLogDebug(AppInfo.m());
        ATSDK.integrationChecking(AppInfo.d());
        ATSDK.init(AppInfo.d(), "a6088f098f2534", "a11c38eb18d1d5ade5bfe7053852313b");
    }

    public static void initUMeng() {
        UMConfigure.preInit(AppInfo.d(), BluedApplicationLike.umengAppKey, AppInfo.f9487c);
    }

    public static void initWMSDK() {
        WebViewSdk.getInstance().init("wmsdk.n.weimob.com");
    }

    public static void initYouZanSDK() {
        YouZanUtils.a();
    }

    public static void initZego() {
        if (BluedApplicationLike.isMainApplication(AppInfo.d())) {
            ZegoCommonHelper.a();
        }
    }

    public static void setStartAutoStartService(boolean z) {
        startAutoStartService = z;
    }
}
