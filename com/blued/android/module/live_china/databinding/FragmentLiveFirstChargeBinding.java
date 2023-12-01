package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/FragmentLiveFirstChargeBinding.class */
public final class FragmentLiveFirstChargeBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f11922a;
    public final FrameLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final FrameLayout f11923c;
    public final FrameLayout d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final LinearLayout h;
    public final LinearLayout i;
    public final LinearLayout j;
    public final ShapeLinearLayout k;
    public final RelativeLayout l;
    public final RelativeLayout m;
    public final FrameLayout n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final TextView r;
    public final TextView s;
    public final ShapeTextView t;
    public final TextView u;
    public final TextView v;
    public final ImageView w;
    public final ImageView x;
    public final View y;
    private final FrameLayout z;

    private FragmentLiveFirstChargeBinding(FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, FrameLayout frameLayout5, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, ShapeLinearLayout shapeLinearLayout, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, FrameLayout frameLayout6, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, ShapeTextView shapeTextView, TextView textView6, TextView textView7, ImageView imageView4, ImageView imageView5, View view) {
        this.z = frameLayout;
        this.f11922a = frameLayout2;
        this.b = frameLayout3;
        this.f11923c = frameLayout4;
        this.d = frameLayout5;
        this.e = imageView;
        this.f = imageView2;
        this.g = imageView3;
        this.h = linearLayout;
        this.i = linearLayout2;
        this.j = linearLayout3;
        this.k = shapeLinearLayout;
        this.l = relativeLayout;
        this.m = relativeLayout2;
        this.n = frameLayout6;
        this.o = textView;
        this.p = textView2;
        this.q = textView3;
        this.r = textView4;
        this.s = textView5;
        this.t = shapeTextView;
        this.u = textView6;
        this.v = textView7;
        this.w = imageView4;
        this.x = imageView5;
        this.y = view;
    }

    public static FragmentLiveFirstChargeBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_live_first_charge, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static FragmentLiveFirstChargeBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_main);
        if (frameLayout != null) {
            FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.fl_pay_1);
            if (frameLayout2 != null) {
                FrameLayout frameLayout3 = (FrameLayout) view.findViewById(R.id.fl_pay_2);
                if (frameLayout3 != null) {
                    FrameLayout frameLayout4 = (FrameLayout) view.findViewById(R.id.fl_root);
                    if (frameLayout4 != null) {
                        ImageView imageView = (ImageView) view.findViewById(R.id.iv_close);
                        if (imageView != null) {
                            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_qa);
                            if (imageView2 != null) {
                                ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_recharge_succeed_close);
                                if (imageView3 != null) {
                                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_arrow);
                                    if (linearLayout != null) {
                                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_first_charge);
                                        if (linearLayout2 != null) {
                                            LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.ll_no_data);
                                            if (linearLayout3 != null) {
                                                ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.ll_qa);
                                                if (shapeLinearLayout != null) {
                                                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_gift_anim_root);
                                                    if (relativeLayout != null) {
                                                        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.rv_success);
                                                        if (relativeLayout2 != null) {
                                                            FrameLayout frameLayout5 = (FrameLayout) view.findViewById(R.id.rv_success_root);
                                                            if (frameLayout5 != null) {
                                                                TextView textView = (TextView) view.findViewById(R.id.tv_l_beans);
                                                                if (textView != null) {
                                                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_l_dou);
                                                                    if (textView2 != null) {
                                                                        TextView textView3 = (TextView) view.findViewById(R.id.tv_qa_ok);
                                                                        if (textView3 != null) {
                                                                            TextView textView4 = (TextView) view.findViewById(R.id.tv_r_beans);
                                                                            if (textView4 != null) {
                                                                                TextView textView5 = (TextView) view.findViewById(R.id.tv_r_dou);
                                                                                if (textView5 != null) {
                                                                                    ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_roger);
                                                                                    if (shapeTextView != null) {
                                                                                        TextView textView6 = (TextView) view.findViewById(R.id.tv_rule);
                                                                                        if (textView6 != null) {
                                                                                            TextView textView7 = (TextView) view.findViewById(R.id.tv_title);
                                                                                            if (textView7 != null) {
                                                                                                ImageView imageView4 = (ImageView) view.findViewById(R.id.view_gift_bag);
                                                                                                if (imageView4 != null) {
                                                                                                    ImageView imageView5 = (ImageView) view.findViewById(R.id.view_hand);
                                                                                                    if (imageView5 != null) {
                                                                                                        View findViewById = view.findViewById(R.id.view_top);
                                                                                                        if (findViewById != null) {
                                                                                                            return new FragmentLiveFirstChargeBinding((FrameLayout) view, frameLayout, frameLayout2, frameLayout3, frameLayout4, imageView, imageView2, imageView3, linearLayout, linearLayout2, linearLayout3, shapeLinearLayout, relativeLayout, relativeLayout2, frameLayout5, textView, textView2, textView3, textView4, textView5, shapeTextView, textView6, textView7, imageView4, imageView5, findViewById);
                                                                                                        }
                                                                                                        str = "viewTop";
                                                                                                    } else {
                                                                                                        str = "viewHand";
                                                                                                    }
                                                                                                } else {
                                                                                                    str = "viewGiftBag";
                                                                                                }
                                                                                            } else {
                                                                                                str = "tvTitle";
                                                                                            }
                                                                                        } else {
                                                                                            str = "tvRule";
                                                                                        }
                                                                                    } else {
                                                                                        str = "tvRoger";
                                                                                    }
                                                                                } else {
                                                                                    str = "tvRDou";
                                                                                }
                                                                            } else {
                                                                                str = "tvRBeans";
                                                                            }
                                                                        } else {
                                                                            str = "tvQaOk";
                                                                        }
                                                                    } else {
                                                                        str = "tvLDou";
                                                                    }
                                                                } else {
                                                                    str = "tvLBeans";
                                                                }
                                                            } else {
                                                                str = "rvSuccessRoot";
                                                            }
                                                        } else {
                                                            str = "rvSuccess";
                                                        }
                                                    } else {
                                                        str = "rlGiftAnimRoot";
                                                    }
                                                } else {
                                                    str = "llQa";
                                                }
                                            } else {
                                                str = "llNoData";
                                            }
                                        } else {
                                            str = "llFirstCharge";
                                        }
                                    } else {
                                        str = "llArrow";
                                    }
                                } else {
                                    str = "ivRechargeSucceedClose";
                                }
                            } else {
                                str = "ivQa";
                            }
                        } else {
                            str = "ivClose";
                        }
                    } else {
                        str = "flRoot";
                    }
                } else {
                    str = "flPay2";
                }
            } else {
                str = "flPay1";
            }
        } else {
            str = "flMain";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.z;
    }
}
