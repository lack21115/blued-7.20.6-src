package com.blued.android.module.common.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
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
import com.blued.android.module.common.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/LinePageIndicator.class */
public class LinePageIndicator extends View implements PageIndicator {

    /* renamed from: a  reason: collision with root package name */
    RectF f10996a;
    private final Paint b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f10997c;
    private final Paint d;
    private ViewPager e;
    private ViewPager.OnPageChangeListener f;
    private int g;
    private boolean h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private int n;
    private float o;
    private int p;
    private boolean q;
    private boolean r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/LinePageIndicator$SavedState.class */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.blued.android.module.common.view.LinePageIndicator.SavedState.1
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
        int f10998a;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f10998a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f10998a);
        }
    }

    public LinePageIndicator(Context context) {
        this(context, null);
    }

    public LinePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.vpiLinePageIndicatorStyle);
    }

    public LinePageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new Paint(1);
        this.f10997c = new Paint(1);
        this.d = new Paint(1);
        this.o = -1.0f;
        this.p = -1;
        this.f10996a = new RectF();
        if (isInEditMode()) {
            return;
        }
        Resources resources = getResources();
        int color = resources.getColor(R.color.default_line_indicator_selected_color);
        int color2 = resources.getColor(R.color.default_line_indicator_unselected_color);
        float dimension = resources.getDimension(R.dimen.default_line_indicator_line_width);
        float dimension2 = resources.getDimension(R.dimen.default_line_indicator_gap_width);
        float dimension3 = resources.getDimension(R.dimen.default_line_indicator_stroke_width);
        boolean z = resources.getBoolean(R.bool.default_line_indicator_centered);
        float dimension4 = resources.getDimension(R.dimen.default_line_indicator_line_height);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LinePageIndicator, i, 0);
        this.h = obtainStyledAttributes.getBoolean(R.styleable.LinePageIndicator_lineCentered, z);
        this.i = obtainStyledAttributes.getDimension(R.styleable.LinePageIndicator_lineWidth, dimension);
        this.m = obtainStyledAttributes.getDimension(R.styleable.LinePageIndicator_lineHeight, dimension4);
        this.j = obtainStyledAttributes.getDimension(R.styleable.LinePageIndicator_gapWidth, dimension2);
        setStrokeWidth(obtainStyledAttributes.getDimension(R.styleable.LinePageIndicator_lineStrokeWidth, dimension3));
        this.b.setColor(obtainStyledAttributes.getColor(R.styleable.LinePageIndicator_lineUnselectedColor, color2));
        this.f10997c.setColor(obtainStyledAttributes.getColor(R.styleable.LinePageIndicator_lineSelectedColor, color));
        this.d.setStyle(Paint.Style.FILL);
        this.d.setColor(obtainStyledAttributes.getColor(R.styleable.LinePageIndicator_lineUnselectedColor, color2));
        this.k = obtainStyledAttributes.getDimension(R.styleable.LinePageIndicator_selectedLineWidth, this.i);
        this.l = obtainStyledAttributes.getDimension(R.styleable.LinePageIndicator_roundRadius, 0.0f);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.LinePageIndicator_android_background);
        if (drawable != null) {
            setBackgroundDrawable(drawable);
        }
        obtainStyledAttributes.recycle();
        this.n = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
    }

    private int a(int i) {
        float f;
        ViewPager viewPager;
        int count;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824 || (viewPager = this.e) == null) {
            f = size;
        } else {
            float paddingLeft = getPaddingLeft() + getPaddingRight() + (viewPager.getAdapter().getCount() * this.i) + ((count - 1) * this.j);
            f = paddingLeft;
            if (mode == Integer.MIN_VALUE) {
                f = Math.min(paddingLeft, size);
            }
        }
        return (int) Math.ceil(f);
    }

    private int b(int i) {
        float strokeWidth;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            strokeWidth = size;
        } else {
            strokeWidth = this.f10997c.getStrokeWidth() + getPaddingTop() + getPaddingBottom();
            if (mode == Integer.MIN_VALUE) {
                strokeWidth = Math.min(strokeWidth, size);
            }
        }
        return (int) Math.ceil(strokeWidth);
    }

    public void a(ViewPager viewPager, int i) {
        setViewPager(viewPager);
        setCurrentItem(i);
    }

    public float getGapWidth() {
        return this.j;
    }

    public float getLineWidth() {
        return this.i;
    }

    public int getSelectedColor() {
        return this.f10997c.getColor();
    }

    public float getStrokeWidth() {
        return this.f10997c.getStrokeWidth();
    }

    public int getUnselectedColor() {
        return this.b.getColor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int count;
        super.onDraw(canvas);
        ViewPager viewPager = this.e;
        if (viewPager == null || (count = viewPager.getAdapter().getCount()) == 0) {
            return;
        }
        if (this.g >= count) {
            setCurrentItem(count - 1);
            return;
        }
        float f = this.i;
        float f2 = this.j;
        float f3 = f + f2;
        float f4 = count;
        float f5 = this.k;
        float paddingTop = getPaddingTop();
        float paddingLeft = getPaddingLeft();
        float paddingRight = getPaddingRight();
        float height = paddingTop + (((getHeight() - paddingTop) - getPaddingBottom()) / 2.0f);
        float f6 = paddingLeft;
        if (this.h) {
            f6 = paddingLeft + ((((getWidth() - paddingLeft) - paddingRight) / 2.0f) - ((((f4 * f3) - f2) + (f5 - f)) / 2.0f));
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= count) {
                return;
            }
            float f7 = (i2 * f3) + f6 + (i2 > this.g ? this.k - this.i : 0.0f);
            float f8 = this.i;
            float f9 = 0.0f;
            if (i2 == this.g) {
                f9 = this.k - f8;
            }
            RectF rectF = this.f10996a;
            float f10 = this.m;
            rectF.set(f7, height - (f10 / 2.0f), f7 + f8 + f9, (f10 / 2.0f) + height);
            if (i2 == this.g) {
                RectF rectF2 = this.f10996a;
                float f11 = this.l;
                canvas.drawRoundRect(rectF2, f11, f11, this.f10997c);
            } else if (Math.abs(this.m - (this.l * 2.0f)) < 0.4f || this.r) {
                float f12 = this.l;
                canvas.drawCircle(f7 + f12, height, f12, this.d);
            } else {
                RectF rectF3 = this.f10996a;
                float f13 = this.l;
                canvas.drawRoundRect(rectF3, f13, f13, this.b);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(a(i), b(i2));
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.f;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.f;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.g = i;
        invalidate();
        ViewPager.OnPageChangeListener onPageChangeListener = this.f;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.g = savedState.f10998a;
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f10998a = this.g;
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
        try {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.p = MotionEventCompat.getPointerId(motionEvent, 0);
                this.o = motionEvent.getX();
                return true;
            }
            if (action != 1) {
                if (action == 2) {
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
        } catch (Exception e) {
            return true;
        }
    }

    public void setCentered(boolean z) {
        this.h = z;
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

    public void setGapWidth(float f) {
        this.j = f;
        invalidate();
    }

    public void setLineWidth(float f) {
        this.i = f;
        invalidate();
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f = onPageChangeListener;
    }

    public void setSelectedColor(int i) {
        this.f10997c.setColor(i);
        invalidate();
    }

    public void setStrokeWidth(float f) {
        this.f10997c.setStrokeWidth(f);
        this.b.setStrokeWidth(f);
        invalidate();
    }

    public void setUnSelectedCircle(boolean z) {
        this.r = z;
    }

    public void setUnselectedColor(int i) {
        this.b.setColor(i);
        this.d.setColor(i);
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
