package com.opos.exoplayer.core.i;

import android.os.Trace;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/i/t.class */
public final class t {
    public static void a() {
        if (u.f25510a >= 18) {
            b();
        }
    }

    public static void a(String str) {
        if (u.f25510a >= 18) {
            b(str);
        }
    }

    private static void b() {
        Trace.endSection();
    }

    private static void b(String str) {
        Trace.beginSection(str);
    }
}
