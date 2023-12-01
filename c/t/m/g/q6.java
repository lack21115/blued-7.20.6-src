package c.t.m.g;

import android.content.Context;
import android.telephony.TelephonyManager;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/q6.class */
public class q6 {

    /* renamed from: a  reason: collision with root package name */
    public static q6 f3904a = new q6();

    public static q6 a() {
        return f3904a;
    }

    public final int a(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return i != 3 ? 0 : 512;
                }
                return 256;
            }
            return 128;
        }
        return 64;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(android.content.Context r4) {
        /*
            r3 = this;
            r0 = 1
            r8 = r0
            r0 = 0
            r7 = r0
            r0 = r4
            java.lang.String r1 = "wifi"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch: java.lang.Throwable -> L65
            android.net.wifi.WifiManager r0 = (android.net.wifi.WifiManager) r0     // Catch: java.lang.Throwable -> L65
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L37
            r0 = r4
            boolean r0 = r0.isWifiEnabled()     // Catch: java.lang.Throwable -> L65
            r9 = r0
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L65 java.lang.Throwable -> L69
            r1 = 18
            if (r0 < r1) goto L32
            r0 = r4
            boolean r0 = r0.isScanAlwaysAvailable()     // Catch: java.lang.Throwable -> L69
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L32
            r0 = 1
            r5 = r0
            goto L3f
        L32:
            r0 = 0
            r5 = r0
            goto L3f
        L37:
            r0 = 0
            r9 = r0
        L3a:
            r0 = 0
            r5 = r0
            r0 = 0
            r8 = r0
        L3f:
            r0 = r9
            if (r0 != 0) goto L47
            r0 = 2
            r7 = r0
        L47:
            r0 = r7
            r6 = r0
            r0 = r8
            if (r0 != 0) goto L55
            r0 = r7
            r1 = 8
            int r0 = r0 + r1
            r6 = r0
        L55:
            r0 = r6
            r7 = r0
            r0 = r5
            if (r0 != 0) goto L62
            r0 = r6
            r1 = 32
            int r0 = r0 + r1
            r7 = r0
        L62:
            r0 = r7
            return r0
        L65:
            r4 = move-exception
            goto L37
        L69:
            r4 = move-exception
            goto L3a
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.q6.a(android.content.Context):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int b(android.content.Context r5) {
        /*
            r4 = this;
            r0 = r5
            if (r0 != 0) goto L6
            r0 = -1
            return r0
        L6:
            r0 = r4
            r1 = r5
            boolean r0 = r0.c(r1)
            r12 = r0
            r0 = 0
            r10 = r0
            r0 = r5
            java.lang.String r1 = "location"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch: java.lang.Exception -> L99
            android.location.LocationManager r0 = (android.location.LocationManager) r0     // Catch: java.lang.Exception -> L99
            r13 = r0
            r0 = r13
            if (r0 == 0) goto L5c
            r0 = r5
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> L9e
            java.lang.String r1 = "location_mode"
            int r0 = android.provider.Settings.Secure.getInt(r0, r1)     // Catch: java.lang.Throwable -> L9e
            r6 = r0
            goto L2f
        L2d:
            r0 = 0
            r6 = r0
        L2f:
            r0 = r13
            java.lang.String r1 = "gps"
            boolean r0 = r0.isProviderEnabled(r1)     // Catch: java.lang.Exception -> La3
            r9 = r0
            r0 = r13
            java.util.List r0 = r0.getAllProviders()     // Catch: java.lang.Exception -> La3
            r13 = r0
            r0 = r13
            if (r0 != 0) goto L47
            goto L62
        L47:
            r0 = r13
            java.lang.String r1 = "gps"
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Exception -> La3
            r11 = r0
            r0 = r11
            r10 = r0
            r0 = r6
            r8 = r0
            goto L68
        L5c:
            r0 = 0
            r6 = r0
            r0 = r10
            r9 = r0
        L62:
            r0 = 0
            r10 = r0
            r0 = r6
            r8 = r0
        L68:
            r0 = r4
            r1 = r5
            int r0 = r0.a(r1)
            r7 = r0
            r0 = r7
            r6 = r0
            r0 = r12
            if (r0 != 0) goto L79
            r0 = r7
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
        L79:
            r0 = r6
            r7 = r0
            r0 = r9
            if (r0 != 0) goto L84
            r0 = r6
            r1 = 4
            int r0 = r0 + r1
            r7 = r0
        L84:
            r0 = r7
            r6 = r0
            r0 = r10
            if (r0 != 0) goto L90
            r0 = r7
            r1 = 16
            int r0 = r0 + r1
            r6 = r0
        L90:
            r0 = r6
            r1 = r4
            r2 = r8
            int r1 = r1.a(r2)
            int r0 = r0 + r1
            return r0
        L99:
            r13 = move-exception
            goto L5c
        L9e:
            r14 = move-exception
            goto L2d
        La3:
            r13 = move-exception
            r0 = r10
            r9 = r0
            goto L62
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.q6.b(android.content.Context):int");
    }

    public boolean c(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return false;
            }
            return telephonyManager.getSimState() == 5;
        } catch (Exception e) {
            return false;
        }
    }
}
