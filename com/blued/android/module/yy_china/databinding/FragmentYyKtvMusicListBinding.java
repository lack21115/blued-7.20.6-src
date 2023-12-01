package com.blued.android.module.yy_china.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentYyKtvMusicListBinding.class */
public final class FragmentYyKtvMusicListBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final SmartRefreshLayout f16519a;
    public final RecyclerView b;

    /* renamed from: c  reason: collision with root package name */
    private final ConstraintLayout f16520c;

    private FragmentYyKtvMusicListBinding(ConstraintLayout constraintLayout, SmartRefreshLayout smartRefreshLayout, RecyclerView recyclerView) {
        this.f16520c = constraintLayout;
        this.f16519a = smartRefreshLayout;
        this.b = recyclerView;
    }

    public static FragmentYyKtvMusicListBinding a(View view) {
        String str;
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refresh_layout);
        if (smartRefreshLayout != null) {
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_room_list);
            if (recyclerView != null) {
                return new FragmentYyKtvMusicListBinding((ConstraintLayout) view, smartRefreshLayout, recyclerView);
            }
            str = "rvRoomList";
        } else {
            str = "refreshLayout";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f16520c;
    }
}
