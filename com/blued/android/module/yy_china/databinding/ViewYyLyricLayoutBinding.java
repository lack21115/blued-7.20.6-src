package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewYyLyricLayoutBinding.class */
public final class ViewYyLyricLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f16925a;
    private final FrameLayout b;

    private ViewYyLyricLayoutBinding(FrameLayout frameLayout, RecyclerView recyclerView) {
        this.b = frameLayout;
        this.f16925a = recyclerView;
    }

    public static ViewYyLyricLayoutBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_yy_lyric_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewYyLyricLayoutBinding a(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_words_list);
        if (recyclerView != null) {
            return new ViewYyLyricLayoutBinding((FrameLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("rvWordsList"));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.b;
    }
}
