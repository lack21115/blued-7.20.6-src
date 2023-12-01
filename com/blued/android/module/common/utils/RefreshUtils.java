package com.blued.android.module.common.utils;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.google.android.material.appbar.AppBarLayout;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/RefreshUtils.class */
public class RefreshUtils {

    /* renamed from: a  reason: collision with root package name */
    public static int f10911a = DensityUtils.a(AppInfo.d(), 46.0f);

    public static void a(AppBarLayout appBarLayout) {
        if (appBarLayout != null) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).getBehavior();
            if (behavior instanceof AppBarLayout.Behavior) {
                AppBarLayout.Behavior behavior2 = (AppBarLayout.Behavior) behavior;
                if (behavior2.getTopAndBottomOffset() != 0) {
                    behavior2.setTopAndBottomOffset(0);
                }
            }
        }
    }

    public static void b(AppBarLayout appBarLayout) {
        if (appBarLayout != null) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).getBehavior();
            if (behavior instanceof AppBarLayout.Behavior) {
                AppBarLayout.Behavior behavior2 = (AppBarLayout.Behavior) behavior;
                int topAndBottomOffset = behavior2.getTopAndBottomOffset();
                int i = -f10911a;
                if (topAndBottomOffset != i) {
                    behavior2.setTopAndBottomOffset(i);
                }
            }
        }
    }
}
