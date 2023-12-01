package com.sobot.chat.core.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sobot.chat.core.a.a.b;
import com.sobot.chat.core.a.a.c;
import com.sobot.chat.core.a.a.d;
import com.sobot.chat.core.a.a.e;
import com.sobot.chat.core.a.a.f;
import com.sobot.chat.core.a.a.g;
import com.sobot.chat.core.a.a.h;
import com.sobot.chat.core.a.a.i;
import com.sobot.chat.core.a.a.j;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/a/a.class */
public class a {
    public static final String b = a.class.getSimpleName();
    private static final long p = -1;
    private ArrayList<c> A;
    private f B;
    private Timer C;
    private TimerTask D;

    /* renamed from: a  reason: collision with root package name */
    final a f28172a;

    /* renamed from: c  reason: collision with root package name */
    private ExecutorService f28173c;
    private com.sobot.chat.core.a.a.a d;
    private String e;
    private i f;
    private f g;
    private Socket h;
    private g i;
    private e j;
    private e k;
    private boolean l;
    private LinkedBlockingQueue<h> m;
    private long n;
    private long o;
    private long q;
    private h r;
    private j s;
    private long t;
    private C0768a u;
    private b v;
    private d w;
    private c x;
    private ArrayList<b> y;
    private ArrayList<d> z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.sobot.chat.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/a/a$a.class */
    public class C0768a extends Thread {
        private C0768a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            try {
                com.sobot.chat.core.a.a.a b = a.this.f28172a.n().b();
                if (Thread.interrupted()) {
                    return;
                }
                a.this.f28172a.l().setTcpNoDelay(true);
                a.this.f28172a.l().setKeepAlive(true);
                a.this.f28172a.l().setSoTimeout(50000);
                a.this.f28172a.l().connect(b.d(), b.h());
                if (Thread.interrupted()) {
                    return;
                }
                a.this.f28172a.a(e.Connected);
                a.this.f28172a.a(System.currentTimeMillis());
                a.this.f28172a.b(System.currentTimeMillis());
                a.this.f28172a.c(-1L);
                a.this.f28172a.c((h) null);
                a.this.f28172a.a((j) null);
                a.this.f28172a.a((C0768a) null);
                a.this.f28172a.H();
            } catch (Exception e) {
                e.printStackTrace();
                a.this.f28172a.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/a/a$b.class */
    public class b extends Thread {
        private b() {
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x00cd  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00f3  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x012c  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0161 A[LOOP:0: B:33:0x014c->B:35:0x0161, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x017c  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x016f A[EDGE_INSN: B:51:0x016f->B:36:0x016f ?: BREAK  , SYNTHETIC] */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 465
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.core.a.a.b.run():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/a/a$c.class */
    public class c extends Thread {
        private c() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int i;
            int i2;
            super.run();
            try {
                if (a.this.f28172a.n().c().k() == i.a.Manually) {
                    return;
                }
                while (a.this.f28172a.d() && a.this.f28172a.m() != null && !Thread.interrupted()) {
                    j jVar = new j();
                    a.this.f28172a.a(jVar);
                    byte[] l = a.this.f28172a.n().c().l();
                    int length = l == null ? 0 : l.length;
                    byte[] o = a.this.f28172a.n().c().o();
                    int length2 = o == null ? 0 : o.length;
                    int m = a.this.f28172a.n().c().m();
                    a.this.f28172a.c(jVar);
                    if (length > 0) {
                        byte[] a2 = a.this.f28172a.m().a(l, true);
                        a.this.f28172a.b(System.currentTimeMillis());
                        jVar.c(a2);
                        i = length + 0;
                    } else {
                        i = 0;
                    }
                    if (a.this.f28172a.n().c().k() == i.a.AutoReadByLength) {
                        if (m < 0) {
                            a.this.f28172a.e(jVar);
                            a.this.f28172a.a((j) null);
                        } else if (m == 0) {
                            a.this.f28172a.d(jVar);
                            a.this.f28172a.a((j) null);
                        }
                        byte[] a3 = a.this.f28172a.m().a(m);
                        a.this.f28172a.b(System.currentTimeMillis());
                        jVar.d(a3);
                        int i3 = i + m;
                        int a4 = a.this.f28172a.n().c().a(a3) - length2;
                        if (a4 > 0) {
                            int receiveBufferSize = a.this.f28172a.l().getReceiveBufferSize();
                            int i4 = receiveBufferSize;
                            if (a.this.f28172a.n().c().q()) {
                                i4 = Math.min(receiveBufferSize, a.this.f28172a.n().c().p());
                            }
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                i2 = i3;
                                if (i6 >= a4) {
                                    break;
                                }
                                int min = Math.min(i6 + i4, a4);
                                int i7 = min - i6;
                                byte[] a5 = a.this.f28172a.m().a(i7);
                                a.this.f28172a.b(System.currentTimeMillis());
                                if (jVar.a() == null) {
                                    jVar.b(a5);
                                } else {
                                    byte[] bArr = new byte[jVar.a().length + a5.length];
                                    System.arraycopy((Object) jVar.a(), 0, (Object) bArr, 0, jVar.a().length);
                                    System.arraycopy((Object) a5, 0, (Object) bArr, jVar.a().length, a5.length);
                                    jVar.b(bArr);
                                }
                                i3 += i7;
                                a.this.f28172a.a(jVar, i3, length, m, a4, length2);
                                i5 = min;
                            }
                        } else {
                            i2 = i3;
                            if (a4 < 0) {
                                a.this.f28172a.e(jVar);
                                a.this.f28172a.a((j) null);
                                i2 = i3;
                            }
                        }
                        if (length2 > 0) {
                            byte[] a6 = a.this.f28172a.m().a(length2);
                            a.this.f28172a.b(System.currentTimeMillis());
                            jVar.e(a6);
                            a.this.f28172a.a(jVar, i2 + length2, length, m, a4, length2);
                        }
                    } else if (a.this.f28172a.n().c().k() == i.a.AutoReadToTrailer) {
                        if (length2 > 0) {
                            byte[] a7 = a.this.f28172a.m().a(o, false);
                            a.this.f28172a.b(System.currentTimeMillis());
                            jVar.b(a7);
                            jVar.e(o);
                            int length3 = a7.length;
                        } else {
                            a.this.f28172a.e(jVar);
                            a.this.f28172a.a((j) null);
                        }
                    }
                    jVar.a(a.this.f28172a.n().d().a(jVar));
                    if (a.this.f28172a.n().a() != null) {
                        jVar.a(a.this.f28172a.n().a());
                    }
                    a.this.f28172a.d(jVar);
                    a.this.f28172a.b(jVar);
                    a.this.f28172a.a((j) null);
                }
            } catch (Exception e) {
                a.this.f28172a.c();
                if (a.this.f28172a.v() != null) {
                    a.this.f28172a.e(a.this.f28172a.v());
                    a.this.f28172a.a((j) null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/a/a$d.class */
    public class d extends Thread {
        public d() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            h take;
            int i;
            super.run();
            while (a.this.f28172a.d() && !Thread.interrupted() && (take = a.this.f28172a.q().take()) != null) {
                try {
                    a.this.f28172a.c(take);
                    a.this.f28172a.c(System.currentTimeMillis());
                    if (take.b() == null && take.c() != null) {
                        if (a.this.f28172a.n().a() == null) {
                            throw new IllegalArgumentException("we need string charset to send string type message");
                        }
                        take.a(a.this.f28172a.n().a());
                    }
                    if (take.b() == null) {
                        a.this.f28172a.g(take);
                        a.this.f28172a.c((h) null);
                    } else {
                        byte[] d = a.this.f28172a.n().c().d();
                        int i2 = 0;
                        int length = d == null ? 0 : d.length;
                        byte[] f = a.this.f28172a.n().c().f();
                        int length2 = f == null ? 0 : f.length;
                        byte[] a2 = a.this.f28172a.n().c().a(take.b().length + length2);
                        int length3 = a2 == null ? 0 : a2.length;
                        take.a(d);
                        take.c(f);
                        take.b(a2);
                        if (length + length3 + take.b().length + length2 <= 0) {
                            a.this.f28172a.g(take);
                            a.this.f28172a.c((h) null);
                        } else {
                            a.this.f28172a.e(take);
                            a.this.f28172a.a(take, 0, length, length3, take.b().length, length2);
                            if (length > 0) {
                                try {
                                    a.this.f28172a.l().getOutputStream().write(d);
                                    a.this.f28172a.l().getOutputStream().flush();
                                    a.this.f28172a.c(System.currentTimeMillis());
                                    i = length + 0;
                                    a.this.f28172a.a(take, i, length, length3, take.b().length, length2);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    if (a.this.f28172a.u() != null) {
                                        a.this.f28172a.g(a.this.f28172a.u());
                                        a.this.f28172a.c((h) null);
                                    }
                                }
                            } else {
                                i = 0;
                            }
                            int i3 = i;
                            if (length3 > 0) {
                                a.this.f28172a.l().getOutputStream().write(a2);
                                a.this.f28172a.l().getOutputStream().flush();
                                a.this.f28172a.c(System.currentTimeMillis());
                                i3 = i + length3;
                                a.this.f28172a.a(take, i3, length, length3, take.b().length, length2);
                            }
                            int i4 = i3;
                            if (take.b().length > 0) {
                                int sendBufferSize = a.this.f28172a.l().getSendBufferSize();
                                int i5 = sendBufferSize;
                                if (a.this.f28172a.n().c().h()) {
                                    i5 = Math.min(sendBufferSize, a.this.f28172a.n().c().g());
                                }
                                while (true) {
                                    i4 = i3;
                                    if (i2 >= take.b().length) {
                                        break;
                                    }
                                    int min = Math.min(i2 + i5, take.b().length);
                                    OutputStream outputStream = a.this.f28172a.l().getOutputStream();
                                    byte[] b = take.b();
                                    int i6 = min - i2;
                                    outputStream.write(b, i2, i6);
                                    a.this.f28172a.l().getOutputStream().flush();
                                    a.this.f28172a.c(System.currentTimeMillis());
                                    i3 += i6;
                                    a.this.f28172a.a(take, i3, length, length3, take.b().length, length2);
                                    i2 = min;
                                }
                            }
                            if (length2 > 0) {
                                a.this.f28172a.l().getOutputStream().write(f);
                                a.this.f28172a.l().getOutputStream().flush();
                                a.this.f28172a.c(System.currentTimeMillis());
                                a.this.f28172a.a(take, i4 + length2, length, length3, take.b().length, length2);
                            }
                            a.this.f28172a.f(take);
                            a.this.f28172a.c((h) null);
                            a.this.f28172a.c(-1L);
                        }
                    }
                } catch (IllegalMonitorStateException e2) {
                    a.this.m = null;
                    a.this.f28172a.c();
                    if (a.this.f28172a.u() != null) {
                        a.this.f28172a.g(a.this.f28172a.u());
                        a.this.f28172a.c((h) null);
                        return;
                    }
                    return;
                } catch (InterruptedException e3) {
                    if (a.this.f28172a.u() != null) {
                        a.this.f28172a.g(a.this.f28172a.u());
                        a.this.f28172a.c((h) null);
                        return;
                    }
                    return;
                }
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/a/a$e.class */
    public enum e {
        Disconnected,
        Connecting,
        Connected
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/a/a$f.class */
    public static class f extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<a> f28206a;

        public f(a aVar) {
            super(Looper.getMainLooper());
            this.f28206a = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    }

    public a() {
        this(new com.sobot.chat.core.a.a.a());
    }

    public a(com.sobot.chat.core.a.a.a aVar) {
        this.f28172a = this;
        this.q = -1L;
        this.C = null;
        this.D = null;
        this.d = aVar;
    }

    private void G() {
        if (d() && n() != null && n().d() != null && n().d().i()) {
            final h hVar = new h(n().d().b(), true);
            a().execute(new Runnable() { // from class: com.sobot.chat.core.a.a.15
                @Override // java.lang.Runnable
                public void run() {
                    a.this.f28172a.d(hVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            E().post(new Runnable() { // from class: com.sobot.chat.core.a.a.16
                @Override // java.lang.Runnable
                public void run() {
                    a.this.f28172a.H();
                }
            });
            return;
        }
        ArrayList arrayList = (ArrayList) B().clone();
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                try {
                    z().start();
                    A().start();
                    I();
                    return;
                } catch (Exception e2) {
                    this.f28172a.c();
                    return;
                }
            }
            ((b) arrayList.get(i2)).a(this);
            i = i2 + 1;
        }
    }

    private void I() {
        J();
        this.C = new Timer();
        TimerTask timerTask = new TimerTask() { // from class: com.sobot.chat.core.a.a.17
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                a.this.L();
            }
        };
        this.D = timerTask;
        this.C.schedule(timerTask, 10000L, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        Timer timer = this.C;
        if (timer != null) {
            timer.cancel();
            this.C = null;
        }
        TimerTask timerTask = this.D;
        if (timerTask != null) {
            timerTask.cancel();
            this.D = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            E().post(new Runnable() { // from class: com.sobot.chat.core.a.a.18
                @Override // java.lang.Runnable
                public void run() {
                    a.this.f28172a.K();
                }
            });
            return;
        }
        ArrayList arrayList = (ArrayList) B().clone();
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            ((b) arrayList.get(i2)).b(this);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        if (d()) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (n().d().i()) {
                    G();
                    a(currentTimeMillis);
                }
            } catch (Exception e2) {
                c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final h hVar, final int i, final int i2, final int i3, final int i4, final int i5) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            E().post(new Runnable() { // from class: com.sobot.chat.core.a.a.6
                @Override // java.lang.Runnable
                public void run() {
                    a.this.f28172a.a(hVar, i, i2, i3, i4, i5);
                }
            });
            return;
        }
        float f2 = i / (((i2 + i3) + i4) + i5);
        if (B().size() <= 0) {
            return;
        }
        ArrayList arrayList = (ArrayList) C().clone();
        int size = arrayList.size();
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= size) {
                return;
            }
            ((d) arrayList.get(i7)).a(this, hVar, f2, i);
            i6 = i7 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final j jVar, final int i, final int i2, final int i3, final int i4, final int i5) {
        if (System.currentTimeMillis() - w() < 41) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            E().post(new Runnable() { // from class: com.sobot.chat.core.a.a.10
                @Override // java.lang.Runnable
                public void run() {
                    a.this.f28172a.a(jVar, i, i2, i3, i4, i5);
                }
            });
            return;
        }
        float f2 = i / (((i2 + i3) + i4) + i5);
        if (D().size() > 0) {
            ArrayList arrayList = (ArrayList) D().clone();
            int size = arrayList.size();
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= size) {
                    break;
                }
                ((c) arrayList.get(i7)).a(this, jVar, f2, i);
                i6 = i7 + 1;
            }
        }
        d(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final j jVar) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            E().post(new Runnable() { // from class: com.sobot.chat.core.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.f28172a.b(jVar);
                }
            });
            return;
        }
        b(System.currentTimeMillis());
        if (B().size() <= 0) {
            return;
        }
        ArrayList arrayList = (ArrayList) B().clone();
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            ((b) arrayList.get(i2)).a(this, jVar);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final j jVar) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            E().post(new Runnable() { // from class: com.sobot.chat.core.a.a.7
                @Override // java.lang.Runnable
                public void run() {
                    a.this.f28172a.c(jVar);
                }
            });
        } else if (D().size() <= 0) {
        } else {
            ArrayList arrayList = (ArrayList) D().clone();
            int size = arrayList.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                ((c) arrayList.get(i2)).a(this, jVar);
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(h hVar) {
        if (d()) {
            synchronized (q()) {
                try {
                    q().put(hVar);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final j jVar) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            E().post(new Runnable() { // from class: com.sobot.chat.core.a.a.8
                @Override // java.lang.Runnable
                public void run() {
                    a.this.f28172a.d(jVar);
                }
            });
        } else if (D().size() <= 0) {
        } else {
            ArrayList arrayList = (ArrayList) D().clone();
            int size = arrayList.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                ((c) arrayList.get(i2)).b(this, jVar);
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final h hVar) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            E().post(new Runnable() { // from class: com.sobot.chat.core.a.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.f28172a.e(hVar);
                }
            });
        } else if (B().size() <= 0) {
        } else {
            ArrayList arrayList = (ArrayList) C().clone();
            int size = arrayList.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                ((d) arrayList.get(i2)).a(this, hVar);
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final j jVar) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            E().post(new Runnable() { // from class: com.sobot.chat.core.a.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.f28172a.e(jVar);
                }
            });
        } else if (D().size() <= 0) {
        } else {
            ArrayList arrayList = (ArrayList) D().clone();
            int size = arrayList.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                ((c) arrayList.get(i2)).c(this, jVar);
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final h hVar) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            E().post(new Runnable() { // from class: com.sobot.chat.core.a.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.f28172a.f(hVar);
                }
            });
        } else if (B().size() <= 0) {
        } else {
            ArrayList arrayList = (ArrayList) C().clone();
            int size = arrayList.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                ((d) arrayList.get(i2)).b(this, hVar);
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(final h hVar) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            E().post(new Runnable() { // from class: com.sobot.chat.core.a.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.f28172a.g(hVar);
                }
            });
        } else if (B().size() <= 0) {
        } else {
            ArrayList arrayList = (ArrayList) C().clone();
            int size = arrayList.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                ((d) arrayList.get(i2)).c(this, hVar);
                i = i2 + 1;
            }
        }
    }

    protected c A() {
        if (this.x == null) {
            this.x = new c();
        }
        return this.x;
    }

    protected ArrayList<b> B() {
        if (this.y == null) {
            this.y = new ArrayList<>();
        }
        return this.y;
    }

    protected ArrayList<d> C() {
        if (this.z == null) {
            this.z = new ArrayList<>();
        }
        return this.z;
    }

    protected ArrayList<c> D() {
        if (this.A == null) {
            this.A = new ArrayList<>();
        }
        return this.A;
    }

    protected f E() {
        if (this.B == null) {
            this.B = new f(this);
        }
        return this.B;
    }

    protected void F() {
        a(e.Connected);
        a(System.currentTimeMillis());
        b(System.currentTimeMillis());
        c(-1L);
        c((h) null);
        a((j) null);
        H();
    }

    public h a(final h hVar) {
        if (d() && hVar != null) {
            a().execute(new Runnable() { // from class: com.sobot.chat.core.a.a.11
                @Override // java.lang.Runnable
                public void run() {
                    a.this.f28172a.d(hVar);
                }
            });
            return hVar;
        }
        return null;
    }

    public h a(String str) {
        if (d()) {
            h hVar = new h(str);
            a(hVar);
            return hVar;
        }
        return null;
    }

    public h a(byte[] bArr) {
        if (d()) {
            h hVar = new h(bArr);
            a(hVar);
            return hVar;
        }
        return null;
    }

    public j a(final int i) {
        if (d() && n().c().k() == i.a.Manually && v() == null) {
            a(new j());
            a().execute(new Runnable() { // from class: com.sobot.chat.core.a.a.13
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.f28172a.d()) {
                        a.this.f28172a.c(a.this.f28172a.v());
                        try {
                            a.this.f28172a.v().b(a.this.f28172a.m().a(i));
                            if (a.this.f28172a.n().a() != null) {
                                a.this.f28172a.v().a(a.this.f28172a.n().a());
                            }
                            a.this.f28172a.d(a.this.f28172a.v());
                            a.this.f28172a.b(a.this.f28172a.v());
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            if (a.this.f28172a.v() != null) {
                                a.this.f28172a.e(a.this.f28172a.v());
                                a.this.f28172a.a((j) null);
                            }
                        }
                    }
                }
            });
            return v();
        }
        return null;
    }

    public j a(final byte[] bArr, final boolean z) {
        if (d() && n().c().k() == i.a.Manually && v() == null) {
            a(new j());
            a().execute(new Runnable() { // from class: com.sobot.chat.core.a.a.14
                @Override // java.lang.Runnable
                public void run() {
                    a.this.f28172a.c(a.this.f28172a.v());
                    try {
                        a.this.f28172a.v().b(a.this.f28172a.m().a(bArr, z));
                        if (a.this.f28172a.n().a() != null) {
                            a.this.f28172a.v().a(a.this.f28172a.n().a());
                        }
                        a.this.f28172a.d(a.this.f28172a.v());
                        a.this.f28172a.b(a.this.f28172a.v());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        if (a.this.f28172a.v() != null) {
                            a.this.f28172a.e(a.this.f28172a.v());
                            a.this.f28172a.a((j) null);
                        }
                    }
                }
            });
            return v();
        }
        return null;
    }

    protected a a(long j) {
        this.n = j;
        return this;
    }

    protected a a(C0768a c0768a) {
        this.u = c0768a;
        return this;
    }

    protected a a(b bVar) {
        this.v = bVar;
        return this;
    }

    protected a a(c cVar) {
        this.x = cVar;
        return this;
    }

    protected a a(d dVar) {
        this.w = dVar;
        return this;
    }

    protected a a(e eVar) {
        this.k = eVar;
        return this;
    }

    public a a(com.sobot.chat.core.a.a.a aVar) {
        this.d = aVar;
        return this;
    }

    public a a(b bVar) {
        if (!B().contains(bVar)) {
            B().add(bVar);
        }
        return this;
    }

    public a a(c cVar) {
        if (!D().contains(cVar)) {
            D().add(cVar);
        }
        return this;
    }

    public a a(d dVar) {
        if (!C().contains(dVar)) {
            C().add(dVar);
        }
        return this;
    }

    protected a a(e eVar) {
        this.j = eVar;
        return this;
    }

    public a a(f fVar) {
        this.g = fVar;
        return this;
    }

    protected a a(g gVar) {
        this.i = gVar;
        return this;
    }

    public a a(i iVar) {
        this.f = iVar;
        return this;
    }

    protected a a(j jVar) {
        this.s = jVar;
        return this;
    }

    protected a a(Socket socket) {
        this.h = socket;
        return this;
    }

    protected a a(boolean z) {
        this.l = z;
        return this;
    }

    public ExecutorService a() {
        if (this.f28173c == null) {
            synchronized (a.class) {
                try {
                    if (this.f28173c == null) {
                        this.f28173c = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), a("sobot SocketClient", false));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f28173c;
    }

    public ThreadFactory a(final String str, final boolean z) {
        return new ThreadFactory() { // from class: com.sobot.chat.core.a.a.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    public j b(byte[] bArr) {
        return a(bArr, true);
    }

    protected a b(long j) {
        this.o = j;
        return this;
    }

    public a b(b bVar) {
        B().remove(bVar);
        return this;
    }

    public a b(c cVar) {
        D().remove(cVar);
        return this;
    }

    public a b(d dVar) {
        C().remove(dVar);
        return this;
    }

    public a b(String str) {
        this.e = str;
        return this;
    }

    public void b() {
        synchronized (this) {
            if (e()) {
                if (h() == null) {
                    throw new IllegalArgumentException("we need a SocketClientAddress to connect");
                }
                h().b();
                j().b();
                n().a(i()).a(h()).a(k()).a(j());
                a(e.Connecting);
                x().start();
            }
        }
    }

    public void b(final h hVar) {
        a().execute(new Runnable() { // from class: com.sobot.chat.core.a.a.12
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.q()) {
                    if (a.this.f28172a.q().contains(hVar)) {
                        a.this.f28172a.q().remove(hVar);
                        a.this.f28172a.g(hVar);
                    }
                }
            }
        });
    }

    protected a c(long j) {
        this.q = j;
        return this;
    }

    protected a c(h hVar) {
        this.r = hVar;
        return this;
    }

    public void c() {
        if (e() || p()) {
            return;
        }
        a(true);
        y().start();
    }

    protected a d(long j) {
        this.t = j;
        return this;
    }

    public boolean d() {
        return o() == e.Connected;
    }

    public boolean e() {
        return o() == e.Disconnected;
    }

    public boolean f() {
        return o() == e.Connecting;
    }

    public com.sobot.chat.core.a.a.a g() {
        return n().b();
    }

    public com.sobot.chat.core.a.a.a h() {
        if (this.d == null) {
            this.d = new com.sobot.chat.core.a.a.a();
        }
        return this.d;
    }

    public String i() {
        return this.e;
    }

    public i j() {
        if (this.f == null) {
            this.f = new i();
        }
        return this.f;
    }

    public f k() {
        if (this.g == null) {
            this.g = new f();
        }
        return this.g;
    }

    public Socket l() {
        if (this.h == null) {
            this.h = new Socket();
        }
        return this.h;
    }

    protected g m() throws IOException {
        if (this.i == null) {
            this.i = new g(l().getInputStream());
        }
        return this.i;
    }

    protected e n() {
        if (this.j == null) {
            this.j = new e();
        }
        return this.j;
    }

    public e o() {
        e eVar = this.k;
        e eVar2 = eVar;
        if (eVar == null) {
            eVar2 = e.Disconnected;
        }
        return eVar2;
    }

    public boolean p() {
        return this.l;
    }

    protected LinkedBlockingQueue<h> q() {
        if (this.m == null) {
            this.m = new LinkedBlockingQueue<>();
        }
        return this.m;
    }

    protected long r() {
        return this.n;
    }

    protected long s() {
        return this.o;
    }

    protected long t() {
        return this.q;
    }

    protected h u() {
        return this.r;
    }

    protected j v() {
        return this.s;
    }

    protected long w() {
        return this.t;
    }

    protected C0768a x() {
        if (this.u == null) {
            this.u = new C0768a();
        }
        return this.u;
    }

    protected b y() {
        if (this.v == null) {
            this.v = new b();
        }
        return this.v;
    }

    protected d z() {
        if (this.w == null) {
            this.w = new d();
        }
        return this.w;
    }
}
