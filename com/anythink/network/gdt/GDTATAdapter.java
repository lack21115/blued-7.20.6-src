package com.anythink.network.gdt;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import com.igexin.assist.sdk.AssistPushConsts;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/gdt/GDTATAdapter.class */
public class GDTATAdapter extends CustomNativeAdapter {

    /* renamed from: a  reason: collision with root package name */
    String f6078a;
    String b;

    /* renamed from: c  reason: collision with root package name */
    int f6079c;
    String d;
    int e;
    int f;
    int g;
    int h;
    private int j = -1;
    private int k = -2;
    boolean i = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.network.gdt.GDTATAdapter$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/gdt/GDTATAdapter$1.class */
    public final class AnonymousClass1 implements a {
        AnonymousClass1() {
        }

        @Override // com.anythink.network.gdt.a
        public final void notifyError(String str, String str2) {
            GDTATAdapter.this.notifyATLoadFail(str, str2);
        }

        @Override // com.anythink.network.gdt.a
        public final void notifyLoaded(CustomNativeAd... customNativeAdArr) {
            if (!GDTATAdapter.this.i || !(customNativeAdArr[0] instanceof GDTATNativeExpressAd)) {
                if (GDTATAdapter.this.mLoadListener != null) {
                    GDTATAdapter.this.mLoadListener.onAdCacheLoaded(customNativeAdArr);
                    return;
                }
                return;
            }
            GDTATNativeExpressAd gDTATNativeExpressAd = (GDTATNativeExpressAd) customNativeAdArr[0];
            if (GDTATAdapter.this.mBiddingListener != null) {
                double ecpm = gDTATNativeExpressAd.b.getECPM();
                GDTATBiddingNotice gDTATBiddingNotice = new GDTATBiddingNotice(gDTATNativeExpressAd);
                ATBiddingListener aTBiddingListener = GDTATAdapter.this.mBiddingListener;
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, sb.toString(), gDTATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), gDTATNativeExpressAd);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.network.gdt.GDTATAdapter$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/gdt/GDTATAdapter$2.class */
    public final class AnonymousClass2 implements NativeADUnifiedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f6081a;

        AnonymousClass2(Context context) {
            this.f6081a = context;
        }

        @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
        public final void onADLoaded(List<NativeUnifiedADData> list) {
            ArrayList arrayList = new ArrayList();
            if (list == null || list.size() <= 0) {
                GDTATAdapter.this.notifyATLoadFail("", "Ad list is empty");
                return;
            }
            GDTATNativePatchAd gDTATNativePatchAd = null;
            GDTATNativeAd gDTATNativeAd = null;
            for (NativeUnifiedADData nativeUnifiedADData : list) {
                if (GDTATAdapter.this.e == 4) {
                    gDTATNativePatchAd = new GDTATNativePatchAd(this.f6081a, nativeUnifiedADData, GDTATAdapter.this.f, GDTATAdapter.this.g, GDTATAdapter.this.h);
                    arrayList.add(gDTATNativePatchAd);
                } else {
                    gDTATNativeAd = new GDTATNativeAd(this.f6081a, nativeUnifiedADData, GDTATAdapter.this.f, GDTATAdapter.this.g, GDTATAdapter.this.h);
                    arrayList.add(gDTATNativeAd);
                }
            }
            CustomNativeAd[] customNativeAdArr = (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]);
            if (!GDTATAdapter.this.i) {
                if (GDTATAdapter.this.mLoadListener != null) {
                    GDTATAdapter.this.mLoadListener.onAdCacheLoaded(customNativeAdArr);
                }
            } else if (GDTATAdapter.this.mBiddingListener != null) {
                if (GDTATAdapter.this.e == 4 && gDTATNativePatchAd != null) {
                    double ecpm = gDTATNativePatchAd.f6105c.getECPM();
                    GDTATBiddingNotice gDTATBiddingNotice = new GDTATBiddingNotice(gDTATNativePatchAd);
                    ATBiddingListener aTBiddingListener = GDTATAdapter.this.mBiddingListener;
                    StringBuilder sb = new StringBuilder();
                    sb.append(System.currentTimeMillis());
                    aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, sb.toString(), gDTATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), gDTATNativePatchAd);
                } else if (gDTATNativeAd != null) {
                    double ecpm2 = gDTATNativeAd.f6105c.getECPM();
                    GDTATBiddingNotice gDTATBiddingNotice2 = new GDTATBiddingNotice(gDTATNativeAd);
                    ATBiddingListener aTBiddingListener2 = GDTATAdapter.this.mBiddingListener;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(System.currentTimeMillis());
                    aTBiddingListener2.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm2, sb2.toString(), gDTATBiddingNotice2, ATAdConst.CURRENCY.RMB_CENT), gDTATNativeAd);
                }
            }
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public final void onNoAD(AdError adError) {
            GDTATAdapter gDTATAdapter = GDTATAdapter.this;
            StringBuilder sb = new StringBuilder();
            sb.append(adError.getErrorCode());
            gDTATAdapter.notifyATLoadFail(sb.toString(), adError.getErrorMsg());
        }
    }

    private void a(Context context, Map<String, Object> map) {
        try {
            int i = this.e;
            if (i != 2 && i != 4) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1();
                if (this.e == 3) {
                    GDTATNativeExpressPatchAd gDTATNativeExpressPatchAd = new GDTATNativeExpressPatchAd(context, this.b, this.j, this.k, this.f, this.g, this.h, this.d);
                    GDTATInitManager.getInstance();
                    gDTATNativeExpressPatchAd.a(anonymousClass1, GDTATInitManager.a(map));
                    return;
                }
                GDTATNativeExpressAd gDTATNativeExpressAd = new GDTATNativeExpressAd(context, this.b, this.j, this.k, this.f, this.g, this.h, this.d);
                GDTATInitManager.getInstance();
                gDTATNativeExpressAd.a(anonymousClass1, GDTATInitManager.a(map));
                return;
            }
            Context applicationContext = context.getApplicationContext();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(applicationContext);
            NativeUnifiedAD nativeUnifiedAD = TextUtils.isEmpty(this.d) ? new NativeUnifiedAD(applicationContext, this.b, anonymousClass2) : new NativeUnifiedAD(applicationContext, this.b, anonymousClass2, this.d);
            if (this.h != -1) {
                nativeUnifiedAD.setMaxVideoDuration(this.h);
            }
            if (!TextUtils.isEmpty(this.d)) {
                nativeUnifiedAD.loadData(this.f6079c);
                return;
            }
            int i2 = this.f6079c;
            GDTATInitManager.getInstance();
            nativeUnifiedAD.loadData(i2, GDTATInitManager.a(map));
        } catch (Throwable th) {
            notifyATLoadFail("", th.getMessage());
        }
    }

    static /* synthetic */ void a(GDTATAdapter gDTATAdapter, Context context, Map map) {
        try {
            int i = gDTATAdapter.e;
            if (i != 2 && i != 4) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1();
                if (gDTATAdapter.e == 3) {
                    GDTATNativeExpressPatchAd gDTATNativeExpressPatchAd = new GDTATNativeExpressPatchAd(context, gDTATAdapter.b, gDTATAdapter.j, gDTATAdapter.k, gDTATAdapter.f, gDTATAdapter.g, gDTATAdapter.h, gDTATAdapter.d);
                    GDTATInitManager.getInstance();
                    gDTATNativeExpressPatchAd.a(anonymousClass1, GDTATInitManager.a(map));
                    return;
                }
                GDTATNativeExpressAd gDTATNativeExpressAd = new GDTATNativeExpressAd(context, gDTATAdapter.b, gDTATAdapter.j, gDTATAdapter.k, gDTATAdapter.f, gDTATAdapter.g, gDTATAdapter.h, gDTATAdapter.d);
                GDTATInitManager.getInstance();
                gDTATNativeExpressAd.a(anonymousClass1, GDTATInitManager.a(map));
                return;
            }
            Context applicationContext = context.getApplicationContext();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(applicationContext);
            NativeUnifiedAD nativeUnifiedAD = TextUtils.isEmpty(gDTATAdapter.d) ? new NativeUnifiedAD(applicationContext, gDTATAdapter.b, anonymousClass2) : new NativeUnifiedAD(applicationContext, gDTATAdapter.b, anonymousClass2, gDTATAdapter.d);
            if (gDTATAdapter.h != -1) {
                nativeUnifiedAD.setMaxVideoDuration(gDTATAdapter.h);
            }
            if (!TextUtils.isEmpty(gDTATAdapter.d)) {
                nativeUnifiedAD.loadData(gDTATAdapter.f6079c);
                return;
            }
            int i2 = gDTATAdapter.f6079c;
            GDTATInitManager.getInstance();
            nativeUnifiedAD.loadData(i2, GDTATInitManager.a(map));
        } catch (Throwable th) {
            gDTATAdapter.notifyATLoadFail("", th.getMessage());
        }
    }

    private void a(Map<String, Object> map, Map<String, Object> map2) {
        this.f6078a = ATInitMediation.getStringFromMap(map, "app_id");
        this.b = ATInitMediation.getStringFromMap(map, "unit_id");
        this.e = ATInitMediation.getIntFromMap(map, "unit_type");
        this.d = ATInitMediation.getStringFromMap(map, AssistPushConsts.MSG_TYPE_PAYLOAD);
        this.f6079c = this.i ? 1 : this.mRequestNum;
        try {
            this.j = ATInitMediation.getIntFromMap(map2, "key_width", -1);
            if (map2.containsKey(GDTATConst.AD_HEIGHT)) {
                this.k = ATInitMediation.getIntFromMap(map2, GDTATConst.AD_HEIGHT, -2);
            } else if (map2.containsKey("key_height")) {
                this.k = ATInitMediation.getIntFromMap(map2, "key_height", -2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int intFromMap = ATInitMediation.getIntFromMap(map, "video_muted", 0);
        int intFromMap2 = ATInitMediation.getIntFromMap(map, "video_autoplay", 1);
        int intFromMap3 = ATInitMediation.getIntFromMap(map, "video_duration", -1);
        this.f = intFromMap;
        this.g = intFromMap2;
        this.h = intFromMap3;
    }

    private void b(Context context, Map<String, Object> map) {
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(context);
        NativeUnifiedAD nativeUnifiedAD = TextUtils.isEmpty(this.d) ? new NativeUnifiedAD(context, this.b, anonymousClass2) : new NativeUnifiedAD(context, this.b, anonymousClass2, this.d);
        int i = this.h;
        if (i != -1) {
            nativeUnifiedAD.setMaxVideoDuration(i);
        }
        if (!TextUtils.isEmpty(this.d)) {
            nativeUnifiedAD.loadData(this.f6079c);
            return;
        }
        int i2 = this.f6079c;
        GDTATInitManager.getInstance();
        nativeUnifiedAD.loadData(i2, GDTATInitManager.a(map));
    }

    public void destory() {
    }

    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.b = ATInitMediation.getStringFromMap(map, "unit_id");
        GDTATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener);
    }

    public ATInitMediation getMediationInitManager() {
        return GDTATInitManager.getInstance();
    }

    public String getNetworkName() {
        return GDTATInitManager.getInstance().getNetworkName();
    }

    public String getNetworkPlacementId() {
        return this.b;
    }

    public String getNetworkSDKVersion() {
        return GDTATInitManager.getInstance().getNetworkVersion();
    }

    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, Map<String, Object> map2) {
        this.f6078a = ATInitMediation.getStringFromMap(map, "app_id");
        this.b = ATInitMediation.getStringFromMap(map, "unit_id");
        this.e = ATInitMediation.getIntFromMap(map, "unit_type");
        this.d = ATInitMediation.getStringFromMap(map, AssistPushConsts.MSG_TYPE_PAYLOAD);
        this.f6079c = this.i ? 1 : this.mRequestNum;
        try {
            this.j = ATInitMediation.getIntFromMap(map2, "key_width", -1);
            if (map2.containsKey(GDTATConst.AD_HEIGHT)) {
                this.k = ATInitMediation.getIntFromMap(map2, GDTATConst.AD_HEIGHT, -2);
            } else if (map2.containsKey("key_height")) {
                this.k = ATInitMediation.getIntFromMap(map2, "key_height", -2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int intFromMap = ATInitMediation.getIntFromMap(map, "video_muted", 0);
        int intFromMap2 = ATInitMediation.getIntFromMap(map, "video_autoplay", 1);
        int intFromMap3 = ATInitMediation.getIntFromMap(map, "video_duration", -1);
        this.f = intFromMap;
        this.g = intFromMap2;
        this.h = intFromMap3;
        if (TextUtils.isEmpty(this.f6078a) || TextUtils.isEmpty(this.b)) {
            notifyATLoadFail("", "GTD appid or unitId is empty.");
        } else {
            GDTATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.gdt.GDTATAdapter.3
                public final void onFail(String str) {
                    GDTATAdapter.this.notifyATLoadFail("", str);
                }

                public final void onSuccess() {
                    GDTATAdapter.a(GDTATAdapter.this, context, map);
                }
            });
        }
    }

    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.i = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }
}
