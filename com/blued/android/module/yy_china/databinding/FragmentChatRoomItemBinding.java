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
    public final NoDataAndLoadFailView a;
    public final RecyclerView b;
    public final SmartRefreshLayout c;
    private final ConstraintLayout d;

    private FragmentChatRoomItemBinding(ConstraintLayout constraintLayout, NoDataAndLoadFailView noDataAndLoadFailView, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout) {
        this.d = constraintLayout;
        this.a = noDataAndLoadFailView;
        this.b = recyclerView;
        this.c = smartRefreshLayout;
    }

    public static FragmentChatRoomItemBinding a(View view) {
        String str;
        NoDataAndLoadFailView noDataAndLoadFailView = (NoDataAndLoadFailView) view.findViewById(R.id.noDataView);
        if (noDataAndLoadFailView != null) {
            RecyclerView findViewById = view.findViewById(R.id.recycler_view);
            if (findViewById != null) {
                SmartRefreshLayout findViewById2 = view.findViewById(R.id.refresh_layout);
                if (findViewById2 != null) {
                    return new FragmentChatRoomItemBinding((ConstraintLayout) view, noDataAndLoadFailView, findViewById, findViewById2);
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

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.d;
    }
}
