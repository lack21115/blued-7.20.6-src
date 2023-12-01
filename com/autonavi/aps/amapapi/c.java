package com.autonavi.aps.amapapi;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiScanner;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import com.amap.api.col.p0003sl.ho;
import com.amap.api.col.p0003sl.hs;
import com.amap.api.col.p0003sl.ht;
import com.amap.api.col.p0003sl.ib;
import com.amap.api.col.p0003sl.iu;
import com.amap.api.col.p0003sl.iw;
import com.amap.api.col.p0003sl.jk;
import com.amap.api.col.p0003sl.jr;
import com.amap.api.col.p0003sl.ju;
import com.amap.api.col.p0003sl.kc;
import com.amap.api.col.p0003sl.ke;
import com.amap.api.col.p0003sl.kf;
import com.amap.api.col.p0003sl.kl;
import com.amap.api.col.p0003sl.kv;
import com.amap.api.col.p0003sl.kx;
import com.amap.api.col.p0003sl.lb;
import com.amap.api.col.p0003sl.lc;
import com.amap.api.col.p0003sl.lk;
import com.amap.api.col.p0003sl.lm;
import com.amap.api.col.p0003sl.mg;
import com.amap.api.col.p0003sl.mj;
import com.amap.api.col.p0003sl.mp;
import com.amap.api.col.p0003sl.mq;
import com.amap.api.col.p0003sl.mu;
import com.amap.api.col.p0003sl.mv;
import com.amap.api.col.p0003sl.mw;
import com.autonavi.aps.amapapi.restruct.e;
import com.autonavi.aps.amapapi.restruct.i;
import com.kuaishou.weapon.p0.t;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.KeyGenerator;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/c.class */
public final class c implements mw {
    private static long k;

    /* renamed from: a  reason: collision with root package name */
    Context f9226a;
    mg d;
    ke e;
    private Handler g;
    private LocationManager h;
    private a i;
    private ArrayList<lm> f = new ArrayList<>();
    i b = null;

    /* renamed from: c  reason: collision with root package name */
    e f9227c = null;
    private volatile boolean j = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/c$a.class */
    public static final class a implements LocationListener {

        /* renamed from: a  reason: collision with root package name */
        private c f9229a;

        a(c cVar) {
            this.f9229a = cVar;
        }

        final void a() {
            this.f9229a = null;
        }

        final void a(c cVar) {
            this.f9229a = cVar;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            try {
                if (this.f9229a != null) {
                    this.f9229a.a(location);
                }
            } catch (Throwable th) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/c$b.class */
    public final class b extends lc {
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private Location f9231c;

        b(int i) {
            this.b = 0;
            this.b = i;
        }

        b(c cVar, Location location) {
            this(1);
            this.f9231c = location;
        }

        private void a() {
            try {
                if (this.f9231c == null || !c.this.j || com.autonavi.aps.amapapi.utils.i.m(c.this.f9226a)) {
                    return;
                }
                Bundle extras = this.f9231c.getExtras();
                int i = 0;
                if (extras != null) {
                    i = extras.getInt("satellites");
                }
                if (com.autonavi.aps.amapapi.utils.i.a(this.f9231c, i)) {
                    return;
                }
                if (c.this.b != null && !c.this.b.s) {
                    c.this.b.f();
                }
                ArrayList<mq> a2 = c.this.b.a();
                List<mj> a3 = c.this.f9227c.a();
                lk.a aVar = new lk.a();
                mp mpVar = new mp();
                mpVar.i = this.f9231c.getAccuracy();
                mpVar.f = this.f9231c.getAltitude();
                mpVar.d = this.f9231c.getLatitude();
                mpVar.h = this.f9231c.getBearing();
                mpVar.e = this.f9231c.getLongitude();
                mpVar.j = this.f9231c.isFromMockProvider();
                mpVar.f5385a = this.f9231c.getProvider();
                mpVar.g = this.f9231c.getSpeed();
                mpVar.l = (byte) i;
                mpVar.b = System.currentTimeMillis();
                mpVar.f5386c = this.f9231c.getTime();
                mpVar.k = this.f9231c.getTime();
                aVar.f5368a = mpVar;
                aVar.b = a2;
                WifiInfo c2 = c.this.b.c();
                if (c2 != null) {
                    aVar.f5369c = mq.a(c2.getBSSID());
                }
                aVar.d = i.A;
                aVar.f = this.f9231c.getTime();
                aVar.g = (byte) hs.n(c.this.f9226a);
                aVar.h = hs.s(c.this.f9226a);
                aVar.e = c.this.b.k();
                aVar.j = com.autonavi.aps.amapapi.utils.i.a(c.this.f9226a);
                aVar.i = a3;
                lm a4 = mg.a(aVar);
                if (a4 == null) {
                    return;
                }
                synchronized (c.this.f) {
                    c.this.f.add(a4);
                    if (c.this.f.size() >= 5) {
                        c.this.e();
                    }
                }
                c.this.d();
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "cl", "coll");
            }
        }

        private void b() {
            if (com.autonavi.aps.amapapi.utils.i.m(c.this.f9226a)) {
                return;
            }
            jr jrVar = null;
            jr jrVar2 = null;
            try {
                long unused = c.k = System.currentTimeMillis();
                if (c.this.e.f.d()) {
                    jr a2 = jr.a(new File(c.this.e.f5266a), c.this.e.b);
                    ArrayList arrayList = new ArrayList();
                    byte[] f = c.f();
                    if (f == null) {
                        try {
                            a2.close();
                            return;
                        } catch (Throwable th) {
                            return;
                        }
                    }
                    List b = c.b(a2, c.this.e, arrayList, f);
                    if (b != null && b.size() != 0) {
                        c.this.e.f.c_(true);
                        jrVar = a2;
                        if (mg.a(ib.b(mg.a(com.autonavi.aps.amapapi.security.a.a(f), ht.b(f, mg.a(), ib.c()), b)))) {
                            jrVar2 = a2;
                            c.b(a2, arrayList);
                            jrVar = a2;
                        }
                    }
                    try {
                        a2.close();
                        return;
                    } catch (Throwable th2) {
                        return;
                    }
                }
                if (jrVar != null) {
                    try {
                        jrVar.close();
                    } catch (Throwable th3) {
                    }
                }
            } catch (Throwable th4) {
                try {
                    iw.c(th4, "leg", "uts");
                    if (jrVar2 != null) {
                        try {
                            jrVar2.close();
                        } catch (Throwable th5) {
                        }
                    }
                } catch (Throwable th6) {
                    if (jrVar2 != null) {
                        try {
                            jrVar2.close();
                        } catch (Throwable th7) {
                        }
                    }
                    throw th6;
                }
            }
        }

        @Override // com.amap.api.col.p0003sl.lc
        public final void runTask() {
            int i = this.b;
            if (i == 1) {
                a();
            } else if (i == 2) {
                b();
            } else if (i == 3) {
                c.this.g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.f9226a = null;
        this.f9226a = context;
        ke keVar = new ke();
        this.e = keVar;
        kl.a(this.f9226a, keVar, iu.k, 100, WifiScanner.MAX_SCAN_PERIOD_MS, "0");
        ke keVar2 = this.e;
        int i = com.autonavi.aps.amapapi.utils.a.g;
        boolean z = com.autonavi.aps.amapapi.utils.a.e;
        int i2 = com.autonavi.aps.amapapi.utils.a.f;
        keVar2.f = new kx(context, i, "kKey", new kv(context, z, i2, i2 * 10, "carrierLocKey"));
        this.e.e = new jk();
    }

    private static int a(byte[] bArr) {
        return ((bArr[0] & 255) << 24) | (bArr[3] & 255) | ((bArr[2] & 255) << 8) | ((bArr[1] & 255) << 16);
    }

    private static byte[] a(int i) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            if (keyGenerator == null) {
                return null;
            }
            keyGenerator.init(i);
            return keyGenerator.generateKey().getEncoded();
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(5:19|(5:20|21|22|23|24)|(1:26)(4:32|33|34|(3:36|(2:40|41)|38)(7:44|45|46|47|48|49|(1:1)(17:53|54|55|56|57|58|59|(7:63|64|65|66|67|61|60)|92|93|94|95|96|97|98|99|(4:111|112|(2:125|126)|114)(4:101|(2:107|108)|103|(6:105|76|77|78|79|80)(2:106|80)))))|28|29) */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x02b0, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0072, code lost:
        if (r0 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009c, code lost:
        if (r0 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01c0, code lost:
        if (r0 != null) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01c3, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01ca, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0213, code lost:
        if (r0 != null) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0267, code lost:
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0238 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0258 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x024d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<com.amap.api.col.p0003sl.lm> b(com.amap.api.col.p0003sl.jr r8, com.amap.api.col.p0003sl.ke r9, java.util.List<java.lang.String> r10, byte[] r11) {
        /*
            Method dump skipped, instructions count: 712
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.c.b(com.amap.api.col.3sl.jr, com.amap.api.col.3sl.ke, java.util.List, byte[]):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(jr jrVar, List<String> list) {
        if (jrVar != null) {
            try {
                for (String str : list) {
                    jrVar.c(str);
                }
                jrVar.close();
            } catch (Throwable th) {
                iw.c(th, t.p, "dlo");
            }
        }
    }

    private static byte[] b(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    private static byte[] c(int i) {
        return new byte[]{(byte) ((i & 65280) >> 8), (byte) (i & 255)};
    }

    static /* synthetic */ byte[] f() {
        return a(128);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            if (com.autonavi.aps.amapapi.utils.i.m(this.f9226a) || this.f == null || this.f.size() == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            synchronized (this.f) {
                arrayList.addAll(this.f);
                this.f.clear();
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] a2 = a(256);
            if (a2 == null) {
                return;
            }
            byteArrayOutputStream.write(c(a2.length));
            byteArrayOutputStream.write(a2);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                lm lmVar = (lm) it.next();
                byte[] b2 = lmVar.b();
                if (b2.length >= 10 && b2.length <= 65535) {
                    byte[] b3 = ht.b(a2, b2, ib.c());
                    byteArrayOutputStream.write(c(b3.length));
                    byteArrayOutputStream.write(b3);
                    byteArrayOutputStream.write(b(lmVar.a()));
                }
            }
            kf.a(Long.toString(System.currentTimeMillis()), byteArrayOutputStream.toByteArray(), this.e);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "clm", "wtD");
        }
    }

    @Override // com.amap.api.col.p0003sl.mw
    public final mv a(mu muVar) {
        try {
            com.autonavi.aps.amapapi.trans.b bVar = new com.autonavi.aps.amapapi.trans.b();
            bVar.a(muVar.b);
            bVar.a(muVar.f5391a);
            bVar.a(muVar.d);
            ju.a();
            kc a2 = ju.a(bVar);
            mv mvVar = new mv();
            mvVar.f5394c = a2.f5264a;
            mvVar.b = a2.b;
            mvVar.f5393a = 200;
            return mvVar;
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        if (com.autonavi.aps.amapapi.utils.i.m(this.f9226a)) {
            return;
        }
        try {
            if (this.i != null && this.h != null) {
                this.h.removeUpdates(this.i);
            }
            if (this.i != null) {
                this.i.a();
            }
            if (this.j) {
                g();
                this.b.a((c) null);
                this.f9227c.a((c) null);
                this.f9227c = null;
                this.b = null;
                this.g = null;
                this.j = false;
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "clm", "stc");
        }
    }

    public final void a(Location location) {
        try {
            if (this.g != null) {
                this.g.post(new b(this, location));
            }
        } catch (Throwable th) {
            iw.c(th, "cl", "olcc");
        }
    }

    public final void a(e eVar, i iVar, Handler handler) {
        if (this.j || eVar == null || iVar == null || handler == null || com.autonavi.aps.amapapi.utils.i.m(this.f9226a)) {
            return;
        }
        this.j = true;
        this.f9227c = eVar;
        this.b = iVar;
        iVar.a(this);
        this.f9227c.a(this);
        this.g = handler;
        try {
            if (this.h == null && handler != null) {
                this.h = (LocationManager) this.f9226a.getSystemService("location");
            }
            if (this.i == null) {
                this.i = new a(this);
            }
            this.i.a(this);
            if (this.i != null && this.h != null) {
                this.h.requestLocationUpdates(LocationManager.PASSIVE_PROVIDER, 1000L, -1.0f, this.i);
            }
            if (this.d == null) {
                mg mgVar = new mg("6.1.0", ho.f(this.f9226a), "S128DF1572465B890OE3F7A13167KLEI", ho.c(this.f9226a), this);
                this.d = mgVar;
                mgVar.a(hs.v(this.f9226a)).b(hs.h(this.f9226a)).c(hs.a(this.f9226a)).d(hs.g(this.f9226a)).e(hs.y(this.f9226a)).f(hs.i(this.f9226a)).g(Build.MODEL).h(Build.MANUFACTURER).i(Build.BRAND).a(Build.VERSION.SDK_INT).j(Build.VERSION.RELEASE).a(mq.a(hs.k(this.f9226a))).k(hs.k(this.f9226a));
                mg.b();
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "col", "init");
        }
    }

    public final void b() {
        try {
            if (this.g != null) {
                this.g.post(new Runnable() { // from class: com.autonavi.aps.amapapi.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            if (c.this.d == null || c.this.b == null) {
                                return;
                            }
                            mg.b(c.this.b.a());
                        } catch (Throwable th) {
                            com.autonavi.aps.amapapi.utils.b.a(th, "cl", "upwr");
                        }
                    }
                });
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "cl", "upw");
        }
    }

    public final void c() {
        try {
            if (this.d == null || this.f9227c == null) {
                return;
            }
            mg.a(this.f9227c.a());
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "cl", "upc");
        }
    }

    public final void d() {
        try {
            if (!com.autonavi.aps.amapapi.utils.i.m(this.f9226a) && System.currentTimeMillis() - k >= 60000) {
                lb.a().a(new b(2));
            }
        } catch (Throwable th) {
        }
    }

    public final void e() {
        try {
            lb.a().a(new b(3));
        } catch (Throwable th) {
        }
    }
}
