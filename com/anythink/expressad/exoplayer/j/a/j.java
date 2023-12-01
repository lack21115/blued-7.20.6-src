package com.anythink.expressad.exoplayer.j.a;

import android.net.Uri;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/a/j.class */
final class j {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7567a = "exo_";
    private static final String b = "exo_redir";

    /* renamed from: c  reason: collision with root package name */
    private static final String f7568c = "exo_len";

    private j() {
    }

    public static long a(i iVar) {
        return iVar.a(f7568c);
    }

    private static void a(k kVar) {
        kVar.a(f7568c);
    }

    public static void a(k kVar, long j) {
        kVar.a(f7568c, j);
    }

    public static void a(k kVar, Uri uri) {
        kVar.a(b, uri.toString());
    }

    private static Uri b(i iVar) {
        String a2 = iVar.a(b, (String) null);
        if (a2 == null) {
            return null;
        }
        return Uri.parse(a2);
    }

    private static void b(k kVar) {
        kVar.a(b);
    }
}
