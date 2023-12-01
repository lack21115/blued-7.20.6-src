package com.blued.android.module.yy_china.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentYyKtvMusicListBinding.class */
public final class FragmentYyKtvMusicListBinding implements ViewBinding {
    public final SmartRefreshLayout a;
    public final RecyclerView b;
    private final ConstraintLayout c;

    private FragmentYyKtvMusicListBinding(ConstraintLayout constraintLayout, SmartRefreshLayout smartRefreshLayout, RecyclerView recyclerView) {
        this.c = constraintLayout;
        this.a = smartRefreshLayout;
        this.b = recyclerView;
    }

    public static FragmentYyKtvMusicListBinding a(View view) {
        String str;
        SmartRefreshLayout findViewById = view.findViewById(R.id.refresh_layout);
        if (findViewById != null) {
            RecyclerView findViewById2 = view.findViewById(R.id.rv_room_list);
            if (findViewById2 != null) {
                return new FragmentYyKtvMusicListBinding((ConstraintLayout) view, findViewById, findViewById2);
            }
            str = "rvRoomList";
        } else {
            str = "refreshLayout";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.c;
    }
}
