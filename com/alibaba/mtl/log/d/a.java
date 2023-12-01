package com.alibaba.mtl.log.d;

import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.r;
import com.anythink.expressad.video.module.a.a.m;
import java.util.Random;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/d/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    static a f4488a = new a();
    private int A;
    protected long z = com.alibaba.mtl.log.a.a.a();
    private boolean E = false;

    public static a a() {
        return f4488a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long c() {
        long a2;
        int i;
        i.a("UploadEngine", "UTDC.bBackground:", Boolean.valueOf(com.alibaba.mtl.log.a.o), "AppInfoUtil.isForeground(UTDC.getContext()) ", Boolean.valueOf(com.alibaba.mtl.log.e.b.b(com.alibaba.mtl.log.a.getContext())));
        com.alibaba.mtl.log.a.o = !com.alibaba.mtl.log.e.b.b(com.alibaba.mtl.log.a.getContext());
        boolean z = com.alibaba.mtl.log.a.o;
        com.alibaba.mtl.log.a.a.a();
        if (z) {
            a2 = com.alibaba.mtl.log.a.a.b();
            i = this.A;
        } else {
            a2 = com.alibaba.mtl.log.a.a.a();
            i = this.A;
        }
        this.z = a2 + i;
        if (com.alibaba.mtl.log.a.a.g()) {
            this.z = m.ag;
        }
        return this.z;
    }

    public void J() {
        if (this.A == 0) {
            this.A = 7000;
        } else {
            this.A = 0;
        }
    }

    public void start() {
        synchronized (this) {
            this.E = true;
            if (r.a().b(2)) {
                r.a().f(2);
            }
            c();
            Random random = new Random();
            if (!b.isRunning()) {
                r.a().a(2, new b() { // from class: com.alibaba.mtl.log.d.a.1
                    @Override // com.alibaba.mtl.log.d.b
                    public void K() {
                        if (a.this.E) {
                            com.alibaba.mtl.log.b.a.E();
                            a.this.c();
                            i.a("UploadTask", "mPeriod:", Long.valueOf(a.this.z));
                            if (r.a().b(2)) {
                                r.a().f(2);
                            }
                            if (b.isRunning()) {
                                return;
                            }
                            r.a().a(2, this, a.this.z);
                        }
                    }

                    @Override // com.alibaba.mtl.log.d.b
                    public void L() {
                        a.this.J();
                    }
                }, random.nextInt((int) this.z));
            }
        }
    }

    public void stop() {
        synchronized (this) {
            this.E = false;
            r.a().f(2);
        }
    }
}
