package com.kwad.components.ad.splashscreen.local;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.utils.y;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/local/c.class */
public class c extends com.kwad.sdk.core.response.kwai.a {
    private static SimpleDateFormat gp = new SimpleDateFormat("yyyy-MM-dd");
    public long gq = 0;
    public int gr = 0;

    public static void R(Context context) {
        String Ds = y.Ds();
        c cVar = new c();
        if (TextUtils.isEmpty(Ds)) {
            cVar.gr = 1;
            cVar.gq = System.currentTimeMillis();
            y.V(context, cVar.toJson().toString());
            return;
        }
        try {
            cVar.parseJson(new JSONObject(Ds));
            if (b(cVar.gq, System.currentTimeMillis())) {
                cVar.gr++;
            } else {
                cVar.gr = 1;
            }
            cVar.gq = System.currentTimeMillis();
            y.V(context, cVar.toJson().toString());
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
}
