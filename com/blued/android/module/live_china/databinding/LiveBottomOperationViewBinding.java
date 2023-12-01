package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveBottomOperationViewBinding.class */
public final class LiveBottomOperationViewBinding implements ViewBinding {
    public final LinearLayout a;
    private final FrameLayout b;

    private LiveBottomOperationViewBinding(FrameLayout frameLayout, LinearLayout linearLayout) {
        this.b = frameLayout;
        this.a = linearLayout;
    }

    public static LiveBottomOperationViewBinding a(View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_child_root);
        if (linearLayout != null) {
            return new LiveBottomOperationViewBinding((FrameLayout) view, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("llChildRoot"));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.b;
    }
}
