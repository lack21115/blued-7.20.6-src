package com.blued.android.module.live_china.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.anythink.expressad.foundation.d.c;
import com.blued.android.module.live_china.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveHotFragmentLayoutTestBinding.class */
public final class LiveHotFragmentLayoutTestBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f12253a;
    public final SmartRefreshLayout b;

    /* renamed from: c  reason: collision with root package name */
    private final ConstraintLayout f12254c;

    private LiveHotFragmentLayoutTestBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout) {
        this.f12254c = constraintLayout;
        this.f12253a = recyclerView;
        this.b = smartRefreshLayout;
    }

    public static LiveHotFragmentLayoutTestBinding a(View view) {
        String str;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv);
        if (recyclerView != null) {
            SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.smart_refresh);
            if (smartRefreshLayout != null) {
                return new LiveHotFragmentLayoutTestBinding((ConstraintLayout) view, recyclerView, smartRefreshLayout);
            }
            str = "smartRefresh";
        } else {
            str = c.ck;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f12254c;
    }
}
