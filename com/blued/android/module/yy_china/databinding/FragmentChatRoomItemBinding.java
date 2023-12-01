package com.blued.android.module.yy_china.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.yy_china.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentChatRoomItemBinding.class */
public final class FragmentChatRoomItemBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final NoDataAndLoadFailView f16468a;
    public final RecyclerView b;

    /* renamed from: c  reason: collision with root package name */
    public final SmartRefreshLayout f16469c;
    private final ConstraintLayout d;

    private FragmentChatRoomItemBinding(ConstraintLayout constraintLayout, NoDataAndLoadFailView noDataAndLoadFailView, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout) {
        this.d = constraintLayout;
        this.f16468a = noDataAndLoadFailView;
        this.b = recyclerView;
        this.f16469c = smartRefreshLayout;
    }

    public static FragmentChatRoomItemBinding a(View view) {
        String str;
        NoDataAndLoadFailView noDataAndLoadFailView = (NoDataAndLoadFailView) view.findViewById(R.id.noDataView);
        if (noDataAndLoadFailView != null) {
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
            if (recyclerView != null) {
                SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refresh_layout);
                if (smartRefreshLayout != null) {
                    return new FragmentChatRoomItemBinding((ConstraintLayout) view, noDataAndLoadFailView, recyclerView, smartRefreshLayout);
                }
                str = "refreshLayout";
            } else {
                str = "recyclerView";
            }
        } else {
            str = "noDataView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.d;
    }
}
