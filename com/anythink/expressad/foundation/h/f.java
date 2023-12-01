package com.anythink.expressad.foundation.h;

import android.content.Context;
import android.content.res.Resources;
import android.provider.Settings;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/h/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static String f7948a = "DomainSameSDKTool";

    private static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            Resources resources = context.getResources();
            return resources.getDimensionPixelSize(resources.getIdentifier(Settings.System.NAVIGATION_BAR_HEIGHT, "dimen", "android")) > 0;
        } catch (Throwable th) {
            o.b(f7948a, th.getMessage(), th);
            return false;
        }
    }
}
