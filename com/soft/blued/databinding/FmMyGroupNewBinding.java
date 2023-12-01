package com.soft.blued.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.widget.consecutivescroller.ConsecutiveScrollerLayout;
import com.blued.android.module.common.widget.consecutivescroller.ConsecutiveViewPager;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.R;
import com.soft.blued.customview.TabPageIndicatorWithDot;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/FmMyGroupNewBinding.class */
public final class FmMyGroupNewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f15067a;
    public final SmartRefreshLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f15068c;
    public final ConsecutiveScrollerLayout d;
    public final ShapeTextView e;
    public final TabPageIndicatorWithDot f;
    public final CommonTopTitleNoTrans g;
    public final TextView h;
    public final TextView i;
    public final ConsecutiveViewPager j;
    public final ViewSearchBinding k;
    private final LinearLayout l;

    private FmMyGroupNewBinding(LinearLayout linearLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, RelativeLayout relativeLayout, ConsecutiveScrollerLayout consecutiveScrollerLayout, ShapeTextView shapeTextView, TabPageIndicatorWithDot tabPageIndicatorWithDot, CommonTopTitleNoTrans commonTopTitleNoTrans, TextView textView, TextView textView2, ConsecutiveViewPager consecutiveViewPager, ViewSearchBinding viewSearchBinding) {
        this.l = linearLayout;
        this.f15067a = recyclerView;
        this.b = smartRefreshLayout;
        this.f15068c = relativeLayout;
        this.d = consecutiveScrollerLayout;
        this.e = shapeTextView;
        this.f = tabPageIndicatorWithDot;
        this.g = commonTopTitleNoTrans;
        this.h = textView;
        this.i = textView2;
        this.j = consecutiveViewPager;
        this.k = viewSearchBinding;
    }

    public static FmMyGroupNewBinding a(View view) {
        String str;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.group_list);
        if (recyclerView != null) {
            SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refresh_layout);
            if (smartRefreshLayout != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_group_title);
                if (relativeLayout != null) {
                    ConsecutiveScrollerLayout findViewById = view.findViewById(R.id.scrollerLayout);
                    if (findViewById != null) {
                        ShapeTextView findViewById2 = view.findViewById(R.id.shape_tab_layout);
                        if (findViewById2 != null) {
                            TabPageIndicatorWithDot tabPageIndicatorWithDot = (TabPageIndicatorWithDot) view.findViewById(R.id.tablayout);
                            if (tabPageIndicatorWithDot != null) {
                                CommonTopTitleNoTrans findViewById3 = view.findViewById(2131370694);
                                if (findViewById3 != null) {
                                    TextView textView = (TextView) view.findViewById(R.id.tv_all);
                                    if (textView != null) {
                                        TextView textView2 = (TextView) view.findViewById(R.id.tv_left);
                                        if (textView2 != null) {
                                            ConsecutiveViewPager findViewById4 = view.findViewById(2131373100);
                                            if (findViewById4 != null) {
                                                View findViewById5 = view.findViewById(R.id.view_search);
                                                if (findViewById5 != null) {
                                                    return new FmMyGroupNewBinding((LinearLayout) view, recyclerView, smartRefreshLayout, relativeLayout, findViewById, findViewById2, tabPageIndicatorWithDot, findViewById3, textView, textView2, findViewById4, ViewSearchBinding.a(findViewById5));
                                                }
                                                str = "viewSearch";
                                            } else {
                                                str = "viewPager";
                                            }
                                        } else {
                                            str = "tvLeft";
                                        }
                                    } else {
                                        str = "tvAll";
                                    }
                                } else {
                                    str = "title";
                                }
                            } else {
                                str = "tablayout";
                            }
                        } else {
                            str = "shapeTabLayout";
                        }
                    } else {
                        str = "scrollerLayout";
                    }
                } else {
                    str = "rlGroupTitle";
                }
            } else {
                str = "refreshLayout";
            }
        } else {
            str = "groupList";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.l;
    }
}
