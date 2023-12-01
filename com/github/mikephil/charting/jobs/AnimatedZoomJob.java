package com.github.mikephil.charting.jobs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.view.View;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/jobs/AnimatedZoomJob.class */
public class AnimatedZoomJob extends AnimatedViewPortJob implements Animator.AnimatorListener {
    private static ObjectPool<AnimatedZoomJob> t = ObjectPool.a(8, new AnimatedZoomJob(null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0));
    protected float e;
    protected float f;
    protected float g;
    protected float h;
    protected YAxis i;
    protected float j;
    protected Matrix k;

    public AnimatedZoomJob(ViewPortHandler viewPortHandler, View view, Transformer transformer, YAxis yAxis, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, long j) {
        super(viewPortHandler, f2, f3, transformer, view, f4, f5, j);
        this.k = new Matrix();
        this.g = f6;
        this.h = f7;
        this.e = f8;
        this.f = f9;
        this.f8547a.addListener(this);
        this.i = yAxis;
        this.j = f;
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob
    public void a() {
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    public ObjectPool.Poolable b() {
        return new AnimatedZoomJob(null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L);
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        ((BarLineChartBase) this.q).j();
        this.q.postInvalidate();
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float f = this.f8548c;
        float f2 = this.n;
        float f3 = this.f8548c;
        float f4 = this.b;
        float f5 = this.d;
        float f6 = this.o;
        float f7 = this.d;
        float f8 = this.b;
        Matrix matrix = this.k;
        this.m.b(f + ((f2 - f3) * f4), f5 + ((f6 - f7) * f8), matrix);
        this.m.a(matrix, this.q, false);
        float r = this.i.v / this.m.r();
        float q = this.j / this.m.q();
        float[] fArr = this.l;
        float f9 = this.e;
        fArr[0] = f9 + (((this.g - (q / 2.0f)) - f9) * this.b);
        float[] fArr2 = this.l;
        float f10 = this.f;
        fArr2[1] = f10 + (((this.h + (r / 2.0f)) - f10) * this.b);
        this.p.a(this.l);
        this.m.a(this.l, matrix);
        this.m.a(matrix, this.q, true);
    }
}
