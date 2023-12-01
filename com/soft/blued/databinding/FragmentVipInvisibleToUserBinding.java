package com.soft.blued.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/FragmentVipInvisibleToUserBinding.class */
public final class FragmentVipInvisibleToUserBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final NoDataAndLoadFailView f29023a;
    public final RecyclerView b;

    /* renamed from: c  reason: collision with root package name */
    public final SmartRefreshLayout f29024c;
    public final CommonTopTitleNoTrans d;
    public final TextView e;
    public final TextView f;
    private final LinearLayout g;

    private FragmentVipInvisibleToUserBinding(LinearLayout linearLayout, NoDataAndLoadFailView noDataAndLoadFailView, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, CommonTopTitleNoTrans commonTopTitleNoTrans, TextView textView, TextView textView2) {
        this.g = linearLayout;
        this.f29023a = noDataAndLoadFailView;
        this.b = recyclerView;
        this.f29024c = smartRefreshLayout;
        this.d = commonTopTitleNoTrans;
        this.e = textView;
        this.f = textView2;
    }

    public static FragmentVipInvisibleToUserBinding a(View view) {
        String str;
        NoDataAndLoadFailView noDataAndLoadFailView = (NoDataAndLoadFailView) view.findViewById(2131368721);
        if (noDataAndLoadFailView != null) {
            RecyclerView recyclerView = (RecyclerView) view.findViewById(2131369105);
            if (recyclerView != null) {
                SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(2131369119);
                if (smartRefreshLayout != null) {
                    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) view.findViewById(2131370749);
                    if (commonTopTitleNoTrans != null) {
                        TextView textView = (TextView) view.findViewById(2131372745);
                        if (textView != null) {
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_user_nums);
                            if (textView2 != null) {
                                return new FragmentVipInvisibleToUserBinding((LinearLayout) view, noDataAndLoadFailView, recyclerView, smartRefreshLayout, commonTopTitleNoTrans, textView, textView2);
                            }
                            str = "tvUserNums";
                        } else {
                            str = "tvTips";
                        }
                    } else {
                        str = "topTitle";
                    }
                } else {
                    str = "refreshLayout";
                }
            } else {
                str = "recyclerView";
            }
        } else {
            str = "noDataView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.g;
    }
}
