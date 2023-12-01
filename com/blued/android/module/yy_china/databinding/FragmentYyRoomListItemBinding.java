package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentYyRoomListItemBinding.class */
public final class FragmentYyRoomListItemBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final NoDataAndLoadFailView f16546a;
    public final RecyclerView b;

    /* renamed from: c  reason: collision with root package name */
    private final FrameLayout f16547c;

    private FragmentYyRoomListItemBinding(FrameLayout frameLayout, NoDataAndLoadFailView noDataAndLoadFailView, RecyclerView recyclerView) {
        this.f16547c = frameLayout;
        this.f16546a = noDataAndLoadFailView;
        this.b = recyclerView;
    }

    public static FragmentYyRoomListItemBinding a(View view) {
        String str;
        NoDataAndLoadFailView noDataAndLoadFailView = (NoDataAndLoadFailView) view.findViewById(R.id.empty_view);
        if (noDataAndLoadFailView != null) {
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_room_list);
            if (recyclerView != null) {
                return new FragmentYyRoomListItemBinding((FrameLayout) view, noDataAndLoadFailView, recyclerView);
            }
            str = "rvRoomList";
        } else {
            str = "emptyView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.f16547c;
    }
}
