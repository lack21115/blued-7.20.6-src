package com.soft.blued.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/FmVirtualImageBinding.class */
public final class FmVirtualImageBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RelativeLayout f28772a;
    public final RelativeLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeRelativeLayout f28773c;
    public final ConstraintLayout d;
    public final FrameLayout e;
    public final FrameLayout f;
    public final FrameLayout g;
    public final ConstraintLayout h;
    public final ImageView i;
    public final ImageView j;
    public final ImageView k;
    public final NoDataAndLoadFailView l;
    public final RelativeLayout m;
    public final RelativeLayout n;
    public final TextView o;
    public final View p;
    public final View q;
    public final View r;
    public final View s;
    public final View t;
    public final View u;
    private final ConstraintLayout v;

    private FmVirtualImageBinding(ConstraintLayout constraintLayout, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ShapeRelativeLayout shapeRelativeLayout, ConstraintLayout constraintLayout2, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, ConstraintLayout constraintLayout3, ImageView imageView, ImageView imageView2, ImageView imageView3, NoDataAndLoadFailView noDataAndLoadFailView, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, TextView textView, View view, View view2, View view3, View view4, View view5, View view6) {
        this.v = constraintLayout;
        this.f28772a = relativeLayout;
        this.b = relativeLayout2;
        this.f28773c = shapeRelativeLayout;
        this.d = constraintLayout2;
        this.e = frameLayout;
        this.f = frameLayout2;
        this.g = frameLayout3;
        this.h = constraintLayout3;
        this.i = imageView;
        this.j = imageView2;
        this.k = imageView3;
        this.l = noDataAndLoadFailView;
        this.m = relativeLayout3;
        this.n = relativeLayout4;
        this.o = textView;
        this.p = view;
        this.q = view2;
        this.r = view3;
        this.s = view4;
        this.t = view5;
        this.u = view6;
    }

    public static FmVirtualImageBinding a(View view) {
        String str;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.btn_modify);
        if (relativeLayout != null) {
            RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.btn_modify_self);
            if (relativeLayout2 != null) {
                ShapeRelativeLayout shapeRelativeLayout = (ShapeRelativeLayout) view.findViewById(R.id.btn_share);
                if (shapeRelativeLayout != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_guide);
                    if (constraintLayout != null) {
                        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_back);
                        if (frameLayout != null) {
                            FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.fl_select_goods_layout);
                            if (frameLayout2 != null) {
                                FrameLayout frameLayout3 = (FrameLayout) view.findViewById(R.id.fm_image);
                                if (frameLayout3 != null) {
                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.fm_main);
                                    if (constraintLayout2 != null) {
                                        ImageView imageView = (ImageView) view.findViewById(2131365114);
                                        if (imageView != null) {
                                            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_double_tap_anim);
                                            if (imageView2 != null) {
                                                ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_virtual_image_bg);
                                                if (imageView3 != null) {
                                                    NoDataAndLoadFailView noDataAndLoadFailView = (NoDataAndLoadFailView) view.findViewById(2131368721);
                                                    if (noDataAndLoadFailView != null) {
                                                        RelativeLayout relativeLayout3 = (RelativeLayout) view.findViewById(R.id.rl_guide);
                                                        if (relativeLayout3 != null) {
                                                            RelativeLayout relativeLayout4 = (RelativeLayout) view.findViewById(R.id.rl_modify);
                                                            if (relativeLayout4 != null) {
                                                                TextView textView = (TextView) view.findViewById(R.id.stv_new_arrivals);
                                                                if (textView != null) {
                                                                    View findViewById = view.findViewById(R.id.v_double_tap_guide);
                                                                    if (findViewById != null) {
                                                                        View findViewById2 = view.findViewById(R.id.v_header);
                                                                        if (findViewById2 != null) {
                                                                            View findViewById3 = view.findViewById(R.id.v_left_arm);
                                                                            if (findViewById3 != null) {
                                                                                View findViewById4 = view.findViewById(R.id.v_lower_body);
                                                                                if (findViewById4 != null) {
                                                                                    View findViewById5 = view.findViewById(R.id.v_right_arm);
                                                                                    if (findViewById5 != null) {
                                                                                        View findViewById6 = view.findViewById(R.id.v_upper_body);
                                                                                        if (findViewById6 != null) {
                                                                                            return new FmVirtualImageBinding((ConstraintLayout) view, relativeLayout, relativeLayout2, shapeRelativeLayout, constraintLayout, frameLayout, frameLayout2, frameLayout3, constraintLayout2, imageView, imageView2, imageView3, noDataAndLoadFailView, relativeLayout3, relativeLayout4, textView, findViewById, findViewById2, findViewById3, findViewById4, findViewById5, findViewById6);
                                                                                        }
                                                                                        str = "vUpperBody";
                                                                                    } else {
                                                                                        str = "vRightArm";
                                                                                    }
                                                                                } else {
                                                                                    str = "vLowerBody";
                                                                                }
                                                                            } else {
                                                                                str = "vLeftArm";
                                                                            }
                                                                        } else {
                                                                            str = "vHeader";
                                                                        }
                                                                    } else {
                                                                        str = "vDoubleTapGuide";
                                                                    }
                                                                } else {
                                                                    str = "stvNewArrivals";
                                                                }
                                                            } else {
                                                                str = "rlModify";
                                                            }
                                                        } else {
                                                            str = "rlGuide";
                                                        }
                                                    } else {
                                                        str = "noDataView";
                                                    }
                                                } else {
                                                    str = "ivVirtualImageBg";
                                                }
                                            } else {
                                                str = "ivDoubleTapAnim";
                                            }
                                        } else {
                                            str = "ivBack";
                                        }
                                    } else {
                                        str = "fmMain";
                                    }
                                } else {
                                    str = "fmImage";
                                }
                            } else {
                                str = "flSelectGoodsLayout";
                            }
                        } else {
                            str = "flBack";
                        }
                    } else {
                        str = "clGuide";
                    }
                } else {
                    str = "btnShare";
                }
            } else {
                str = "btnModifySelf";
            }
        } else {
            str = "btnModify";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.v;
    }
}
