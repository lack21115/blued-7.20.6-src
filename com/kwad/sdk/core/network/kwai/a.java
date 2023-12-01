package com.kwad.sdk.core.network.kwai;

import android.util.Log;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.f;
import java.io.OutputStream;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/network/kwai/a.class */
public final class a {
    private static AdHttpProxy ahf;

    /* renamed from: com.kwad.sdk.core.network.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/network/kwai/a$a.class */
    public static final class C0564a {
        public String msg;
    }

    public static boolean a(String str, OutputStream outputStream, C0564a c0564a, int i) {
        boolean wj = wj();
        AdHttpProxy adHttpProxy = ahf;
        com.kwad.sdk.core.network.b.a aVar = adHttpProxy;
        if (adHttpProxy == null) {
            com.kwad.sdk.core.d.b.d("VideoCacheHelper", "isAdCacheEnable:" + wj);
            aVar = wj ? com.kwad.sdk.b.rZ() : new com.kwad.sdk.core.network.b.a();
            ahf = aVar;
        }
        if (com.kwad.b.a.a.bI.booleanValue()) {
            com.kwad.sdk.core.d.b.d("VideoCacheHelper", aVar instanceof com.kwad.sdk.core.network.b.b ? "okHttp" : "Http");
        }
        try {
            com.kwad.sdk.core.d.b.d("VideoCacheHelper", "downloadUrlToStream success size:" + i + " url:" + str);
            aVar.downloadUrlToStream(str, outputStream, i);
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.d("VideoCacheHelper", Log.getStackTraceString(e));
            c0564a.msg = e.getMessage();
            return false;
        }
    }

    private static boolean wj() {
        f fVar = (f) ServiceProvider.get(f.class);
        if (fVar != null) {
            return fVar.sN();
        }
        return false;
    }
}
