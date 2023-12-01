package com.soft.blued.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/FragmentVipCenterTabPageNewBinding.class */
public final class FragmentVipCenterTabPageNewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f15329a;
    public final FrameLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f15330c;
    public final ImageView d;
    public final ImageView e;
    public final LinearLayout f;
    public final CommonTopTitleNoTrans g;
    public final CommonTopTitleNoTrans h;
    public final RecyclerView i;
    public final NestedScrollView j;
    public final RecyclerView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public final LinearLayout p;
    public final LinearLayout q;
    public final LinearLayout r;
    public final LinearLayout s;
    public final LinearLayout t;
    public final LinearLayout u;
    private final ConstraintLayout v;

    private FragmentVipCenterTabPageNewBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, FrameLayout frameLayout, LinearLayout linearLayout2, ImageView imageView, ImageView imageView2, LinearLayout linearLayout3, CommonTopTitleNoTrans commonTopTitleNoTrans, CommonTopTitleNoTrans commonTopTitleNoTrans2, RecyclerView recyclerView, NestedScrollView nestedScrollView, RecyclerView recyclerView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, LinearLayout linearLayout8, LinearLayout linearLayout9) {
        this.v = constraintLayout;
        this.f15329a = linearLayout;
        this.b = frameLayout;
        this.f15330c = linearLayout2;
        this.d = imageView;
        this.e = imageView2;
        this.f = linearLayout3;
        this.g = commonTopTitleNoTrans;
        this.h = commonTopTitleNoTrans2;
        this.i = recyclerView;
        this.j = nestedScrollView;
        this.k = recyclerView2;
        this.l = textView;
        this.m = textView2;
        this.n = textView3;
        this.o = textView4;
        this.p = linearLayout4;
        this.q = linearLayout5;
        this.r = linearLayout6;
        this.s = linearLayout7;
        this.t = linearLayout8;
        this.u = linearLayout9;
    }

    public static FragmentVipCenterTabPageNewBinding a(View view) {
        String str;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.btn_privilege_detail);
        if (linearLayout != null) {
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.buy_btn);
            if (frameLayout != null) {
                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(2131364232);
                if (linearLayout2 != null) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_bg);
                    if (imageView != null) {
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_buy_btn);
                        if (imageView2 != null) {
                            LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.ll_renewal_statement);
                            if (linearLayout3 != null) {
                                CommonTopTitleNoTrans findViewById = view.findViewById(R.id.page_title);
                                if (findViewById != null) {
                                    CommonTopTitleNoTrans findViewById2 = view.findViewById(R.id.page_title_hover);
                                    if (findViewById2 != null) {
                                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.privilege_recycler_view);
                                        if (recyclerView != null) {
                                            NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R.id.scroll_view);
                                            if (nestedScrollView != null) {
                                                RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.tab_recycler_view);
                                                if (recyclerView2 != null) {
                                                    TextView textView = (TextView) view.findViewById(R.id.tv_buy_btn);
                                                    if (textView != null) {
                                                        TextView textView2 = (TextView) view.findViewById(R.id.tv_can_use_privilege);
                                                        if (textView2 != null) {
                                                            TextView textView3 = (TextView) view.findViewById(R.id.tv_explain);
                                                            if (textView3 != null) {
                                                                TextView textView4 = (TextView) view.findViewById(2131372754);
                                                                if (textView4 != null) {
                                                                    LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.vip_help_center);
                                                                    if (linearLayout4 != null) {
                                                                        LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.vip_order_record);
                                                                        if (linearLayout5 != null) {
                                                                            LinearLayout linearLayout6 = (LinearLayout) view.findViewById(R.id.vip_privacy_clause);
                                                                            if (linearLayout6 != null) {
                                                                                LinearLayout linearLayout7 = (LinearLayout) view.findViewById(R.id.vip_protocol_exp_lvl);
                                                                                if (linearLayout7 != null) {
                                                                                    LinearLayout linearLayout8 = (LinearLayout) view.findViewById(R.id.vip_protocol_terms);
                                                                                    if (linearLayout8 != null) {
                                                                                        LinearLayout linearLayout9 = (LinearLayout) view.findViewById(R.id.vip_service_terms);
                                                                                        if (linearLayout9 != null) {
                                                                                            return new FragmentVipCenterTabPageNewBinding((ConstraintLayout) view, linearLayout, frameLayout, linearLayout2, imageView, imageView2, linearLayout3, findViewById, findViewById2, recyclerView, nestedScrollView, recyclerView2, textView, textView2, textView3, textView4, linearLayout4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, linearLayout9);
                                                                                        }
                                                                                        str = "vipServiceTerms";
                                                                                    } else {
                                                                                        str = "vipProtocolTerms";
                                                                                    }
                                                                                } else {
                                                                                    str = "vipProtocolExpLvl";
                                                                                }
                                                                            } else {
                                                                                str = "vipPrivacyClause";
                                                                            }
                                                                        } else {
                                                                            str = "vipOrderRecord";
                                                                        }
                                                                    } else {
                                                                        str = "vipHelpCenter";
                                                                    }
                                                                } else {
                                                                    str = "tvTitle";
                                                                }
                                                            } else {
                                                                str = "tvExplain";
                                                            }
                                                        } else {
                                                            str = "tvCanUsePrivilege";
                                                        }
                                                    } else {
                                                        str = "tvBuyBtn";
                                                    }
                                                } else {
                                                    str = "tabRecyclerView";
                                                }
                                            } else {
                                                str = "scrollView";
                                            }
                                        } else {
                                            str = "privilegeRecyclerView";
                                        }
                                    } else {
                                        str = "pageTitleHover";
                                    }
                                } else {
                                    str = "pageTitle";
                                }
                            } else {
                                str = "llRenewalStatement";
                            }
                        } else {
                            str = "ivBuyBtn";
                        }
                    } else {
                        str = "ivBg";
                    }
                } else {
                    str = "headerView";
                }
            } else {
                str = "buyBtn";
            }
        } else {
            str = "btnPrivilegeDetail";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.v;
    }
}
