package com.opos.exoplayer.core.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.h;
import com.opos.exoplayer.core.l;
import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/metadata/f.class */
public final class f extends com.opos.exoplayer.core.a implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    private final c f25522a;
    private final e b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f25523c;
    private final l d;
    private final d e;
    private final Metadata[] f;
    private final long[] g;
    private int h;
    private int i;
    private a j;
    private boolean k;

    public f(e eVar, Looper looper) {
        this(eVar, looper, c.f25519a);
    }

    public f(e eVar, Looper looper, c cVar) {
        super(4);
        this.b = (e) com.opos.exoplayer.core.i.a.a(eVar);
        this.f25523c = looper == null ? null : new Handler(looper, this);
        this.f25522a = (c) com.opos.exoplayer.core.i.a.a(cVar);
        this.d = new l();
        this.e = new d();
        this.f = new Metadata[5];
        this.g = new long[5];
    }

    private void a(Metadata metadata) {
        Handler handler = this.f25523c;
        if (handler != null) {
            handler.obtainMessage(0, metadata).sendToTarget();
        } else {
            b(metadata);
        }
    }

    private void b(Metadata metadata) {
        this.b.a(metadata);
    }

    private void v() {
        Arrays.fill(this.f, (Object) null);
        this.h = 0;
        this.i = 0;
    }

    @Override // com.opos.exoplayer.core.t
    public int a(Format format) {
        if (this.f25522a.a(format)) {
            return a((com.opos.exoplayer.core.drm.b<?>) null, format.i) ? 4 : 2;
        }
        return 0;
    }

    @Override // com.opos.exoplayer.core.s
    public void a(long j, long j2) {
        if (!this.k && this.i < 5) {
            this.e.a();
            if (a(this.d, (com.opos.exoplayer.core.b.e) this.e, false) == -4) {
                if (this.e.c()) {
                    this.k = true;
                } else if (!this.e.d_()) {
                    this.e.d = this.d.f25515a.w;
                    this.e.h();
                    try {
                        int i = (this.h + this.i) % 5;
                        this.f[i] = this.j.a(this.e);
                        this.g[i] = this.e.f25074c;
                        this.i++;
                    } catch (b e) {
                        throw h.a(e, r());
                    }
                }
            }
        }
        if (this.i > 0) {
            long[] jArr = this.g;
            int i2 = this.h;
            if (jArr[i2] <= j) {
                a(this.f[i2]);
                Metadata[] metadataArr = this.f;
                int i3 = this.h;
                metadataArr[i3] = null;
                this.h = (i3 + 1) % 5;
                this.i--;
            }
        }
    }

    @Override // com.opos.exoplayer.core.a
    public void a(long j, boolean z) {
        v();
        this.k = false;
    }

    @Override // com.opos.exoplayer.core.a
    public void a(Format[] formatArr, long j) {
        this.j = this.f25522a.b(formatArr[0]);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            b((Metadata) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    @Override // com.opos.exoplayer.core.a
    public void p() {
        v();
        this.j = null;
    }

    @Override // com.opos.exoplayer.core.s
    public boolean t() {
        return true;
    }

    @Override // com.opos.exoplayer.core.s
    public boolean u() {
        return this.k;
    }
}
