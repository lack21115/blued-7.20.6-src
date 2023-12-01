package me.itangqi.waveloadingview;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import me.itangqi.library.R;

/* loaded from: source-3503164-dex2jar.jar:me/itangqi/waveloadingview/WaveLoadingView.class */
public class WaveLoadingView extends View {

    /* renamed from: a  reason: collision with root package name */
    private static final int f43650a = Color.parseColor("#212121");
    private static final int b = Color.parseColor("#00000000");

    /* renamed from: c  reason: collision with root package name */
    private static final int f43651c = Color.parseColor("#212121");
    private static final int d = ShapeType.CIRCLE.ordinal();
    private static final int e = TriangleDirection.NORTH.ordinal();
    private Paint A;
    private Paint B;
    private Paint C;
    private Paint D;
    private Paint E;
    private Paint F;
    private Paint G;
    private Paint H;
    private ObjectAnimator I;
    private AnimatorSet J;
    private Context K;
    private int f;
    private int g;
    private int h;
    private float i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private String o;
    private String p;
    private String q;
    private float r;
    private float s;
    private float t;
    private int u;
    private boolean v;
    private BitmapShader w;
    private Bitmap x;
    private Matrix y;
    private Paint z;

    /* loaded from: source-3503164-dex2jar.jar:me/itangqi/waveloadingview/WaveLoadingView$ShapeType.class */
    public enum ShapeType {
        TRIANGLE,
        CIRCLE,
        SQUARE,
        RECTANGLE
    }

    /* loaded from: source-3503164-dex2jar.jar:me/itangqi/waveloadingview/WaveLoadingView$TriangleDirection.class */
    public enum TriangleDirection {
        NORTH,
        SOUTH,
        EAST,
        WEST
    }

    public WaveLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WaveLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.s = 1.0f;
        this.t = 0.0f;
        this.u = 50;
        a(context, attributeSet, i);
    }

    private int a(float f) {
        return (int) ((f * this.K.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    private int a(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824 && mode != Integer.MIN_VALUE) {
            return this.h;
        }
        return size;
    }

    private int a(int i, float f) {
        return Color.argb(Math.round(Color.alpha(i) * f), Color.red(i), Color.green(i), Color.blue(i));
    }

    private Path a(Point point, int i, int i2, int i3) {
        Point point2;
        Point point3 = null;
        if (i3 == 0) {
            point3 = new Point(point.x + i, point.y);
            double d2 = i2;
            point2 = new Point(point.x + (i / 2), (int) (d2 - ((Math.sqrt(3.0d) / 2.0d) * d2)));
        } else if (i3 == 1) {
            point3 = new Point(point.x, point.y - i2);
            point2 = new Point(point.x + i, point.y - i2);
            point.x += i / 2;
            point.y = (int) ((Math.sqrt(3.0d) / 2.0d) * i2);
        } else if (i3 == 2) {
            point3 = new Point(point.x, point.y - i2);
            point2 = new Point((int) ((Math.sqrt(3.0d) / 2.0d) * i), point.y / 2);
        } else if (i3 == 3) {
            point3 = new Point(point.x + i, point.y - i2);
            point2 = new Point(point.x + i, point.y);
            double d3 = i;
            point.x = (int) (d3 - ((Math.sqrt(3.0d) / 2.0d) * d3));
            point.y /= 2;
        } else {
            point2 = null;
        }
        Path path = new Path();
        path.moveTo(point.x, point.y);
        path.lineTo(point3.x, point3.y);
        path.lineTo(point2.x, point2.y);
        return path;
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        this.K = context;
        this.y = new Matrix();
        Paint paint = new Paint();
        this.z = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.A = paint2;
        paint2.setAntiAlias(true);
        e();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WaveLoadingView, i, 0);
        this.l = obtainStyledAttributes.getInteger(R.styleable.WaveLoadingView_wlv_shapeType, d);
        this.k = obtainStyledAttributes.getColor(R.styleable.WaveLoadingView_wlv_waveColor, f43650a);
        int color = obtainStyledAttributes.getColor(R.styleable.WaveLoadingView_wlv_wave_background_Color, b);
        this.j = color;
        this.A.setColor(color);
        float f = obtainStyledAttributes.getFloat(R.styleable.WaveLoadingView_wlv_waveAmplitude, 50.0f) / 1000.0f;
        float f2 = f;
        if (f > 0.1f) {
            f2 = 0.1f;
        }
        this.i = f2;
        int integer = obtainStyledAttributes.getInteger(R.styleable.WaveLoadingView_wlv_progressValue, 50);
        this.u = integer;
        setProgressValue(integer);
        this.v = obtainStyledAttributes.getBoolean(R.styleable.WaveLoadingView_wlv_round_rectangle, false);
        this.n = obtainStyledAttributes.getInteger(R.styleable.WaveLoadingView_wlv_round_rectangle_x_and_y, 30);
        this.m = obtainStyledAttributes.getInteger(R.styleable.WaveLoadingView_wlv_triangle_direction, e);
        Paint paint3 = new Paint();
        this.B = paint3;
        paint3.setAntiAlias(true);
        this.B.setStyle(Paint.Style.STROKE);
        this.B.setStrokeWidth(obtainStyledAttributes.getDimension(R.styleable.WaveLoadingView_wlv_borderWidth, b(0.0f)));
        this.B.setColor(obtainStyledAttributes.getColor(R.styleable.WaveLoadingView_wlv_borderColor, f43650a));
        Paint paint4 = new Paint();
        this.C = paint4;
        paint4.setColor(obtainStyledAttributes.getColor(R.styleable.WaveLoadingView_wlv_titleTopColor, f43651c));
        this.C.setStyle(Paint.Style.FILL);
        this.C.setAntiAlias(true);
        this.C.setTextSize(obtainStyledAttributes.getDimension(R.styleable.WaveLoadingView_wlv_titleTopSize, a(18.0f)));
        Paint paint5 = new Paint();
        this.F = paint5;
        paint5.setColor(obtainStyledAttributes.getColor(R.styleable.WaveLoadingView_wlv_titleTopStrokeColor, 0));
        this.F.setStrokeWidth(obtainStyledAttributes.getDimension(R.styleable.WaveLoadingView_wlv_titleTopStrokeWidth, b(0.0f)));
        this.F.setStyle(Paint.Style.STROKE);
        this.F.setAntiAlias(true);
        this.F.setTextSize(this.C.getTextSize());
        this.o = obtainStyledAttributes.getString(R.styleable.WaveLoadingView_wlv_titleTop);
        Paint paint6 = new Paint();
        this.E = paint6;
        paint6.setColor(obtainStyledAttributes.getColor(R.styleable.WaveLoadingView_wlv_titleCenterColor, f43651c));
        this.E.setStyle(Paint.Style.FILL);
        this.E.setAntiAlias(true);
        this.E.setTextSize(obtainStyledAttributes.getDimension(R.styleable.WaveLoadingView_wlv_titleCenterSize, a(22.0f)));
        Paint paint7 = new Paint();
        this.H = paint7;
        paint7.setColor(obtainStyledAttributes.getColor(R.styleable.WaveLoadingView_wlv_titleCenterStrokeColor, 0));
        this.H.setStrokeWidth(obtainStyledAttributes.getDimension(R.styleable.WaveLoadingView_wlv_titleCenterStrokeWidth, b(0.0f)));
        this.H.setStyle(Paint.Style.STROKE);
        this.H.setAntiAlias(true);
        this.H.setTextSize(this.E.getTextSize());
        this.p = obtainStyledAttributes.getString(R.styleable.WaveLoadingView_wlv_titleCenter);
        Paint paint8 = new Paint();
        this.D = paint8;
        paint8.setColor(obtainStyledAttributes.getColor(R.styleable.WaveLoadingView_wlv_titleBottomColor, f43651c));
        this.D.setStyle(Paint.Style.FILL);
        this.D.setAntiAlias(true);
        this.D.setTextSize(obtainStyledAttributes.getDimension(R.styleable.WaveLoadingView_wlv_titleBottomSize, a(18.0f)));
        Paint paint9 = new Paint();
        this.G = paint9;
        paint9.setColor(obtainStyledAttributes.getColor(R.styleable.WaveLoadingView_wlv_titleBottomStrokeColor, 0));
        this.G.setStrokeWidth(obtainStyledAttributes.getDimension(R.styleable.WaveLoadingView_wlv_titleBottomStrokeWidth, b(0.0f)));
        this.G.setStyle(Paint.Style.STROKE);
        this.G.setAntiAlias(true);
        this.G.setTextSize(this.D.getTextSize());
        this.q = obtainStyledAttributes.getString(R.styleable.WaveLoadingView_wlv_titleBottom);
        obtainStyledAttributes.recycle();
    }

    private int b(float f) {
        return (int) ((f * this.K.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private int b(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824 && mode != Integer.MIN_VALUE) {
            size = this.g;
        }
        return size + 2;
    }

    private void c() {
        float f;
        if (this.x != null && !d()) {
            return;
        }
        Bitmap bitmap = this.x;
        if (bitmap != null) {
            bitmap.recycle();
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            return;
        }
        double d2 = 6.283185307179586d / measuredWidth;
        this.r = measuredHeight * 0.5f;
        float f2 = measuredWidth;
        Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setStrokeWidth(2.0f);
        paint.setAntiAlias(true);
        int i = measuredWidth + 1;
        int i2 = measuredHeight + 1;
        float[] fArr = new float[i];
        paint.setColor(a(this.k, 0.3f));
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i) {
                break;
            }
            float sin = (float) (this.r + (0.1f * f * Math.sin(i4 * d2)));
            float f3 = i4;
            canvas.drawLine(f3, sin, f3, i2, paint);
            fArr[i4] = sin;
            i3 = i4 + 1;
        }
        paint.setColor(this.k);
        int i5 = (int) (f2 / 4.0f);
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= i) {
                BitmapShader bitmapShader = new BitmapShader(createBitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
                this.w = bitmapShader;
                this.z.setShader(bitmapShader);
                return;
            }
            float f4 = i7;
            canvas.drawLine(f4, fArr[(i7 + i5) % i], f4, i2, paint);
            i6 = i7 + 1;
        }
    }

    private boolean d() {
        return (getMeasuredWidth() == this.x.getWidth() && getMeasuredHeight() == this.x.getHeight()) ? false : true;
    }

    private void e() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "waveShiftRatio", 0.0f, 1.0f);
        this.I = ofFloat;
        ofFloat.setRepeatCount(-1);
        this.I.setDuration(1000L);
        this.I.setInterpolator(new LinearInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        this.J = animatorSet;
        animatorSet.play(this.I);
    }

    public void a() {
        AnimatorSet animatorSet = this.J;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    public void b() {
        AnimatorSet animatorSet = this.J;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public float getAmplitudeRatio() {
        return this.i;
    }

    public int getBorderColor() {
        return this.B.getColor();
    }

    public float getBorderWidth() {
        return this.B.getStrokeWidth();
    }

    public String getBottomTitle() {
        return this.q;
    }

    public int getBottomTitleColor() {
        return this.D.getColor();
    }

    public float getBottomTitleSize() {
        return this.D.getTextSize();
    }

    public String getCenterTitle() {
        return this.p;
    }

    public int getCenterTitleColor() {
        return this.E.getColor();
    }

    public float getCenterTitleSize() {
        return this.E.getTextSize();
    }

    public int getProgressValue() {
        return this.u;
    }

    public int getShapeType() {
        return this.l;
    }

    public String getTopTitle() {
        return this.o;
    }

    public int getTopTitleColor() {
        return this.C.getColor();
    }

    public float getWaterLevelRatio() {
        return this.s;
    }

    public int getWaveBgColor() {
        return this.j;
    }

    public int getWaveColor() {
        return this.k;
    }

    public float getWaveShiftRatio() {
        return this.t;
    }

    public float getsetTopTitleSize() {
        return this.C.getTextSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onAttachedToWindow() {
        a();
        super.onAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        b();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.f = canvas.getWidth();
        if (canvas.getHeight() < this.f) {
            this.f = canvas.getHeight();
        }
        if (this.w == null) {
            this.z.setShader(null);
            return;
        }
        if (this.z.getShader() == null) {
            this.z.setShader(this.w);
        }
        this.y.setScale(1.0f, this.i / 0.1f, 0.0f, this.r);
        this.y.postTranslate(this.t * getWidth(), (0.5f - this.s) * getHeight());
        this.w.setLocalMatrix(this.y);
        float strokeWidth = this.B.getStrokeWidth();
        int i = this.l;
        if (i == 0) {
            Path a2 = a(new Point(0, getHeight()), getWidth(), getHeight(), this.m);
            canvas.drawPath(a2, this.A);
            canvas.drawPath(a2, this.z);
        } else if (i == 1) {
            if (strokeWidth > 0.0f) {
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, ((getWidth() - strokeWidth) / 2.0f) - 1.0f, this.B);
            }
            float width = (getWidth() / 2.0f) - strokeWidth;
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, width, this.A);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, width, this.z);
        } else if (i == 2) {
            if (strokeWidth > 0.0f) {
                float f = strokeWidth / 2.0f;
                canvas.drawRect(f, f, (getWidth() - f) - 0.5f, (getHeight() - f) - 0.5f, this.B);
            }
            canvas.drawRect(strokeWidth, strokeWidth, getWidth() - strokeWidth, getHeight() - strokeWidth, this.A);
            canvas.drawRect(strokeWidth, strokeWidth, getWidth() - strokeWidth, getHeight() - strokeWidth, this.z);
        } else if (i == 3) {
            if (this.v) {
                if (strokeWidth > 0.0f) {
                    float f2 = strokeWidth / 2.0f;
                    RectF rectF = new RectF(f2, f2, (getWidth() - f2) - 0.5f, (getHeight() - f2) - 0.5f);
                    int i2 = this.n;
                    canvas.drawRoundRect(rectF, i2, i2, this.A);
                    int i3 = this.n;
                    canvas.drawRoundRect(rectF, i3, i3, this.z);
                } else {
                    RectF rectF2 = new RectF(0.0f, 0.0f, getWidth(), getHeight());
                    int i4 = this.n;
                    canvas.drawRoundRect(rectF2, i4, i4, this.A);
                    int i5 = this.n;
                    canvas.drawRoundRect(rectF2, i5, i5, this.z);
                }
            } else if (strokeWidth > 0.0f) {
                float f3 = strokeWidth / 2.0f;
                canvas.drawRect(f3, f3, (getWidth() - f3) - 0.5f, (getHeight() - f3) - 0.5f, this.A);
                canvas.drawRect(f3, f3, (getWidth() - f3) - 0.5f, (getHeight() - f3) - 0.5f, this.z);
            } else {
                canvas.drawRect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.A);
                canvas.drawRect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.z);
            }
        }
        if (!TextUtils.isEmpty(this.o)) {
            float measureText = this.C.measureText(this.o);
            canvas.drawText(this.o, (getWidth() - measureText) / 2.0f, (getHeight() * 2) / 10.0f, this.F);
            canvas.drawText(this.o, (getWidth() - measureText) / 2.0f, (getHeight() * 2) / 10.0f, this.C);
        }
        if (!TextUtils.isEmpty(this.p)) {
            float measureText2 = this.E.measureText(this.p);
            canvas.drawText(this.p, (getWidth() - measureText2) / 2.0f, (getHeight() / 2) - ((this.H.descent() + this.H.ascent()) / 2.0f), this.H);
            canvas.drawText(this.p, (getWidth() - measureText2) / 2.0f, (getHeight() / 2) - ((this.E.descent() + this.E.ascent()) / 2.0f), this.E);
        }
        if (TextUtils.isEmpty(this.q)) {
            return;
        }
        float measureText3 = this.D.measureText(this.q);
        canvas.drawText(this.q, (getWidth() - measureText3) / 2.0f, ((getHeight() * 8) / 10.0f) - ((this.G.descent() + this.G.ascent()) / 2.0f), this.G);
        canvas.drawText(this.q, (getWidth() - measureText3) / 2.0f, ((getHeight() * 8) / 10.0f) - ((this.D.descent() + this.D.ascent()) / 2.0f), this.D);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int a2 = a(i);
        int b2 = b(i2);
        if (getShapeType() == 3) {
            setMeasuredDimension(a2, b2);
            return;
        }
        if (a2 >= b2) {
            a2 = b2;
        }
        setMeasuredDimension(a2, a2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (getShapeType() == 3) {
            this.h = i;
            this.g = i2;
        } else {
            this.f = i;
            if (i2 < i) {
                this.f = i2;
            }
        }
        c();
    }

    public void setAmplitudeRatio(int i) {
        float f = i / 1000.0f;
        if (this.i != f) {
            this.i = f;
            invalidate();
        }
    }

    public void setAnimDuration(long j) {
        this.I.setDuration(j);
    }

    public void setBorderColor(int i) {
        this.B.setColor(i);
        c();
        invalidate();
    }

    public void setBorderWidth(float f) {
        this.B.setStrokeWidth(f);
        invalidate();
    }

    public void setBottomTitle(String str) {
        this.q = str;
    }

    public void setBottomTitleColor(int i) {
        this.D.setColor(i);
    }

    public void setBottomTitleSize(float f) {
        this.D.setTextSize(a(f));
    }

    public void setBottomTitleStrokeColor(int i) {
        this.G.setColor(i);
    }

    public void setBottomTitleStrokeWidth(float f) {
        this.G.setStrokeWidth(b(f));
    }

    public void setCenterTitle(String str) {
        this.p = str;
    }

    public void setCenterTitleColor(int i) {
        this.E.setColor(i);
    }

    public void setCenterTitleSize(float f) {
        this.E.setTextSize(a(f));
    }

    public void setCenterTitleStrokeColor(int i) {
        this.H.setColor(i);
    }

    public void setCenterTitleStrokeWidth(float f) {
        this.H.setStrokeWidth(b(f));
    }

    public void setProgressValue(int i) {
        this.u = i;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "waterLevelRatio", this.s, i / 100.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat);
        animatorSet.start();
    }

    public void setShapeType(ShapeType shapeType) {
        this.l = shapeType.ordinal();
        invalidate();
    }

    public void setTopTitle(String str) {
        this.o = str;
    }

    public void setTopTitleColor(int i) {
        this.C.setColor(i);
    }

    public void setTopTitleSize(float f) {
        this.C.setTextSize(a(f));
    }

    public void setTopTitleStrokeColor(int i) {
        this.F.setColor(i);
    }

    public void setTopTitleStrokeWidth(float f) {
        this.F.setStrokeWidth(b(f));
    }

    public void setWaterLevelRatio(float f) {
        if (this.s != f) {
            this.s = f;
            invalidate();
        }
    }

    public void setWaveBgColor(int i) {
        this.j = i;
        this.A.setColor(i);
        c();
        invalidate();
    }

    public void setWaveColor(int i) {
        this.k = i;
        c();
        invalidate();
    }

    public void setWaveShiftRatio(float f) {
        if (this.t != f) {
            this.t = f;
            invalidate();
        }
    }
}
