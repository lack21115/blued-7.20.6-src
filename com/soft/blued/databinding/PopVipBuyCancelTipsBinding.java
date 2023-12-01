package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.AutoScrollViewPager;
import com.rbrooks.indefinitepagerindicator.IndefinitePagerIndicator;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/PopVipBuyCancelTipsBinding.class */
public final class PopVipBuyCancelTipsBinding implements ViewBinding {
    public final TextView A;
    public final TextView B;
    private final LinearLayout C;

    /* renamed from: a  reason: collision with root package name */
    public final ShapeLinearLayout f15874a;
    public final ShapeLinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final IndefinitePagerIndicator f15875c;
    public final ImageView d;
    public final ImageView e;
    public final LinearLayout f;
    public final LinearLayout g;
    public final LinearLayout h;
    public final LinearLayout i;
    public final LinearLayout j;
    public final ShapeConstraintLayout k;
    public final LinearLayout l;
    public final AutoScrollViewPager m;
    public final ShapeTextView n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final TextView r;
    public final TextView s;
    public final ShapeTextView t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final TextView x;
    public final TextView y;
    public final TextView z;

    private PopVipBuyCancelTipsBinding(LinearLayout linearLayout, ShapeLinearLayout shapeLinearLayout, ShapeLinearLayout shapeLinearLayout2, IndefinitePagerIndicator indefinitePagerIndicator, ImageView imageView, ImageView imageView2, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, ShapeConstraintLayout shapeConstraintLayout, LinearLayout linearLayout7, AutoScrollViewPager autoScrollViewPager, ShapeTextView shapeTextView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, ShapeTextView shapeTextView2, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13) {
        this.C = linearLayout;
        this.f15874a = shapeLinearLayout;
        this.b = shapeLinearLayout2;
        this.f15875c = indefinitePagerIndicator;
        this.d = imageView;
        this.e = imageView2;
        this.f = linearLayout2;
        this.g = linearLayout3;
        this.h = linearLayout4;
        this.i = linearLayout5;
        this.j = linearLayout6;
        this.k = shapeConstraintLayout;
        this.l = linearLayout7;
        this.m = autoScrollViewPager;
        this.n = shapeTextView;
        this.o = textView;
        this.p = textView2;
        this.q = textView3;
        this.r = textView4;
        this.s = textView5;
        this.t = shapeTextView2;
        this.u = textView6;
        this.v = textView7;
        this.w = textView8;
        this.x = textView9;
        this.y = textView10;
        this.z = textView11;
        this.A = textView12;
        this.B = textView13;
    }

    public static PopVipBuyCancelTipsBinding a(View view) {
        String str;
        ShapeLinearLayout findViewById = view.findViewById(2131362547);
        if (findViewById != null) {
            ShapeLinearLayout findViewById2 = view.findViewById(R.id.btn_confirm);
            if (findViewById2 != null) {
                IndefinitePagerIndicator indefinitePagerIndicator = (IndefinitePagerIndicator) view.findViewById(R.id.indicator);
                if (indefinitePagerIndicator != null) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_bottom_bg);
                    if (imageView != null) {
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_top_bg);
                        if (imageView2 != null) {
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_expired_item);
                            if (linearLayout != null) {
                                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_new_user_title);
                                if (linearLayout2 != null) {
                                    LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.ll_options_card);
                                    if (linearLayout3 != null) {
                                        LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.ll_present_price);
                                        if (linearLayout4 != null) {
                                            LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.ll_privilege_card);
                                            if (linearLayout5 != null) {
                                                ShapeConstraintLayout findViewById3 = view.findViewById(R.id.ll_regression_item);
                                                if (findViewById3 != null) {
                                                    LinearLayout linearLayout6 = (LinearLayout) view.findViewById(2131368288);
                                                    if (linearLayout6 != null) {
                                                        AutoScrollViewPager findViewById4 = view.findViewById(R.id.pager_privilege);
                                                        if (findViewById4 != null) {
                                                            ShapeTextView findViewById5 = view.findViewById(R.id.tv_annual_discount);
                                                            if (findViewById5 != null) {
                                                                TextView textView = (TextView) view.findViewById(R.id.tv_annual_money);
                                                                if (textView != null) {
                                                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_annual_tips);
                                                                    if (textView2 != null) {
                                                                        TextView textView3 = (TextView) view.findViewById(2131371164);
                                                                        if (textView3 != null) {
                                                                            TextView textView4 = (TextView) view.findViewById(R.id.tv_count_down);
                                                                            if (textView4 != null) {
                                                                                TextView textView5 = (TextView) view.findViewById(R.id.tv_first_buy_money);
                                                                                if (textView5 != null) {
                                                                                    ShapeTextView findViewById6 = view.findViewById(R.id.tv_month_discount);
                                                                                    if (findViewById6 != null) {
                                                                                        TextView textView6 = (TextView) view.findViewById(R.id.tv_month_money);
                                                                                        if (textView6 != null) {
                                                                                            TextView textView7 = (TextView) view.findViewById(R.id.tv_month_tips);
                                                                                            if (textView7 != null) {
                                                                                                TextView textView8 = (TextView) view.findViewById(R.id.tv_original_price);
                                                                                                if (textView8 != null) {
                                                                                                    TextView textView9 = (TextView) view.findViewById(R.id.tv_present_price);
                                                                                                    if (textView9 != null) {
                                                                                                        TextView textView10 = (TextView) view.findViewById(R.id.tv_privilege_tips);
                                                                                                        if (textView10 != null) {
                                                                                                            TextView textView11 = (TextView) view.findViewById(R.id.tv_subtitle);
                                                                                                            if (textView11 != null) {
                                                                                                                TextView textView12 = (TextView) view.findViewById(2131372754);
                                                                                                                if (textView12 != null) {
                                                                                                                    TextView textView13 = (TextView) view.findViewById(R.id.tv_top_title);
                                                                                                                    if (textView13 != null) {
                                                                                                                        return new PopVipBuyCancelTipsBinding((LinearLayout) view, findViewById, findViewById2, indefinitePagerIndicator, imageView, imageView2, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, findViewById3, linearLayout6, findViewById4, findViewById5, textView, textView2, textView3, textView4, textView5, findViewById6, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13);
                                                                                                                    }
                                                                                                                    str = "tvTopTitle";
                                                                                                                } else {
                                                                                                                    str = "tvTitle";
                                                                                                                }
                                                                                                            } else {
                                                                                                                str = "tvSubtitle";
                                                                                                            }
                                                                                                        } else {
                                                                                                            str = "tvPrivilegeTips";
                                                                                                        }
                                                                                                    } else {
                                                                                                        str = "tvPresentPrice";
                                                                                                    }
                                                                                                } else {
                                                                                                    str = "tvOriginalPrice";
                                                                                                }
                                                                                            } else {
                                                                                                str = "tvMonthTips";
                                                                                            }
                                                                                        } else {
                                                                                            str = "tvMonthMoney";
                                                                                        }
                                                                                    } else {
                                                                                        str = "tvMonthDiscount";
                                                                                    }
                                                                                } else {
                                                                                    str = "tvFirstBuyMoney";
                                                                                }
                                                                            } else {
                                                                                str = "tvCountDown";
                                                                            }
                                                                        } else {
                                                                            str = "tvConfirm";
                                                                        }
                                                                    } else {
                                                                        str = "tvAnnualTips";
                                                                    }
                                                                } else {
                                                                    str = "tvAnnualMoney";
                                                                }
                                                            } else {
                                                                str = "tvAnnualDiscount";
                                                            }
                                                        } else {
                                                            str = "pagerPrivilege";
                                                        }
                                                    } else {
                                                        str = "llTitle";
                                                    }
                                                } else {
                                                    str = "llRegressionItem";
                                                }
                                            } else {
                                                str = "llPrivilegeCard";
                                            }
                                        } else {
                                            str = "llPresentPrice";
                                        }
                                    } else {
                                        str = "llOptionsCard";
                                    }
                                } else {
                                    str = "llNewUserTitle";
                                }
                            } else {
                                str = "llExpiredItem";
                            }
                        } else {
                            str = "ivTopBg";
                        }
                    } else {
                        str = "ivBottomBg";
                    }
                } else {
                    str = "indicator";
                }
            } else {
                str = "btnConfirm";
            }
        } else {
            str = "btnCancel";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.C;
    }
}
