package com.huawei.openalliance.ad.inter.data;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.ads.AdvertiserInfo;
import com.huawei.hms.ads.fw;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.ko;
import com.huawei.hms.ads.nativead.NativeAdConfiguration;
import com.huawei.openalliance.ad.beans.metadata.ContentExt;
import com.huawei.openalliance.ad.beans.metadata.ImageInfo;
import com.huawei.openalliance.ad.beans.metadata.ImpEX;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.constant.at;
import com.huawei.openalliance.ad.uriaction.q;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.au;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/data/n.class */
public class n extends c implements g {
    private boolean B;
    private String C;
    private List<k> D;
    private k F;
    private v L;
    private String S;

    /* renamed from: a  reason: collision with root package name */
    private List<String> f9365a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9366c;
    private boolean d;
    private int e;
    private String f;
    private NativeAdConfiguration g;
    @com.huawei.openalliance.ad.annotations.d
    private long h;
    private Integer i;
    private String j;

    public n(AdContentData adContentData) {
        super(adContentData);
        this.B = false;
        this.b = false;
        this.f9366c = false;
        this.d = false;
        this.e = 0;
        this.i = Integer.valueOf(adContentData.aA());
        this.j = adContentData.az();
    }

    private boolean C(Context context, Bundle bundle) {
        if (context == null || !x()) {
            return false;
        }
        return B(context, bundle);
    }

    private void Code(Context context, String str, Bundle bundle) {
        ge.V("INativeAd", "api report click event.");
        ko.Code(context, l(), au.Code(bundle), 0, 0, str, 12, com.huawei.openalliance.ad.utils.b.Code(context), V(bundle));
    }

    private void F(Context context, Bundle bundle) {
        ge.V("INativeAd", "api adShow called.");
        ko.Code(context, l(), au.Code(bundle), Long.valueOf(Math.min(System.currentTimeMillis() - this.h, r())), Integer.valueOf(s()), (Integer) 7, com.huawei.openalliance.ad.utils.b.Code(context));
    }

    private void S(Context context, Bundle bundle) {
        ge.V("INativeAd", "api report adShowStart event.");
        ko.Code(context, l(), au.Code(bundle));
    }

    public List<AdvertiserInfo> A() {
        if (this.Code == null || !g_()) {
            return null;
        }
        return this.Code.aG();
    }

    @Override // com.huawei.openalliance.ad.inter.data.g
    public v B() {
        if (this.Code == null || this.Code.p() == null) {
            return null;
        }
        if (this.L == null) {
            v vVar = new v(this.Code.p());
            this.L = vVar;
            vVar.Code(this.Code.y());
        }
        return this.L;
    }

    public void B(String str) {
        this.f = str;
        if (this.Code != null) {
            this.Code.V(str);
        }
    }

    public void B(boolean z) {
        this.d = z;
    }

    public boolean B(Context context, Bundle bundle) {
        if (context == null) {
            return false;
        }
        Code(true);
        q Code = com.huawei.openalliance.ad.uriaction.r.Code(context, l(), ae());
        boolean Code2 = Code.Code();
        if (Code2) {
            Code(context, Code.I(), bundle);
        }
        return Code2;
    }

    public String Code() {
        MetaData k;
        if (this.C == null && (k = k()) != null) {
            this.C = au.V(k.I());
        }
        return this.C;
    }

    public void Code(int i) {
        if (this.Code != null) {
            this.Code.B(i);
        }
    }

    public void Code(Context context, List<String> list) {
        if (context == null || !x()) {
            return;
        }
        new com.huawei.hms.ads.g(context, this).Code(list);
    }

    public void Code(Bundle bundle) {
    }

    public void Code(NativeAdConfiguration nativeAdConfiguration) {
        this.g = nativeAdConfiguration;
    }

    public void Code(boolean z) {
        this.B = z;
    }

    public boolean Code(Context context, Bundle bundle) {
        if (context == null || !x()) {
            return false;
        }
        this.h = System.currentTimeMillis();
        B(String.valueOf(com.huawei.openalliance.ad.utils.v.Code()));
        V(this.h);
        S(context, bundle);
        return true;
    }

    @Override // com.huawei.openalliance.ad.inter.data.g
    public k I() {
        MetaData k;
        List<ImageInfo> B;
        if (this.F == null && (k = k()) != null && (B = k.B()) != null && !B.isEmpty()) {
            this.F = new k(B.get(0));
        }
        return this.F;
    }

    public boolean I(Context context, Bundle bundle) {
        if (context == null || !x()) {
            ge.V("INativeAd", "record click event failed.");
            return false;
        }
        Code(context, com.huawei.openalliance.ad.constant.s.D, bundle);
        return true;
    }

    public boolean Q() {
        return this.b;
    }

    public boolean R() {
        return this.f9366c;
    }

    public boolean T() {
        return this.d;
    }

    public String U() {
        MetaData k = k();
        return k != null ? k.D() : "";
    }

    public m V(Bundle bundle) {
        JSONObject V = au.V(bundle);
        Integer valueOf = Integer.valueOf(V.optInt(at.aj, -111111));
        Integer valueOf2 = Integer.valueOf(V.optInt(at.ak, -111111));
        String optString = V.optString(at.al, "");
        Integer num = valueOf;
        if (valueOf.intValue() == -111111) {
            num = null;
        }
        Integer num2 = valueOf2;
        if (valueOf2.intValue() == -111111) {
            num2 = null;
        }
        String str = optString;
        if (!au.D(optString)) {
            str = null;
        }
        return new m(num, num2, str);
    }

    public String V() {
        MetaData Z;
        if (this.S == null && (Z = this.Code.Z()) != null) {
            this.S = au.V(Z.Z());
        }
        return this.S;
    }

    public void V(long j) {
        if (this.Code != null) {
            this.Code.Z(j);
        }
    }

    public void V(boolean z) {
        this.b = z;
    }

    public boolean V(Context context, Bundle bundle) {
        if (context == null || !x()) {
            return false;
        }
        F(context, bundle);
        return true;
    }

    public String W() {
        return c();
    }

    public Double X() {
        return null;
    }

    public String Y() {
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.g
    public List<k> Z() {
        MetaData k;
        if (this.D == null && (k = k()) != null) {
            this.D = Code(k.b());
        }
        return this.D;
    }

    public void Z(String str) {
        if (this.Code != null) {
            this.Code.S(str);
        }
    }

    public void Z(boolean z) {
        this.f9366c = z;
    }

    public boolean Z(Context context, Bundle bundle) {
        return C(context, bundle);
    }

    public String aa() {
        return null;
    }

    public Bundle ab() {
        return new Bundle();
    }

    public void ac() {
    }

    public NativeAdConfiguration ad() {
        return this.g;
    }

    public Map<String, String> ae() {
        HashMap hashMap = new HashMap();
        hashMap.put("appId", t());
        hashMap.put(com.huawei.openalliance.ad.uriaction.i.V, U());
        if (B() == null) {
            return hashMap;
        }
        hashMap.put(at.m, o());
        int L = B().L();
        ge.V("INativeAd", "buildLinkedAdConfig, set progress from native view " + L);
        hashMap.put(at.n, String.valueOf(aj()));
        hashMap.put(at.q, B().h() ? fw.Code : "false");
        hashMap.put(at.p, B().a());
        hashMap.put(at.o, String.valueOf(L));
        return hashMap;
    }

    public String ag() {
        if (this.Code != null) {
            return this.Code.I();
        }
        return null;
    }

    public String ah() {
        return this.Code != null ? this.Code.x() : "";
    }

    public Integer ai() {
        return this.i;
    }

    public int aj() {
        if (this.Code != null) {
            this.e = this.Code.z();
        }
        return this.e;
    }

    public String ak() {
        if (this.Code != null) {
            return this.Code.aj();
        }
        return null;
    }

    public boolean c_() {
        return B() != null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.g
    public boolean d_() {
        boolean z = false;
        if (this.Code != null) {
            z = false;
            if (this.Code.ag() == 1) {
                z = true;
            }
        }
        return z;
    }

    public boolean g_() {
        if (this.Code != null) {
            return !aa.Code(this.Code.aG());
        }
        return false;
    }

    @Override // com.huawei.openalliance.ad.inter.data.g
    public List<String> n() {
        List<String> k;
        if (this.f9365a == null && this.Code != null && (k = this.Code.k()) != null && k.size() > 0) {
            this.f9365a = k;
        }
        return this.f9365a;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c
    public String o() {
        return this.f;
    }

    public Map<String, String> q() {
        if (this.Code == null) {
            return null;
        }
        List<ImpEX> at = this.Code.at();
        List<ContentExt> au = this.Code.au();
        HashMap hashMap = new HashMap();
        if (!aa.Code(au)) {
            for (ContentExt contentExt : au) {
                hashMap.put(contentExt.Code(), au.V(contentExt.V()));
            }
        }
        if (!aa.Code(at)) {
            for (ImpEX impEX : at) {
                hashMap.put(impEX.Code(), au.V(impEX.V()));
            }
        }
        return hashMap;
    }
}
