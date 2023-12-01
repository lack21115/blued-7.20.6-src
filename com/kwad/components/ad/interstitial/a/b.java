package com.kwad.components.ad.interstitial.a;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.utils.y;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/a/b.class */
public class b extends com.kwad.sdk.core.response.kwai.a {
    private static SimpleDateFormat gp = new SimpleDateFormat("yyyy-MM-dd");
    public long gq = -1;
    public int jj = 0;
    public int jk = 0;

    public static void J(Context context) {
        String Dp = y.Dp();
        b bVar = new b();
        if (TextUtils.isEmpty(Dp)) {
            bVar.jj = 1;
            bVar.gq = System.currentTimeMillis();
            y.R(context, bVar.toJson().toString());
            return;
        }
        try {
            bVar.parseJson(new JSONObject(Dp));
            if (b(bVar.gq, System.currentTimeMillis())) {
                bVar.jj++;
            } else {
                bVar.jj = 1;
                bVar.jk = 0;
                bVar.gq = System.currentTimeMillis();
            }
            y.R(context, bVar.toJson().toString());
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
        }
    }

    public static void K(Context context) {
        String Dp = y.Dp();
        b bVar = new b();
        if (TextUtils.isEmpty(Dp)) {
            bVar.jk = 1;
            bVar.gq = System.currentTimeMillis();
            y.R(context, bVar.toJson().toString());
            return;
        }
        try {
            bVar.parseJson(new JSONObject(Dp));
            if (b(bVar.gq, System.currentTimeMillis())) {
                bVar.jk++;
            } else {
                bVar.jk = 1;
                bVar.jj = 0;
                bVar.gq = System.currentTimeMillis();
            }
            y.R(context, bVar.toJson().toString());
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
        }
    }

    private static boolean b(long j, long j2) {
        if (j <= 0 || j2 <= 0) {
            return false;
        }
        try {
            return gp.format(new Date(j)).equals(gp.format(new Date(j2)));
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            return false;
        }
    }

    public static int cO() {
        String Dp = y.Dp();
        if (TextUtils.isEmpty(Dp)) {
            return 0;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(Dp));
            return bVar.jj;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            return 0;
        }
    }

    public static int cP() {
        String Dp = y.Dp();
        if (TextUtils.isEmpty(Dp)) {
            return 0;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(Dp));
            return bVar.jk;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            return 0;
        }
    }
}
