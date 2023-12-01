package com.soft.blued.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import com.anythink.expressad.video.module.a.a.m;
import com.soft.blued.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/DiffuseView.class */
public class DiffuseView extends View {
    private static SparseArray<Bitmap> q = new SparseArray<>();

    /* renamed from: a  reason: collision with root package name */
    private int f14715a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap f14716c;
    private float d;
    private int e;
    private float f;
    private float g;
    private boolean h;
    private int i;
    private int j;
    private List<Float> k;
    private List<Float> l;
    private Paint m;
    private Paint n;
    private long o;
    private boolean p;

    public DiffuseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public DiffuseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14715a = getResources().getColor(2131101190);
        this.b = getResources().getColor(2131099875);
        this.e = 3;
        this.f = 50.0f;
        this.g = 1.0f;
        this.h = false;
        this.k = new ArrayList();
        this.l = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DiffuseView, i, 0);
        this.f14715a = obtainStyledAttributes.getColor(0, this.f14715a);
        this.b = obtainStyledAttributes.getColor(1, this.b);
        this.d = obtainStyledAttributes.getFloat(3, this.d);
        this.e = obtainStyledAttributes.getInt(8, this.e);
        this.f = obtainStyledAttributes.getDimension(6, this.f);
        this.g = obtainStyledAttributes.getDimension(7, this.g);
        this.i = obtainStyledAttributes.getDimensionPixelSize(5, 50);
        this.j = obtainStyledAttributes.getDimensionPixelOffset(4, 50);
        int resourceId = obtainStyledAttributes.getResourceId(2, -1);
        int i2 = this.i + this.f14715a;
        Bitmap bitmap = q.get(i2);
        this.f14716c = bitmap;
        if (bitmap == null && resourceId != -1) {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), resourceId), this.i, this.j, true);
            this.f14716c = createScaledBitmap;
            q.put(i2, createScaledBitmap);
        }
        obtainStyledAttributes.recycle();
        a();
    }

    private void a() {
        this.m = new Paint();
        this.n = new Paint();
        this.p = true;
        Bitmap bitmap = this.f14716c;
        this.d = bitmap == null ? 0 : bitmap.getHeight() / 2;
        this.m.setColor(this.f14715a);
        this.m.setAntiAlias(true);
        this.n.setAntiAlias(true);
        this.k.add(Float.valueOf(204.0f));
        this.l.add(Float.valueOf(0.0f));
    }

    private void b() {
        this.h = false;
        this.l.clear();
        this.k.clear();
        this.k.add(Float.valueOf(204.0f));
        this.l.add(Float.valueOf(0.0f));
    }

    private boolean c() {
        return System.currentTimeMillis() - this.o >= m.ag;
    }

    @Override // android.view.View
    public void invalidate() {
        if (hasWindowFocus()) {
            super.invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.h) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.k.size()) {
                    break;
                }
                float floatValue = this.k.get(i2).floatValue();
                float floatValue2 = this.l.get(i2).floatValue();
                float f = this.f;
                if (floatValue2 < f) {
                    float height = 204.0f / (f - (this.f14716c.getHeight() / 2));
                    float f2 = this.g;
                    this.l.set(i2, Float.valueOf(f2 + floatValue2));
                    List<Float> list = this.k;
                    float f3 = 0.0f;
                    if (floatValue2 < this.f) {
                        f3 = floatValue - (height * f2);
                        if (f3 <= 1.0f) {
                            f3 = 0.0f;
                        }
                    }
                    list.set(i2, Float.valueOf(f3));
                }
                this.m.setAlpha(Math.round(this.k.get(i2).floatValue()));
                canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.d + floatValue2, this.m);
                i = i2 + 1;
            }
            if (this.l.get(0).floatValue() >= (this.f - this.d) / 2.0f && this.l.size() < 2) {
                this.k.add(Float.valueOf(204.0f));
                this.l.add(Float.valueOf(0.0f));
            }
            Bitmap bitmap = this.f14716c;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, (getWidth() / 2) - (this.f14716c.getWidth() / 2), (getHeight() / 2) - (this.f14716c.getHeight() / 2), this.n);
            }
        } else {
            Bitmap bitmap2 = this.f14716c;
            if (bitmap2 != null) {
                canvas.drawBitmap(bitmap2, (getWidth() / 2) - (this.f14716c.getWidth() / 2), (getHeight() / 2) - (this.f14716c.getHeight() / 2), this.n);
            }
        }
        if (this.l.size() == 2 && this.l.get(1).floatValue() >= this.f) {
            b();
            this.o = System.currentTimeMillis();
        } else if (c()) {
            this.h = true;
        }
        invalidate();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            invalidate();
        }
    }

    public void setColor(int i) {
        this.f14715a = i;
    }

    public void setCoreColor(int i) {
        this.b = i;
    }

    public void setCoreImage(int i) {
        this.f14716c = BitmapFactory.decodeResource(getResources(), i);
    }

    public void setCoreRadius(int i) {
        this.d = i;
    }

    public void setDiffuseSpeed(int i) {
        this.g = i;
    }

    public void setDiffuseWidth(int i) {
        this.e = i;
    }

    public void setIsTransparent(boolean z) {
        this.p = z;
    }

    public void setMaxWidth(int i) {
        this.f = i;
    }
}
