package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.yy_china.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentYyHotTopicItemBinding.class */
public final class FragmentYyHotTopicItemBinding implements ViewBinding {
    public final ShapeConstraintLayout a;
    public final NoDataAndLoadFailView b;
    public final RecyclerView c;
    public final SmartRefreshLayout d;
    public final TextView e;
    private final ConstraintLayout f;

    private FragmentYyHotTopicItemBinding(ConstraintLayout constraintLayout, ShapeConstraintLayout shapeConstraintLayout, NoDataAndLoadFailView noDataAndLoadFailView, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, TextView textView) {
        this.f = constraintLayout;
        this.a = shapeConstraintLayout;
        this.b = noDataAndLoadFailView;
        this.c = recyclerView;
        this.d = smartRefreshLayout;
        this.e = textView;
    }

    public static FragmentYyHotTopicItemBinding a(View view) {
        String str;
        ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.con);
        if (shapeConstraintLayout != null) {
            NoDataAndLoadFailView noDataAndLoadFailView = (NoDataAndLoadFailView) view.findViewById(R.id.noDataView);
            if (noDataAndLoadFailView != null) {
                RecyclerView findViewById = view.findViewById(R.id.recycler_view);
                if (findViewById != null) {
                    SmartRefreshLayout findViewById2 = view.findViewById(R.id.refresh_layout);
                    if (findViewById2 != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_hot_topic_name);
                        if (textView != null) {
                            return new FragmentYyHotTopicItemBinding((ConstraintLayout) view, shapeConstraintLayout, noDataAndLoadFailView, findViewById, findViewById2, textView);
                        }
                        str = "tvHotTopicName";
                    } else {
                        str = "refreshLayout";
                    }
                } else {
                    str = "recyclerView";
                }
            } else {
                str = "noDataView";
            }
        } else {
            str = "con";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f;
    }
}
