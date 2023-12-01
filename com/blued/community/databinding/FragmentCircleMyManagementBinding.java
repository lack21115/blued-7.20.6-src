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

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f18834a;
    public final SmartRefreshLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final CommonTopTitleNoTrans f18835c;
    private final LinearLayout d;

    private FragmentCircleMyManagementBinding(LinearLayout linearLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, CommonTopTitleNoTrans commonTopTitleNoTrans) {
        this.d = linearLayout;
        this.f18834a = recyclerView;
        this.b = smartRefreshLayout;
        this.f18835c = commonTopTitleNoTrans;
    }

    public static FragmentCircleMyManagementBinding a(View view) {
        String str;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
        if (recyclerView != null) {
            SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refresh_layout);
            if (smartRefreshLayout != null) {
                CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) view.findViewById(R.id.title);
                if (commonTopTitleNoTrans != null) {
                    return new FragmentCircleMyManagementBinding((LinearLayout) view, recyclerView, smartRefreshLayout, commonTopTitleNoTrans);
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

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.d;
    }
}
