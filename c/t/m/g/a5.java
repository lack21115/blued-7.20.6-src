package c.t.m.g;

import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.blued.das.live.LiveProtos;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/a5.class */
public class a5 extends d5 {
    public static volatile a5 n;
    public static volatile long o;
    public static volatile CellLocation p;
    public List<NeighboringCellInfo> k;
    public List<a5> l;

    /* renamed from: a  reason: collision with root package name */
    public a f3749a = a.NONE;
    public int b = LiveProtos.Event.LIVE_ROOM_CONFIG_POP_SHOW_VALUE;

    /* renamed from: c  reason: collision with root package name */
    public int f3750c = 0;
    public int d = 0;
    public int e = 0;
    public long f = 0;
    public int g = Integer.MAX_VALUE;
    public int h = Integer.MAX_VALUE;
    public boolean j = false;
    public final long i = System.currentTimeMillis();
    public List<String> m = new ArrayList();

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/a5$a.class */
    public enum a {
        NONE,
        GSM,
        CDMA,
        WCDMA,
        LTE,
        NR,
        TEMP6,
        TEMP7,
        NOSIM
    }

    public static int a(int i) {
        if (i < -140 || i > -40) {
            return -1;
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0015, code lost:
        if (r0 >= 65535) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(android.telephony.CellIdentityNr r4) {
        /*
            r0 = r4
            if (r0 != 0) goto L7
            r0 = 2147483647(0x7fffffff, float:NaN)
            return r0
        L7:
            r0 = r4
            int r0 = r0.getTac()
            r6 = r0
            r0 = r6
            if (r0 < 0) goto L18
            r0 = r6
            r5 = r0
            r0 = r6
            r1 = 65535(0xffff, float:9.1834E-41)
            if (r0 < r1) goto L46
        L18:
            r0 = r4
            java.lang.Class r0 = r0.getClass()     // Catch: java.lang.Throwable -> L48
            r7 = r0
            r0 = r7
            java.lang.String r1 = "getHwTac"
            r2 = 0
            java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L48
            java.lang.reflect.Method r0 = r0.getMethod(r1, r2)     // Catch: java.lang.Throwable -> L48
            r7 = r0
            r0 = r6
            r5 = r0
            r0 = r7
            if (r0 == 0) goto L46
            r0 = r7
            r1 = r4
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L48
            java.lang.Object r0 = r0.invoke(r1, r2)     // Catch: java.lang.Throwable -> L48
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Throwable -> L48
            r4 = r0
            r0 = r6
            r5 = r0
            r0 = r4
            if (r0 == 0) goto L46
            r0 = r4
            int r0 = r0.intValue()     // Catch: java.lang.Throwable -> L48
            r5 = r0
        L46:
            r0 = r5
            return r0
        L48:
            r4 = move-exception
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.a5.a(android.telephony.CellIdentityNr):int");
    }

    public static a5 a() {
        synchronized (a5.class) {
            try {
                if (System.currentTimeMillis() - o >= 29000 || n == null) {
                    return null;
                }
                System.currentTimeMillis();
                return n;
            } finally {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
        if (r0.g() == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static c.t.m.g.a5 a(c.t.m.g.t3 r4) {
        /*
            c.t.m.g.a5 r0 = a()
            r5 = r0
            r0 = r5
            if (r0 == 0) goto La
            r0 = r5
            return r0
        La:
            r0 = r4
            r1 = r4
            java.util.List r1 = c.t.m.g.v5.a(r1)
            c.t.m.g.a5 r0 = a(r0, r1)
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L20
            r0 = r6
            r5 = r0
            r0 = r6
            boolean r0 = r0.g()
            if (r0 != 0) goto L2a
        L20:
            r0 = r4
            r1 = r4
            android.telephony.CellLocation r1 = c.t.m.g.v5.b(r1)
            r2 = 0
            c.t.m.g.a5 r0 = a(r0, r1, r2)
            r5 = r0
        L2a:
            r0 = r5
            long r1 = java.lang.System.currentTimeMillis()
            a(r0, r1)
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.a5.a(c.t.m.g.t3):c.t.m.g.a5");
    }

    public static a5 a(t3 t3Var, CellInfo cellInfo) {
        if (cellInfo == null || t3Var == null) {
            return null;
        }
        a5 a2 = a();
        if (a2 != null) {
            return a2;
        }
        TelephonyManager d = t3Var.d();
        a5 a5Var = new a5();
        try {
            if (cellInfo instanceof CellInfoCdma) {
                CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
                a5Var.f3749a = a.CDMA;
                a5Var.a(d, a.CDMA);
                a5Var.f3750c = cellIdentity.getSystemId();
                a5Var.d = cellIdentity.getNetworkId();
                a5Var.f = cellIdentity.getBasestationId();
                a5Var.g = cellIdentity.getLatitude();
                a5Var.h = cellIdentity.getLongitude();
                int dbm = cellInfoCdma.getCellSignalStrength().getDbm();
                int i = -88;
                if (dbm > -110) {
                    i = -88;
                    if (dbm < -40) {
                        i = dbm;
                    }
                }
                a5Var.e = i;
            } else if (cellInfo instanceof CellInfoGsm) {
                CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                a5Var.f3749a = a.GSM;
                CellIdentityGsm cellIdentity2 = cellInfoGsm.getCellIdentity();
                a5Var.d = cellIdentity2.getLac();
                a5Var.f = cellIdentity2.getCid();
                a5Var.b = cellIdentity2.getMcc();
                a5Var.f3750c = cellIdentity2.getMnc();
                int dbm2 = cellInfoGsm.getCellSignalStrength().getDbm();
                int i2 = -88;
                if (dbm2 > -110) {
                    i2 = -88;
                    if (dbm2 < -40) {
                        i2 = dbm2;
                    }
                }
                a5Var.e = i2;
            } else if (cellInfo instanceof CellInfoWcdma) {
                CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                a5Var.f3749a = a.WCDMA;
                CellIdentityWcdma cellIdentity3 = cellInfoWcdma.getCellIdentity();
                a5Var.d = cellIdentity3.getLac();
                a5Var.f = cellIdentity3.getCid();
                a5Var.b = cellIdentity3.getMcc();
                a5Var.f3750c = cellIdentity3.getMnc();
                int dbm3 = cellInfoWcdma.getCellSignalStrength().getDbm();
                int i3 = -88;
                if (dbm3 > -110) {
                    i3 = -88;
                    if (dbm3 < -40) {
                        i3 = dbm3;
                    }
                }
                a5Var.e = i3;
            } else if (cellInfo instanceof CellInfoLte) {
                CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                a5Var.f3749a = a.LTE;
                CellIdentityLte cellIdentity4 = cellInfoLte.getCellIdentity();
                a5Var.d = cellIdentity4.getTac();
                a5Var.f = cellIdentity4.getCi();
                a5Var.b = cellIdentity4.getMcc();
                a5Var.f3750c = cellIdentity4.getMnc();
                int dbm4 = cellInfoLte.getCellSignalStrength().getDbm();
                int i4 = -88;
                if (dbm4 > -110) {
                    i4 = -88;
                    if (dbm4 < -40) {
                        i4 = dbm4;
                    }
                }
                a5Var.e = i4;
            } else if (cellInfo instanceof CellInfoNr) {
                CellInfoNr cellInfoNr = (CellInfoNr) cellInfo;
                a5Var.f3749a = a.NR;
                CellIdentityNr cellIdentityNr = (CellIdentityNr) cellInfoNr.getCellIdentity();
                a5Var.f3750c = Integer.parseInt(cellIdentityNr.getMncString());
                a5Var.b = Integer.parseInt(cellIdentityNr.getMccString());
                a5Var.d = a(cellIdentityNr);
                a5Var.f = cellIdentityNr.getNci();
                a5Var.e = a(cellInfoNr.getCellSignalStrength().getDbm());
            }
        } catch (Throwable th) {
            th.toString();
        }
        a5Var.j = a5Var.f();
        if (a5Var.b == 460 && a5Var.f3750c == Integer.MAX_VALUE) {
            a5Var.f3750c = 0;
        }
        if (!y5.a().b(t3Var.f3992a)) {
            a5Var.f3749a = a.NOSIM;
        }
        a5Var.m.add(a5Var.b());
        a(a5Var, System.currentTimeMillis());
        return a5Var;
    }

    public static a5 a(t3 t3Var, CellLocation cellLocation, SignalStrength signalStrength) {
        if (!t3Var.i() || cellLocation == null) {
            return null;
        }
        a5 a2 = a();
        if (a2 != null) {
            return a2;
        }
        TelephonyManager d = t3Var.d();
        a5 a5Var = new a5();
        try {
            if (cellLocation instanceof CdmaCellLocation) {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                a5Var.f3749a = a.CDMA;
                a5Var.a(d, a.CDMA);
                a5Var.f3750c = cdmaCellLocation.getSystemId();
                a5Var.d = cdmaCellLocation.getNetworkId();
                a5Var.f = cdmaCellLocation.getBaseStationId();
                a5Var.g = cdmaCellLocation.getBaseStationLatitude();
                a5Var.h = cdmaCellLocation.getBaseStationLongitude();
                if (signalStrength == null) {
                    a5Var.e = -1;
                } else {
                    a5Var.e = signalStrength.getCdmaDbm();
                }
            } else {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                a5Var.f3749a = a.GSM;
                a5Var.a(d, a.GSM);
                a5Var.d = gsmCellLocation.getLac();
                a5Var.f = gsmCellLocation.getCid();
                if (signalStrength == null) {
                    a5Var.e = -1;
                } else {
                    a5Var.e = (signalStrength.getGsmSignalStrength() * 2) - 113;
                }
            }
            v5.a(t3Var, d, cellLocation, a5Var.f);
        } catch (Throwable th) {
            th.toString();
        }
        if (a5Var.f()) {
            a5Var.j = true;
        }
        if (!y5.a().b(t3Var.f3992a)) {
            a5Var.f3749a = a.NOSIM;
        }
        a5Var.m.add(a5Var.b());
        a(a5Var, System.currentTimeMillis());
        return a5Var;
    }

    public static a5 a(t3 t3Var, List<CellInfo> list) {
        if (list == null || t3Var == null || list.size() == 0) {
            return new a5();
        }
        a5 a2 = a();
        if (a2 != null) {
            return a2;
        }
        ArrayList arrayList = new ArrayList();
        a5 a5Var = new a5();
        boolean z = true;
        a5 a5Var2 = a5Var;
        for (CellInfo cellInfo : list) {
            if (cellInfo != null && cellInfo.isRegistered()) {
                a5 a3 = a(t3Var, cellInfo);
                if (a3.f()) {
                    a5Var2.m.add(a3.b());
                    if (z) {
                        z = false;
                        a3.j = true;
                        a5Var2 = a3;
                    } else {
                        arrayList.add(a3);
                    }
                } else {
                    s3.a("Cells", "invalid!" + a3.h());
                }
            }
        }
        a5Var2.l = arrayList;
        TelephonyManager d = t3Var.d();
        p = v5.b(t3Var);
        v5.a(t3Var, d, p, a5Var2.f);
        a(a5Var2, System.currentTimeMillis());
        return a5Var2;
    }

    public static void a(a5 a5Var, long j) {
        synchronized (a5.class) {
            try {
                o = j;
                n = a5Var;
                if (j == 0) {
                    p = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a(TelephonyManager telephonyManager, a aVar) {
        int i;
        int i2;
        String networkOperator = telephonyManager.getNetworkOperator();
        int i3 = 460;
        int i4 = 0;
        if (networkOperator != null) {
            i3 = 460;
            i4 = 0;
            if (networkOperator.length() >= 5) {
                try {
                    i2 = Integer.parseInt(networkOperator.substring(0, 3));
                    try {
                        int parseInt = Integer.parseInt(networkOperator.substring(3, 5));
                        boolean z = i2 == 460 && parseInt == 3;
                        int i5 = parseInt;
                        if (z) {
                            i5 = parseInt;
                            try {
                                if (aVar != a.CDMA) {
                                    i5 = parseInt;
                                    if (networkOperator.length() == 11) {
                                        i5 = Integer.parseInt(networkOperator.substring(9, 11));
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                i = parseInt;
                                th.toString();
                                i4 = i;
                                i3 = i2;
                                if (i3 > 0) {
                                    return;
                                }
                                return;
                            }
                        }
                        i4 = z ? 0 : i5;
                        i3 = i2;
                    } catch (Throwable th2) {
                        th = th2;
                        i = 0;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    i = 0;
                    i2 = 460;
                }
            }
        }
        if (i3 > 0 || i4 < 0) {
            return;
        }
        this.b = i3;
        this.f3750c = i4;
    }

    public void a(List<NeighboringCellInfo> list) {
        synchronized (this) {
            if (list != null) {
                this.k = Collections.unmodifiableList(list);
            } else {
                this.k = Collections.emptyList();
            }
        }
    }

    public boolean a(long j) {
        return System.currentTimeMillis() - this.i < j;
    }

    public String b() {
        return "" + this.b + this.f3750c + this.d + this.f;
    }

    public List<a5> c() {
        if (this.l == null) {
            this.l = Collections.emptyList();
        }
        return this.l;
    }

    public List<NeighboringCellInfo> d() {
        List<NeighboringCellInfo> list;
        synchronized (this) {
            if (this.k == null) {
                this.k = Collections.emptyList();
            }
            list = this.k;
        }
        return list;
    }

    public long e() {
        return this.i;
    }

    public boolean f() {
        int i;
        int i2;
        int i3;
        int i4;
        if (this.f3749a == a.CDMA) {
            int i5 = this.b;
            if (i5 < 0 || (i = this.f3750c) < 0 || i5 == 535 || i == 535 || (i2 = this.d) < 0 || i2 == 65535) {
                return false;
            }
            long j = this.f;
            return j != 65535 && j > 0;
        }
        int i6 = this.b;
        if (i6 < 0 || (i3 = this.f3750c) < 0 || i6 == 535 || i3 == 535 || (i4 = this.d) < 0 || i4 == 65535 || i4 == 25840) {
            return false;
        }
        long j2 = this.f;
        return (j2 == 65535 || j2 == 268435455 || j2 == 2147483647L || j2 == 50594049 || j2 == 8 || j2 == 10 || j2 == 33 || j2 <= 0) ? false : true;
    }

    public boolean g() {
        return this.j;
    }

    public String h() {
        return this.b + "," + this.f3750c + "," + this.d + "," + this.f + "," + this.e;
    }

    public String toString() {
        return "TxCellInfo [PhoneType=" + this.f3749a + ", MCC=" + this.b + ", MNC=" + this.f3750c + ", LAC=" + this.d + ", CID=" + this.f + ", RSSI=" + this.e + ", LAT=" + this.g + ", LNG=" + this.h + ", mTime=" + this.i + "]";
    }
}
