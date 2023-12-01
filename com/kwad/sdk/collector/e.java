package com.kwad.sdk.collector;

import android.os.Build;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.io.IOException;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/collector/e.class */
public final class e {
    public static String bq(String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                return new String(com.kwad.sdk.core.kwai.c.vH().encode(m.k(q.P(new File(str)))));
            } catch (IOException e) {
                com.kwad.sdk.core.d.b.printStackTrace(e);
                return null;
            }
        }
        return null;
    }
}
