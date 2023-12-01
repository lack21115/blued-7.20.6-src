package com.anythink.expressad.exoplayer.d;

import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.anythink.expressad.exoplayer.d.c;
import com.anythink.expressad.exoplayer.d.e;
import com.anythink.expressad.exoplayer.d.f;
import com.anythink.expressad.exoplayer.d.i;
import com.anythink.expressad.exoplayer.d.j;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/d/b.class */
public final class b<T extends i> implements f<T> {
    private static final String i = "DefaultDrmSession";
    private static final int j = 0;
    private static final int k = 1;
    private static final int l = 60;
    private byte[] A;
    private Object B;
    private Object C;

    /* renamed from: a  reason: collision with root package name */
    final n f4399a;
    final UUID b;

    /* renamed from: c  reason: collision with root package name */
    final b<T>.HandlerC0051b f4400c;
    private final j<T> m;
    private final c<T> n;
    private final e.a o;
    private final int p;
    private final HashMap<String, String> q;
    private final c.a r;
    private final int s;
    private int t;
    private int u;
    private HandlerThread v;
    private b<T>.a w;
    private T x;
    private f.a y;
    private byte[] z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/d/b$a.class */
    public final class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        private static long a(int i) {
            return Math.min((i - 1) * 1000, 5000);
        }

        private boolean a(Message message) {
            int i;
            if ((message.arg1 == 1) && (i = message.arg2 + 1) <= b.this.s) {
                Message obtain = Message.obtain(message);
                obtain.arg2 = i;
                sendMessageDelayed(obtain, Math.min((i - 1) * 1000, 5000));
                return true;
            }
            return false;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        final void a(int i, Object obj, boolean z) {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i;
            boolean z;
            Object obj = message.obj;
            try {
                int i2 = message.what;
                if (i2 == 0) {
                    e = b.this.f4399a.a();
                } else if (i2 != 1) {
                    throw new RuntimeException();
                } else {
                    Pair pair = (Pair) obj;
                    F f = pair.first;
                    S s = pair.second;
                    e = b.this.f4399a.b();
                }
            } catch (Exception e) {
                e = e;
                if ((message.arg1 == 1) && (i = message.arg2 + 1) <= b.this.s) {
                    Message obtain = Message.obtain(message);
                    obtain.arg2 = i;
                    sendMessageDelayed(obtain, Math.min((i - 1) * 1000, 5000));
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return;
                }
            }
            b.this.f4400c.obtainMessage(message.what, Pair.create(obj, e)).sendToTarget();
        }
    }

    /* renamed from: com.anythink.expressad.exoplayer.d.b$b  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/d/b$b.class */
    final class HandlerC0051b extends Handler {
        public HandlerC0051b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Pair pair = (Pair) message.obj;
            F f = pair.first;
            S s = pair.second;
            int i = message.what;
            if (i == 0) {
                b.a(b.this, f, s);
            } else if (i != 1) {
            } else {
                b.b(b.this, f, s);
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/d/b$c.class */
    public interface c<T extends i> {
        void a();

        void a(b<T> bVar);

        void a(Exception exc);
    }

    public b(UUID uuid, j<T> jVar, c<T> cVar, e.a aVar, int i2, byte[] bArr, HashMap<String, String> hashMap, n nVar, Looper looper, c.a aVar2, int i3) {
        this.b = uuid;
        this.n = cVar;
        this.m = jVar;
        this.p = i2;
        this.A = bArr;
        this.o = bArr != null ? null : aVar;
        this.q = hashMap;
        this.f4399a = nVar;
        this.s = i3;
        this.r = aVar2;
        this.t = 2;
        this.f4400c = new HandlerC0051b(looper);
        HandlerThread handlerThread = new HandlerThread("DrmRequestHandler");
        this.v = handlerThread;
        handlerThread.start();
        this.w = new a(this.v.getLooper());
    }

    private void a(int i2, boolean z) {
        String str;
        byte[] bArr;
        String str2;
        byte[] bArr2 = i2 == 3 ? this.A : this.z;
        e.a aVar = this.o;
        if (aVar != null) {
            byte[] bArr3 = aVar.f4417c;
            String str3 = this.o.b;
            str2 = this.o.f4416a;
            bArr = bArr3;
            str = str3;
        } else {
            str = null;
            bArr = null;
            str2 = null;
        }
        try {
            Pair create = Pair.create(this.m.a(bArr2, bArr, str, i2, this.q), str2);
            this.B = create;
            this.w.a(1, create, z);
        } catch (Exception e) {
            b(e);
        }
    }

    static /* synthetic */ void a(b bVar, Object obj, Object obj2) {
        if (obj == bVar.C) {
            if (bVar.t == 2 || bVar.n()) {
                bVar.C = null;
                if (obj2 instanceof Exception) {
                    bVar.n.a((Exception) obj2);
                    return;
                }
                try {
                    bVar.m.b((byte[]) obj2);
                    bVar.n.a();
                } catch (Exception e) {
                    bVar.n.a(e);
                }
            }
        }
    }

    private void a(Object obj, Object obj2) {
        if (obj == this.C) {
            if (this.t == 2 || n()) {
                this.C = null;
                if (obj2 instanceof Exception) {
                    this.n.a((Exception) obj2);
                    return;
                }
                try {
                    this.m.b((byte[]) obj2);
                    this.n.a();
                } catch (Exception e) {
                    this.n.a(e);
                }
            }
        }
    }

    private void a(boolean z) {
        int i2 = this.p;
        if (i2 != 0 && i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3 && k()) {
                    a(3, z);
                }
            } else if (this.A == null) {
                a(2, z);
            } else if (k()) {
                a(2, z);
            }
        } else if (this.A == null) {
            a(1, z);
        } else if (this.t == 4 || k()) {
            long l2 = l();
            if (this.p == 0 && l2 <= 60) {
                Log.d(i, "Offline license has expired or will expire soon. Remaining seconds: ".concat(String.valueOf(l2)));
                a(2, z);
            } else if (l2 <= 0) {
                c(new m());
            } else {
                this.t = 4;
                this.r.b();
            }
        }
    }

    static /* synthetic */ void b(b bVar, Object obj, Object obj2) {
        if (obj == bVar.B && bVar.n()) {
            bVar.B = null;
            if (obj2 instanceof Exception) {
                bVar.b((Exception) obj2);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (bVar.p == 3) {
                    bVar.m.a(bVar.A, bArr);
                    bVar.r.c();
                    return;
                }
                byte[] a2 = bVar.m.a(bVar.z, bArr);
                if ((bVar.p == 2 || (bVar.p == 0 && bVar.A != null)) && a2 != null && a2.length != 0) {
                    bVar.A = a2;
                }
                bVar.t = 4;
                bVar.r.a();
            } catch (Exception e) {
                bVar.b(e);
            }
        }
    }

    private void b(Exception exc) {
        if (exc instanceof NotProvisionedException) {
            this.n.a(this);
        } else {
            c(exc);
        }
    }

    private void b(Object obj, Object obj2) {
        if (obj == this.B && n()) {
            this.B = null;
            if (obj2 instanceof Exception) {
                b((Exception) obj2);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.p == 3) {
                    this.m.a(this.A, bArr);
                    this.r.c();
                    return;
                }
                byte[] a2 = this.m.a(this.z, bArr);
                if ((this.p == 2 || (this.p == 0 && this.A != null)) && a2 != null && a2.length != 0) {
                    this.A = a2;
                }
                this.t = 4;
                this.r.a();
            } catch (Exception e) {
                b(e);
            }
        }
    }

    private void c(Exception exc) {
        this.y = new f.a(exc);
        this.r.a(exc);
        if (this.t != 4) {
            this.t = 1;
        }
    }

    private boolean j() {
        if (n()) {
            return true;
        }
        try {
            byte[] a2 = this.m.a();
            this.z = a2;
            this.x = this.m.d(a2);
            this.t = 3;
            return true;
        } catch (Exception e) {
            c(e);
            return false;
        }
    }

    private boolean k() {
        try {
            this.m.b(this.z, this.A);
            return true;
        } catch (Exception e) {
            Log.e(i, "Error trying to restore Widevine keys.", e);
            c(e);
            return false;
        }
    }

    private long l() {
        if (com.anythink.expressad.exoplayer.b.bk.equals(this.b)) {
            Pair<Long, Long> a2 = p.a(this);
            return Math.min(a2.first.longValue(), a2.second.longValue());
        }
        return Long.MAX_VALUE;
    }

    private void m() {
        if (this.t == 4) {
            this.t = 3;
            c(new m());
        }
    }

    private boolean n() {
        int i2 = this.t;
        return i2 == 3 || i2 == 4;
    }

    public final void a() {
        int i2 = this.u + 1;
        this.u = i2;
        if (i2 == 1 && this.t != 1 && j()) {
            a(true);
        }
    }

    public final void a(int i2) {
        if (n()) {
            if (i2 == 1) {
                this.t = 3;
                this.n.a(this);
            } else if (i2 == 2) {
                a(false);
            } else if (i2 == 3 && this.t == 4) {
                this.t = 3;
                c(new m());
            }
        }
    }

    public final void a(Exception exc) {
        c(exc);
    }

    public final boolean a(byte[] bArr) {
        e.a aVar = this.o;
        return Arrays.equals(aVar != null ? aVar.f4417c : null, bArr);
    }

    public final boolean b() {
        int i2 = this.u - 1;
        this.u = i2;
        if (i2 == 0) {
            this.t = 0;
            this.f4400c.removeCallbacksAndMessages(null);
            this.w.removeCallbacksAndMessages(null);
            this.w = null;
            this.v.quit();
            this.v = null;
            this.x = null;
            this.y = null;
            this.B = null;
            this.C = null;
            byte[] bArr = this.z;
            if (bArr != null) {
                this.m.a(bArr);
                this.z = null;
                return true;
            }
            return true;
        }
        return false;
    }

    public final boolean b(byte[] bArr) {
        return Arrays.equals(this.z, bArr);
    }

    public final void c() {
        j.h b = this.m.b();
        this.C = b;
        this.w.a(0, b, true);
    }

    public final void d() {
        if (j()) {
            a(true);
        }
    }

    @Override // com.anythink.expressad.exoplayer.d.f
    public final int e() {
        return this.t;
    }

    @Override // com.anythink.expressad.exoplayer.d.f
    public final f.a f() {
        if (this.t == 1) {
            return this.y;
        }
        return null;
    }

    @Override // com.anythink.expressad.exoplayer.d.f
    public final T g() {
        return this.x;
    }

    @Override // com.anythink.expressad.exoplayer.d.f
    public final Map<String, String> h() {
        byte[] bArr = this.z;
        if (bArr == null) {
            return null;
        }
        return this.m.c(bArr);
    }

    @Override // com.anythink.expressad.exoplayer.d.f
    public final byte[] i() {
        return this.A;
    }
}
