package com.opos.mobad.service;

import android.content.Context;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/e.class */
public class e {
    public static int a(Context context, String str, String str2) {
        try {
            return b.b(context).getResources().getIdentifier(str, str2, b.b(context).getPackageName());
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ResourcesUtils", "getIdentifierFromHost", e);
            return 0;
        }
    }
}
