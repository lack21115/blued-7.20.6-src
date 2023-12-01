package com.github.mikephil.charting.jobs;

import android.view.View;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/jobs/MoveViewJob.class */
public class MoveViewJob extends ViewPortJob {

    /* renamed from: a  reason: collision with root package name */
    private static ObjectPool<MoveViewJob> f22156a;

    static {
        ObjectPool<MoveViewJob> a2 = ObjectPool.a(2, new MoveViewJob(null, 0.0f, 0.0f, null, null));
        f22156a = a2;
        a2.a(0.5f);
    }

    public MoveViewJob(ViewPortHandler viewPortHandler, float f, float f2, Transformer transformer, View view) {
        super(viewPortHandler, f, f2, transformer, view);
    }

    public static void a(MoveViewJob moveViewJob) {
        f22156a.a((ObjectPool<MoveViewJob>) moveViewJob);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    public ObjectPool.Poolable b() {
        return new MoveViewJob(this.m, this.n, this.o, this.p, this.q);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.l[0] = this.n;
        this.l[1] = this.o;
        this.p.a(this.l);
        this.m.a(this.l, this.q);
        a(this);
    }
}
