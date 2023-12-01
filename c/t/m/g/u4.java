package c.t.m.g;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.map.geolocation.util.SoUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/u4.class */
public class u4 {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedBlockingQueue<b> f3960a = new LinkedBlockingQueue<>(3);
    public final t3 b;

    /* renamed from: c  reason: collision with root package name */
    public long f3961c;
    public long d;
    public long e;
    public long f;
    public volatile boolean g;
    public boolean h;
    public volatile Handler i;

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/u4$a.class */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            u4.this.f3960a.clear();
            u4.this.b();
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/u4$b.class */
    public static class b {
        public static final b h = new b();

        /* renamed from: a  reason: collision with root package name */
        public final int f3963a;
        public final byte[] b;

        /* renamed from: c  reason: collision with root package name */
        public final String f3964c;
        public final Object d;
        public int e;
        public String f;
        public long g;

        public b() {
            this.e = 1;
            this.f3963a = 0;
            this.b = null;
            this.f3964c = null;
            this.d = null;
        }

        public b(int i, byte[] bArr, String str, Object obj) {
            this.e = 1;
            this.f3963a = i;
            this.b = bArr;
            this.f3964c = str;
            this.d = obj;
        }

        public static /* synthetic */ int e(b bVar) {
            int i = bVar.e;
            bVar.e = i - 1;
            return i;
        }
    }

    public u4(t3 t3Var) {
        this.b = t3Var;
    }

    public final String a(byte[] bArr, int i) {
        if (!j5.a() && bArr != null) {
            try {
                if (SoUtils.fun_o(bArr, 1) >= 0) {
                    return l4.a(1, i, 1);
                }
            } catch (UnsatisfiedLinkError e) {
                return null;
            }
        }
        return l4.a(1, i, 0);
    }

    public final void a() {
        this.f3961c = 0L;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
    }

    public void a(Handler handler, boolean z) {
        if (this.g) {
            return;
        }
        this.g = true;
        this.i = handler;
        this.h = z;
        this.b.e().execute(new a());
        this.f = SystemClock.elapsedRealtime();
    }

    public final void a(b bVar, String str) throws FileNotFoundException, IOException {
        byte[] a2;
        this.f3961c++;
        this.d += bVar.b.length;
        this.e += g6.a(str.getBytes("UTF-8")) != null ? a2.length : 0;
    }

    public void a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            byte[] a2 = f6.a(str.getBytes("UTF-8"));
            SoUtils.fun_o(a2, 2);
            b bVar = new b(3, a2, "https://ue.indoorloc.map.qq.com/?wl", null);
            bVar.f = str;
            a(bVar);
        } catch (Throwable th) {
        }
    }

    public void a(String str, c5 c5Var, int i) {
        try {
            byte[] a2 = g6.a(str.getBytes("GBK"));
            b bVar = new b(1, a2, a(a2, i), c5Var);
            bVar.f = str;
            a(bVar);
        } catch (Throwable th) {
        }
    }

    public final void a(String str, b bVar, Message message) {
        if (1 == bVar.f3963a) {
            message.obj = Pair.create(str, bVar);
            message.what = 4999;
            message.sendToTarget();
        }
    }

    public final boolean a(b bVar) {
        boolean offer = bVar.b != null ? this.f3960a.offer(bVar) : false;
        if (offer) {
            return offer;
        }
        this.f3960a.clear();
        this.f3960a.offer(bVar);
        if (bVar.f3963a == 2) {
            return offer;
        }
        int unused = bVar.f3963a;
        return offer;
    }

    public final void b() {
        b take;
        LinkedBlockingQueue<b> linkedBlockingQueue = this.f3960a;
        while (this.g) {
            try {
                take = linkedBlockingQueue.take();
                try {
                } catch (IOException e) {
                    System.currentTimeMillis();
                    b(take);
                    Handler handler = this.i;
                    Looper looper = handler == null ? null : handler.getLooper();
                    if (looper != null && looper.getThread().isAlive()) {
                        handler.sendEmptyMessageDelayed(4998, 0L);
                    }
                }
            } catch (Throwable th) {
            }
            if (b.h == take) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            Bundle a2 = this.b.a(take.f3964c, take.b, true);
            String string = a2.getString("result");
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            String str = string;
            if (string == null) {
                str = "";
            }
            a(take, str);
            Handler handler2 = this.i;
            take.g = currentTimeMillis;
            if (!this.h && this.g && handler2 != null && handler2.getLooper().getThread().isAlive()) {
                Message obtainMessage = handler2.obtainMessage();
                obtainMessage.arg1 = (int) currentTimeMillis2;
                a(str, take, obtainMessage);
            }
            try {
                if (take.f3963a == 1 && this.b.a().g() == 0) {
                    this.b.a().a(currentTimeMillis2);
                    this.b.a().c(a2.getString("req_key"));
                }
            } catch (Throwable th2) {
            }
        }
    }

    public final void b(b bVar) {
        boolean z;
        b.e(bVar);
        Iterator<b> it = this.f3960a.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (it.next().f3963a == bVar.f3963a) {
                z = true;
                break;
            }
        }
        if (bVar.e <= 0 || z) {
            return;
        }
        int unused = bVar.e;
        this.f3960a.offer(bVar);
    }

    public void c() {
        if (this.g) {
            this.g = false;
            this.f3960a.clear();
            this.f3960a.offer(b.h);
            this.i = null;
            if (this.f != 0) {
                String.format(Locale.ENGLISH, "shutdown: duration=%ds, sent=%dB, recv=%dB, reqCount=%d", Long.valueOf((SystemClock.elapsedRealtime() - this.f) / 1000), Long.valueOf(this.d), Long.valueOf(this.e), Long.valueOf(this.f3961c));
            }
            a();
        }
    }
}
