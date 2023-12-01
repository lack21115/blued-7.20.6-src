package com.opos.cmn.an.f.c;

import android.content.Context;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/f/c/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f10851a = false;

    public static String a(Context context) {
        try {
            b(context);
            return com.oplus.stdid.sdk.a.a() ? com.oplus.stdid.sdk.a.e(context) : "";
        } catch (Exception e) {
            return "";
        }
    }

    private static void b(Context context) {
        if (f10851a) {
            return;
        }
        com.oplus.stdid.sdk.a.b(context);
        f10851a = true;
    }
}
