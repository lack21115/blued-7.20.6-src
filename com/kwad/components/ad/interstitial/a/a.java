package com.kwad.components.ad.interstitial.a;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.utils.y;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/a/a.class */
public class a extends com.kwad.sdk.core.response.kwai.a {
    private static SimpleDateFormat gp = new SimpleDateFormat("yyyy-MM-dd");
    public long gq = -1;
    public int ji = 0;

    public static void J(Context context) {
        String Dq = y.Dq();
        a aVar = new a();
        if (TextUtils.isEmpty(Dq)) {
            aVar.ji = 1;
            aVar.gq = System.currentTimeMillis();
            y.S(context, aVar.toJson().toString());
            return;
        }
        try {
            aVar.parseJson(new JSONObject(Dq));
            if (b(aVar.gq, System.currentTimeMillis())) {
                aVar.ji++;
            } else {
                aVar.ji = 1;
                aVar.gq = System.currentTimeMillis();
            }
            y.S(context, aVar.toJson().toString());
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
        String Dq = y.Dq();
        if (TextUtils.isEmpty(Dq)) {
            return 0;
        }
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(Dq));
            if (b(aVar.gq, System.currentTimeMillis())) {
                return aVar.ji;
            }
            return 0;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            return 0;
        }
    }
}
