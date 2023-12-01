package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveOperationChildViewBinding.class */
public final class LiveOperationChildViewBinding implements ViewBinding {
    public final FrameLayout a;
    public final FrameLayout b;
    public final View c;
    private final FrameLayout d;

    private LiveOperationChildViewBinding(FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, View view) {
        this.d = frameLayout;
        this.a = frameLayout2;
        this.b = frameLayout3;
        this.c = view;
    }

    public static LiveOperationChildViewBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_child_root);
        if (frameLayout != null) {
            FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.fl_root);
            if (frameLayout2 != null) {
                View findViewById = view.findViewById(R.id.view_split_line);
                if (findViewById != null) {
                    return new LiveOperationChildViewBinding((FrameLayout) view, frameLayout, frameLayout2, findViewById);
                }
                str = "viewSplitLine";
            } else {
                str = "flRoot";
            }
        } else {
            str = "flChildRoot";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.d;
    }
}
