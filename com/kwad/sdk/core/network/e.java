package com.kwad.sdk.core.network;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.bb;
import java.io.File;
import java.nio.charset.Charset;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/network/e.class */
public class e {
    private static volatile e agg;
    private String agh = we();

    private e() {
    }

    private static void cd(String str) {
        try {
            com.kwad.sdk.utils.q.a(new File(av.cF(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext())), str, Charset.forName("UTF-8"), false);
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
        }
    }

    public static e wc() {
        if (agg == null) {
            synchronized (e.class) {
                try {
                    if (agg == null) {
                        agg = new e();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return agg;
    }

    private static String we() {
        try {
            return com.kwad.sdk.utils.q.a(new File(av.cF(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext())), Charset.forName("UTF-8"));
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            return null;
        }
    }

    public final void cc(String str) {
        if (bb.isEquals(this.agh, str)) {
            return;
        }
        this.agh = str;
        cd(str);
    }

    public final String wd() {
        return this.agh;
    }
}
