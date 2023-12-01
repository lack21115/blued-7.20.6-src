package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* renamed from: com.amap.api.col.3sl.as  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/as.class */
public final class as extends am {
    private static final PointF p = new PointF();
    private final a n;
    private boolean o;
    private PointF q;
    private PointF r;
    private PointF s;
    private PointF t;

    /* renamed from: com.amap.api.col.3sl.as$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/as$a.class */
    public interface a {
        void a(as asVar);
    }

    /* renamed from: com.amap.api.col.3sl.as$b */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/as$b.class */
    public static class b implements a {
        @Override // com.amap.api.col.p0003sl.as.a
        public void a(as asVar) {
        }
    }

    public as(Context context, a aVar) {
        super(context);
        this.s = new PointF();
        this.t = new PointF();
        this.n = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0003sl.an
    public final void a() {
        super.a();
        this.o = false;
        this.s.x = 0.0f;
        this.t.x = 0.0f;
        this.s.y = 0.0f;
        this.t.y = 0.0f;
    }

    @Override // com.amap.api.col.p0003sl.an
    protected final void a(int i, MotionEvent motionEvent) {
        if (i == 3) {
            a();
        } else if (i != 6) {
        } else {
            a(motionEvent);
            if (!this.o) {
                this.n.a(this);
            }
            a();
        }
    }

    @Override // com.amap.api.col.p0003sl.an
    protected final void a(int i, MotionEvent motionEvent, int i2, int i3) {
        if (i != 5) {
            return;
        }
        a();
        this.g = MotionEvent.obtain(motionEvent);
        this.k = 0L;
        a(motionEvent);
        boolean a2 = a(motionEvent, i2, i3);
        this.o = a2;
        if (a2) {
            return;
        }
        this.f = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0003sl.am, com.amap.api.col.p0003sl.an
    public final void a(MotionEvent motionEvent) {
        super.a(motionEvent);
        MotionEvent motionEvent2 = this.g;
        this.q = b(motionEvent);
        this.r = b(motionEvent2);
        this.t = this.g.getPointerCount() != motionEvent.getPointerCount() ? p : new PointF(this.q.x - this.r.x, this.q.y - this.r.y);
        this.s.x += this.t.x;
        this.s.y += this.t.y;
    }

    public final float d() {
        return this.s.x;
    }

    public final float e() {
        return this.s.y;
    }
}
