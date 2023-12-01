package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/PopWindowRankingListHostBinding.class */
public final class PopWindowRankingListHostBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f12497a;
    public final RelativeLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f12498c;
    public final SmartRefreshLayout d;
    public final TextView e;
    private final FrameLayout f;

    private PopWindowRankingListHostBinding(FrameLayout frameLayout, ImageView imageView, RelativeLayout relativeLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, TextView textView) {
        this.f = frameLayout;
        this.f12497a = imageView;
        this.b = relativeLayout;
        this.f12498c = recyclerView;
        this.d = smartRefreshLayout;
        this.e = textView;
    }

    public static PopWindowRankingListHostBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_empty_view);
        if (imageView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_empty_view);
            if (relativeLayout != null) {
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
                if (recyclerView != null) {
                    SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.smart_refresh);
                    if (smartRefreshLayout != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_empty_view);
                        if (textView != null) {
                            return new PopWindowRankingListHostBinding((FrameLayout) view, imageView, relativeLayout, recyclerView, smartRefreshLayout, textView);
                        }
                        str = "tvEmptyView";
                    } else {
                        str = "smartRefresh";
                    }
                } else {
                    str = "rvList";
                }
            } else {
                str = "rlEmptyView";
            }
        } else {
            str = "ivEmptyView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.f;
    }
}
