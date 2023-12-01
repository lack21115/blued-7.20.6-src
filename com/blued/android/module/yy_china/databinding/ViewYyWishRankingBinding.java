package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewYyWishRankingBinding.class */
public final class ViewYyWishRankingBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f16977a;
    private final LinearLayout b;

    private ViewYyWishRankingBinding(LinearLayout linearLayout, RecyclerView recyclerView) {
        this.b = linearLayout;
        this.f16977a = recyclerView;
    }

    public static ViewYyWishRankingBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_yy_wish_ranking, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewYyWishRankingBinding a(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_item_list);
        if (recyclerView != null) {
            return new ViewYyWishRankingBinding((LinearLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("rvItemList"));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.b;
    }
}
