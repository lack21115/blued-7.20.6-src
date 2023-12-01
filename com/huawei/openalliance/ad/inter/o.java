package com.huawei.openalliance.ad.inter;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.dr;
import com.huawei.hms.ads.eh;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.kk;
import com.huawei.openalliance.ad.beans.inner.PlacementAdReqParam;
import com.huawei.openalliance.ad.beans.metadata.Video;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.listeners.n;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.aa;
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
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/o.class */
public class o {
    private n B;
    private int C;
    private boolean D;
    private int F;
    private Context I;
    private boolean L;
    private String S;
    private b V;
    private final String[] Z;

    /* renamed from: a  reason: collision with root package name */
    private RequestOptions f22982a;
    private Location b;

    /* renamed from: c  reason: collision with root package name */
    private String f22983c;
    private long d;
    private long e;
    private long f;
    private int g;
    private String h;
    private String i;
    private Set<String> j;
    private Integer k;
    private String l;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/o$a.class */
    public static final class a {
        private int B;
        private boolean C;
        private Context Code;
        private Location D;
        private RequestOptions F;
        private int I = 4;
        private Integer L;
        private boolean S;
        private String[] V;
        private String Z;

        /* renamed from: a  reason: collision with root package name */
        private String f22984a;

        public a(Context context) {
            this.Code = context.getApplicationContext();
        }

        public int B() {
            return this.B;
        }

        public boolean C() {
            return this.C;
        }

        public a Code(int i) {
            this.I = i;
            return this;
        }

        public a Code(Location location) {
            this.D = location;
            return this;
        }

        public a Code(RequestOptions requestOptions) {
            this.F = requestOptions;
            return this;
        }

        public a Code(Integer num) {
            this.L = num;
            return this;
        }

        public a Code(String str) {
            this.Z = str;
            return this;
        }

        public a Code(boolean z) {
            this.C = z;
            return this;
        }

        public a Code(String[] strArr) {
            if (strArr != null) {
                this.V = (String[]) Arrays.copyOf(strArr, strArr.length);
                return this;
            }
            this.V = null;
            return this;
        }

        public o Code() {
            return new o(this);
        }

        public Context F() {
            return this.Code;
        }

        public int I() {
            return this.I;
        }

        public boolean S() {
            return this.S;
        }

        public a V(boolean z) {
            this.S = z;
            return this;
        }

        public String[] V() {
            String[] strArr = this.V;
            return strArr != null ? (String[]) Arrays.copyOf(strArr, strArr.length) : new String[0];
        }

        public String Z() {
            return this.Z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/o$b.class */
    public enum b {
        IDLE,
        LOADING
    }

    private o(a aVar) {
        this.V = b.IDLE;
        if (!v.Code(aVar.Code)) {
            this.Z = new String[0];
            return;
        }
        this.I = aVar.F();
        String[] V = aVar.V();
        if (aa.Code(V)) {
            this.Z = new String[0];
        } else {
            String[] strArr = new String[V.length];
            this.Z = strArr;
            System.arraycopy(V, 0, strArr, 0, V.length);
        }
        this.C = aVar.I();
        this.S = aVar.Z();
        this.F = aVar.B();
        this.D = aVar.C();
        this.L = aVar.S();
        this.b = aVar.D;
        this.f22982a = aVar.F;
        this.k = aVar.L;
        this.l = aVar.f22984a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(AdSlotParam.a aVar, PlacementAdReqParam placementAdReqParam) {
        kk.Code(this.I, "reqPlaceAd", aVar.S(), z.V(placementAdReqParam), new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.inter.o.2
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                o oVar;
                int code;
                o.this.f = System.currentTimeMillis();
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
                                    if (o.this.f22983c == null) {
                                        o.this.f22983c = adContentData.E();
                                    }
                                    arrayList.add(new com.huawei.openalliance.ad.inter.data.p(adContentData));
                                }
                                hashMap.put(str2, arrayList);
                            }
                        }
                        if (!af.Code(hashMap)) {
                            o.this.Code(hashMap);
                            o.this.V = b.IDLE;
                        }
                    }
                    oVar = o.this;
                } else {
                    oVar = o.this;
                    code = callResult.getCode();
                }
                oVar.I(code);
                o.this.V = b.IDLE;
            }
        }, String.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(final Map<String, List<com.huawei.openalliance.ad.inter.data.h>> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("onAdsLoaded, size:");
        sb.append(map == null ? 0 : map.size());
        ge.V("PlacementAdLoader", sb.toString());
        if (this.B != null) {
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.o.3
                @Override // java.lang.Runnable
                public void run() {
                    n nVar = o.this.B;
                    o.this.e = System.currentTimeMillis();
                    if (nVar != null) {
                        nVar.Code(map);
                    }
                    eh.Code(o.this.I, 200, o.this.f22983c, 60, map, o.this.d, o.this.e, o.this.f);
                }
            });
        }
    }

    private void Code(boolean z, int i, int i2) {
        this.d = v.Code();
        ge.V("PlacementAdLoader", "loadAds");
        if (!v.Code(this.I)) {
            ge.I("PlacementAdLoader", "api level too low");
            I(1001);
        } else if (!Z(this.S)) {
            ge.I("PlacementAdLoader", "extra info is invalid");
            I(804);
        } else if (b.LOADING == this.V) {
            ge.V("PlacementAdLoader", "waiting for request finish");
            I(801);
        } else {
            String[] strArr = this.Z;
            if (strArr == null || strArr.length == 0) {
                ge.I("PlacementAdLoader", "empty ad ids");
                I(802);
            } else if (i <= 0) {
                ge.I("PlacementAdLoader", "invalid totalDuration.");
                I(804);
            } else if (i2 < 0) {
                ge.I("PlacementAdLoader", "invalid maxCount");
                I(804);
            } else {
                this.V = b.LOADING;
                ac.Code(this.I, this.f22982a);
                Video video = new Video(this.F);
                final AdSlotParam.a aVar = new AdSlotParam.a();
                aVar.Code(Arrays.asList(this.Z)).V(this.C).Code(Boolean.valueOf(z)).Code(1).I(com.huawei.openalliance.ad.utils.c.Z(this.I)).Z(com.huawei.openalliance.ad.utils.c.B(this.I)).Code(this.D).Code(dr.Code(this.f22982a)).Code(this.b).B(i2).D(i).C(this.l).Code(video);
                Integer num = this.k;
                if (num != null) {
                    aVar.S(num);
                }
                final PlacementAdReqParam placementAdReqParam = new PlacementAdReqParam();
                placementAdReqParam.Code(this.S);
                placementAdReqParam.Code(this.L);
                placementAdReqParam.Code(this.d);
                com.huawei.openalliance.ad.utils.f.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.o.1
                    @Override // java.lang.Runnable
                    public void run() {
                        o.this.Code(aVar, placementAdReqParam);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(final int i) {
        ge.V("PlacementAdLoader", "onAdFailed, errorCode:" + i);
        if (this.B != null) {
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.o.4
                @Override // java.lang.Runnable
                public void run() {
                    n nVar = o.this.B;
                    o.this.e = System.currentTimeMillis();
                    if (nVar != null) {
                        nVar.I(i);
                    }
                    eh.Code(o.this.I, i, o.this.f22983c, 60, null, o.this.d, o.this.e, o.this.f);
                }
            });
        }
    }

    private boolean Z(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            new JSONObject(str);
            return true;
        } catch (JSONException e) {
            ge.I("PlacementAdLoader", "extra info is not json string");
            return false;
        }
    }

    public void Code(n nVar) {
        this.B = nVar;
        Code(false, 300, 1);
    }

    public void Code(n nVar, int i) {
        Code(nVar, i, 0);
    }

    public void Code(n nVar, int i, int i2) {
        this.B = nVar;
        Code(false, i, i2);
    }

    public void Code(String str) {
        this.l = str;
    }

    public void Code(Set<String> set) {
        this.j = set;
    }

    public void I(String str) {
        this.i = str;
    }

    public void V(int i) {
        this.g = i;
    }

    public void V(String str) {
        this.h = str;
    }
}
