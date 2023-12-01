package com.kwad.sdk.ranger;

import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.g;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/ranger/e.class */
public class e {
    public static final String TAG = e.class.getSimpleName();

    private static void a(d dVar) {
        try {
            a.a(dVar);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.e(TAG, Log.getStackTraceString(th));
        }
    }

    public static void cL(final String str) {
        g.schedule(new aw() { // from class: com.kwad.sdk.ranger.e.1
            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                String str2 = String.this;
                if (TextUtils.isEmpty(str2)) {
                    com.kwad.sdk.core.d.b.w(e.TAG, "config is empty");
                    return;
                }
                d er = e.er(str2);
                if (er != null) {
                    String str3 = e.TAG;
                    com.kwad.sdk.core.d.b.d(str3, "config:" + er.toJson().toString());
                }
                if (er == null || er.Cm()) {
                    return;
                }
                e.d(er);
            }
        }, 0L, TimeUnit.SECONDS);
    }

    public static void d(d dVar) {
        if (new Random().nextFloat() >= dVar.axW) {
            String str = TAG;
            com.kwad.sdk.core.d.b.d(str, "config.sampleRate：" + dVar.axW + " return");
            return;
        }
        if (dVar.Cn()) {
            e(dVar);
        }
        if (dVar.Co()) {
            a(dVar);
        }
        if (dVar.Cp()) {
            f(dVar);
        }
    }

    private static void e(d dVar) {
        List<String> list = dVar.axT;
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            RangerHelper.c(dVar);
            RangerHelper.replaceInternal();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.e(TAG, Log.getStackTraceString(th));
        }
    }

    public static d er(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            dVar.parseJson(jSONObject);
            return dVar;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.w(TAG, e);
            return null;
        }
    }

    private static void f(d dVar) {
        b.Ck().b(dVar);
    }
}
