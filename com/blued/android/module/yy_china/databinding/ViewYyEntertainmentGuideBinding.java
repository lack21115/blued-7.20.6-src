package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewYyEntertainmentGuideBinding.class */
public final class ViewYyEntertainmentGuideBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f16907a;

    private ViewYyEntertainmentGuideBinding(LinearLayout linearLayout) {
        this.f16907a = linearLayout;
    }

    public static ViewYyEntertainmentGuideBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_yy_entertainment_guide, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewYyEntertainmentGuideBinding a(View view) {
        if (view != null) {
            return new ViewYyEntertainmentGuideBinding((LinearLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.f16907a;
    }
}
