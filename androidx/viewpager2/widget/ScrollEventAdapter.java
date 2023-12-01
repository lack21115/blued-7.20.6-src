package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/viewpager2/widget/ScrollEventAdapter.class */
public final class ScrollEventAdapter extends RecyclerView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    private ViewPager2.OnPageChangeCallback f3589a;
    private final ViewPager2 b;

    /* renamed from: c  reason: collision with root package name */
    private final RecyclerView f3590c;
    private final LinearLayoutManager d;
    private int e;
    private int f;
    private ScrollEventValues g;
    private int h;
    private int i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues.class */
    public static final class ScrollEventValues {

        /* renamed from: a  reason: collision with root package name */
        int f3591a;
        float b;

        /* renamed from: c  reason: collision with root package name */
        int f3592c;

        ScrollEventValues() {
        }

        void a() {
            this.f3591a = -1;
            this.b = 0.0f;
            this.f3592c = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ScrollEventAdapter(ViewPager2 viewPager2) {
        this.b = viewPager2;
        RecyclerView recyclerView = viewPager2.d;
        this.f3590c = recyclerView;
        this.d = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.g = new ScrollEventValues();
        i();
    }

    private void a(int i) {
        if ((this.e == 3 && this.f == 0) || this.f == i) {
            return;
        }
        this.f = i;
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f3589a;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrollStateChanged(i);
        }
    }

    private void a(int i, float f, int i2) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f3589a;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrolled(i, f, i2);
        }
    }

    private void a(boolean z) {
        this.m = z;
        this.e = z ? 4 : 1;
        int i = this.i;
        if (i != -1) {
            this.h = i;
            this.i = -1;
        } else if (this.h == -1) {
            this.h = l();
        }
        a(1);
    }

    private void b(int i) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f3589a;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageSelected(i);
        }
    }

    private void i() {
        this.e = 0;
        this.f = 0;
        this.g.a();
        this.h = -1;
        this.i = -1;
        this.j = false;
        this.k = false;
        this.m = false;
        this.l = false;
    }

    private void j() {
        int top;
        int i;
        ScrollEventValues scrollEventValues = this.g;
        scrollEventValues.f3591a = this.d.findFirstVisibleItemPosition();
        if (scrollEventValues.f3591a == -1) {
            scrollEventValues.a();
            return;
        }
        View findViewByPosition = this.d.findViewByPosition(scrollEventValues.f3591a);
        if (findViewByPosition == null) {
            scrollEventValues.a();
            return;
        }
        int leftDecorationWidth = this.d.getLeftDecorationWidth(findViewByPosition);
        int rightDecorationWidth = this.d.getRightDecorationWidth(findViewByPosition);
        int topDecorationHeight = this.d.getTopDecorationHeight(findViewByPosition);
        int bottomDecorationHeight = this.d.getBottomDecorationHeight(findViewByPosition);
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
        if (this.d.getOrientation() == 0) {
            int left = (findViewByPosition.getLeft() - i2) - this.f3590c.getPaddingLeft();
            top = left;
            if (this.b.b()) {
                top = -left;
            }
            i = width + i2 + i3;
        } else {
            top = (findViewByPosition.getTop() - i4) - this.f3590c.getPaddingTop();
            i = height;
        }
        scrollEventValues.f3592c = -top;
        if (scrollEventValues.f3592c >= 0) {
            scrollEventValues.b = i == 0 ? 0.0f : scrollEventValues.f3592c / i;
        } else if (!new AnimateLayoutChangeDetector(this.d).a()) {
            throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(scrollEventValues.f3592c)));
        } else {
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        }
    }

    private boolean k() {
        int i = this.e;
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
        return this.d.findFirstVisibleItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.l = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, boolean z) {
        this.e = z ? 2 : 3;
        boolean z2 = false;
        this.m = false;
        if (this.i != i) {
            z2 = true;
        }
        this.i = i;
        a(2);
        if (z2) {
            b(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f3589a = onPageChangeCallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.e = 4;
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (!f() || this.m) {
            this.m = false;
            j();
            if (this.g.f3592c != 0) {
                a(2);
                return;
            }
            if (this.g.f3591a != this.h) {
                b(this.g.f3591a);
            }
            a(0);
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return this.f == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double h() {
        j();
        return this.g.f3591a + this.g.b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        boolean z;
        if (!(this.e == 1 && this.f == 1) && i == 1) {
            a(false);
        } else if (k() && i == 2) {
            if (this.k) {
                a(2);
                this.j = true;
            }
        } else {
            if (k() && i == 0) {
                j();
                if (!this.k) {
                    z = true;
                    if (this.g.f3591a != -1) {
                        a(this.g.f3591a, 0.0f, 0);
                        z = true;
                    }
                } else if (this.g.f3592c == 0) {
                    z = true;
                    if (this.h != this.g.f3591a) {
                        b(this.g.f3591a);
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
            if (this.e == 2 && i == 0 && this.l) {
                j();
                if (this.g.f3592c == 0) {
                    if (this.i != this.g.f3591a) {
                        b(this.g.f3591a == -1 ? 0 : this.g.f3591a);
                    }
                    a(0);
                    i();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
        if ((r7 < 0) == r5.b.b()) goto L41;
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.ScrollEventAdapter.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }
}
