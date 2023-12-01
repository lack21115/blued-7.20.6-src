package com.kwad.components.splash;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.igexin.push.core.b;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.components.core.video.h;
import com.kwad.components.splash.monitor.SplashMonitorInfo;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.network.kwai.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.i;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/splash/SplashPreloadManager.class */
public final class SplashPreloadManager {
    private HashMap<String, PreLoadItem> Ya;
    private List<String> Yb;
    private volatile SharedPreferences Yc;
    private final Object mLock;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/splash/SplashPreloadManager$PreLoadItem.class */
    public static class PreLoadItem extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public long cacheTime;
        public long expiredTime;
        public String preloadId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/splash/SplashPreloadManager$a.class */
    public static final class a {
        private static final SplashPreloadManager Yd = new SplashPreloadManager((byte) 0);
    }

    private SplashPreloadManager() {
        this.mLock = new Object();
        this.Ya = new HashMap<>();
        this.Yb = new ArrayList();
        init();
    }

    /* synthetic */ SplashPreloadManager(byte b) {
        this();
    }

    private static boolean aV(String str) {
        if (str != null) {
            File aX = com.kwad.sdk.core.diskcache.a.a.vs().aX(str);
            StringBuilder sb = new StringBuilder("check preloadId ");
            sb.append(str);
            sb.append(" file exists ");
            sb.append(aX == null ? b.l : Boolean.valueOf(aX.exists()));
            com.kwad.sdk.core.d.b.d("PreloadManager", sb.toString());
            return aX != null && aX.exists();
        }
        return false;
    }

    public static File aW(String str) {
        if (str != null) {
            com.kwad.sdk.core.d.b.d("PreloadManager", "getVideoFile preloadId " + str + "  url " + str);
            File aX = com.kwad.sdk.core.diskcache.a.a.vs().aX(str);
            if (aX == null || !aX.exists()) {
                return null;
            }
            return aX;
        }
        return null;
    }

    public static boolean g(AdResultData adResultData) {
        if (adResultData.getAdTemplateList().isEmpty()) {
            return false;
        }
        AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
        if (adTemplate.adInfoList.isEmpty()) {
            return false;
        }
        return com.kwad.sdk.core.response.a.a.aV(adTemplate.adInfoList.get(0));
    }

    private void init() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null) {
            this.Yc = context.getSharedPreferences("ksadsdk_splash_preload_id_list", 0);
            initData();
        }
    }

    private void initData() {
        Map<String, ?> all = this.Yc.getAll();
        ArrayList<String> arrayList = new ArrayList();
        for (String str : all.keySet()) {
            PreLoadItem preLoadItem = new PreLoadItem();
            try {
                Object obj = all.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!TextUtils.isEmpty(str2)) {
                        preLoadItem.parseJson(new JSONObject(str2));
                        if (!TextUtils.isEmpty(preLoadItem.preloadId)) {
                            File aX = com.kwad.sdk.core.diskcache.a.a.vs().aX(preLoadItem.preloadId);
                            if (aX == null || !aX.exists()) {
                                arrayList.add(preLoadItem.preloadId);
                                com.kwad.sdk.core.d.b.d("PreloadManager", "Remove null file list " + preLoadItem.preloadId);
                            } else {
                                synchronized (this.mLock) {
                                    this.Ya.put(str, preLoadItem);
                                    if (!this.Yb.contains(str)) {
                                        this.Yb.add(str);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.printStackTrace(e);
            }
        }
        SharedPreferences.Editor edit = this.Yc.edit();
        for (String str3 : arrayList) {
            edit.remove(str3);
        }
        edit.apply();
    }

    private void rU() {
        int size;
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.mLock) {
            ArrayList<String> arrayList = new ArrayList();
            for (String str2 : this.Ya.keySet()) {
                PreLoadItem preLoadItem = this.Ya.get(str2);
                if (preLoadItem != null && preLoadItem.expiredTime < currentTimeMillis) {
                    arrayList.add(str2);
                }
            }
            SharedPreferences.Editor edit = this.Yc.edit();
            for (String str3 : arrayList) {
                this.Yb.remove(str3);
                this.Ya.remove(str3);
                edit.remove(str3);
                com.kwad.sdk.core.diskcache.a.a.vs().remove(str3);
            }
            edit.apply();
            size = this.Yb.size();
        }
        if (size <= 30) {
            return;
        }
        com.kwad.sdk.core.d.b.d("PreloadManager", "大于 30 按失效日期远近顺序移除");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size - 15) {
                return;
            }
            long j = Long.MAX_VALUE;
            synchronized (this.mLock) {
                str = "";
                for (PreLoadItem preLoadItem2 : this.Ya.values()) {
                    if (preLoadItem2.expiredTime < j) {
                        j = preLoadItem2.expiredTime;
                        str = preLoadItem2.preloadId;
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    this.Yb.remove(str);
                    this.Ya.remove(str);
                    this.Yc.edit().remove(str).apply();
                    com.kwad.sdk.core.d.b.d("PreloadManager", "移除 preloadId = " + str + " expiredTime =  " + j);
                }
            }
            if (!TextUtils.isEmpty(str)) {
                com.kwad.sdk.core.diskcache.a.a.vs().remove(str);
            }
            i = i2 + 1;
        }
    }

    public static SplashPreloadManager rV() {
        SplashPreloadManager splashPreloadManager = a.Yd;
        if (splashPreloadManager.Yc == null) {
            splashPreloadManager.init();
        }
        return splashPreloadManager;
    }

    private void y(AdInfo adInfo) {
        PreLoadItem preLoadItem = new PreLoadItem();
        preLoadItem.cacheTime = System.currentTimeMillis();
        preLoadItem.expiredTime = System.currentTimeMillis() + (adInfo.adPreloadInfo.validityPeriod * 1000);
        preLoadItem.preloadId = com.kwad.sdk.core.response.a.a.aS(adInfo);
        synchronized (this.mLock) {
            this.Ya.put(adInfo.adPreloadInfo.preloadId, preLoadItem);
            if (!this.Yb.contains(adInfo.adPreloadInfo.preloadId)) {
                this.Yb.add(adInfo.adPreloadInfo.preloadId);
            }
        }
        if (this.Yc != null) {
            SharedPreferences.Editor edit = this.Yc.edit();
            edit.putString(adInfo.adPreloadInfo.preloadId, preLoadItem.toJson().toString());
            edit.apply();
        }
    }

    public final int b(AdResultData adResultData, boolean z) {
        AdTemplate adTemplate;
        int i;
        long j;
        String str;
        Iterator<AdTemplate> it = adResultData.getAdTemplateList().iterator();
        com.kwad.components.splash.monitor.a.rY();
        com.kwad.components.splash.monitor.a.h(adResultData);
        int i2 = 0;
        while (true) {
            adTemplate = null;
            if (!it.hasNext()) {
                break;
            }
            AdTemplate next = it.next();
            if (next != null) {
                Iterator<AdInfo> it2 = next.adInfoList.iterator();
                int i3 = i2;
                while (true) {
                    i2 = i3;
                    if (it2.hasNext()) {
                        AdInfo next2 = it2.next();
                        if (next2.adPreloadInfo == null || this.Yc == null) {
                            com.kwad.components.splash.monitor.a.rY();
                            i = 3;
                            j = next.posId;
                            str = SplashMonitorInfo.ERROR_PRELOAD_ID_INVALID_MSG;
                        } else {
                            long elapsedRealtime = SystemClock.elapsedRealtime();
                            if (aV(next2.adPreloadInfo.preloadId)) {
                                com.kwad.components.splash.monitor.a.rY();
                                com.kwad.components.splash.monitor.a.a(next2, SystemClock.elapsedRealtime() - elapsedRealtime, 2, next.posId);
                                y(next2);
                                i3++;
                            } else {
                                String E = com.kwad.sdk.core.response.a.a.aU(next2) ? com.kwad.sdk.core.response.a.a.E(next2) : com.kwad.sdk.core.response.a.a.aV(next2) ? com.kwad.sdk.core.response.a.a.aM(next2).materialUrl : null;
                                if (TextUtils.isEmpty(E)) {
                                    com.kwad.components.splash.monitor.a.rY();
                                    i = 2;
                                    j = next.posId;
                                    str = SplashMonitorInfo.ERROR_URL_INVALID_MSG;
                                } else {
                                    String aS = com.kwad.sdk.core.response.a.a.aS(next2);
                                    if (next2.adPreloadInfo.preloadType != 1 || ag.isWifiConnected(KsAdSDKImpl.get().getContext()) || z) {
                                        com.kwad.sdk.core.d.b.d("PreloadManager", "start Download preloadId " + aS + " true url " + E);
                                        rU();
                                        a.C0394a c0394a = new a.C0394a();
                                        if (h.a(E, aS, c0394a)) {
                                            y(next2);
                                            i3++;
                                            com.kwad.components.splash.monitor.a.rY();
                                            com.kwad.components.splash.monitor.a.a(next2, SystemClock.elapsedRealtime() - elapsedRealtime, 1, next.posId);
                                        } else {
                                            com.kwad.components.splash.monitor.a.rY();
                                            com.kwad.components.splash.monitor.a.a(next2, 4, c0394a.msg, next.posId);
                                            com.kwad.components.core.m.a.pb().b(next, 1, c0394a.msg);
                                        }
                                    } else {
                                        com.kwad.components.splash.monitor.a.rY();
                                        com.kwad.components.splash.monitor.a.a(next2, 1, SplashMonitorInfo.ERROR_NET_MSG, next.posId);
                                    }
                                }
                            }
                        }
                        com.kwad.components.splash.monitor.a.a(next2, i, str, j);
                    }
                }
            }
        }
        if (adResultData.getAdTemplateList().size() > 0) {
            adTemplate = adResultData.getAdTemplateList().get(0);
        }
        if (i2 <= 0) {
            i.Z("splashAd_", "onSplashVideoAdCacheFailed");
            return i2;
        }
        i.Z("splashAd_", "onSplashVideoAdCacheSuccess");
        com.kwad.components.core.m.a.pb().f(adTemplate, i2);
        return i2;
    }

    public final boolean f(AdResultData adResultData) {
        if (adResultData.getAdTemplateList().isEmpty()) {
            return false;
        }
        AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
        if (adTemplate.adInfoList.isEmpty()) {
            return false;
        }
        AdInfo adInfo = adTemplate.adInfoList.get(0);
        if (adInfo.adPreloadInfo != null) {
            return aV(com.kwad.sdk.core.response.a.a.aS(adInfo));
        }
        return false;
    }

    public final List<String> rW() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            com.kwad.sdk.core.d.b.d("PreloadManager", "getPreloadIdList start ");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.Yb.size()) {
                    String str = this.Yb.get(i2);
                    File aX = com.kwad.sdk.core.diskcache.a.a.vs().aX(str);
                    if (aX != null && aX.exists()) {
                        arrayList.add(str);
                    }
                    i = i2 + 1;
                } else {
                    com.kwad.sdk.core.d.b.d("PreloadManager", "getPreloadIdList end ");
                }
            }
        }
        com.kwad.sdk.core.d.b.d("PreloadManager", "getPreloadIdList " + this.Yb.size());
        return arrayList;
    }
}
