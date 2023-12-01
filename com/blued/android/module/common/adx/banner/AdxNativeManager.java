package com.blued.android.module.common.adx.banner;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.adx.base.ADEvent;
import com.blued.android.module.common.adx.base.ADListener;
import com.blued.android.module.common.adx.base.AdxBaseManager;
import com.blued.android.module.common.adx.base.BaseNativeExpressAd;
import com.blued.android.module.common.adx.base.IBaseAd;
import com.blued.android.module.common.adx.bd.p001native.BDNativeExpressAdAdapter;
import com.blued.android.module.common.adx.gdt.p002native.TXNativeExpressAdAdapter;
import com.blued.android.module.common.adx.ks.p003native.KSNativeExpressAdAdapter;
import com.blued.android.module.common.adx.tt.p004native.TTNativeExpressAdAdapter;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.comm.pi.IBidding;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/banner/AdxNativeManager.class */
public class AdxNativeManager extends AdxBaseManager {
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f10443c;
    private int d;
    private long e;
    private final ADListener f;
    private final Context g;

    public AdxNativeManager(Context context, int i, int i2, int i3, long j, ADListener listener) {
        Intrinsics.e(context, "context");
        Intrinsics.e(listener, "listener");
        this.b = i;
        this.f10443c = i2;
        this.d = i3;
        this.e = j;
        this.f = listener;
        this.g = context;
    }

    static /* synthetic */ Object a(AdxNativeManager adxNativeManager, List list, Continuation continuation) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            BluedADExtra bluedADExtra = (BluedADExtra) it.next();
            String str = bluedADExtra.adm_type_source;
            if (str != null) {
                int hashCode = str.hashCode();
                if (hashCode != 51) {
                    if (hashCode != 52) {
                        if (hashCode != 1570) {
                            if (hashCode == 1572 && str.equals("15")) {
                                arrayList.add(new BDNativeExpressAdAdapter(adxNativeManager.g, bluedADExtra, adxNativeManager.j(), adxNativeManager.d()));
                            }
                        } else if (str.equals("13")) {
                            int a2 = AppInfo.l - DensityUtil.a(24.0f);
                            arrayList.add(new KSNativeExpressAdAdapter(adxNativeManager.g, bluedADExtra, new ADSize(a2, (int) (a2 / 2.8d)), adxNativeManager.d()));
                        }
                    } else if (str.equals("4")) {
                        arrayList.add(new TTNativeExpressAdAdapter(adxNativeManager.g, bluedADExtra, adxNativeManager.k(), adxNativeManager.d()));
                    }
                } else if (str.equals("3")) {
                    arrayList.add(new TXNativeExpressAdAdapter(adxNativeManager.g, bluedADExtra, new ADSize(-1, -2), adxNativeManager.d()));
                }
            }
            arrayList.add(new TXNativeExpressAdAdapter(adxNativeManager.g, bluedADExtra, new ADSize(-1, -2), adxNativeManager.d()));
        }
        return FlowKt.a((Iterable) arrayList);
    }

    private final ADSize j() {
        int a2 = AppInfo.l - DensityUtil.a(24.0f);
        return new ADSize(a2, a2 / 3);
    }

    private final ADSize k() {
        float a2 = DensityUtil.a(AppInfo.l - DensityUtil.a(24.0f));
        return new ADSize((int) a2, (int) (a2 / 3));
    }

    public int a() {
        return this.b;
    }

    @Override // com.blued.android.module.common.adx.base.AdxBaseManager
    public Object a(List<? extends BluedADExtra> list, Continuation<? super Flow<? extends IBaseAd>> continuation) {
        return a(this, list, continuation);
    }

    public void a(int i) {
        this.f10443c = i;
    }

    public void a(long j) {
        this.e = j;
    }

    public void a(long j, int i, int i2) {
        a(j);
        a(i);
        b(i2);
        a("adx配置的超时时间：" + j + " 如果是0，使用默认超时时间：10秒");
    }

    @Override // com.blued.android.module.common.adx.base.AdxBaseManager
    public void a(BluedADExtra bluedADExtra) {
        if (bluedADExtra == null) {
            d().onADEvent(new ADEvent(107, new BluedADExtra()));
            return;
        }
        d().onADEvent(new ADEvent(100, bluedADExtra));
        if (bluedADExtra.isAdxTimeout) {
            d().onADEvent(new ADEvent(107, bluedADExtra));
        }
    }

    @Override // com.blued.android.module.common.adx.base.AdxBaseManager
    public void a(Map<String, ? extends BluedADExtra> map) {
        Intrinsics.e(map, "map");
        BluedADExtra bluedADExtra = map.get("win_data");
        if (bluedADExtra == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.common.login.model.BluedADExtra");
        }
        BluedADExtra bluedADExtra2 = bluedADExtra;
        BluedADExtra bluedADExtra3 = map.get("loss_data");
        if (bluedADExtra3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.common.login.model.BluedADExtra");
        }
        BluedADExtra bluedADExtra4 = bluedADExtra3;
        float f = bluedADExtra2.price;
        float f2 = 100;
        int i = (int) (f * f2);
        int i2 = (int) (bluedADExtra4.price * f2);
        String str = bluedADExtra2.adm_type_source;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode == 51) {
                if (str.equals("3")) {
                    Map<String, ? extends Object> a2 = MapsKt.a(TuplesKt.a(IBidding.EXPECT_COST_PRICE, Integer.valueOf(i)), TuplesKt.a(IBidding.HIGHEST_LOSS_PRICE, Integer.valueOf(i2)));
                    a("回传给广点通竞胜信息 广告id:" + ((Object) bluedADExtra2.ads_id_sub) + " 广告位id:" + ((Object) bluedADExtra2.third_id) + " 竞胜出价：" + i + " 竞败⽅的最⾼价格:" + i2);
                    bluedADExtra2.baseNativeExpressAd.a(a2);
                }
            } else if (hashCode != 1570) {
                if (hashCode == 1572 && str.equals("15")) {
                    Map<String, ? extends Object> a3 = MapsKt.a(TuplesKt.a("highest_loss_price", Integer.valueOf(i2)));
                    a("回传给百度竞胜信息 广告id:" + ((Object) bluedADExtra2.ads_id_sub) + " 广告位id:" + ((Object) bluedADExtra2.third_id) + " 竞败⽅的最⾼价格:" + i2);
                    bluedADExtra2.baseNativeExpressAd.a(a3);
                }
            } else if (str.equals("13")) {
                Map<String, ? extends Object> a4 = MapsKt.a(TuplesKt.a("win_data", bluedADExtra2), TuplesKt.a("loss_data", bluedADExtra4));
                Log.v("adx", "回传给快手竞胜信息 广告id:" + ((Object) bluedADExtra2.ads_id_sub) + " 广告位id:" + ((Object) bluedADExtra2.third_id) + " 竞胜出价：" + i + " 竞败⽅的最⾼价格:" + i2);
                bluedADExtra2.baseNativeExpressAd.a(a4);
            }
        }
    }

    public int b() {
        return this.d;
    }

    public void b(int i) {
        this.d = i;
    }

    @Override // com.blued.android.module.common.adx.base.AdxBaseManager
    public void b(Map<String, ? extends BluedADExtra> map) {
        String str;
        String str2;
        Intrinsics.e(map, "map");
        BluedADExtra bluedADExtra = map.get("win_data");
        if (bluedADExtra == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.common.login.model.BluedADExtra");
        }
        BluedADExtra bluedADExtra2 = bluedADExtra;
        BluedADExtra bluedADExtra3 = map.get("loss_data");
        if (bluedADExtra3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.common.login.model.BluedADExtra");
        }
        BluedADExtra bluedADExtra4 = bluedADExtra3;
        BluedADExtra bluedADExtra5 = map.get("current_data");
        if (bluedADExtra5 == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.common.login.model.BluedADExtra");
        }
        BluedADExtra bluedADExtra6 = bluedADExtra5;
        int i = (int) (bluedADExtra2.price * 100);
        String str3 = bluedADExtra6.adm_type_source;
        if (str3 != null) {
            int hashCode = str3.hashCode();
            if (hashCode != 51) {
                if (hashCode == 1570) {
                    if (str3.equals("13")) {
                        bluedADExtra6.baseNativeExpressAd.b(MapsKt.a(TuplesKt.a("win_data", bluedADExtra2), TuplesKt.a("loss_data", bluedADExtra4)));
                    }
                } else if (hashCode == 1572 && str3.equals("15")) {
                    bluedADExtra6.baseNativeExpressAd.b(MapsKt.a(TuplesKt.a("win_data", bluedADExtra2), TuplesKt.a("loss_data", bluedADExtra4)));
                }
            } else if (str3.equals("3")) {
                if (TextUtils.equals(bluedADExtra2.adm_type_source, bluedADExtra6.adm_type_source) && !bluedADExtra2.is_bidding()) {
                    str = "1";
                } else if (TextUtils.equals(bluedADExtra2.adm_type_source, bluedADExtra6.adm_type_source)) {
                    str = "2";
                    if (TextUtils.equals(bluedADExtra2.adm_type_source, bluedADExtra6.adm_type_source)) {
                        str = "2";
                        if (bluedADExtra2.is_bidding()) {
                            str = "4";
                        }
                    }
                } else {
                    str = "2";
                }
                int i2 = !bluedADExtra6.hasMaterial ? 2 : 1;
                String str4 = "reason：" + i2 + " 释义：竞争力不足，如优量汇不是本次竞价的最高出价方，可上报此竞败原因";
                if (Intrinsics.a((Object) bluedADExtra2.adm_type_source, (Object) bluedADExtra6.adm_type_source) && !bluedADExtra2.is_bidding()) {
                    str2 = "adnId：" + str + " 释义：输给优量汇其它非bidding广告位，当优量汇目标价报价为本次竞价的最高报价时，可上报此值";
                } else if (!Intrinsics.a((Object) bluedADExtra2.adm_type_source, (Object) bluedADExtra6.adm_type_source)) {
                    str2 = "adnId：" + str + " 释义： 输给第三方ADN，当其它ADN报价为本次竞价的最高报价时，可上报此值";
                } else if (Intrinsics.a((Object) bluedADExtra2.adm_type_source, (Object) bluedADExtra6.adm_type_source) && bluedADExtra2.is_bidding()) {
                    str2 = "adnId：" + str + " 释义： 输给优量汇其他bidding广告位，当优量汇其他bidding广告位报价为本次竞价的最高报价时，可上报此值";
                } else {
                    str2 = "";
                }
                a("回传给广点通竞败信息 当前广告id:" + ((Object) bluedADExtra6.ads_id_sub) + " 广告位id:" + ((Object) bluedADExtra6.third_id) + " 本次竞胜方出价：" + i + "  竞价失败原因:" + str4 + "  本次竞胜方渠道ID:" + str2);
                if (bluedADExtra6.bid_fail_notice != 1) {
                    Map<String, ? extends Object> a2 = MapsKt.a(TuplesKt.a(IBidding.LOSS_REASON, Integer.valueOf(i2)));
                    BaseNativeExpressAd baseNativeExpressAd = bluedADExtra6.baseNativeExpressAd;
                    if (baseNativeExpressAd != null) {
                        baseNativeExpressAd.b(a2);
                    }
                    Log.v("adx", "回传给广点通竞败信息 当前广告id:" + ((Object) bluedADExtra6.ads_id_sub) + " 广告位id:" + ((Object) bluedADExtra6.third_id) + " bid_fail_notice字段为：" + bluedADExtra6.bid_fail_notice + " 不上报「竞胜广告源」「竞胜价格」");
                    return;
                }
                Map<String, ? extends Object> a3 = MapsKt.a(TuplesKt.a(IBidding.WIN_PRICE, Integer.valueOf(i)), TuplesKt.a(IBidding.LOSS_REASON, Integer.valueOf(i2)), TuplesKt.a(IBidding.ADN_ID, str));
                BaseNativeExpressAd baseNativeExpressAd2 = bluedADExtra6.baseNativeExpressAd;
                if (baseNativeExpressAd2 != null) {
                    baseNativeExpressAd2.b(a3);
                }
                a("回传给广点通竞败信息 当前广告id:" + ((Object) bluedADExtra6.ads_id_sub) + " 广告位id:" + ((Object) bluedADExtra6.third_id) + " 本次竞胜方出价：" + i + "  竞价失败原因:" + str4 + "  本次竞胜方渠道ID:" + str2);
            }
        }
    }

    public long c() {
        return this.e;
    }

    public ADListener d() {
        return this.f;
    }

    @Override // com.blued.android.module.common.adx.base.AdxBaseManager
    public long e() {
        if (c() == 0) {
            return 10000L;
        }
        return c();
    }

    @Override // com.blued.android.module.common.adx.base.AdxBaseManager
    public int f() {
        if (getType() == 0) {
            return 1;
        }
        return getType();
    }

    @Override // com.blued.android.module.common.adx.base.AdxBaseManager
    public int g() {
        if (b() == 0) {
            return 1;
        }
        return b();
    }

    public int getType() {
        return this.f10443c;
    }

    @Override // com.blued.android.module.common.adx.base.AdxBaseManager
    public String h() {
        return String.valueOf(a());
    }
}
