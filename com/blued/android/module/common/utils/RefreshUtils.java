package com.blued.android.module.common.utils;

import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.google.android.material.appbar.AppBarLayout;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/RefreshUtils.class */
public class RefreshUtils {
    public static int a = DensityUtils.a(AppInfo.d(), 46.0f);

    public static void a(AppBarLayout appBarLayout) {
        if (appBarLayout != null) {
            AppBarLayout.Behavior behavior = appBarLayout.getLayoutParams().getBehavior();
            if (behavior instanceof AppBarLayout.Behavior) {
                AppBarLayout.Behavior behavior2 = behavior;
                if (behavior2.getTopAndBottomOffset() != 0) {
                    behavior2.setTopAndBottomOffset(0);
                }
            }
        }
    }

    public static void b(AppBarLayout appBarLayout) {
        if (appBarLayout != null) {
            AppBarLayout.Behavior behavior = appBarLayout.getLayoutParams().getBehavior();
            if (behavior instanceof AppBarLayout.Behavior) {
                AppBarLayout.Behavior behavior2 = behavior;
                int topAndBottomOffset = behavior2.getTopAndBottomOffset();
                int i = -a;
                if (topAndBottomOffset != i) {
                    behavior2.setTopAndBottomOffset(i);
                }
            }
        }
    }
}
