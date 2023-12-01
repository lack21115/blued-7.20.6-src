package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LayoutLiveCurHotBinding.class */
public final class LayoutLiveCurHotBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f12092a;
    public final FrameLayout b;

    /* renamed from: c  reason: collision with root package name */
    private final FrameLayout f12093c;

    private LayoutLiveCurHotBinding(FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3) {
        this.f12093c = frameLayout;
        this.f12092a = frameLayout2;
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

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.f12093c;
    }
}
