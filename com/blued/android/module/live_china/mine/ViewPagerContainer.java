package com.blued.android.module.live_china.mine;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/ViewPagerContainer.class */
public final class ViewPagerContainer extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private ViewPager f13881a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private int f13882c;
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

    /* JADX WARN: Code restructure failed: missing block: B:55:0x010b, code lost:
        if ((r6 - r4.d) >= 0) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void a(int r5, int r6, int r7, int r8) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.mine.ViewPagerContainer.a(int, int, int, int):void");
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
            View childAt = getChildAt(i2);
            if (childAt instanceof ViewPager) {
                this.f13881a = (ViewPager) childAt;
                break;
            }
            i = i2 + 1;
        }
        if (this.f13881a == null) {
            throw new IllegalStateException("The root child of ViewPager2Container must contains a ViewPager2");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x005d, code lost:
        if (r11.getCount() <= 1) goto L34;
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
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.mine.ViewPagerContainer.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }
}
