package com.blued.android.module.live_china.databinding;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.CustomTwoLevelHeader;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.view.LiveTwoLevelRefreshView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/FragmentLiveTabNewBinding.class */
public final class FragmentLiveTabNewBinding implements ViewBinding {
    public final CoordinatorLayout a;
    public final CustomTwoLevelHeader b;
    public final NodataShowLiveListBinding c;
    public final RecyclerView d;
    public final SmartRefreshLayout e;
    public final LiveTwoLevelRefreshView f;
    private final CoordinatorLayout g;

    private FragmentLiveTabNewBinding(CoordinatorLayout coordinatorLayout, CoordinatorLayout coordinatorLayout2, CustomTwoLevelHeader customTwoLevelHeader, NodataShowLiveListBinding nodataShowLiveListBinding, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, LiveTwoLevelRefreshView liveTwoLevelRefreshView) {
        this.g = coordinatorLayout;
        this.a = coordinatorLayout2;
        this.b = customTwoLevelHeader;
        this.c = nodataShowLiveListBinding;
        this.d = recyclerView;
        this.e = smartRefreshLayout;
        this.f = liveTwoLevelRefreshView;
    }

    public static FragmentLiveTabNewBinding a(View view) {
        String str;
        CoordinatorLayout findViewById = view.findViewById(R.id.coordinator);
        if (findViewById != null) {
            CustomTwoLevelHeader customTwoLevelHeader = (CustomTwoLevelHeader) view.findViewById(R.id.header);
            if (customTwoLevelHeader != null) {
                View findViewById2 = view.findViewById(R.id.live_default_empty);
                if (findViewById2 != null) {
                    NodataShowLiveListBinding a = NodataShowLiveListBinding.a(findViewById2);
                    RecyclerView findViewById3 = view.findViewById(R.id.recycler_view);
                    if (findViewById3 != null) {
                        SmartRefreshLayout findViewById4 = view.findViewById(R.id.refreshLayout);
                        if (findViewById4 != null) {
                            LiveTwoLevelRefreshView liveTwoLevelRefreshView = (LiveTwoLevelRefreshView) view.findViewById(R.id.refresh_view);
                            if (liveTwoLevelRefreshView != null) {
                                return new FragmentLiveTabNewBinding((CoordinatorLayout) view, findViewById, customTwoLevelHeader, a, findViewById3, findViewById4, liveTwoLevelRefreshView);
                            }
                            str = "refreshView";
                        } else {
                            str = "refreshLayout";
                        }
                    } else {
                        str = "recyclerView";
                    }
                } else {
                    str = "liveDefaultEmpty";
                }
            } else {
                str = "header";
            }
        } else {
            str = "coordinator";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public CoordinatorLayout getRoot() {
        return this.g;
    }
}
