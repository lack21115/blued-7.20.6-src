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
    public final FloatFooterView a;
    public final RecyclerView b;
    public final SmartRefreshLayout c;
    public final CommonTopTitleNoTrans d;
    private final ConstraintLayout e;

    private FragmentHotFeedBinding(ConstraintLayout constraintLayout, FloatFooterView floatFooterView, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, CommonTopTitleNoTrans commonTopTitleNoTrans) {
        this.e = constraintLayout;
        this.a = floatFooterView;
        this.b = recyclerView;
        this.c = smartRefreshLayout;
        this.d = commonTopTitleNoTrans;
    }

    public static FragmentHotFeedBinding a(View view) {
        String str;
        FloatFooterView findViewById = view.findViewById(R.id.ll_feed_post);
        if (findViewById != null) {
            RecyclerView findViewById2 = view.findViewById(R.id.recycler_view);
            if (findViewById2 != null) {
                SmartRefreshLayout findViewById3 = view.findViewById(R.id.refresh_layout);
                if (findViewById3 != null) {
                    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) view.findViewById(R.id.title);
                    if (commonTopTitleNoTrans != null) {
                        return new FragmentHotFeedBinding((ConstraintLayout) view, findViewById, findViewById2, findViewById3, commonTopTitleNoTrans);
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

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.e;
    }
}
