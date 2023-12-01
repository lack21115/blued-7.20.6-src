package com.huawei.openalliance.ad.views;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.utils.ay;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/f.class */
public class f extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private Paint f9436a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private float f9437c;
    private float d;
    private float e;
    private int i;
    private long k;
    private LinearGradient l;
    private float m;
    private boolean n;
    private int f = 1728053247;
    private boolean g = true;
    private float h = 0.0f;
    private boolean j = false;

    public f() {
        B();
    }

    public f(float f) {
        this.m = f;
        B();
    }

    private void B() {
        Paint paint = new Paint();
        this.f9436a = paint;
        paint.setAntiAlias(true);
        this.f9436a.setStyle(Paint.Style.FILL);
        this.b = 0.0f;
        this.d = 0.0f;
        V(2);
        this.n = ay.C();
    }

    private boolean C() {
        return this.i == 2;
    }

    private void Code(float f, float f2) {
        float f3 = f2 - f;
        this.b = f3;
        float level = (f3 * getLevel()) / 10000.0f;
        this.f9437c = level;
        float f4 = this.b * 0.3f;
        this.d = f4;
        this.h = (f4 + level) / 2000.0f;
        a();
        L();
    }

    private void Code(long j) {
        this.k = j;
    }

    private long D() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.k;
        Code(currentTimeMillis);
        long j2 = j;
        if (j < 0) {
            j2 = 0;
        }
        return j2;
    }

    private void F() {
        this.h = (this.d + this.f9437c) / 2000.0f;
        if (this.g) {
            this.g = false;
        }
    }

    private void L() {
        int i = this.f;
        int i2 = 16777215 & i;
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, this.d, 0.0f, new int[]{i2, i, i2}, new float[]{0.0f, 0.93f, 1.0f}, Shader.TileMode.CLAMP);
        this.l = linearGradient;
        this.f9436a.setShader(linearGradient);
    }

    private boolean S() {
        return this.j && this.g;
    }

    private void V(int i) {
        this.i = i;
    }

    private void a() {
        this.e = -this.d;
    }

    public void Code() {
        if (ge.Code()) {
            ge.Code("HwFlickerDrawable", "start()");
        }
        if (this.i == 0) {
            return;
        }
        this.j = false;
        Code(System.currentTimeMillis());
        invalidateSelf();
        V(0);
    }

    public void I() {
        if (ge.Code()) {
            ge.Code("HwFlickerDrawable", "stop()");
        }
        a();
        V(2);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (C()) {
            this.j = false;
            return;
        }
        F();
        float D = this.e + (this.h * ((float) D()));
        float f = D;
        if (Float.compare(D, this.f9437c) > 0) {
            float f2 = this.f9437c;
            f = D;
            if (((int) f2) != 0) {
                f = (D % ((int) f2)) - this.d;
            }
            this.g = true;
        }
        this.e = f;
        Rect bounds = getBounds();
        if (Float.compare(this.m, 0.0f) > 0) {
            RectF rectF = new RectF();
            rectF.set(bounds);
            Path path = new Path();
            float f3 = this.m;
            path.addRoundRect(rectF, f3, f3, Path.Direction.CW);
            canvas.clipPath(path);
        }
        if (this.n) {
            canvas.scale(-1.0f, 1.0f, bounds.width() / 2.0f, bounds.height() / 2.0f);
        }
        canvas.save();
        canvas.translate(f, 0.0f);
        float f4 = Float.compare(this.d + f, this.f9437c) > 0 ? this.f9437c - f : this.d;
        if (Float.compare(f, 0.0f) < 0) {
            canvas.clipRect(bounds.left - f, bounds.top, (bounds.left - f) + f4, bounds.bottom);
        }
        canvas.drawRect(bounds.left, bounds.top, bounds.left + f4, bounds.bottom, this.f9436a);
        canvas.restore();
        invalidateSelf();
        if (S()) {
            this.j = false;
            I();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        this.f9437c = (this.b * i) / 10000.0f;
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        Code(i, i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        super.setBounds(rect);
        Code(rect.left, rect.right);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
