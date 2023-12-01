package com.blued.community.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.community.R;
import com.blued.community.view.FloatFooterView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/FragmentHotFeedBinding.class */
public final class FragmentHotFeedBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FloatFooterView f18888a;
    public final RecyclerView b;

    /* renamed from: c  reason: collision with root package name */
    public final SmartRefreshLayout f18889c;
    public final CommonTopTitleNoTrans d;
    private final ConstraintLayout e;

    private FragmentHotFeedBinding(ConstraintLayout constraintLayout, FloatFooterView floatFooterView, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, CommonTopTitleNoTrans commonTopTitleNoTrans) {
        this.e = constraintLayout;
        this.f18888a = floatFooterView;
        this.b = recyclerView;
        this.f18889c = smartRefreshLayout;
        this.d = commonTopTitleNoTrans;
    }

    public static FragmentHotFeedBinding a(View view) {
        String str;
        FloatFooterView floatFooterView = (FloatFooterView) view.findViewById(R.id.ll_feed_post);
        if (floatFooterView != null) {
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
            if (recyclerView != null) {
                SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refresh_layout);
                if (smartRefreshLayout != null) {
                    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) view.findViewById(R.id.title);
                    if (commonTopTitleNoTrans != null) {
                        return new FragmentHotFeedBinding((ConstraintLayout) view, floatFooterView, recyclerView, smartRefreshLayout, commonTopTitleNoTrans);
                    }
                    str = "title";
                } else {
                    str = "refreshLayout";
                }
            } else {
                str = "recyclerView";
            }
        } else {
            str = "llFeedPost";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.e;
    }
}
