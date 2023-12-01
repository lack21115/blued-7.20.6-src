package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import javax.annotation.Nullable;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/RangeSeekBar.class */
public class RangeSeekBar extends View {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15903a = RangeSeekBar.class.getSimpleName() + " ";
    private Thumb A;
    private boolean B;
    private boolean C;
    private OnRangeSeekBarChangeListener D;
    private double b;

    /* renamed from: c  reason: collision with root package name */
    private double f15904c;
    private double d;
    private double e;
    private long f;
    private double g;
    private double h;
    private double i;
    private int j;
    private Bitmap k;
    private Bitmap l;
    private Bitmap m;
    private Bitmap n;
    private Bitmap o;
    private Paint p;
    private Paint q;
    private int r;
    private float s;
    private final float t;
    private float u;
    private float v;
    private boolean w;
    private int x;
    private float y;
    private boolean z;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/RangeSeekBar$OnRangeSeekBarChangeListener.class */
    public interface OnRangeSeekBarChangeListener {
        void a(RangeSeekBar rangeSeekBar, long j, long j2, int i, boolean z, Thumb thumb);
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/RangeSeekBar$Thumb.class */
    public enum Thumb {
        MIN,
        MAX
    }

    public RangeSeekBar(Context context, long j, long j2) {
        super(context);
        this.d = 0.0d;
        this.e = 1.0d;
        this.f = m.ag;
        this.g = 1.0d;
        this.h = 0.0d;
        this.i = 1.0d;
        this.t = 0.0f;
        this.u = 0.0f;
        this.v = 0.0f;
        this.x = 255;
        this.C = false;
        this.b = j;
        this.f15904c = j2;
        setFocusable(true);
        setFocusableInTouchMode(true);
        c();
    }

    public RangeSeekBar(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0.0d;
        this.e = 1.0d;
        this.f = m.ag;
        this.g = 1.0d;
        this.h = 0.0d;
        this.i = 1.0d;
        this.t = 0.0f;
        this.u = 0.0f;
        this.v = 0.0f;
        this.x = 255;
        this.C = false;
    }

    public RangeSeekBar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 0.0d;
        this.e = 1.0d;
        this.f = m.ag;
        this.g = 1.0d;
        this.h = 0.0d;
        this.i = 1.0d;
        this.t = 0.0f;
        this.u = 0.0f;
        this.v = 0.0f;
        this.x = 255;
        this.C = false;
    }

    private double a(float f, int i) {
        int width;
        float width2;
        double d;
        double d2;
        double d3;
        double d4;
        if (getWidth() <= 0.0f) {
            return 0.0d;
        }
        this.B = false;
        double d5 = f;
        float a2 = a(this.d);
        float a3 = a(this.e);
        this.g = (this.f / (this.f15904c - this.b)) * (width - (this.r * 2));
        if (i == 0) {
            if (b(f, this.d, 0.5d)) {
                return this.d;
            }
            double valueLength = getValueLength() - ((((float) getWidth()) - a3 >= 0.0f ? getWidth() - a3 : 0.0f) + this.g);
            double d6 = a2;
            if (d5 > d6) {
                d4 = (d5 - d6) + d6;
            } else {
                d4 = d5;
                if (d5 <= d6) {
                    d4 = d6 - (d6 - d5);
                }
            }
            if (d4 > valueLength) {
                this.B = true;
                d4 = valueLength;
            }
            if (d4 < (this.r * 2) / 3) {
                d4 = 0.0d;
            }
            double d7 = d4 - 0.0d;
            this.h = Math.min(1.0d, Math.max(0.0d, d7 / (width - (this.r * 2))));
            return Math.min(1.0d, Math.max(0.0d, d7 / (width2 - 0.0f)));
        } else if (a(f, this.e, 0.5d)) {
            return this.e;
        } else {
            double valueLength2 = getValueLength() - (a2 + this.g);
            double d8 = a3;
            if (d5 > d8) {
                d = (d5 - d8) + d8;
            } else {
                d = d5;
                if (d5 <= d8) {
                    d = d8 - (d8 - d5);
                }
            }
            double width3 = getWidth() - d;
            if (width3 > valueLength2) {
                this.B = true;
                d2 = getWidth() - valueLength2;
                d3 = valueLength2;
            } else {
                d2 = d;
                d3 = width3;
            }
            double d9 = d3;
            if (d3 < (this.r * 2) / 3) {
                d2 = getWidth();
                d9 = 0.0d;
            }
            this.i = Math.min(1.0d, Math.max(0.0d, 1.0d - ((d9 - 0.0d) / (width - (this.r * 2)))));
            return Math.min(1.0d, Math.max(0.0d, (d2 - 0.0d) / (width2 - 0.0f)));
        }
    }

    private double a(long j) {
        double d = this.f15904c;
        double d2 = this.b;
        if (0.0d == d - d2) {
            return 0.0d;
        }
        return (j - d2) / (d - d2);
    }

    private float a(double d) {
        return (float) (getPaddingLeft() + (d * ((getWidth() - getPaddingLeft()) - getPaddingRight())));
    }

    private Thumb a(float f) {
        boolean a2 = a(f, this.d, 2.0d);
        boolean a3 = a(f, this.e, 2.0d);
        if (a2 && a3) {
            return f / ((float) getWidth()) > 0.5f ? Thumb.MIN : Thumb.MAX;
        } else if (a2) {
            return Thumb.MIN;
        } else {
            if (a3) {
                return Thumb.MAX;
            }
            return null;
        }
    }

    private void a(float f, boolean z, Canvas canvas, boolean z2) {
        canvas.drawBitmap(z ? this.m : z2 ? this.k : this.l, f - (z2 ? 0 : this.r), z ? this.v : this.u, this.p);
    }

    private void a(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.x) {
            int i = action == 0 ? 1 : 0;
            this.y = motionEvent.getX(i);
            this.x = motionEvent.getPointerId(i);
        }
    }

    private boolean a(float f, double d, double d2) {
        return ((double) Math.abs(f - a(d))) <= ((double) this.s) * d2;
    }

    private long b(double d) {
        double d2 = this.b;
        return (long) (d2 + (d * (this.f15904c - d2)));
    }

    private void b(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            return;
        }
        StvLogUtils.b(f15903a + "trackTouchEvent: " + motionEvent.getAction() + " x: " + motionEvent.getX(), new Object[0]);
        try {
            float x = motionEvent.getX(motionEvent.findPointerIndex(this.x));
            if (Thumb.MIN.equals(this.A)) {
                setNormalizedMinValue(a(x, 0));
            } else if (Thumb.MAX.equals(this.A)) {
                setNormalizedMaxValue(a(x, 1));
            }
        } catch (Exception e) {
        }
    }

    private boolean b(float f, double d, double d2) {
        return ((double) Math.abs((f - a(d)) - ((float) this.r))) <= ((double) this.s) * d2;
    }

    private void c() {
        this.j = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.trim_selected_video_handle);
        int width = decodeResource.getWidth();
        int height = decodeResource.getHeight();
        int a2 = a(11);
        float f = (a2 * 1.0f) / width;
        float a3 = (a(55) * 1.0f) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(f, a3);
        this.k = Bitmap.createBitmap(decodeResource, 0, 0, width, height, matrix, true);
        decodeResource.recycle();
        Bitmap bitmap = this.k;
        this.l = bitmap;
        this.m = bitmap;
        this.r = a2;
        this.s = a2 / 2;
        this.n = BitmapFactory.decodeResource(getResources(), R.drawable.upload_overlay_black);
        this.o = BitmapFactory.decodeResource(getResources(), R.drawable.upload_overlay_trans);
        this.p = new Paint(1);
        Paint paint = new Paint(1);
        this.q = paint;
        paint.setStyle(Paint.Style.FILL);
        this.q.setColor(Color.parseColor("#F7C443"));
    }

    private void d() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    private int getValueLength() {
        return getWidth() - (this.r * 2);
    }

    public int a(int i) {
        return (int) ((i * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    void a() {
        this.z = true;
    }

    void b() {
        this.z = false;
    }

    public long getSelectedMaxValue() {
        return b(this.i);
    }

    public long getSelectedMinValue() {
        return b(this.h);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = ((getWidth() - getPaddingRight()) - 0.0f) / this.o.getWidth();
        float a2 = a(this.d);
        float a3 = a(this.e);
        float width2 = (a3 - a2) / this.o.getWidth();
        if (width2 > 0.0f) {
            try {
                Matrix matrix = new Matrix();
                matrix.postScale(width2, 1.0f);
                canvas.drawBitmap(Bitmap.createBitmap(this.o, 0, 0, this.o.getWidth(), this.o.getHeight(), matrix, true), a2, this.u, this.p);
                Matrix matrix2 = new Matrix();
                matrix2.postScale(width, 1.0f);
                Bitmap createBitmap = Bitmap.createBitmap(this.n, 0, 0, this.n.getWidth(), this.n.getHeight(), matrix2, true);
                canvas.drawBitmap(Bitmap.createBitmap(createBitmap, 0, 0, ((int) (a2 - 0.0f)) + (this.r / 2), this.n.getHeight()), 0.0f, this.u, this.p);
                canvas.drawBitmap(Bitmap.createBitmap(createBitmap, (int) (a3 - (this.r / 2)), 0, ((int) (getWidth() - a3)) + (this.r / 2), this.n.getHeight()), (int) (a3 - (this.r / 2)), this.u, this.p);
                canvas.drawRect(a2, this.u, a3, this.u + a(2), this.q);
                canvas.drawRect(a2, getHeight() - a(2), a3, getHeight(), this.q);
                a(a(this.d), false, canvas, true);
                a(a(this.e), false, canvas, false);
            } catch (Exception e) {
                StvLogUtils.b(f15903a + "IllegalArgumentException--width=" + this.o.getWidth() + "Height=" + this.o.getHeight() + "scale_pro=" + width2, new Object[0]);
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getMode(i) != 0 ? View.MeasureSpec.getSize(i) : 300;
        int i3 = 120;
        if (View.MeasureSpec.getMode(i2) != 0) {
            i3 = View.MeasureSpec.getSize(i2);
        }
        setMeasuredDimension(size, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("SUPER"));
        this.d = bundle.getDouble("MIN");
        this.e = bundle.getDouble("MAX");
        this.h = bundle.getDouble("MIN_TIME");
        this.i = bundle.getDouble("MAX_TIME");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("SUPER", super.onSaveInstanceState());
        bundle.putDouble("MIN", this.d);
        bundle.putDouble("MAX", this.e);
        bundle.putDouble("MIN_TIME", this.h);
        bundle.putDouble("MAX_TIME", this.i);
        return bundle;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        OnRangeSeekBarChangeListener onRangeSeekBarChangeListener;
        if (!this.w && motionEvent.getPointerCount() <= 1) {
            if (isEnabled()) {
                if (this.f15904c <= this.f) {
                    return super.onTouchEvent(motionEvent);
                }
                int action = motionEvent.getAction() & 255;
                if (action == 0) {
                    int pointerId = motionEvent.getPointerId(motionEvent.getPointerCount() - 1);
                    this.x = pointerId;
                    float x = motionEvent.getX(motionEvent.findPointerIndex(pointerId));
                    this.y = x;
                    Thumb a2 = a(x);
                    this.A = a2;
                    if (a2 == null) {
                        return super.onTouchEvent(motionEvent);
                    }
                    setPressed(true);
                    a();
                    b(motionEvent);
                    d();
                    OnRangeSeekBarChangeListener onRangeSeekBarChangeListener2 = this.D;
                    if (onRangeSeekBarChangeListener2 != null) {
                        onRangeSeekBarChangeListener2.a(this, getSelectedMinValue(), getSelectedMaxValue(), 0, this.B, this.A);
                        return true;
                    }
                    return true;
                } else if (action == 1) {
                    if (this.z) {
                        b(motionEvent);
                        b();
                        setPressed(false);
                    } else {
                        a();
                        b(motionEvent);
                        b();
                    }
                    invalidate();
                    OnRangeSeekBarChangeListener onRangeSeekBarChangeListener3 = this.D;
                    if (onRangeSeekBarChangeListener3 != null) {
                        onRangeSeekBarChangeListener3.a(this, getSelectedMinValue(), getSelectedMaxValue(), 1, this.B, this.A);
                    }
                    this.A = null;
                    return true;
                } else if (action != 2) {
                    if (action == 3) {
                        if (this.z) {
                            b();
                            setPressed(false);
                        }
                        invalidate();
                        return true;
                    } else if (action != 5) {
                        if (action != 6) {
                            return true;
                        }
                        a(motionEvent);
                        invalidate();
                        return true;
                    } else {
                        int pointerCount = motionEvent.getPointerCount() - 1;
                        this.y = motionEvent.getX(pointerCount);
                        this.x = motionEvent.getPointerId(pointerCount);
                        invalidate();
                        return true;
                    }
                } else if (this.A != null) {
                    if (this.z) {
                        b(motionEvent);
                    } else if (Math.abs(motionEvent.getX(motionEvent.findPointerIndex(this.x)) - this.y) > this.j) {
                        setPressed(true);
                        StvLogUtils.b(f15903a + "没有拖住最大最小值", new Object[0]);
                        invalidate();
                        a();
                        b(motionEvent);
                        d();
                    }
                    if (!this.C || (onRangeSeekBarChangeListener = this.D) == null) {
                        return true;
                    }
                    onRangeSeekBarChangeListener.a(this, getSelectedMinValue(), getSelectedMaxValue(), 2, this.B, this.A);
                    return true;
                } else {
                    return true;
                }
            }
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setMin_cut_time(long j) {
        this.f = j;
    }

    public void setNormalizedMaxValue(double d) {
        this.e = Math.max(0.0d, Math.min(1.0d, Math.max(d, this.d)));
        invalidate();
    }

    public void setNormalizedMinValue(double d) {
        this.d = Math.max(0.0d, Math.min(1.0d, Math.min(d, this.e)));
        invalidate();
    }

    public void setNotifyWhileDragging(boolean z) {
        this.C = z;
    }

    public void setOnRangeSeekBarChangeListener(OnRangeSeekBarChangeListener onRangeSeekBarChangeListener) {
        this.D = onRangeSeekBarChangeListener;
    }

    public void setSelectedMaxValue(long j) {
        if (0.0d == this.f15904c - this.b) {
            setNormalizedMaxValue(1.0d);
        } else {
            setNormalizedMaxValue(a(j));
        }
    }

    public void setSelectedMinValue(long j) {
        if (0.0d == this.f15904c - this.b) {
            setNormalizedMinValue(0.0d);
        } else {
            setNormalizedMinValue(a(j));
        }
    }

    public void setTouchDown(boolean z) {
        this.w = z;
    }
}
