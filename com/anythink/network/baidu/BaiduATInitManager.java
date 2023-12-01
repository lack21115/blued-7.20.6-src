package com.anythink.network.baidu;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.MediationInitCallback;
import com.baidu.mobads.sdk.api.BDAdConfig;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.igexin.push.config.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/BaiduATInitManager.class */
public class BaiduATInitManager extends ATInitMediation {
    protected static final String d = "AT_BAIDU_C2S_";
    private static volatile BaiduATInitManager e;

    /* renamed from: a  reason: collision with root package name */
    Map<String, Map<String, BaiduATBiddingInfo>> f8864a;
    private boolean f;
    private List<MediationInitCallback> h;
    boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    int f8865c = 0;
    private final Object i = new Object();
    private AtomicBoolean g = new AtomicBoolean(false);

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/BaiduATInitManager$InitCallback.class */
    public interface InitCallback {
        void onError(Throwable th);

        void onSuccess();
    }

    private BaiduATInitManager() {
    }

    private BaiduATBiddingInfo a(String str, String str2) {
        Map<String, BaiduATBiddingInfo> map;
        synchronized (this) {
            if (this.f8864a == null || (map = this.f8864a.get(str)) == null) {
                return null;
            }
            return map.remove(str2);
        }
    }

    private String a(String str, Object obj, double d2, Object obj2) {
        String str2;
        synchronized (this) {
            if (this.f8864a == null) {
                this.f8864a = new ConcurrentHashMap(3);
            }
            Map<String, BaiduATBiddingInfo> map = this.f8864a.get(str);
            ConcurrentHashMap concurrentHashMap = map;
            if (map == null) {
                concurrentHashMap = new ConcurrentHashMap(2);
                this.f8864a.put(str, concurrentHashMap);
            }
            str2 = d + UUID.randomUUID().toString();
            concurrentHashMap.put(str2, new BaiduATBiddingInfo(obj, d2, obj2));
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, Throwable th) {
        synchronized (this.i) {
            int size = this.h.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size) {
                    MediationInitCallback mediationInitCallback = this.h.get(i2);
                    if (mediationInitCallback != null) {
                        if (z) {
                            mediationInitCallback.onSuccess();
                        } else {
                            mediationInitCallback.onFail(th.getMessage());
                        }
                    }
                    i = i2 + 1;
                } else {
                    this.h.clear();
                    this.g.set(false);
                }
            }
        }
    }

    static /* synthetic */ boolean a(BaiduATInitManager baiduATInitManager) {
        baiduATInitManager.f = true;
        return true;
    }

    private void b(String str, String str2) {
        Map<String, BaiduATBiddingInfo> map;
        synchronized (this) {
            if (this.f8864a != null && (map = this.f8864a.get(str)) != null) {
                map.remove(str2);
            }
        }
    }

    public static BaiduATInitManager getInstance() {
        if (e == null) {
            synchronized (BaiduATInitManager.class) {
                try {
                    if (e == null) {
                        e = new BaiduATInitManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return e;
    }

    public static void printLog(String str) {
        if (ATSDK.isNetworkLogDebug()) {
            Log.d("anythink_baidu_log", str);
        }
    }

    @Override // com.anythink.core.api.ATInitMediation
    public List getActivityStatus() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.baidu.mobads.sdk.api.AppActivity");
        arrayList.add("com.baidu.mobads.sdk.api.MobRewardVideoActivity");
        return arrayList;
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkName() {
        return "Baidu";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkSDKClass() {
        return "com.baidu.mobads.sdk.api.BDAdConfig";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkVersion() {
        return BaiduATConst.getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATInitMediation
    public List getProviderStatus() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.baidu.mobads.sdk.api.BdFileProvider");
        return arrayList;
    }

    public void initSDK(Context context, Map<String, Object> map) {
        synchronized (this) {
            initSDK(context, map, null);
        }
    }

    @Override // com.anythink.core.api.ATInitMediation
    public void initSDK(Context context, Map<String, Object> map, MediationInitCallback mediationInitCallback) {
        synchronized (this) {
            initSDK(context, map, false, mediationInitCallback);
        }
    }

    public void initSDK(Context context, Map<String, Object> map, boolean z, MediationInitCallback mediationInitCallback) {
        synchronized (this) {
            try {
                this.f8865c = ATSDK.getPersionalizedAdStatus();
            } catch (Throwable th) {
            }
            MobadsPermissionSettings.setLimitPersonalAds(this.f8865c == 2);
            if (!this.b) {
                MobadsPermissionSettings.setPermissionReadDeviceID(true);
                MobadsPermissionSettings.setPermissionOAID(true);
                MobadsPermissionSettings.setPermissionAppList(true);
                MobadsPermissionSettings.setPermissionStorage(true);
                MobadsPermissionSettings.setPermissionLocation(true);
            }
            if (ATSDK.isNetworkLogDebug()) {
                Log.i("BaiduATInitManager", "MobadsPermissionSettings.getLimitPersonalAdsStatus():" + MobadsPermissionSettings.getLimitPersonalAdsStatus());
            }
            if (z) {
                this.f = false;
            }
            if (this.f) {
                if (mediationInitCallback != null) {
                    mediationInitCallback.onSuccess();
                }
                return;
            }
            synchronized (this.i) {
                if (this.g.get()) {
                    if (mediationInitCallback != null) {
                        this.h.add(mediationInitCallback);
                    }
                    return;
                }
                if (this.h == null) {
                    this.h = new ArrayList();
                }
                this.g.set(true);
                String str = (String) map.get("app_id");
                if (mediationInitCallback != null) {
                    this.h.add(mediationInitCallback);
                }
                new BDAdConfig.Builder().setAppsid(str).setHttps(false).build(context.getApplicationContext()).init();
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.anythink.network.baidu.BaiduATInitManager.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaiduATInitManager.a(BaiduATInitManager.this);
                        BaiduATInitManager.this.a(true, (Throwable) null);
                    }
                }, c.j);
            }
        }
    }

    public void setBaiduATCustomController(BaiduATCustomController baiduATCustomController) {
        if (baiduATCustomController != null) {
            MobadsPermissionSettings.setPermissionReadDeviceID(baiduATCustomController.getPermissionReadDeviceID());
            MobadsPermissionSettings.setPermissionLocation(baiduATCustomController.getPermissionLocation());
            MobadsPermissionSettings.setPermissionStorage(baiduATCustomController.getPermissionStorage());
            MobadsPermissionSettings.setPermissionAppList(baiduATCustomController.getPermissionAppList());
            MobadsPermissionSettings.setPermissionOAID(baiduATCustomController.getPermissionOAID());
            MobadsPermissionSettings.setPermissionDeviceInfo(baiduATCustomController.getPermissionDeviceInfo());
            MobadsPermissionSettings.setPermissionAppUpdate(baiduATCustomController.getPermissionAppUpdate());
            MobadsPermissionSettings.setPermissionRunningApp(baiduATCustomController.getPermissionRunningApp());
            this.b = true;
        }
    }
}
