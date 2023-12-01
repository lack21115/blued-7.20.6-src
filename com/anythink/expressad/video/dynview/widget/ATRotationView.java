package com.anythink.expressad.video.dynview.widget;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/widget/ATRotationView.class */
public class ATRotationView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    Runnable f8409a;
    private Camera b;

    /* renamed from: c  reason: collision with root package name */
    private Matrix f8410c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private float l;
    private float m;
    private boolean n;
    private boolean o;
    private boolean p;

    public ATRotationView(Context context) {
        super(context);
        this.f = 40;
        this.g = 20;
        this.h = 0;
        this.i = 0;
        this.k = 0;
        this.l = 0.5f;
        this.m = 0.9f;
        this.n = true;
        this.o = false;
        this.p = false;
        this.f8409a = new Runnable() { // from class: com.anythink.expressad.video.dynview.widget.ATRotationView.1
            @Override // java.lang.Runnable
            public final void run() {
                ATRotationView.a(ATRotationView.this);
            }
        };
        a();
    }

    public ATRotationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 40;
        this.g = 20;
        this.h = 0;
        this.i = 0;
        this.k = 0;
        this.l = 0.5f;
        this.m = 0.9f;
        this.n = true;
        this.o = false;
        this.p = false;
        this.f8409a = new Runnable() { // from class: com.anythink.expressad.video.dynview.widget.ATRotationView.1
            @Override // java.lang.Runnable
            public final void run() {
                ATRotationView.a(ATRotationView.this);
            }
        };
        a();
    }

    public ATRotationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = 40;
        this.g = 20;
        this.h = 0;
        this.i = 0;
        this.k = 0;
        this.l = 0.5f;
        this.m = 0.9f;
        this.n = true;
        this.o = false;
        this.p = false;
        this.f8409a = new Runnable() { // from class: com.anythink.expressad.video.dynview.widget.ATRotationView.1
            @Override // java.lang.Runnable
            public final void run() {
                ATRotationView.a(ATRotationView.this);
            }
        };
        a();
    }

    private int a(int i) {
        int i2;
        int i3;
        int i4;
        if (i == 0) {
            i2 = this.p ? this.i - 2 : this.i + 2;
        } else if (i != 1) {
            if (i != 2) {
                i2 = i != 3 ? 0 : this.i;
            } else if (this.p) {
                i3 = this.i;
                i2 = i3 - 1;
            } else {
                i4 = this.i;
                i2 = i4 + 1;
            }
        } else if (this.p) {
            i4 = this.i;
            i2 = i4 + 1;
        } else {
            i3 = this.i;
            i2 = i3 - 1;
        }
        int childCount = i2 % getChildCount();
        return childCount >= 0 ? childCount : childCount + getChildCount();
    }

    private void a() {
        this.b = new Camera();
        this.f8410c = new Matrix();
        setWillNotDraw(false);
    }

    private void a(int i, int i2, int i3) {
        float f = (-i) / 2.0f;
        if (i3 == 0) {
            this.b.translate(0.0f, f, 0.0f);
            float f2 = -i2;
            this.b.rotateX(f2);
            this.b.translate(0.0f, f, 0.0f);
            this.b.translate(0.0f, f, 0.0f);
            this.b.rotateX(f2);
            this.b.translate(0.0f, f, 0.0f);
        } else if (i3 == 1) {
            this.b.translate(0.0f, f, 0.0f);
            this.b.rotateX(i2);
            this.b.translate(0.0f, f, 0.0f);
        } else if (i3 != 2) {
            if (i3 != 3) {
                return;
            }
            this.b.rotateX(0.0f);
        } else {
            this.b.translate(0.0f, f, 0.0f);
            this.b.rotateX(-i2);
            this.b.translate(0.0f, f, 0.0f);
        }
    }

    private void a(Canvas canvas) {
        int width = getWidth() / 2;
        int i = ((this.h * this.e) / 2) / this.f;
        b(canvas, i, width, 0);
        b(canvas, i, width, 1);
        if (Math.abs(this.h) > this.f / 2) {
            b(canvas, i, width, 3);
            b(canvas, i, width, 2);
            return;
        }
        b(canvas, i, width, 2);
        b(canvas, i, width, 3);
    }

    private void a(Canvas canvas, int i, int i2, int i3) {
        canvas.save();
        this.b.save();
        this.f8410c.reset();
        float f = i;
        this.b.translate(0.0f, f, 0.0f);
        this.b.rotateX(this.h);
        this.b.translate(0.0f, f, 0.0f);
        if (i == 0) {
            if (this.p) {
                a(this.d, this.f, i3);
            } else {
                a(-this.d, -this.f, i3);
            }
        } else if (i > 0) {
            a(this.d, this.f, i3);
        } else if (i < 0) {
            a(-this.d, -this.f, i3);
        }
        this.b.getMatrix(this.f8410c);
        this.b.restore();
        this.f8410c.preTranslate((-getWidth()) / 2, -i2);
        this.f8410c.postTranslate(getWidth() / 2, i2);
        canvas.concat(this.f8410c);
        View childAt = getChildAt(a(i3));
        if (childAt != null) {
            drawChild(canvas, childAt, 0L);
        }
        canvas.restore();
    }

    static /* synthetic */ void a(ATRotationView aTRotationView) {
        if (aTRotationView.getChildCount() != 0) {
            int i = aTRotationView.h - 1;
            aTRotationView.h = i;
            int i2 = aTRotationView.i;
            aTRotationView.j = i2;
            int i3 = aTRotationView.f;
            int i4 = i / i3;
            int i5 = i % i3;
            aTRotationView.h = i5;
            aTRotationView.i = i2 - i4;
            int a2 = Math.abs(i5) > aTRotationView.f / 2 ? aTRotationView.a(2) : aTRotationView.a(3);
            if (aTRotationView.k != a2) {
                aTRotationView.k = a2;
            }
            aTRotationView.invalidate();
            if (aTRotationView.n) {
                aTRotationView.postDelayed(aTRotationView.f8409a, 1000 / aTRotationView.g);
            }
        }
    }

    private void b() {
        if (getChildCount() == 0) {
            return;
        }
        int i = this.h - 1;
        this.h = i;
        int i2 = this.i;
        this.j = i2;
        int i3 = this.f;
        int i4 = i / i3;
        int i5 = i % i3;
        this.h = i5;
        this.i = i2 - i4;
        int a2 = Math.abs(i5) > this.f / 2 ? a(2) : a(3);
        if (this.k != a2) {
            this.k = a2;
        }
        invalidate();
        if (this.n) {
            postDelayed(this.f8409a, 1000 / this.g);
        }
    }

    private void b(int i) {
        int i2 = this.f;
        int i3 = i / i2;
        int i4 = this.j;
        int i5 = i % i2;
        this.h = i5;
        this.i = i4 - i3;
        int a2 = Math.abs(i5) > this.f / 2 ? a(2) : a(3);
        if (this.k != a2) {
            this.k = a2;
        }
        invalidate();
    }

    private void b(int i, int i2, int i3) {
        if (i3 == 0) {
            float f = (-i) / 2;
            this.b.translate(f, 0.0f, 0.0f);
            float f2 = -i2;
            this.b.rotateY(f2);
            this.b.translate(f, 0.0f, 0.0f);
            this.b.translate(f, 0.0f, 0.0f);
            this.b.rotateY(f2);
            this.b.translate(f, 0.0f, 0.0f);
        } else if (i3 == 1) {
            float f3 = i / 2;
            this.b.translate(f3, 0.0f, 0.0f);
            this.b.rotateY(i2);
            this.b.translate(f3, 0.0f, 0.0f);
        } else if (i3 != 2) {
            if (i3 != 3) {
                return;
            }
            this.b.rotateY(0.0f);
        } else {
            float f4 = (-i) / 2;
            this.b.translate(f4, 0.0f, 0.0f);
            this.b.rotateY(-i2);
            this.b.translate(f4, 0.0f, 0.0f);
        }
    }

    private void b(Canvas canvas) {
        int height = getHeight() / 2;
        int i = ((this.h * this.d) / 2) / this.f;
        a(canvas, i, height, 0);
        a(canvas, i, height, 1);
        if (Math.abs(this.h) > this.f / 2) {
            a(canvas, i, height, 3);
            a(canvas, i, height, 2);
            return;
        }
        a(canvas, i, height, 2);
        a(canvas, i, height, 3);
    }

    private void b(Canvas canvas, int i, int i2, int i3) {
        canvas.save();
        this.b.save();
        this.f8410c.reset();
        float f = i;
        this.b.translate(f, 0.0f, 0.0f);
        this.b.rotateY(this.h);
        this.b.translate(f, 0.0f, 0.0f);
        if (i == 0) {
            if (this.p) {
                b(this.e, this.f, i3);
            } else {
                b(-this.e, -this.f, i3);
            }
        } else if (i > 0) {
            b(this.e, this.f, i3);
        } else if (i < 0) {
            b(-this.e, -this.f, i3);
        }
        this.b.getMatrix(this.f8410c);
        this.b.restore();
        this.f8410c.preTranslate(-i2, (-getHeight()) / 2);
        this.f8410c.postTranslate(i2, getHeight() / 2);
        canvas.concat(this.f8410c);
        View childAt = getChildAt(a(i3));
        if (childAt != null) {
            drawChild(canvas, childAt, 0L);
        }
        canvas.restore();
    }

    private void c(int i) {
        this.i = i;
        int a2 = Math.abs(this.h) > this.f / 2 ? a(2) : a(3);
        if (this.k != a2) {
            this.k = a2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (getChildCount() == 0) {
            return;
        }
        if (this.o) {
            int height = getHeight() / 2;
            int i = ((this.h * this.d) / 2) / this.f;
            a(canvas, i, height, 0);
            a(canvas, i, height, 1);
            if (Math.abs(this.h) > this.f / 2) {
                a(canvas, i, height, 3);
                a(canvas, i, height, 2);
                return;
            }
            a(canvas, i, height, 2);
            a(canvas, i, height, 3);
            return;
        }
        int width = getWidth() / 2;
        int i2 = ((this.h * this.e) / 2) / this.f;
        b(canvas, i2, width, 0);
        b(canvas, i2, width, 1);
        if (Math.abs(this.h) > this.f / 2) {
            b(canvas, i2, width, 3);
            b(canvas, i2, width, 2);
            return;
        }
        b(canvas, i2, width, 2);
        b(canvas, i2, width, 3);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        float f = i5;
        float f2 = this.l;
        int i6 = (int) (((1.0f - f2) * f) / 2.0f);
        int i7 = i4 - i2;
        float f3 = i7;
        float f4 = this.m;
        int i8 = (int) (((1.0f - f4) * f3) / 2.0f);
        this.d = (int) (f3 * f4);
        this.e = (int) (f * f2);
        int childCount = getChildCount();
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= childCount) {
                return;
            }
            View childAt = getChildAt(i10);
            childAt.layout(i6, i8, i5 - i6, i7 - i8);
            childAt.setClickable(true);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            int i11 = layoutParams.width;
            int i12 = this.e;
            if (i11 != i12) {
                layoutParams.width = i12;
                layoutParams.height = this.d;
                childAt.setLayoutParams(layoutParams);
            }
            i9 = i10 + 1;
        }
    }

    public void setAutoscroll(boolean z) {
        if (z) {
            postDelayed(this.f8409a, 1000 / this.g);
        }
        this.n = z;
    }

    public void setHeightRatio(float f) {
        this.m = f;
    }

    public void setRotateV(boolean z) {
        this.o = z;
        invalidate();
    }

    public void setWidthRatio(float f) {
        this.l = f;
    }
}
