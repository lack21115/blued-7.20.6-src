package com.github.mikephil.charting.jobs;

import android.graphics.Matrix;
import android.view.View;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/jobs/ZoomJob.class */
public class ZoomJob extends ViewPortJob {
    private static ObjectPool<ZoomJob> e;

    /* renamed from: a  reason: collision with root package name */
    protected float f8550a;
    protected float b;

    /* renamed from: c  reason: collision with root package name */
    protected YAxis.AxisDependency f8551c;
    protected Matrix d;

    static {
        ObjectPool<ZoomJob> a2 = ObjectPool.a(1, new ZoomJob(null, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null));
        e = a2;
        a2.a(0.5f);
    }

    public ZoomJob(ViewPortHandler viewPortHandler, float f, float f2, float f3, float f4, Transformer transformer, YAxis.AxisDependency axisDependency, View view) {
        super(viewPortHandler, f3, f4, transformer, view);
        this.d = new Matrix();
        this.f8550a = f;
        this.b = f2;
        this.f8551c = axisDependency;
    }

    public static void a(ZoomJob zoomJob) {
        e.a((ObjectPool<ZoomJob>) zoomJob);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    public ObjectPool.Poolable b() {
        return new ZoomJob(null, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null);
    }

    @Override // java.lang.Runnable
    public void run() {
        Matrix matrix = this.d;
        this.m.a(this.f8550a, this.b, matrix);
        this.m.a(matrix, this.q, false);
        float r = ((BarLineChartBase) this.q).b(this.f8551c).v / this.m.r();
        this.l[0] = this.n - ((((BarLineChartBase) this.q).getXAxis().v / this.m.q()) / 2.0f);
        this.l[1] = this.o + (r / 2.0f);
        this.p.a(this.l);
        this.m.a(this.l, matrix);
        this.m.a(matrix, this.q, false);
        ((BarLineChartBase) this.q).j();
        this.q.postInvalidate();
        a(this);
    }
}
