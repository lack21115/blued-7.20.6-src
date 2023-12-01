package com.anythink.network.ks;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.MediationInitCallback;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/ks/KSATInitManager.class */
public class KSATInitManager extends ATInitMediation {
    private static final String d = KSATInitManager.class.getSimpleName();
    private static volatile KSATInitManager e;

    /* renamed from: a  reason: collision with root package name */
    Boolean f6147a;
    Boolean b;
    private boolean h;
    private KSATCustomController i;
    private final Object g = new Object();
    private Map<String, WeakReference> j = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    int f6148c = 0;
    private Handler f = new Handler(Looper.getMainLooper());

    private KSATInitManager() {
    }

    private void a() {
        try {
            for (Map.Entry<String, WeakReference> entry : this.j.entrySet()) {
                if (entry.getValue().get() == null) {
                    this.j.remove(entry.getKey());
                }
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        boolean z = false;
        boolean z2 = this.f6148c != 2;
        if (this.f6148c != 2) {
            z = true;
        }
        Boolean bool = this.f6147a;
        if (bool != null) {
            z2 = bool.booleanValue();
        }
        Boolean bool2 = this.b;
        if (bool2 != null) {
            z = bool2.booleanValue();
        }
        KsAdSDK.setPersonalRecommend(z2);
        KsAdSDK.setProgrammaticRecommend(z);
        if (ATSDK.isNetworkLogDebug()) {
            Log.i(d, "PersonalRecommend: ".concat(String.valueOf(z2)));
            Log.i(d, "ProgrammaticRecommend: ".concat(String.valueOf(z)));
        }
    }

    static /* synthetic */ boolean e(KSATInitManager kSATInitManager) {
        kSATInitManager.h = true;
        return true;
    }

    public static KSATInitManager getInstance() {
        if (e == null) {
            synchronized (KSATInitManager.class) {
                try {
                    if (e == null) {
                        e = new KSATInitManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Context context, final Map<String, Object> map, final Map<String, Object> map2, final ATBidRequestInfoListener aTBidRequestInfoListener) {
        initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.ks.KSATInitManager.2
            public final void onFail(String str) {
                ATBidRequestInfoListener aTBidRequestInfoListener2 = aTBidRequestInfoListener;
                if (aTBidRequestInfoListener2 != null) {
                    aTBidRequestInfoListener2.onFailed("Network init error.");
                }
            }

            public final void onSuccess() {
                KSATInitManager.this.runOnThreadPool(new Runnable() { // from class: com.anythink.network.ks.KSATInitManager.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        KSBidRequestInfo kSBidRequestInfo = new KSBidRequestInfo(map, map2);
                        if (kSBidRequestInfo.isValid()) {
                            if (aTBidRequestInfoListener != null) {
                                aTBidRequestInfoListener.onSuccess(kSBidRequestInfo);
                            }
                        } else if (aTBidRequestInfoListener != null) {
                            aTBidRequestInfoListener.onFailed("Network BidToken or Custom bid info is Empty.");
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(String str, WeakReference weakReference) {
        try {
            this.j.put(str, weakReference);
        } catch (Throwable th) {
        }
    }

    public String getNetworkName() {
        return "Kuaishou";
    }

    public String getNetworkSDKClass() {
        return "com.kwad.sdk.api.KsAdSDK";
    }

    public String getNetworkVersion() {
        return KSATConst.getNetworkVersion();
    }

    public String getPayloadInfo(String str, double d2) {
        String str2 = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.getJSONArray("adBids").getJSONObject(0).put("bidEcpm", d2);
            String jSONObject2 = jSONObject.toString();
            str2 = jSONObject2;
            Log.i(d, jSONObject.toString());
            return jSONObject2;
        } catch (Throwable th) {
            return str2;
        }
    }

    public Map<String, Boolean> getPluginClassStatus() {
        HashMap hashMap = new HashMap();
        hashMap.put("recyclerview-*.aar", Boolean.FALSE);
        try {
            hashMap.put("recyclerview-*.aar", Boolean.TRUE);
            return hashMap;
        } catch (Throwable th) {
            th.printStackTrace();
            return hashMap;
        }
    }

    public List getResourceStatus() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("ksad_reward_order_end_dialog");
        return arrayList;
    }

    public void initSDK(Context context, Map<String, Object> map) {
        initSDK(context, map, null);
    }

    public void initSDK(Context context, Map<String, Object> map, final MediationInitCallback mediationInitCallback) {
        try {
            for (Map.Entry<String, WeakReference> entry : this.j.entrySet()) {
                if (entry.getValue().get() == null) {
                    this.j.remove(entry.getKey());
                }
            }
        } catch (Throwable th) {
        }
        final Context applicationContext = context.getApplicationContext();
        try {
            this.f6148c = ATSDK.getPersionalizedAdStatus();
        } catch (Throwable th2) {
        }
        if (this.h) {
            b();
            if (mediationInitCallback != null) {
                mediationInitCallback.onSuccess();
                return;
            }
            return;
        }
        final String stringFromMap = getStringFromMap(map, "app_id");
        if (TextUtils.isEmpty(stringFromMap)) {
            return;
        }
        this.f.post(new Runnable() { // from class: com.anythink.network.ks.KSATInitManager.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (KSATInitManager.this.g) {
                    if (KSATInitManager.this.h) {
                        if (mediationInitCallback != null) {
                            mediationInitCallback.onSuccess();
                        }
                        return;
                    }
                    SdkConfig.Builder builder = new SdkConfig.Builder();
                    builder.appId(stringFromMap);
                    if (KSATInitManager.this.i != null) {
                        builder.canReadICCID(KSATInitManager.this.i.getCanReadICCID());
                        builder.canReadMacAddress(KSATInitManager.this.i.getCanReadMacAddress());
                        builder.canReadNearbyWifiList(KSATInitManager.this.i.getCanReadNearbyWifiList());
                        if (KSATInitManager.this.i.getKsCustomeController() != null) {
                            builder.customController(KSATInitManager.this.i.getKsCustomeController());
                        }
                    }
                    boolean init = KsAdSDK.init(applicationContext, builder.build());
                    KSATInitManager.this.b();
                    if (init) {
                        KSATInitManager.e(KSATInitManager.this);
                        if (mediationInitCallback != null) {
                            mediationInitCallback.onSuccess();
                        }
                    } else if (mediationInitCallback != null) {
                        mediationInitCallback.onFail("Kuaishou init failed");
                    }
                }
            }
        });
    }

    public void setKSATCustomController(KSATCustomController kSATCustomController) {
        if (kSATCustomController != null) {
            this.i = kSATCustomController;
        }
    }

    public void setPersonalRecommend(boolean z) {
        this.f6147a = Boolean.valueOf(z);
    }

    public void setProgrammaticRecommend(boolean z) {
        this.b = Boolean.valueOf(z);
    }
}
