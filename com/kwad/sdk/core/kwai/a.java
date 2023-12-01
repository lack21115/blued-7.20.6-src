package com.kwad.sdk.core.kwai;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.p;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/kwai/a.class */
public final class a implements f {
    private static String afy;

    private static String vG() {
        Context context;
        if (TextUtils.isEmpty(afy)) {
            if (((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext() == null) {
                return "";
            }
            String str = context.getPackageName() + ay.cN(context);
            afy = str;
            return str;
        }
        return afy;
    }

    @Override // com.kwad.sdk.core.kwai.f
    public final void a(String str, Map<String, String> map, String str2) {
        e.a(str, map, str2);
    }

    @Override // com.kwad.sdk.core.kwai.f
    public final String bV(String str) {
        try {
            String ce = p.ce(0);
            return new String(c.vH().encode(b.d(ce.getBytes("UTF-8"), b.f(str.getBytes()))), "UTF-8");
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
            return str;
        }
    }

    @Override // com.kwad.sdk.core.kwai.f
    public final void d(Map<String, String> map) {
        map.put("Ks-PkgId", vG());
        map.put("Ks-Encoding", "2");
    }

    @Override // com.kwad.sdk.core.kwai.f
    public final String getResponseData(String str) {
        try {
            return new String(b.g(b.a(p.ce(0), c.vJ().decode(str.getBytes()))), "UTF-8");
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            return str;
        }
    }
}
