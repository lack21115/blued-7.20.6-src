package com.blued.android.module.live.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.blued.android.module.live.base.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/ProgressWheel.class */
public class ProgressWheel extends View {
    private static final String a = ProgressWheel.class.getSimpleName();
    private final int b;
    private final int c;
    private final long d;
    private int e;
    private int f;
    private int g;
    private boolean h;
    private double i;
    private double j;
    private float k;
    private boolean l;
    private long m;
    private int n;
    private int o;
    private Paint p;
    private Paint q;
    private RectF r;
    private float s;
    private long t;
    private boolean u;
    private float v;
    private float w;
    private boolean x;
    private ProgressCallback y;
    private boolean z;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/ProgressWheel$ProgressCallback.class */
    public interface ProgressCallback {
        void a(float f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/ProgressWheel$WheelSavedState.class */
    public static class WheelSavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<WheelSavedState> CREATOR = new Parcelable.Creator<WheelSavedState>() { // from class: com.blued.android.module.live.base.view.ProgressWheel.WheelSavedState.1
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

    public ProgressWheel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 16;
        this.c = 270;
        this.d = 200L;
        this.e = 28;
        this.f = 4;
        this.g = 4;
        this.h = false;
        this.i = 0.0d;
        this.j = 460.0d;
        this.k = 0.0f;
        this.l = true;
        this.m = 0L;
        this.n = -1442840576;
        this.o = 16777215;
        this.p = new Paint();
        this.q = new Paint();
        this.r = new RectF();
        this.s = 230.0f;
        this.t = 0L;
        this.v = 0.0f;
        this.w = 0.0f;
        this.x = false;
        a(context.obtainStyledAttributes(attributeSet, R.styleable.ProgressWheel));
        b();
    }

    private void a(float f) {
        ProgressCallback progressCallback = this.y;
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
            int i3 = this.f;
            this.r = new RectF(paddingLeft + i3, paddingTop + i3, (i - paddingRight) - i3, (i2 - paddingBottom) - i3);
            return;
        }
        int i4 = (i - paddingLeft) - paddingRight;
        int min = Math.min(Math.min(i4, (i2 - paddingBottom) - paddingTop), (this.e * 2) - (this.f * 2));
        int i5 = ((i4 - min) / 2) + paddingLeft;
        int i6 = ((((i2 - paddingTop) - paddingBottom) - min) / 2) + paddingTop;
        int i7 = this.f;
        this.r = new RectF(i5 + i7, i6 + i7, (i5 + min) - i7, (i6 + min) - i7);
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
            this.k = cos * 254.0f;
            return;
        }
        float f = (1.0f - cos) * 254.0f;
        this.v += this.k - f;
        this.k = f;
    }

    private void a(TypedArray typedArray) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.f = (int) TypedValue.applyDimension(1, this.f, displayMetrics);
        this.g = (int) TypedValue.applyDimension(1, this.g, displayMetrics);
        this.e = (int) TypedValue.applyDimension(1, this.e, displayMetrics);
        this.e = (int) typedArray.getDimension(R.styleable.ProgressWheel_matProg_circleRadius, this.e);
        this.h = typedArray.getBoolean(R.styleable.ProgressWheel_matProg_fillRadius, false);
        this.f = (int) typedArray.getDimension(R.styleable.ProgressWheel_matProg_barWidth, this.f);
        this.g = (int) typedArray.getDimension(R.styleable.ProgressWheel_matProg_rimWidth, this.g);
        this.s = typedArray.getFloat(R.styleable.ProgressWheel_matProg_spinSpeed, this.s / 360.0f) * 360.0f;
        this.j = typedArray.getInt(R.styleable.ProgressWheel_matProg_barSpinCycleTime, (int) this.j);
        this.n = typedArray.getColor(R.styleable.ProgressWheel_matProg_barColor, this.n);
        this.o = typedArray.getColor(R.styleable.ProgressWheel_matProg_rimColor, this.o);
        this.u = typedArray.getBoolean(R.styleable.ProgressWheel_matProg_linearProgress, false);
        if (typedArray.getBoolean(R.styleable.ProgressWheel_matProg_progressIndeterminate, false)) {
            a();
        }
        typedArray.recycle();
    }

    private void b() {
        this.z = (Build.VERSION.SDK_INT >= 17 ? Settings.Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f) : Settings.System.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f)) != 0.0f;
    }

    private void c() {
        this.p.setColor(this.n);
        this.p.setAntiAlias(true);
        this.p.setStyle(Paint.Style.STROKE);
        this.p.setStrokeWidth(this.f);
        this.q.setColor(this.o);
        this.q.setAntiAlias(true);
        this.q.setStyle(Paint.Style.STROKE);
        this.q.setStrokeWidth(this.g);
    }

    private void d() {
        if (this.y != null) {
            this.y.a(Math.round((this.v * 100.0f) / 360.0f) / 100.0f);
        }
    }

    public void a() {
        this.t = SystemClock.uptimeMillis();
        this.x = true;
        invalidate();
    }

    public int getBarColor() {
        return this.n;
    }

    public int getBarWidth() {
        return this.f;
    }

    public int getCircleRadius() {
        return this.e;
    }

    public float getProgress() {
        if (this.x) {
            return -1.0f;
        }
        return this.v / 360.0f;
    }

    public int getRimColor() {
        return this.o;
    }

    public int getRimWidth() {
        return this.g;
    }

    public float getSpinSpeed() {
        return this.s / 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        canvas.drawArc(this.r, 360.0f, 360.0f, false, this.q);
        if (this.z) {
            float f2 = 0.0f;
            float f3 = 0.0f;
            boolean z = true;
            if (this.x) {
                long uptimeMillis = SystemClock.uptimeMillis() - this.t;
                float f4 = (((float) uptimeMillis) * this.s) / 1000.0f;
                a(uptimeMillis);
                float f5 = this.v + f4;
                this.v = f5;
                if (f5 > 360.0f) {
                    this.v = f5 - 360.0f;
                    a(-1.0f);
                }
                this.t = SystemClock.uptimeMillis();
                float f6 = this.v;
                float f7 = this.k + 16.0f;
                if (isInEditMode()) {
                    f7 = 135.0f;
                } else {
                    f3 = f6;
                }
                canvas.drawArc(this.r, -f3, -f7, false, this.p);
                z = true;
            } else {
                float f8 = this.v;
                if (f8 != this.w) {
                    this.v = Math.min(this.v + ((((float) (SystemClock.uptimeMillis() - this.t)) / 1000.0f) * this.s), this.w);
                    this.t = SystemClock.uptimeMillis();
                } else {
                    z = false;
                }
                if (f8 != this.v) {
                    d();
                }
                float f9 = this.v;
                if (!this.u) {
                    f2 = ((float) (1.0d - Math.pow(1.0f - (f / 360.0f), 4.0f))) * 360.0f;
                    f9 = ((float) (1.0d - Math.pow(1.0f - (this.v / 360.0f), 2.0f))) * 360.0f;
                }
                if (isInEditMode()) {
                    f9 = 360.0f;
                }
                canvas.drawArc(this.r, f2 - 90.0f, f9, false, this.p);
            }
            if (z) {
                invalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        super.onMeasure(i, i2);
        int paddingLeft = this.e + getPaddingLeft() + getPaddingRight();
        int paddingTop = this.e + getPaddingTop() + getPaddingBottom();
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
        this.v = wheelSavedState.a;
        this.w = wheelSavedState.b;
        this.x = wheelSavedState.c;
        this.s = wheelSavedState.d;
        this.f = wheelSavedState.e;
        this.n = wheelSavedState.f;
        this.g = wheelSavedState.g;
        this.o = wheelSavedState.h;
        this.e = wheelSavedState.i;
        this.u = wheelSavedState.j;
        this.h = wheelSavedState.k;
        this.t = SystemClock.uptimeMillis();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        WheelSavedState wheelSavedState = new WheelSavedState(super.onSaveInstanceState());
        wheelSavedState.a = this.v;
        wheelSavedState.b = this.w;
        wheelSavedState.c = this.x;
        wheelSavedState.d = this.s;
        wheelSavedState.e = this.f;
        wheelSavedState.f = this.n;
        wheelSavedState.g = this.g;
        wheelSavedState.h = this.o;
        wheelSavedState.i = this.e;
        wheelSavedState.j = this.u;
        wheelSavedState.k = this.h;
        return wheelSavedState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a(i, i2);
        c();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            this.t = SystemClock.uptimeMillis();
        }
    }

    public void setBarColor(int i) {
        this.n = i;
        c();
        if (this.x) {
            return;
        }
        invalidate();
    }

    public void setBarWidth(int i) {
        this.f = i;
        if (this.x) {
            return;
        }
        invalidate();
    }

    public void setCallback(ProgressCallback progressCallback) {
        this.y = progressCallback;
        if (this.x) {
            return;
        }
        d();
    }

    public void setCircleRadius(int i) {
        this.e = i;
        if (this.x) {
            return;
        }
        invalidate();
    }

    public void setInstantProgress(float f) {
        float f2;
        if (this.x) {
            this.v = 0.0f;
            this.x = false;
        }
        if (f > 1.0f) {
            f2 = f - 1.0f;
        } else {
            f2 = f;
            if (f < 0.0f) {
                f2 = 0.0f;
            }
        }
        if (f2 == this.w) {
            return;
        }
        float min = Math.min(f2 * 360.0f, 360.0f);
        this.w = min;
        this.v = min;
        this.t = SystemClock.uptimeMillis();
        invalidate();
    }

    public void setLinearProgress(boolean z) {
        this.u = z;
        if (this.x) {
            return;
        }
        invalidate();
    }

    public void setProgress(float f) {
        float f2;
        if (this.x) {
            this.v = 0.0f;
            this.x = false;
            d();
        }
        if (f > 1.0f) {
            f2 = f - 1.0f;
        } else {
            f2 = f;
            if (f < 0.0f) {
                f2 = 0.0f;
            }
        }
        float f3 = this.w;
        if (f2 == f3) {
            return;
        }
        if (this.v == f3) {
            this.t = SystemClock.uptimeMillis();
        }
        this.w = Math.min(f2 * 360.0f, 360.0f);
        invalidate();
    }

    public void setRimColor(int i) {
        this.o = i;
        c();
        if (this.x) {
            return;
        }
        invalidate();
    }

    public void setRimWidth(int i) {
        this.g = i;
        if (this.x) {
            return;
        }
        invalidate();
    }

    public void setSpinSpeed(float f) {
        this.s = f * 360.0f;
    }
}
