package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.lb;
import com.amap.api.col.p0003sl.mj;
import com.amap.api.col.p0003sl.mk;
import com.amap.api.col.p0003sl.ml;
import com.amap.api.col.p0003sl.mm;
import com.amap.api.col.p0003sl.mn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/restruct/e.class */
public final class e {
    TelephonyManager b;
    SignalStrength d;
    private Context h;
    private c m;
    private TelephonyManager.CellInfoCallback q;
    private com.autonavi.aps.amapapi.c u;
    private boolean i = false;
    private boolean j = false;

    /* renamed from: a  reason: collision with root package name */
    ArrayList<d> f9248a = new ArrayList<>();
    private String k = null;
    private ArrayList<d> l = new ArrayList<>();
    private long n = 0;

    /* renamed from: c  reason: collision with root package name */
    PhoneStateListener f9249c = null;
    private boolean o = false;
    private Object p = new Object();
    private boolean r = false;
    boolean e = false;
    StringBuilder f = null;
    private String s = null;
    private String t = null;
    String g = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/restruct/e$a.class */
    public final class a extends TelephonyManager.CellInfoCallback {
        a() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public final void onCellInfo(List<CellInfo> list) {
            try {
                if (com.autonavi.aps.amapapi.utils.i.b() - e.this.n < 500) {
                    return;
                }
                e.b(e.this);
                e.this.a(e.this.t());
                e.this.a(list);
                e.this.n = com.autonavi.aps.amapapi.utils.i.b();
            } catch (SecurityException e) {
                e.this.g = e.getMessage();
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "Cgi", "cellInfo");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/restruct/e$b.class */
    public final class b extends PhoneStateListener {
        b() {
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellInfoChanged(List<CellInfo> list) {
            try {
                if (e.this.u != null) {
                    e.this.u.c();
                }
                if (com.autonavi.aps.amapapi.utils.i.b() - e.this.n < 500) {
                    return;
                }
                e.this.a(e.this.t());
                e.this.a(list);
                e.this.n = com.autonavi.aps.amapapi.utils.i.b();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellLocationChanged(CellLocation cellLocation) {
            if (com.autonavi.aps.amapapi.utils.i.b() - e.this.n < 500) {
                return;
            }
            try {
                e.this.a(cellLocation);
                e.this.a(e.this.u());
                e.this.n = com.autonavi.aps.amapapi.utils.i.b();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onDataConnectionStateChanged(int i) {
            super.onDataConnectionStateChanged(i);
        }

        @Override // android.telephony.PhoneStateListener
        public final void onServiceStateChanged(ServiceState serviceState) {
            try {
                int state = serviceState.getState();
                if (state == 0) {
                    e.this.a(false, false);
                } else if (state != 1) {
                } else {
                    e.this.j();
                }
            } catch (Throwable th) {
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthChanged(int i) {
            super.onSignalStrengthChanged(i);
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (signalStrength == null) {
                return;
            }
            e.this.d = signalStrength;
            try {
                if (e.this.u != null) {
                    e.this.u.c();
                }
            } catch (Throwable th) {
            }
        }
    }

    public e(Context context, Handler handler) {
        this.b = null;
        this.m = null;
        this.h = context;
        if (this.b == null) {
            this.b = (TelephonyManager) com.autonavi.aps.amapapi.utils.i.a(context, "phone");
        }
        o();
        c cVar = new c(context, "cellAge", handler);
        this.m = cVar;
        cVar.a();
    }

    private static d a(int i, boolean z, int i2, int i3, int i4, int i5, int i6) {
        d dVar = new d(i, z);
        dVar.f9246a = i2;
        dVar.b = i3;
        dVar.f9247c = i4;
        dVar.d = i5;
        dVar.k = i6;
        return dVar;
    }

    private d a(CellInfoCdma cellInfoCdma, boolean z) {
        int i;
        int i2;
        int i3;
        if (cellInfoCdma == null || cellInfoCdma.getCellIdentity() == null) {
            return null;
        }
        CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
        if (cellIdentity.getSystemId() <= 0 || cellIdentity.getNetworkId() < 0 || cellIdentity.getBasestationId() < 0) {
            return null;
        }
        CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
        String[] a2 = com.autonavi.aps.amapapi.utils.i.a(this.b);
        try {
            i3 = Integer.parseInt(a2[0]);
            try {
                i2 = Integer.parseInt(a2[1]);
            } catch (Throwable th) {
                i = i3;
                i2 = 0;
                i3 = i;
                d a3 = a(2, z, i3, i2, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                a3.h = cellIdentity2.getSystemId();
                a3.i = cellIdentity2.getNetworkId();
                a3.j = cellIdentity2.getBasestationId();
                a3.f = cellIdentity2.getLatitude();
                a3.g = cellIdentity2.getLongitude();
                a3.s = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                return a3;
            }
        } catch (Throwable th2) {
            i = 0;
        }
        d a32 = a(2, z, i3, i2, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
        a32.h = cellIdentity2.getSystemId();
        a32.i = cellIdentity2.getNetworkId();
        a32.j = cellIdentity2.getBasestationId();
        a32.f = cellIdentity2.getLatitude();
        a32.g = cellIdentity2.getLongitude();
        a32.s = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
        return a32;
    }

    private static d a(CellInfoGsm cellInfoGsm, boolean z) {
        if (cellInfoGsm == null || cellInfoGsm.getCellIdentity() == null) {
            return null;
        }
        CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
        d a2 = a(1, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoGsm.getCellSignalStrength().getDbm());
        a2.o = cellInfoGsm.getCellIdentity().getBsic();
        a2.p = cellInfoGsm.getCellIdentity().getArfcn();
        a2.q = cellInfoGsm.getCellSignalStrength().getTimingAdvance();
        a2.s = cellInfoGsm.getCellSignalStrength().getDbm();
        return a2;
    }

    private static d a(CellInfoLte cellInfoLte, boolean z) {
        if (cellInfoLte == null || cellInfoLte.getCellIdentity() == null) {
            return null;
        }
        CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
        d a2 = a(3, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getTac(), cellIdentity.getCi(), cellInfoLte.getCellSignalStrength().getDbm());
        a2.o = cellIdentity.getPci();
        if (Build.VERSION.SDK_INT >= 24) {
            a2.p = cellIdentity.getEarfcn();
        }
        a2.q = cellInfoLte.getCellSignalStrength().getTimingAdvance();
        a2.s = cellInfoLte.getCellSignalStrength().getDbm();
        return a2;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.autonavi.aps.amapapi.restruct.d a(android.telephony.CellInfoNr r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.restruct.e.a(android.telephony.CellInfoNr, boolean):com.autonavi.aps.amapapi.restruct.d");
    }

    private static d a(CellInfoWcdma cellInfoWcdma, boolean z) {
        if (cellInfoWcdma == null || cellInfoWcdma.getCellIdentity() == null) {
            return null;
        }
        CellIdentityWcdma cellIdentity = cellInfoWcdma.getCellIdentity();
        d a2 = a(4, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoWcdma.getCellSignalStrength().getDbm());
        a2.o = cellIdentity.getPsc();
        a2.p = cellInfoWcdma.getCellIdentity().getUarfcn();
        a2.s = cellInfoWcdma.getCellSignalStrength().getDbm();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CellLocation cellLocation) {
        synchronized (this) {
            String[] a2 = com.autonavi.aps.amapapi.utils.i.a(this.b);
            this.f9248a.clear();
            if (cellLocation instanceof GsmCellLocation) {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                d dVar = new d(1, true);
                dVar.f9246a = com.autonavi.aps.amapapi.utils.i.e(a2[0]);
                dVar.b = com.autonavi.aps.amapapi.utils.i.e(a2[1]);
                dVar.f9247c = gsmCellLocation.getLac();
                dVar.d = gsmCellLocation.getCid();
                if (this.d != null) {
                    int gsmSignalStrength = this.d.getGsmSignalStrength();
                    dVar.s = gsmSignalStrength == 99 ? Integer.MAX_VALUE : b(gsmSignalStrength);
                }
                dVar.r = false;
                this.m.a((c) dVar);
                this.f9248a.add(dVar);
                return;
            }
            if (cellLocation instanceof CdmaCellLocation) {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                d dVar2 = new d(2, true);
                dVar2.f9246a = Integer.parseInt(a2[0]);
                dVar2.b = Integer.parseInt(a2[1]);
                dVar2.f = cdmaCellLocation.getBaseStationLatitude();
                dVar2.g = cdmaCellLocation.getBaseStationLongitude();
                dVar2.h = cdmaCellLocation.getSystemId();
                dVar2.i = cdmaCellLocation.getNetworkId();
                dVar2.j = cdmaCellLocation.getBaseStationId();
                if (this.d != null) {
                    dVar2.s = this.d.getCdmaDbm();
                }
                dVar2.r = false;
                this.m.a((c) dVar2);
                this.f9248a.add(dVar2);
            }
        }
    }

    public static boolean a(int i) {
        return i > 0 && i <= 15;
    }

    private static int b(int i) {
        return (i * 2) - 113;
    }

    private void b(boolean z, boolean z2) {
        if (!this.e && this.b != null && Build.VERSION.SDK_INT >= 29 && this.h.getApplicationInfo().targetSdkVersion >= 29) {
            if (this.q == null) {
                this.q = new a();
            }
            this.b.requestCellInfoUpdate(lb.a().d(), this.q);
            if (z2 || z) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (this.r || i2 >= 20) {
                        break;
                    }
                    try {
                        Thread.sleep(5L);
                    } catch (Throwable th) {
                    }
                    i = i2 + 1;
                }
            }
        }
        this.j = false;
        TelephonyManager telephonyManager = this.b;
        if (telephonyManager != null) {
            String networkOperator = telephonyManager.getNetworkOperator();
            this.k = networkOperator;
            if (!TextUtils.isEmpty(networkOperator)) {
                this.j = true;
            }
        }
        this.n = com.autonavi.aps.amapapi.utils.i.b();
    }

    static /* synthetic */ boolean b(e eVar) {
        eVar.r = true;
        return true;
    }

    private void o() {
        if (this.b == null) {
            return;
        }
        p();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0051 A[Catch: Exception -> 0x00d8, TryCatch #0 {Exception -> 0x00d8, blocks: (B:2:0x0000, B:4:0x0007, B:7:0x0017, B:10:0x0026, B:12:0x0033, B:13:0x003d, B:15:0x0049, B:17:0x0051, B:19:0x0059, B:23:0x0070, B:26:0x0080, B:29:0x0092, B:30:0x00c4, B:32:0x00cb), top: B:51:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00cb A[Catch: Exception -> 0x00d8, TryCatch #0 {Exception -> 0x00d8, blocks: (B:2:0x0000, B:4:0x0007, B:7:0x0017, B:10:0x0026, B:12:0x0033, B:13:0x003d, B:15:0x0049, B:17:0x0051, B:19:0x0059, B:23:0x0070, B:26:0x0080, B:29:0x0092, B:30:0x00c4, B:32:0x00cb), top: B:51:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void p() {
        /*
            Method dump skipped, instructions count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.restruct.e.p():void");
    }

    private int q() {
        d e = e();
        if (e != null) {
            return e.l;
        }
        return 0;
    }

    private CellLocation r() {
        TelephonyManager telephonyManager = this.b;
        if (telephonyManager != null) {
            try {
                CellLocation cellLocation = telephonyManager.getCellLocation();
                this.g = null;
                return cellLocation;
            } catch (SecurityException e) {
                this.g = e.getMessage();
                return null;
            } catch (Throwable th) {
                this.g = null;
                com.autonavi.aps.amapapi.utils.b.a(th, "CgiManager", "getCellLocation");
                return null;
            }
        }
        return null;
    }

    private boolean s() {
        return !this.e && com.autonavi.aps.amapapi.utils.i.b() - this.n >= 45000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellLocation t() {
        if (this.b == null) {
            return null;
        }
        return r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<CellInfo> u() {
        List<CellInfo> list;
        try {
            if (com.autonavi.aps.amapapi.utils.i.c() >= 18 && this.b != null) {
                try {
                    list = this.b.getAllCellInfo();
                } catch (SecurityException e) {
                    e = e;
                    list = null;
                }
                try {
                    this.g = null;
                    return list;
                } catch (SecurityException e2) {
                    e = e2;
                    this.g = e.getMessage();
                    return list;
                }
            }
            return null;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Cgi", "getNewCells");
            return null;
        }
    }

    public final List<mj> a() {
        ArrayList arrayList = new ArrayList();
        List<CellInfo> allCellInfo = this.b.getAllCellInfo();
        if (Build.VERSION.SDK_INT >= 17 && allCellInfo != null) {
            for (CellInfo cellInfo : allCellInfo) {
                if (cellInfo instanceof CellInfoCdma) {
                    CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                    CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
                    mk mkVar = new mk(cellInfo.isRegistered(), true);
                    mkVar.m = cellIdentity.getLatitude();
                    mkVar.n = cellIdentity.getLongitude();
                    mkVar.j = cellIdentity.getSystemId();
                    mkVar.k = cellIdentity.getNetworkId();
                    mkVar.l = cellIdentity.getBasestationId();
                    mkVar.d = cellInfoCdma.getCellSignalStrength().getAsuLevel();
                    mkVar.f5384c = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                    arrayList.add(mkVar);
                } else if (cellInfo instanceof CellInfoGsm) {
                    CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                    CellIdentityGsm cellIdentity2 = cellInfoGsm.getCellIdentity();
                    ml mlVar = new ml(cellInfo.isRegistered(), true);
                    mlVar.f5383a = String.valueOf(cellIdentity2.getMcc());
                    mlVar.b = String.valueOf(cellIdentity2.getMnc());
                    mlVar.j = cellIdentity2.getLac();
                    mlVar.k = cellIdentity2.getCid();
                    mlVar.f5384c = cellInfoGsm.getCellSignalStrength().getDbm();
                    mlVar.d = cellInfoGsm.getCellSignalStrength().getAsuLevel();
                    if (Build.VERSION.SDK_INT >= 24) {
                        mlVar.m = cellIdentity2.getArfcn();
                        mlVar.n = cellIdentity2.getBsic();
                    }
                    arrayList.add(mlVar);
                } else if (cellInfo instanceof CellInfoLte) {
                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                    CellIdentityLte cellIdentity3 = cellInfoLte.getCellIdentity();
                    mm mmVar = new mm(cellInfo.isRegistered());
                    mmVar.f5383a = String.valueOf(cellIdentity3.getMcc());
                    mmVar.b = String.valueOf(cellIdentity3.getMnc());
                    mmVar.l = cellIdentity3.getPci();
                    mmVar.d = cellInfoLte.getCellSignalStrength().getAsuLevel();
                    mmVar.k = cellIdentity3.getCi();
                    mmVar.j = cellIdentity3.getTac();
                    mmVar.n = cellInfoLte.getCellSignalStrength().getTimingAdvance();
                    mmVar.f5384c = cellInfoLte.getCellSignalStrength().getDbm();
                    if (Build.VERSION.SDK_INT >= 24) {
                        mmVar.m = cellIdentity3.getEarfcn();
                    }
                    arrayList.add(mmVar);
                } else if (Build.VERSION.SDK_INT >= 18 && (cellInfo instanceof CellInfoWcdma)) {
                    CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                    CellIdentityWcdma cellIdentity4 = cellInfoWcdma.getCellIdentity();
                    mn mnVar = new mn(cellInfo.isRegistered(), true);
                    mnVar.f5383a = String.valueOf(cellIdentity4.getMcc());
                    mnVar.b = String.valueOf(cellIdentity4.getMnc());
                    mnVar.j = cellIdentity4.getLac();
                    mnVar.k = cellIdentity4.getCid();
                    mnVar.l = cellIdentity4.getPsc();
                    mnVar.d = cellInfoWcdma.getCellSignalStrength().getAsuLevel();
                    mnVar.f5384c = cellInfoWcdma.getCellSignalStrength().getDbm();
                    if (Build.VERSION.SDK_INT >= 24) {
                        mnVar.m = cellIdentity4.getUarfcn();
                    }
                    arrayList.add(mnVar);
                }
            }
        }
        return arrayList;
    }

    public final void a(com.autonavi.aps.amapapi.c cVar) {
        this.u = cVar;
    }

    final void a(List<CellInfo> list) {
        d dVar;
        synchronized (this) {
            if (this.l != null) {
                this.l.clear();
            }
            if (list != null && list.size() > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list.size()) {
                        break;
                    }
                    CellInfo cellInfo = list.get(i2);
                    if (cellInfo != null) {
                        boolean isRegistered = cellInfo.isRegistered();
                        if (cellInfo instanceof CellInfoCdma) {
                            dVar = a((CellInfoCdma) cellInfo, isRegistered);
                        } else if (cellInfo instanceof CellInfoGsm) {
                            dVar = a((CellInfoGsm) cellInfo, isRegistered);
                        } else if (cellInfo instanceof CellInfoWcdma) {
                            dVar = a((CellInfoWcdma) cellInfo, isRegistered);
                        } else if (cellInfo instanceof CellInfoLte) {
                            dVar = a((CellInfoLte) cellInfo, isRegistered);
                        } else {
                            dVar = null;
                            if (Build.VERSION.SDK_INT >= 29) {
                                dVar = null;
                                if (cellInfo instanceof CellInfoNr) {
                                    dVar = a((CellInfoNr) cellInfo, isRegistered);
                                }
                            }
                        }
                        if (dVar != null) {
                            this.m.a((c) dVar);
                            dVar.m = (short) Math.min(65535L, this.m.e((c) dVar));
                            dVar.r = true;
                            this.l.add(dVar);
                        }
                    }
                    i = i2 + 1;
                }
                this.i = false;
                if (this.l != null && this.l.size() > 0) {
                    this.i = true;
                }
            }
        }
    }

    public final void a(boolean z) {
        PhoneStateListener phoneStateListener;
        this.m.a(z);
        this.n = 0L;
        synchronized (this.p) {
            this.o = true;
        }
        TelephonyManager telephonyManager = this.b;
        if (telephonyManager != null && (phoneStateListener = this.f9249c) != null) {
            try {
                telephonyManager.listen(phoneStateListener, 0);
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "CgiManager", "destroy");
            }
        }
        this.f9249c = null;
        this.d = null;
        this.b = null;
    }

    public final void a(boolean z, boolean z2) {
        try {
            this.e = com.autonavi.aps.amapapi.utils.i.a(this.h);
            if (s()) {
                b(z, z2);
                a(t());
                a(u());
            }
            if (this.e) {
                j();
            }
        } catch (SecurityException e) {
            this.g = e.getMessage();
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "CgiManager", "refresh");
        }
    }

    public final void b() {
        try {
            if (Build.VERSION.SDK_INT >= 31) {
                String str = this.h.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 ? "hasFineLocPerm" : "hasNoFineLocPerm";
                String str2 = this.h.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0 ? "hasReadPhoneStatePerm" : "hasNoReadPhoneStatePerm";
                boolean z = false;
                if (!TextUtils.isEmpty(this.t)) {
                    z = false;
                    if (!this.t.equals(str)) {
                        z = true;
                    }
                }
                if (!TextUtils.isEmpty(this.s) && !this.s.equals(str2)) {
                    z = true;
                }
                if (z) {
                    p();
                }
            }
        } catch (Throwable th) {
        }
    }

    public final ArrayList<d> c() {
        ArrayList<d> arrayList;
        synchronized (this) {
            arrayList = new ArrayList<>();
            if (this.f9248a != null) {
                Iterator<d> it = this.f9248a.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().clone());
                }
            }
        }
        return arrayList;
    }

    public final ArrayList<d> d() {
        ArrayList<d> arrayList;
        synchronized (this) {
            arrayList = new ArrayList<>();
            if (this.l != null) {
                Iterator<d> it = this.l.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().clone());
                }
            }
        }
        return arrayList;
    }

    public final d e() {
        synchronized (this) {
            if (this.e) {
                return null;
            }
            ArrayList<d> arrayList = this.f9248a;
            if (arrayList.size() > 0) {
                return arrayList.get(0).clone();
            }
            return null;
        }
    }

    public final d f() {
        d next;
        synchronized (this) {
            if (this.e) {
                return null;
            }
            ArrayList<d> arrayList = this.l;
            if (arrayList.size() > 0) {
                Iterator<d> it = arrayList.iterator();
                do {
                    if (!it.hasNext()) {
                        return arrayList.get(0).clone();
                    }
                    next = it.next();
                } while (!next.n);
                return next.clone();
            }
            return null;
        }
    }

    public final int g() {
        int q = q();
        int i = 0;
        int i2 = this.i ? 4 : 0;
        if (this.j) {
            i = 8;
        }
        return q | i2 | i;
    }

    public final int h() {
        return q() & 3;
    }

    public final TelephonyManager i() {
        return this.b;
    }

    final void j() {
        synchronized (this) {
            this.g = null;
            this.f9248a.clear();
            this.l.clear();
            this.i = false;
            this.j = false;
        }
    }

    public final String k() {
        return this.g;
    }

    public final String l() {
        return this.k;
    }

    public final String m() {
        String sb;
        synchronized (this) {
            if (this.e) {
                j();
            }
            if (this.f == null) {
                this.f = new StringBuilder();
            } else {
                this.f.delete(0, this.f.length());
            }
            if (h() == 1) {
                int i = 1;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.f9248a.size()) {
                        break;
                    }
                    StringBuilder sb2 = this.f;
                    sb2.append("#");
                    sb2.append(this.f9248a.get(i2).b);
                    StringBuilder sb3 = this.f;
                    sb3.append("|");
                    sb3.append(this.f9248a.get(i2).f9247c);
                    StringBuilder sb4 = this.f;
                    sb4.append("|");
                    sb4.append(this.f9248a.get(i2).d);
                    i = i2 + 1;
                }
            }
            int i3 = 1;
            while (true) {
                int i4 = i3;
                if (i4 >= this.l.size()) {
                    break;
                }
                d dVar = this.l.get(i4);
                if (dVar.l != 1 && dVar.l != 3 && dVar.l != 4 && dVar.l != 5) {
                    if (dVar.l == 2) {
                        StringBuilder sb5 = this.f;
                        sb5.append("#");
                        sb5.append(dVar.l);
                        StringBuilder sb6 = this.f;
                        sb6.append("|");
                        sb6.append(dVar.f9246a);
                        StringBuilder sb7 = this.f;
                        sb7.append("|");
                        sb7.append(dVar.h);
                        StringBuilder sb8 = this.f;
                        sb8.append("|");
                        sb8.append(dVar.i);
                        StringBuilder sb9 = this.f;
                        sb9.append("|");
                        sb9.append(dVar.j);
                    }
                    i3 = i4 + 1;
                }
                StringBuilder sb10 = this.f;
                sb10.append("#");
                sb10.append(dVar.l);
                StringBuilder sb11 = this.f;
                sb11.append("|");
                sb11.append(dVar.f9246a);
                StringBuilder sb12 = this.f;
                sb12.append("|");
                sb12.append(dVar.b);
                StringBuilder sb13 = this.f;
                sb13.append("|");
                sb13.append(dVar.f9247c);
                StringBuilder sb14 = this.f;
                sb14.append("|");
                sb14.append(dVar.a());
                i3 = i4 + 1;
            }
            if (this.f.length() > 0) {
                this.f.deleteCharAt(0);
            }
            sb = this.f.toString();
        }
        return sb;
    }

    public final boolean n() {
        try {
            if (this.b != null) {
                if (!TextUtils.isEmpty(this.b.getSimOperator())) {
                    return true;
                }
                if (!TextUtils.isEmpty(this.b.getSimCountryIso())) {
                    return true;
                }
            }
        } catch (Throwable th) {
        }
        try {
            int a2 = com.autonavi.aps.amapapi.utils.i.a(com.autonavi.aps.amapapi.utils.i.c(this.h));
            return a2 == 0 || a2 == 4 || a2 == 2 || a2 == 5 || a2 == 3;
        } catch (Throwable th2) {
            return false;
        }
    }
}
