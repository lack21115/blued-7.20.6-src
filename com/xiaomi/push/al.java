package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/al.class */
public class al {

    /* renamed from: a  reason: collision with root package name */
    private int f27560a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f131a;

    /* renamed from: a  reason: collision with other field name */
    private a f132a;

    /* renamed from: a  reason: collision with other field name */
    private volatile b f133a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f134a;
    private final boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/al$a.class */
    public class a extends Thread {

        /* renamed from: a  reason: collision with other field name */
        private final LinkedBlockingQueue<b> f135a;

        public a() {
            super("PackageProcessor");
            this.f135a = new LinkedBlockingQueue<>();
        }

        private void a(int i, b bVar) {
            try {
                al.this.f131a.sendMessage(al.this.f131a.obtainMessage(i, bVar));
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }

        public void a(b bVar) {
            try {
                this.f135a.add(bVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j = al.this.f27560a > 0 ? al.this.f27560a : Long.MAX_VALUE;
            while (!al.this.f134a) {
                try {
                    b poll = this.f135a.poll(j, TimeUnit.SECONDS);
                    al.this.f133a = poll;
                    if (poll != null) {
                        a(0, poll);
                        poll.b();
                        a(1, poll);
                    } else if (al.this.f27560a > 0) {
                        al.this.a();
                    }
                } catch (InterruptedException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/al$b.class */
    public static abstract class b {
        public void a() {
        }

        public abstract void b();

        /* renamed from: c */
        public void mo8568c() {
        }
    }

    public al() {
        this(false);
    }

    public al(boolean z) {
        this(z, 0);
    }

    public al(boolean z, int i) {
        this.f131a = null;
        this.f134a = false;
        this.f27560a = 0;
        this.f131a = new am(this, Looper.getMainLooper());
        this.b = z;
        this.f27560a = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        synchronized (this) {
            this.f132a = null;
            this.f134a = true;
        }
    }

    public void a(b bVar) {
        synchronized (this) {
            if (this.f132a == null) {
                a aVar = new a();
                this.f132a = aVar;
                aVar.setDaemon(this.b);
                this.f134a = false;
                this.f132a.start();
            }
            this.f132a.a(bVar);
        }
    }

    public void a(b bVar, long j) {
        this.f131a.postDelayed(new an(this, bVar), j);
    }
}
