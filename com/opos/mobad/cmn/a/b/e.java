package com.opos.mobad.cmn.a.b;

import java.util.Formatter;
import java.util.Locale;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/a/b/e.class */
public class e {
    public static final String a(long j) {
        if (j <= 0 || j >= 86400000) {
            return "00:00";
        }
        long j2 = j / 1000;
        int i = (int) (j2 % 60);
        int i2 = (int) ((j2 / 60) % 60);
        int i3 = (int) (j2 / com.anythink.expressad.d.a.b.P);
        Formatter formatter = new Formatter(new StringBuilder(), Locale.getDefault());
        try {
            String formatter2 = (i3 > 0 ? formatter.format("%d:%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i)) : formatter.format("%02d:%02d", Integer.valueOf(i2), Integer.valueOf(i))).toString();
            formatter.close();
            return formatter2;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    formatter.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }
}
