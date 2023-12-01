package com.blued.android.framework.view.pulltorefresh;

import android.view.View;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/OverscrollHelper.class */
public final class OverscrollHelper {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.framework.view.pulltorefresh.OverscrollHelper$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/OverscrollHelper$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0020 -> B:11:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[PullToRefreshBase.Orientation.values().length];
            a = iArr;
            try {
                iArr[PullToRefreshBase.Orientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[PullToRefreshBase.Orientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static void a(PullToRefreshBase<?> pullToRefreshBase, int i, int i2, int i3, int i4, int i5, int i6, float f, boolean z) {
        int scrollX;
        int i7;
        if (AnonymousClass1.a[pullToRefreshBase.getPullToRefreshScrollDirection().ordinal()] != 1) {
            i7 = i3;
            scrollX = pullToRefreshBase.getScrollY();
        } else {
            scrollX = pullToRefreshBase.getScrollX();
            i4 = i2;
            i7 = i;
        }
        if (!pullToRefreshBase.h() || pullToRefreshBase.i()) {
            return;
        }
        PullToRefreshBase.Mode mode = pullToRefreshBase.getMode();
        if (!mode.b() || z || i7 == 0) {
            if (z && PullToRefreshBase.State.OVERSCROLLING == pullToRefreshBase.getState()) {
                pullToRefreshBase.a(PullToRefreshBase.State.RESET, new boolean[0]);
                return;
            }
            return;
        }
        int i8 = i7 + i4;
        if (i8 < 0 - i6) {
            if (mode.c()) {
                if (scrollX == 0) {
                    pullToRefreshBase.a(PullToRefreshBase.State.OVERSCROLLING, new boolean[0]);
                }
                pullToRefreshBase.setHeaderScroll((int) (f * (scrollX + i8)));
            }
        } else if (i8 <= i5 + i6) {
            if (Math.abs(i8) <= i6 || Math.abs(i8 - i5) <= i6) {
                pullToRefreshBase.a(PullToRefreshBase.State.RESET, new boolean[0]);
            }
        } else if (mode.d()) {
            if (scrollX == 0) {
                pullToRefreshBase.a(PullToRefreshBase.State.OVERSCROLLING, new boolean[0]);
            }
            pullToRefreshBase.setHeaderScroll((int) (f * ((scrollX + i8) - i5)));
        }
    }

    public static void a(PullToRefreshBase<?> pullToRefreshBase, int i, int i2, int i3, int i4, int i5, boolean z) {
        a(pullToRefreshBase, i, i2, i3, i4, i5, 0, 1.0f, z);
    }

    public static void a(PullToRefreshBase<?> pullToRefreshBase, int i, int i2, int i3, int i4, boolean z) {
        a(pullToRefreshBase, i, i2, i3, i4, 0, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(View view) {
        return view.getOverScrollMode() != 2;
    }
}
