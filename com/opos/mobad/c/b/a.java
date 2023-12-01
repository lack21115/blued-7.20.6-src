package com.opos.mobad.c.b;

import android.content.Context;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/c/b/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f25808a = "FoldUtil";
    private static int b = -1;

    public static boolean a(Context context) {
        boolean z = false;
        if (b == -1) {
            int identifier = context.getResources().getIdentifier("config_lidControlsDisplayFold", "bool", "android");
            if (identifier <= 0 || !context.getResources().getBoolean(identifier)) {
                b = 0;
            } else {
                b = 1;
            }
        }
        if (b == 1) {
            z = true;
        }
        return z;
    }
}
