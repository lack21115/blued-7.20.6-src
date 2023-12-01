package com.huawei.openalliance.ad.inter;

import android.content.Context;
import android.location.Location;
import com.huawei.hms.ads.App;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.eh;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.kk;
import com.huawei.openalliance.ad.beans.inner.BaseAdReqParam;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.s;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.ac;
import com.huawei.openalliance.ad.utils.af;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.v;
import com.huawei.openalliance.ad.utils.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/p.class */
public class p {
    private com.huawei.openalliance.ad.inter.listeners.o B;
    private RequestOptions C;
    private String D;
    private int F;
    private final String[] I;
    private String L;
    private Location S;
    private Context V;
    private a Z = a.IDLE;

    /* renamed from: a  reason: collision with root package name */
    private Set<String> f9377a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private long f9378c;
    private long d;
    private long e;
    private App f;
    private Integer g;
    private String h;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/p$a.class */
    enum a {
        IDLE,
        LOADING
    }

    public p(Context context, String[] strArr) {
        if (!v.Code(context)) {
            this.I = new String[0];
            return;
        }
        this.V = context.getApplicationContext();
        if (strArr == null || strArr.length <= 0) {
            this.I = new String[0];
            return;
        }
        String[] strArr2 = new String[strArr.length];
        this.I = strArr2;
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(final Map<String, List<com.huawei.openalliance.ad.inter.data.i>> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("onAdsLoaded, size:");
        sb.append(map != null ? Integer.valueOf(map.size()) : null);
        sb.append(", listener:");
        sb.append(this.B);
        ge.V("RewardAdLoader", sb.toString());
        if (this.B == null) {
            return;
        }
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.p.2
            @Override // java.lang.Runnable
            public void run() {
                com.huawei.openalliance.ad.inter.listeners.o oVar = p.this.B;
                p.this.d = System.currentTimeMillis();
                if (oVar != null) {
                    oVar.Code(map);
                }
                eh.Code(p.this.V, 200, p.this.b, 7, map, p.this.f9378c, p.this.d, p.this.e);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(final int i) {
        ge.V("RewardAdLoader", "onAdFailed, errorCode:" + i);
        if (this.B == null) {
            return;
        }
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.p.3
            @Override // java.lang.Runnable
            public void run() {
                com.huawei.openalliance.ad.inter.listeners.o oVar = p.this.B;
                p.this.d = System.currentTimeMillis();
                if (oVar != null) {
                    oVar.Code(i);
                }
                eh.Code(p.this.V, i, p.this.b, 7, null, p.this.f9378c, p.this.d, p.this.e);
            }
        });
    }

    public void Code(int i) {
        this.F = i;
    }

    public void Code(int i, boolean z) {
        this.f9378c = v.Code();
        ge.V("RewardAdLoader", "loadAds");
        if (!v.Code(this.V)) {
            V(1001);
        } else if (a.LOADING == this.Z) {
            ge.V("RewardAdLoader", "waiting for request finish");
            V(901);
        } else {
            String[] strArr = this.I;
            if (strArr == null || strArr.length == 0) {
                ge.I("RewardAdLoader", "empty ad ids");
                V(902);
            } else if (this.f != null && !v.I(this.V)) {
                ge.I("RewardAdLoader", "hms ver not support set appInfo.");
                V(706);
            } else {
                ac.Code(this.V, this.C);
                this.Z = a.LOADING;
                AdSlotParam.a aVar = new AdSlotParam.a();
                aVar.Code(Arrays.asList(this.I)).V(i).Code(1).I(com.huawei.openalliance.ad.utils.c.Z(this.V)).Z(com.huawei.openalliance.ad.utils.c.B(this.V)).Code(this.S).Code(this.C).Code(z).S(this.F).V(this.D).Code(this.f9377a).Code(this.f).I(this.L).C(this.h);
                Integer num = this.g;
                if (num != null) {
                    aVar.S(num);
                }
                BaseAdReqParam baseAdReqParam = new BaseAdReqParam();
                baseAdReqParam.Code(this.f9378c);
                kk.Code(this.V, "reqRewardAd", aVar.S(), z.V(baseAdReqParam), new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.inter.p.1
                    @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str, CallResult<String> callResult) {
                        p pVar;
                        int code;
                        p.this.e = System.currentTimeMillis();
                        if (callResult.getCode() == 200) {
                            Map map = (Map) z.V(callResult.getData(), Map.class, List.class, AdContentData.class);
                            code = 204;
                            if (map != null && map.size() > 0) {
                                HashMap hashMap = new HashMap(map.size());
                                for (Map.Entry entry : map.entrySet()) {
                                    String str2 = (String) entry.getKey();
                                    List<AdContentData> list = (List) entry.getValue();
                                    if (list != null) {
                                        ArrayList arrayList = new ArrayList(list.size());
                                        for (AdContentData adContentData : list) {
                                            if (p.this.b == null) {
                                                p.this.b = adContentData.E();
                                            }
                                            arrayList.add(new s(adContentData));
                                        }
                                        hashMap.put(str2, arrayList);
                                    }
                                }
                                if (!af.Code(hashMap)) {
                                    p.this.Code(hashMap);
                                    p.this.Z = a.IDLE;
                                }
                            }
                            pVar = p.this;
                        } else {
                            pVar = p.this;
                            code = callResult.getCode();
                        }
                        pVar.V(code);
                        p.this.Z = a.IDLE;
                    }
                }, String.class);
            }
        }
    }

    public void Code(Location location) {
        this.S = location;
    }

    public void Code(RequestOptions requestOptions) {
        this.C = requestOptions;
        App app = requestOptions.getApp();
        if (app != null) {
            this.f = app;
        }
    }

    public void Code(com.huawei.openalliance.ad.inter.listeners.o oVar) {
        this.B = oVar;
    }

    public void Code(Integer num) {
        this.g = num;
    }

    public void Code(String str) {
        this.h = str;
    }

    public void Code(Set<String> set) {
        this.f9377a = set;
    }

    public void I(String str) {
        this.L = str;
    }

    public void V(String str) {
        this.D = str;
    }
}
