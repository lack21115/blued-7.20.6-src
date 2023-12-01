package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveOperationListViewBinding.class */
public final class LiveOperationListViewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f12312a;
    private final FrameLayout b;

    private LiveOperationListViewBinding(FrameLayout frameLayout, LinearLayout linearLayout) {
        this.b = frameLayout;
        this.f12312a = linearLayout;
    }

    public static LiveOperationListViewBinding a(View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_list);
        if (linearLayout != null) {
            return new LiveOperationListViewBinding((FrameLayout) view, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("llList"));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.b;
    }
}
