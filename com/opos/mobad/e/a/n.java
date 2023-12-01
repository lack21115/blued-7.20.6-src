package com.opos.mobad.e.a;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/e/a/n.class */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f12314a;

    public static f a() {
        return new com.opos.mobad.e.a.a.b();
    }

    public static void a(Context context, String str, String str2, m mVar) {
        if (f12314a) {
            com.opos.cmn.an.f.a.b("MatManager", "already init!");
            return;
        }
        com.opos.cmn.an.f.a.b("MatManager", "init!");
        f12314a = true;
        com.opos.mobad.e.a.a.b.a.a().f12305a = mVar;
        com.opos.mobad.e.a.a.b.a.a().a(context, str, str2, "com.opos.dy.mat");
    }

    public static void a(final String str, final String str2, final h hVar) {
        com.opos.cmn.an.f.a.b("MatManager", "prepare!");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.e.a.n.1
                @Override // java.lang.Runnable
                public final void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    boolean a2 = com.opos.mobad.e.a.a.d.a(str, str2);
                    h hVar2 = hVar;
                    if (hVar2 != null) {
                        hVar2.a(a2, str2);
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    com.opos.cmn.an.f.a.b("MatManager", "prepare result:" + a2 + ",destPath:" + str2 + ",costTime" + (currentTimeMillis2 - currentTimeMillis));
                }
            });
            return;
        }
        com.opos.cmn.an.f.a.d("MatManager", "prepare failed!zipPath or destPath is empty!");
        if (hVar != null) {
            hVar.a(false, str2);
        }
    }
}
