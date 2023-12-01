package com.huawei.openalliance.ad.views;

import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/h.class */
public class h extends g {
    private float D;
    private float L;

    /* renamed from: a  reason: collision with root package name */
    private Path f9438a;
    private RectF b;

    /* renamed from: c  reason: collision with root package name */
    private RectF f9439c;
    private Rect d;
    private float e;

    public h(Drawable drawable, int i, int i2) {
        super(drawable, i, i2);
        this.f9438a = new Path();
        this.b = new RectF();
        this.f9439c = new RectF();
        I();
    }

    private void B(float f) {
        this.f9438a.reset();
        this.f9438a.addArc(this.b, 90.0f, 180.0f);
        float f2 = this.d.right - this.e;
        if (Float.compare(Code(), V()) != 0) {
            this.f9438a.addRect(this.e + this.d.left, this.d.top, f2, this.d.bottom, Path.Direction.CCW);
        }
        float f3 = 0.0f;
        if (Float.compare(Code(), 0.0f) != 0) {
            f3 = ((f - V()) / Code()) * this.e;
        }
        this.f9439c.set(f2 - f3, this.d.top, f2 + f3, this.d.bottom);
        this.f9438a.addArc(this.f9439c, 270.0f, 180.0f);
    }

    private float C(float f) {
        return f / 2.0f;
    }

    private void Code(float f) {
        this.D = f;
    }

    private void I() {
        Rect bounds = getBounds();
        this.d = bounds;
        Code(bounds.left, this.d.top, this.d.left + this.d.height(), this.d.bottom);
        this.e = C(this.d.height());
    }

    private void I(float f) {
        this.f9438a.reset();
        this.f9438a.addArc(this.b, 90.0f, 180.0f);
        float f2 = 0.0f;
        if (Float.compare(Code(), 0.0f) != 0) {
            f2 = (f / Code()) * this.e;
        }
        this.f9439c.set(this.d.left + f2, this.d.top, (this.d.left + this.d.height()) - f2, this.d.bottom);
        this.f9438a.addArc(this.f9439c, 270.0f, -180.0f);
    }

    private void V(float f) {
        this.L = f;
    }

    private void Z(float f) {
        this.f9438a.reset();
        this.f9438a.addArc(this.b, 90.0f, 180.0f);
        this.f9438a.addRect(this.d.left + this.e, this.d.top, (this.d.width() * f) + this.d.left, this.d.bottom, Path.Direction.CCW);
    }

    protected float Code() {
        return this.D;
    }

    void Code(float f, float f2, float f3, float f4) {
        this.b.set(f, f2, f3, f4);
    }

    void Code(int i, int i2, int i3, int i4) {
        this.d.set(i, i2, i3, i4);
        int i5 = i4 - i2;
        Code(i, i2, i + i5, i4);
        this.e = C(i5);
    }

    protected float V() {
        return this.L;
    }

    @Override // com.huawei.openalliance.ad.views.g
    protected Path V(int i) {
        float f = i / 10000.0f;
        if (Float.compare(f, Code()) < 0) {
            I(f);
        } else if (Float.compare(f, V()) < 0) {
            Z(f);
        } else {
            B(f);
        }
        return this.f9438a;
    }

    @Override // com.huawei.openalliance.ad.views.g, android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        Code(i, i2, i3, i4);
        int i5 = i3 - i;
        if (i5 != 0) {
            Code(this.e / i5);
            V(1.0f - Code());
        }
    }
}
