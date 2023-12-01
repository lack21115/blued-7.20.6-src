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
    public final ConstraintLayout a;
    public final NoDataAndLoadFailView b;
    public final RecyclerView c;
    public final SmartRefreshLayout d;
    public final CommonTopTitleNoTrans e;
    private final ConstraintLayout f;

    private FragmentYyFullServiceSquareBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, NoDataAndLoadFailView noDataAndLoadFailView, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, CommonTopTitleNoTrans commonTopTitleNoTrans) {
        this.f = constraintLayout;
        this.a = constraintLayout2;
        this.b = noDataAndLoadFailView;
        this.c = recyclerView;
        this.d = smartRefreshLayout;
        this.e = commonTopTitleNoTrans;
    }

    public static FragmentYyFullServiceSquareBinding a(View view) {
        String str;
        ConstraintLayout findViewById = view.findViewById(R.id.con);
        if (findViewById != null) {
            NoDataAndLoadFailView noDataAndLoadFailView = (NoDataAndLoadFailView) view.findViewById(R.id.noDataView);
            if (noDataAndLoadFailView != null) {
                RecyclerView findViewById2 = view.findViewById(R.id.recycler_view);
                if (findViewById2 != null) {
                    SmartRefreshLayout findViewById3 = view.findViewById(R.id.refresh_layout);
                    if (findViewById3 != null) {
                        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) view.findViewById(R.id.top_title);
                        if (commonTopTitleNoTrans != null) {
                            return new FragmentYyFullServiceSquareBinding((ConstraintLayout) view, findViewById, noDataAndLoadFailView, findViewById2, findViewById3, commonTopTitleNoTrans);
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

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f;
    }
}
