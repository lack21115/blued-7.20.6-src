package com.soft.blued.utils.third;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.CommonPreferences;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.LocationProvider;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTLocation;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/third/TTADUtils.class */
public class TTADUtils {

    /* renamed from: com.soft.blued.utils.third.TTADUtils$6  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/third/TTADUtils$6.class */
    class AnonymousClass6 implements TTAdNative.NativeAdListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TTGetOriginAdListener f34842a;

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int i, String str) {
            Log.v("drb", "穿山甲原生失败：" + i + " -- " + str);
            TTGetOriginAdListener tTGetOriginAdListener = this.f34842a;
            if (tTGetOriginAdListener != null) {
                tTGetOriginAdListener.a(i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener
        public void onNativeAdLoad(List<TTNativeAd> list) {
            if (this.f34842a != null) {
                if (list == null || list.get(0) == null || list.get(0).getImageList() == null || list.get(0).getImageList().isEmpty()) {
                    this.f34842a.a();
                } else {
                    this.f34842a.a(list.get(0));
                }
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/third/TTADUtils$TTGetAdListener.class */
    public interface TTGetAdListener {
        void a();

        void a(int i, String str);

        void a(TTFeedAd tTFeedAd);
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/third/TTADUtils$TTGetAdTemplateListener.class */
    public interface TTGetAdTemplateListener {
        void a();

        void a(int i, String str);

        void a(TTNativeExpressAd tTNativeExpressAd);
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/third/TTADUtils$TTGetOriginAdListener.class */
    public interface TTGetOriginAdListener {
        void a();

        void a(int i, String str);

        void a(TTNativeAd tTNativeAd);
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/third/TTADUtils$TTGetSplashAdListener.class */
    public interface TTGetSplashAdListener {
        void a();

        void a(int i, String str);

        void a(TTSplashAd tTSplashAd);
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/third/TTADUtils$TTOriginAdListener.class */
    public interface TTOriginAdListener {
        void a();

        void a(int i, String str);

        void a(TTFeedAd tTFeedAd);
    }

    public static void a(Context context) {
        TTAdSdk.init(context, new TTAdConfig.Builder().appId("5042793").useTextureView(false).appName("Blued_android").titleBarTheme(1).allowShowNotify(true).allowShowPageWhenScreenLock(false).directDownloadNetworkType(4, 3).supportMultiProcess(false).customController(new TTCustomController() { // from class: com.soft.blued.utils.third.TTADUtils.2
            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public LocationProvider getTTLocation() {
                try {
                    return new TTLocation(Float.parseFloat(CommonPreferences.v()), Float.parseFloat(CommonPreferences.u()));
                } catch (Exception e) {
                    return new TTLocation(0.0d, 0.0d);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseAndroidId() {
                return false;
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseLocation() {
                return false;
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUsePermissionRecordAudio() {
                return false;
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUsePhoneState() {
                return false;
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseWifiState() {
                return false;
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseWriteExternal() {
                return false;
            }
        }).build(), new TTAdSdk.InitCallback() { // from class: com.soft.blued.utils.third.TTADUtils.1
            @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
            public void fail(int i, String str) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
            public void success() {
            }
        });
    }

    public static void a(Context context, String str, final TTGetAdListener tTGetAdListener) {
        if (Build.VERSION.SDK_INT < 21) {
            tTGetAdListener.a();
            return;
        }
        TTAdSdk.getAdManager().createAdNative(context).loadFeedAd(new AdSlot.Builder().setCodeId(str).setSupportDeepLink(true).setImageAcceptedSize(228, 150).setAdCount(1).build(), new TTAdNative.FeedAdListener() { // from class: com.soft.blued.utils.third.TTADUtils.4
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
            public void onError(int i, String str2) {
                TTGetAdListener tTGetAdListener2 = TTGetAdListener.this;
                if (tTGetAdListener2 != null) {
                    tTGetAdListener2.a(i, str2);
                }
                Log.v("drb", "banner2 穿山甲广告：" + i + " -- " + str2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onFeedAdLoad(List<TTFeedAd> list) {
                if (TTGetAdListener.this != null) {
                    if (list == null || list.get(0) == null) {
                        TTGetAdListener.this.a();
                    } else {
                        TTGetAdListener.this.a(list.get(0));
                    }
                }
                Log.v("drb", "banner2 穿山甲广告 加载成功");
            }
        });
    }

    public static void a(Context context, String str, final TTGetAdTemplateListener tTGetAdTemplateListener) {
        Log.v("drb", "穿山甲 模板渲染Banner广告 thirdId:" + str);
        int b = DensityUtils.b(context, (float) AppInfo.l) - DensityUtils.b(context, 80.0f);
        TTAdSdk.getAdManager().createAdNative(context).loadBannerExpressAd(new AdSlot.Builder().setCodeId(str).setSupportDeepLink(true).setAdCount(1).setExpressViewAcceptedSize((float) b, (float) (b / 4)).setAdLoadType(TTAdLoadType.PRELOAD).build(), new TTAdNative.NativeExpressAdListener() { // from class: com.soft.blued.utils.third.TTADUtils.3
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
            public void onError(int i, String str2) {
                TTGetAdTemplateListener tTGetAdTemplateListener2 = TTGetAdTemplateListener.this;
                if (tTGetAdTemplateListener2 != null) {
                    tTGetAdTemplateListener2.a(i, str2);
                }
                Log.v("drb", "banner1穿山甲广告：" + i + " -- " + str2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                Log.v("drb", "banner1穿山甲广告：请求成功回调onNativeExpressAdLoad");
                if (TTGetAdTemplateListener.this != null) {
                    if (list == null || list.get(0) == null) {
                        TTGetAdTemplateListener.this.a();
                    } else {
                        TTGetAdTemplateListener.this.a(list.get(0));
                    }
                }
            }
        });
    }

    public static void a(Context context, String str, final TTGetSplashAdListener tTGetSplashAdListener) {
        TTAdManagerHolder.a(context).createAdNative(context).loadSplashAd(new AdSlot.Builder().setCodeId(str).setSupportDeepLink(true).setImageAcceptedSize(AppInfo.l, AppInfo.m - DensityUtils.a(context, 75.0f)).build(), new TTAdNative.SplashAdListener() { // from class: com.soft.blued.utils.third.TTADUtils.7
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
            public void onError(int i, String str2) {
                TTGetSplashAdListener tTGetSplashAdListener2 = TTGetSplashAdListener.this;
                if (tTGetSplashAdListener2 != null) {
                    tTGetSplashAdListener2.a(i, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
            public void onSplashAdLoad(TTSplashAd tTSplashAd) {
                TTGetSplashAdListener tTGetSplashAdListener2 = TTGetSplashAdListener.this;
                if (tTGetSplashAdListener2 != null) {
                    tTGetSplashAdListener2.a(tTSplashAd);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
            public void onTimeout() {
                TTGetSplashAdListener tTGetSplashAdListener2 = TTGetSplashAdListener.this;
                if (tTGetSplashAdListener2 != null) {
                    tTGetSplashAdListener2.a();
                }
            }
        }, 300);
    }

    public static void a(Context context, String str, final TTOriginAdListener tTOriginAdListener) {
        int a2 = AppInfo.l - DensityUtil.a(95.0f);
        AdSlot.Builder adLoadType = new AdSlot.Builder().setCodeId(str).setImageAcceptedSize(a2, (a2 / 16) * 9).setAdCount(1).setAdLoadType(TTAdLoadType.PRELOAD);
        float f = 60;
        TTAdManagerHolder.a(context).createAdNative(context).loadFeedAd(adLoadType.setExpressViewAcceptedSize(f, f).build(), new TTAdNative.FeedAdListener() { // from class: com.soft.blued.utils.third.TTADUtils.5
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
            public void onError(int i, String str2) {
                Log.v("drb", "穿山甲原生失败：" + i + " -- " + str2);
                TTOriginAdListener tTOriginAdListener2 = TTOriginAdListener.this;
                if (tTOriginAdListener2 != null) {
                    tTOriginAdListener2.a(i, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onFeedAdLoad(List<TTFeedAd> list) {
                if (TTOriginAdListener.this != null) {
                    if (list == null || list.get(0) == null) {
                        TTOriginAdListener.this.a();
                    } else {
                        TTOriginAdListener.this.a(list.get(0));
                    }
                }
                Log.v("drb", "穿山甲原生广告 加载成功");
            }
        });
    }
}
