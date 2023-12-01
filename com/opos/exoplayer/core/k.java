package com.opos.exoplayer.core;

import java.util.HashSet;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/k.class */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static final HashSet<String> f11826a = new HashSet<>();
    private static String b = "goog.exo.core";

    public static String a() {
        String str;
        synchronized (k.class) {
            try {
                str = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public static void a(String str) {
        synchronized (k.class) {
            try {
                if (f11826a.add(str)) {
                    b += ", " + str;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
