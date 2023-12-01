package com.blued.android.module.live_china.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveHotFragmentLayoutTestBinding.class */
public final class LiveHotFragmentLayoutTestBinding implements ViewBinding {
    public final RecyclerView a;
    public final SmartRefreshLayout b;
    private final ConstraintLayout c;

    private LiveHotFragmentLayoutTestBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout) {
        this.c = constraintLayout;
        this.a = recyclerView;
        this.b = smartRefreshLayout;
    }

    public static LiveHotFragmentLayoutTestBinding a(View view) {
        String str;
        RecyclerView findViewById = view.findViewById(R.id.rv);
        if (findViewById != null) {
            SmartRefreshLayout findViewById2 = view.findViewById(R.id.smart_refresh);
            if (findViewById2 != null) {
                return new LiveHotFragmentLayoutTestBinding((ConstraintLayout) view, findViewById, findViewById2);
            }
            str = "smartRefresh";
        } else {
            str = "rv";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.c;
    }
}
