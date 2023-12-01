package com.kwad.components.ad.reward.e;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.utils.y;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/e/a.class */
public final class a {
    public static int rA = 0;
    public static long rz = -1;

    public static void J(Context context) {
        b bVar = new b();
        if (e(System.currentTimeMillis())) {
            rA++;
        } else {
            rA = 1;
        }
        rz = System.currentTimeMillis();
        bVar.rB = rA;
        bVar.gq = rz;
        y.U(context, bVar.toJson().toString());
    }

    public static int cO() {
        if (!e(System.currentTimeMillis())) {
            rA = 0;
        }
        return rA;
    }

    private static boolean e(long j) {
        return gX() > 0 && j > 0 && gX() / 2460601000L == j / 2460601000L;
    }

    private static long gX() {
        long j = rz;
        long j2 = j;
        if (j == -1) {
            String Dr = y.Dr();
            if (TextUtils.isEmpty(Dr)) {
                return 0L;
            }
            b bVar = new b();
            try {
                bVar.parseJson(new JSONObject(Dr));
                rz = bVar.gq;
                rA = bVar.rB;
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            }
            j2 = rz;
        }
        return j2;
    }
}
