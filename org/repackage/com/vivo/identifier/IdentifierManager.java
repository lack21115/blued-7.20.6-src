package org.repackage.com.vivo.identifier;

import android.content.Context;

/* loaded from: source-3503164-dex2jar.jar:org/repackage/com/vivo/identifier/IdentifierManager.class */
public class IdentifierManager {
    public static boolean a(Context context) {
        if (IdentifierIdClient.b(context) == null) {
            return false;
        }
        return IdentifierIdClient.a();
    }

    public static String b(Context context) {
        IdentifierIdClient b = IdentifierIdClient.b(context);
        if (b == null) {
            return null;
        }
        return b.b();
    }
}
