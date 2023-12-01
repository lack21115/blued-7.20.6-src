package com.soft.blued.customview.rangebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import com.soft.blued.R;
import skin.support.widget.SkinCompatBackgroundHelper;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/rangebar/RangeBar.class */
public class RangeBar extends View implements BluedSkinSupportable {

    /* renamed from: a  reason: collision with root package name */
    private int f28624a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private float f28625c;
    private int d;
    private float e;
    private int f;
    private int g;
    private int h;
    private float i;
    private int j;
    private int k;
    private boolean l;
    private int m;
    private int n;
    private Thumb o;
    private Thumb p;
    private Bar q;
    private ConnectingLine r;
    private OnRangeBarChangeListener s;
    private int t;
    private int u;
    private SkinCompatBackgroundHelper v;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/rangebar/RangeBar$OnRangeBarChangeListener.class */
    public interface OnRangeBarChangeListener {
        void a(RangeBar rangeBar, int i, int i2);
    }

    public RangeBar(Context context) {
        super(context);
        this.f28624a = 3;
        this.b = 24.0f;
        this.f28625c = 2.0f;
        this.d = Color.LTGRAY;
        this.e = 4.0f;
        this.f = -13388315;
        this.g = R.drawable.icon_two_bars_blue;
        this.h = R.drawable.icon_two_bars_blue;
        this.i = -1.0f;
        this.j = -1;
        this.k = -1;
        this.l = true;
        this.m = 500;
        this.n = 100;
        this.t = 0;
        this.u = 3 - 1;
    }

    public RangeBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28624a = 3;
        this.b = 24.0f;
        this.f28625c = 2.0f;
        this.d = Color.LTGRAY;
        this.e = 4.0f;
        this.f = -13388315;
        this.g = R.drawable.icon_two_bars_blue;
        this.h = R.drawable.icon_two_bars_blue;
        this.i = -1.0f;
        this.j = -1;
        this.k = -1;
        this.l = true;
        this.m = 500;
        this.n = 100;
        this.t = 0;
        this.u = 3 - 1;
        a(context, attributeSet);
    }

    public RangeBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f28624a = 3;
        this.b = 24.0f;
        this.f28625c = 2.0f;
        this.d = Color.LTGRAY;
        this.e = 4.0f;
        this.f = -13388315;
        this.g = R.drawable.icon_two_bars_blue;
        this.h = R.drawable.icon_two_bars_blue;
        this.i = -1.0f;
        this.j = -1;
        this.k = -1;
        this.l = true;
        this.m = 500;
        this.n = 100;
        this.t = 0;
        this.u = 3 - 1;
        a(context, attributeSet);
    }

    private void a() {
        this.q = new Bar(getContext(), getMarginLeft(), getYPos(), getBarLength(), this.f28624a, this.b, this.f28625c, this.d);
        invalidate();
    }

    private void a(float f) {
        if (this.o.c()) {
            a(this.o, f);
        } else if (this.p.c()) {
            a(this.p, f);
        }
        if (this.o.b() > this.p.b()) {
            Thumb thumb = this.o;
            this.o = this.p;
            this.p = thumb;
        }
        int b = this.q.b(this.o);
        int b2 = this.q.b(this.p);
        if (b == this.t && b2 == this.u) {
            return;
        }
        this.t = b;
        this.u = b2;
        OnRangeBarChangeListener onRangeBarChangeListener = this.s;
        if (onRangeBarChangeListener != null) {
            onRangeBarChangeListener.a(this, b, b2);
        }
    }

    private void a(float f, float f2) {
        if (!this.o.c() && this.o.a(f, f2)) {
            a(this.o);
        } else if (this.o.c() || !this.p.a(f, f2)) {
        } else {
            a(this.p);
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
        this.v = skinCompatBackgroundHelper;
        skinCompatBackgroundHelper.a(attributeSet, 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RangeBar, 0, 0);
        try {
            Integer valueOf = Integer.valueOf(obtainStyledAttributes.getInteger(9, 3));
            if (a(valueOf.intValue())) {
                int intValue = valueOf.intValue();
                this.f28624a = intValue;
                this.t = 0;
                int i = intValue - 1;
                this.u = i;
                if (this.s != null) {
                    this.s.a(this, 0, i);
                }
            } else {
                Log.e("RangeBar", "tickCount less than 2; invalid tickCount. XML input ignored.");
            }
            this.b = obtainStyledAttributes.getDimension(10, 24.0f);
            this.f28625c = obtainStyledAttributes.getDimension(1, 2.0f);
            this.d = obtainStyledAttributes.getColor(0, Color.LTGRAY);
            this.e = obtainStyledAttributes.getDimension(3, 4.0f);
            this.f = obtainStyledAttributes.getColor(2, -13388315);
            this.i = obtainStyledAttributes.getDimension(8, -1.0f);
            this.g = obtainStyledAttributes.getResourceId(6, R.drawable.icon_two_bars_blue);
            this.h = obtainStyledAttributes.getResourceId(7, R.drawable.icon_two_bars_blue);
            this.j = obtainStyledAttributes.getColor(4, -1);
            this.k = obtainStyledAttributes.getColor(5, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void a(Thumb thumb) {
        if (this.l) {
            this.l = false;
        }
        thumb.d();
        invalidate();
    }

    private void a(Thumb thumb, float f) {
        if (f < this.q.a()) {
            thumb.a(this.q.a());
        } else if (f > this.q.b()) {
            thumb.a(this.q.b());
        } else {
            thumb.a(f);
        }
        invalidate();
    }

    private boolean a(int i) {
        return i > 1;
    }

    private void b() {
        this.r = new ConnectingLine(getContext(), getYPos(), this.e, this.f);
        invalidate();
    }

    private void b(float f, float f2) {
        if (this.o.c()) {
            b(this.o);
        } else if (this.p.c()) {
            b(this.p);
        } else {
            if (Math.abs(this.o.b() - f) < Math.abs(this.p.b() - f)) {
                this.o.a(f);
                b(this.o);
            } else {
                this.p.a(f);
                b(this.p);
            }
            int b = this.q.b(this.o);
            int b2 = this.q.b(this.p);
            if (b == this.t && b2 == this.u) {
                return;
            }
            this.t = b;
            this.u = b2;
            OnRangeBarChangeListener onRangeBarChangeListener = this.s;
            if (onRangeBarChangeListener != null) {
                onRangeBarChangeListener.a(this, b, b2);
            }
        }
    }

    private void b(Thumb thumb) {
        thumb.a(this.q.a(thumb));
        thumb.e();
        invalidate();
    }

    private boolean b(int i, int i2) {
        int i3;
        return i < 0 || i >= (i3 = this.f28624a) || i2 < 0 || i2 >= i3;
    }

    private void c() {
        Context context = getContext();
        float yPos = getYPos();
        this.o = new Thumb(context, yPos, this.j, this.k, this.i, this.g, this.h);
        this.p = new Thumb(context, yPos, this.j, this.k, this.i, this.g, this.h);
        float marginLeft = getMarginLeft();
        float barLength = getBarLength();
        this.o.a(((this.t / (this.f28624a - 1)) * barLength) + marginLeft);
        this.p.a(marginLeft + ((this.u / (this.f28624a - 1)) * barLength));
        invalidate();
    }

    private float getBarLength() {
        return getWidth() - (getMarginLeft() * 2.0f);
    }

    private float getMarginLeft() {
        Thumb thumb = this.o;
        if (thumb != null) {
            return thumb.a();
        }
        return 0.0f;
    }

    private float getYPos() {
        return getHeight() / 2.0f;
    }

    public void a(int i, int i2) {
        if (b(i, i2)) {
            Log.e("RangeBar", "A thumb index is out of bounds. Check that it is between 0 and mTickCount - 1");
            throw new IllegalArgumentException("A thumb index is out of bounds. Check that it is between 0 and mTickCount - 1, mTickCount = " + this.f28624a);
        }
        if (this.l) {
            this.l = false;
        }
        this.t = i;
        this.u = i2;
        c();
        OnRangeBarChangeListener onRangeBarChangeListener = this.s;
        if (onRangeBarChangeListener != null) {
            onRangeBarChangeListener.a(this, this.t, this.u);
        }
        invalidate();
        requestLayout();
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.v;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a();
        }
    }

    public int getLeftIndex() {
        return this.t;
    }

    public int getRightIndex() {
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.q.a(canvas);
        this.r.a(canvas, this.o, this.p);
        this.o.a(canvas);
        this.p.a(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i3 = mode == Integer.MIN_VALUE ? size : mode == 1073741824 ? size : this.m;
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(this.n, size2);
        } else if (mode2 != 1073741824) {
            size2 = this.n;
        }
        setMeasuredDimension(i3, size2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        this.f28624a = bundle.getInt("TICK_COUNT");
        this.b = bundle.getFloat("TICK_HEIGHT_DP");
        this.f28625c = bundle.getFloat("BAR_WEIGHT");
        this.d = bundle.getInt("BAR_COLOR");
        this.e = bundle.getFloat("CONNECTING_LINE_WEIGHT");
        this.f = bundle.getInt("CONNECTING_LINE_COLOR");
        this.g = bundle.getInt("THUMB_IMAGE_NORMAL");
        this.h = bundle.getInt("THUMB_IMAGE_PRESSED");
        this.i = bundle.getFloat("THUMB_RADIUS_DP");
        this.j = bundle.getInt("THUMB_COLOR_NORMAL");
        this.k = bundle.getInt("THUMB_COLOR_PRESSED");
        this.t = bundle.getInt("LEFT_INDEX");
        this.u = bundle.getInt("RIGHT_INDEX");
        this.l = bundle.getBoolean("FIRST_SET_TICK_COUNT");
        a(this.t, this.u);
        super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("TICK_COUNT", this.f28624a);
        bundle.putFloat("TICK_HEIGHT_DP", this.b);
        bundle.putFloat("BAR_WEIGHT", this.f28625c);
        bundle.putInt("BAR_COLOR", this.d);
        bundle.putFloat("CONNECTING_LINE_WEIGHT", this.e);
        bundle.putInt("CONNECTING_LINE_COLOR", this.f);
        bundle.putInt("THUMB_IMAGE_NORMAL", this.g);
        bundle.putInt("THUMB_IMAGE_PRESSED", this.h);
        bundle.putFloat("THUMB_RADIUS_DP", this.i);
        bundle.putInt("THUMB_COLOR_NORMAL", this.j);
        bundle.putInt("THUMB_COLOR_PRESSED", this.k);
        bundle.putInt("LEFT_INDEX", this.t);
        bundle.putInt("RIGHT_INDEX", this.u);
        bundle.putBoolean("FIRST_SET_TICK_COUNT", this.l);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Context context = getContext();
        float f = i2 / 2.0f;
        this.o = new Thumb(context, f, this.j, this.k, this.i, this.g, this.h);
        this.p = new Thumb(context, f, this.j, this.k, this.i, this.g, this.h);
        float a2 = this.o.a();
        float f2 = i - (2.0f * a2);
        this.q = new Bar(context, a2, f, f2, this.f28624a, this.b, this.f28625c, this.d);
        this.o.a(((this.t / (this.f28624a - 1)) * f2) + a2);
        this.p.a(a2 + ((this.u / (this.f28624a - 1)) * f2));
        int b = this.q.b(this.o);
        int b2 = this.q.b(this.p);
        if (b != this.t || b2 != this.u) {
            this.t = b;
            this.u = b2;
            OnRangeBarChangeListener onRangeBarChangeListener = this.s;
            if (onRangeBarChangeListener != null) {
                onRangeBarChangeListener.a(this, b, b2);
            }
        }
        this.r = new ConnectingLine(context, f, this.e, this.f);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            int action = motionEvent.getAction();
            if (action == 0) {
                a(motionEvent.getX(), motionEvent.getY());
                return true;
            }
            if (action != 1) {
                if (action == 2) {
                    a(motionEvent.getX());
                    getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                } else if (action != 3) {
                    return false;
                }
            }
            getParent().requestDisallowInterceptTouchEvent(false);
            b(motionEvent.getX(), motionEvent.getY());
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.v;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a(i);
        }
    }

    public void setBarColor(int i) {
        this.d = i;
        a();
    }

    public void setBarWeight(float f) {
        this.f28625c = f;
        a();
    }

    public void setConnectingLineColor(int i) {
        this.f = i;
        b();
    }

    public void setConnectingLineWeight(float f) {
        this.e = f;
        b();
    }

    public void setOnRangeBarChangeListener(OnRangeBarChangeListener onRangeBarChangeListener) {
        this.s = onRangeBarChangeListener;
    }

    public void setThumbColorNormal(int i) {
        this.j = i;
        c();
    }

    public void setThumbColorPressed(int i) {
        this.k = i;
        c();
    }

    public void setThumbImageNormal(int i) {
        this.g = i;
        c();
    }

    public void setThumbImagePressed(int i) {
        this.h = i;
        c();
    }

    public void setThumbRadius(float f) {
        this.i = f;
        c();
    }

    public void setTickCount(int i) {
        if (!a(i)) {
            Log.e("RangeBar", "tickCount less than 2; invalid tickCount.");
            throw new IllegalArgumentException("tickCount less than 2; invalid tickCount.");
        }
        this.f28624a = i;
        if (this.l) {
            this.t = 0;
            int i2 = i - 1;
            this.u = i2;
            OnRangeBarChangeListener onRangeBarChangeListener = this.s;
            if (onRangeBarChangeListener != null) {
                onRangeBarChangeListener.a(this, 0, i2);
            }
        }
        if (b(this.t, this.u)) {
            this.t = 0;
            int i3 = this.f28624a - 1;
            this.u = i3;
            OnRangeBarChangeListener onRangeBarChangeListener2 = this.s;
            if (onRangeBarChangeListener2 != null) {
                onRangeBarChangeListener2.a(this, 0, i3);
            }
        }
        a();
        c();
    }

    public void setTickHeight(float f) {
        this.b = f;
        a();
    }
}
