package com.ut.mini;

import android.app.Activity;

/* loaded from: source-8829756-dex2jar.jar:com/ut/mini/UTInterfaceCallDelegate.class */
public class UTInterfaceCallDelegate {
    public static void pageAppearByAuto(Activity activity) {
        UTPageHitHelper.getInstance().pageAppearByAuto(activity);
    }

    public static void pageDisAppearByAuto(Activity activity) {
        UTPageHitHelper.getInstance().pageDisAppearByAuto(activity);
    }
}
