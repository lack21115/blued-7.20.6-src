package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.gsm.GsmCellLocation;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/k4.class */
public final class k4 extends PhoneStateListener {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f3861a;
    public final t3 b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f3862c = new byte[0];
    public CellLocation d = null;
    public SignalStrength e = null;
    public ServiceState f = null;
    public long g;
    public HandlerThread h;
    public b i;

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/k4$b.class */
    public final class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f3863a;

        public b(Looper looper) {
            super(looper);
            this.f3863a = false;
            this.f3863a = false;
        }

        public void a() {
            this.f3863a = true;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (k4.this.f3861a) {
                synchronized (k4.this.f3862c) {
                    if (k4.this.i != null && !this.f3863a) {
                        sendEmptyMessageDelayed(0, 30000L);
                    }
                }
                k4.this.c(v5.b(k4.this.b));
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/k4$c.class */
    public static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public t3 f3864a;
        public a5 b;

        public c(t3 t3Var) {
            this.f3864a = t3Var;
        }

        public void a(a5 a5Var) {
            this.b = a5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            t3 t3Var = this.f3864a;
            a5 a5Var = this.b;
            if (a5Var != null) {
                t3Var.a(a5Var);
            }
        }
    }

    public k4(t3 t3Var) {
        this.b = t3Var;
    }

    public final void a() {
        this.d = null;
        this.e = null;
        this.f = null;
    }

    public final void a(int i) {
        try {
            this.b.d().listen(this, i);
        } catch (Exception e) {
        }
    }

    public void a(Handler handler) {
        a5 a2;
        if (this.f3861a) {
            return;
        }
        this.f3861a = true;
        b();
        CellLocation b2 = v5.b(this.b);
        if (a(b2) && (a2 = a5.a(this.b, b2, null)) != null) {
            this.d = b2;
            this.b.a(a2);
        }
        a(273);
    }

    public final boolean a(CellLocation cellLocation) {
        if (cellLocation == null) {
            return false;
        }
        try {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            if (gsmCellLocation.getCid() == 0) {
                if (gsmCellLocation.getLac() == 0) {
                    return false;
                }
            }
        } catch (ClassCastException e) {
        }
        return v5.a(cellLocation) >= 0 && !v5.a(this.d, cellLocation) && b(cellLocation);
    }

    public final void b() {
        synchronized (this.f3862c) {
            HandlerThread handlerThread = new HandlerThread("CellProvider");
            this.h = handlerThread;
            handlerThread.start();
            b bVar = new b(this.h.getLooper());
            this.i = bVar;
            bVar.sendEmptyMessageDelayed(0, com.anythink.expressad.video.module.a.a.m.ag);
        }
    }

    public final boolean b(CellLocation cellLocation) {
        a5 a2 = a5.a(this.b, cellLocation, null);
        if (a2 == null) {
            return true;
        }
        return v5.a(a2);
    }

    public final void c() {
        if (this.f3861a && this.d != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.g > 2000) {
                this.g = currentTimeMillis;
                d();
            }
        }
    }

    public final void c(CellLocation cellLocation) {
        onCellLocationChanged(cellLocation);
    }

    public final void d() {
        a5 a2 = a5.a(this.b, this.d, this.e);
        synchronized (this.f3862c) {
            if (this.i != null && a2 != null) {
                c cVar = new c(this.b);
                cVar.a(a2);
                this.i.post(cVar);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e() {
        /*
            r3 = this;
            r0 = r3
            boolean r0 = r0.f3861a
            if (r0 != 0) goto L8
            return
        L8:
            r0 = r3
            android.telephony.ServiceState r0 = r0.f
            r9 = r0
            r0 = 1
            r5 = r0
            r0 = 0
            r7 = r0
            r0 = r9
            if (r0 != 0) goto L1b
            goto L38
        L1b:
            r0 = r9
            int r0 = r0.getState()
            if (r0 != 0) goto L28
            r0 = 1
            r4 = r0
            goto L3a
        L28:
            r0 = r3
            android.telephony.ServiceState r0 = r0.f
            int r0 = r0.getState()
            r1 = 1
            if (r0 != r1) goto L38
            r0 = 0
            r4 = r0
            goto L3a
        L38:
            r0 = -1
            r4 = r0
        L3a:
            r0 = r3
            c.t.m.g.t3 r0 = r0.b
            android.telephony.TelephonyManager r0 = r0.d()
            r9 = r0
            r0 = r3
            c.t.m.g.t3 r0 = r0.b
            android.content.Context r0 = r0.f3992a
            boolean r0 = c.t.m.g.v5.a(r0)
            r8 = r0
            r0 = r9
            if (r0 == 0) goto L60
            r0 = r9
            int r0 = r0.getSimState()
            r1 = 5
            if (r0 != r1) goto L60
            goto L62
        L60:
            r0 = 0
            r5 = r0
        L62:
            r0 = r7
            r6 = r0
            r0 = r8
            if (r0 != 0) goto L76
            r0 = r5
            if (r0 != 0) goto L74
            r0 = r7
            r6 = r0
            goto L76
        L74:
            r0 = r4
            r6 = r0
        L76:
            android.os.Message r0 = new android.os.Message
            r1 = r0
            r1.<init>()
            r9 = r0
            r0 = r9
            r1 = 12999(0x32c7, float:1.8215E-41)
            r0.what = r1
            r0 = r9
            r1 = 12003(0x2ee3, float:1.682E-41)
            r0.arg1 = r1
            r0 = r9
            r1 = r6
            r0.arg2 = r1
            r0 = r3
            c.t.m.g.t3 r0 = r0.b
            r1 = r9
            r0.a(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.k4.e():void");
    }

    public void f() {
        if (this.f3861a) {
            this.f3861a = false;
            a(0);
            synchronized (this.f3862c) {
                if (this.i != null) {
                    this.i.a();
                    this.i.removeCallbacksAndMessages(null);
                    this.i = null;
                }
                if (this.h != null) {
                    this.h.quit();
                    this.h = null;
                }
                a();
                this.g = 0L;
            }
        }
    }

    @Override // android.telephony.PhoneStateListener
    public void onCellLocationChanged(CellLocation cellLocation) {
        super.onCellLocationChanged(cellLocation);
        if (a(cellLocation)) {
            this.d = cellLocation;
            c();
            return;
        }
        String str = "onCellLocationChanged: illegal cell or same cell " + cellLocation;
    }

    @Override // android.telephony.PhoneStateListener
    public void onServiceStateChanged(ServiceState serviceState) {
        super.onServiceStateChanged(serviceState);
        if (serviceState == null) {
            return;
        }
        ServiceState serviceState2 = this.f;
        if (serviceState2 == null || serviceState2.getState() != serviceState.getState()) {
            this.f = serviceState;
            e();
        }
    }

    @Override // android.telephony.PhoneStateListener
    public void onSignalStrengthsChanged(SignalStrength signalStrength) {
        super.onSignalStrengthsChanged(signalStrength);
        if (signalStrength == null) {
            return;
        }
        try {
            SignalStrength signalStrength2 = this.e;
            int m = this.b.a().m();
            if (signalStrength2 == null || v5.a(m, signalStrength2, signalStrength)) {
                this.e = signalStrength;
                c();
            }
        } catch (Exception e) {
            e.toString();
        }
    }
}
