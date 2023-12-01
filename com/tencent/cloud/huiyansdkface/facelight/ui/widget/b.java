package com.tencent.cloud.huiyansdkface.facelight.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.os.CountDownTimer;
import android.view.View;
import com.tencent.cloud.huiyansdkface.facelight.c.f;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/ui/widget/b.class */
public class b extends View {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22089a = b.class.getSimpleName();
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private int f22090c;
    private int d;
    private float[] e;
    private float[] f;
    private float[] g;
    private int h;
    private int i;
    private int j;
    private int k;
    private Paint l;
    private DrawFilter m;
    private float n;
    private float o;
    private float p;
    private CountDownTimer q;
    private CountDownTimer r;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/ui/widget/b$a.class */
    public interface a {
        void a();
    }

    public b(Context context) {
        super(context);
        this.n = 0.0f;
        this.p = 0.0f;
        this.h = f.a(context, 6.0f);
        this.i = f.a(context, 8.0f);
        Paint paint = new Paint();
        this.l = paint;
        paint.setAntiAlias(true);
        this.l.setStyle(Paint.Style.FILL);
        this.l.setColor(452984831);
        this.m = new PaintFlagsDrawFilter(0, 3);
    }

    private void a() {
        float[] fArr;
        float[] fArr2 = this.e;
        if (fArr2 == null || (fArr = this.f) == null || this.g == null) {
            WLogger.e(f22089a, "mYPositions is null！");
            return;
        }
        int length = fArr2.length;
        int i = this.j;
        int i2 = length - i;
        if (i2 > 0) {
            System.arraycopy(fArr2, i, fArr, 0, i2);
            System.arraycopy(this.e, 0, this.f, i2, this.j);
        }
        float[] fArr3 = this.e;
        int length2 = fArr3.length;
        int i3 = this.k;
        int i4 = length2 - i3;
        if (i4 > 0) {
            System.arraycopy(fArr3, i3, this.g, 0, i4);
            System.arraycopy(this.e, 0, this.g, i4, this.k);
        }
    }

    public void a(final int i, final float f) {
        this.p = 0.0f;
        CountDownTimer countDownTimer = new CountDownTimer(i, 10L) { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.widget.b.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                b.this.setProgress(f);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                b bVar = b.this;
                float f2 = f;
                int i2 = i;
                bVar.setProgress((f2 * ((float) (i2 - j))) / i2);
            }
        };
        this.q = countDownTimer;
        countDownTimer.start();
    }

    public void a(final int i, final a aVar) {
        CountDownTimer countDownTimer = this.q;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        final float f = this.p;
        final float f2 = 1.0f - f;
        CountDownTimer countDownTimer2 = new CountDownTimer(i, 10L) { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.widget.b.2
            @Override // android.os.CountDownTimer
            public void onFinish() {
                b.this.setProgress(1.0f);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a();
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                b bVar = b.this;
                float f3 = f;
                float f4 = f2;
                int i2 = i;
                bVar.setProgress(f3 + ((f4 * ((float) (i2 - j))) / i2));
            }
        };
        this.r = countDownTimer2;
        countDownTimer2.start();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        canvas.setDrawFilter(this.m);
        a();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            i = this.f22090c;
            if (i3 >= i) {
                break;
            }
            float f = i3;
            int i4 = this.d;
            canvas.drawLine(f, ((i4 - this.f[i3]) - this.n) - (this.p * this.o), f, i4, this.l);
            int i5 = this.d;
            canvas.drawLine(f, ((i5 - this.g[i3]) - this.n) - (this.p * this.o), f, i5, this.l);
            i2 = i3 + 1;
        }
        int i6 = this.j + this.h;
        this.j = i6;
        this.k += this.i;
        if (i6 >= i) {
            this.j = 0;
        }
        if (this.k > this.f22090c) {
            this.k = 0;
        }
        postInvalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f22090c = i;
        this.d = i2;
        this.e = new float[i];
        this.f = new float[i];
        this.g = new float[i];
        this.b = (float) (6.283185307179586d / i);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= this.f22090c) {
                return;
            }
            this.e[i6] = (float) ((Math.sin(this.b * i6) * 24.0d) + 0.0d);
            i5 = i6 + 1;
        }
    }

    public void setEndHeight(float f) {
        this.o = f;
        invalidate();
    }

    public void setInitHeight(float f) {
        this.n = f;
        invalidate();
    }

    public void setProgress(float f) {
        this.p = f;
        invalidate();
    }
}
