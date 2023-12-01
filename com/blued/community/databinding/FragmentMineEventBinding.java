package com.blued.community.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.CustomViewPager;
import com.blued.android.module.common.view.PageTabLayout;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/FragmentMineEventBinding.class */
public final class FragmentMineEventBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f18895a;
    public final ShapeTextView b;

    /* renamed from: c  reason: collision with root package name */
    public final PageTabLayout f18896c;
    public final CommonTopTitleNoTrans d;
    public final CustomViewPager e;
    private final LinearLayout f;

    private FragmentMineEventBinding(LinearLayout linearLayout, FrameLayout frameLayout, ShapeTextView shapeTextView, PageTabLayout pageTabLayout, CommonTopTitleNoTrans commonTopTitleNoTrans, CustomViewPager customViewPager) {
        this.f = linearLayout;
        this.f18895a = frameLayout;
        this.b = shapeTextView;
        this.f18896c = pageTabLayout;
        this.d = commonTopTitleNoTrans;
        this.e = customViewPager;
    }

    public static FragmentMineEventBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_tab_title);
        if (frameLayout != null) {
            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.shape_tab);
            if (shapeTextView != null) {
                PageTabLayout pageTabLayout = (PageTabLayout) view.findViewById(R.id.tab_layout);
                if (pageTabLayout != null) {
                    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) view.findViewById(R.id.title);
                    if (commonTopTitleNoTrans != null) {
                        CustomViewPager customViewPager = (CustomViewPager) view.findViewById(R.id.viewPager);
                        if (customViewPager != null) {
                            return new FragmentMineEventBinding((LinearLayout) view, frameLayout, shapeTextView, pageTabLayout, commonTopTitleNoTrans, customViewPager);
                        }
                        str = "viewPager";
                    } else {
                        str = "title";
                    }
                } else {
                    str = "tabLayout";
                }
            } else {
                str = "shapeTab";
            }
        } else {
            str = "flTabTitle";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.f;
    }
}
