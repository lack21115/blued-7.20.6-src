package com.soft.blued.customview;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/PagerSlidingTabStrip.class */
public class PagerSlidingTabStrip extends android.widget.HorizontalScrollView {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f28461a = {16842901, 16842904};
    private int A;
    private Typeface B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private boolean H;
    private LinearLayout.LayoutParams b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout.LayoutParams f28462c;
    private final PageListener d;
    private ViewPager.OnPageChangeListener e;
    private LinearLayout f;
    private ViewPager g;
    private int h;
    private int i;
    private float j;
    private Paint k;
    private Paint l;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/PagerSlidingTabStrip$PageListener.class */
    public class PageListener implements ViewPager.OnPageChangeListener {
        public PageListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip.a(pagerSlidingTabStrip.g.getCurrentItem(), 0);
            }
            if (PagerSlidingTabStrip.this.e != null) {
                PagerSlidingTabStrip.this.e.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            PagerSlidingTabStrip.this.i = i;
            PagerSlidingTabStrip.this.j = f;
            PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
            pagerSlidingTabStrip.a(pagerSlidingTabStrip.g.getCurrentItem(), (int) (PagerSlidingTabStrip.this.f.getChildAt(i).getWidth() * f));
            PagerSlidingTabStrip.this.invalidate();
            if (PagerSlidingTabStrip.this.e != null) {
                PagerSlidingTabStrip.this.e.onPageScrolled(i, f, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.e != null) {
                PagerSlidingTabStrip.this.e.onPageSelected(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/PagerSlidingTabStrip$SavedState.class */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.soft.blued.customview.PagerSlidingTabStrip.SavedState.1
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
        int f28466a;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f28466a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f28466a);
        }
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new PageListener();
        this.i = 0;
        this.j = 0.0f;
        this.m = false;
        this.n = -16738064;
        this.o = Color.LTGRAY;
        this.p = 436207616;
        this.q = false;
        this.r = 52;
        this.s = 2;
        this.t = 0;
        this.u = 4;
        this.v = 10;
        this.w = 8;
        this.x = 0;
        this.y = 20;
        this.z = -16738064;
        this.A = -6052957;
        this.B = null;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.H = true;
        if (isInEditMode()) {
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.F = displayMetrics.widthPixels;
        this.G = displayMetrics.heightPixels;
        setFillViewport(true);
        setWillNotDraw(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f = linearLayout;
        linearLayout.setOrientation(0);
        this.f.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        addView(this.f);
        DisplayMetrics displayMetrics2 = getResources().getDisplayMetrics();
        this.r = (int) TypedValue.applyDimension(1, this.r, displayMetrics2);
        this.s = (int) TypedValue.applyDimension(1, this.s, displayMetrics2);
        this.t = (int) TypedValue.applyDimension(1, this.t, displayMetrics2);
        this.u = (int) TypedValue.applyDimension(1, this.u, displayMetrics2);
        this.v = (int) TypedValue.applyDimension(1, this.v, displayMetrics2);
        this.x = (int) TypedValue.applyDimension(1, this.x, displayMetrics2);
        this.y = (int) TypedValue.applyDimension(2, this.y, displayMetrics2);
        this.w = (int) TypedValue.applyDimension(2, this.w, displayMetrics2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f28461a);
        this.y = obtainStyledAttributes.getDimensionPixelSize(0, this.y);
        this.z = obtainStyledAttributes.getColor(13, this.z);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.PagerSlidingTabStrip);
        this.n = obtainStyledAttributes2.getColor(1, this.n);
        this.o = obtainStyledAttributes2.getColor(18, this.o);
        this.p = obtainStyledAttributes2.getColor(0, this.p);
        this.s = obtainStyledAttributes2.getDimensionPixelSize(2, this.s);
        this.t = obtainStyledAttributes2.getDimensionPixelSize(19, this.t);
        this.u = obtainStyledAttributes2.getDimensionPixelSize(16, this.u);
        this.v = obtainStyledAttributes2.getDimensionPixelSize(10, this.v);
        this.E = obtainStyledAttributes2.getResourceId(7, this.E);
        this.q = obtainStyledAttributes2.getBoolean(6, this.q);
        this.r = obtainStyledAttributes2.getDimensionPixelSize(5, this.r);
        obtainStyledAttributes2.recycle();
        Paint paint = new Paint();
        this.k = paint;
        paint.setAntiAlias(true);
        this.k.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.l = paint2;
        paint2.setAntiAlias(true);
        this.l.setStrokeWidth(this.x);
        this.b = new LinearLayout.LayoutParams(-2, -1);
        this.f28462c = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    private void a(int i) {
        ImageView imageView;
        ImageView imageView2 = (ImageView) ((LinearLayout) this.f.getChildAt(0)).getChildAt(0);
        ImageView imageView3 = (ImageView) ((LinearLayout) this.f.getChildAt(1)).getChildAt(0);
        TextView textView = (TextView) ((LinearLayout) this.f.getChildAt(0)).getChildAt(1);
        TextView textView2 = (TextView) ((LinearLayout) this.f.getChildAt(1)).getChildAt(1);
        TextView textView3 = null;
        if (this.H) {
            imageView = null;
        } else {
            imageView = (ImageView) ((LinearLayout) this.f.getChildAt(2)).getChildAt(0);
            textView3 = (TextView) ((LinearLayout) this.f.getChildAt(2)).getChildAt(1);
        }
        if (i == 0) {
            textView.setTextColor(this.z);
            textView2.setTextColor(this.A);
            imageView2.setImageResource(R.drawable.navclass_locationcurrent);
            imageView3.setImageResource(2131235873);
            if (this.H) {
                return;
            }
            textView3.setTextColor(this.A);
            imageView.setImageResource(2131235869);
        } else if (i == 1) {
            textView.setTextColor(this.A);
            textView2.setTextColor(this.z);
            imageView2.setImageResource(2131235871);
            imageView3.setImageResource(R.drawable.navclass_timecurrent);
            if (this.H) {
                return;
            }
            textView3.setTextColor(this.A);
            imageView.setImageResource(2131235869);
        } else if (i != 2) {
        } else {
            textView.setTextColor(this.A);
            textView2.setTextColor(this.A);
            imageView2.setImageResource(2131235871);
            imageView3.setImageResource(2131235873);
            if (this.H) {
                return;
            }
            textView3.setTextColor(this.z);
            imageView.setImageResource(R.drawable.navclass_hotcurrent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0017, code lost:
        if (r6 > 0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r5, int r6) {
        /*
            r4 = this;
            r0 = r4
            android.widget.LinearLayout r0 = r0.f
            r1 = r5
            android.view.View r0 = r0.getChildAt(r1)
            int r0 = r0.getLeft()
            r1 = r6
            int r0 = r0 + r1
            r8 = r0
            r0 = r5
            if (r0 > 0) goto L1a
            r0 = r8
            r7 = r0
            r0 = r6
            if (r0 <= 0) goto L22
        L1a:
            r0 = r8
            r1 = r4
            int r1 = r1.r
            int r0 = r0 - r1
            r7 = r0
        L22:
            r0 = r7
            r1 = r4
            int r1 = r1.D
            if (r0 == r1) goto L35
            r0 = r4
            r1 = r7
            r0.D = r1
            r0 = r4
            r1 = r7
            r2 = 0
            r0.scrollTo(r1, r2)
        L35:
            r0 = r4
            r1 = r5
            r0.a(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.customview.PagerSlidingTabStrip.a(int, int):void");
    }

    private void a(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setFocusable(true);
        textView.setGravity(17);
        textView.setSingleLine();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(17);
        ImageView imageView = new ImageView(getContext());
        imageView.setVisibility(8);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        ((ViewGroup.MarginLayoutParams) imageView.getLayoutParams()).rightMargin = 6;
        if (i == 0) {
            imageView.setImageResource(2131235871);
        } else if (i == 1) {
            imageView.setImageResource(2131235873);
        } else if (i == 2) {
            imageView.setImageResource(2131235869);
        }
        linearLayout.addView(imageView);
        linearLayout.addView(textView);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.customview.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PagerSlidingTabStrip.this.g.setCurrentItem(i);
            }
        });
        this.f.addView(linearLayout);
    }

    private void b() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.h) {
                return;
            }
            LinearLayout linearLayout = (LinearLayout) this.f.getChildAt(i2);
            linearLayout.setBackgroundResource(this.E);
            if (this.q) {
                linearLayout.setPadding(0, 0, 0, 0);
            } else {
                int i3 = this.v;
                linearLayout.setPadding(i3, 0, i3, this.w);
            }
            ((TextView) linearLayout.getChildAt(1)).setTextSize(0, this.y);
            ((TextView) linearLayout.getChildAt(1)).setTypeface(this.B, this.C);
            ((TextView) linearLayout.getChildAt(1)).setTextColor(this.z);
            i = i2 + 1;
        }
    }

    public void a() {
        this.f.removeAllViews();
        this.h = this.g.getAdapter().getCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.h) {
                b();
                this.m = false;
                getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.soft.blued.customview.PagerSlidingTabStrip.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        PagerSlidingTabStrip.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
                        pagerSlidingTabStrip.i = pagerSlidingTabStrip.g.getCurrentItem();
                        PagerSlidingTabStrip pagerSlidingTabStrip2 = PagerSlidingTabStrip.this;
                        pagerSlidingTabStrip2.a(pagerSlidingTabStrip2.i, 0);
                    }
                });
                return;
            }
            a(i2, this.g.getAdapter().getPageTitle(i2).toString());
            i = i2 + 1;
        }
    }

    public int getDividerColor() {
        return this.p;
    }

    public int getDividerPadding() {
        return this.u;
    }

    public int getIndicatorColor() {
        return this.n;
    }

    public int getIndicatorHeight() {
        return this.s;
    }

    public int getScrollOffset() {
        return this.r;
    }

    public boolean getShuldExpand() {
        return this.q;
    }

    public int getTabBackground() {
        return this.E;
    }

    public int getTabPaddingLeftRight() {
        return this.v;
    }

    public int getTextColor() {
        return this.z;
    }

    public int getTextSize() {
        return this.y;
    }

    public int getUnderlineColor() {
        return this.o;
    }

    public int getUnderlineHeight() {
        return this.t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode() || this.h == 0) {
            return;
        }
        int height = getHeight();
        this.k.setColor(this.n);
        View childAt = this.f.getChildAt(this.i);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        float f = right;
        float f2 = left;
        if (this.j > 0.0f) {
            int i = this.i;
            f = right;
            f2 = left;
            if (i < this.h - 1) {
                View childAt2 = this.f.getChildAt(i + 1);
                float left2 = childAt2.getLeft();
                float right2 = childAt2.getRight();
                float f3 = this.j;
                f2 = (left2 * f3) + ((1.0f - f3) * left);
                f = (right2 * f3) + ((1.0f - f3) * right);
            }
        }
        float f4 = height - this.s;
        float f5 = height;
        canvas.drawRect(f2, f4, f, f5, this.k);
        this.k.setColor(this.o);
        canvas.drawRect(0.0f, height - this.t, this.f.getWidth(), f5, this.k);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.q || View.MeasureSpec.getMode(i) == 0) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int i3 = 0;
        for (int i4 = 0; i4 < this.h; i4++) {
            i3 += this.f.getChildAt(i4).getMeasuredWidth();
        }
        if (this.m || i3 <= 0 || measuredWidth <= 0) {
            return;
        }
        if (i3 <= measuredWidth) {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= this.h) {
                    break;
                }
                this.f.getChildAt(i6).setLayoutParams(this.f28462c);
                i5 = i6 + 1;
            }
        }
        this.m = true;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.i = savedState.f28466a;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f28466a = this.i;
        return savedState;
    }

    public void setDividerColor(int i) {
        this.p = i;
        invalidate();
    }

    public void setDividerColorResource(int i) {
        this.p = getResources().getColor(i);
        invalidate();
    }

    public void setDividerPadding(int i) {
        this.u = i;
        invalidate();
    }

    public void setIndicatorColor(int i) {
        this.n = i;
        invalidate();
    }

    public void setIndicatorColorResource(int i) {
        this.n = getResources().getColor(i);
        invalidate();
    }

    public void setIndicatorHeight(int i) {
        this.s = i;
        invalidate();
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.e = onPageChangeListener;
    }

    public void setScrollOffset(int i) {
        this.r = i;
        invalidate();
    }

    public void setShouldExpand(boolean z) {
        this.q = z;
        requestLayout();
    }

    public void setTabBackground(int i) {
        this.E = i;
    }

    public void setTabPaddingLeftRight(int i) {
        this.v = i;
        b();
    }

    public void setTextColor(int i) {
        this.z = i;
        b();
    }

    public void setTextColorResource(int i) {
        this.z = getResources().getColor(i);
        b();
    }

    public void setTextSize(int i) {
        this.y = i;
        b();
    }

    public void setTwoTab(boolean z) {
        this.H = z;
    }

    public void setUnderlineColor(int i) {
        this.o = i;
        invalidate();
    }

    public void setUnderlineColorResource(int i) {
        this.o = getResources().getColor(i);
        invalidate();
    }

    public void setUnderlineHeight(int i) {
        this.t = i;
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        this.g = viewPager;
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        viewPager.setOnPageChangeListener(this.d);
        a();
    }
}
