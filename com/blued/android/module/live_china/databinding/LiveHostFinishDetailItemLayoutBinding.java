package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveHostFinishDetailItemLayoutBinding.class */
public final class LiveHostFinishDetailItemLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f12245a;
    public final SmartRefreshLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f12246c;
    private final FrameLayout d;

    private LiveHostFinishDetailItemLayoutBinding(FrameLayout frameLayout, LinearLayout linearLayout, SmartRefreshLayout smartRefreshLayout, RecyclerView recyclerView) {
        this.d = frameLayout;
        this.f12245a = linearLayout;
        this.b = smartRefreshLayout;
        this.f12246c = recyclerView;
    }

    public static LiveHostFinishDetailItemLayoutBinding a(View view) {
        String str;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.fl_no_data);
        if (linearLayout != null) {
            SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refresh);
            if (smartRefreshLayout != null) {
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
                if (recyclerView != null) {
                    return new LiveHostFinishDetailItemLayoutBinding((FrameLayout) view, linearLayout, smartRefreshLayout, recyclerView);
                }
                str = "rvList";
            } else {
                str = "refresh";
            }
        } else {
            str = "flNoData";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.d;
    }
}
