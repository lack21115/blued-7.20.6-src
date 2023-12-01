package com.tencent.cloud.huiyansdkface.facelight.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.tencent.cloud.huiyansdkface.R;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/ui/widget/HeadBorderView.class */
public class HeadBorderView extends View {

    /* renamed from: a  reason: collision with root package name */
    public static final RectF f35770a = new RectF(0.0f, 0.0f, 720.0f, 1280.0f);
    static float b = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    private static RectF f35771c;
    private Path d;
    private Path e;
    private Paint f;
    private Paint g;
    private Paint h;
    private Paint i;
    private Matrix j;
    private int[] k;
    private boolean l;
    private RectF m;
    private com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.b n;
    private com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.a o;

    public HeadBorderView(Context context) {
        super(context);
        this.d = new Path();
        this.e = new Path();
        this.f = new Paint();
        this.g = new Paint();
        this.j = new Matrix();
        this.l = false;
        this.o = new com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.a();
        a(context);
    }

    public HeadBorderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new Path();
        this.e = new Path();
        this.f = new Paint();
        this.g = new Paint();
        this.j = new Matrix();
        this.l = false;
        this.o = new com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.a();
        a(context);
    }

    public HeadBorderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new Path();
        this.e = new Path();
        this.f = new Paint();
        this.g = new Paint();
        this.j = new Matrix();
        this.l = false;
        this.o = new com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.a();
        a(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x01b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Matrix a(int r6, int r7, int r8, int r9, android.graphics.Paint r10) {
        /*
            Method dump skipped, instructions count: 446
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.facelight.ui.widget.HeadBorderView.a(int, int, int, int, android.graphics.Paint):android.graphics.Matrix");
    }

    private void a() {
        this.f.setColor(getResources().getColor(R.color.wbcf_white));
        this.f.setStyle(Paint.Style.FILL);
        this.f.setAntiAlias(true);
        this.g.setColor(-65536);
        this.g.setStyle(Paint.Style.FILL);
        this.g.setAntiAlias(true);
    }

    private void a(Context context) {
        a();
    }

    private void a(Canvas canvas) {
        if (this.l) {
            if (this.i == null) {
                Paint paint = new Paint(1);
                this.i = paint;
                paint.setColor(Color.BLUE);
                this.i.setStyle(Paint.Style.STROKE);
                this.i.setStrokeWidth(5.0f);
                this.i.setAlpha(180);
            }
            canvas.drawRect(new RectF(f35771c.left, f35771c.top, f35771c.right, f35771c.bottom + 80.0f), this.i);
            if (this.h == null) {
                Paint paint2 = new Paint();
                this.h = paint2;
                paint2.setColor(-65536);
                this.h.setStyle(Paint.Style.STROKE);
                this.h.setStrokeWidth(5.0f);
                this.h.setAlpha(180);
            }
            RectF rectF = this.m;
            if (rectF != null) {
                canvas.drawRect(rectF, this.h);
            }
        }
    }

    private void b() {
        Path path = this.e;
        Path path2 = this.d;
        path.rewind();
        path2.rewind();
        path2.setFillType(Path.FillType.EVEN_ODD);
        path.setFillType(Path.FillType.EVEN_ODD);
        com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.a aVar = this.o;
        Path path3 = new Path();
        Path path4 = new Path();
        aVar.a(path3);
        path3.addCircle(360.0f, 554.0f, 248.0f, Path.Direction.CW);
        path4.addCircle(360.0f, 554.0f, 256.0f, Path.Direction.CCW);
        path.addPath(path3);
        path.addPath(path4);
        path.transform(this.j);
        path4.transform(this.j);
        RectF rectF = new RectF();
        f35771c = rectF;
        path.computeBounds(rectF, true);
        path2.set(path4);
        path2.moveTo(0.0f, 0.0f);
        path2.lineTo(getWidth(), 0.0f);
        path2.lineTo(getWidth(), getHeight());
        path2.lineTo(0.0f, getHeight());
        path2.close();
        if (this.n != null) {
            WLogger.d("HeadBorderView", "totalScale=" + b);
            this.n.a(b);
            WLogger.d("HeadBorderView", "绘制外围矩形 结束");
        }
    }

    public HeadBorderView a(boolean z) {
        this.l = z;
        return this;
    }

    public void a(int i) {
        c(i).postInvalidate();
    }

    public void a(RectF rectF) {
        if (this.l) {
            if (this.m == null) {
                this.m = new RectF();
            }
            this.m.set(rectF);
            postInvalidate();
        }
    }

    public void b(int i) {
        e(i).postInvalidate();
    }

    public HeadBorderView c(int i) {
        this.g.setColor(i);
        return this;
    }

    public HeadBorderView d(int i) {
        this.k = null;
        this.f.setShader(null);
        this.f.setColor(i);
        return this;
    }

    public HeadBorderView e(int i) {
        this.f.setColor(i);
        return this;
    }

    public RectF getBorderRect() {
        return f35771c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        System.currentTimeMillis();
        canvas.drawPath(this.d, this.f);
        canvas.drawPath(this.e, this.g);
        a(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int width = getWidth();
        int height = getHeight();
        WLogger.d("HeadBorderView", String.format("Screen Background view rect size:%d,%d-%d,%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(width), Integer.valueOf(height)));
        WindowManager windowManager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        this.j = a(width, height, displayMetrics.widthPixels, displayMetrics.heightPixels, this.g);
        long currentTimeMillis = System.currentTimeMillis();
        b();
        WLogger.d("HeadBorderView", "加载 Path 耗时:" + (System.currentTimeMillis() - currentTimeMillis));
        if (this.k != null) {
            this.f.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, height, this.k, (float[]) null, Shader.TileMode.CLAMP));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
            setMeasuredDimension(100, 100);
        } else if (mode == Integer.MIN_VALUE) {
            setMeasuredDimension(100, size2);
        } else if (mode2 == Integer.MIN_VALUE) {
            setMeasuredDimension(size, 100);
        }
    }

    public void setWbCloudFacePathListener(com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.b bVar) {
        this.n = bVar;
    }
}
