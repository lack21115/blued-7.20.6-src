package com.kwad.components.ad.interstitial.b;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.utils.y;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/b/a.class */
public class a extends com.kwad.sdk.core.response.kwai.a {
    private static SimpleDateFormat gp = new SimpleDateFormat("yyyy-MM-dd");
    public long jl = -1;
    public int jm = 0;

    public static void L(Context context) {
        String Du = y.Du();
        a aVar = new a();
        if (TextUtils.isEmpty(Du)) {
            aVar.jm = 1;
            aVar.jl = System.currentTimeMillis();
            y.X(context, aVar.toJson().toString());
            return;
        }
        try {
            aVar.parseJson(new JSONObject(Du));
            if (b(aVar.jl, System.currentTimeMillis())) {
                aVar.jm++;
            } else {
                aVar.jm = 1;
                aVar.jl = System.currentTimeMillis();
            }
            y.X(context, aVar.toJson().toString());
        } catch (Exception e) {
            b.printStackTrace(e);
        }
    }

    private static boolean b(long j, long j2) {
        if (j <= 0 || j2 <= 0) {
            return false;
        }
        try {
            return gp.format(new Date(j)).equals(gp.format(new Date(j2)));
        } catch (Exception e) {
            b.printStackTrace(e);
            return false;
        }
    }

    public static int cQ() {
        String Du = y.Du();
        if (TextUtils.isEmpty(Du)) {
            return 0;
        }
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(Du));
            if (b(aVar.jl, System.currentTimeMillis())) {
                return aVar.jm;
            }
            return 0;
        } catch (Exception e) {
            b.printStackTrace(e);
            return 0;
        }
    }
}
