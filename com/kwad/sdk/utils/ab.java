package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.utils.ac;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/ab.class */
public final class ab {
    public static String a(Context context, String str, ac.a aVar, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String ag = ac.ag(context, ac.a(str, aVar));
        String cn2 = au.cn(context);
        String str2 = ag;
        if (!TextUtils.isEmpty(cn2)) {
            str2 = ag.replace("__MAC__", cn2).replace("__MAC2__", ad.eC(cn2)).replace("__MAC3__", ad.eC(cn2.replace(":", "")));
        }
        String cl = au.cl(context);
        String str3 = str2;
        if (!TextUtils.isEmpty(cl)) {
            str3 = str2.replace("__IMEI__", cl).replace("__IMEI2__", ad.eC(cl)).replace("__IMEI3__", ad.eD(cl));
        }
        String oaid = au.getOaid();
        String str4 = str3;
        if (!TextUtils.isEmpty(oaid)) {
            str4 = str3.replace("__OAID__", oaid).replace("__OAID2__", ad.eC(oaid));
        }
        String cm = au.cm(context);
        String str5 = str4;
        if (!TextUtils.isEmpty(cm)) {
            str5 = str4.replace("__ANDROIDID2__", ad.eC(cm)).replace("__ANDROIDID3__", ad.eD(cm)).replace("__ANDROIDID__", cm);
        }
        return ac.c(context, str5, z);
    }
}
