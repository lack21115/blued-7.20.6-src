package com.baidu.mobads.sdk.internal.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/widget/ScrollEventAdapter.class */
public final class ScrollEventAdapter extends RecyclerView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    private static final int f6615a = 0;
    private static final int b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f6616c = 2;
    private static final int d = 3;
    private static final int e = 4;
    private static final int f = -1;
    private ViewPager2.OnPageChangeCallback g;
    private final ViewPager2 h;
    private final RecyclerView i;
    private final LinearLayoutManager j;
    private int k;
    private int l;
    private ScrollEventValues m;
    private int n;
    private int o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/widget/ScrollEventAdapter$AdapterState.class */
    @interface AdapterState {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/widget/ScrollEventAdapter$ScrollEventValues.class */
    public static final class ScrollEventValues {

        /* renamed from: a  reason: collision with root package name */
        int f6617a;
        float b;

        /* renamed from: c  reason: collision with root package name */
        int f6618c;

        ScrollEventValues() {
        }

        void a() {
            this.f6617a = -1;
            this.b = 0.0f;
            this.f6618c = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ScrollEventAdapter(ViewPager2 viewPager2) {
        this.h = viewPager2;
        RecyclerView recyclerView = viewPager2.j;
        this.i = recyclerView;
        this.j = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.m = new ScrollEventValues();
        i();
    }

    private void a(int i) {
        if ((this.k == 3 && this.l == 0) || this.l == i) {
            return;
        }
        this.l = i;
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrollStateChanged(i);
        }
    }

    private void a(int i, float f2, int i2) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrolled(i, f2, i2);
        }
    }

    private void a(boolean z) {
        this.s = z;
        this.k = z ? 4 : 1;
        int i = this.o;
        if (i != -1) {
            this.n = i;
            this.o = -1;
        } else if (this.n == -1) {
            this.n = l();
        }
        a(1);
    }

    private void b(int i) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageSelected(i);
        }
    }

    private void i() {
        this.k = 0;
        this.l = 0;
        this.m.a();
        this.n = -1;
        this.o = -1;
        this.p = false;
        this.q = false;
        this.s = false;
        this.r = false;
    }

    private void j() {
        int top;
        int i;
        ScrollEventValues scrollEventValues = this.m;
        scrollEventValues.f6617a = this.j.findFirstVisibleItemPosition();
        if (scrollEventValues.f6617a == -1) {
            scrollEventValues.a();
            return;
        }
        View findViewByPosition = this.j.findViewByPosition(scrollEventValues.f6617a);
        if (findViewByPosition == null) {
            scrollEventValues.a();
            return;
        }
        int leftDecorationWidth = this.j.getLeftDecorationWidth(findViewByPosition);
        int rightDecorationWidth = this.j.getRightDecorationWidth(findViewByPosition);
        int topDecorationHeight = this.j.getTopDecorationHeight(findViewByPosition);
        int bottomDecorationHeight = this.j.getBottomDecorationHeight(findViewByPosition);
        ViewGroup.LayoutParams layoutParams = findViewByPosition.getLayoutParams();
        int i2 = leftDecorationWidth;
        int i3 = rightDecorationWidth;
        int i4 = topDecorationHeight;
        int i5 = bottomDecorationHeight;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            i2 = leftDecorationWidth + marginLayoutParams.leftMargin;
            i3 = rightDecorationWidth + marginLayoutParams.rightMargin;
            i4 = topDecorationHeight + marginLayoutParams.topMargin;
            i5 = bottomDecorationHeight + marginLayoutParams.bottomMargin;
        }
        int height = findViewByPosition.getHeight() + i4 + i5;
        int width = findViewByPosition.getWidth();
        if (this.j.getOrientation() == 0) {
            int left = (findViewByPosition.getLeft() - i2) - this.i.getPaddingLeft();
            top = left;
            if (this.h.c()) {
                top = -left;
            }
            i = width + i2 + i3;
        } else {
            top = (findViewByPosition.getTop() - i4) - this.i.getPaddingTop();
            i = height;
        }
        scrollEventValues.f6618c = -top;
        if (scrollEventValues.f6618c >= 0) {
            scrollEventValues.b = i == 0 ? 0.0f : scrollEventValues.f6618c / i;
        } else if (!new AnimateLayoutChangeDetector(this.j).a()) {
            throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(scrollEventValues.f6618c)));
        } else {
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        }
    }

    private boolean k() {
        int i = this.k;
        boolean z = true;
        if (i != 1) {
            if (i == 4) {
                return true;
            }
            z = false;
        }
        return z;
    }

    private int l() {
        return this.j.findFirstVisibleItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.r = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, boolean z) {
        this.k = z ? 2 : 3;
        boolean z2 = false;
        this.s = false;
        if (this.o != i) {
            z2 = true;
        }
        this.o = i;
        a(2);
        if (z2) {
            b(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.g = onPageChangeCallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.k = 4;
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (!f() || this.s) {
            this.s = false;
            j();
            if (this.m.f6618c != 0) {
                a(2);
                return;
            }
            if (this.m.f6617a != this.n) {
                b(this.m.f6617a);
            }
            a(0);
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.l == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return this.l == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double h() {
        j();
        return this.m.f6617a + this.m.b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        boolean z;
        if (!(this.k == 1 && this.l == 1) && i == 1) {
            a(false);
        } else if (k() && i == 2) {
            if (this.q) {
                a(2);
                this.p = true;
            }
        } else {
            if (k() && i == 0) {
                j();
                if (!this.q) {
                    z = true;
                    if (this.m.f6617a != -1) {
                        a(this.m.f6617a, 0.0f, 0);
                        z = true;
                    }
                } else if (this.m.f6618c == 0) {
                    z = true;
                    if (this.n != this.m.f6617a) {
                        b(this.m.f6617a);
                        z = true;
                    }
                } else {
                    z = false;
                }
                if (z) {
                    a(0);
                    i();
                }
            }
            if (this.k == 2 && i == 0 && this.r) {
                j();
                if (this.m.f6618c == 0) {
                    if (this.o != this.m.f6617a) {
                        b(this.m.f6617a == -1 ? 0 : this.m.f6617a);
                    }
                    a(0);
                    i();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
        if ((r7 < 0) == r5.h.c()) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0070  */
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onScrolled(androidx.recyclerview.widget.RecyclerView r6, int r7, int r8) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }
}
