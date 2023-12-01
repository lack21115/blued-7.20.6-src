package com.scwang.smartrefresh.layout.util;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.listener.CoordinatorLayoutListener;

/* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/util/DesignUtil.class */
public class DesignUtil {
    public static void a(View view, RefreshKernel refreshKernel, CoordinatorLayoutListener coordinatorLayoutListener) {
        try {
            if (view instanceof CoordinatorLayout) {
                refreshKernel.a().h(false);
                a((ViewGroup) view, coordinatorLayoutListener);
            }
        } catch (Throwable th) {
        }
    }

    private static void a(ViewGroup viewGroup, final CoordinatorLayoutListener coordinatorLayoutListener) {
        int childCount = viewGroup.getChildCount();
        while (true) {
            int i = childCount - 1;
            if (i < 0) {
                return;
            }
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof AppBarLayout) {
                ((AppBarLayout) childAt).addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.scwang.smartrefresh.layout.util.DesignUtil.1
                    @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
                    public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
                        CoordinatorLayoutListener coordinatorLayoutListener2 = CoordinatorLayoutListener.this;
                        boolean z = true;
                        boolean z2 = i2 >= 0;
                        if (appBarLayout.getTotalScrollRange() + i2 > 0) {
                            z = false;
                        }
                        coordinatorLayoutListener2.a(z2, z);
                    }
                });
            }
            childCount = i;
        }
    }
}
