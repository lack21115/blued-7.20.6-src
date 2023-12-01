package com.ishumei.l111l11111Il;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import com.ishumei.l1111l111111Il.l111l1111llIl;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111Il/l11l1111I11l.class */
public final class l11l1111I11l {
    public static String l1111l111111Il() {
        String str = "";
        try {
            Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
            if (context != null) {
                str = (String) com.ishumei.l111l1111llIl.l111l1111l1Il.l1111l111111Il(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9e919b8d90969bd18f8d9089969b9a8dd1ac9a8b8b9691988cdbac9a9c8a8d9a"), com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bac8b8d969198"), new Class[]{ContentResolver.class, String.class}, new Object[]{context.getContentResolver(), com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9e919b8d90969ba0969b")});
                if (str == null) {
                    return "";
                }
            }
            return str;
        } catch (Exception e) {
            return "";
        }
    }

    public static int l111l11111I1l() {
        Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
        if (context == null) {
            return -1;
        }
        try {
            return ((Integer) com.ishumei.l111l1111llIl.l111l1111l1Il.l1111l111111Il(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9e919b8d90969bd18f8d9089969b9a8dd1ac9a8b8b9691988cdbac868c8b9a92"), com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bb6918b"), new Class[]{ContentResolver.class, String.class}, new Object[]{context.getContentResolver(), com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("8c9c8d9a9a91a09d8d9698978b919a8c8c")})).intValue();
        } catch (SecurityException e) {
            return -1001;
        } catch (Exception e2) {
            return -1;
        }
    }

    public static int l111l11111Il() {
        Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
        if (context == null) {
            return 0;
        }
        return Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.ALLOW_MOCK_LOCATION, 0) != 0 ? 1 : 0;
    }

    public static long l111l11111lIl() {
        try {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 11) {
                    Collections.sort(arrayList);
                    return ((Long) arrayList.get(5)).longValue();
                }
                arrayList.add(Long.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
                i = i2 + 1;
            }
        } catch (Exception e) {
            return System.currentTimeMillis() - SystemClock.elapsedRealtime();
        }
    }

    public static int l111l1111l1Il() {
        Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
        int i = -1;
        if (context == null) {
            return -1;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                i = Settings.Global.getInt(context.getContentResolver(), "wifi_connected_mac_randomization_enabled");
            } catch (Throwable th) {
                return -1;
            }
        }
        return i;
    }

    private static long l111l1111llIl() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }
}
