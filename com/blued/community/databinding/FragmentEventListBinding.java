package com.blued.community.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.community.R;
import com.blued.community.view.FloatFooterView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/FragmentEventListBinding.class */
public final class FragmentEventListBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FloatFooterView f18854a;
    public final NoDataAndLoadFailView b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f18855c;
    public final SmartRefreshLayout d;
    public final CommonTopTitleNoTrans e;
    private final ConstraintLayout f;

    private FragmentEventListBinding(ConstraintLayout constraintLayout, FloatFooterView floatFooterView, NoDataAndLoadFailView noDataAndLoadFailView, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, CommonTopTitleNoTrans commonTopTitleNoTrans) {
        this.f = constraintLayout;
        this.f18854a = floatFooterView;
        this.b = noDataAndLoadFailView;
        this.f18855c = recyclerView;
        this.d = smartRefreshLayout;
        this.e = commonTopTitleNoTrans;
    }

    public static FragmentEventListBinding a(View view) {
        String str;
        FloatFooterView floatFooterView = (FloatFooterView) view.findViewById(R.id.event_post);
        if (floatFooterView != null) {
            NoDataAndLoadFailView noDataAndLoadFailView = (NoDataAndLoadFailView) view.findViewById(R.id.noDataView);
            if (noDataAndLoadFailView != null) {
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
                if (recyclerView != null) {
                    SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refresh_layout);
                    if (smartRefreshLayout != null) {
                        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) view.findViewById(R.id.title);
                        if (commonTopTitleNoTrans != null) {
                            return new FragmentEventListBinding((ConstraintLayout) view, floatFooterView, noDataAndLoadFailView, recyclerView, smartRefreshLayout, commonTopTitleNoTrans);
                        }
                        str = "title";
                    } else {
                        str = "refreshLayout";
                    }
                } else {
                    str = "recycleView";
                }
            } else {
                str = "noDataView";
            }
        } else {
            str = "eventPost";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f;
    }
}
