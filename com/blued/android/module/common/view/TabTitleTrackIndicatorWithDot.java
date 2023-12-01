package com.blued.android.module.common.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.android.internal.R;
import com.blued.android.framework.utils.DensityUtils;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/TabTitleTrackIndicatorWithDot.class */
public class TabTitleTrackIndicatorWithDot extends HorizontalScrollView {
    public static final int[] a = {R.attr.textSize, R.attr.textColor};
    public boolean A;
    public boolean B;
    public int C;
    private final PageListener D;
    public LinearLayout.LayoutParams b;
    public LinearLayout.LayoutParams c;
    public ViewPager.OnPageChangeListener d;
    public LinearLayout e;
    public ViewPager f;
    public int g;
    public int h;
    public float i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public Typeface s;
    public int t;
    public boolean u;
    public int v;
    public int w;
    public List<ColorTrackView> x;
    public List<ImageView> y;
    public List<ImageView> z;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/TabTitleTrackIndicatorWithDot$PageListener.class */
    public class PageListener implements ViewPager.OnPageChangeListener {
        public PageListener() {
        }

        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                TabTitleTrackIndicatorWithDot.this.b();
                TabTitleTrackIndicatorWithDot.this.A = false;
            }
            if (TabTitleTrackIndicatorWithDot.this.d != null) {
                TabTitleTrackIndicatorWithDot.this.d.onPageScrollStateChanged(i);
            }
        }

        public void onPageScrolled(int i, float f, int i2) {
            TabTitleTrackIndicatorWithDot.this.h = i;
            TabTitleTrackIndicatorWithDot.this.i = f;
            if (TabTitleTrackIndicatorWithDot.this.x.size() > 0 && TabTitleTrackIndicatorWithDot.this.e.getChildCount() > 0) {
                TabTitleTrackIndicatorWithDot tabTitleTrackIndicatorWithDot = TabTitleTrackIndicatorWithDot.this;
                tabTitleTrackIndicatorWithDot.a(i, (int) (tabTitleTrackIndicatorWithDot.e.getChildAt(i).getWidth() * f));
                if (f > 0.0f && i < TabTitleTrackIndicatorWithDot.this.x.size() - 1 && !TabTitleTrackIndicatorWithDot.this.A) {
                    ColorTrackView colorTrackView = TabTitleTrackIndicatorWithDot.this.x.get(i);
                    ColorTrackView colorTrackView2 = TabTitleTrackIndicatorWithDot.this.x.get(i + 1);
                    colorTrackView.setDirection(1);
                    colorTrackView2.setDirection(0);
                    colorTrackView.setProgress(1.0f - f);
                    colorTrackView2.setProgress(f);
                } else if (f < 0.0f && i > 0 && !TabTitleTrackIndicatorWithDot.this.A) {
                    ColorTrackView colorTrackView3 = TabTitleTrackIndicatorWithDot.this.x.get(i);
                    ColorTrackView colorTrackView4 = TabTitleTrackIndicatorWithDot.this.x.get(i - 1);
                    colorTrackView3.setDirection(1);
                    colorTrackView4.setDirection(0);
                    colorTrackView3.setProgress(1.0f - f);
                    colorTrackView4.setProgress(f);
                }
            }
            if (TabTitleTrackIndicatorWithDot.this.d != null) {
                TabTitleTrackIndicatorWithDot.this.d.onPageScrolled(i, f, i2);
            }
        }

        public void onPageSelected(int i) {
            if (TabTitleTrackIndicatorWithDot.this.A) {
                TabTitleTrackIndicatorWithDot.this.b();
            }
            if (TabTitleTrackIndicatorWithDot.this.d != null) {
                TabTitleTrackIndicatorWithDot.this.d.onPageSelected(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/TabTitleTrackIndicatorWithDot$SavedState.class */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.blued.android.module.common.view.TabTitleTrackIndicatorWithDot.SavedState.1
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
        int a;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
        }
    }

    public TabTitleTrackIndicatorWithDot(Context context) {
        this(context, null);
    }

    public TabTitleTrackIndicatorWithDot(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabTitleTrackIndicatorWithDot(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.D = new PageListener();
        this.h = 0;
        this.i = 0.0f;
        this.j = 52;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 15;
        this.q = 0;
        this.r = 0;
        this.s = null;
        this.t = 0;
        this.v = 0;
        this.A = false;
        this.B = false;
        this.C = 17;
        if (isInEditMode()) {
            return;
        }
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        setFillViewport(true);
        setWillNotDraw(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.e = linearLayout;
        linearLayout.setOrientation(0);
        this.e.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        addView(this.e);
        setTextSize(15);
        setSelectedTextSize(15);
        setTextOriginColor(getResources().getColor(com.blued.android.module.common.R.color.nafio_k));
        setTextChangeColor(getResources().getColor(com.blued.android.module.common.R.color.nafio_a));
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.j = (int) TypedValue.applyDimension(1, this.j, displayMetrics);
        this.k = (int) TypedValue.applyDimension(1, this.k, displayMetrics);
        this.l = (int) TypedValue.applyDimension(1, this.l, displayMetrics);
        this.m = (int) TypedValue.applyDimension(1, this.m, displayMetrics);
        this.n = (int) TypedValue.applyDimension(1, this.n, displayMetrics);
        this.o = (int) TypedValue.applyDimension(2, this.o, displayMetrics);
        this.p = (int) TypedValue.applyDimension(2, this.p, displayMetrics);
        this.w = DensityUtils.a(getContext(), 7.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.blued.android.module.common.R.styleable.PagerSlidingTabStrip);
        this.o = obtainStyledAttributes.getDimensionPixelSize(com.blued.android.module.common.R.styleable.PagerSlidingTabStrip_tabTextSize, this.o);
        this.p = obtainStyledAttributes.getDimensionPixelSize(com.blued.android.module.common.R.styleable.PagerSlidingTabStrip_tabTextSelectdSize, this.p);
        this.q = obtainStyledAttributes.getColor(com.blued.android.module.common.R.styleable.PagerSlidingTabStrip_tabTextColor, this.q);
        this.r = obtainStyledAttributes.getColor(com.blued.android.module.common.R.styleable.PagerSlidingTabStrip_textChangeColor, this.r);
        this.k = obtainStyledAttributes.getDimensionPixelSize(com.blued.android.module.common.R.styleable.PagerSlidingTabStrip_tabPaddingLeft, this.k);
        this.l = obtainStyledAttributes.getDimensionPixelSize(com.blued.android.module.common.R.styleable.PagerSlidingTabStrip_tabPaddingRight, this.l);
        this.m = obtainStyledAttributes.getDimensionPixelSize(com.blued.android.module.common.R.styleable.PagerSlidingTabStrip_tabPaddingTop, this.m);
        this.n = obtainStyledAttributes.getDimensionPixelSize(com.blued.android.module.common.R.styleable.PagerSlidingTabStrip_tabPaddingBottom, this.n);
        this.j = obtainStyledAttributes.getDimensionPixelSize(com.blued.android.module.common.R.styleable.PagerSlidingTabStrip_scrollOffset, this.j);
        this.u = obtainStyledAttributes.getBoolean(com.blued.android.module.common.R.styleable.PagerSlidingTabStrip_shouldExpand, this.u);
        obtainStyledAttributes.recycle();
        if (this.p == 0) {
            this.p = this.o;
        }
        this.b = new LinearLayout.LayoutParams(-2, -2);
        this.c = new LinearLayout.LayoutParams(0, -2, 1.0f);
    }

    private int a(float f) {
        return (int) TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
        if (r6 > 0) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r5, int r6) {
        /*
            r4 = this;
            r0 = r5
            if (r0 < 0) goto L42
            r0 = r5
            r1 = r4
            android.widget.LinearLayout r1 = r1.e
            int r1 = r1.getChildCount()
            if (r0 < r1) goto L10
            return
        L10:
            r0 = r4
            android.widget.LinearLayout r0 = r0.e
            r1 = r5
            android.view.View r0 = r0.getChildAt(r1)
            int r0 = r0.getLeft()
            r1 = r6
            int r0 = r0 + r1
            r7 = r0
            r0 = r5
            if (r0 > 0) goto L28
            r0 = r7
            r5 = r0
            r0 = r6
            if (r0 <= 0) goto L2f
        L28:
            r0 = r7
            r1 = r4
            int r1 = r1.j
            int r0 = r0 - r1
            r5 = r0
        L2f:
            r0 = r5
            r1 = r4
            int r1 = r1.v
            if (r0 == r1) goto L42
            r0 = r4
            r1 = r5
            r0.v = r1
            r0 = r4
            r1 = r5
            r2 = 0
            r0.scrollTo(r1, r2)
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.view.TabTitleTrackIndicatorWithDot.a(int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.x == null || this.f == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.x.size()) {
                a(this.f.getCurrentItem(), 0);
                return;
            }
            if (this.f.getCurrentItem() == i2) {
                this.x.get(i2).setProgress(1.0f);
                this.x.get(i2).setTextSize(this.p);
            } else {
                this.x.get(i2).setProgress(0.0f);
                this.x.get(i2).setTextSize(this.o);
            }
            i = i2 + 1;
        }
    }

    public void a() {
        this.e.removeAllViews();
        this.g = this.f.getAdapter().getCount();
        List<ColorTrackView> list = this.x;
        if (list != null) {
            list.clear();
        } else {
            this.x = new ArrayList();
        }
        List<ImageView> list2 = this.y;
        if (list2 != null) {
            list2.clear();
        } else {
            this.y = new ArrayList();
        }
        List<ImageView> list3 = this.z;
        if (list3 != null) {
            list3.clear();
        } else {
            this.z = new ArrayList();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.g) {
                getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.blued.android.module.common.view.TabTitleTrackIndicatorWithDot.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        TabTitleTrackIndicatorWithDot.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        TabTitleTrackIndicatorWithDot.this.b();
                    }
                });
                return;
            } else {
                a(i2, this.f.getAdapter().getPageTitle(i2).toString());
                i = i2 + 1;
            }
        }
    }

    public void a(final int i, String str) {
        View inflate = LayoutInflater.from(getContext()).inflate(com.blued.android.module.common.R.layout.item_tabtitle, (ViewGroup) null);
        ColorTrackView colorTrackView = (ColorTrackView) inflate.findViewById(com.blued.android.module.common.R.id.colorTrackView);
        colorTrackView.setText(str);
        colorTrackView.setTextSize(this.o);
        colorTrackView.setTextOriginColor(this.q);
        colorTrackView.setTextChangeColor(this.r);
        colorTrackView.setFocusable(true);
        if (i == 0) {
            colorTrackView.setProgress(1.0f);
            colorTrackView.setTextSize(this.p);
        }
        this.x.add(colorTrackView);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(com.blued.android.module.common.R.id.ll_main);
        linearLayout.setLayoutParams(this.u ? this.c : this.b);
        linearLayout.setPadding(this.k, this.m, this.l, this.n);
        linearLayout.setGravity(this.C);
        ImageView imageView = (ImageView) inflate.findViewById(com.blued.android.module.common.R.id.img_dot);
        imageView.setImageResource(com.blued.android.module.common.R.drawable.new_remind);
        imageView.setVisibility(4);
        List<ImageView> list = this.y;
        if (list != null) {
            list.add(imageView);
        }
        ImageView imageView2 = (ImageView) inflate.findViewById(com.blued.android.module.common.R.id.img_underline);
        if (this.B) {
            imageView2.setVisibility(4);
        } else {
            imageView2.setVisibility(8);
        }
        List<ImageView> list2 = this.z;
        if (list2 != null) {
            list2.add(imageView2);
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.view.TabTitleTrackIndicatorWithDot.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                TabTitleTrackIndicatorWithDot.this.A = true;
                TabTitleTrackIndicatorWithDot.this.f.setCurrentItem(i);
            }
        });
        this.e.addView(linearLayout);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.h = savedState.a;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.h;
        return savedState;
    }

    public void setIsShowWithUnderline(boolean z) {
        this.B = z;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.d = onPageChangeListener;
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.k = a(i);
        this.l = a(i3);
        this.m = a(i2);
        this.n = a(i4);
    }

    public void setSelectedTextSize(int i) {
        this.p = i;
    }

    public void setTabLayoutGravity(int i) {
        this.C = i;
    }

    public void setTextChangeColor(int i) {
        this.r = i;
    }

    public void setTextOriginColor(int i) {
        this.q = i;
    }

    public void setTextSize(int i) {
        this.o = i;
    }

    public void setViewPager(ViewPager viewPager) {
        this.f = viewPager;
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        viewPager.setOnPageChangeListener(this.D);
        a();
    }
}
