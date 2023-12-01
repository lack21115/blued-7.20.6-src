package com.anythink.expressad.exoplayer.k;

import android.os.Trace;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/ad.class */
public final class ad {
    private ad() {
    }

    public static void a() {
        if (af.f7632a >= 18) {
            Trace.endSection();
        }
    }

    public static void a(String str) {
        if (af.f7632a >= 18) {
            Trace.beginSection(str);
        }
    }

    private static void b() {
        Trace.endSection();
    }

    private static void b(String str) {
        Trace.beginSection(str);
    }
}
