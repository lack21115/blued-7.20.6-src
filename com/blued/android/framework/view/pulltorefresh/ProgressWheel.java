package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.blued.android.framework.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/ProgressWheel.class */
public class ProgressWheel extends View {
    private int c;
    private int d;
    private int e;
    private final int f;
    private final int g;
    private boolean h;
    private double i;
    private double j;
    private float k;
    private boolean l;
    private long m;
    private final long n;
    private int o;
    private int p;
    private Paint q;
    private Paint r;
    private RectF s;
    private float t;
    private long u;
    private boolean v;
    private float w;
    private float x;
    private boolean y;
    private ProgressCallback z;
    private static final String b = ProgressWheel.class.getSimpleName();
    public static boolean a = false;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/ProgressWheel$ProgressCallback.class */
    public interface ProgressCallback {
        void a(float f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/ProgressWheel$WheelSavedState.class */
    public static class WheelSavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<WheelSavedState> CREATOR = new Parcelable.Creator<WheelSavedState>() { // from class: com.blued.android.framework.view.pulltorefresh.ProgressWheel.WheelSavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public WheelSavedState createFromParcel(Parcel parcel) {
                return new WheelSavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public WheelSavedState[] newArray(int i) {
                return new WheelSavedState[i];
            }
        };
        float a;
        float b;
        boolean c;
        float d;
        int e;
        int f;
        int g;
        int h;
        int i;
        boolean j;
        boolean k;

        private WheelSavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readFloat();
            this.b = parcel.readFloat();
            this.c = parcel.readByte() != 0;
            this.d = parcel.readFloat();
            this.e = parcel.readInt();
            this.f = parcel.readInt();
            this.g = parcel.readInt();
            this.h = parcel.readInt();
            this.i = parcel.readInt();
            this.j = parcel.readByte() != 0;
            this.k = parcel.readByte() != 0;
        }

        WheelSavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.a);
            parcel.writeFloat(this.b);
            parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
            parcel.writeFloat(this.d);
            parcel.writeInt(this.e);
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
            parcel.writeInt(this.h);
            parcel.writeInt(this.i);
            parcel.writeByte(this.j ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.k ? (byte) 1 : (byte) 0);
        }
    }

    public ProgressWheel(Context context) {
        super(context);
        this.c = 23;
        this.d = 3;
        this.e = 3;
        this.f = 36;
        this.g = 324;
        this.h = false;
        this.i = 0.0d;
        this.j = 460.0d;
        this.k = 0.0f;
        this.l = true;
        this.m = 0L;
        this.n = 200L;
        this.o = -1442840576;
        this.p = 16777215;
        this.q = new Paint();
        this.r = new Paint();
        this.s = new RectF();
        this.t = 230.0f;
        this.u = 0L;
        this.w = 0.0f;
        this.x = 0.0f;
        this.y = false;
    }

    public ProgressWheel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 23;
        this.d = 3;
        this.e = 3;
        this.f = 36;
        this.g = 324;
        this.h = false;
        this.i = 0.0d;
        this.j = 460.0d;
        this.k = 0.0f;
        this.l = true;
        this.m = 0L;
        this.n = 200L;
        this.o = -1442840576;
        this.p = 16777215;
        this.q = new Paint();
        this.r = new Paint();
        this.s = new RectF();
        this.t = 230.0f;
        this.u = 0L;
        this.w = 0.0f;
        this.x = 0.0f;
        this.y = false;
        a(context.obtainStyledAttributes(attributeSet, R.styleable.ProgressWheel));
    }

    private void a(float f) {
        ProgressCallback progressCallback = this.z;
        if (progressCallback != null) {
            progressCallback.a(f);
        }
    }

    private void a(int i, int i2) {
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        if (this.h) {
            int i3 = this.d;
            this.s = new RectF(paddingLeft + i3, paddingTop + i3, (i - paddingRight) - i3, (i2 - paddingBottom) - i3);
            return;
        }
        int i4 = (i - paddingLeft) - paddingRight;
        int min = Math.min(Math.min(i4, (i2 - paddingBottom) - paddingTop), (this.c * 2) - (this.d * 2));
        int i5 = ((i4 - min) / 2) + paddingLeft;
        int i6 = ((((i2 - paddingTop) - paddingBottom) - min) / 2) + paddingTop;
        int i7 = this.d;
        this.s = new RectF(i5 + i7, i6 + i7, (i5 + min) - i7, (i6 + min) - i7);
    }

    private void a(long j) {
        long j2 = this.m;
        if (j2 < 200) {
            this.m = j2 + j;
            return;
        }
        double d = this.i + j;
        this.i = d;
        double d2 = this.j;
        if (d > d2) {
            this.i = d - d2;
            this.m = 0L;
            this.l = !this.l;
        }
        float cos = (((float) Math.cos(((this.i / this.j) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f;
        if (this.l) {
            this.k = cos * 288.0f;
            return;
        }
        float f = (1.0f - cos) * 288.0f;
        this.w += this.k - f;
        this.k = f;
    }

    private void a(TypedArray typedArray) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.d = (int) TypedValue.applyDimension(1, this.d, displayMetrics);
        this.e = (int) TypedValue.applyDimension(1, this.e, displayMetrics);
        this.c = (int) TypedValue.applyDimension(1, this.c, displayMetrics);
        this.c = (int) typedArray.getDimension(R.styleable.ProgressWheel_matProg_circleRadius, this.c);
        this.h = typedArray.getBoolean(R.styleable.ProgressWheel_matProg_fillRadius, false);
        this.d = (int) typedArray.getDimension(R.styleable.ProgressWheel_matProg_barWidth, this.d);
        this.e = (int) typedArray.getDimension(R.styleable.ProgressWheel_matProg_rimWidth, this.e);
        this.t = typedArray.getFloat(R.styleable.ProgressWheel_matProg_spinSpeed, this.t / 360.0f) * 360.0f;
        this.j = typedArray.getInt(R.styleable.ProgressWheel_matProg_barSpinCycleTime, (int) this.j);
        this.o = typedArray.getColor(R.styleable.ProgressWheel_matProg_barColor, this.o);
        this.p = typedArray.getColor(R.styleable.ProgressWheel_matProg_rimColor, this.p);
        this.v = typedArray.getBoolean(R.styleable.ProgressWheel_matProg_linearProgress, false);
        if (typedArray.getBoolean(R.styleable.ProgressWheel_matProg_progressIndeterminate, false)) {
            a();
        }
        typedArray.recycle();
    }

    private void b() {
        this.q.setColor(this.o);
        this.q.setAntiAlias(true);
        this.q.setStyle(Paint.Style.STROKE);
        this.q.setStrokeWidth(this.d);
        this.r.setColor(this.p);
        this.r.setAntiAlias(true);
        this.r.setStyle(Paint.Style.STROKE);
        this.r.setStrokeWidth(this.e);
    }

    private void c() {
        if (this.z != null) {
            this.z.a(Math.round((this.w * 100.0f) / 360.0f) / 100.0f);
        }
    }

    public void a() {
        this.u = SystemClock.uptimeMillis();
        this.y = true;
        invalidate();
    }

    public int getBarColor() {
        return this.o;
    }

    public int getBarWidth() {
        return this.d;
    }

    public int getCircleRadius() {
        return this.c;
    }

    public float getProgress() {
        if (this.y) {
            return -1.0f;
        }
        return this.w / 360.0f;
    }

    public int getRimColor() {
        return this.p;
    }

    public int getRimWidth() {
        return this.e;
    }

    public float getSpinSpeed() {
        return this.t / 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f;
        float f2;
        float f3;
        super.onDraw(canvas);
        canvas.drawArc(this.s, 360.0f, 360.0f, false, this.r);
        float f4 = 0.0f;
        boolean z = true;
        if (this.y) {
            z = true;
            if (a) {
                long uptimeMillis = SystemClock.uptimeMillis() - this.u;
                float f5 = (((float) uptimeMillis) * this.t) / 1000.0f;
                a(uptimeMillis);
                float f6 = this.w + f5;
                this.w = f6;
                if (f6 > 360.0f) {
                    this.w = f6 - 360.0f;
                    a(-1.0f);
                }
                this.u = SystemClock.uptimeMillis();
                float f7 = this.w;
                float f8 = this.k;
                if (isInEditMode()) {
                    f2 = 0.0f;
                    f3 = 135.0f;
                } else {
                    f2 = f7 - 90.0f;
                    f3 = f8 + 36.0f;
                }
                canvas.drawArc(this.s, f2, f3, false, this.q);
                z = true;
            }
        } else {
            float f9 = this.w;
            if (f9 != this.x) {
                this.w = Math.min(this.w + ((((float) (SystemClock.uptimeMillis() - this.u)) / 1000.0f) * this.t), this.x);
                this.u = SystemClock.uptimeMillis();
            } else {
                z = false;
            }
            if (f9 != this.w) {
                c();
            }
            float f10 = this.w;
            if (!this.v) {
                f4 = ((float) (1.0d - Math.pow(1.0f - (f / 360.0f), 4.0f))) * 360.0f;
                f10 = ((float) (1.0d - Math.pow(1.0f - (this.w / 360.0f), 2.0f))) * 360.0f;
            }
            if (isInEditMode()) {
                f10 = 360.0f;
            }
            canvas.drawArc(this.s, f4 - 90.0f, f10, false, this.q);
        }
        if (z) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        super.onMeasure(i, i2);
        int paddingLeft = this.c + getPaddingLeft() + getPaddingRight();
        int paddingTop = this.c + getPaddingTop() + getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            i3 = size;
        } else {
            i3 = paddingLeft;
            if (mode == Integer.MIN_VALUE) {
                i3 = Math.min(paddingLeft, size);
            }
        }
        if (mode2 == 1073741824 || mode == 1073741824) {
            i4 = size2;
        } else {
            i4 = paddingTop;
            if (mode2 == Integer.MIN_VALUE) {
                i4 = Math.min(paddingTop, size2);
            }
        }
        setMeasuredDimension(i3, i4);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof WheelSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        WheelSavedState wheelSavedState = (WheelSavedState) parcelable;
        super.onRestoreInstanceState(wheelSavedState.getSuperState());
        this.w = wheelSavedState.a;
        this.x = wheelSavedState.b;
        this.y = wheelSavedState.c;
        this.t = wheelSavedState.d;
        this.d = wheelSavedState.e;
        this.o = wheelSavedState.f;
        this.e = wheelSavedState.g;
        this.p = wheelSavedState.h;
        this.c = wheelSavedState.i;
        this.v = wheelSavedState.j;
        this.h = wheelSavedState.k;
        this.u = SystemClock.uptimeMillis();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        WheelSavedState wheelSavedState = new WheelSavedState(super.onSaveInstanceState());
        wheelSavedState.a = this.w;
        wheelSavedState.b = this.x;
        wheelSavedState.c = this.y;
        wheelSavedState.d = this.t;
        wheelSavedState.e = this.d;
        wheelSavedState.f = this.o;
        wheelSavedState.g = this.e;
        wheelSavedState.h = this.p;
        wheelSavedState.i = this.c;
        wheelSavedState.j = this.v;
        wheelSavedState.k = this.h;
        return wheelSavedState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a(i, i2);
        b();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            this.u = SystemClock.uptimeMillis();
        }
    }

    public void setBarColor(int i) {
        this.o = i;
        b();
        if (this.y) {
            return;
        }
        invalidate();
    }

    public void setBarWidth(int i) {
        this.d = i;
        if (this.y) {
            return;
        }
        invalidate();
    }

    public void setCallback(ProgressCallback progressCallback) {
        this.z = progressCallback;
        if (this.y) {
            return;
        }
        c();
    }

    public void setCircleRadius(int i) {
        this.c = i;
        if (this.y) {
            return;
        }
        invalidate();
    }

    public void setInstantProgress(float f) {
        float f2;
        if (this.y) {
            this.w = 0.0f;
            this.y = false;
        }
        if (f > 1.0f) {
            f2 = f - 1.0f;
        } else {
            f2 = f;
            if (f < 0.0f) {
                f2 = 0.0f;
            }
        }
        if (f2 == this.x) {
            return;
        }
        float min = Math.min(f2 * 360.0f, 360.0f);
        this.x = min;
        this.w = min;
        this.u = SystemClock.uptimeMillis();
        invalidate();
    }

    public void setLinearProgress(boolean z) {
        this.v = z;
        if (this.y) {
            return;
        }
        invalidate();
    }

    public void setProgress(float f) {
        float f2;
        if (this.y) {
            this.w = 0.0f;
            this.y = false;
            c();
        }
        if (f > 1.0f) {
            f2 = f - 1.0f;
        } else {
            f2 = f;
            if (f < 0.0f) {
                f2 = 0.0f;
            }
        }
        float f3 = this.x;
        if (f2 == f3) {
            return;
        }
        if (this.w == f3) {
            this.u = SystemClock.uptimeMillis();
        }
        this.x = Math.min(f2 * 360.0f, 360.0f);
        invalidate();
    }

    public void setRimColor(int i) {
        this.p = i;
        b();
        if (this.y) {
            return;
        }
        invalidate();
    }

    public void setRimWidth(int i) {
        this.e = i;
        if (this.y) {
            return;
        }
        invalidate();
    }

    public void setSpinSpeed(float f) {
        this.t = f * 360.0f;
    }
}
