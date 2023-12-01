package com.anythink.network.gdt;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATBidRequestInfo;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.core.common.b.g;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/gdt/GDTATInitManager.class */
public class GDTATInitManager extends ATInitMediation {
    public static final String TAG = GDTATInitManager.class.getSimpleName();
    private static volatile GDTATInitManager b;
    private boolean f;
    private String g;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, WeakReference> f8934c = new ConcurrentHashMap();
    private Map<String, RewardVideoAD> d = new ConcurrentHashMap();
    private Map<String, UnifiedInterstitialAD> e = new ConcurrentHashMap();
    private final Object h = new Object();

    /* renamed from: a  reason: collision with root package name */
    int f8933a = 0;

    private GDTATInitManager() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int a(Context context, float f) {
        float f2 = context.getResources().getDisplayMetrics().density;
        float f3 = f2;
        if (f2 <= 0.0f) {
            f3 = 1.0f;
        }
        return (int) ((f / f3) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static LoadAdParams a(Map<String, Object> map) {
        LoadAdParams loadAdParams = new LoadAdParams();
        HashMap hashMap = new HashMap();
        a(hashMap, map);
        loadAdParams.setDevExtra(hashMap);
        return loadAdParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Map map, Map<String, Object> map2) {
        try {
            Object obj = map2.get(g.k.n);
            map.put("staIn", obj != null ? obj.toString() : "");
            map.put("meSrc", "299");
            Object obj2 = map2.get(g.k.m);
            map.put("thrmei", obj2 != null ? obj2.toString() : "");
        } catch (Exception e) {
        }
    }

    private void c() {
        try {
            for (Map.Entry<String, WeakReference> entry : this.f8934c.entrySet()) {
                if (entry.getValue().get() == 0) {
                    this.f8934c.remove(entry.getKey());
                }
            }
        } catch (Throwable th) {
        }
    }

    public static GDTATInitManager getInstance() {
        if (b == null) {
            synchronized (GDTATInitManager.class) {
                try {
                    if (b == null) {
                        b = new GDTATInitManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        this.d.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Context context, final Map<String, Object> map, final Map<String, Object> map2, final ATBidRequestInfoListener aTBidRequestInfoListener) {
        getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.gdt.GDTATInitManager.1
            @Override // com.anythink.core.api.MediationInitCallback
            public final void onFail(String str) {
                ATBidRequestInfoListener aTBidRequestInfoListener2 = aTBidRequestInfoListener;
                if (aTBidRequestInfoListener2 != null) {
                    aTBidRequestInfoListener2.onFailed(ATBidRequestInfo.INIT_ERROR_TYPE);
                }
            }

            @Override // com.anythink.core.api.MediationInitCallback
            public final void onSuccess() {
                GDTATInitManager.this.runOnThreadPool(new Runnable() { // from class: com.anythink.network.gdt.GDTATInitManager.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        GDTBidRequestInfo gDTBidRequestInfo;
                        synchronized (GDTATInitManager.this.h) {
                            gDTBidRequestInfo = new GDTBidRequestInfo(map);
                        }
                        if (gDTBidRequestInfo.isValid()) {
                            if (aTBidRequestInfoListener != null) {
                                aTBidRequestInfoListener.onSuccess(gDTBidRequestInfo);
                            }
                        } else if (aTBidRequestInfoListener != null) {
                            aTBidRequestInfoListener.onFailed(ATBidRequestInfo.BIDTOKEN_EMPTY_ERROR_TYPE);
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(String str, UnifiedInterstitialAD unifiedInterstitialAD) {
        this.e.clear();
        this.e.put(str, unifiedInterstitialAD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(String str, RewardVideoAD rewardVideoAD) {
        this.d.clear();
        this.d.put(str, rewardVideoAD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(String str, WeakReference weakReference) {
        try {
            this.f8934c.put(str, weakReference);
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        this.e.clear();
    }

    @Override // com.anythink.core.api.ATInitMediation
    public List getActivityStatus() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.qq.e.ads.ADActivity");
        arrayList.add("com.qq.e.ads.PortraitADActivity");
        arrayList.add("com.qq.e.ads.LandscapeADActivity");
        arrayList.add("com.qq.e.ads.RewardvideoPortraitADActivity");
        arrayList.add("com.qq.e.ads.RewardvideoLandscapeADActivity");
        return arrayList;
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkName() {
        return "Tencent";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkSDKClass() {
        return "com.qq.e.ads.ADActivity";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkVersion() {
        return GDTATConst.getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATInitMediation
    public List getServiceStatus() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.qq.e.comm.DownloadService");
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
            try {
                this.f8933a = ATSDK.getPersionalizedAdStatus();
            } catch (Throwable th) {
            }
            if (this.f8933a == 2) {
                GlobalSetting.setPersonalizedState(1);
            } else {
                GlobalSetting.setPersonalizedState(0);
            }
            if (ATSDK.isNetworkLogDebug()) {
                String str = TAG;
                Log.i(str, "GlobalSetting.getPersonalizedState():" + GlobalSetting.getPersonalizedState());
            }
            c();
            String stringFromMap = getStringFromMap(map, "app_id");
            if (map.containsKey(ATInitMediation.KEY_LOCAL)) {
                this.g = stringFromMap;
            } else if (this.g != null && !TextUtils.equals(this.g, stringFromMap)) {
                checkToSaveInitData(getNetworkName(), map, this.g);
                this.g = null;
            }
            if (!this.f) {
                GDTAdSdk.init(context.getApplicationContext(), stringFromMap);
                this.f = true;
            }
            if (mediationInitCallback != null) {
                mediationInitCallback.onSuccess();
            }
        }
    }

    public void setGDTATCustomController(GDTATCustomController gDTATCustomController) {
        if (gDTATCustomController != null) {
            GlobalSetting.setAgreePrivacyStrategy(gDTATCustomController.getAgreePrivacyStrategy());
        }
    }
}
