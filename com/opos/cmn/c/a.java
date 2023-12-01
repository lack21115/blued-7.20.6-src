package com.opos.cmn.c;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.an.f.b.b;
import com.opos.cmn.an.f.b.c;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/c/a.class */
public class a {
    public static void a() {
        com.opos.cmn.an.f.a.b();
    }

    public static void a(Context context, boolean z, String str, boolean z2) {
        if (context == null) {
            return;
        }
        if (z) {
            com.opos.cmn.an.f.a.a();
        }
        b.a a2 = new b.a().b(c() ? 1 : 4).c(7).a("mob_ad");
        a2.a(1);
        if (!TextUtils.isEmpty(str)) {
            a2.b(str);
        }
        b a3 = a2.a(context);
        com.opos.cmn.an.f.a.a(context, z2);
        com.opos.cmn.an.f.a.a(a3);
    }

    public static void a(Context context, boolean z, boolean z2) {
        if (context == null) {
            return;
        }
        a(context, z, context.getPackageName(), z2);
    }

    public static void b() {
        com.opos.cmn.an.f.a.a(new c.a().a(true).a("ad_mob").a(), new com.opos.cmn.an.f.b.a() { // from class: com.opos.cmn.c.a.1
            @Override // com.opos.cmn.an.f.b.a
            public void onDontNeedUpload(String str) {
                com.opos.cmn.an.f.a.a("lc", "onDontNeedUpload " + str);
            }

            @Override // com.opos.cmn.an.f.b.a
            public void onUploaderFailed(String str) {
                com.opos.cmn.an.f.a.a("lc", "onUploaderFailed " + str);
            }

            @Override // com.opos.cmn.an.f.b.a
            public void onUploaderSuccess() {
                com.opos.cmn.an.f.a.a("lc", "onUploaderSuccess ");
            }
        });
    }

    public static final boolean c() {
        String a2 = com.opos.cmn.an.a.b.a("Y29tLmhleXRhcC5tc3AubW9iYWQuYQ==");
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        try {
            return Class.forName(a2) != null;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
