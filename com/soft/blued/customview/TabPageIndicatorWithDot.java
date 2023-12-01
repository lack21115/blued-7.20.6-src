package com.soft.blued.customview;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.badgeview.QBadgeContainer;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.bytedance.applog.tracker.Tracker;
import com.google.android.material.badge.BadgeDrawable;
import com.soft.blued.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/TabPageIndicatorWithDot.class */
public class TabPageIndicatorWithDot extends android.widget.HorizontalScrollView implements BluedSkinSupportable {
    private static final int[] G = {16842901, 16842904};
    public int A;
    public int B;
    protected List<TextView> C;
    protected List<View> D;
    protected List<QBadgeContainer> E;
    protected OnTitleClickListener F;
    private LinearLayout.LayoutParams H;
    private final PageListener I;
    private ViewPager.OnPageChangeListener J;
    private boolean K;
    private Paint L;
    private boolean M;
    private boolean N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private float T;
    private Typeface U;
    private int V;
    private int W;

    /* renamed from: a  reason: collision with root package name */
    public Context f28520a;
    private int aa;
    private int ab;
    private int ac;
    private int ad;
    private int ae;
    private int af;
    public RelativeLayout.LayoutParams b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout.LayoutParams f28521c;
    public LinearLayout d;
    protected ViewPager e;
    public int f;
    public int g;
    public float h;
    public int i;
    public Paint j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public float t;
    public float u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/TabPageIndicatorWithDot$OnTitleClickListener.class */
    public interface OnTitleClickListener {
        void onClick(int i);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/TabPageIndicatorWithDot$PageListener.class */
    public class PageListener implements ViewPager.OnPageChangeListener {
        public PageListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                TabPageIndicatorWithDot tabPageIndicatorWithDot = TabPageIndicatorWithDot.this;
                tabPageIndicatorWithDot.d(tabPageIndicatorWithDot.e.getCurrentItem(), 0);
            }
            if (TabPageIndicatorWithDot.this.J != null) {
                TabPageIndicatorWithDot.this.J.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            TabPageIndicatorWithDot.this.g = i;
            TabPageIndicatorWithDot.this.h = f;
            if (TabPageIndicatorWithDot.this.d != null && TabPageIndicatorWithDot.this.d.getChildAt(i) != null) {
                TabPageIndicatorWithDot tabPageIndicatorWithDot = TabPageIndicatorWithDot.this;
                tabPageIndicatorWithDot.d(i, (int) (tabPageIndicatorWithDot.d.getChildAt(i).getWidth() * f));
            }
            TabPageIndicatorWithDot.this.invalidate();
            if (TabPageIndicatorWithDot.this.J != null) {
                TabPageIndicatorWithDot.this.J.onPageScrolled(i, f, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            TabPageIndicatorWithDot.this.i = i;
            if (TabPageIndicatorWithDot.this.J != null) {
                TabPageIndicatorWithDot.this.J.onPageSelected(i);
            }
            TabPageIndicatorWithDot.this.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/TabPageIndicatorWithDot$SavedState.class */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.soft.blued.customview.TabPageIndicatorWithDot.SavedState.1
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
        int f28524a;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f28524a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f28524a);
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/TabPageIndicatorWithDot$TabData.class */
    public class TabData {

        /* renamed from: a  reason: collision with root package name */
        public float f28525a;
        public float b;

        /* renamed from: c  reason: collision with root package name */
        public float f28526c;

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
        this.I = new PageListener();
        this.K = true;
        this.g = 0;
        this.h = 0.0f;
        this.i = 0;
        this.M = false;
        this.k = 2131102254;
        this.l = -14803165;
        this.m = 2131102363;
        this.n = -16738064;
        this.o = 2131102363;
        this.p = -16738064;
        this.q = -15037442;
        this.r = -15046914;
        this.N = false;
        this.O = 52;
        this.s = 2;
        this.t = -1.0f;
        this.u = 10.0f;
        this.P = 0;
        this.Q = 4;
        this.v = 15;
        this.R = 0;
        this.S = 0;
        this.T = 15.0f;
        this.w = 19;
        this.x = 16;
        this.y = -16119286;
        this.z = 2131102254;
        this.A = -9013642;
        this.B = 2131102263;
        this.U = null;
        this.V = 0;
        this.W = 0;
        this.aa = 0;
        this.ae = -1;
        this.af = 0;
        this.f28520a = context;
        if (isInEditMode()) {
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.ab = displayMetrics.widthPixels;
        this.ac = displayMetrics.heightPixels;
        setFillViewport(true);
        setWillNotDraw(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.d = linearLayout;
        linearLayout.setOrientation(0);
        this.d.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        addView(this.d);
        DisplayMetrics displayMetrics2 = getResources().getDisplayMetrics();
        this.O = (int) TypedValue.applyDimension(1, this.O, displayMetrics2);
        this.s = (int) TypedValue.applyDimension(1, this.s, displayMetrics2);
        this.t = (int) TypedValue.applyDimension(1, this.t, displayMetrics2);
        this.P = (int) TypedValue.applyDimension(1, this.P, displayMetrics2);
        this.Q = (int) TypedValue.applyDimension(1, this.Q, displayMetrics2);
        this.v = (int) TypedValue.applyDimension(1, this.v, displayMetrics2);
        this.R = (int) TypedValue.applyDimension(1, this.R, displayMetrics2);
        this.w = (int) TypedValue.applyDimension(2, this.w, displayMetrics2);
        this.x = (int) TypedValue.applyDimension(2, this.x, displayMetrics2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, G);
        this.w = obtainStyledAttributes.getDimensionPixelSize(0, this.w);
        this.ad = DensityUtils.a(getContext(), 8.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.PagerSlidingTabStrip);
        a();
        if (obtainStyledAttributes2.hasValue(7)) {
            this.aa = obtainStyledAttributes2.getResourceId(7, this.aa);
        }
        this.Q = obtainStyledAttributes2.getDimensionPixelSize(16, this.Q);
        this.v = obtainStyledAttributes2.getDimensionPixelSize(10, this.v);
        this.N = obtainStyledAttributes2.getBoolean(6, this.N);
        this.O = obtainStyledAttributes2.getDimensionPixelSize(5, this.O);
        this.u = obtainStyledAttributes2.getDimension(3, this.u);
        this.t = obtainStyledAttributes2.getDimension(4, this.t);
        obtainStyledAttributes2.recycle();
        Paint paint = new Paint();
        this.j = paint;
        paint.setAntiAlias(true);
        this.j.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.L = paint2;
        paint2.setAntiAlias(true);
        this.L.setStrokeWidth(this.R);
        this.f28521c = new LinearLayout.LayoutParams(-2, -1);
        this.b = new RelativeLayout.LayoutParams(-2, DensityUtils.a(context, 44.0f));
        this.H = new LinearLayout.LayoutParams(0, DensityUtils.a(context, 44.0f), 1.0f);
        this.S = DensityUtils.a(context, 30.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i, View view) {
        Tracker.onClick(view);
        this.e.setCurrentItem(i);
        OnTitleClickListener onTitleClickListener = this.F;
        if (onTitleClickListener != null) {
            onTitleClickListener.onClick(i);
        }
    }

    private void d() {
        List<QBadgeContainer> list;
        if (this.af <= 0 || this.ae == -1 || (list = this.E) == null || list.isEmpty()) {
            return;
        }
        for (QBadgeContainer qBadgeContainer : this.E) {
            qBadgeContainer.a(BluedSkinUtils.a(this.f28520a, this.ae), this.af, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0015, code lost:
        if (r6 > 0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(int r5, int r6) {
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
            int r1 = r1.O
            int r0 = r0 - r1
            r5 = r0
        L1f:
            r0 = r5
            r1 = r4
            int r1 = r1.W
            if (r0 == r1) goto L32
            r0 = r4
            r1 = r5
            r0.W = r1
            r0 = r4
            r1 = r5
            r2 = 0
            r0.scrollTo(r1, r2)
        L32:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.customview.TabPageIndicatorWithDot.d(int, int):void");
    }

    protected View a(ViewGroup viewGroup) {
        return viewGroup.getChildAt(1);
    }

    public TabData a(View view) {
        TabData tabData = new TabData();
        tabData.f28525a = (view.getRight() - this.ad) - view.getLeft();
        tabData.b = view.getLeft();
        tabData.f28526c = view.getRight() - this.ad;
        if (tabData.f28525a > 0.0f && this.t > 0.0f) {
            tabData.b = (view.getLeft() + (tabData.f28525a / 2.0f)) - (this.t / 2.0f);
            tabData.f28526c = view.getLeft() + (tabData.f28525a / 2.0f) + (this.t / 2.0f);
        }
        return tabData;
    }

    public void a() {
        this.t = DensityUtils.a(this.f28520a, 18.0f);
        this.s = DensityUtils.a(this.f28520a, 2.5f);
        this.y = BluedSkinUtils.a(this.f28520a, 2131102254);
        this.z = 2131102254;
        this.l = BluedSkinUtils.a(this.f28520a, 2131102254);
        this.k = 2131102254;
        this.A = BluedSkinUtils.a(this.f28520a, 2131102263);
        this.B = 2131102263;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i) {
        if (this.C == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.C.size()) {
                return;
            }
            TextView textView = this.C.get(i3);
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
        QBadgeContainer qBadgeContainer;
        List<QBadgeContainer> list = this.E;
        if (list == null || list.isEmpty() || i > this.E.size() - 1 || (qBadgeContainer = this.E.get(i)) == null) {
            return;
        }
        qBadgeContainer.a(i2);
    }

    protected void a(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setFocusable(true);
        textView.setGravity(17);
        textView.setSingleLine();
        textView.setPadding(0, 0, 0, DensityUtils.a(this.f28520a, this.T));
        List<TextView> list = this.C;
        if (list != null) {
            list.add(textView);
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag(str + i);
        linearLayout.setLayoutParams(this.f28521c);
        linearLayout.setGravity(17);
        ImageView imageView = new ImageView(getContext());
        imageView.setVisibility(8);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        ((ViewGroup.MarginLayoutParams) imageView.getLayoutParams()).rightMargin = 6;
        ShapeTextView shapeTextView = new ShapeTextView(getContext());
        ShapeHelper.a(shapeTextView, DensityUtils.a(this.f28520a, 1.0f), 0.0f, 0.0f);
        ShapeHelper.d(shapeTextView, 2131101780);
        ShapeHelper.b(shapeTextView, 2131102251);
        ShapeHelper.a(shapeTextView, this.ad);
        shapeTextView.setVisibility(4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DensityUtils.a(getContext(), 10.0f), DensityUtils.a(getContext(), 10.0f));
        layoutParams.gravity = 48;
        layoutParams.topMargin = this.ad / 2;
        shapeTextView.setLayoutParams(layoutParams);
        List<View> list2 = this.D;
        if (list2 != null) {
            list2.add(shapeTextView);
        }
        if (i == 0) {
            imageView.setImageResource(2131235871);
        } else if (i == 1) {
            imageView.setImageResource(2131235873);
        } else if (i == 2) {
            imageView.setImageResource(2131235869);
        }
        linearLayout.addView(imageView);
        linearLayout.addView(textView);
        linearLayout.addView(shapeTextView);
        QBadgeContainer qBadgeContainer = new QBadgeContainer(this.f28520a);
        qBadgeContainer.setGravity(17);
        qBadgeContainer.setLayoutParams(this.b);
        qBadgeContainer.addView(linearLayout);
        qBadgeContainer.a(linearLayout);
        qBadgeContainer.d(BadgeDrawable.TOP_END);
        qBadgeContainer.b(5.0f, true);
        qBadgeContainer.a(10.0f, true);
        qBadgeContainer.a(3.0f, 0.0f, true);
        qBadgeContainer.a("");
        qBadgeContainer.a(BluedSkinUtils.a(this.f28520a, 2131101780), 1.0f, true);
        qBadgeContainer.b(BluedSkinUtils.a(this.f28520a, 2131101201));
        Collection collection = this.E;
        if (collection != null) {
            collection.add(qBadgeContainer);
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.customview.-$$Lambda$TabPageIndicatorWithDot$QncBFgjyFwpj6Hp9Qh5YvAooRxM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TabPageIndicatorWithDot.this.a(i, view);
            }
        });
        this.d.addView(qBadgeContainer);
    }

    public void a(Canvas canvas, int i, int i2) {
        int height = getHeight() - getPaddingBottom();
        if (this.u <= 0.0f) {
            canvas.drawRect(i, height - this.s, i2, height, this.j);
            return;
        }
        RectF rectF = new RectF();
        rectF.left = i;
        rectF.top = height - this.s;
        rectF.right = i2;
        rectF.bottom = height;
        float f = this.u;
        canvas.drawRoundRect(rectF, f, f, this.j);
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        this.l = BluedSkinUtils.a(this.f28520a, this.k);
        this.y = BluedSkinUtils.a(this.f28520a, this.z);
        this.A = BluedSkinUtils.a(this.f28520a, this.B);
        d();
        a(this.g);
    }

    public void b() {
        this.d.removeAllViews();
        this.f = this.e.getAdapter().getCount();
        List<TextView> list = this.C;
        if (list != null) {
            list.clear();
        } else {
            this.C = new ArrayList();
        }
        List<View> list2 = this.D;
        if (list2 != null) {
            list2.clear();
        } else {
            this.D = new ArrayList();
        }
        List<QBadgeContainer> list3 = this.E;
        if (list3 != null) {
            list3.clear();
        } else {
            this.E = new ArrayList();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f) {
                c();
                this.M = false;
                getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.soft.blued.customview.TabPageIndicatorWithDot.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        TabPageIndicatorWithDot.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        TabPageIndicatorWithDot tabPageIndicatorWithDot = TabPageIndicatorWithDot.this;
                        tabPageIndicatorWithDot.g = tabPageIndicatorWithDot.e.getCurrentItem();
                        TabPageIndicatorWithDot tabPageIndicatorWithDot2 = TabPageIndicatorWithDot.this;
                        tabPageIndicatorWithDot2.d(tabPageIndicatorWithDot2.g, 0);
                        TabPageIndicatorWithDot tabPageIndicatorWithDot3 = TabPageIndicatorWithDot.this;
                        tabPageIndicatorWithDot3.a(tabPageIndicatorWithDot3.g);
                    }
                });
                return;
            }
            a(i2, this.e.getAdapter().getPageTitle(i2).toString());
            i = i2 + 1;
        }
    }

    public void b(int i) {
        View view;
        List<View> list = this.D;
        if (list == null || i < 0 || i >= list.size() || (view = this.D.get(i)) == null) {
            return;
        }
        view.setVisibility(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.bottomMargin = this.w / 2;
        view.setLayoutParams(layoutParams);
    }

    public void b(int i, int i2) {
        this.ae = i;
        this.af = i2;
        d();
    }

    protected void c() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f) {
                return;
            }
            QBadgeContainer qBadgeContainer = (QBadgeContainer) this.d.getChildAt(i2);
            LinearLayout linearLayout = (LinearLayout) qBadgeContainer.findViewWithTag(this.e.getAdapter().getPageTitle(i2).toString() + i2);
            if (linearLayout == null) {
                return;
            }
            linearLayout.setBackgroundResource(this.aa);
            if (this.N) {
                linearLayout.setPadding(0, 0, 0, 0);
            } else {
                int i3 = this.v;
                linearLayout.setPadding(i3, 0, i3, 0);
            }
            TextView textView = (TextView) a((ViewGroup) linearLayout);
            textView.setTextSize(0, this.w);
            textView.setTypeface(this.U, this.V);
            textView.setTextColor(this.y);
            i = i2 + 1;
        }
    }

    public void c(int i) {
        View view;
        List<View> list = this.D;
        if (list == null || i >= list.size() || (view = this.D.get(i)) == null) {
            return;
        }
        view.setVisibility(4);
        ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin = this.w / 2;
    }

    public void c(int i, int i2) {
        this.r = i;
        this.q = i2;
        invalidate();
    }

    public TextView e(int i) {
        List<TextView> list = this.C;
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return this.C.get(i);
    }

    public int getDividerColor() {
        return this.p;
    }

    public int getDividerPadding() {
        return this.Q;
    }

    public int getIndicatorColor() {
        return this.l;
    }

    public int getIndicatorHeight() {
        return this.s;
    }

    public int getScrollOffset() {
        return this.O;
    }

    public boolean getShuldExpand() {
        return this.N;
    }

    public int getTabBackground() {
        return this.aa;
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
        return this.n;
    }

    public int getUnderlineHeight() {
        return this.P;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (isInEditMode() || this.f == 0) {
            return;
        }
        int height = getHeight() - getPaddingBottom();
        TabData a2 = a(this.d.getChildAt(this.g));
        int i2 = this.g;
        int i3 = this.i;
        if (this.h > 0.0f && (i = this.g) < this.f - 1) {
            TabData a3 = a(this.d.getChildAt(i + 1));
            if (this.h < 0.5d) {
                a2.b += this.h * this.S;
                a2.f28526c = (a2.f28526c + ((this.h * 2.0f) * (a3.f28526c - a2.f28526c))) - (this.h * this.S);
            } else {
                float f = a2.b;
                float f2 = this.h;
                float f3 = a3.b;
                float f4 = a2.b;
                int i4 = this.S;
                a2.b = f + ((f2 - 0.5f) * 2.0f * ((f3 - f4) - (i4 / 2))) + (i4 / 2);
                a2.f28526c = a3.f28526c - ((1.0f - this.h) * this.S);
            }
        }
        this.j.setShader(new LinearGradient(((a2.f28526c - a2.b) / 2.0f) + a2.b, 0.0f, a2.f28526c, this.s, new int[]{this.r, this.q}, (float[]) null, Shader.TileMode.CLAMP));
        if (this.f > 1 && this.K) {
            a(canvas, (int) a2.b, (int) a2.f28526c);
        }
        canvas.drawRect(0.0f, height - this.P, this.d.getWidth(), height, this.j);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.N || View.MeasureSpec.getMode(i) == 0) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int i3 = 0;
        for (int i4 = 0; i4 < this.f; i4++) {
            i3 += this.d.getChildAt(i4).getMeasuredWidth();
        }
        if (this.M || i3 <= 0 || measuredWidth <= 0) {
            return;
        }
        if (i3 <= measuredWidth) {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= this.f) {
                    break;
                }
                this.d.getChildAt(i6).setLayoutParams(this.H);
                i5 = i6 + 1;
            }
        }
        this.M = true;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.g = savedState.f28524a;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f28524a = this.g;
        return savedState;
    }

    public void setDividerColor(int i) {
        this.o = i;
        this.p = BluedSkinUtils.a(this.f28520a, i);
        invalidate();
    }

    public void setDividerPadding(int i) {
        this.Q = i;
        invalidate();
    }

    public void setDotDiameter(int i) {
        this.ad = i;
        invalidate();
    }

    public void setForeverShowTabIndicator(boolean z) {
        this.K = z;
        invalidate();
    }

    public void setIndicatorColor(int i) {
        this.k = i;
        this.l = BluedSkinUtils.a(this.f28520a, i);
        invalidate();
    }

    public void setIndicatorHeight(int i) {
        this.s = i;
        invalidate();
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.J = onPageChangeListener;
    }

    public void setOnTitleClickListener(OnTitleClickListener onTitleClickListener) {
        this.F = onTitleClickListener;
    }

    public void setScrollOffset(int i) {
        this.O = i;
        invalidate();
    }

    public void setShouldExpand(boolean z) {
        this.N = z;
        requestLayout();
    }

    public void setTabBackground(int i) {
        this.aa = i;
    }

    public void setTabPaddingLeftRight(int i) {
        this.v = i;
        c();
    }

    public void setTabTextColorUnfocused(int i) {
        this.B = i;
        this.A = BluedSkinUtils.a(this.f28520a, i);
        c();
    }

    public void setTextColor(int i) {
        this.z = i;
        this.y = BluedSkinUtils.a(this.f28520a, i);
        c();
    }

    public void setTextSize(int i) {
        this.w = i;
        c();
    }

    public void setUnderlineColor(int i) {
        this.m = i;
        this.n = BluedSkinUtils.a(this.f28520a, i);
        invalidate();
    }

    public void setUnderlineHeight(int i) {
        this.P = i;
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        this.e = viewPager;
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        viewPager.addOnPageChangeListener(this.I);
        b();
    }
}
