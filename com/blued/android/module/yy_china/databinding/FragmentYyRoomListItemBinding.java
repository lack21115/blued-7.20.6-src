package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentYyRoomListItemBinding.class */
public final class FragmentYyRoomListItemBinding implements ViewBinding {
    public final NoDataAndLoadFailView a;
    public final RecyclerView b;
    private final FrameLayout c;

    private FragmentYyRoomListItemBinding(FrameLayout frameLayout, NoDataAndLoadFailView noDataAndLoadFailView, RecyclerView recyclerView) {
        this.c = frameLayout;
        this.a = noDataAndLoadFailView;
        this.b = recyclerView;
    }

    public static FragmentYyRoomListItemBinding a(View view) {
        String str;
        NoDataAndLoadFailView noDataAndLoadFailView = (NoDataAndLoadFailView) view.findViewById(R.id.empty_view);
        if (noDataAndLoadFailView != null) {
            RecyclerView findViewById = view.findViewById(R.id.rv_room_list);
            if (findViewById != null) {
                return new FragmentYyRoomListItemBinding((FrameLayout) view, noDataAndLoadFailView, findViewById);
            }
            str = "rvRoomList";
        } else {
            str = "emptyView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.c;
    }
}
