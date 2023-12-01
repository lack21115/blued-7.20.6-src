package com.blued.android.module.live_china.same;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/same/CirclePageIndicator.class */
public class CirclePageIndicator extends View implements PageIndicator {

    /* renamed from: a  reason: collision with root package name */
    private float f14098a;
    private final Paint b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f14099c;
    private final Paint d;
    private ViewPager e;
    private ViewPager.OnPageChangeListener f;
    private int g;
    private int h;
    private float i;
    private int j;
    private int k;
    private boolean l;
    private boolean m;
    private int n;
    private float o;
    private int p;
    private boolean q;
    private int r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/same/CirclePageIndicator$SavedState.class */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.blued.android.module.live_china.same.CirclePageIndicator.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        int f14100a;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f14100a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f14100a);
        }
    }

    public CirclePageIndicator(Context context) {
        this(context, null);
    }

    public CirclePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CirclePageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new Paint(1);
        this.f14099c = new Paint(1);
        this.d = new Paint(1);
        this.l = true;
        this.o = -1.0f;
        this.p = -1;
        this.r = 0;
        if (isInEditMode()) {
            return;
        }
        Resources resources = getResources();
        resources.getColor(R.color.default_circle_indicator_page_color);
        resources.getColor(R.color.default_circle_indicator_fill_color);
        resources.getInteger(R.integer.default_circle_indicator_orientation);
        resources.getColor(R.color.default_circle_indicator_stroke_color);
        resources.getDimension(R.dimen.default_circle_indicator_stroke_width);
        resources.getDimension(R.dimen.default_circle_indicator_radius);
        resources.getBoolean(R.bool.default_circle_indicator_centered);
        resources.getBoolean(R.bool.default_circle_indicator_snap);
        this.b.setStyle(Paint.Style.FILL);
        this.b.setColor(getContext().getResources().getColor(R.color.nafio_i));
        this.d.setStyle(Paint.Style.FILL);
        this.d.setColor(getContext().getResources().getColor(R.color.black));
        this.n = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
    }

    private int a(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int i2 = size;
        if (mode != 1073741824) {
            ViewPager viewPager = this.e;
            if (viewPager == null) {
                return size;
            }
            int count = viewPager.getAdapter().getCount();
            float paddingLeft = getPaddingLeft() + getPaddingRight();
            float f = count * 2;
            float f2 = this.f14098a;
            i2 = (int) (paddingLeft + (f * f2) + ((count - 1) * (f2 + this.r)) + 1.0f);
            if (mode == Integer.MIN_VALUE) {
                return Math.min(i2, size);
            }
        }
        return i2;
    }

    private int b(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = (int) ((this.f14098a * 2.0f) + getPaddingTop() + getPaddingBottom() + 1.0f);
        return mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
    }

    public void a() {
        invalidate();
    }

    public int getFillColor() {
        return this.d.getColor();
    }

    public int getOrientation() {
        return this.k;
    }

    public int getPageColor() {
        return this.b.getColor();
    }

    public float getRadius() {
        return this.f14098a;
    }

    public int getStrokeColor() {
        return this.f14099c.getColor();
    }

    public float getStrokeWidth() {
        return this.f14099c.getStrokeWidth();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int count;
        int height;
        int paddingTop;
        int paddingBottom;
        int paddingLeft;
        float f;
        float f2;
        float f3;
        super.onDraw(canvas);
        ViewPager viewPager = this.e;
        if (viewPager == null || (count = viewPager.getAdapter().getCount()) == 0) {
            return;
        }
        if (this.g >= count) {
            setCurrentItem(count - 1);
            return;
        }
        if (this.k == 0) {
            height = getWidth();
            paddingTop = getPaddingLeft();
            paddingBottom = getPaddingRight();
            paddingLeft = getPaddingTop();
        } else {
            height = getHeight();
            paddingTop = getPaddingTop();
            paddingBottom = getPaddingBottom();
            paddingLeft = getPaddingLeft();
        }
        float f4 = this.f14098a;
        float f5 = 3.0f * f4;
        float f6 = paddingLeft + f4;
        float f7 = paddingTop + f4;
        float f8 = f7;
        if (this.l) {
            f8 = f7 + ((((height - paddingTop) - paddingBottom) / 2.0f) - ((((count * f5) - f4) + ((count - 1) * this.r)) / 2.0f));
        }
        float f9 = f8;
        if (f8 < 0.0f) {
            f9 = 0.0f;
        }
        float f10 = this.f14098a;
        float f11 = f10;
        if (this.f14099c.getStrokeWidth() > 0.0f) {
            f11 = f10 - (this.f14099c.getStrokeWidth() / 2.0f);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= count) {
                break;
            }
            float f12 = (i2 * (this.r + f5)) + f9;
            if (this.k == 0) {
                f3 = f6;
            } else {
                f3 = f12;
                f12 = f6;
            }
            if (this.b.getAlpha() > 0) {
                canvas.drawCircle(f12, f3, f11, this.b);
            }
            float f13 = this.f14098a;
            if (f11 != f13) {
                canvas.drawCircle(f12, f3, f13, this.f14099c);
            }
            i = i2 + 1;
        }
        int i3 = this.m ? this.h : this.g;
        int i4 = this.r;
        float f14 = i3 * (i4 + f5);
        float f15 = f14;
        if (!this.m) {
            f15 = f14 + (this.i * (f5 + i4));
        }
        if (this.k == 0) {
            f2 = f9 + f15;
            f = f6;
        } else {
            f = f9 + f15;
            f2 = f6;
        }
        canvas.drawCircle(f2, f, this.f14098a, this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (this.k == 0) {
            setMeasuredDimension(a(i), b(i2));
        } else {
            setMeasuredDimension(b(i), a(i2));
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        this.j = i;
        ViewPager.OnPageChangeListener onPageChangeListener = this.f;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        this.g = i;
        this.i = f;
        invalidate();
        ViewPager.OnPageChangeListener onPageChangeListener = this.f;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.m || this.j == 0) {
            this.g = i;
            this.h = i;
            invalidate();
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.f;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.g = savedState.f14100a;
        this.h = savedState.f14100a;
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f14100a = this.g;
        return savedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        ViewPager viewPager = this.e;
        int i = 0;
        if (viewPager == null || viewPager.getAdapter().getCount() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.p = MotionEventCompat.getPointerId(motionEvent, 0);
            this.o = motionEvent.getX();
            return true;
        }
        if (action != 1) {
            if (action == 2) {
                try {
                    float x = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.p));
                    float f = x - this.o;
                    if (!this.q && Math.abs(f) > this.n) {
                        this.q = true;
                    }
                    if (this.q) {
                        this.o = x;
                        if (this.e.isFakeDragging() || this.e.beginFakeDrag()) {
                            this.e.fakeDragBy(f);
                            return true;
                        }
                        return true;
                    }
                    return true;
                } catch (Exception e) {
                    return true;
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                    this.o = MotionEventCompat.getX(motionEvent, actionIndex);
                    this.p = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                    return true;
                } else if (action != 6) {
                    return true;
                } else {
                    int actionIndex2 = MotionEventCompat.getActionIndex(motionEvent);
                    if (MotionEventCompat.getPointerId(motionEvent, actionIndex2) == this.p) {
                        if (actionIndex2 == 0) {
                            i = 1;
                        }
                        this.p = MotionEventCompat.getPointerId(motionEvent, i);
                    }
                    this.o = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.p));
                    return true;
                }
            }
        }
        if (!this.q) {
            int count = this.e.getAdapter().getCount();
            float width = getWidth();
            float f2 = width / 2.0f;
            float f3 = width / 6.0f;
            if (this.g > 0 && motionEvent.getX() < f2 - f3) {
                if (action != 3) {
                    this.e.setCurrentItem(this.g - 1);
                    return true;
                }
                return true;
            } else if (this.g < count - 1 && motionEvent.getX() > f2 + f3) {
                if (action != 3) {
                    this.e.setCurrentItem(this.g + 1);
                    return true;
                }
                return true;
            }
        }
        this.q = false;
        this.p = -1;
        if (this.e.isFakeDragging()) {
            this.e.endFakeDrag();
            return true;
        }
        return true;
    }

    public void setCentered(boolean z) {
        this.l = z;
        invalidate();
    }

    public void setCurrentItem(int i) {
        ViewPager viewPager = this.e;
        if (viewPager == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        viewPager.setCurrentItem(i);
        this.g = i;
        invalidate();
    }

    public void setFillColor(int i) {
        this.d.setColor(i);
        invalidate();
    }

    public void setInterval(int i) {
        this.r = i;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f = onPageChangeListener;
    }

    public void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");
        }
        this.k = i;
        requestLayout();
    }

    public void setPageColor(int i) {
        this.b.setColor(i);
        invalidate();
    }

    public void setRadius(float f) {
        this.f14098a = f;
        invalidate();
    }

    public void setSnap(boolean z) {
        this.m = z;
        invalidate();
    }

    public void setStrokeColor(int i) {
        this.f14099c.setColor(i);
        invalidate();
    }

    public void setStrokeWidth(float f) {
        this.f14099c.setStrokeWidth(f);
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        ViewPager viewPager2 = this.e;
        if (viewPager2 == viewPager) {
            return;
        }
        if (viewPager2 != null) {
            viewPager2.setOnPageChangeListener(null);
        }
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        this.e = viewPager;
        viewPager.setOnPageChangeListener(this);
        invalidate();
    }
}
