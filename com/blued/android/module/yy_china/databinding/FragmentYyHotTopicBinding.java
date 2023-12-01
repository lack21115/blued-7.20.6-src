package com.blued.android.module.yy_china.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYHotTopicTabView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentYyHotTopicBinding.class */
public final class FragmentYyHotTopicBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f16511a;
    public final NoDataAndLoadFailView b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewPager f16512c;
    public final YYHotTopicTabView d;
    public final CommonTopTitleNoTrans e;
    private final ConstraintLayout f;

    private FragmentYyHotTopicBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, NoDataAndLoadFailView noDataAndLoadFailView, ViewPager viewPager, YYHotTopicTabView yYHotTopicTabView, CommonTopTitleNoTrans commonTopTitleNoTrans) {
        this.f = constraintLayout;
        this.f16511a = constraintLayout2;
        this.b = noDataAndLoadFailView;
        this.f16512c = viewPager;
        this.d = yYHotTopicTabView;
        this.e = commonTopTitleNoTrans;
    }

    public static FragmentYyHotTopicBinding a(View view) {
        String str;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.con);
        if (constraintLayout != null) {
            NoDataAndLoadFailView noDataAndLoadFailView = (NoDataAndLoadFailView) view.findViewById(R.id.noDataView);
            if (noDataAndLoadFailView != null) {
                ViewPager viewPager = (ViewPager) view.findViewById(R.id.room_view_pager);
                if (viewPager != null) {
                    YYHotTopicTabView yYHotTopicTabView = (YYHotTopicTabView) view.findViewById(R.id.tablayout);
                    if (yYHotTopicTabView != null) {
                        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) view.findViewById(R.id.top_title);
                        if (commonTopTitleNoTrans != null) {
                            return new FragmentYyHotTopicBinding((ConstraintLayout) view, constraintLayout, noDataAndLoadFailView, viewPager, yYHotTopicTabView, commonTopTitleNoTrans);
                        }
                        str = "topTitle";
                    } else {
                        str = "tablayout";
                    }
                } else {
                    str = "roomViewPager";
                }
            } else {
                str = "noDataView";
            }
        } else {
            str = "con";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f;
    }
}
