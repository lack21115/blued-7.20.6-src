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

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f18841a;
    public final NoDataAndLoadFailView b;

    /* renamed from: c  reason: collision with root package name */
    public final SmartRefreshLayout f18842c;
    public final CommonTopTitleNoTrans d;
    public final RecyclerView e;
    private final ConstraintLayout f;

    private FragmentCircleTypeListBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, NoDataAndLoadFailView noDataAndLoadFailView, SmartRefreshLayout smartRefreshLayout, CommonTopTitleNoTrans commonTopTitleNoTrans, RecyclerView recyclerView2) {
        this.f = constraintLayout;
        this.f18841a = recyclerView;
        this.b = noDataAndLoadFailView;
        this.f18842c = smartRefreshLayout;
        this.d = commonTopTitleNoTrans;
        this.e = recyclerView2;
    }

    public static FragmentCircleTypeListBinding a(View view) {
        String str;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.circleListRecycler);
        if (recyclerView != null) {
            NoDataAndLoadFailView noDataAndLoadFailView = (NoDataAndLoadFailView) view.findViewById(R.id.classNoDataView);
            if (noDataAndLoadFailView != null) {
                SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
                if (smartRefreshLayout != null) {
                    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) view.findViewById(R.id.title);
                    if (commonTopTitleNoTrans != null) {
                        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.typeListRecycler);
                        if (recyclerView2 != null) {
                            return new FragmentCircleTypeListBinding((ConstraintLayout) view, recyclerView, noDataAndLoadFailView, smartRefreshLayout, commonTopTitleNoTrans, recyclerView2);
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

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f;
    }
}
