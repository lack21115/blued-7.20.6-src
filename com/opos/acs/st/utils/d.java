package com.opos.acs.st.utils;

import android.content.Context;
import com.opos.cmn.an.f.b.b;
import com.opos.cmn.an.f.b.c;

/* loaded from: source-8303388-dex2jar.jar:com/opos/acs/st/utils/d.class */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f10775a = false;

    public static void a() {
        com.opos.cmn.an.f.a.a();
    }

    public static void a(final Context context) {
        com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.acs.st.utils.d.1
            @Override // java.lang.Runnable
            public final void run() {
                com.opos.cmn.an.f.a.a(new b.a().a("acs_st").a(Context.this));
                com.opos.cmn.an.f.a.a(new c.a().a(true).a("ad_st").a(), new com.opos.cmn.an.f.b.a() { // from class: com.opos.acs.st.utils.d.1.1
                    @Override // com.opos.cmn.an.f.b.a
                    public final void onDontNeedUpload(String str) {
                        com.opos.cmn.an.f.a.b("LogUtil", "onDontNeedUpload:".concat(String.valueOf(str)));
                    }

                    @Override // com.opos.cmn.an.f.b.a
                    public final void onUploaderFailed(String str) {
                        com.opos.cmn.an.f.a.b("LogUtil", "onUploaderFailed:".concat(String.valueOf(str)));
                    }

                    @Override // com.opos.cmn.an.f.b.a
                    public final void onUploaderSuccess() {
                        com.opos.cmn.an.f.a.b("LogUtil", "onUploaderSuccess:");
                    }
                });
            }
        });
    }

    public static void a(String str, String str2) {
        com.opos.cmn.an.f.a.b(str, str2);
    }

    public static void a(String str, String str2, Throwable th) {
        com.opos.cmn.an.f.a.b(str, str2, th);
    }

    public static void b(String str, String str2) {
        com.opos.cmn.an.f.a.d(str, str2);
    }

    public static void b(String str, String str2, Throwable th) {
        com.opos.cmn.an.f.a.c(str, str2, th);
    }

    public static void c(String str, String str2, Throwable th) {
        com.opos.cmn.an.f.a.d(str, str2, th);
    }
}
