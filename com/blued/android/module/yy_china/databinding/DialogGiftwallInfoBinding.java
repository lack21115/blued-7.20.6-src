package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.HollowView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogGiftwallInfoBinding.class */
public final class DialogGiftwallInfoBinding implements ViewBinding {
    public final TextView A;
    public final TextView B;
    private final ConstraintLayout C;

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f16348a;
    public final ConstraintLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeConstraintLayout f16349c;
    public final HollowView d;
    public final HollowView e;
    public final HollowView f;
    public final ImageView g;
    public final ImageView h;
    public final ImageView i;
    public final ImageView j;
    public final ImageView k;
    public final ImageView l;
    public final LinearLayout m;
    public final ProgressBar n;
    public final ConstraintLayout o;
    public final ShapeConstraintLayout p;
    public final TextView q;
    public final ShapeTextView r;
    public final TextView s;
    public final TextView t;
    public final ShapeTextView u;
    public final TextView v;
    public final TextView w;
    public final TextView x;
    public final TextView y;
    public final TextView z;

    private DialogGiftwallInfoBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ShapeConstraintLayout shapeConstraintLayout, HollowView hollowView, HollowView hollowView2, HollowView hollowView3, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, LinearLayout linearLayout, ProgressBar progressBar, ConstraintLayout constraintLayout4, ShapeConstraintLayout shapeConstraintLayout2, TextView textView, ShapeTextView shapeTextView, TextView textView2, TextView textView3, ShapeTextView shapeTextView2, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10) {
        this.C = constraintLayout;
        this.f16348a = constraintLayout2;
        this.b = constraintLayout3;
        this.f16349c = shapeConstraintLayout;
        this.d = hollowView;
        this.e = hollowView2;
        this.f = hollowView3;
        this.g = imageView;
        this.h = imageView2;
        this.i = imageView3;
        this.j = imageView4;
        this.k = imageView5;
        this.l = imageView6;
        this.m = linearLayout;
        this.n = progressBar;
        this.o = constraintLayout4;
        this.p = shapeConstraintLayout2;
        this.q = textView;
        this.r = shapeTextView;
        this.s = textView2;
        this.t = textView3;
        this.u = shapeTextView2;
        this.v = textView4;
        this.w = textView5;
        this.x = textView6;
        this.y = textView7;
        this.z = textView8;
        this.A = textView9;
        this.B = textView10;
    }

    public static DialogGiftwallInfoBinding a(View view) {
        String str;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cons_gift_num);
        if (constraintLayout != null) {
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cons_list);
            if (constraintLayout2 != null) {
                ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.cons_user_list);
                if (shapeConstraintLayout != null) {
                    HollowView hollowView = (HollowView) view.findViewById(R.id.holl_user_1);
                    if (hollowView != null) {
                        HollowView hollowView2 = (HollowView) view.findViewById(R.id.holl_user_2);
                        if (hollowView2 != null) {
                            HollowView hollowView3 = (HollowView) view.findViewById(R.id.holl_user_3);
                            if (hollowView3 != null) {
                                ImageView imageView = (ImageView) view.findViewById(R.id.iv);
                                if (imageView != null) {
                                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_close);
                                    if (imageView2 != null) {
                                        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_list_user_null);
                                        if (imageView3 != null) {
                                            ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_us_1);
                                            if (imageView4 != null) {
                                                ImageView imageView5 = (ImageView) view.findViewById(R.id.iv_us_2);
                                                if (imageView5 != null) {
                                                    ImageView imageView6 = (ImageView) view.findViewById(R.id.iv_us_3);
                                                    if (imageView6 != null) {
                                                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll);
                                                        if (linearLayout != null) {
                                                            ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.pro);
                                                            if (progressBar != null) {
                                                                ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.sha_);
                                                                if (constraintLayout3 != null) {
                                                                    ShapeConstraintLayout shapeConstraintLayout2 = (ShapeConstraintLayout) view.findViewById(R.id.shap_con);
                                                                    if (shapeConstraintLayout2 != null) {
                                                                        TextView textView = (TextView) view.findViewById(R.id.tv_botto);
                                                                        if (textView != null) {
                                                                            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_click);
                                                                            if (shapeTextView != null) {
                                                                                TextView textView2 = (TextView) view.findViewById(R.id.tv_gift_num_info);
                                                                                if (textView2 != null) {
                                                                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_gift_num_info_myselef);
                                                                                    if (textView3 != null) {
                                                                                        ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_gift_num_no);
                                                                                        if (shapeTextView2 != null) {
                                                                                            TextView textView4 = (TextView) view.findViewById(R.id.tv_left_info);
                                                                                            if (textView4 != null) {
                                                                                                TextView textView5 = (TextView) view.findViewById(R.id.tv_name);
                                                                                                if (textView5 != null) {
                                                                                                    TextView textView6 = (TextView) view.findViewById(R.id.tv_null);
                                                                                                    if (textView6 != null) {
                                                                                                        TextView textView7 = (TextView) view.findViewById(R.id.tv_right_info);
                                                                                                        if (textView7 != null) {
                                                                                                            TextView textView8 = (TextView) view.findViewById(R.id.tv_user_name_1);
                                                                                                            if (textView8 != null) {
                                                                                                                TextView textView9 = (TextView) view.findViewById(R.id.tv_user_name_2);
                                                                                                                if (textView9 != null) {
                                                                                                                    TextView textView10 = (TextView) view.findViewById(R.id.tv_user_name_3);
                                                                                                                    if (textView10 != null) {
                                                                                                                        return new DialogGiftwallInfoBinding((ConstraintLayout) view, constraintLayout, constraintLayout2, shapeConstraintLayout, hollowView, hollowView2, hollowView3, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, linearLayout, progressBar, constraintLayout3, shapeConstraintLayout2, textView, shapeTextView, textView2, textView3, shapeTextView2, textView4, textView5, textView6, textView7, textView8, textView9, textView10);
                                                                                                                    }
                                                                                                                    str = "tvUserName3";
                                                                                                                } else {
                                                                                                                    str = "tvUserName2";
                                                                                                                }
                                                                                                            } else {
                                                                                                                str = "tvUserName1";
                                                                                                            }
                                                                                                        } else {
                                                                                                            str = "tvRightInfo";
                                                                                                        }
                                                                                                    } else {
                                                                                                        str = "tvNull";
                                                                                                    }
                                                                                                } else {
                                                                                                    str = "tvName";
                                                                                                }
                                                                                            } else {
                                                                                                str = "tvLeftInfo";
                                                                                            }
                                                                                        } else {
                                                                                            str = "tvGiftNumNo";
                                                                                        }
                                                                                    } else {
                                                                                        str = "tvGiftNumInfoMyselef";
                                                                                    }
                                                                                } else {
                                                                                    str = "tvGiftNumInfo";
                                                                                }
                                                                            } else {
                                                                                str = "tvClick";
                                                                            }
                                                                        } else {
                                                                            str = "tvBotto";
                                                                        }
                                                                    } else {
                                                                        str = "shapCon";
                                                                    }
                                                                } else {
                                                                    str = "sha";
                                                                }
                                                            } else {
                                                                str = "pro";
                                                            }
                                                        } else {
                                                            str = "ll";
                                                        }
                                                    } else {
                                                        str = "ivUs3";
                                                    }
                                                } else {
                                                    str = "ivUs2";
                                                }
                                            } else {
                                                str = "ivUs1";
                                            }
                                        } else {
                                            str = "ivListUserNull";
                                        }
                                    } else {
                                        str = "ivClose";
                                    }
                                } else {
                                    str = "iv";
                                }
                            } else {
                                str = "hollUser3";
                            }
                        } else {
                            str = "hollUser2";
                        }
                    } else {
                        str = "hollUser1";
                    }
                } else {
                    str = "consUserList";
                }
            } else {
                str = "consList";
            }
        } else {
            str = "consGiftNum";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.C;
    }
}
