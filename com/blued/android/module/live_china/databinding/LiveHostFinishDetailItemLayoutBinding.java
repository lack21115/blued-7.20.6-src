package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.alipay.sdk.widget.j;
import com.blued.android.module.live_china.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveHostFinishDetailItemLayoutBinding.class */
public final class LiveHostFinishDetailItemLayoutBinding implements ViewBinding {
    public final LinearLayout a;
    public final SmartRefreshLayout b;
    public final RecyclerView c;
    private final FrameLayout d;

    private LiveHostFinishDetailItemLayoutBinding(FrameLayout frameLayout, LinearLayout linearLayout, SmartRefreshLayout smartRefreshLayout, RecyclerView recyclerView) {
        this.d = frameLayout;
        this.a = linearLayout;
        this.b = smartRefreshLayout;
        this.c = recyclerView;
    }

    public static LiveHostFinishDetailItemLayoutBinding a(View view) {
        String str;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.fl_no_data);
        if (linearLayout != null) {
            SmartRefreshLayout findViewById = view.findViewById(R.id.refresh);
            if (findViewById != null) {
                RecyclerView findViewById2 = view.findViewById(R.id.rv_list);
                if (findViewById2 != null) {
                    return new LiveHostFinishDetailItemLayoutBinding((FrameLayout) view, linearLayout, findViewById, findViewById2);
                }
                str = "rvList";
            } else {
                str = j.l;
            }
        } else {
            str = "flNoData";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.d;
    }
}
