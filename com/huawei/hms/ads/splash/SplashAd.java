package com.huawei.hms.ads.splash;

import android.content.Context;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.dr;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.constant.p;
import com.huawei.openalliance.ad.inter.h;
import com.huawei.openalliance.ad.ipc.g;
import com.huawei.openalliance.ad.utils.c;
import com.huawei.openalliance.ad.utils.f;
import com.huawei.openalliance.ad.utils.l;
import java.util.ArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/splash/SplashAd.class */
public class SplashAd {
    private static int Z;

    private static int Code(Context context, int i) {
        int i2 = 0;
        if (i != 0) {
            if (i != 1 && context != null && context.getResources().getConfiguration().orientation == 2) {
                return 0;
            }
            i2 = 1;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void Code(Context context, String str, int i, AdParam adParam, AdSlotParam.a aVar) {
        if (adParam == null || aVar == null) {
            return;
        }
        aVar.V(Z).I(c.Z(context)).Z(c.B(context)).Code(dr.Code(adParam.V())).S(adParam.getGender()).V(adParam.getTargetingContentUrl()).Code(adParam.getKeywords()).I(adParam.I()).C(adParam.C());
        if (adParam.Code() != null) {
            aVar.Code(adParam.Code());
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(str);
        aVar.Code(arrayList).Code(Code(context, i));
    }

    public static void dismissExSplashSlogan(final Context context) {
        f.I(new Runnable() { // from class: com.huawei.hms.ads.splash.SplashAd.1
            @Override // java.lang.Runnable
            public void run() {
                g.V(Context.this).Code(p.j, null, null, null);
            }
        });
    }

    public static boolean isExSplashEnable(Context context) {
        return c.L(context);
    }

    public static void preloadAd(Context context, String str, int i, AdParam adParam) {
        if (context == null || str == null) {
            return;
        }
        Z = l.I(context);
        h Code = com.huawei.openalliance.ad.inter.g.Code(context);
        if (Code instanceof com.huawei.openalliance.ad.inter.g) {
            AdSlotParam.a aVar = new AdSlotParam.a();
            Code(context, str, i, adParam, aVar);
            ((com.huawei.openalliance.ad.inter.g) Code).I(aVar.S());
            Code.Code();
        }
    }

    public static void setDefaultSplashMode(Context context, int i) {
        com.huawei.openalliance.ad.inter.g.Code(context).C(i);
    }

    public static void setSloganShowTimeWhenNoAd(final Context context, final int i) {
        f.I(new Runnable() { // from class: com.huawei.hms.ads.splash.SplashAd.2
            @Override // java.lang.Runnable
            public void run() {
                g.V(Context.this).Code(p.k, String.valueOf(i), null, null);
            }
        });
    }

    public void dismissExSplash(final Context context) {
        f.I(new Runnable() { // from class: com.huawei.hms.ads.splash.SplashAd.3
            @Override // java.lang.Runnable
            public void run() {
                g.V(context).Code(p.l, null, null, null);
            }
        });
    }

    public void setExSplashShowTime(final Context context, final int i) {
        f.I(new Runnable() { // from class: com.huawei.hms.ads.splash.SplashAd.4
            @Override // java.lang.Runnable
            public void run() {
                g.V(context).Code(p.m, String.valueOf(i), null, null);
            }
        });
    }
}
