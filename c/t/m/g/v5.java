package c.t.m.g;

import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import c.t.m.g.a5;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/v5.class */
public class v5 {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f3980a = false;

    public static int a(CellLocation cellLocation) {
        if (cellLocation instanceof CdmaCellLocation) {
            return ((CdmaCellLocation) cellLocation).getBaseStationId();
        }
        try {
            return ((GsmCellLocation) cellLocation).getCid();
        } catch (Exception e) {
            return -1;
        }
    }

    public static List<CellInfo> a(t3 t3Var) {
        try {
            List<CellInfo> allCellInfo = t3Var.d().getAllCellInfo();
            if (allCellInfo != null) {
                return allCellInfo;
            }
        } catch (Throwable th) {
        }
        return new ArrayList();
    }

    public static void a(t3 t3Var, TelephonyManager telephonyManager, CellLocation cellLocation, long j) {
        if (telephonyManager != null) {
            try {
                if (telephonyManager.getSimState() == 5) {
                    boolean a2 = a(t3Var.f3944a);
                    boolean z = false;
                    if (cellLocation == null) {
                        z = false;
                        if (j < 0) {
                            z = false;
                            if (!a2) {
                                z = true;
                            }
                        }
                    }
                    f3980a = z;
                }
            } catch (Exception e) {
                f3980a = true;
            }
        }
    }

    public static boolean a(int i) {
        return i == a5.a.CDMA.ordinal();
    }

    public static boolean a(int i, int i2, int i3, int i4, long j) {
        int i5;
        int i6;
        return a(i) ? i2 >= 0 && i3 >= 0 && i4 > 0 && i4 != Integer.MAX_VALUE && j > 0 && j < 65535 : (i2 < 0 || i3 < 0 || i4 < 0 || i4 == Integer.MAX_VALUE || j == 268435455 || j == 2147483647L || j == 50594049 || j == 65535 || j <= 0 || i5 == 0 || i6 <= 0) ? false : true;
    }

    public static boolean a(int i, SignalStrength signalStrength, SignalStrength signalStrength2) {
        if (signalStrength == null || signalStrength2 == null) {
            return true;
        }
        int abs = Math.abs(b(i, signalStrength, signalStrength2));
        return b(i) ? abs > 3 : a(i) && abs > 6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
        if (android.provider.Settings.System.getInt(r3.getContentResolver(), "airplane_mode_on") == 1) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r3) {
        /*
            r0 = 0
            r5 = r0
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L2f
            r4 = r0
            r0 = r4
            r1 = 17
            if (r0 < r1) goto L1c
            r0 = r3
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> L2f
            java.lang.String r1 = "airplane_mode_on"
            int r0 = android.provider.Settings.Global.getInt(r0, r1)     // Catch: java.lang.Throwable -> L2f
            r1 = 1
            if (r0 != r1) goto L2d
            goto L2b
        L1c:
            r0 = r3
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> L2f
            java.lang.String r1 = "airplane_mode_on"
            int r0 = android.provider.Settings.System.getInt(r0, r1)     // Catch: java.lang.Throwable -> L2f
            r4 = r0
            r0 = r4
            r1 = 1
            if (r0 != r1) goto L2d
        L2b:
            r0 = 1
            r5 = r0
        L2d:
            r0 = r5
            return r0
        L2f:
            r3 = move-exception
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.v5.a(android.content.Context):boolean");
    }

    public static boolean a(CellLocation cellLocation, CellLocation cellLocation2) {
        boolean z = false;
        if (!b6.b(cellLocation, cellLocation2) && cellLocation.getClass() == cellLocation2.getClass()) {
            if (cellLocation instanceof GsmCellLocation) {
                if (((GsmCellLocation) cellLocation).getCid() == ((GsmCellLocation) cellLocation2).getCid()) {
                    z = true;
                }
                return z;
            }
            boolean z2 = false;
            if (cellLocation instanceof CdmaCellLocation) {
                z2 = false;
                if (((CdmaCellLocation) cellLocation).getBaseStationId() == ((CdmaCellLocation) cellLocation2).getBaseStationId()) {
                    z2 = true;
                }
            }
            return z2;
        }
        return false;
    }

    public static boolean a(a5 a5Var) {
        if (b6.a(a5Var)) {
            return false;
        }
        return a(a5Var.f3701a.ordinal(), a5Var.b, a5Var.f3702c, a5Var.d, a5Var.f);
    }

    public static int b(int i, SignalStrength signalStrength, SignalStrength signalStrength2) {
        try {
            if (b(i)) {
                return signalStrength.getGsmSignalStrength() - signalStrength2.getGsmSignalStrength();
            }
            if (a(i)) {
                return signalStrength.getCdmaDbm() - signalStrength2.getCdmaDbm();
            }
            return 0;
        } catch (Throwable th) {
            return 0;
        }
    }

    public static CellLocation b(t3 t3Var) {
        TelephonyManager d = t3Var.d();
        if (d != null) {
            try {
                return d.getCellLocation();
            } catch (Exception e) {
            }
        }
        return CellLocation.getEmpty();
    }

    public static boolean b(int i) {
        return i != a5.a.CDMA.ordinal();
    }
}
