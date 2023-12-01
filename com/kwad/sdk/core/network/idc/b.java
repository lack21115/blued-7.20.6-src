package com.kwad.sdk.core.network.idc;

import android.content.Context;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.utils.t;
import com.kwad.sdk.utils.y;
import java.io.IOException;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/network/idc/b.class */
public final class b {
    public static void a(Context context, com.kwad.sdk.core.network.idc.kwai.a aVar) {
        y.a(context, "ksadsdk_idc", "idc_data", aVar == null ? "" : aVar.toJson().toString());
    }

    public static void a(Context context, Map<String, String> map) {
        y.a(context, "ksadsdk_idc", "idc_current", (map == null || map.isEmpty()) ? "" : new JSONObject(map).toString());
    }

    public static com.kwad.sdk.core.network.idc.kwai.a aO(Context context) {
        try {
            return com.kwad.sdk.core.network.idc.kwai.a.cj(h.B(context, "ksad_idc.json"));
        } catch (IOException e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            return new com.kwad.sdk.core.network.idc.kwai.a();
        }
    }

    public static com.kwad.sdk.core.network.idc.kwai.a aP(Context context) {
        return com.kwad.sdk.core.network.idc.kwai.a.cj(y.b(context, "ksadsdk_idc", "idc_data", ""));
    }

    public static Map<String, String> aQ(Context context) {
        return t.parseJSON2MapString(y.b(context, "ksadsdk_idc", "idc_current", ""));
    }
}
