package org.repackage.com.heytap.openid.sdk;

import android.content.Context;
import org.repackage.a.a.a.a.a;
import org.repackage.a.a.a.a.c;

/* loaded from: source-3503164-dex2jar.jar:org/repackage/com/heytap/openid/sdk/OpenIDSDK.class */
public class OpenIDSDK {
    public static void a(Context context) {
        a.b = c.a.f44105a.a(context.getApplicationContext());
        a.f44100a = true;
    }

    public static boolean a() {
        if (a.f44100a) {
            return a.b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String b(Context context) {
        if (a.f44100a) {
            return c.a.f44105a.a(context.getApplicationContext(), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}
