package com.blued.community.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.PageTabLayout;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/FragmentEventMemberBinding.class */
public final class FragmentEventMemberBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ViewPager f18856a;
    public final FrameLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTextView f18857c;
    public final PageTabLayout d;
    public final CommonTopTitleNoTrans e;
    private final LinearLayout f;

    private FragmentEventMemberBinding(LinearLayout linearLayout, ViewPager viewPager, FrameLayout frameLayout, ShapeTextView shapeTextView, PageTabLayout pageTabLayout, CommonTopTitleNoTrans commonTopTitleNoTrans) {
        this.f = linearLayout;
        this.f18856a = viewPager;
        this.b = frameLayout;
        this.f18857c = shapeTextView;
        this.d = pageTabLayout;
        this.e = commonTopTitleNoTrans;
    }

    public static FragmentEventMemberBinding a(View view) {
        String str;
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.base_view_pager_id);
        if (viewPager != null) {
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_tab_title);
            if (frameLayout != null) {
                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.shape_tab);
                if (shapeTextView != null) {
                    PageTabLayout pageTabLayout = (PageTabLayout) view.findViewById(R.id.tab_layout);
                    if (pageTabLayout != null) {
                        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) view.findViewById(R.id.top_title);
                        if (commonTopTitleNoTrans != null) {
                            return new FragmentEventMemberBinding((LinearLayout) view, viewPager, frameLayout, shapeTextView, pageTabLayout, commonTopTitleNoTrans);
                        }
                        str = "topTitle";
                    } else {
                        str = "tabLayout";
                    }
                } else {
                    str = "shapeTab";
                }
            } else {
                str = "flTabTitle";
            }
        } else {
            str = "baseViewPagerId";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.f;
    }
}
