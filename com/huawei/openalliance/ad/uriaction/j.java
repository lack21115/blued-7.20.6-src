package com.huawei.openalliance.ad.uriaction;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.ads.ds;
import com.huawei.hms.ads.fw;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.km;
import com.huawei.openalliance.ad.constant.at;
import com.huawei.openalliance.ad.constant.s;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.ai;
import com.huawei.openalliance.ad.utils.au;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/uriaction/j.class */
public class j extends q {
    private static final String V = "InnerWebAction";
    private final boolean C;
    protected fw Code;
    private boolean S;

    public j(Context context, AdContentData adContentData, boolean z) {
        super(context, adContentData);
        this.Code = new fw();
        this.S = false;
        this.C = z;
    }

    public j(Context context, AdContentData adContentData, boolean z, Map<String, String> map) {
        super(context, adContentData);
        this.Code = new fw();
        this.S = false;
        this.C = z;
        Code(map);
    }

    private boolean Code(AdContentData adContentData) {
        if (km.Code(this.Z.r()) || ai.Z(this.I)) {
            Code(s.B);
            ds.Code(this.I, adContentData, this.Code, this.S);
            return true;
        }
        return V();
    }

    protected void Code(Map<String, String> map) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        ge.Code(V, "buildLinkedAdConfig");
        if (map == null || map.isEmpty()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            str = map.getOrDefault(at.n, String.valueOf(0));
            str2 = map.getOrDefault(at.m, String.valueOf(0));
            String orDefault = map.getOrDefault(at.q, "false");
            str3 = map.getOrDefault(at.o, null);
            String orDefault2 = map.getOrDefault(at.p, "n");
            str5 = orDefault;
            str4 = orDefault2;
        } else {
            str = map.get(at.n);
            str2 = map.get(at.m);
            String str6 = map.get(at.q);
            str3 = map.get(at.o);
            str4 = map.get(at.p);
            str5 = str6;
        }
        String str7 = str4;
        Integer F = au.F(str);
        if (F != null) {
            this.Code.V(F.intValue());
        } else {
            this.Code.V(0);
        }
        this.Code.V(str2);
        Integer F2 = au.F(str3);
        if (F2 != null) {
            this.Code.Code(F2.intValue());
            ge.V(V, "set progress from native view " + F2);
        } else {
            this.Code.Code(0);
        }
        this.Code.Code(str7);
        this.Code.Code(fw.Code.equals(str5));
    }

    public void Code(boolean z) {
        this.S = z;
    }

    @Override // com.huawei.openalliance.ad.uriaction.q
    public boolean Code() {
        if (this.Z == null) {
            return V();
        }
        ge.V(V, "handle inner web action");
        this.Z.V(this.C);
        ge.V(V, "needAppDownload: %s", Boolean.valueOf(this.C));
        return TextUtils.isEmpty(this.Z.e()) ? V() : Code(this.Z);
    }
}
