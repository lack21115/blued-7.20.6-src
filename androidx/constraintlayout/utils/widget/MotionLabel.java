package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.FloatLayout;
import androidx.constraintlayout.widget.R;
import com.google.android.material.badge.BadgeDrawable;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/utils/widget/MotionLabel.class */
public class MotionLabel extends View implements FloatLayout {

    /* renamed from: a  reason: collision with root package name */
    static String f2242a = "MotionLabel";
    private Rect A;
    private int B;
    private int C;
    private int D;
    private int E;
    private String F;
    private Layout G;
    private int H;
    private int I;
    private boolean J;
    private float K;
    private float L;
    private float M;
    private Drawable N;
    private Bitmap O;
    private BitmapShader P;
    private Matrix Q;
    private float R;
    private float S;
    private float T;
    private float U;
    private int V;
    TextPaint b;

    /* renamed from: c  reason: collision with root package name */
    Path f2243c;
    ViewOutlineProvider d;
    RectF e;
    boolean f;
    Matrix g;
    Paint h;
    Rect i;
    Paint j;
    float k;
    float l;
    float m;
    float n;
    float o;
    private int p;
    private int q;
    private boolean r;
    private float s;
    private float t;
    private float u;
    private float v;
    private int w;
    private int x;
    private float y;
    private String z;

    public MotionLabel(Context context) {
        super(context);
        this.b = new TextPaint();
        this.f2243c = new Path();
        this.p = 65535;
        this.q = 65535;
        this.r = false;
        this.s = 0.0f;
        this.t = Float.NaN;
        this.u = 48.0f;
        this.v = Float.NaN;
        this.y = 0.0f;
        this.z = "Hello World";
        this.f = true;
        this.A = new Rect();
        this.B = 1;
        this.C = 1;
        this.D = 1;
        this.E = 1;
        this.H = BadgeDrawable.TOP_START;
        this.I = 0;
        this.J = false;
        this.R = Float.NaN;
        this.S = Float.NaN;
        this.T = 0.0f;
        this.U = 0.0f;
        this.h = new Paint();
        this.V = 0;
        this.l = Float.NaN;
        this.m = Float.NaN;
        this.n = Float.NaN;
        this.o = Float.NaN;
        a(context, (AttributeSet) null);
    }

    public MotionLabel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new TextPaint();
        this.f2243c = new Path();
        this.p = 65535;
        this.q = 65535;
        this.r = false;
        this.s = 0.0f;
        this.t = Float.NaN;
        this.u = 48.0f;
        this.v = Float.NaN;
        this.y = 0.0f;
        this.z = "Hello World";
        this.f = true;
        this.A = new Rect();
        this.B = 1;
        this.C = 1;
        this.D = 1;
        this.E = 1;
        this.H = BadgeDrawable.TOP_START;
        this.I = 0;
        this.J = false;
        this.R = Float.NaN;
        this.S = Float.NaN;
        this.T = 0.0f;
        this.U = 0.0f;
        this.h = new Paint();
        this.V = 0;
        this.l = Float.NaN;
        this.m = Float.NaN;
        this.n = Float.NaN;
        this.o = Float.NaN;
        a(context, attributeSet);
    }

    public MotionLabel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new TextPaint();
        this.f2243c = new Path();
        this.p = 65535;
        this.q = 65535;
        this.r = false;
        this.s = 0.0f;
        this.t = Float.NaN;
        this.u = 48.0f;
        this.v = Float.NaN;
        this.y = 0.0f;
        this.z = "Hello World";
        this.f = true;
        this.A = new Rect();
        this.B = 1;
        this.C = 1;
        this.D = 1;
        this.E = 1;
        this.H = BadgeDrawable.TOP_START;
        this.I = 0;
        this.J = false;
        this.R = Float.NaN;
        this.S = Float.NaN;
        this.T = 0.0f;
        this.U = 0.0f;
        this.h = new Paint();
        this.V = 0;
        this.l = Float.NaN;
        this.m = Float.NaN;
        this.n = Float.NaN;
        this.o = Float.NaN;
        a(context, attributeSet);
    }

    private void a(float f, float f2, float f3, float f4) {
        if (this.Q == null) {
            return;
        }
        this.L = f3 - f;
        this.M = f4 - f2;
        c();
    }

    private void a(Context context, AttributeSet attributeSet) {
        b(context, attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionLabel);
            int indexCount = obtainStyledAttributes.getIndexCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= indexCount) {
                    break;
                }
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.MotionLabel_android_text) {
                    setText(obtainStyledAttributes.getText(index));
                } else if (index == R.styleable.MotionLabel_android_fontFamily) {
                    this.F = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.MotionLabel_scaleFromTextSize) {
                    this.v = obtainStyledAttributes.getDimensionPixelSize(index, (int) this.v);
                } else if (index == R.styleable.MotionLabel_android_textSize) {
                    this.u = obtainStyledAttributes.getDimensionPixelSize(index, (int) this.u);
                } else if (index == R.styleable.MotionLabel_android_textStyle) {
                    this.w = obtainStyledAttributes.getInt(index, this.w);
                } else if (index == R.styleable.MotionLabel_android_typeface) {
                    this.x = obtainStyledAttributes.getInt(index, this.x);
                } else if (index == R.styleable.MotionLabel_android_textColor) {
                    this.p = obtainStyledAttributes.getColor(index, this.p);
                } else if (index == R.styleable.MotionLabel_borderRound) {
                    this.t = obtainStyledAttributes.getDimension(index, this.t);
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRound(this.t);
                    }
                } else if (index == R.styleable.MotionLabel_borderRoundPercent) {
                    this.s = obtainStyledAttributes.getFloat(index, this.s);
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRoundPercent(this.s);
                    }
                } else if (index == R.styleable.MotionLabel_android_gravity) {
                    setGravity(obtainStyledAttributes.getInt(index, -1));
                } else if (index == R.styleable.MotionLabel_android_autoSizeTextType) {
                    this.I = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.MotionLabel_textOutlineColor) {
                    this.q = obtainStyledAttributes.getInt(index, this.q);
                    this.r = true;
                } else if (index == R.styleable.MotionLabel_textOutlineThickness) {
                    this.y = obtainStyledAttributes.getDimension(index, this.y);
                    this.r = true;
                } else if (index == R.styleable.MotionLabel_textBackground) {
                    this.N = obtainStyledAttributes.getDrawable(index);
                    this.r = true;
                } else if (index == R.styleable.MotionLabel_textBackgroundPanX) {
                    this.l = obtainStyledAttributes.getFloat(index, this.l);
                } else if (index == R.styleable.MotionLabel_textBackgroundPanY) {
                    this.m = obtainStyledAttributes.getFloat(index, this.m);
                } else if (index == R.styleable.MotionLabel_textPanX) {
                    this.T = obtainStyledAttributes.getFloat(index, this.T);
                } else if (index == R.styleable.MotionLabel_textPanY) {
                    this.U = obtainStyledAttributes.getFloat(index, this.U);
                } else if (index == R.styleable.MotionLabel_textBackgroundRotate) {
                    this.o = obtainStyledAttributes.getFloat(index, this.o);
                } else if (index == R.styleable.MotionLabel_textBackgroundZoom) {
                    this.n = obtainStyledAttributes.getFloat(index, this.n);
                } else if (index == R.styleable.MotionLabel_textureHeight) {
                    this.R = obtainStyledAttributes.getDimension(index, this.R);
                } else if (index == R.styleable.MotionLabel_textureWidth) {
                    this.S = obtainStyledAttributes.getDimension(index, this.S);
                } else if (index == R.styleable.MotionLabel_textureEffect) {
                    this.V = obtainStyledAttributes.getInt(index, this.V);
                }
                i = i2 + 1;
            }
            obtainStyledAttributes.recycle();
        }
        b();
        a();
    }

    private void a(String str, int i, int i2) {
        Typeface typeface;
        if (str != null) {
            Typeface create = Typeface.create(str, i2);
            typeface = create;
            if (create != null) {
                setTypeface(create);
                return;
            }
        } else {
            typeface = null;
        }
        boolean z = true;
        if (i == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i == 2) {
            typeface = Typeface.SERIF;
        } else if (i == 3) {
            typeface = Typeface.MONOSPACE;
        }
        float f = 0.0f;
        if (i2 <= 0) {
            this.b.setFakeBoldText(false);
            this.b.setTextSkewX(0.0f);
            setTypeface(typeface);
            return;
        }
        Typeface defaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i2) : Typeface.create(typeface, i2);
        setTypeface(defaultFromStyle);
        int style = (defaultFromStyle != null ? defaultFromStyle.getStyle() : 0) & i2;
        TextPaint textPaint = this.b;
        if ((style & 1) == 0) {
            z = false;
        }
        textPaint.setFakeBoldText(z);
        TextPaint textPaint2 = this.b;
        if ((style & 2) != 0) {
            f = -0.25f;
        }
        textPaint2.setTextSkewX(f);
    }

    private void b() {
        if (this.N != null) {
            this.Q = new Matrix();
            int intrinsicWidth = this.N.getIntrinsicWidth();
            int intrinsicHeight = this.N.getIntrinsicHeight();
            int i = intrinsicWidth;
            if (intrinsicWidth <= 0) {
                int width = getWidth();
                i = width;
                if (width == 0) {
                    i = Float.isNaN(this.S) ? 128 : (int) this.S;
                }
            }
            int i2 = intrinsicHeight;
            if (intrinsicHeight <= 0) {
                int height = getHeight();
                i2 = height;
                if (height == 0) {
                    i2 = Float.isNaN(this.R) ? 128 : (int) this.R;
                }
            }
            int i3 = i;
            int i4 = i2;
            if (this.V != 0) {
                i3 = i / 2;
                i4 = i2 / 2;
            }
            this.O = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.O);
            this.N.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            this.N.setFilterBitmap(true);
            this.N.draw(canvas);
            if (this.V != 0) {
                this.O = a(this.O, 4);
            }
            this.P = new BitmapShader(this.O, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        }
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true);
        TextPaint textPaint = this.b;
        int i = typedValue.data;
        this.p = i;
        textPaint.setColor(i);
    }

    private void c() {
        float f = 0.0f;
        float f2 = Float.isNaN(this.l) ? 0.0f : this.l;
        float f3 = Float.isNaN(this.m) ? 0.0f : this.m;
        float f4 = Float.isNaN(this.n) ? 1.0f : this.n;
        if (!Float.isNaN(this.o)) {
            f = this.o;
        }
        this.Q.reset();
        float width = this.O.getWidth();
        float height = this.O.getHeight();
        float f5 = Float.isNaN(this.S) ? this.L : this.S;
        float f6 = Float.isNaN(this.R) ? this.M : this.R;
        float f7 = f4 * (width * f6 < height * f5 ? f5 / width : f6 / height);
        this.Q.postScale(f7, f7);
        float f8 = width * f7;
        float f9 = f5 - f8;
        float f10 = f7 * height;
        float f11 = f6 - f10;
        if (!Float.isNaN(this.R)) {
            f11 = this.R / 2.0f;
        }
        if (!Float.isNaN(this.S)) {
            f9 = this.S / 2.0f;
        }
        this.Q.postTranslate((((f2 * f9) + f5) - f8) * 0.5f, (((f3 * f11) + f6) - f10) * 0.5f);
        this.Q.postRotate(f, f5 / 2.0f, f6 / 2.0f);
        this.P.setLocalMatrix(this.Q);
    }

    private float getHorizontalOffset() {
        float f = Float.isNaN(this.v) ? 1.0f : this.u / this.v;
        TextPaint textPaint = this.b;
        String str = this.z;
        return (((((Float.isNaN(this.L) ? getMeasuredWidth() : this.L) - getPaddingLeft()) - getPaddingRight()) - (f * textPaint.measureText(str, 0, str.length()))) * (this.T + 1.0f)) / 2.0f;
    }

    private float getVerticalOffset() {
        float f = Float.isNaN(this.v) ? 1.0f : this.u / this.v;
        Paint.FontMetrics fontMetrics = this.b.getFontMetrics();
        return ((((((Float.isNaN(this.M) ? getMeasuredHeight() : this.M) - getPaddingTop()) - getPaddingBottom()) - ((fontMetrics.descent - fontMetrics.ascent) * f)) * (1.0f - this.U)) / 2.0f) - (f * fontMetrics.ascent);
    }

    Bitmap a(Bitmap bitmap, int i) {
        System.nanoTime();
        int width = bitmap.getWidth() / 2;
        int height = bitmap.getHeight() / 2;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i || width < 32) {
                break;
            } else if (height < 32) {
                return createScaledBitmap;
            } else {
                width /= 2;
                height /= 2;
                createScaledBitmap = Bitmap.createScaledBitmap(createScaledBitmap, width, height, true);
                i2 = i3 + 1;
            }
        }
        return createScaledBitmap;
    }

    void a() {
        this.B = getPaddingLeft();
        this.C = getPaddingRight();
        this.D = getPaddingTop();
        this.E = getPaddingBottom();
        a(this.F, this.x, this.w);
        this.b.setColor(this.p);
        this.b.setStrokeWidth(this.y);
        this.b.setStyle(Paint.Style.FILL_AND_STROKE);
        this.b.setFlags(128);
        setTextSize(this.u);
        this.b.setAntiAlias(true);
    }

    void a(float f) {
        if (this.r || f != 1.0f) {
            this.f2243c.reset();
            String str = this.z;
            int length = str.length();
            this.b.getTextBounds(str, 0, length, this.A);
            this.b.getTextPath(str, 0, length, 0.0f, 0.0f, this.f2243c);
            if (f != 1.0f) {
                Log.v(f2242a, Debug.getLoc() + " scale " + f);
                Matrix matrix = new Matrix();
                matrix.postScale(f, f);
                this.f2243c.transform(matrix);
            }
            this.A.right--;
            this.A.left++;
            this.A.bottom++;
            this.A.top--;
            RectF rectF = new RectF();
            rectF.bottom = getHeight();
            rectF.right = getWidth();
            this.f = false;
        }
    }

    public float getRound() {
        return this.t;
    }

    public float getRoundPercent() {
        return this.s;
    }

    public float getScaleFromTextSize() {
        return this.v;
    }

    public float getTextBackgroundPanX() {
        return this.l;
    }

    public float getTextBackgroundPanY() {
        return this.m;
    }

    public float getTextBackgroundRotate() {
        return this.o;
    }

    public float getTextBackgroundZoom() {
        return this.n;
    }

    public int getTextOutlineColor() {
        return this.q;
    }

    public float getTextPanX() {
        return this.T;
    }

    public float getTextPanY() {
        return this.U;
    }

    public float getTextureHeight() {
        return this.R;
    }

    public float getTextureWidth() {
        return this.S;
    }

    public Typeface getTypeface() {
        return this.b.getTypeface();
    }

    @Override // androidx.constraintlayout.motion.widget.FloatLayout
    public void layout(float f, float f2, float f3, float f4) {
        int i = (int) (f + 0.5f);
        this.K = f - i;
        int i2 = (int) (f3 + 0.5f);
        int i3 = i2 - i;
        int i4 = (int) (f4 + 0.5f);
        int i5 = (int) (0.5f + f2);
        int i6 = i4 - i5;
        float f5 = f3 - f;
        this.L = f5;
        float f6 = f4 - f2;
        this.M = f6;
        a(f, f2, f3, f4);
        if (getMeasuredHeight() == i6 && getMeasuredWidth() == i3) {
            super.layout(i, i5, i2, i4);
        } else {
            measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(i6, 1073741824));
            super.layout(i, i5, i2, i4);
        }
        if (this.J) {
            if (this.i == null) {
                this.j = new Paint();
                this.i = new Rect();
                this.j.set(this.b);
                this.k = this.j.getTextSize();
            }
            this.L = f5;
            this.M = f6;
            Paint paint = this.j;
            String str = this.z;
            paint.getTextBounds(str, 0, str.length(), this.i);
            float height = this.i.height() * 1.3f;
            float f7 = (f5 - this.C) - this.B;
            float f8 = (f6 - this.E) - this.D;
            float width = this.i.width();
            if (width * f8 > height * f7) {
                this.b.setTextSize((this.k * f7) / width);
            } else {
                this.b.setTextSize((this.k * f8) / height);
            }
            if (this.r || !Float.isNaN(this.v)) {
                a(Float.isNaN(this.v) ? 1.0f : this.u / this.v);
            }
        }
    }

    @Override // android.view.View
    public void layout(int i, int i2, int i3, int i4) {
        super.layout(i, i2, i3, i4);
        boolean isNaN = Float.isNaN(this.v);
        float f = isNaN ? 1.0f : this.u / this.v;
        this.L = i3 - i;
        this.M = i4 - i2;
        float f2 = f;
        if (this.J) {
            if (this.i == null) {
                this.j = new Paint();
                this.i = new Rect();
                this.j.set(this.b);
                this.k = this.j.getTextSize();
            }
            Paint paint = this.j;
            String str = this.z;
            paint.getTextBounds(str, 0, str.length(), this.i);
            int width = this.i.width();
            int height = (int) (this.i.height() * 1.3f);
            float f3 = (this.L - this.C) - this.B;
            float f4 = (this.M - this.E) - this.D;
            if (isNaN) {
                float f5 = width;
                float f6 = height;
                if (f5 * f4 > f6 * f3) {
                    this.b.setTextSize((this.k * f3) / f5);
                    f2 = f;
                } else {
                    this.b.setTextSize((this.k * f4) / f6);
                    f2 = f;
                }
            } else {
                float f7 = width;
                float f8 = height;
                f2 = f7 * f4 > f8 * f3 ? f3 / f7 : f4 / f8;
            }
        }
        if (this.r || !isNaN) {
            a(i, i2, i3, i4);
            a(f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f = Float.isNaN(this.v) ? 1.0f : this.u / this.v;
        super.onDraw(canvas);
        if (!this.r && f == 1.0f) {
            canvas.drawText(this.z, this.K + this.B + getHorizontalOffset(), this.D + getVerticalOffset(), this.b);
            return;
        }
        if (this.f) {
            a(f);
        }
        if (this.g == null) {
            this.g = new Matrix();
        }
        if (!this.r) {
            float horizontalOffset = this.B + getHorizontalOffset();
            float verticalOffset = this.D + getVerticalOffset();
            this.g.reset();
            this.g.preTranslate(horizontalOffset, verticalOffset);
            this.f2243c.transform(this.g);
            this.b.setColor(this.p);
            this.b.setStyle(Paint.Style.FILL_AND_STROKE);
            this.b.setStrokeWidth(this.y);
            canvas.drawPath(this.f2243c, this.b);
            this.g.reset();
            this.g.preTranslate(-horizontalOffset, -verticalOffset);
            this.f2243c.transform(this.g);
            return;
        }
        this.h.set(this.b);
        this.g.reset();
        float horizontalOffset2 = this.B + getHorizontalOffset();
        float verticalOffset2 = this.D + getVerticalOffset();
        this.g.postTranslate(horizontalOffset2, verticalOffset2);
        this.g.preScale(f, f);
        this.f2243c.transform(this.g);
        if (this.P != null) {
            this.b.setFilterBitmap(true);
            this.b.setShader(this.P);
        } else {
            this.b.setColor(this.p);
        }
        this.b.setStyle(Paint.Style.FILL);
        this.b.setStrokeWidth(this.y);
        canvas.drawPath(this.f2243c, this.b);
        if (this.P != null) {
            this.b.setShader(null);
        }
        this.b.setColor(this.q);
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setStrokeWidth(this.y);
        canvas.drawPath(this.f2243c, this.b);
        this.g.reset();
        this.g.postTranslate(-horizontalOffset2, -verticalOffset2);
        this.f2243c.transform(this.g);
        this.b.set(this.h);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        this.J = false;
        this.B = getPaddingLeft();
        this.C = getPaddingRight();
        this.D = getPaddingTop();
        this.E = getPaddingBottom();
        if (mode == 1073741824 && mode2 == 1073741824) {
            i3 = size;
            i4 = size2;
            if (this.I != 0) {
                this.J = true;
                i3 = size;
                i4 = size2;
            }
        } else {
            TextPaint textPaint = this.b;
            String str = this.z;
            textPaint.getTextBounds(str, 0, str.length(), this.A);
            if (mode != 1073741824) {
                size = (int) (this.A.width() + 0.99999f);
            }
            int i5 = size + this.B + this.C;
            i3 = i5;
            i4 = size2;
            if (mode2 != 1073741824) {
                int fontMetricsInt = (int) (this.b.getFontMetricsInt(null) + 0.99999f);
                int i6 = fontMetricsInt;
                if (mode2 == Integer.MIN_VALUE) {
                    i6 = Math.min(size2, fontMetricsInt);
                }
                i4 = this.D + this.E + i6;
                i3 = i5;
            }
        }
        setMeasuredDimension(i3, i4);
    }

    public void setGravity(int i) {
        int i2 = i;
        if ((i & 8388615) == 0) {
            i2 = i | 8388611;
        }
        int i3 = i2;
        if ((i2 & 112) == 0) {
            i3 = i2 | 48;
        }
        int i4 = this.H;
        if (i3 != this.H) {
            invalidate();
        }
        this.H = i3;
        int i5 = i3 & 112;
        if (i5 == 48) {
            this.U = -1.0f;
        } else if (i5 != 80) {
            this.U = 0.0f;
        } else {
            this.U = 1.0f;
        }
        int i6 = this.H & 8388615;
        if (i6 != 3) {
            if (i6 != 5) {
                if (i6 != 8388611) {
                    if (i6 != 8388613) {
                        this.T = 0.0f;
                        return;
                    }
                }
            }
            this.T = 1.0f;
            return;
        }
        this.T = -1.0f;
    }

    public void setRound(float f) {
        if (Float.isNaN(f)) {
            this.t = f;
            float f2 = this.s;
            this.s = -1.0f;
            setRoundPercent(f2);
            return;
        }
        boolean z = this.t != f;
        this.t = f;
        if (f != 0.0f) {
            if (this.f2243c == null) {
                this.f2243c = new Path();
            }
            if (this.e == null) {
                this.e = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.d == null) {
                    ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.MotionLabel.2
                        @Override // android.view.ViewOutlineProvider
                        public void getOutline(View view, Outline outline) {
                            outline.setRoundRect(0, 0, MotionLabel.this.getWidth(), MotionLabel.this.getHeight(), MotionLabel.this.t);
                        }
                    };
                    this.d = viewOutlineProvider;
                    setOutlineProvider(viewOutlineProvider);
                }
                setClipToOutline(true);
            }
            this.e.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f2243c.reset();
            Path path = this.f2243c;
            RectF rectF = this.e;
            float f3 = this.t;
            path.addRoundRect(rectF, f3, f3, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (!z || Build.VERSION.SDK_INT < 21) {
            return;
        }
        invalidateOutline();
    }

    public void setRoundPercent(float f) {
        boolean z = this.s != f;
        this.s = f;
        if (f != 0.0f) {
            if (this.f2243c == null) {
                this.f2243c = new Path();
            }
            if (this.e == null) {
                this.e = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.d == null) {
                    ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.MotionLabel.1
                        @Override // android.view.ViewOutlineProvider
                        public void getOutline(View view, Outline outline) {
                            int width = MotionLabel.this.getWidth();
                            int height = MotionLabel.this.getHeight();
                            outline.setRoundRect(0, 0, width, height, (Math.min(width, height) * MotionLabel.this.s) / 2.0f);
                        }
                    };
                    this.d = viewOutlineProvider;
                    setOutlineProvider(viewOutlineProvider);
                }
                setClipToOutline(true);
            }
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.s) / 2.0f;
            this.e.set(0.0f, 0.0f, width, height);
            this.f2243c.reset();
            this.f2243c.addRoundRect(this.e, min, min, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (!z || Build.VERSION.SDK_INT < 21) {
            return;
        }
        invalidateOutline();
    }

    public void setScaleFromTextSize(float f) {
        this.v = f;
    }

    public void setText(CharSequence charSequence) {
        this.z = charSequence.toString();
        invalidate();
    }

    public void setTextBackgroundPanX(float f) {
        this.l = f;
        c();
        invalidate();
    }

    public void setTextBackgroundPanY(float f) {
        this.m = f;
        c();
        invalidate();
    }

    public void setTextBackgroundRotate(float f) {
        this.o = f;
        c();
        invalidate();
    }

    public void setTextBackgroundZoom(float f) {
        this.n = f;
        c();
        invalidate();
    }

    public void setTextFillColor(int i) {
        this.p = i;
        invalidate();
    }

    public void setTextOutlineColor(int i) {
        this.q = i;
        this.r = true;
        invalidate();
    }

    public void setTextOutlineThickness(float f) {
        this.y = f;
        this.r = true;
        if (Float.isNaN(f)) {
            this.y = 1.0f;
            this.r = false;
        }
        invalidate();
    }

    public void setTextPanX(float f) {
        this.T = f;
        invalidate();
    }

    public void setTextPanY(float f) {
        this.U = f;
        invalidate();
    }

    public void setTextSize(float f) {
        this.u = f;
        String str = f2242a;
        Log.v(str, Debug.getLoc() + "  " + f + " / " + this.v);
        TextPaint textPaint = this.b;
        if (!Float.isNaN(this.v)) {
            f = this.v;
        }
        textPaint.setTextSize(f);
        a(Float.isNaN(this.v) ? 1.0f : this.u / this.v);
        requestLayout();
        invalidate();
    }

    public void setTextureHeight(float f) {
        this.R = f;
        c();
        invalidate();
    }

    public void setTextureWidth(float f) {
        this.S = f;
        c();
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        if (this.b.getTypeface() != typeface) {
            this.b.setTypeface(typeface);
            if (this.G != null) {
                this.G = null;
                requestLayout();
                invalidate();
            }
        }
    }
}
