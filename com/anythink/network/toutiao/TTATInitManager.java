package com.anythink.network.toutiao;

import android.Manifest;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTClientBidding;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.cdo.oaps.ad.OapsKey;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/toutiao/TTATInitManager.class */
public class TTATInitManager extends ATInitMediation {
    public static final String TAG = TTATInitManager.class.getSimpleName();
    private static volatile TTATInitManager e;

    /* renamed from: a  reason: collision with root package name */
    TTCustomController f6260a;
    Map<String, Map<String, TTATBiddingInfo>> b;
    private boolean i;
    private List<MediationInitCallback> k;
    private Map<String, WeakReference> h = new ConcurrentHashMap();
    private final Object l = new Object();
    private final long m = 100;

    /* renamed from: c  reason: collision with root package name */
    int f6261c = 0;
    String d = OapsKey.KEY_PRICE;
    private Handler f = new Handler(Looper.getMainLooper());
    private boolean g = true;
    private AtomicBoolean j = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.network.toutiao.TTATInitManager$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/toutiao/TTATInitManager$1.class */
    public final class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f6262a;
        final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int[] f6263c;
        final /* synthetic */ Context d;

        AnonymousClass1(String str, String str2, int[] iArr, Context context) {
            this.f6262a = str;
            this.b = str2;
            this.f6263c = iArr;
            this.d = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                TTAdConfig.Builder supportMultiProcess = new TTAdConfig.Builder().appId(this.f6262a).useTextureView(true).appName(this.b).titleBarTheme(1).directDownloadNetworkType(this.f6263c).data(TTATInitManager.this.b()).supportMultiProcess(false);
                if (TTATInitManager.this.f6260a != null) {
                    supportMultiProcess.customController(TTATInitManager.this.f6260a);
                }
                TTAdSdk.init(this.d, supportMultiProcess.build(), new TTAdSdk.InitCallback() { // from class: com.anythink.network.toutiao.TTATInitManager.1.1
                    @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
                    public final void fail(int i, String str) {
                        TTATInitManager.a(TTATInitManager.this, false, String.valueOf(i), str);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
                    public final void success() {
                        TTATInitManager.this.f.postDelayed(new Runnable() { // from class: com.anythink.network.toutiao.TTATInitManager.1.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                TTATInitManager.b(TTATInitManager.this);
                                TTATInitManager.a(TTATInitManager.this, true, (String) null, (String) null);
                            }
                        }, 100L);
                    }
                });
            } catch (Throwable th) {
                TTATInitManager.a(TTATInitManager.this, false, "", th.getMessage());
            }
        }
    }

    private TTATInitManager() {
    }

    private void a() {
        try {
            for (Map.Entry<String, WeakReference> entry : this.h.entrySet()) {
                if (entry.getValue().get() == null) {
                    this.h.remove(entry.getKey());
                }
            }
        } catch (Throwable th) {
        }
    }

    static /* synthetic */ void a(TTATInitManager tTATInitManager, boolean z, String str, String str2) {
        synchronized (tTATInitManager.l) {
            int size = tTATInitManager.k.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size) {
                    MediationInitCallback mediationInitCallback = tTATInitManager.k.get(i2);
                    if (mediationInitCallback != null) {
                        if (z) {
                            mediationInitCallback.onSuccess();
                        } else {
                            mediationInitCallback.onFail(str + " | " + str2);
                        }
                    }
                    i = i2 + 1;
                } else {
                    tTATInitManager.k.clear();
                    tTATInitManager.j.set(false);
                }
            }
        }
    }

    private void a(boolean z, String str, String str2) {
        synchronized (this.l) {
            int size = this.k.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size) {
                    MediationInitCallback mediationInitCallback = this.k.get(i2);
                    if (mediationInitCallback != null) {
                        if (z) {
                            mediationInitCallback.onSuccess();
                        } else {
                            mediationInitCallback.onFail(str + " | " + str2);
                        }
                    }
                    i = i2 + 1;
                } else {
                    this.k.clear();
                    this.j.set(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b() {
        try {
            this.f6261c = ATSDK.getPersionalizedAdStatus();
        } catch (Throwable th) {
        }
        try {
            String str = this.f6261c == 2 ? "0" : "";
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", "personal_ads_type");
            jSONObject.put("value", str);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            String jSONArray2 = jSONArray.toString();
            if (ATSDK.isNetworkLogDebug()) {
                Log.i(TAG, "TTPrivateData:".concat(String.valueOf(jSONArray2)));
            }
            return jSONArray2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    static /* synthetic */ boolean b(TTATInitManager tTATInitManager) {
        tTATInitManager.i = true;
        return true;
    }

    public static TTATInitManager getInstance() {
        if (e == null) {
            synchronized (TTATInitManager.class) {
                try {
                    if (e == null) {
                        e = new TTATInitManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(String str, WeakReference weakReference) {
        try {
            this.h.put(str, weakReference);
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Map<String, Object> map, BaseAd baseAd, TTClientBidding tTClientBidding, ATBiddingListener aTBiddingListener) {
        synchronized (this) {
            if (aTBiddingListener != null) {
                double d = 0.0d;
                if (map.containsKey(this.d)) {
                    d = Double.parseDouble(String.valueOf(map.get(this.d)));
                }
                TTATBiddingNotify tTATBiddingNotify = new TTATBiddingNotify(tTClientBidding);
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d, sb.toString(), tTATBiddingNotify, ATAdConst.CURRENCY.RMB_CENT), baseAd);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Map<String, Object> map, TTClientBidding tTClientBidding, ATBiddingListener aTBiddingListener) {
        synchronized (this) {
            a(map, (BaseAd) null, tTClientBidding, aTBiddingListener);
        }
    }

    public String getNetworkName() {
        return "CSJ";
    }

    public String getNetworkSDKClass() {
        return "com.bytedance.sdk.openadsdk.TTAdSdk";
    }

    public String getNetworkVersion() {
        return TTATConst.getNetworkVersion();
    }

    public List getPermissionStatus() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Manifest.permission.WAKE_LOCK);
        return arrayList;
    }

    public List getProviderStatus() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.bytedance.sdk.openadsdk.multipro.TTMultiProvider");
        arrayList.add("com.bytedance.sdk.openadsdk.TTFileProvider");
        return arrayList;
    }

    public void initSDK(Context context, Map<String, Object> map) {
        initSDK(context, map, null);
    }

    public void initSDK(Context context, Map<String, Object> map, MediationInitCallback mediationInitCallback) {
        try {
            for (Map.Entry<String, WeakReference> entry : this.h.entrySet()) {
                if (entry.getValue().get() == null) {
                    this.h.remove(entry.getKey());
                }
            }
        } catch (Throwable th) {
        }
        if (TTAdSdk.isInitSuccess() || this.i) {
            TTAdSdk.updateAdConfig(new TTAdConfig.Builder().data(b()).build());
            if (mediationInitCallback != null) {
                mediationInitCallback.onSuccess();
                return;
            }
            return;
        }
        synchronized (this.l) {
            if (this.j.get()) {
                if (mediationInitCallback != null) {
                    this.k.add(mediationInitCallback);
                }
                return;
            }
            if (this.k == null) {
                this.k = new ArrayList();
            }
            this.j.set(true);
            String stringFromMap = getStringFromMap(map, "app_id");
            if (mediationInitCallback != null) {
                this.k.add(mediationInitCallback);
            }
            this.f.post(new AnonymousClass1(stringFromMap, context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString(), this.g ? new int[]{1, 2, 3, 4, 5} : new int[]{2}, context.getApplicationContext()));
        }
    }

    public void setIsOpenDirectDownload(boolean z) {
        this.g = z;
    }

    public void setTtCustomController(TTCustomController tTCustomController) {
        this.f6260a = tTCustomController;
    }
}
