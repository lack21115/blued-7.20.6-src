package com.opos.exoplayer.core.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.opos.exoplayer.core.Format;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/k.class */
public final class k extends com.opos.exoplayer.core.a implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f25412a;
    private final j b;

    /* renamed from: c  reason: collision with root package name */
    private final g f25413c;
    private final com.opos.exoplayer.core.l d;
    private boolean e;
    private boolean f;
    private int g;
    private Format h;
    private e i;
    private h j;
    private i k;
    private i l;
    private int m;

    public k(j jVar, Looper looper) {
        this(jVar, looper, g.f25387a);
    }

    public k(j jVar, Looper looper, g gVar) {
        super(3);
        this.b = (j) com.opos.exoplayer.core.i.a.a(jVar);
        this.f25412a = looper == null ? null : new Handler(looper, this);
        this.f25413c = gVar;
        this.d = new com.opos.exoplayer.core.l();
    }

    private void a(List<b> list) {
        Handler handler = this.f25412a;
        if (handler != null) {
            handler.obtainMessage(0, list).sendToTarget();
        } else {
            b(list);
        }
    }

    private void b(List<b> list) {
        this.b.a(list);
    }

    private void v() {
        this.j = null;
        this.m = -1;
        i iVar = this.k;
        if (iVar != null) {
            iVar.e();
            this.k = null;
        }
        i iVar2 = this.l;
        if (iVar2 != null) {
            iVar2.e();
            this.l = null;
        }
    }

    private void w() {
        v();
        this.i.d();
        this.i = null;
        this.g = 0;
    }

    private void x() {
        w();
        this.i = this.f25413c.b(this.h);
    }

    private long y() {
        int i = this.m;
        if (i == -1 || i >= this.k.b()) {
            return Long.MAX_VALUE;
        }
        return this.k.a(this.m);
    }

    private void z() {
        a(Collections.emptyList());
    }

    @Override // com.opos.exoplayer.core.t
    public int a(Format format) {
        return this.f25413c.a(format) ? a((com.opos.exoplayer.core.drm.b<?>) null, format.i) ? 4 : 2 : com.opos.exoplayer.core.i.j.c(format.f) ? 1 : 0;
    }

    @Override // com.opos.exoplayer.core.s
    public void a(long j, long j2) {
        boolean z;
        if (this.f) {
            return;
        }
        if (this.l == null) {
            this.i.a(j);
            try {
                this.l = this.i.b();
            } catch (f e) {
                throw com.opos.exoplayer.core.h.a(e, r());
            }
        }
        if (a_() == 2) {
            if (this.k != null) {
                long y = y();
                boolean z2 = false;
                while (true) {
                    z = z2;
                    if (y > j) {
                        break;
                    }
                    this.m++;
                    y = y();
                    z2 = true;
                }
            } else {
                z = false;
            }
            i iVar = this.l;
            boolean z3 = z;
            if (iVar != null) {
                if (iVar.c()) {
                    z3 = z;
                    if (!z) {
                        z3 = z;
                        if (y() == Long.MAX_VALUE) {
                            if (this.g == 2) {
                                x();
                                z3 = z;
                            } else {
                                v();
                                this.f = true;
                                z3 = z;
                            }
                        }
                    }
                } else {
                    z3 = z;
                    if (this.l.f25075a <= j) {
                        i iVar2 = this.k;
                        if (iVar2 != null) {
                            iVar2.e();
                        }
                        i iVar3 = this.l;
                        this.k = iVar3;
                        this.l = null;
                        this.m = iVar3.a(j);
                        z3 = true;
                    }
                }
            }
            if (z3) {
                a(this.k.b(j));
            }
            if (this.g != 2) {
                while (!this.e) {
                    try {
                        if (this.j == null) {
                            h a2 = this.i.a();
                            this.j = a2;
                            if (a2 == null) {
                                return;
                            }
                        }
                        if (this.g == 1) {
                            this.j.a_(4);
                            this.i.a((e) this.j);
                            this.j = null;
                            this.g = 2;
                            return;
                        }
                        int a3 = a(this.d, (com.opos.exoplayer.core.b.e) this.j, false);
                        if (a3 == -4) {
                            if (this.j.c()) {
                                this.e = true;
                            } else {
                                this.j.d = this.d.f25515a.w;
                                this.j.h();
                            }
                            this.i.a((e) this.j);
                            this.j = null;
                        } else if (a3 == -3) {
                            return;
                        }
                    } catch (f e2) {
                        throw com.opos.exoplayer.core.h.a(e2, r());
                    }
                }
            }
        }
    }

    @Override // com.opos.exoplayer.core.a
    public void a(long j, boolean z) {
        z();
        this.e = false;
        this.f = false;
        if (this.g != 0) {
            x();
            return;
        }
        v();
        this.i.c();
    }

    @Override // com.opos.exoplayer.core.a
    public void a(Format[] formatArr, long j) {
        Format format = formatArr[0];
        this.h = format;
        if (this.i != null) {
            this.g = 1;
        } else {
            this.i = this.f25413c.b(format);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            b((List) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    @Override // com.opos.exoplayer.core.a
    public void p() {
        this.h = null;
        z();
        w();
    }

    @Override // com.opos.exoplayer.core.s
    public boolean t() {
        return true;
    }

    @Override // com.opos.exoplayer.core.s
    public boolean u() {
        return this.f;
    }
}
