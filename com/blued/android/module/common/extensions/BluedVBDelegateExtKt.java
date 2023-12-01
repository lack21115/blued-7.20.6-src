package com.blued.android.module.common.extensions;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/extensions/BluedVBDelegateExtKt.class */
public final class BluedVBDelegateExtKt {
    public static final View a(Activity activity) {
        Intrinsics.e(activity, "activity");
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            if (childCount != 0) {
                if (childCount == 1) {
                    View childAt = viewGroup.getChildAt(0);
                    Intrinsics.c(childAt, "contentView.getChildAt(0)");
                    return childAt;
                }
                throw new IllegalStateException("More than one child view found in Activity content view".toString());
            }
            throw new IllegalStateException("Content view has no children. Provide root view explicitly".toString());
        }
        throw new IllegalStateException("Activity has no content view".toString());
    }
}
