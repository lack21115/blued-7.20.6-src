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
    public final FloatFooterView a;
    public final NoDataAndLoadFailView b;
    public final RecyclerView c;
    public final SmartRefreshLayout d;
    public final CommonTopTitleNoTrans e;
    private final ConstraintLayout f;

    private FragmentEventListBinding(ConstraintLayout constraintLayout, FloatFooterView floatFooterView, NoDataAndLoadFailView noDataAndLoadFailView, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, CommonTopTitleNoTrans commonTopTitleNoTrans) {
        this.f = constraintLayout;
        this.a = floatFooterView;
        this.b = noDataAndLoadFailView;
        this.c = recyclerView;
        this.d = smartRefreshLayout;
        this.e = commonTopTitleNoTrans;
    }

    public static FragmentEventListBinding a(View view) {
        String str;
        FloatFooterView findViewById = view.findViewById(R.id.event_post);
        if (findViewById != null) {
            NoDataAndLoadFailView noDataAndLoadFailView = (NoDataAndLoadFailView) view.findViewById(R.id.noDataView);
            if (noDataAndLoadFailView != null) {
                RecyclerView findViewById2 = view.findViewById(R.id.recycle_view);
                if (findViewById2 != null) {
                    SmartRefreshLayout findViewById3 = view.findViewById(R.id.refresh_layout);
                    if (findViewById3 != null) {
                        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) view.findViewById(R.id.title);
                        if (commonTopTitleNoTrans != null) {
                            return new FragmentEventListBinding((ConstraintLayout) view, findViewById, noDataAndLoadFailView, findViewById2, findViewById3, commonTopTitleNoTrans);
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

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f;
    }
}
