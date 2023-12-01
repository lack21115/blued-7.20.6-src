package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LayoutLiveCurHotBinding.class */
public final class LayoutLiveCurHotBinding implements ViewBinding {
    public final FrameLayout a;
    public final FrameLayout b;
    private final FrameLayout c;

    private LayoutLiveCurHotBinding(FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3) {
        this.c = frameLayout;
        this.a = frameLayout2;
        this.b = frameLayout3;
    }

    public static LayoutLiveCurHotBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_live_cur_hot, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LayoutLiveCurHotBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_main);
        if (frameLayout != null) {
            FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.fl_root);
            if (frameLayout2 != null) {
                return new LayoutLiveCurHotBinding((FrameLayout) view, frameLayout, frameLayout2);
            }
            str = "flRoot";
        } else {
            str = "flMain";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.c;
    }
}
