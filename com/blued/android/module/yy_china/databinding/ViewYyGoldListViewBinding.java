package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewYyGoldListViewBinding.class */
public final class ViewYyGoldListViewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f16920a;
    private final ShapeLinearLayout b;

    private ViewYyGoldListViewBinding(ShapeLinearLayout shapeLinearLayout, RecyclerView recyclerView) {
        this.b = shapeLinearLayout;
        this.f16920a = recyclerView;
    }

    public static ViewYyGoldListViewBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_yy_gold_list_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewYyGoldListViewBinding a(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_rank_list);
        if (recyclerView != null) {
            return new ViewYyGoldListViewBinding((ShapeLinearLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("rvRankList"));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ShapeLinearLayout getRoot() {
        return this.b;
    }
}
