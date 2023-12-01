package com.blued.community.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.community.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/FragmentCircleMyManagementBinding.class */
public final class FragmentCircleMyManagementBinding implements ViewBinding {
    public final RecyclerView a;
    public final SmartRefreshLayout b;
    public final CommonTopTitleNoTrans c;
    private final LinearLayout d;

    private FragmentCircleMyManagementBinding(LinearLayout linearLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, CommonTopTitleNoTrans commonTopTitleNoTrans) {
        this.d = linearLayout;
        this.a = recyclerView;
        this.b = smartRefreshLayout;
        this.c = commonTopTitleNoTrans;
    }

    public static FragmentCircleMyManagementBinding a(View view) {
        String str;
        RecyclerView findViewById = view.findViewById(R.id.recycle_view);
        if (findViewById != null) {
            SmartRefreshLayout findViewById2 = view.findViewById(R.id.refresh_layout);
            if (findViewById2 != null) {
                CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) view.findViewById(R.id.title);
                if (commonTopTitleNoTrans != null) {
                    return new FragmentCircleMyManagementBinding((LinearLayout) view, findViewById, findViewById2, commonTopTitleNoTrans);
                }
                str = "title";
            } else {
                str = "refreshLayout";
            }
        } else {
            str = "recycleView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.d;
    }
}
