package com.blued.android.module.common.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
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
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.android.internal.R;
import com.blued.android.core.utils.skin.BluedSkinPreferences;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.badgeview.QBadgeContainer;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/TabPageIndicatorWithDot.class */
public class TabPageIndicatorWithDot extends HorizontalScrollView implements BluedSkinSupportable {
    private static final int[] C = {R.attr.textSize, R.attr.textColor};
    public int A;
    public int B;
    private LinearLayout.LayoutParams D;
    private final PageListener E;
    private ViewPager.OnPageChangeListener F;
    private ViewPager G;
    private boolean H;
    private Paint I;
    private boolean J;
    private boolean K;
    private int L;
    private int M;
    private int N;
    private int O;
    private int P;
    private float Q;
    private Typeface R;
    private int S;
    private int T;
    private int U;
    private int V;
    private int W;
    public Context a;
    private List<TextView> aa;
    private List<View> ab;
    private List<QBadgeContainer> ac;
    private int ad;
    private int ae;
    private int af;
    private int ag;
    private int ah;
    private boolean ai;
    private OnTitleClickListener aj;
    public RelativeLayout.LayoutParams b;
    public LinearLayout.LayoutParams c;
    public LinearLayout d;
    public int e;
    public int f;
    public float g;
    public int h;
    public Paint i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public int s;
    public float t;
    public float u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/TabPageIndicatorWithDot$OnTitleClickListener.class */
    public interface OnTitleClickListener {
        void onClick(int i);
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/TabPageIndicatorWithDot$PageListener.class */
    public class PageListener implements ViewPager.OnPageChangeListener {
        public PageListener() {
        }

        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                TabPageIndicatorWithDot tabPageIndicatorWithDot = TabPageIndicatorWithDot.this;
                tabPageIndicatorWithDot.b(tabPageIndicatorWithDot.G.getCurrentItem(), 0);
            }
            if (TabPageIndicatorWithDot.this.F != null) {
                TabPageIndicatorWithDot.this.F.onPageScrollStateChanged(i);
            }
        }

        public void onPageScrolled(int i, float f, int i2) {
            TabPageIndicatorWithDot.this.f = i;
            TabPageIndicatorWithDot.this.g = f;
            if (TabPageIndicatorWithDot.this.d != null && TabPageIndicatorWithDot.this.d.getChildAt(i) != null) {
                TabPageIndicatorWithDot tabPageIndicatorWithDot = TabPageIndicatorWithDot.this;
                tabPageIndicatorWithDot.b(i, (int) (tabPageIndicatorWithDot.d.getChildAt(i).getWidth() * f));
            }
            TabPageIndicatorWithDot.this.invalidate();
            if (TabPageIndicatorWithDot.this.F != null) {
                TabPageIndicatorWithDot.this.F.onPageScrolled(i, f, i2);
            }
        }

        public void onPageSelected(int i) {
            TabPageIndicatorWithDot.this.h = i;
            if (TabPageIndicatorWithDot.this.F != null) {
                TabPageIndicatorWithDot.this.F.onPageSelected(i);
            }
            TabPageIndicatorWithDot.this.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/TabPageIndicatorWithDot$SavedState.class */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.blued.android.module.common.view.TabPageIndicatorWithDot.SavedState.1
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

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/TabPageIndicatorWithDot$TabData.class */
    public class TabData {
        public float a;
        public float b;
        public float c;

        public TabData() {
        }
    }

    public TabPageIndicatorWithDot(Context context) {
        this(context, null);
    }

    public TabPageIndicatorWithDot(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabPageIndicatorWithDot(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.E = new PageListener();
        this.H = false;
        this.f = 0;
        this.g = 0.0f;
        this.h = 0;
        this.J = false;
        this.j = com.blued.android.module.common.R.color.syc_h;
        this.k = -14803165;
        this.l = com.blued.android.module.common.R.color.tab_bottom_line;
        this.m = -16738064;
        this.n = com.blued.android.module.common.R.color.tab_bottom_line;
        this.o = -16738064;
        this.p = -15037442;
        this.q = -15046914;
        this.r = false;
        this.K = false;
        this.L = 52;
        this.s = 2;
        this.t = -1.0f;
        this.u = 10.0f;
        this.M = 0;
        this.N = 4;
        this.v = 15;
        this.O = 0;
        this.P = 0;
        this.Q = 15.0f;
        this.w = 19;
        this.x = 16;
        this.y = -16119286;
        this.z = com.blued.android.module.common.R.color.syc_h;
        this.A = -9013642;
        this.B = com.blued.android.module.common.R.color.syc_j;
        this.R = null;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.ad = -1;
        this.ae = 0;
        this.af = com.blued.android.module.common.R.color.syc_g;
        this.ah = 0;
        this.ai = true;
        this.a = context;
        if (isInEditMode()) {
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.V = displayMetrics.widthPixels;
        this.W = displayMetrics.heightPixels;
        setFillViewport(true);
        setWillNotDraw(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.d = linearLayout;
        linearLayout.setOrientation(0);
        this.d.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        addView(this.d);
        DisplayMetrics displayMetrics2 = getResources().getDisplayMetrics();
        this.L = (int) TypedValue.applyDimension(1, this.L, displayMetrics2);
        this.s = (int) TypedValue.applyDimension(1, this.s, displayMetrics2);
        this.t = (int) TypedValue.applyDimension(1, this.t, displayMetrics2);
        this.M = (int) TypedValue.applyDimension(1, this.M, displayMetrics2);
        this.N = (int) TypedValue.applyDimension(1, this.N, displayMetrics2);
        this.v = (int) TypedValue.applyDimension(1, this.v, displayMetrics2);
        this.O = (int) TypedValue.applyDimension(1, this.O, displayMetrics2);
        this.w = (int) TypedValue.applyDimension(2, this.w, displayMetrics2);
        this.x = (int) TypedValue.applyDimension(2, this.x, displayMetrics2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C);
        this.w = obtainStyledAttributes.getDimensionPixelSize(0, this.w);
        this.ag = DensityUtils.a(getContext(), 10.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, com.blued.android.module.common.R.styleable.PagerSlidingTabStrip);
        a();
        if (obtainStyledAttributes2.hasValue(com.blued.android.module.common.R.styleable.PagerSlidingTabStrip_tabBackground)) {
            this.U = obtainStyledAttributes2.getResourceId(com.blued.android.module.common.R.styleable.PagerSlidingTabStrip_tabBackground, this.U);
        }
        this.N = obtainStyledAttributes2.getDimensionPixelSize(com.blued.android.module.common.R.styleable.PagerSlidingTabStrip_tabdividerPadding, this.N);
        this.v = obtainStyledAttributes2.getDimensionPixelSize(com.blued.android.module.common.R.styleable.PagerSlidingTabStrip_tabPaddingLeftRight, this.v);
        this.K = obtainStyledAttributes2.getBoolean(com.blued.android.module.common.R.styleable.PagerSlidingTabStrip_shouldExpand, this.K);
        this.L = obtainStyledAttributes2.getDimensionPixelSize(com.blued.android.module.common.R.styleable.PagerSlidingTabStrip_scrollOffset, this.L);
        this.u = obtainStyledAttributes2.getDimension(com.blued.android.module.common.R.styleable.PagerSlidingTabStrip_indicatorRadius, this.u);
        this.t = obtainStyledAttributes2.getDimension(com.blued.android.module.common.R.styleable.PagerSlidingTabStrip_indicatorWidth, this.t);
        obtainStyledAttributes2.recycle();
        Paint paint = new Paint();
        this.i = paint;
        paint.setAntiAlias(true);
        this.i.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.I = paint2;
        paint2.setAntiAlias(true);
        this.I.setStrokeWidth(this.O);
        this.c = new LinearLayout.LayoutParams(-2, -1);
        this.b = new RelativeLayout.LayoutParams(-2, DensityUtils.a(context, 44.0f));
        this.D = new LinearLayout.LayoutParams(0, DensityUtils.a(context, 44.0f), 1.0f);
        this.P = DensityUtils.a(context, 30.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i, View view) {
        this.G.setCurrentItem(i);
        OnTitleClickListener onTitleClickListener = this.aj;
        if (onTitleClickListener != null) {
            onTitleClickListener.onClick(i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v24, types: [com.blued.android.framework.view.shape.ShapeHelper$ShapeView, com.blued.android.framework.view.shape.ShapeTextView, android.view.View, java.lang.Object] */
    private void a(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setFocusable(true);
        textView.setGravity(17);
        textView.setSingleLine();
        textView.setPadding(0, 0, 0, DensityUtils.a(this.a, this.Q));
        List<TextView> list = this.aa;
        if (list != null) {
            list.add(textView);
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag(str + i);
        linearLayout.setLayoutParams(this.c);
        linearLayout.setGravity(17);
        ImageView imageView = new ImageView(getContext());
        imageView.setVisibility(8);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        ((ViewGroup.MarginLayoutParams) imageView.getLayoutParams()).rightMargin = 6;
        ?? shapeTextView = new ShapeTextView(getContext());
        if (this.ai) {
            ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, DensityUtils.a(this.a, 1.0f), 0.0f, 0.0f);
            ShapeHelper.d(shapeTextView, com.blued.android.module.common.R.color.syc_b);
        }
        ShapeHelper.b(shapeTextView, this.af);
        ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, this.ag / 2);
        shapeTextView.setVisibility(4);
        int i2 = this.ag;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        layoutParams.gravity = 48;
        int i3 = this.ah;
        int i4 = i3;
        if (i3 <= 0) {
            i4 = this.ag / 2;
        }
        layoutParams.topMargin = i4;
        shapeTextView.setLayoutParams(layoutParams);
        Collection collection = this.ab;
        if (collection != null) {
            collection.add(shapeTextView);
        }
        if (i == 0) {
            imageView.setImageResource(com.blued.android.module.common.R.drawable.navclass_location);
        } else if (i == 1) {
            imageView.setImageResource(com.blued.android.module.common.R.drawable.navclass_time);
        } else if (i == 2) {
            imageView.setImageResource(com.blued.android.module.common.R.drawable.navclass_hot);
        }
        linearLayout.addView(imageView);
        linearLayout.addView(textView);
        linearLayout.addView(shapeTextView);
        QBadgeContainer qBadgeContainer = new QBadgeContainer(this.a);
        qBadgeContainer.setGravity(17);
        qBadgeContainer.setLayoutParams(this.b);
        qBadgeContainer.addView(linearLayout);
        qBadgeContainer.a(linearLayout);
        qBadgeContainer.d(8388661);
        qBadgeContainer.b(5.0f, true);
        qBadgeContainer.a(10.0f, true);
        qBadgeContainer.a(3.0f, 0.0f, true);
        qBadgeContainer.a("");
        qBadgeContainer.a(BluedSkinUtils.a(this.a, com.blued.android.module.common.R.color.syc_b), 1.0f, true);
        qBadgeContainer.b(BluedSkinUtils.a(this.a, com.blued.android.module.common.R.color.nafio_g));
        Collection collection2 = this.ac;
        if (collection2 != null) {
            collection2.add(qBadgeContainer);
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.view.-$$Lambda$TabPageIndicatorWithDot$0XNcGhIQyw6jz_y1reD3L-0fzds
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TabPageIndicatorWithDot.this.a(i, view);
            }
        });
        this.d.addView(qBadgeContainer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0015, code lost:
        if (r6 > 0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(int r5, int r6) {
        /*
            r4 = this;
            r0 = r4
            android.widget.LinearLayout r0 = r0.d
            r1 = r5
            android.view.View r0 = r0.getChildAt(r1)
            int r0 = r0.getLeft()
            r1 = r6
            int r0 = r0 + r1
            r7 = r0
            r0 = r5
            if (r0 > 0) goto L18
            r0 = r7
            r5 = r0
            r0 = r6
            if (r0 <= 0) goto L1f
        L18:
            r0 = r7
            r1 = r4
            int r1 = r1.L
            int r0 = r0 - r1
            r5 = r0
        L1f:
            r0 = r5
            r1 = r4
            int r1 = r1.T
            if (r0 == r1) goto L32
            r0 = r4
            r1 = r5
            r0.T = r1
            r0 = r4
            r1 = r5
            r2 = 0
            r0.scrollTo(r1, r2)
        L32:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.view.TabPageIndicatorWithDot.b(int, int):void");
    }

    private void c() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.e) {
                return;
            }
            QBadgeContainer qBadgeContainer = (QBadgeContainer) this.d.getChildAt(i2);
            LinearLayout linearLayout = (LinearLayout) qBadgeContainer.findViewWithTag(this.G.getAdapter().getPageTitle(i2).toString() + i2);
            if (linearLayout == null) {
                return;
            }
            linearLayout.setBackgroundResource(this.U);
            if (this.K) {
                linearLayout.setPadding(0, 0, 0, 0);
            } else {
                int i3 = this.v;
                linearLayout.setPadding(i3, 0, i3, 0);
            }
            TextView textView = (TextView) linearLayout.getChildAt(1);
            textView.setTextSize(0, this.w);
            textView.setTypeface(this.R, this.S);
            textView.setTextColor(this.y);
            i = i2 + 1;
        }
    }

    private void d() {
        List<QBadgeContainer> list;
        if (this.ae <= 0 || this.ad == -1 || (list = this.ac) == null || list.isEmpty()) {
            return;
        }
        for (QBadgeContainer qBadgeContainer : this.ac) {
            qBadgeContainer.a(BluedSkinUtils.a(this.a, this.ad), this.ae, true);
        }
    }

    public TabData a(View view) {
        TabData tabData = new TabData();
        tabData.a = (view.getRight() - this.ag) - view.getLeft();
        tabData.b = view.getLeft();
        tabData.c = view.getRight() - this.ag;
        if (tabData.a > 0.0f && this.t > 0.0f) {
            tabData.b = (view.getLeft() + (tabData.a / 2.0f)) - (this.t / 2.0f);
            tabData.c = view.getLeft() + (tabData.a / 2.0f) + (this.t / 2.0f);
        }
        return tabData;
    }

    public void a() {
        this.t = DensityUtils.a(this.a, 18.0f);
        this.s = DensityUtils.a(this.a, 2.5f);
        this.z = com.blued.android.module.common.R.color.syc_h;
        this.j = com.blued.android.module.common.R.color.syc_h;
        this.B = com.blued.android.module.common.R.color.syc_j;
        if (BluedSkinPreferences.b()) {
            this.y = com.blued.android.module.common.R.color.syc_EAEAEA;
            this.k = com.blued.android.module.common.R.color.syc_EAEAEA;
            this.A = com.blued.android.module.common.R.color.syc_D0D0D0;
            return;
        }
        this.y = com.blued.android.module.common.R.color.syc_h;
        this.k = com.blued.android.module.common.R.color.syc_h;
        this.A = com.blued.android.module.common.R.color.syc_j;
    }

    public void a(int i) {
        if (this.aa == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.aa.size()) {
                return;
            }
            TextView textView = this.aa.get(i3);
            if (textView != null) {
                if (i3 == i) {
                    textView.setTextColor(this.y);
                    textView.setTextSize(0, this.w);
                } else {
                    textView.setTextColor(this.A);
                    if (this.A != -1) {
                        textView.setTextSize(0, this.x);
                    } else {
                        textView.setTextSize(0, this.w);
                    }
                }
            }
            i2 = i3 + 1;
        }
    }

    public void a(int i, int i2) {
        this.q = i;
        this.p = i2;
        invalidate();
    }

    public void a(Canvas canvas, int i, int i2) {
        int height = getHeight() - getPaddingBottom();
        if (this.u <= 0.0f) {
            canvas.drawRect(i, height - this.s, i2, height, this.i);
            return;
        }
        RectF rectF = new RectF();
        rectF.left = i;
        rectF.top = height - this.s;
        rectF.right = i2;
        rectF.bottom = height;
        float f = this.u;
        canvas.drawRoundRect(rectF, f, f, this.i);
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        this.k = BluedSkinUtils.a(this.a, this.j);
        this.y = BluedSkinUtils.a(this.a, this.z);
        this.A = BluedSkinUtils.a(this.a, this.B);
        d();
        a(this.f);
    }

    public void b() {
        this.d.removeAllViews();
        this.e = this.G.getAdapter().getCount();
        List<TextView> list = this.aa;
        if (list != null) {
            list.clear();
        } else {
            this.aa = new ArrayList();
        }
        List<View> list2 = this.ab;
        if (list2 != null) {
            list2.clear();
        } else {
            this.ab = new ArrayList();
        }
        List<QBadgeContainer> list3 = this.ac;
        if (list3 != null) {
            list3.clear();
        } else {
            this.ac = new ArrayList();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.e) {
                c();
                this.J = false;
                getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.blued.android.module.common.view.TabPageIndicatorWithDot.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        TabPageIndicatorWithDot.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        TabPageIndicatorWithDot tabPageIndicatorWithDot = TabPageIndicatorWithDot.this;
                        tabPageIndicatorWithDot.f = tabPageIndicatorWithDot.G.getCurrentItem();
                        TabPageIndicatorWithDot tabPageIndicatorWithDot2 = TabPageIndicatorWithDot.this;
                        tabPageIndicatorWithDot2.b(tabPageIndicatorWithDot2.f, 0);
                        TabPageIndicatorWithDot tabPageIndicatorWithDot3 = TabPageIndicatorWithDot.this;
                        tabPageIndicatorWithDot3.a(tabPageIndicatorWithDot3.f);
                    }
                });
                return;
            }
            a(i2, this.G.getAdapter().getPageTitle(i2).toString());
            i = i2 + 1;
        }
    }

    public int getDividerColor() {
        return this.o;
    }

    public int getDividerPadding() {
        return this.N;
    }

    public int getIndicatorColor() {
        return this.k;
    }

    public int getIndicatorHeight() {
        return this.s;
    }

    public int getScrollOffset() {
        return this.L;
    }

    public boolean getShuldExpand() {
        return this.K;
    }

    public int getTabBackground() {
        return this.U;
    }

    public int getTabPaddingLeftRight() {
        return this.v;
    }

    public int getTextColor() {
        return this.y;
    }

    public int getTextSize() {
        return this.w;
    }

    public int getUnderlineColor() {
        return this.m;
    }

    public int getUnderlineHeight() {
        return this.M;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (isInEditMode() || this.e == 0) {
            return;
        }
        int height = getHeight() - getPaddingBottom();
        TabData a = a(this.d.getChildAt(this.f));
        int i2 = this.f;
        int i3 = this.h;
        if (this.g > 0.0f && (i = this.f) < this.e - 1) {
            TabData a2 = a(this.d.getChildAt(i + 1));
            if (this.g < 0.5d) {
                a.b += this.g * this.P;
                a.c = (a.c + ((this.g * 2.0f) * (a2.c - a.c))) - (this.g * this.P);
            } else {
                float f = a.b;
                float f2 = this.g;
                float f3 = a2.b;
                float f4 = a.b;
                int i4 = this.P;
                a.b = f + ((f2 - 0.5f) * 2.0f * ((f3 - f4) - (i4 / 2))) + (i4 / 2);
                a.c = a2.c - ((1.0f - this.g) * this.P);
            }
        }
        this.i.setShader(new LinearGradient(((a.c - a.b) / 2.0f) + a.b, 0.0f, a.c, this.r ? this.s / 2 : this.s, new int[]{this.q, this.p}, (float[]) null, Shader.TileMode.CLAMP));
        if (this.e > 1 || this.H) {
            a(canvas, (int) a.b, (int) a.c);
        }
        canvas.drawRect(0.0f, height - this.M, this.d.getWidth(), height, this.i);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.K || View.MeasureSpec.getMode(i) == 0) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int i3 = 0;
        for (int i4 = 0; i4 < this.e; i4++) {
            i3 += this.d.getChildAt(i4).getMeasuredWidth();
        }
        if (this.J || i3 <= 0 || measuredWidth <= 0) {
            return;
        }
        if (i3 <= measuredWidth) {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= this.e) {
                    break;
                }
                this.d.getChildAt(i6).setLayoutParams(this.D);
                i5 = i6 + 1;
            }
        }
        this.J = true;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f = savedState.a;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.f;
        return savedState;
    }

    public void setDividerColor(int i) {
        this.n = i;
        this.o = BluedSkinUtils.a(this.a, i);
        invalidate();
    }

    public void setDividerPadding(int i) {
        this.N = i;
        invalidate();
    }

    public void setForeverShowTabIndicator(boolean z) {
        this.H = z;
        invalidate();
    }

    public void setHorizontalShade(boolean z) {
        this.r = z;
    }

    public void setIndicatorColor(int i) {
        this.j = i;
        this.k = BluedSkinUtils.a(this.a, i);
        invalidate();
    }

    public void setIndicatorHeight(int i) {
        this.s = i;
        invalidate();
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.F = onPageChangeListener;
    }

    public void setOnTitleClickListener(OnTitleClickListener onTitleClickListener) {
        this.aj = onTitleClickListener;
    }

    public void setRealTabTextColorUnfocused(int i) {
        this.B = i;
        this.A = this.a.getResources().getColor(this.B);
        c();
    }

    public void setRealTextColor(int i) {
        this.z = i;
        this.y = this.a.getResources().getColor(this.z);
        c();
    }

    public void setRedDotColorRes(int i) {
        this.af = i;
    }

    public void setRedDotDiameter(int i) {
        this.ag = i;
        invalidate();
    }

    public void setRedDotIsHasWhiteStroke(boolean z) {
        this.ai = z;
    }

    public void setRedDotMarginTop(int i) {
        this.ah = i;
        invalidate();
    }

    public void setScrollOffset(int i) {
        this.L = i;
        invalidate();
    }

    public void setShouldExpand(boolean z) {
        this.K = z;
        requestLayout();
    }

    public void setTabBackground(int i) {
        this.U = i;
    }

    public void setTabPaddingLeftRight(int i) {
        this.v = i;
        c();
    }

    public void setTabTextColorUnfocused(int i) {
        this.B = i;
        this.A = BluedSkinUtils.a(this.a, i);
        c();
    }

    public void setTextColor(int i) {
        this.z = i;
        this.y = BluedSkinUtils.a(this.a, i);
        c();
    }

    public void setTextSize(int i) {
        this.w = i;
        c();
    }

    public void setUnderlineColor(int i) {
        this.l = i;
        this.m = BluedSkinUtils.a(this.a, i);
        invalidate();
    }

    public void setUnderlineHeight(int i) {
        this.M = i;
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        this.G = viewPager;
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        viewPager.addOnPageChangeListener(this.E);
        b();
    }
}
