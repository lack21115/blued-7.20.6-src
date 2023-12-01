package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LayoutOnlineUserBinding.class */
public final class LayoutOnlineUserBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f12107a;
    public final RecyclerView b;

    /* renamed from: c  reason: collision with root package name */
    public final SmartRefreshLayout f12108c;
    private final RelativeLayout d;

    private LayoutOnlineUserBinding(RelativeLayout relativeLayout, LinearLayout linearLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout) {
        this.d = relativeLayout;
        this.f12107a = linearLayout;
        this.b = recyclerView;
        this.f12108c = smartRefreshLayout;
    }

    public static LayoutOnlineUserBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static LayoutOnlineUserBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_online_user, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LayoutOnlineUserBinding a(View view) {
        String str;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_no_online_user_empty_view);
        if (linearLayout != null) {
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
            if (recyclerView != null) {
                SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.smart_refresh_layout);
                if (smartRefreshLayout != null) {
                    return new LayoutOnlineUserBinding((RelativeLayout) view, linearLayout, recyclerView, smartRefreshLayout);
                }
                str = "smartRefreshLayout";
            } else {
                str = "recyclerView";
            }
        } else {
            str = "llNoOnlineUserEmptyView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.d;
    }
}
