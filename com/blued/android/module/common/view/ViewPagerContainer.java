package com.blued.android.module.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/ViewPagerContainer.class */
public final class ViewPagerContainer extends RelativeLayout {
    private ViewPager a;
    private boolean b;
    private int c;
    private int d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewPagerContainer(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewPagerContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPagerContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.b = true;
    }

    public /* synthetic */ ViewPagerContainer(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void a(int i, int i2, int i3) {
        ViewPager viewPager = this.a;
        PagerAdapter pagerAdapter = null;
        if ((viewPager == null ? null : viewPager.getAdapter()) == null) {
            return;
        }
        boolean z = false;
        if (i2 <= i3) {
            if (i3 > i2) {
                getParent().requestDisallowInterceptTouchEvent(false);
                return;
            }
            return;
        }
        ViewPager viewPager2 = this.a;
        Integer valueOf = viewPager2 == null ? null : Integer.valueOf(viewPager2.getCurrentItem());
        ViewPager viewPager3 = this.a;
        if (viewPager3 != null) {
            pagerAdapter = viewPager3.getAdapter();
        }
        Intrinsics.a(pagerAdapter);
        int count = pagerAdapter.getCount();
        if (valueOf != null && valueOf.intValue() == 0 && i - this.c > 0) {
            getParent().requestDisallowInterceptTouchEvent(false);
            return;
        }
        ViewParent parent = getParent();
        if (valueOf == null || valueOf.intValue() != count - 1 || i - this.c >= 0) {
            z = true;
        }
        parent.requestDisallowInterceptTouchEvent(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                break;
            }
            ViewPager childAt = getChildAt(i2);
            if (childAt instanceof ViewPager) {
                this.a = childAt;
                break;
            }
            i = i2 + 1;
        }
        if (this.a == null) {
            throw new IllegalStateException("The root child of ViewPager2Container must contains a ViewPager2");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x005d, code lost:
        if (r10.getCount() <= 1) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0089, code lost:
        if (r0 != 3) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0074  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.view.ViewPagerContainer.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }
}
