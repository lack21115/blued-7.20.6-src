package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* renamed from: com.amap.api.col.3sl.ao  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ao.class */
public final class ao extends am {
    private static final PointF n = new PointF();
    private final a o;
    private boolean p;
    private PointF q;
    private PointF r;
    private PointF s;
    private PointF t;

    /* renamed from: com.amap.api.col.3sl.ao$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ao$a.class */
    public interface a {
        boolean a(ao aoVar);

        boolean b(ao aoVar);

        void c(ao aoVar);
    }

    public ao(Context context, a aVar) {
        super(context);
        this.s = new PointF();
        this.t = new PointF();
        this.o = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0003sl.an
    public final void a() {
        super.a();
        this.p = false;
    }

    @Override // com.amap.api.col.p0003sl.an
    protected final void a(int i, MotionEvent motionEvent) {
        if (i == 2) {
            a(motionEvent);
            if (this.i / this.j <= 0.67f || !this.o.a(this)) {
                return;
            }
            this.g.recycle();
            this.g = MotionEvent.obtain(motionEvent);
        } else if (i == 3) {
            if (!this.p) {
                this.o.c(this);
            }
            a();
        } else if (i != 6) {
        } else {
            a(motionEvent);
            if (!this.p) {
                this.o.c(this);
            }
            a();
        }
    }

    @Override // com.amap.api.col.p0003sl.an
    protected final void a(int i, MotionEvent motionEvent, int i2, int i3) {
        if (i == 2) {
            if (this.p) {
                boolean a2 = a(motionEvent, i2, i3);
                this.p = a2;
                if (a2) {
                    return;
                }
                this.f = this.o.b(this);
            }
        } else if (i != 5) {
        } else {
            a();
            this.g = MotionEvent.obtain(motionEvent);
            this.k = 0L;
            a(motionEvent);
            boolean a3 = a(motionEvent, i2, i3);
            this.p = a3;
            if (a3) {
                return;
            }
            this.f = this.o.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0003sl.am, com.amap.api.col.p0003sl.an
    public final void a(MotionEvent motionEvent) {
        super.a(motionEvent);
        MotionEvent motionEvent2 = this.g;
        this.q = b(motionEvent);
        this.r = b(motionEvent2);
        this.t = this.g.getPointerCount() != motionEvent.getPointerCount() ? n : new PointF(this.q.x - this.r.x, this.q.y - this.r.y);
        this.s.x += this.t.x;
        this.s.y += this.t.y;
    }

    public final PointF d() {
        return this.t;
    }
}
