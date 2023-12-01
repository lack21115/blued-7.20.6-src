package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.hi;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/hg.class */
public class hg<V extends hi> implements hh<V> {
    protected AdContentData Code;
    private Map<String, Boolean> I = new HashMap();
    private V V;

    private boolean V(String str) {
        return this.I.containsKey(str) && this.I.get(str).booleanValue();
    }

    public void Code(long j) {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            adContentData.Z(j);
        }
    }

    public void Code(Context context, long j, long j2) {
        String str;
        if (j >= j2) {
            str = "complete";
            if (V("complete")) {
                return;
            }
        } else {
            long j3 = j2 / 4;
            if (j > 3 * j3) {
                str = com.huawei.openalliance.ad.constant.cf.Z;
                if (V(com.huawei.openalliance.ad.constant.cf.Z)) {
                    return;
                }
            } else if (j > j2 / 2) {
                str = "midpoint";
                if (V("midpoint")) {
                    return;
                }
            } else if (j > j3) {
                str = com.huawei.openalliance.ad.constant.cf.V;
                if (V(com.huawei.openalliance.ad.constant.cf.V)) {
                    return;
                }
            } else if (j <= 0) {
                return;
            } else {
                str = "start";
                if (V("start")) {
                    return;
                }
            }
        }
        ko.V(context, this.Code, str);
        this.I.put(str, true);
    }

    @Override // com.huawei.hms.ads.hh
    public void Code(V v) {
        this.V = v;
    }

    public void Code(String str) {
        AdContentData adContentData = this.Code;
        if (adContentData == null) {
            return;
        }
        adContentData.V(str);
        Z();
    }

    @Override // com.huawei.hms.ads.hh
    public V I() {
        return this.V;
    }

    public void Z() {
        Map<String, Boolean> map = this.I;
        if (map == null) {
            return;
        }
        map.clear();
    }
}
