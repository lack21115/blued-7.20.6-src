package com.blued.android.module.yy_china.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.yy_china.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentYyFullServiceSquareBinding.class */
public final class FragmentYyFullServiceSquareBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f16499a;
    public final NoDataAndLoadFailView b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f16500c;
    public final SmartRefreshLayout d;
    public final CommonTopTitleNoTrans e;
    private final ConstraintLayout f;

    private FragmentYyFullServiceSquareBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, NoDataAndLoadFailView noDataAndLoadFailView, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, CommonTopTitleNoTrans commonTopTitleNoTrans) {
        this.f = constraintLayout;
        this.f16499a = constraintLayout2;
        this.b = noDataAndLoadFailView;
        this.f16500c = recyclerView;
        this.d = smartRefreshLayout;
        this.e = commonTopTitleNoTrans;
    }

    public static FragmentYyFullServiceSquareBinding a(View view) {
        String str;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.con);
        if (constraintLayout != null) {
            NoDataAndLoadFailView noDataAndLoadFailView = (NoDataAndLoadFailView) view.findViewById(R.id.noDataView);
            if (noDataAndLoadFailView != null) {
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
                if (recyclerView != null) {
                    SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refresh_layout);
                    if (smartRefreshLayout != null) {
                        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) view.findViewById(R.id.top_title);
                        if (commonTopTitleNoTrans != null) {
                            return new FragmentYyFullServiceSquareBinding((ConstraintLayout) view, constraintLayout, noDataAndLoadFailView, recyclerView, smartRefreshLayout, commonTopTitleNoTrans);
                        }
                        str = "topTitle";
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

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f;
    }
}
