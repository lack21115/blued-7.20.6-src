package com.huawei.openalliance.ad.inter;

import android.content.Context;
import android.location.Location;
import com.huawei.hms.ads.App;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.eh;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.kk;
import com.huawei.hms.ads.nativead.NativeAdConfiguration;
import com.huawei.openalliance.ad.beans.inner.NativeAdReqParam;
import com.huawei.openalliance.ad.beans.metadata.DelayInfo;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.n;
import com.huawei.openalliance.ad.inter.listeners.l;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.ac;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.v;
import com.huawei.openalliance.ad.utils.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/m.class */
public class m implements i {
    private static final String V = m.class.getSimpleName();
    private DelayInfo A;
    private a B;
    private final String[] C;
    boolean Code;
    private String D;
    private com.huawei.openalliance.ad.inter.listeners.i F;
    private List<String> I;
    private boolean L;
    private l S;
    private com.huawei.openalliance.ad.inter.listeners.d Z;

    /* renamed from: a  reason: collision with root package name */
    private boolean f22980a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f22981c;
    private Context d;
    private int e;
    private RequestOptions f;
    private Location g;
    private Integer h;
    private int i;
    private String j;
    private String k;
    private Set<String> l;
    private int m;
    private Integer n;
    private Integer o;
    private Integer p;
    private NativeAdConfiguration q;
    private String r;
    private long s;
    private long t;
    private long u;
    private String v;
    private App w;
    private List<Integer> x;
    private Integer y;
    private String z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/m$a.class */
    public enum a {
        IDLE,
        LOADING
    }

    public m(Context context, String[] strArr) {
        this(context, strArr, false);
    }

    public m(Context context, String[] strArr, int i) {
        this(context, strArr, false);
        this.e = i;
    }

    public m(Context context, String[] strArr, int i, List<String> list) {
        this(context, strArr, false);
        this.e = i;
        this.I = list;
    }

    public m(Context context, String[] strArr, boolean z) {
        this.B = a.IDLE;
        this.f22981c = false;
        this.e = 3;
        this.A = new DelayInfo();
        if (!v.Code(context)) {
            this.C = new String[0];
            return;
        }
        this.d = context.getApplicationContext();
        if (strArr == null || strArr.length <= 0) {
            this.C = new String[0];
        } else {
            String[] strArr2 = new String[strArr.length];
            this.C = strArr2;
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        }
        this.L = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(AdSlotParam.a aVar, NativeAdReqParam nativeAdReqParam) {
        kk.Code(this.d.getApplicationContext(), "reqNativeAd", aVar.S(), z.V(nativeAdReqParam), new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.inter.m.2
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                m.this.u = System.currentTimeMillis();
                m.this.A.j().c(m.this.u);
                boolean z = false;
                if (callResult.getCode() == 200) {
                    Map map = (Map) z.V(callResult.getData(), Map.class, List.class, AdContentData.class);
                    if (map == null || map.size() <= 0) {
                        m.this.V(204, true);
                        z = false;
                    } else {
                        HashMap hashMap = new HashMap(map.size());
                        for (Map.Entry entry : map.entrySet()) {
                            String str2 = (String) entry.getKey();
                            List<AdContentData> list = (List) entry.getValue();
                            if (list != null) {
                                ArrayList arrayList = new ArrayList(list.size());
                                for (AdContentData adContentData : list) {
                                    if (m.this.v == null) {
                                        m.this.v = adContentData.E();
                                    }
                                    n nVar = new n(adContentData);
                                    nVar.Code(m.this.q);
                                    arrayList.add(nVar);
                                    if (!z) {
                                        z = adContentData.aa();
                                    }
                                }
                                hashMap.put(str2, arrayList);
                            }
                        }
                        m.this.Code(hashMap, z);
                    }
                } else if (callResult.getCode() == 602) {
                    List<String> list2 = (List) z.V(callResult.getMsg(), List.class, new Class[0]);
                    z = false;
                    if (m.this.Z != null) {
                        z = false;
                        if (list2 != null) {
                            ge.Code(m.V, "InValidContentIdsGot: %s", list2.toString());
                            m.this.Z.Code(list2);
                            z = false;
                        }
                    }
                } else {
                    boolean booleanValue = Boolean.valueOf(callResult.getMsg()).booleanValue();
                    z = booleanValue;
                    if (-10 != callResult.getCode()) {
                        m.this.V(callResult.getCode(), booleanValue);
                        z = booleanValue;
                    }
                }
                if (z) {
                    m.this.B = a.IDLE;
                }
            }
        }, String.class);
    }

    public void B(Integer num) {
        this.y = num;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void Code(int i) {
        this.i = i;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void Code(int i, String str, boolean z) {
        this.s = System.currentTimeMillis();
        this.A.j().Code(this.s);
        ge.V(V, "loadAds");
        if (!v.Code(this.d)) {
            V(1001, true);
        } else if (a.LOADING == this.B) {
            ge.V(V, "waiting for request finish");
            V(701, true);
        } else {
            String[] strArr = this.C;
            if (strArr == null || strArr.length == 0) {
                ge.I(V, "empty ad ids");
                V(702, true);
            } else if (this.w != null && !v.I(this.d)) {
                ge.I(V, "hms ver not support set appInfo.");
                V(706, true);
            } else {
                ac.Code(this.d, this.f);
                this.B = a.LOADING;
                final AdSlotParam.a aVar = new AdSlotParam.a();
                aVar.Code(Arrays.asList(this.C)).V(i).Code(str).Code(1).I(com.huawei.openalliance.ad.utils.c.Z(this.d)).Z(com.huawei.openalliance.ad.utils.c.B(this.d)).Code(z).Code(this.f).Code(this.g).C(this.e).S(this.i).V(this.j).B(this.m).Code(this.l).I(this.k).Code(this.n).Code(this.w).C(this.h).Z(this.r).V(this.x).C(this.z).Z(this.f22981c);
                Integer num = this.o;
                if (num != null && this.p != null) {
                    aVar.V(num);
                    aVar.I(this.p);
                }
                Integer num2 = this.y;
                if (num2 != null) {
                    aVar.S(num2);
                }
                NativeAdConfiguration nativeAdConfiguration = this.q;
                if (nativeAdConfiguration != null) {
                    aVar.V(!nativeAdConfiguration.isReturnUrlsForImages());
                    aVar.I(this.q.isRequestMultiImages());
                }
                final NativeAdReqParam nativeAdReqParam = new NativeAdReqParam();
                nativeAdReqParam.Code(this.D);
                nativeAdReqParam.V(this.f22980a);
                nativeAdReqParam.Code(this.L);
                nativeAdReqParam.I(this.b);
                nativeAdReqParam.Code(this.I);
                nativeAdReqParam.Code(this.s);
                final long currentTimeMillis = System.currentTimeMillis();
                com.huawei.openalliance.ad.utils.f.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.m.1
                    @Override // java.lang.Runnable
                    public void run() {
                        m.this.A.Z(System.currentTimeMillis() - currentTimeMillis);
                        m.this.Code(aVar, nativeAdReqParam);
                    }
                });
            }
        }
    }

    public void Code(int i, boolean z) {
        Code(i, (String) null, z);
    }

    public void Code(Location location) {
        this.g = location;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void Code(RequestOptions requestOptions) {
        this.f = requestOptions;
        App app = requestOptions.getApp();
        if (app != null) {
            this.w = app;
        }
    }

    public void Code(NativeAdConfiguration nativeAdConfiguration) {
        this.q = nativeAdConfiguration;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void Code(com.huawei.openalliance.ad.inter.listeners.d dVar) {
        this.Z = dVar;
    }

    public void Code(com.huawei.openalliance.ad.inter.listeners.i iVar) {
        this.F = iVar;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void Code(l lVar) {
        this.S = lVar;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void Code(Integer num) {
        this.n = num;
    }

    public void Code(String str) {
        this.D = str;
    }

    public void Code(List<Integer> list) {
        this.x = list;
    }

    public void Code(final Map<String, List<com.huawei.openalliance.ad.inter.data.g>> map, final boolean z) {
        String str = V;
        StringBuilder sb = new StringBuilder();
        sb.append("onAdsLoaded, size:");
        sb.append(map != null ? Integer.valueOf(map.size()) : null);
        sb.append(", listener:");
        sb.append(this.S);
        sb.append(" innerlistener: ");
        sb.append(this.F);
        ge.V(str, sb.toString());
        final long currentTimeMillis = System.currentTimeMillis();
        this.A.j().D(currentTimeMillis);
        if (!this.Code) {
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.m.3
                @Override // java.lang.Runnable
                public void run() {
                    l lVar = m.this.S;
                    m.this.t = System.currentTimeMillis();
                    m.this.A.j().V(m.this.t);
                    long j = m.this.t - currentTimeMillis;
                    m.this.A.D(j);
                    ge.V(m.V, "onAdsLoaded main thread switch: %s ms", Long.valueOf(j));
                    if (lVar != null) {
                        lVar.Code(map);
                    }
                    com.huawei.openalliance.ad.inter.listeners.i iVar = m.this.F;
                    if (iVar != null) {
                        iVar.Code(map, z);
                    }
                    eh.Code(m.this.d, 200, m.this.v, m.this.e, map, m.this.t - m.this.s, m.this.A);
                }
            });
            return;
        }
        this.A.L(currentTimeMillis);
        ge.V(V, "onAdsLoaded thread");
        l lVar = this.S;
        if (lVar != null) {
            lVar.Code(map);
        }
        com.huawei.openalliance.ad.inter.listeners.i iVar = this.F;
        if (iVar != null) {
            iVar.Code(map, z);
        }
        eh.Code(this.d, 200, this.v, this.e, map, this.s, currentTimeMillis, this.u);
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void Code(Set<String> set) {
        this.l = set;
    }

    public void Code(boolean z) {
        this.f22980a = z;
    }

    public void I(int i) {
        this.e = i;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void I(Integer num) {
        this.p = num;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void I(String str) {
        this.k = str;
    }

    public void I(boolean z) {
        this.Code = z;
    }

    public void V(int i) {
        this.m = i;
    }

    public void V(final int i, final boolean z) {
        String str = V;
        ge.V(str, "onAdFailed, errorCode:" + i);
        final long currentTimeMillis = System.currentTimeMillis();
        this.A.j().D(currentTimeMillis);
        if (!this.Code) {
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.m.4
                @Override // java.lang.Runnable
                public void run() {
                    l lVar = m.this.S;
                    m.this.t = System.currentTimeMillis();
                    m.this.A.j().V(m.this.t);
                    long j = m.this.t - currentTimeMillis;
                    m.this.A.D(j);
                    ge.V(m.V, "onAdFailed main thread switch: %s ms", Long.valueOf(j));
                    if (lVar != null) {
                        lVar.Code(i);
                    }
                    com.huawei.openalliance.ad.inter.listeners.i iVar = m.this.F;
                    if (iVar != null) {
                        iVar.Code(i, z);
                    }
                    eh.Code(m.this.d, i, m.this.v, m.this.e, null, m.this.t - m.this.s, m.this.A);
                }
            });
            return;
        }
        ge.V(V, "onAdFailed thread");
        l lVar = this.S;
        if (lVar != null) {
            lVar.Code(i);
        }
        com.huawei.openalliance.ad.inter.listeners.i iVar = this.F;
        if (iVar != null) {
            iVar.Code(i, z);
        }
        eh.Code(this.d, i, this.v, this.e, null, this.s, currentTimeMillis, this.u);
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void V(Integer num) {
        this.o = num;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void V(String str) {
        this.j = str;
    }

    public void V(boolean z) {
        this.b = z;
    }

    public void Z(Integer num) {
        this.h = num;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void Z(String str) {
        this.z = str;
    }
}
