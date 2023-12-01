package com.blued.community.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.community.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/FragmentCircleTypeListBinding.class */
public final class FragmentCircleTypeListBinding implements ViewBinding {
    public final RecyclerView a;
    public final NoDataAndLoadFailView b;
    public final SmartRefreshLayout c;
    public final CommonTopTitleNoTrans d;
    public final RecyclerView e;
    private final ConstraintLayout f;

    private FragmentCircleTypeListBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, NoDataAndLoadFailView noDataAndLoadFailView, SmartRefreshLayout smartRefreshLayout, CommonTopTitleNoTrans commonTopTitleNoTrans, RecyclerView recyclerView2) {
        this.f = constraintLayout;
        this.a = recyclerView;
        this.b = noDataAndLoadFailView;
        this.c = smartRefreshLayout;
        this.d = commonTopTitleNoTrans;
        this.e = recyclerView2;
    }

    public static FragmentCircleTypeListBinding a(View view) {
        String str;
        RecyclerView findViewById = view.findViewById(R.id.circleListRecycler);
        if (findViewById != null) {
            NoDataAndLoadFailView noDataAndLoadFailView = (NoDataAndLoadFailView) view.findViewById(R.id.classNoDataView);
            if (noDataAndLoadFailView != null) {
                SmartRefreshLayout findViewById2 = view.findViewById(R.id.refreshLayout);
                if (findViewById2 != null) {
                    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) view.findViewById(R.id.title);
                    if (commonTopTitleNoTrans != null) {
                        RecyclerView findViewById3 = view.findViewById(R.id.typeListRecycler);
                        if (findViewById3 != null) {
                            return new FragmentCircleTypeListBinding((ConstraintLayout) view, findViewById, noDataAndLoadFailView, findViewById2, commonTopTitleNoTrans, findViewById3);
                        }
                        str = "typeListRecycler";
                    } else {
                        str = "title";
                    }
                } else {
                    str = "refreshLayout";
                }
            } else {
                str = "classNoDataView";
            }
        } else {
            str = "circleListRecycler";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f;
    }
}
