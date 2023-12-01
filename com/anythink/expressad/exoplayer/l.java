package com.anythink.expressad.exoplayer;

import java.util.HashSet;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/l.class */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4850a = "ExoPlayer";
    public static final String b = "2.8.4";

    /* renamed from: c  reason: collision with root package name */
    public static final String f4851c = "ExoPlayerLib/2.8.4";
    public static final int d = 2008004;
    public static final boolean e = true;
    public static final boolean f = true;
    private static final HashSet<String> g = new HashSet<>();
    private static String h = "goog.exo.core";

    private l() {
    }

    public static String a() {
        String str;
        synchronized (l.class) {
            try {
                str = h;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    private static void a(String str) {
        synchronized (l.class) {
            try {
                if (g.add(str)) {
                    h += ", " + str;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
