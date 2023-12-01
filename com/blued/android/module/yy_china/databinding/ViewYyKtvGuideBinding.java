package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewYyKtvGuideBinding.class */
public final class ViewYyKtvGuideBinding implements ViewBinding {
    private final LinearLayout a;

    private ViewYyKtvGuideBinding(LinearLayout linearLayout) {
        this.a = linearLayout;
    }

    public static ViewYyKtvGuideBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_yy_ktv_guide, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewYyKtvGuideBinding a(View view) {
        if (view != null) {
            return new ViewYyKtvGuideBinding((LinearLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.a;
    }
}
