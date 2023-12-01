package com.blued.android.module.yy_china.view.ban;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.ban.BGAViewPager;
import com.blued.android.module.yy_china.view.ban.transformer.BGAPageTransformer;
import com.tencent.ugc.UGCTransitionRules;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/ban/BGABanner.class */
public class BGABanner extends RelativeLayout implements ViewPager.OnPageChangeListener, BGAViewPager.AutoPlayDelegate {
    private static final ImageView.ScaleType[] S = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    private Adapter A;
    private int B;
    private ViewPager.OnPageChangeListener C;
    private RelativeLayout D;
    private boolean E;
    private TextView F;
    private int G;
    private int H;
    private Drawable I;
    private boolean J;
    private boolean K;
    private int L;
    private float M;
    private boolean N;
    private View O;
    private View P;
    private GuideDelegate Q;
    private boolean R;
    private BGAOnNoDoubleClickListener T;
    private int U;
    private int V;

    /* renamed from: a  reason: collision with root package name */
    private BGAViewPager f18607a;
    private List<View> b;

    /* renamed from: c  reason: collision with root package name */
    private List<View> f18608c;
    private List<String> d;
    private LinearLayout e;
    private TextView f;
    private boolean g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private Drawable q;
    private AutoPlayTask r;
    private int s;
    private float t;
    private int u;
    private ImageView v;
    private ImageView.ScaleType w;
    private int x;
    private List<? extends Object> y;
    private Delegate z;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/ban/BGABanner$Adapter.class */
    public interface Adapter<V extends View, M> {
        void a(BGABanner bGABanner, V v, M m, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/ban/BGABanner$AutoPlayTask.class */
    public static class AutoPlayTask implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<BGABanner> f18610a;

        private AutoPlayTask(BGABanner bGABanner) {
            this.f18610a = new WeakReference<>(bGABanner);
        }

        @Override // java.lang.Runnable
        public void run() {
            BGABanner bGABanner = this.f18610a.get();
            if (bGABanner != null) {
                bGABanner.c();
                bGABanner.h();
            }
        }
    }

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/ban/BGABanner$Delegate.class */
    public interface Delegate<V extends View, M> {
        void b(BGABanner bGABanner, V v, M m, int i);
    }

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/ban/BGABanner$GuideDelegate.class */
    public interface GuideDelegate {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/ban/BGABanner$PageAdapter.class */
    public class PageAdapter extends PagerAdapter {
        private PageAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (BGABanner.this.f18608c == null) {
                return 0;
            }
            if (BGABanner.this.g) {
                return Integer.MAX_VALUE;
            }
            return BGABanner.this.f18608c.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            if (BGABannerUtil.a(BGABanner.this.f18608c, new Collection[0])) {
                return null;
            }
            int size = i % BGABanner.this.f18608c.size();
            View view = BGABanner.this.b == null ? (View) BGABanner.this.f18608c.get(size) : (View) BGABanner.this.b.get(i % BGABanner.this.b.size());
            if (BGABanner.this.z != null) {
                view.setOnClickListener(new BGAOnNoDoubleClickListener() { // from class: com.blued.android.module.yy_china.view.ban.BGABanner.PageAdapter.1
                    @Override // com.blued.android.module.yy_china.view.ban.BGAOnNoDoubleClickListener
                    public void a(View view2) {
                        int currentItem = BGABanner.this.f18607a.getCurrentItem() % BGABanner.this.f18608c.size();
                        if (BGABannerUtil.a(currentItem, BGABanner.this.y)) {
                            BGABanner.this.z.b(BGABanner.this, view2, BGABanner.this.y.get(currentItem), currentItem);
                        } else if (BGABannerUtil.a(BGABanner.this.y, new Collection[0])) {
                            BGABanner.this.z.b(BGABanner.this, view2, null, currentItem);
                        }
                    }
                });
            }
            if (BGABanner.this.A != null) {
                if (BGABannerUtil.a(size, BGABanner.this.y)) {
                    Adapter adapter = BGABanner.this.A;
                    BGABanner bGABanner = BGABanner.this;
                    adapter.a(bGABanner, view, bGABanner.y.get(size), size);
                } else if (BGABannerUtil.a(BGABanner.this.y, new Collection[0])) {
                    BGABanner.this.A.a(BGABanner.this, view, null, size);
                }
            }
            ViewParent parent = view.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(view);
            }
            viewGroup.addView(view);
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public BGABanner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BGABanner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = true;
        this.h = 5000;
        this.i = 800;
        this.j = 81;
        this.o = -1;
        this.p = R.drawable.yy_banner_selector_point_solid;
        this.w = ImageView.ScaleType.CENTER_CROP;
        this.x = -1;
        this.B = 2;
        this.E = false;
        this.G = -1;
        this.N = true;
        this.R = true;
        this.T = new BGAOnNoDoubleClickListener() { // from class: com.blued.android.module.yy_china.view.ban.BGABanner.1
            @Override // com.blued.android.module.yy_china.view.ban.BGAOnNoDoubleClickListener
            public void a(View view) {
                if (BGABanner.this.Q != null) {
                    BGABanner.this.Q.a();
                }
            }
        };
        this.U = 0;
        this.V = -1;
        a(context);
        a(context, attributeSet);
        b(context);
    }

    private View a(int i) {
        View inflate = View.inflate(getContext(), i, null);
        if (inflate instanceof ImageView) {
            ((ImageView) inflate).setScaleType(this.w);
        }
        return inflate;
    }

    private void a(int i, float f) {
        if (this.P == null && this.O == null) {
            return;
        }
        if (getItemCount() < 2) {
            View view = this.P;
            if (view != null) {
                view.setVisibility(0);
                View view2 = this.O;
                if (view2 != null) {
                    view2.setVisibility(8);
                    return;
                }
                return;
            }
            View view3 = this.O;
            if (view3 != null) {
                view3.setVisibility(0);
                return;
            }
        }
        if (i == getItemCount() - 2) {
            View view4 = this.P;
            if (view4 != null) {
                ViewCompat.setAlpha(view4, f);
            }
            View view5 = this.O;
            if (view5 != null) {
                ViewCompat.setAlpha(view5, 1.0f - f);
            }
            if (f > 0.5f) {
                View view6 = this.P;
                if (view6 != null) {
                    view6.setVisibility(0);
                }
                View view7 = this.O;
                if (view7 != null) {
                    view7.setVisibility(8);
                    return;
                }
                return;
            }
            View view8 = this.P;
            if (view8 != null) {
                view8.setVisibility(8);
            }
            View view9 = this.O;
            if (view9 != null) {
                view9.setVisibility(0);
            }
        } else if (i != getItemCount() - 1) {
            View view10 = this.O;
            if (view10 != null) {
                view10.setVisibility(0);
                ViewCompat.setAlpha(this.O, 1.0f);
            }
            View view11 = this.P;
            if (view11 != null) {
                view11.setVisibility(8);
            }
        } else {
            View view12 = this.P;
            if (view12 != null) {
                ViewCompat.setAlpha(view12, 1.0f - f);
            }
            View view13 = this.O;
            if (view13 != null) {
                ViewCompat.setAlpha(view13, f);
            }
            if (f < 0.5f) {
                View view14 = this.P;
                if (view14 != null) {
                    view14.setVisibility(0);
                }
                View view15 = this.O;
                if (view15 != null) {
                    view15.setVisibility(8);
                    return;
                }
                return;
            }
            View view16 = this.P;
            if (view16 != null) {
                view16.setVisibility(8);
            }
            View view17 = this.O;
            if (view17 != null) {
                view17.setVisibility(0);
            }
        }
    }

    private void a(int i, TypedArray typedArray) {
        int i2;
        if (i == R.styleable.BGABanner_banner_pointDrawable) {
            this.p = typedArray.getResourceId(i, R.drawable.yy_banner_selector_point_solid);
        } else if (i == R.styleable.BGABanner_banner_pointContainerBackground) {
            this.q = typedArray.getDrawable(i);
        } else if (i == R.styleable.BGABanner_banner_pointLeftRightMargin) {
            this.k = typedArray.getDimensionPixelSize(i, this.k);
        } else if (i == R.styleable.BGABanner_banner_pointContainerLeftRightPadding) {
            this.m = typedArray.getDimensionPixelSize(i, this.m);
        } else if (i == R.styleable.BGABanner_banner_pointTopBottomMargin) {
            this.l = typedArray.getDimensionPixelSize(i, this.l);
        } else if (i == R.styleable.BGABanner_banner_indicatorGravity) {
            this.j = typedArray.getInt(i, this.j);
        } else if (i == R.styleable.BGABanner_banner_pointAutoPlayAble) {
            this.g = typedArray.getBoolean(i, this.g);
        } else if (i == R.styleable.BGABanner_banner_pointAutoPlayInterval) {
            this.h = typedArray.getInteger(i, this.h);
        } else if (i == R.styleable.BGABanner_banner_pageChangeDuration) {
            this.i = typedArray.getInteger(i, this.i);
        } else if (i == R.styleable.BGABanner_banner_transitionEffect) {
            this.u = typedArray.getInt(i, 0);
        } else if (i == R.styleable.BGABanner_banner_tipTextColor) {
            this.o = typedArray.getColor(i, this.o);
        } else if (i == R.styleable.BGABanner_banner_tipTextSize) {
            this.n = typedArray.getDimensionPixelSize(i, this.n);
        } else if (i == R.styleable.BGABanner_banner_placeholderDrawable) {
            this.x = typedArray.getResourceId(i, this.x);
        } else if (i == R.styleable.BGABanner_banner_isNumberIndicator) {
            this.E = typedArray.getBoolean(i, this.E);
        } else if (i == R.styleable.BGABanner_banner_numberIndicatorTextColor) {
            this.G = typedArray.getColor(i, this.G);
        } else if (i == R.styleable.BGABanner_banner_numberIndicatorTextSize) {
            this.H = typedArray.getDimensionPixelSize(i, this.H);
        } else if (i == R.styleable.BGABanner_banner_numberIndicatorBackground) {
            this.I = typedArray.getDrawable(i);
        } else if (i == R.styleable.BGABanner_banner_isNeedShowIndicatorOnOnlyOnePage) {
            this.J = typedArray.getBoolean(i, this.J);
        } else if (i == R.styleable.BGABanner_banner_contentBottomMargin) {
            this.L = typedArray.getDimensionPixelSize(i, this.L);
        } else if (i == R.styleable.BGABanner_banner_aspectRatio) {
            this.M = typedArray.getFloat(i, this.M);
        } else if (i != R.styleable.BGABanner_android_scaleType || (i2 = typedArray.getInt(i, -1)) < 0) {
        } else {
            ImageView.ScaleType[] scaleTypeArr = S;
            if (i2 < scaleTypeArr.length) {
                this.w = scaleTypeArr[i2];
            }
        }
    }

    private void a(Context context) {
        this.r = new AutoPlayTask();
        this.k = BGABannerUtil.a(context, 3.0f);
        this.l = BGABannerUtil.a(context, 3.0f);
        this.m = BGABannerUtil.a(context, 10.0f);
        this.n = BGABannerUtil.b(context, 10.0f);
        this.q = new ColorDrawable(Color.parseColor("#44aaaaaa"));
        this.u = 0;
        this.H = BGABannerUtil.b(context, 10.0f);
        this.L = 0;
        this.M = 0.0f;
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BGABanner);
        int indexCount = obtainStyledAttributes.getIndexCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= indexCount) {
                obtainStyledAttributes.recycle();
                return;
            } else {
                a(obtainStyledAttributes.getIndex(i2), obtainStyledAttributes);
                i = i2 + 1;
            }
        }
    }

    private void b(int i) {
        boolean z;
        boolean z2;
        if (this.f != null) {
            List<String> list = this.d;
            if (list == null || list.size() < 1 || i >= this.d.size()) {
                this.f.setVisibility(8);
            } else {
                this.f.setVisibility(0);
                this.f.setText(this.d.get(i));
            }
        }
        if (this.V != -1) {
            if (i < this.U) {
                this.U = i;
            }
            int i2 = this.U;
            int i3 = this.V;
            if (i >= i2 + i3) {
                this.U = (i - i3) + 1;
            }
        }
        if (this.e != null) {
            List<View> list2 = this.f18608c;
            if (list2 != null && list2.size() > 0 && i < this.f18608c.size() && ((z2 = this.J) || (!z2 && this.f18608c.size() > 1))) {
                this.e.setVisibility(0);
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= this.e.getChildCount()) {
                        break;
                    }
                    int i6 = this.V;
                    if (i6 != -1) {
                        int i7 = this.U;
                        if (i7 > i5 || i5 >= i7 + i6) {
                            this.e.getChildAt(i5).setVisibility(8);
                        } else {
                            this.e.getChildAt(i5).setVisibility(0);
                        }
                    }
                    this.e.getChildAt(i5).setSelected(i5 == i);
                    this.e.getChildAt(i5).requestLayout();
                    i4 = i5 + 1;
                }
            } else {
                this.e.setVisibility(8);
            }
        }
        if (this.K) {
            this.e.setVisibility(8);
        }
        if (this.F != null) {
            List<View> list3 = this.f18608c;
            if (list3 == null || list3.size() <= 0 || i >= this.f18608c.size() || (!(z = this.J) && (z || this.f18608c.size() <= 1))) {
                this.F.setVisibility(8);
                return;
            }
            this.F.setVisibility(0);
            TextView textView = this.F;
            textView.setText((i + 1) + BridgeUtil.SPLIT_MARK + this.f18608c.size());
        }
    }

    private void b(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.D = relativeLayout;
        int i = this.m;
        int i2 = this.l;
        relativeLayout.setPadding(i, i2, i, i2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if ((this.j & 112) == 48) {
            layoutParams.addRule(10);
        } else {
            layoutParams.addRule(12);
        }
        addView(this.D, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        if (this.E) {
            TextView textView = new TextView(context);
            this.F = textView;
            textView.setId(R.id.banner_indicatorId);
            this.F.setGravity(16);
            this.F.setSingleLine(true);
            this.F.setEllipsize(TextUtils.TruncateAt.END);
            this.F.setTextColor(this.G);
            this.F.setTextSize(0, this.H);
            this.F.setVisibility(4);
            if (this.I != null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    this.F.setBackground(this.I);
                } else {
                    this.F.setBackgroundDrawable(this.I);
                }
            }
            this.D.addView(this.F, layoutParams2);
        } else {
            LinearLayout linearLayout = new LinearLayout(context);
            this.e = linearLayout;
            linearLayout.setId(R.id.banner_indicatorId);
            this.e.setOrientation(0);
            this.e.setGravity(16);
            this.D.addView(this.e, layoutParams2);
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(15);
        TextView textView2 = new TextView(context);
        this.f = textView2;
        textView2.setGravity(16);
        this.f.setSingleLine(true);
        this.f.setEllipsize(TextUtils.TruncateAt.END);
        this.f.setTextColor(this.o);
        this.f.setTextSize(0, this.n);
        this.D.addView(this.f, layoutParams3);
        int i3 = this.j & 7;
        if (i3 == 3) {
            layoutParams2.addRule(9);
            layoutParams3.addRule(1, R.id.banner_indicatorId);
            this.f.setGravity(21);
        } else if (i3 == 5) {
            layoutParams2.addRule(11);
            layoutParams3.addRule(0, R.id.banner_indicatorId);
        } else {
            layoutParams2.addRule(14);
            layoutParams3.addRule(0, R.id.banner_indicatorId);
        }
        a();
    }

    private void e() {
        LinearLayout linearLayout = this.e;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            boolean z = this.J;
            if (z || (!z && this.f18608c.size() > 1)) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                int i = this.k;
                layoutParams.setMargins(i, 0, i, 0);
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= this.f18608c.size()) {
                        break;
                    }
                    ImageView imageView = new ImageView(getContext());
                    imageView.setLayoutParams(layoutParams);
                    imageView.setImageResource(this.p);
                    this.e.addView(imageView);
                    i2 = i3 + 1;
                }
            }
        }
        if (this.F != null) {
            boolean z2 = this.J;
            if (z2 || (!z2 && this.f18608c.size() > 1)) {
                this.F.setVisibility(0);
            } else {
                this.F.setVisibility(4);
            }
        }
    }

    private void f() {
        BGAViewPager bGAViewPager = this.f18607a;
        if (bGAViewPager != null && equals(bGAViewPager.getParent())) {
            removeView(this.f18607a);
            this.f18607a = null;
        }
        BGAViewPager bGAViewPager2 = new BGAViewPager(getContext());
        this.f18607a = bGAViewPager2;
        bGAViewPager2.setOffscreenPageLimit(1);
        this.f18607a.setAdapter(new PageAdapter());
        this.f18607a.addOnPageChangeListener(this);
        this.f18607a.setOverScrollMode(this.B);
        this.f18607a.setAllowUserScrollable(this.N);
        this.f18607a.setPageTransformer(true, BGAPageTransformer.a(this.u));
        setPageChangeDuration(this.i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, 0, 0, this.L);
        addView(this.f18607a, 0, layoutParams);
        if (!this.g || BGABannerUtil.a(this.f18608c, new Collection[0])) {
            b(0);
            return;
        }
        this.f18607a.setAutoPlayDelegate(this);
        this.f18607a.setCurrentItem(1073741823 - (1073741823 % this.f18608c.size()));
        c();
    }

    private void g() {
        d();
        if (!this.R && this.g && this.f18607a != null && getItemCount() > 0 && this.t != 0.0f) {
            BGAViewPager bGAViewPager = this.f18607a;
            bGAViewPager.setCurrentItem(bGAViewPager.getCurrentItem() - 1);
            BGAViewPager bGAViewPager2 = this.f18607a;
            bGAViewPager2.setCurrentItem(bGAViewPager2.getCurrentItem() + 1);
        }
        this.R = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        BGAViewPager bGAViewPager = this.f18607a;
        if (bGAViewPager != null) {
            bGAViewPager.setCurrentItem(bGAViewPager.getCurrentItem() + 1);
        }
    }

    public void a() {
        if (this.v != null || this.x == -1) {
            return;
        }
        this.v = BGABannerUtil.a(getContext(), this.x, new BGALocalImageSize(UGCTransitionRules.DEFAULT_IMAGE_WIDTH, 360, 640.0f, 320.0f), this.w);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, 0, 0, this.L);
        addView(this.v, layoutParams);
    }

    @Override // com.blued.android.module.yy_china.view.ban.BGAViewPager.AutoPlayDelegate
    public void a(float f) {
        BGAViewPager bGAViewPager = this.f18607a;
        if (bGAViewPager != null) {
            if (this.s < bGAViewPager.getCurrentItem()) {
                if (f > 400.0f || (this.t < 0.7f && f > -400.0f)) {
                    this.f18607a.a(this.s, true);
                } else {
                    this.f18607a.a(this.s + 1, true);
                }
            } else if (this.s != this.f18607a.getCurrentItem()) {
                this.f18607a.a(this.s, true);
            } else if (f < -400.0f || (this.t > 0.3f && f < 400.0f)) {
                this.f18607a.a(this.s + 1, true);
            } else {
                this.f18607a.a(this.s, true);
            }
        }
    }

    public void a(int i, List<? extends Object> list, List<String> list2) {
        List<View> list3 = this.f18608c;
        if (list3 != null) {
            list3.clear();
        }
        this.f18608c = new ArrayList();
        ArrayList arrayList = list;
        if (list == null) {
            arrayList = new ArrayList();
            list2 = new ArrayList();
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= arrayList.size()) {
                break;
            }
            this.f18608c.add(a(i));
            i2 = i3 + 1;
        }
        if (this.g && this.f18608c.size() < 3) {
            List<View> list4 = this.b;
            if (list4 != null) {
                list4.clear();
            }
            ArrayList arrayList2 = new ArrayList(this.f18608c);
            this.b = arrayList2;
            arrayList2.add(a(i));
            if (this.b.size() == 2) {
                this.b.add(a(i));
            }
        }
        a(this.f18608c, arrayList, list2);
    }

    public void a(List<View> list, List<? extends Object> list2, List<String> list3) {
        ArrayList arrayList = list;
        if (BGABannerUtil.a(list, new Collection[0])) {
            this.g = false;
            arrayList = new ArrayList();
            list2 = new ArrayList();
            list3 = new ArrayList();
        }
        if (this.g && arrayList.size() < 3 && this.b == null) {
            this.g = false;
        }
        this.y = list2;
        this.f18608c = arrayList;
        this.d = list3;
        e();
        f();
        b();
        a(0, 0.0f);
    }

    public void b() {
        ImageView imageView = this.v;
        if (imageView == null || !equals(imageView.getParent())) {
            return;
        }
        removeView(this.v);
        this.v = null;
    }

    public void c() {
        d();
        if (this.g) {
            postDelayed(this.r, this.h);
        }
    }

    public void d() {
        AutoPlayTask autoPlayTask = this.r;
        if (autoPlayTask != null) {
            removeCallbacks(autoPlayTask);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.g) {
            int action = motionEvent.getAction();
            if (action == 0) {
                d();
            } else if (action == 1 || action == 3) {
                c();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getCurrentItem() {
        if (this.f18607a == null || BGABannerUtil.a(this.f18608c, new Collection[0])) {
            return -1;
        }
        return this.f18607a.getCurrentItem() % this.f18608c.size();
    }

    public int getItemCount() {
        List<View> list = this.f18608c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<String> getTips() {
        return this.d;
    }

    public BGAViewPager getViewPager() {
        return this.f18607a;
    }

    public List<? extends View> getViews() {
        return this.f18608c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.M > 0.0f) {
            i2 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i) / this.M), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.C;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (BGABannerUtil.a(this.f18608c, new Collection[0])) {
            return;
        }
        a(i % this.f18608c.size(), f);
        this.s = i;
        this.t = f;
        if (this.f != null) {
            if (BGABannerUtil.b(this.d, new Collection[0])) {
                this.f.setVisibility(0);
                int size = i % this.d.size();
                int size2 = (i + 1) % this.d.size();
                if (size2 < this.d.size() && size < this.d.size()) {
                    if (f > 0.5d) {
                        this.f.setText(this.d.get(size2));
                        ViewCompat.setAlpha(this.f, f);
                    } else {
                        ViewCompat.setAlpha(this.f, 1.0f - f);
                        this.f.setText(this.d.get(size));
                    }
                }
            } else {
                this.f.setVisibility(8);
            }
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.C;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i % this.f18608c.size(), f, i2);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (BGABannerUtil.a(this.f18608c, new Collection[0])) {
            return;
        }
        int size = i % this.f18608c.size();
        b(size);
        ViewPager.OnPageChangeListener onPageChangeListener = this.C;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(size);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            c();
        } else if (i == 4 || i == 8) {
            g();
        }
    }

    public void setAdapter(Adapter adapter) {
        this.A = adapter;
    }

    public void setAllowUserScrollable(boolean z) {
        this.N = z;
        BGAViewPager bGAViewPager = this.f18607a;
        if (bGAViewPager != null) {
            bGAViewPager.setAllowUserScrollable(z);
        }
    }

    public void setAspectRatio(float f) {
        this.M = f;
        requestLayout();
    }

    public void setAutoPlayAble(boolean z) {
        this.g = z;
        d();
        BGAViewPager bGAViewPager = this.f18607a;
        if (bGAViewPager == null || bGAViewPager.getAdapter() == null) {
            return;
        }
        this.f18607a.getAdapter().notifyDataSetChanged();
    }

    public void setAutoPlayInterval(int i) {
        this.h = i;
    }

    public void setCurrentItem(int i) {
        if (this.f18607a == null || this.f18608c == null || i > getItemCount() - 1) {
            return;
        }
        if (!this.g) {
            this.f18607a.setCurrentItem(i, false);
            return;
        }
        int currentItem = this.f18607a.getCurrentItem();
        int size = i - (currentItem % this.f18608c.size());
        if (size < 0) {
            int i2 = -1;
            while (true) {
                int i3 = i2;
                if (i3 < size) {
                    break;
                }
                this.f18607a.setCurrentItem(currentItem + i3, false);
                i2 = i3 - 1;
            }
        } else if (size > 0) {
            int i4 = 1;
            while (true) {
                int i5 = i4;
                if (i5 > size) {
                    break;
                }
                this.f18607a.setCurrentItem(currentItem + i5, false);
                i4 = i5 + 1;
            }
        }
        c();
    }

    public void setData(List<View> list) {
        a(list, (List<? extends Object>) null, (List<String>) null);
    }

    public void setDelegate(Delegate delegate) {
        this.z = delegate;
    }

    public void setIndicatorTopBottomMarginDp(int i) {
        setIndicatorTopBottomMarginPx(BGABannerUtil.a(getContext(), i));
    }

    public void setIndicatorTopBottomMarginPx(int i) {
        this.l = i;
        RelativeLayout relativeLayout = this.D;
        int i2 = this.m;
        relativeLayout.setPadding(i2, i, i2, i);
    }

    public void setIndicatorTopBottomMarginRes(int i) {
        setIndicatorTopBottomMarginPx(getResources().getDimensionPixelOffset(i));
    }

    public void setIndicatorVisibility(boolean z) {
        this.D.setVisibility(z ? 0 : 8);
    }

    public void setIsNeedShowIndicatorOnOnlyOnePage(boolean z) {
        this.J = z;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.C = onPageChangeListener;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i) {
        this.B = i;
        BGAViewPager bGAViewPager = this.f18607a;
        if (bGAViewPager != null) {
            bGAViewPager.setOverScrollMode(i);
        }
    }

    public void setPageChangeDuration(int i) {
        if (i < 0 || i > 2000) {
            return;
        }
        this.i = i;
        BGAViewPager bGAViewPager = this.f18607a;
        if (bGAViewPager != null) {
            bGAViewPager.setPageChangeDuration(i);
        }
    }

    public void setPageTransformer(ViewPager.PageTransformer pageTransformer) {
        BGAViewPager bGAViewPager;
        if (pageTransformer == null || (bGAViewPager = this.f18607a) == null) {
            return;
        }
        bGAViewPager.setPageTransformer(true, pageTransformer);
    }

    public void setTransitionEffect(int i) {
        this.u = i;
        if (this.f18607a != null) {
            f();
            List<View> list = this.b;
            if (list == null) {
                BGABannerUtil.a(this.f18608c);
            } else {
                BGABannerUtil.a(list);
            }
        }
    }

    public void setmContentBottomMargin(int i) {
        this.L = i;
    }

    public void setmIsNeedShowIndicator(boolean z) {
        this.K = z;
    }

    public void setmWantVisiNum(int i) {
        this.V = i;
    }
}
