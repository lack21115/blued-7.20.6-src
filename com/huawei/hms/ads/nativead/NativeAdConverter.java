package com.huawei.hms.ads.nativead;

import android.content.Context;
import com.huawei.hms.ads.bs;
import com.huawei.openalliance.ad.inter.data.g;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/nativead/NativeAdConverter.class */
public class NativeAdConverter {
    public static NativeAd deserialization(Context context, String str) {
        return deserialization(context, str, null);
    }

    public static NativeAd deserialization(Context context, String str, NativeAdConfiguration nativeAdConfiguration) {
        g Code = g.a.Code(str);
        if (Code != null) {
            bs bsVar = new bs(context, Code);
            if (nativeAdConfiguration != null) {
                bsVar.Code(nativeAdConfiguration);
            }
            return bsVar;
        }
        return null;
    }

    public static String serialization(NativeAd nativeAd) {
        if (nativeAd instanceof bs) {
            return g.a.Code(((bs) nativeAd).Code());
        }
        return null;
    }
}
