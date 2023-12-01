package com.soft.blued.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.soft.blued.R;
import com.soft.blued.utils.Logger;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/RoteProgressBar.class */
public class RoteProgressBar extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private Paint f28507a;
    private Paint b;

    /* renamed from: c  reason: collision with root package name */
    private RectF f28508c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private int l;
    private Paint m;
    private int n;
    private Paint o;
    private boolean p;
    private Handler q;
    private boolean r;
    private Timer s;
    private MyTimerTask t;
    private int u;
    private int v;
    private float w;
    private float x;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/RoteProgressBar$MyTimerTask.class */
    class MyTimerTask extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RoteProgressBar f28510a;

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f28510a.q.obtainMessage(256).sendToTarget();
        }
    }

    public RoteProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoteProgressBar);
        int i = obtainStyledAttributes.getInt(3, 100);
        this.j = i;
        this.u = i;
        boolean z = obtainStyledAttributes.getBoolean(1, true);
        this.k = z;
        if (!z) {
            this.b.setStyle(Paint.Style.STROKE);
            this.m.setStyle(Paint.Style.STROKE);
            this.o.setStyle(Paint.Style.STROKE);
        }
        this.l = AppMethods.a(obtainStyledAttributes.getInt(2, 0));
        this.p = obtainStyledAttributes.getBoolean(7, true);
        this.d = AppMethods.a(obtainStyledAttributes.getInt(4, 10));
        if (this.k) {
            this.d = 0;
        }
        this.b.setStrokeWidth(this.d);
        this.m.setStrokeWidth(this.d);
        this.o.setStrokeWidth(this.d);
        int color = obtainStyledAttributes.getColor(5, -13312);
        this.e = color;
        this.b.setColor(color);
        int color2 = obtainStyledAttributes.getColor(6, (this.e & 16777215) | 1711276032);
        this.f = color2;
        this.m.setColor(color2);
        int color3 = obtainStyledAttributes.getColor(0, Color.GRAY);
        this.g = color3;
        this.o.setColor(color3);
        obtainStyledAttributes.recycle();
    }

    static /* synthetic */ float a(RoteProgressBar roteProgressBar, float f) {
        float f2 = roteProgressBar.w + f;
        roteProgressBar.w = f2;
        return f2;
    }

    private void a() {
        Paint paint = new Paint();
        this.f28507a = paint;
        paint.setAntiAlias(true);
        this.f28507a.setStyle(Paint.Style.STROKE);
        this.f28507a.setStrokeWidth(0.0f);
        this.d = 0;
        this.e = -13312;
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setAntiAlias(true);
        this.b.setStyle(Paint.Style.FILL);
        this.b.setStrokeWidth(this.d);
        this.b.setColor(this.e);
        Paint paint3 = new Paint();
        this.m = paint3;
        paint3.setAntiAlias(true);
        this.m.setStyle(Paint.Style.FILL);
        this.m.setStrokeWidth(this.d);
        int i = (this.e & 16777215) | 1711276032;
        this.f = i;
        this.m.setColor(i);
        this.g = Color.GRAY;
        Paint paint4 = new Paint();
        this.o = paint4;
        paint4.setAntiAlias(true);
        this.o.setStyle(Paint.Style.FILL);
        this.o.setStrokeWidth(this.d);
        this.o.setColor(this.g);
        this.h = -90;
        this.i = 0;
        this.j = 100;
        this.u = 100;
        this.k = true;
        this.p = true;
        this.l = 0;
        this.n = 0;
        this.f28508c = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.v = 25;
        this.w = 0.0f;
        this.x = 0.0f;
        this.r = false;
        this.q = new Handler() { // from class: com.soft.blued.customview.RoteProgressBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 256 && RoteProgressBar.this.r) {
                    RoteProgressBar roteProgressBar = RoteProgressBar.this;
                    RoteProgressBar.a(roteProgressBar, roteProgressBar.x);
                    RoteProgressBar roteProgressBar2 = RoteProgressBar.this;
                    roteProgressBar2.setProgress((int) roteProgressBar2.w);
                    if (RoteProgressBar.this.w > RoteProgressBar.this.j) {
                        RoteProgressBar.this.r = false;
                        RoteProgressBar roteProgressBar3 = RoteProgressBar.this;
                        roteProgressBar3.j = roteProgressBar3.u;
                        if (RoteProgressBar.this.t != null) {
                            RoteProgressBar.this.t.cancel();
                            RoteProgressBar.this.t = null;
                        }
                    }
                }
            }
        };
        this.s = new Timer("RotePro");
    }

    public int getMax() {
        int i;
        synchronized (this) {
            i = this.j;
        }
        return i;
    }

    public int getProgress() {
        int i;
        synchronized (this) {
            i = this.i;
        }
        return i;
    }

    public int getSecondaryProgress() {
        int i;
        synchronized (this) {
            i = this.n;
        }
        return i;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.p) {
            canvas.drawArc(this.f28508c, 0.0f, 360.0f, this.k, this.o);
        }
        canvas.drawArc(this.f28508c, this.h, (this.n / this.j) * 360.0f, this.k, this.m);
        canvas.drawArc(this.f28508c, this.h, (this.i / this.j) * 360.0f, this.k, this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Logger.b("", "W = ", Integer.valueOf(i), ", H = ", Integer.valueOf(i2));
        int i5 = this.l;
        if (i5 != 0) {
            RectF rectF = this.f28508c;
            int i6 = this.d;
            rectF.set((i6 / 2) + i5, (i6 / 2) + i5, (i - (i6 / 2)) - i5, (i2 - (i6 / 2)) - i5);
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        RectF rectF2 = this.f28508c;
        int i7 = this.d;
        rectF2.set(paddingLeft + (i7 / 2), paddingTop + (i7 / 2), (i - paddingRight) - (i7 / 2), (i2 - paddingBottom) - (i7 / 2));
    }

    public void setMax(int i) {
        synchronized (this) {
            if (i <= 0) {
                return;
            }
            this.j = i;
            if (this.i > i) {
                this.i = i;
            }
            if (this.n > i) {
                this.n = i;
            }
            this.u = this.j;
            invalidate();
        }
    }

    public void setProgress(int i) {
        synchronized (this) {
            this.i = i;
            if (i < 0) {
                this.i = 0;
            }
            if (this.i > this.j) {
                this.i = this.j;
            }
            invalidate();
        }
    }

    public void setSecondaryProgress(int i) {
        synchronized (this) {
            this.n = i;
            if (i < 0) {
                this.n = 0;
            }
            if (this.n > this.j) {
                this.n = this.j;
            }
            invalidate();
        }
    }
}
