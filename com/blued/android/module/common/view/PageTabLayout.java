package com.blued.android.module.common.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.util.Pools;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.android.internal.R;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import skin.support.widget.SkinCompatBackgroundHelper;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/PageTabLayout.class */
public class PageTabLayout extends HorizontalScrollView implements BluedSkinSupportable {
    private static final Pools.Pool<Tab> F = new Pools.SynchronizedPool(16);
    private float A;
    private int B;
    private Tab C;
    private ValueAnimator D;
    private final ArrayList<Tab> E;
    private final Pools.Pool<TabView> G;
    private final ArrayList<OnTabSelectedListener> H;
    private int I;
    private int J;
    private OnPlaceHolderSelectedListener K;
    final int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;
    ColorStateList i;
    float j;
    private final int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private SkinCompatBackgroundHelper q;
    private ViewPager r;
    private TabLayoutOnPageChangeListener s;
    private AdapterChangeListener t;
    private OnTabSelectedListener u;
    private boolean v;
    private final SlidingTabStrip w;
    private PagerAdapter x;
    private DataSetObserver y;
    private float z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/PageTabLayout$AdapterChangeListener.class */
    public class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {
        private boolean b;

        AdapterChangeListener() {
        }

        void a(boolean z) {
            this.b = z;
        }

        public void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            if (PageTabLayout.this.r == viewPager) {
                PageTabLayout.this.a(pagerAdapter2, this.b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/PageTabLayout$AnimationUtils.class */
    public static class AnimationUtils {
        public static final Interpolator a = new LinearInterpolator();
        public static final Interpolator b = new FastOutSlowInInterpolator();
        public static final Interpolator c = new FastOutLinearInInterpolator();
        public static final Interpolator d = new LinearOutSlowInInterpolator();
        public static final Interpolator e = new DecelerateInterpolator();

        private AnimationUtils() {
        }

        public static int a(int i, int i2, float f) {
            return i + Math.round(f * (i2 - i));
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/PageTabLayout$Mode.class */
    public @interface Mode {
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/PageTabLayout$OnPlaceHolderSelectedListener.class */
    public interface OnPlaceHolderSelectedListener {
        void onSelected();
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/PageTabLayout$OnTabSelectedListener.class */
    public interface OnTabSelectedListener {
        void a(Tab tab);

        void b(Tab tab);

        void c(Tab tab);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/PageTabLayout$PagerAdapterObserver.class */
    public class PagerAdapterObserver extends DataSetObserver {
        PagerAdapterObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PageTabLayout.this.e();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            PageTabLayout.this.e();
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/PageTabLayout$SlidingTabStrip.class */
    public class SlidingTabStrip extends LinearLayout {
        int a;
        float b;
        private int d;
        private final Paint e;
        private int f;
        private int g;
        private int h;
        private int i;
        private ValueAnimator j;

        SlidingTabStrip(Context context) {
            super(context);
            this.a = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            setWillNotDraw(false);
            this.e = new Paint();
        }

        private void b() {
            int i;
            int i2;
            View childAt = getChildAt(this.a);
            if (childAt == null || childAt.getWidth() <= 0) {
                i = -1;
                i2 = -1;
            } else {
                int left = childAt.getLeft();
                int right = childAt.getRight();
                i2 = right;
                i = left;
                if (this.b > 0.0f) {
                    i2 = right;
                    i = left;
                    if (this.a < getChildCount() - 1) {
                        View childAt2 = getChildAt(this.a + 1);
                        float f = this.b;
                        float left2 = childAt2.getLeft();
                        float f2 = this.b;
                        i = (int) ((f * left2) + ((1.0f - f2) * left));
                        i2 = (int) ((f2 * childAt2.getRight()) + ((1.0f - this.b) * right));
                    }
                }
            }
            a(i, i2);
        }

        void a(int i, float f) {
            ValueAnimator valueAnimator = this.j;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.j.cancel();
            }
            this.a = i;
            this.b = f;
            b();
        }

        void a(int i, int i2) {
            if (i == this.h && i2 == this.i) {
                return;
            }
            this.h = i;
            this.i = i2;
            ViewCompat.postInvalidateOnAnimation(this);
        }

        boolean a() {
            int childCount = getChildCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childCount) {
                    return false;
                }
                if (getChildAt(i2).getWidth() <= 0) {
                    return true;
                }
                i = i2 + 1;
            }
        }

        void b(final int i, int i2) {
            int i3;
            int i4;
            ValueAnimator valueAnimator = this.j;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.j.cancel();
            }
            ViewCompat.getLayoutDirection(this);
            View childAt = getChildAt(i);
            if (childAt == null) {
                b();
                return;
            }
            final int left = childAt.getLeft();
            final int right = childAt.getRight();
            if (Math.abs(i - this.a) <= 1) {
                i3 = this.h;
                i4 = this.i;
            } else {
                i3 = this.h;
                i4 = this.i;
            }
            if (i3 == left && i4 == right) {
                return;
            }
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.j = valueAnimator2;
            valueAnimator2.setInterpolator(AnimationUtils.b);
            valueAnimator2.setDuration(i2);
            valueAnimator2.setFloatValues(0.0f, 1.0f);
            final int i5 = i3;
            final int i6 = i4;
            valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.common.view.PageTabLayout.SlidingTabStrip.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    float animatedFraction = valueAnimator3.getAnimatedFraction();
                    SlidingTabStrip.this.a(AnimationUtils.a(i5, left, animatedFraction), AnimationUtils.a(i6, right, animatedFraction));
                }
            });
            valueAnimator2.addListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.common.view.PageTabLayout.SlidingTabStrip.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SlidingTabStrip.this.a = i;
                    SlidingTabStrip.this.b = 0.0f;
                }
            });
            valueAnimator2.start();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.view.ViewGroup, android.view.View
        public void dispatchDraw(Canvas canvas) {
            int i = PageTabLayout.this.p / 2;
            RectF rectF = new RectF();
            rectF.left = this.h + i;
            rectF.top = (getHeight() - this.d) / 2;
            rectF.right = this.i - i;
            rectF.bottom = rectF.top + this.d;
            this.e.setAntiAlias(true);
            int i2 = this.h;
            if (i2 >= 0 && this.i > i2) {
                int i3 = this.f;
                if (i3 == 0) {
                    int i4 = this.d;
                    canvas.drawRoundRect(rectF, i4 / 2, i4 / 2, this.e);
                } else {
                    canvas.drawRoundRect(rectF, i3, i3, this.e);
                }
            }
            super.dispatchDraw(canvas);
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            super.draw(canvas);
        }

        float getIndicatorPosition() {
            return this.a + this.b;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            ValueAnimator valueAnimator = this.j;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                b();
                return;
            }
            this.j.cancel();
            b(this.a, Math.round((1.0f - this.j.getAnimatedFraction()) * ((float) this.j.getDuration())));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            int i3;
            boolean z;
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) == 1073741824 && PageTabLayout.this.h == 1 && PageTabLayout.this.g == 1) {
                int childCount = getChildCount();
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    i3 = i5;
                    if (i4 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i4);
                    int i6 = i3;
                    if (childAt.getVisibility() == 0) {
                        i6 = Math.max(i3, childAt.getMeasuredWidth());
                    }
                    i4++;
                    i5 = i6;
                }
                if (i3 <= 0) {
                    return;
                }
                if (i3 * childCount <= getMeasuredWidth() - (PageTabLayout.this.c(16) * 2)) {
                    z = false;
                    int i7 = 0;
                    while (true) {
                        int i8 = i7;
                        if (i8 >= childCount) {
                            break;
                        }
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i8).getLayoutParams();
                        if (layoutParams.width != i3 || layoutParams.weight != 0.0f) {
                            layoutParams.width = i3;
                            layoutParams.weight = 0.0f;
                            z = true;
                        }
                        i7 = i8 + 1;
                    }
                } else {
                    PageTabLayout.this.g = 0;
                    PageTabLayout.this.a(false);
                    z = true;
                }
                if (z) {
                    super.onMeasure(i, i2);
                }
            }
        }

        @Override // android.view.View
        public void onRtlPropertiesChanged(int i) {
            super.onRtlPropertiesChanged(i);
            if (Build.VERSION.SDK_INT >= 23 || this.g == i) {
                return;
            }
            requestLayout();
            this.g = i;
        }

        void setSelectedIndicatorColor(int i) {
            if (this.e.getColor() != i) {
                this.e.setColor(i);
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void setSelectedIndicatorHeight(int i) {
            if (this.d != i) {
                this.d = i;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void setSelectedIndicatorRadius(int i) {
            if (this.f != i) {
                this.f = i;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/PageTabLayout$Tab.class */
    public class Tab {
        PageTabLayout a;
        TabView b;
        private Object d;
        private Drawable e;
        private CharSequence f;
        private CharSequence g;
        private int h = -1;
        private View i;

        Tab() {
        }

        public View a() {
            return this.i;
        }

        public Tab a(View view) {
            this.i = view;
            h();
            return this;
        }

        public Tab a(CharSequence charSequence) {
            this.f = charSequence;
            h();
            return this;
        }

        void a(int i) {
            this.h = i;
        }

        public Drawable b() {
            return this.e;
        }

        public Tab b(int i) {
            PageTabLayout pageTabLayout = this.a;
            if (pageTabLayout != null) {
                return a(pageTabLayout.getResources().getText(i));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public int c() {
            return this.h;
        }

        public CharSequence d() {
            return this.f;
        }

        public void e() {
            PageTabLayout pageTabLayout = this.a;
            if (pageTabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            pageTabLayout.a(this);
        }

        public boolean f() {
            PageTabLayout pageTabLayout = this.a;
            if (pageTabLayout != null) {
                return pageTabLayout.getSelectedTabPosition() == this.h;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public CharSequence g() {
            return this.g;
        }

        void h() {
            TabView tabView = this.b;
            if (tabView != null) {
                tabView.update();
            }
        }

        void i() {
            this.a = null;
            this.b = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = -1;
            this.i = null;
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/PageTabLayout$TabLayoutOnPageChangeListener.class */
    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        private final WeakReference<PageTabLayout> a;
        private int b;
        private int c;

        public TabLayoutOnPageChangeListener(PageTabLayout pageTabLayout) {
            this.a = new WeakReference<>(pageTabLayout);
        }

        void a() {
            this.c = 0;
            this.b = 0;
        }

        public void onPageScrollStateChanged(int i) {
            this.b = this.c;
            this.c = i;
        }

        public void onPageScrolled(int i, float f, int i2) {
            PageTabLayout pageTabLayout = this.a.get();
            if (pageTabLayout != null) {
                if (this.c == 2) {
                    int i3 = this.b;
                }
                boolean z = true;
                if (this.c == 2) {
                    z = this.b != 0;
                }
                pageTabLayout.a(i, f, false, z);
            }
        }

        public void onPageSelected(int i) {
            PageTabLayout pageTabLayout = this.a.get();
            if (pageTabLayout != null) {
                pageTabLayout.setSelectedTabView(i);
                if (pageTabLayout.getSelectedTabPosition() == i || i >= pageTabLayout.getTabCount()) {
                    return;
                }
                int i2 = this.c;
                pageTabLayout.a(pageTabLayout.a(i), i2 == 0 || (i2 == 2 && this.b == 0));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/PageTabLayout$TabView.class */
    public class TabView extends LinearLayout {
        private Tab b;
        private TextView c;
        private ImageView d;
        private View e;
        private View f;
        private TextView g;
        private ImageView h;
        private int i;

        public TabView(Context context) {
            super(context);
            this.i = 1;
            if (PageTabLayout.this.a != 0) {
                ViewCompat.setBackground(this, AppCompatResources.getDrawable(context, PageTabLayout.this.a));
            }
            ViewCompat.setPaddingRelative(this, PageTabLayout.this.b, PageTabLayout.this.c, PageTabLayout.this.d, PageTabLayout.this.e);
            setGravity(17);
            setOrientation(0);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        private float a(Layout layout, int i, float f) {
            return layout.getLineWidth(i) * (f / layout.getPaint().getTextSize());
        }

        private void a(TextView textView, ImageView imageView) {
            Tab tab = this.b;
            Drawable b = tab != null ? tab.b() : null;
            Tab tab2 = this.b;
            CharSequence d = tab2 != null ? tab2.d() : null;
            Tab tab3 = this.b;
            CharSequence g = tab3 != null ? tab3.g() : null;
            if (imageView != null) {
                if (b != null) {
                    imageView.setImageDrawable(b);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
                imageView.setContentDescription(g);
            }
            boolean z = !TextUtils.isEmpty(d);
            if (textView != null) {
                if (z) {
                    textView.setText(d);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
                textView.setContentDescription(g);
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int i = 0;
                if (z) {
                    i = 0;
                    if (imageView.getVisibility() == 0) {
                        i = PageTabLayout.this.c(8);
                    }
                }
                if (i != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = i;
                    imageView.requestLayout();
                }
            }
            if (z) {
                g = null;
            }
            TooltipCompat.setTooltipText(this, g);
        }

        void a() {
            a(null);
            setSelected(false);
        }

        void a(Tab tab) {
            if (tab != this.b) {
                this.b = tab;
                update();
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ActionBar.Tab.class.getName());
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x00fe, code lost:
            if (a(r0, 0, r8) > ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) goto L27;
         */
        @Override // android.widget.LinearLayout, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onMeasure(int r6, int r7) {
            /*
                Method dump skipped, instructions count: 290
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.view.PageTabLayout.TabView.onMeasure(int, int):void");
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            boolean z = performClick;
            if (this.b != null) {
                if (!performClick) {
                    playSoundEffect(0);
                }
                this.b.e();
                z = true;
            }
            return z;
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z && Build.VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            TextView textView = this.c;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.d;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.f;
            if (view != null) {
                view.setSelected(z);
            }
        }

        final void update() {
            Tab tab = this.b;
            View a = tab != null ? tab.a() : null;
            if (a != null) {
                ViewParent parent = a.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(a);
                    }
                    addView(a);
                }
                this.f = a;
                TextView textView = this.c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.d.setImageDrawable(null);
                }
                TextView textView2 = (TextView) a.findViewById(R.id.text1);
                this.g = textView2;
                if (textView2 != null) {
                    this.i = TextViewCompat.getMaxLines(textView2);
                }
                this.h = (ImageView) a.findViewById(R.id.icon);
            } else {
                View view = this.f;
                if (view != null) {
                    removeView(view);
                    this.f = null;
                }
                this.g = null;
                this.h = null;
            }
            if (this.f == null) {
                if (this.d == null) {
                    ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(com.blued.android.module.common.R.layout.design_layout_tab_icon, (ViewGroup) this, false);
                    addView(imageView2, 0);
                    this.d = imageView2;
                }
                if (this.c == null) {
                    TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(com.blued.android.module.common.R.layout.design_layout_tab_text, (ViewGroup) this, false);
                    addView(textView3);
                    this.c = textView3;
                    textView3.setMaxLines(PageTabLayout.this.B);
                    this.c.setLines(PageTabLayout.this.B);
                    this.i = TextViewCompat.getMaxLines(this.c);
                }
                TextViewCompat.setTextAppearance(this.c, PageTabLayout.this.l);
                View view2 = this.e;
                if (view2 != null) {
                    addView(view2);
                }
                if (PageTabLayout.this.i != null) {
                    this.c.setTextColor(PageTabLayout.this.i);
                }
                a(this.c, this.d);
            } else if (this.g != null || this.h != null) {
                a(this.g, this.h);
            }
            boolean z = false;
            if (tab != null) {
                z = false;
                if (tab.f()) {
                    z = true;
                }
            }
            setSelected(z);
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/PageTabLayout$ViewPagerOnTabSelectedListener.class */
    public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {
        private final ViewPager a;

        ViewPagerOnTabSelectedListener(ViewPager viewPager) {
            this.a = viewPager;
        }

        @Override // com.blued.android.module.common.view.PageTabLayout.OnTabSelectedListener
        public void a(Tab tab) {
            this.a.setCurrentItem(tab.c());
        }

        @Override // com.blued.android.module.common.view.PageTabLayout.OnTabSelectedListener
        public void b(Tab tab) {
        }

        @Override // com.blued.android.module.common.view.PageTabLayout.OnTabSelectedListener
        public void c(Tab tab) {
        }
    }

    public PageTabLayout(Context context) {
        this(context, null);
    }

    public PageTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x01d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PageTabLayout(android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
            Method dump skipped, instructions count: 716
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.view.PageTabLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private int a(int i, float f) {
        int i2 = 0;
        if (this.h == 0) {
            View childAt = this.w.getChildAt(i);
            int i3 = i + 1;
            View childAt2 = i3 < this.w.getChildCount() ? this.w.getChildAt(i3) : null;
            int width = childAt != null ? childAt.getWidth() : 0;
            if (childAt2 != null) {
                i2 = childAt2.getWidth();
            }
            int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
            int i4 = (int) ((width + i2) * 0.5f * f);
            return ViewCompat.getLayoutDirection(this) == 0 ? left + i4 : left - i4;
        }
        return 0;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [int[], int[][]] */
    private static ColorStateList a(int i, int i2) {
        return new ColorStateList(new int[]{SELECTED_STATE_SET, EMPTY_STATE_SET}, new int[]{i2, i});
    }

    private void a(LinearLayout.LayoutParams layoutParams) {
        if (this.h == 1 && this.g == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    private void a(ViewPager viewPager, boolean z, boolean z2) {
        ViewPager viewPager2 = this.r;
        if (viewPager2 != null) {
            TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener = this.s;
            if (tabLayoutOnPageChangeListener != null) {
                viewPager2.removeOnPageChangeListener(tabLayoutOnPageChangeListener);
            }
            AdapterChangeListener adapterChangeListener = this.t;
            if (adapterChangeListener != null) {
                this.r.removeOnAdapterChangeListener(adapterChangeListener);
            }
        }
        OnTabSelectedListener onTabSelectedListener = this.u;
        if (onTabSelectedListener != null) {
            b(onTabSelectedListener);
            this.u = null;
        }
        if (viewPager != null) {
            this.r = viewPager;
            if (this.s == null) {
                this.s = new TabLayoutOnPageChangeListener(this);
            }
            this.s.a();
            viewPager.addOnPageChangeListener(this.s);
            ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener = new ViewPagerOnTabSelectedListener(viewPager);
            this.u = viewPagerOnTabSelectedListener;
            a(viewPagerOnTabSelectedListener);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                a(adapter, z);
            }
            if (this.t == null) {
                this.t = new AdapterChangeListener();
            }
            this.t.a(z);
            viewPager.addOnAdapterChangeListener(this.t);
            a(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.r = null;
            a((PagerAdapter) null, false);
        }
        this.v = z2;
    }

    private void a(OnTabSelectedListener onTabSelectedListener) {
        if (this.H.contains(onTabSelectedListener)) {
            return;
        }
        this.H.add(onTabSelectedListener);
    }

    private void a(Tab tab, int i) {
        tab.a(i);
        this.E.add(i, tab);
        int size = this.E.size();
        while (true) {
            i++;
            if (i >= size) {
                return;
            }
            this.E.get(i).a(i);
        }
    }

    private void b(OnTabSelectedListener onTabSelectedListener) {
        this.H.remove(onTabSelectedListener);
    }

    private void b(Tab tab) {
        int size = this.H.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            this.H.get(i).a(tab);
            size = i;
        }
    }

    private void c() {
        ViewCompat.setPaddingRelative(this.w, this.h == 0 ? Math.max(0, this.k - this.b) : 0, 0, 0, 0);
        int i = this.h;
        if (i == 0) {
            this.w.setGravity(8388611);
        } else if (i == 1) {
            this.w.setGravity(1);
        }
        a(true);
    }

    private void c(Tab tab) {
        int size = this.H.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            this.H.get(i).b(tab);
            size = i;
        }
    }

    private void d() {
        if (this.D == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.D = valueAnimator;
            valueAnimator.setInterpolator(AnimationUtils.b);
            this.D.setDuration(300L);
            this.D.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.common.view.PageTabLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    PageTabLayout.this.scrollTo(((Integer) valueAnimator2.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    private void d(int i) {
        if (i == -1) {
            return;
        }
        if (getWindowToken() == null || getWidth() <= 0 || getHeight() <= 0 || this.w.a()) {
            a(i, 0.0f, true);
            return;
        }
        int scrollX = getScrollX();
        int a = a(i, 0.0f);
        if (scrollX != a) {
            d();
            this.D.setIntValues(scrollX, a);
            this.D.start();
        }
        this.w.b(i, 300);
    }

    private void d(Tab tab) {
        int size = this.H.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            this.H.get(i).c(tab);
            size = i;
        }
    }

    private TabView e(Tab tab) {
        Pools.Pool<TabView> pool = this.G;
        TabView tabView = pool != null ? (TabView) pool.acquire() : null;
        TabView tabView2 = tabView;
        if (tabView == null) {
            tabView2 = new TabView(getContext());
        }
        tabView2.a(tab);
        tabView2.setFocusable(true);
        tabView2.setMinimumWidth(getTabMinWidth());
        return tabView2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        int currentItem;
        b();
        PagerAdapter pagerAdapter = this.x;
        if (pagerAdapter != null) {
            int count = pagerAdapter.getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= count) {
                    break;
                }
                b(a().a(this.x.getPageTitle(i2)), false);
                i = i2 + 1;
            }
            ViewPager viewPager = this.r;
            if (viewPager == null || count <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            a(a(currentItem));
        }
    }

    private void e(int i) {
        TabView tabView = (TabView) this.w.getChildAt(i);
        this.w.removeViewAt(i);
        if (tabView != null) {
            tabView.a();
            this.G.release(tabView);
        }
        requestLayout();
    }

    private LinearLayout.LayoutParams f() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        a(layoutParams);
        return layoutParams;
    }

    private void f(Tab tab) {
        this.w.addView(tab.b, tab.c(), f());
    }

    private int getDefaultHeight() {
        boolean z;
        int size = this.E.size();
        int i = 0;
        while (true) {
            int i2 = i;
            z = false;
            if (i2 < size) {
                Tab tab = this.E.get(i2);
                if (tab != null && tab.b() != null && !TextUtils.isEmpty(tab.d())) {
                    z = true;
                    break;
                }
                i = i2 + 1;
            } else {
                break;
            }
        }
        return z ? 72 : 48;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getSelectedTabPosition() {
        Tab tab = this.C;
        if (tab != null) {
            return tab.c();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTabCount() {
        return this.E.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTabMaxWidth() {
        return this.f;
    }

    private int getTabMinWidth() {
        int i = this.m;
        if (i != -1) {
            return i;
        }
        if (this.h == 0) {
            return this.n;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectedTabView(int i) {
        int childCount = this.w.getChildCount();
        if (i >= childCount) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= childCount) {
                return;
            }
            this.w.getChildAt(i3).setSelected(i3 == i);
            i2 = i3 + 1;
        }
    }

    public Tab a() {
        Tab tab = (Tab) F.acquire();
        Tab tab2 = tab;
        if (tab == null) {
            tab2 = new Tab();
        }
        tab2.a = this;
        tab2.b = e(tab2);
        return tab2;
    }

    public Tab a(int i) {
        if (i < 0 || i >= getTabCount()) {
            return null;
        }
        return this.E.get(i);
    }

    public void a(int i, float f, boolean z) {
        a(i, f, z, true);
    }

    void a(int i, float f, boolean z, boolean z2) {
        int round = f > this.j ? Math.round((i + f) - 0.4f) : Math.round(i + f + 0.4f);
        this.j = f;
        if (round < 0 || round >= this.w.getChildCount()) {
            return;
        }
        if (z2) {
            this.w.a(i, f);
        }
        ValueAnimator valueAnimator = this.D;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.D.cancel();
        }
        scrollTo(a(i, f), 0);
        if (z) {
            setSelectedTabView(round);
        }
    }

    public void a(int i, OnPlaceHolderSelectedListener onPlaceHolderSelectedListener) {
        this.J = i;
        this.K = onPlaceHolderSelectedListener;
    }

    void a(PagerAdapter pagerAdapter, boolean z) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.x;
        if (pagerAdapter2 != null && (dataSetObserver = this.y) != null) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.x = pagerAdapter;
        if (z && pagerAdapter != null) {
            if (this.y == null) {
                this.y = new PagerAdapterObserver();
            }
            pagerAdapter.registerDataSetObserver(this.y);
        }
        e();
    }

    public void a(Tab tab) {
        a(tab, true);
    }

    public void a(Tab tab, int i, boolean z) {
        if (tab.a != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        a(tab, i);
        f(tab);
        if (z) {
            tab.e();
        }
    }

    public void a(Tab tab, boolean z) {
        OnPlaceHolderSelectedListener onPlaceHolderSelectedListener;
        Tab tab2 = this.C;
        if (tab2 == tab) {
            if (tab2 != null) {
                d(tab);
                d(tab.c());
                return;
            }
            return;
        }
        int c = tab != null ? tab.c() : -1;
        if (this.J == c && (onPlaceHolderSelectedListener = this.K) != null) {
            onPlaceHolderSelectedListener.onSelected();
            this.J = -1;
            return;
        }
        if (z) {
            if ((tab2 == null || tab2.c() == -1) && c != -1) {
                a(c, 0.0f, true);
            } else {
                d(c);
            }
            if (c != -1) {
                setSelectedTabView(c);
            }
        }
        if (tab2 != null) {
            c(tab2);
        }
        this.C = tab;
        if (tab != null) {
            b(tab);
        }
    }

    void a(boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.w.getChildCount()) {
                return;
            }
            View childAt = this.w.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            a((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
            i = i2 + 1;
        }
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        this.w.setSelectedIndicatorColor(BluedSkinUtils.a(getContext(), this.I));
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.q;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a();
        }
    }

    public View b(int i) {
        Tab b = a().b(i);
        a(b, this.E.size(), false);
        return b.b;
    }

    public void b() {
        int childCount = this.w.getChildCount();
        while (true) {
            int i = childCount - 1;
            if (i < 0) {
                break;
            }
            e(i);
            childCount = i;
        }
        Iterator<Tab> it = this.E.iterator();
        while (it.hasNext()) {
            Tab next = it.next();
            it.remove();
            next.i();
            F.release(next);
        }
        this.C = null;
    }

    public void b(Tab tab, boolean z) {
        a(tab, this.E.size(), z);
    }

    int c(int i) {
        return Math.round(getResources().getDisplayMetrics().density * i);
    }

    public ArrayList<Tab> getTabs() {
        return this.E;
    }

    public int getTabsCount() {
        ArrayList<Tab> arrayList = this.E;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.r == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                a((ViewPager) parent, true, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.v) {
            setupWithViewPager(null);
            this.v = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a5, code lost:
        if (r0.getMeasuredWidth() != getMeasuredWidth()) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b4, code lost:
        if (r0.getMeasuredWidth() < getMeasuredWidth()) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ba, code lost:
        r5 = false;
     */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r5, int r6) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.view.PageTabLayout.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.q;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a(i);
        }
    }

    public void setScrollableTabMinWidth(int i) {
        this.n = i;
    }

    public void setupWithViewPager(ViewPager viewPager) {
        a(viewPager, true, false);
    }
}
