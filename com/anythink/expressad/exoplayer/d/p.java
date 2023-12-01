package com.anythink.expressad.exoplayer.d;

import android.util.Pair;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/d/p.class */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7268a = "LicenseDurationRemaining";
    public static final String b = "PlaybackDurationRemaining";

    private p() {
    }

    private static long a(Map<String, String> map, String str) {
        if (map != null) {
            try {
                String str2 = map.get(str);
                return str2 != null ? Long.parseLong(str2) : com.anythink.expressad.exoplayer.b.b;
            } catch (NumberFormatException e) {
                return com.anythink.expressad.exoplayer.b.b;
            }
        }
        return com.anythink.expressad.exoplayer.b.b;
    }

    public static Pair<Long, Long> a(f<?> fVar) {
        Map<String, String> h = fVar.h();
        if (h == null) {
            return null;
        }
        return new Pair<>(Long.valueOf(a(h, f7268a)), Long.valueOf(a(h, b)));
    }
}
