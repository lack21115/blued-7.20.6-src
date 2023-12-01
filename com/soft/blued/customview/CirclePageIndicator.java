package com.soft.blued.customview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.module.common.view.PageIndicator;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/CirclePageIndicator.class */
public class CirclePageIndicator extends View implements PageIndicator {

    /* renamed from: a  reason: collision with root package name */
    private float f14685a;
    private final Paint b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f14686c;
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
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/CirclePageIndicator$SavedState.class */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.soft.blued.customview.CirclePageIndicator.SavedState.1
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
        int f14687a;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f14687a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f14687a);
        }
    }

    public CirclePageIndicator(Context context) {
        this(context, null);
    }

    public CirclePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130970434);
    }

    public CirclePageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new Paint(1);
        this.f14686c = new Paint(1);
        this.d = new Paint(1);
        this.o = -1.0f;
        this.p = -1;
        this.r = 0;
        if (isInEditMode()) {
            return;
        }
        Resources resources = getResources();
        int color = resources.getColor(2131100382);
        int color2 = resources.getColor(2131100381);
        int integer = resources.getInteger(2131427334);
        int color3 = resources.getColor(2131100383);
        float dimension = resources.getDimension(2131165328);
        float dimension2 = resources.getDimension(2131165327);
        boolean z = resources.getBoolean(2131034114);
        boolean z2 = resources.getBoolean(2131034115);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CirclePageIndicator, i, 0);
        this.l = obtainStyledAttributes.getBoolean(2, z);
        this.k = obtainStyledAttributes.getInt(0, integer);
        this.b.setStyle(Paint.Style.FILL);
        this.b.setColor(obtainStyledAttributes.getColor(4, color));
        this.f14686c.setStyle(Paint.Style.STROKE);
        this.f14686c.setColor(obtainStyledAttributes.getColor(7, color3));
        this.f14686c.setStrokeWidth(obtainStyledAttributes.getDimension(8, dimension));
        this.d.setStyle(Paint.Style.FILL);
        this.d.setColor(obtainStyledAttributes.getColor(3, color2));
        this.f14685a = obtainStyledAttributes.getDimension(5, dimension2);
        this.m = obtainStyledAttributes.getBoolean(6, z2);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        if (drawable != null) {
            setBackground(drawable);
        }
        obtainStyledAttributes.recycle();
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
            float f2 = this.f14685a;
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
        int paddingTop = (int) ((this.f14685a * 2.0f) + getPaddingTop() + getPaddingBottom() + 1.0f);
        return mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
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
        return this.f14685a;
    }

    public int getStrokeColor() {
        return this.f14686c.getColor();
    }

    public float getStrokeWidth() {
        return this.f14686c.getStrokeWidth();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int count;
        int height;
        int paddingTop;
        int paddingBottom;
        int paddingLeft;
        float f;
        float f2;
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
        float f3 = this.f14685a;
        float f4 = 3.0f * f3;
        float f5 = paddingLeft + f3;
        float f6 = this.l ? (((height - paddingTop) - paddingBottom) / 2.0f) - (((count - 1) * (this.r + f4)) / 2.0f) : paddingTop + f3;
        float f7 = this.f14685a;
        float f8 = f7;
        if (this.f14686c.getStrokeWidth() > 0.0f) {
            f8 = f7 - (this.f14686c.getStrokeWidth() / 2.0f);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= count) {
                break;
            }
            float f9 = (i2 * (this.r + f4)) + f6;
            if (this.k == 0) {
                f2 = f5;
            } else {
                f2 = f9;
                f9 = f5;
            }
            if (this.b.getAlpha() > 0) {
                canvas.drawCircle(f9, f2, f8, this.b);
            }
            float f10 = this.f14685a;
            if (f8 != f10) {
                canvas.drawCircle(f9, f2, f10, this.f14686c);
            }
            i = i2 + 1;
        }
        int i3 = this.m ? this.h : this.g;
        int i4 = this.r;
        float f11 = i3 * (i4 + f4);
        float f12 = f11;
        if (!this.m) {
            f12 = f11 + (this.i * (f4 + i4));
        }
        if (this.k == 0) {
            f = f6 + f12;
        } else {
            f = f5;
            f5 = f6 + f12;
        }
        canvas.drawCircle(f, f5, this.f14685a, this.d);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.k == 0) {
            setMeasuredDimension(a(i), b(i2));
        } else {
            setMeasuredDimension(b(i), a(i2));
        }
    }

    public void onPageScrollStateChanged(int i) {
        this.j = i;
        ViewPager.OnPageChangeListener onPageChangeListener = this.f;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        this.g = i;
        this.i = f;
        invalidate();
        ViewPager.OnPageChangeListener onPageChangeListener = this.f;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

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
        this.g = savedState.f14687a;
        this.h = savedState.f14687a;
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f14687a = this.g;
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
        this.f14685a = f;
        invalidate();
    }

    public void setSnap(boolean z) {
        this.m = z;
        invalidate();
    }

    public void setStrokeColor(int i) {
        this.f14686c.setColor(i);
        invalidate();
    }

    public void setStrokeWidth(float f) {
        this.f14686c.setStrokeWidth(f);
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
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
