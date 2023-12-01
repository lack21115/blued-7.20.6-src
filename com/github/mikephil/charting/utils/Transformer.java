package com.github.mikephil.charting.utils;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/utils/Transformer.class */
public class Transformer {

    /* renamed from: c  reason: collision with root package name */
    protected ViewPortHandler f8601c;

    /* renamed from: a  reason: collision with root package name */
    protected Matrix f8600a = new Matrix();
    protected Matrix b = new Matrix();
    protected float[] d = new float[1];
    protected float[] e = new float[1];
    protected float[] f = new float[1];
    protected float[] g = new float[1];
    protected Matrix h = new Matrix();
    float[] i = new float[2];
    private Matrix j = new Matrix();
    private Matrix k = new Matrix();

    public Transformer(ViewPortHandler viewPortHandler) {
        this.f8601c = viewPortHandler;
    }

    public Matrix a() {
        this.j.set(this.f8600a);
        this.j.postConcat(this.f8601c.f8604a);
        this.j.postConcat(this.b);
        return this.j;
    }

    public MPPointD a(float f, float f2) {
        MPPointD a2 = MPPointD.a(0.0d, 0.0d);
        a(f, f2, a2);
        return a2;
    }

    public void a(float f, float f2, float f3, float f4) {
        float i = this.f8601c.i() / f2;
        float j = this.f8601c.j() / f3;
        float f5 = i;
        if (Float.isInfinite(i)) {
            f5 = 0.0f;
        }
        float f6 = j;
        if (Float.isInfinite(j)) {
            f6 = 0.0f;
        }
        this.f8600a.reset();
        this.f8600a.postTranslate(-f, -f4);
        this.f8600a.postScale(f5, -f6);
    }

    public void a(float f, float f2, MPPointD mPPointD) {
        float[] fArr = this.i;
        fArr[0] = f;
        fArr[1] = f2;
        b(fArr);
        mPPointD.f8595a = this.i[0];
        mPPointD.b = this.i[1];
    }

    public void a(Path path) {
        path.transform(this.f8600a);
        path.transform(this.f8601c.p());
        path.transform(this.b);
    }

    public void a(RectF rectF) {
        this.f8600a.mapRect(rectF);
        this.f8601c.p().mapRect(rectF);
        this.b.mapRect(rectF);
    }

    public void a(RectF rectF, float f) {
        rectF.top *= f;
        rectF.bottom *= f;
        this.f8600a.mapRect(rectF);
        this.f8601c.p().mapRect(rectF);
        this.b.mapRect(rectF);
    }

    public void a(boolean z) {
        this.b.reset();
        if (!z) {
            this.b.postTranslate(this.f8601c.a(), this.f8601c.m() - this.f8601c.d());
            return;
        }
        this.b.setTranslate(this.f8601c.a(), -this.f8601c.c());
        this.b.postScale(1.0f, -1.0f);
    }

    public void a(float[] fArr) {
        this.f8600a.mapPoints(fArr);
        this.f8601c.p().mapPoints(fArr);
        this.b.mapPoints(fArr);
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [com.github.mikephil.charting.data.Entry] */
    public float[] a(IBubbleDataSet iBubbleDataSet, float f, int i, int i2) {
        int i3 = ((i2 - i) + 1) * 2;
        if (this.e.length != i3) {
            this.e = new float[i3];
        }
        float[] fArr = this.e;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= i3) {
                a().mapPoints(fArr);
                return fArr;
            }
            ?? e = iBubbleDataSet.e((i5 / 2) + i);
            if (e != 0) {
                fArr[i5] = e.i();
                fArr[i5 + 1] = e.b() * f;
            } else {
                fArr[i5] = 0.0f;
                fArr[i5 + 1] = 0.0f;
            }
            i4 = i5 + 2;
        }
    }

    public float[] a(ICandleDataSet iCandleDataSet, float f, float f2, int i, int i2) {
        int i3 = ((int) (((i2 - i) * f) + 1.0f)) * 2;
        if (this.g.length != i3) {
            this.g = new float[i3];
        }
        float[] fArr = this.g;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= i3) {
                a().mapPoints(fArr);
                return fArr;
            }
            CandleEntry candleEntry = (CandleEntry) iCandleDataSet.e((i5 / 2) + i);
            if (candleEntry != null) {
                fArr[i5] = candleEntry.i();
                fArr[i5 + 1] = candleEntry.a() * f2;
            } else {
                fArr[i5] = 0.0f;
                fArr[i5 + 1] = 0.0f;
            }
            i4 = i5 + 2;
        }
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [com.github.mikephil.charting.data.Entry] */
    public float[] a(ILineDataSet iLineDataSet, float f, float f2, int i, int i2) {
        int i3 = (((int) ((i2 - i) * f)) + 1) * 2;
        if (this.f.length != i3) {
            this.f = new float[i3];
        }
        float[] fArr = this.f;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= i3) {
                a().mapPoints(fArr);
                return fArr;
            }
            ?? e = iLineDataSet.e((i5 / 2) + i);
            if (e != 0) {
                fArr[i5] = e.i();
                fArr[i5 + 1] = e.b() * f2;
            } else {
                fArr[i5] = 0.0f;
                fArr[i5 + 1] = 0.0f;
            }
            i4 = i5 + 2;
        }
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [com.github.mikephil.charting.data.Entry] */
    public float[] a(IScatterDataSet iScatterDataSet, float f, float f2, int i, int i2) {
        int i3 = ((int) (((i2 - i) * f) + 1.0f)) * 2;
        if (this.d.length != i3) {
            this.d = new float[i3];
        }
        float[] fArr = this.d;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= i3) {
                a().mapPoints(fArr);
                return fArr;
            }
            ?? e = iScatterDataSet.e((i5 / 2) + i);
            if (e != 0) {
                fArr[i5] = e.i();
                fArr[i5 + 1] = e.b() * f2;
            } else {
                fArr[i5] = 0.0f;
                fArr[i5 + 1] = 0.0f;
            }
            i4 = i5 + 2;
        }
    }

    public MPPointD b(float f, float f2) {
        float[] fArr = this.i;
        fArr[0] = f;
        fArr[1] = f2;
        a(fArr);
        float[] fArr2 = this.i;
        return MPPointD.a(fArr2[0], fArr2[1]);
    }

    public void b(RectF rectF, float f) {
        rectF.left *= f;
        rectF.right *= f;
        this.f8600a.mapRect(rectF);
        this.f8601c.p().mapRect(rectF);
        this.b.mapRect(rectF);
    }

    public void b(float[] fArr) {
        Matrix matrix = this.h;
        matrix.reset();
        this.b.invert(matrix);
        matrix.mapPoints(fArr);
        this.f8601c.p().invert(matrix);
        matrix.mapPoints(fArr);
        this.f8600a.invert(matrix);
        matrix.mapPoints(fArr);
    }
}
