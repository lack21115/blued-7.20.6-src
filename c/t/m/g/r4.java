package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/r4.class */
public final class r4 {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f3960a;

    /* renamed from: c  reason: collision with root package name */
    public final t3 f3961c;
    public HandlerThread f;
    public b g;
    public c h;
    public SignalStrength i;
    public final byte[] b = new byte[0];
    public a5 d = null;
    public ServiceState e = null;

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/r4$a.class */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r4.this.h = new c();
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/r4$b.class */
    public final class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f3963a;

        public b(Looper looper) {
            super(looper);
            this.f3963a = false;
            this.f3963a = false;
        }

        public /* synthetic */ b(r4 r4Var, Looper looper, a aVar) {
            this(looper);
        }

        public void a() {
            this.f3963a = true;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (r4.this.f3960a) {
                if ((r4.this.d == null || !r4.this.d.a(com.anythink.expressad.video.module.a.a.m.ag)) && r4.this.f3961c.d() != null) {
                    a5 a2 = a5.a(r4.this.f3961c, v5.a(r4.this.f3961c));
                    a5 a5Var = a2;
                    if (!a2.g()) {
                        a5 a3 = a5.a(r4.this.f3961c, a5.p, r4.this.i);
                        a5Var = a3;
                        if (a3 != null) {
                            a3.g();
                            a5Var = a3;
                        }
                    }
                    r4.this.a(a5Var, 2);
                }
                synchronized (r4.this.b) {
                    if (r4.this.g != null && !this.f3963a) {
                        c3.a(r4.this.g, 0, 30000L);
                    }
                }
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/r4$c.class */
    public final class c extends PhoneStateListener {
        public c() {
            a(1297);
        }

        public void a() {
            a(0);
        }

        public final void a(int i) {
            try {
                r4.this.f3961c.d().listen(this, i);
                s3.a("cell", "lCS");
            } catch (Throwable th) {
                th.toString();
            }
        }

        @Override // android.telephony.PhoneStateListener
        public void onCellInfoChanged(List<CellInfo> list) {
            if (list != null) {
                list.size();
            }
            r4.this.a(a5.a(r4.this.f3961c, list), 0);
        }

        @Override // android.telephony.PhoneStateListener
        public void onCellLocationChanged(CellLocation cellLocation) {
            Thread.currentThread().getName();
            super.onCellLocationChanged(cellLocation);
            r4.this.a(a5.a(r4.this.f3961c, cellLocation, r4.this.i), 1);
        }

        @Override // android.telephony.PhoneStateListener
        public void onServiceStateChanged(ServiceState serviceState) {
            super.onServiceStateChanged(serviceState);
            if (serviceState == null) {
                return;
            }
            try {
                ServiceState serviceState2 = r4.this.e;
                if (serviceState2 == null || serviceState2.getState() != serviceState.getState()) {
                    r4.this.e = serviceState;
                    r4.this.a();
                }
            } catch (Throwable th) {
            }
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            super.onSignalStrengthsChanged(signalStrength);
            r4.this.i = signalStrength;
        }
    }

    public r4(t3 t3Var) {
        this.f3961c = t3Var;
        f6.b = 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            r3 = this;
            r0 = r3
            boolean r0 = r0.f3960a
            if (r0 != 0) goto L8
            return
        L8:
            r0 = r3
            android.telephony.ServiceState r0 = r0.e
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
            android.telephony.ServiceState r0 = r0.e
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
            c.t.m.g.t3 r0 = r0.f3961c
            android.telephony.TelephonyManager r0 = r0.d()
            r9 = r0
            r0 = r3
            c.t.m.g.t3 r0 = r0.f3961c
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
            c.t.m.g.t3 r0 = r0.f3961c
            r1 = r9
            r0.a(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.r4.a():void");
    }

    public void a(Handler handler, boolean z) {
        if (this.f3960a) {
            return;
        }
        a5.a((a5) null, 0L);
        f6.b = 0L;
        HandlerThread handlerThread = new HandlerThread("new_cell_provider");
        this.f = handlerThread;
        if (handler != null) {
            try {
                handlerThread.start();
                this.g = new b(this, this.f.getLooper(), null);
            } catch (Throwable th) {
                this.g = new b(this, handler.getLooper(), null);
            }
            this.f3960a = true;
            if (!z) {
                c3.b(this.g, 0);
            }
            this.g.postDelayed(new a(), 1000L);
        }
    }

    public final void a(a5 a5Var) {
        if (!this.f3960a || a5Var == null || this.f3961c == null) {
            return;
        }
        synchronized (this) {
            if (this.d != null) {
                a5Var.a(this.d.d());
            }
            this.d = a5Var;
            a5Var.toString();
            this.f3961c.a(a5Var);
        }
    }

    public final void a(a5 a5Var, int i) {
        List<String> list;
        List<String> list2;
        List<String> list3;
        if (this.d == null && a5Var != null && a5Var.g()) {
            a5Var.toString();
            a(a5Var);
            return;
        }
        a5 a5Var2 = this.d;
        if (i == 0) {
            if (a5Var == null || !a5Var.g()) {
                return;
            }
            a5Var.toString();
            if (a5Var2 != null && (list = a5Var2.m) != null && list.containsAll(a5Var.m)) {
                a5Var2.m.size();
                a5Var2.toString();
                return;
            }
            s3.a("CELL", "src=0,info=" + a5Var.h());
            a(a5Var);
        } else if (i == 1) {
            if (a5Var == null || !a5Var.g()) {
                return;
            }
            a5Var.toString();
            if (a5Var2 != null && (list2 = a5Var2.m) != null && list2.contains(a5Var.b())) {
                a5Var2.toString();
                return;
            }
            s3.a("CELL", "src=1,info=" + a5Var.h());
            a(a5Var);
        } else if (i == 2 && a5Var != null && a5Var.g()) {
            a5Var.toString();
            if (a5Var2 != null && (list3 = a5Var2.m) != null && list3.containsAll(a5Var.m)) {
                a5Var2.m.size();
                a5Var2.toString();
                return;
            }
            s3.a("CELL", "src=2,info=" + a5Var.h());
            a(a5Var);
        }
    }

    public void b() {
        if (this.f3960a) {
            this.f3960a = false;
            f6.b = 0L;
            synchronized (this.b) {
                if (this.h != null) {
                    this.h.a();
                }
                if (this.g != null) {
                    this.g.a();
                    this.g.removeCallbacksAndMessages(null);
                    this.g = null;
                }
                if (this.f != null) {
                    this.f.quit();
                    this.f = null;
                }
                this.d = null;
                this.e = null;
                this.h = null;
                this.i = null;
                a5.a((a5) null, 0L);
            }
        }
    }
}
