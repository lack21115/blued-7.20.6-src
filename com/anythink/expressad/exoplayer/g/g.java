package com.anythink.expressad.exoplayer.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.anythink.expressad.exoplayer.m;
import com.anythink.expressad.exoplayer.n;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/g/g.class */
public final class g extends com.anythink.expressad.exoplayer.a implements Handler.Callback {
    private static final int n = 0;
    private static final int o = 5;
    private final d p;
    private final f q;
    private final Handler r;
    private final n s;
    private final e t;
    private final com.anythink.expressad.exoplayer.g.a[] u;
    private final long[] v;
    private int w;
    private int x;
    private b y;
    private boolean z;

    @Deprecated
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/g/g$a.class */
    public interface a extends f {
    }

    public g(f fVar, Looper looper) {
        this(fVar, looper, d.f4538a);
    }

    private g(f fVar, Looper looper, d dVar) {
        super(4);
        this.q = (f) com.anythink.expressad.exoplayer.k.a.a(fVar);
        this.r = looper == null ? null : new Handler(looper, this);
        this.p = (d) com.anythink.expressad.exoplayer.k.a.a(dVar);
        this.s = new n();
        this.t = new e();
        this.u = new com.anythink.expressad.exoplayer.g.a[5];
        this.v = new long[5];
    }

    private void a(com.anythink.expressad.exoplayer.g.a aVar) {
        Handler handler = this.r;
        if (handler != null) {
            handler.obtainMessage(0, aVar).sendToTarget();
        } else {
            b(aVar);
        }
    }

    private void b(com.anythink.expressad.exoplayer.g.a aVar) {
        this.q.a(aVar);
    }

    private void w() {
        Arrays.fill(this.u, (Object) null);
        this.w = 0;
        this.x = 0;
    }

    @Override // com.anythink.expressad.exoplayer.z
    public final int a(m mVar) {
        if (this.p.a(mVar)) {
            return a((com.anythink.expressad.exoplayer.d.g<?>) null, mVar.k) ? 4 : 2;
        }
        return 0;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final void a(long j, long j2) {
        if (!this.z && this.x < 5) {
            this.t.a();
            if (a(this.s, (com.anythink.expressad.exoplayer.c.e) this.t, false) == -4) {
                if (this.t.c()) {
                    this.z = true;
                } else if (!this.t.b()) {
                    this.t.g = this.s.f4882a.l;
                    this.t.h();
                    try {
                        int i = (this.w + this.x) % 5;
                        this.u[i] = this.y.a(this.t);
                        this.v[i] = this.t.f;
                        this.x++;
                    } catch (c e) {
                        throw com.anythink.expressad.exoplayer.g.a(e, s());
                    }
                }
            }
        }
        if (this.x > 0) {
            long[] jArr = this.v;
            int i2 = this.w;
            if (jArr[i2] <= j) {
                com.anythink.expressad.exoplayer.g.a aVar = this.u[i2];
                Handler handler = this.r;
                if (handler != null) {
                    handler.obtainMessage(0, aVar).sendToTarget();
                } else {
                    b(aVar);
                }
                com.anythink.expressad.exoplayer.g.a[] aVarArr = this.u;
                int i3 = this.w;
                aVarArr[i3] = null;
                this.w = (i3 + 1) % 5;
                this.x--;
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.a
    public final void a(long j, boolean z) {
        w();
        this.z = false;
    }

    @Override // com.anythink.expressad.exoplayer.a
    public final void a(m[] mVarArr, long j) {
        this.y = this.p.b(mVarArr[0]);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what == 0) {
            b((com.anythink.expressad.exoplayer.g.a) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    @Override // com.anythink.expressad.exoplayer.a
    public final void p() {
        w();
        this.y = null;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final boolean u() {
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final boolean v() {
        return this.z;
    }
}
