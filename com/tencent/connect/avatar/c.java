package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/connect/avatar/c.class */
public class c extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    final String f22494a;
    public boolean b;

    /* renamed from: c  reason: collision with root package name */
    private Matrix f22495c;
    private Matrix d;
    private int e;
    private float f;
    private float g;
    private Bitmap h;
    private boolean i;
    private float j;
    private float k;
    private PointF l;
    private PointF m;
    private float n;
    private float o;
    private Rect p;

    public c(Context context) {
        super(context);
        this.f22495c = new Matrix();
        this.d = new Matrix();
        this.e = 0;
        this.f = 1.0f;
        this.g = 1.0f;
        this.i = false;
        this.f22494a = "TouchView";
        this.l = new PointF();
        this.m = new PointF();
        this.n = 1.0f;
        this.o = 0.0f;
        this.b = false;
        Rect rect = new Rect();
        this.p = rect;
        getDrawingRect(rect);
        a();
    }

    private float a(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() < 2) {
            return 0.0f;
        }
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return FloatMath.sqrt((x * x) + (y * y));
    }

    private void a() {
    }

    private void a(PointF pointF) {
        if (this.h == null) {
            return;
        }
        float[] fArr = new float[9];
        this.f22495c.getValues(fArr);
        float f = fArr[2];
        float f2 = fArr[5];
        float f3 = fArr[0];
        float width = this.h.getWidth();
        float height = this.h.getHeight();
        float f4 = this.p.left - f;
        float f5 = f4;
        if (f4 <= 1.0f) {
            f5 = 1.0f;
        }
        float f6 = (f + (width * f3)) - this.p.right;
        float f7 = f6;
        if (f6 <= 1.0f) {
            f7 = 1.0f;
        }
        float width2 = (this.p.width() * f5) / (f7 + f5);
        float f8 = this.p.left;
        float f9 = this.p.top - f2;
        float f10 = (f2 + (height * f3)) - this.p.bottom;
        float f11 = f9;
        if (f9 <= 1.0f) {
            f11 = 1.0f;
        }
        pointF.set(width2 + f8, ((this.p.height() * f11) / ((f10 <= 1.0f ? 1.0f : f10) + f11)) + this.p.top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.h == null) {
            return;
        }
        float width = this.p.width();
        float height = this.p.height();
        float[] fArr = new float[9];
        this.f22495c.getValues(fArr);
        float f = fArr[2];
        float f2 = fArr[5];
        boolean z = false;
        float f3 = fArr[0];
        ScaleAnimation scaleAnimation = null;
        float f4 = this.f;
        if (f3 > f4) {
            float f5 = f4 / f3;
            this.o = f5;
            this.f22495c.postScale(f5, f5, this.m.x, this.m.y);
            setImageMatrix(this.f22495c);
            float f6 = this.o;
            scaleAnimation = new ScaleAnimation(1.0f / f6, 1.0f, 1.0f / f6, 1.0f, this.m.x, this.m.y);
        } else {
            float f7 = this.g;
            if (f3 < f7) {
                float f8 = f7 / f3;
                this.o = f8;
                this.f22495c.postScale(f8, f8, this.m.x, this.m.y);
                float f9 = this.o;
                scaleAnimation = new ScaleAnimation(1.0f, f9, 1.0f, f9, this.m.x, this.m.y);
            } else {
                float width2 = this.h.getWidth() * f3;
                float height2 = this.h.getHeight() * f3;
                float f10 = this.p.left - f;
                float f11 = this.p.top - f2;
                if (f10 < 0.0f) {
                    f = this.p.left;
                    z = true;
                }
                if (f11 < 0.0f) {
                    f2 = this.p.top;
                    z = true;
                }
                if (width2 - f10 < width) {
                    f = this.p.left - (width2 - width);
                    z = true;
                }
                if (height2 - f11 < height) {
                    f2 = this.p.top - (height2 - height);
                    z = true;
                }
                if (z) {
                    float f12 = fArr[2];
                    float f13 = fArr[5];
                    fArr[2] = f;
                    fArr[5] = f2;
                    this.f22495c.setValues(fArr);
                    setImageMatrix(this.f22495c);
                    scaleAnimation = new TranslateAnimation(f12 - f, 0.0f, f13 - f2, 0.0f);
                } else {
                    setImageMatrix(this.f22495c);
                }
            }
        }
        if (scaleAnimation != null) {
            this.i = true;
            scaleAnimation.setDuration(300L);
            startAnimation(scaleAnimation);
            new Thread(new Runnable() { // from class: com.tencent.connect.avatar.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Thread.sleep(300L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    c.this.post(new Runnable() { // from class: com.tencent.connect.avatar.c.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.clearAnimation();
                            c.this.b();
                        }
                    });
                    c.this.i = false;
                }
            }).start();
        }
    }

    private void c() {
        if (this.h == null) {
            return;
        }
        this.f22495c.getValues(r0);
        float max = Math.max(this.p.width() / this.h.getWidth(), this.p.height() / this.h.getHeight());
        this.j = this.p.left - (((this.h.getWidth() * max) - this.p.width()) / 2.0f);
        float height = this.p.top - (((this.h.getHeight() * max) - this.p.height()) / 2.0f);
        this.k = height;
        float[] fArr = {max, 0.0f, this.j, 0.0f, max, height};
        this.f22495c.setValues(fArr);
        float min = Math.min(2048.0f / this.h.getWidth(), 2048.0f / this.h.getHeight());
        this.f = min;
        this.g = max;
        if (min < max) {
            this.f = max;
        }
        setImageMatrix(this.f22495c);
    }

    public void a(Rect rect) {
        this.p = rect;
        if (this.h != null) {
            c();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
        if (r0 != 6) goto L15;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.avatar.c.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.h = bitmap;
        if (bitmap != null) {
            this.h = bitmap;
        }
    }
}
