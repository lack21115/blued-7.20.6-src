package com.qiniu.pili.droid.shortvideo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLPaintView.class */
public class PLPaintView extends View {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap f27495a;
    private Canvas b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f27496c;
    private Path d;
    private boolean e;
    private int f;
    private int g;
    private float h;
    private float i;
    private LinkedList<a> j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLPaintView$a.class */
    public class a {
        private Paint b;

        /* renamed from: c  reason: collision with root package name */
        private Path f27498c;

        public a(Paint paint, Path path) {
            this.b = paint;
            this.f27498c = path;
        }

        public Paint a() {
            return this.b;
        }

        public Path b() {
            return this.f27498c;
        }
    }

    public PLPaintView(Context context) {
        super(context);
        this.f27496c = new Paint();
        this.d = new Path();
        this.e = true;
        this.j = new LinkedList<>();
        a();
    }

    public PLPaintView(Context context, int i, int i2) {
        this(context);
        this.f = i;
        this.g = i2;
    }

    private void a() {
        this.f27496c.setAntiAlias(true);
        this.f27496c.setDither(true);
        this.f27496c.setStrokeJoin(Paint.Join.ROUND);
        this.f27496c.setStrokeCap(Paint.Cap.ROUND);
        this.f27496c.setColor(-16777216);
        this.f27496c.setStyle(Paint.Style.STROKE);
        this.f27496c.setStrokeWidth(10.0f);
    }

    private void b() {
        int width = getWidth();
        int height = getHeight();
        int i = this.f;
        boolean z = true;
        boolean z2 = i != 0 && i < width;
        int i2 = this.g;
        if (i2 == 0 || i2 >= height) {
            z = false;
        }
        if (z2) {
            width = this.f;
        }
        this.f = width;
        int i3 = height;
        if (z) {
            i3 = this.g;
        }
        this.g = i3;
        this.f27495a = Bitmap.createBitmap(this.f, i3, Bitmap.Config.ARGB_8888);
        this.b = new Canvas(this.f27495a);
    }

    private void c() {
        this.j.add(new a(new Paint(this.f27496c), new Path(this.d)));
    }

    private void d() {
        Bitmap bitmap = this.f27495a;
        if (bitmap != null) {
            bitmap.eraseColor(0);
            if (!this.j.isEmpty()) {
                Iterator<a> it = this.j.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    this.b.drawPath(next.b(), next.a());
                }
            }
            invalidate();
        }
    }

    public void clear() {
        this.j.clear();
        d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap = this.f27495a;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.e) {
            int action = motionEvent.getAction() & 255;
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int actionIndex = motionEvent.getActionIndex();
            if (action == 0) {
                this.h = x;
                this.i = y;
                this.d.moveTo(x, y);
                return true;
            } else if (action == 1) {
                c();
                this.d.reset();
                return true;
            } else if (action == 2 && motionEvent.getPointerId(actionIndex) != 1) {
                if (this.f27495a == null) {
                    b();
                }
                float abs = Math.abs(x - this.h);
                float abs2 = Math.abs(this.i - y);
                if (abs >= 3.0f || abs2 >= 3.0f) {
                    Path path = this.d;
                    float f = this.h;
                    float f2 = this.i;
                    path.quadTo(f, f2, (x + f) / 2.0f, (y + f2) / 2.0f);
                    this.b.drawPath(this.d, this.f27496c);
                    invalidate();
                    this.h = x;
                    this.i = y;
                    return true;
                }
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    public void setPaint(Paint paint) {
        this.f27496c = paint;
    }

    public void setPaintColor(int i) {
        this.f27496c.setColor(i);
    }

    public void setPaintEnable(boolean z) {
        this.e = z;
    }

    public void setPaintSize(int i) {
        this.f27496c.setStrokeWidth(i);
    }

    public void undo() {
        if (!this.j.isEmpty()) {
            this.j.removeLast();
        }
        d();
    }
}
