package com.kwad.sdk.kwai.kwai.kwai;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.utils.y;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/kwai/kwai/kwai/b.class */
public final class b {
    public static int UX = 0;
    public static long rz = -1;

    public static void J(Context context) {
        a aVar = new a();
        if (e(System.currentTimeMillis())) {
            UX++;
        } else {
            UX = 1;
        }
        rz = System.currentTimeMillis();
        aVar.UX = UX;
        aVar.gq = rz;
        y.ae(context, aVar.toJson().toString());
    }

    public static int cO() {
        if (!e(System.currentTimeMillis())) {
            UX = 0;
        }
        return UX;
    }

    private static boolean e(long j) {
        return gX() > 0 && j > 0 && gX() / 2460601000L == j / 2460601000L;
    }

    private static long gX() {
        long j = rz;
        long j2 = j;
        if (j == -1) {
            String Dz = y.Dz();
            if (TextUtils.isEmpty(Dz)) {
                return 0L;
            }
            a aVar = new a();
            try {
                aVar.parseJson(new JSONObject(Dz));
                rz = aVar.gq;
                UX = aVar.UX;
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            }
            j2 = rz;
        }
        return j2;
    }
}
