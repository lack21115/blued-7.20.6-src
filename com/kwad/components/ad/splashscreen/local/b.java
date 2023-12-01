package com.kwad.components.ad.splashscreen.local;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.u;
import com.kwad.sdk.utils.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/local/b.class */
public final class b {
    private static a a(Context context, long j) {
        if (context == null) {
            return null;
        }
        try {
            String Dy = y.Dy();
            if (TextUtils.isEmpty(Dy)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(Dy);
            a aVar = new a();
            aVar.parseJson(jSONObject);
            String str = u.parseJSON2MapString(aVar.BU).get(String.valueOf(j));
            if (TextUtils.isEmpty(str)) {
                aVar.BT.put(Long.valueOf(j), 0);
                return aVar;
            }
            aVar.BT.put(Long.valueOf(j), Integer.valueOf(str));
            return aVar;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(Context context, long j) {
        Map hashMap;
        a a2 = a(context, j);
        long currentTimeMillis = System.currentTimeMillis();
        if (a2 == null) {
            a2 = new a(currentTimeMillis, j, 1);
            hashMap = new HashMap();
            hashMap.put(String.valueOf(j), "1");
        } else {
            String str = a2.BU;
            if (TextUtils.isEmpty(str) || !a2.e(currentTimeMillis)) {
                hashMap = new HashMap();
                hashMap.put(String.valueOf(j), "1");
                a2.gq = currentTimeMillis;
                a2.BT.put(Long.valueOf(j), 1);
            } else {
                hashMap = u.parseJSON2MapString(str);
                int i = 0;
                if (!TextUtils.isEmpty((CharSequence) hashMap.get(String.valueOf(j)))) {
                    i = Integer.valueOf((String) hashMap.get(String.valueOf(j))).intValue();
                }
                int i2 = i + 1;
                hashMap.put(String.valueOf(j), String.valueOf(i2));
                a2.BT.put(Long.valueOf(j), Integer.valueOf(i2));
            }
        }
        a2.BU = u.parseMap2JSON(hashMap).toString();
        if (context == null || a2 == null) {
            return;
        }
        y.ad(context, a2.toJson().toString());
    }

    public static boolean b(Context context, long j, AdInfo adInfo) {
        a a2 = a(context, j);
        return !(a2 == null || !a2.a(j, adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardCountDaily));
    }
}
