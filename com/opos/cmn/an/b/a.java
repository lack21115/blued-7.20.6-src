package com.opos.cmn.an.b;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/b/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f24485a;

    public static String a(Context context) {
        return !TextUtils.isEmpty(f24485a) ? f24485a : com.opos.cmn.biz.a.b.a(context);
    }

    public static void a(final Context context, final String str) {
        f24485a = str;
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.cmn.an.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.biz.a.b.a(Context.this, str);
            }
        });
        com.opos.cmn.an.f.a.c("BrandTool", "Mobile brand : " + str);
    }
}
