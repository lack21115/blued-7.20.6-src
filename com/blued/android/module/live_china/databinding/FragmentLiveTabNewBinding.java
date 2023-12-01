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

    /* renamed from: a  reason: collision with root package name */
    public final CoordinatorLayout f11973a;
    public final CustomTwoLevelHeader b;

    /* renamed from: c  reason: collision with root package name */
    public final NodataShowLiveListBinding f11974c;
    public final RecyclerView d;
    public final SmartRefreshLayout e;
    public final LiveTwoLevelRefreshView f;
    private final CoordinatorLayout g;

    private FragmentLiveTabNewBinding(CoordinatorLayout coordinatorLayout, CoordinatorLayout coordinatorLayout2, CustomTwoLevelHeader customTwoLevelHeader, NodataShowLiveListBinding nodataShowLiveListBinding, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, LiveTwoLevelRefreshView liveTwoLevelRefreshView) {
        this.g = coordinatorLayout;
        this.f11973a = coordinatorLayout2;
        this.b = customTwoLevelHeader;
        this.f11974c = nodataShowLiveListBinding;
        this.d = recyclerView;
        this.e = smartRefreshLayout;
        this.f = liveTwoLevelRefreshView;
    }

    public static FragmentLiveTabNewBinding a(View view) {
        String str;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.coordinator);
        if (coordinatorLayout != null) {
            CustomTwoLevelHeader customTwoLevelHeader = (CustomTwoLevelHeader) view.findViewById(R.id.header);
            if (customTwoLevelHeader != null) {
                View findViewById = view.findViewById(R.id.live_default_empty);
                if (findViewById != null) {
                    NodataShowLiveListBinding a2 = NodataShowLiveListBinding.a(findViewById);
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
                    if (recyclerView != null) {
                        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
                        if (smartRefreshLayout != null) {
                            LiveTwoLevelRefreshView liveTwoLevelRefreshView = (LiveTwoLevelRefreshView) view.findViewById(R.id.refresh_view);
                            if (liveTwoLevelRefreshView != null) {
                                return new FragmentLiveTabNewBinding((CoordinatorLayout) view, coordinatorLayout, customTwoLevelHeader, a2, recyclerView, smartRefreshLayout, liveTwoLevelRefreshView);
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

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public CoordinatorLayout getRoot() {
        return this.g;
    }
}
