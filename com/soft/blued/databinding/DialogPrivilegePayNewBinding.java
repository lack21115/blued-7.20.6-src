package com.soft.blued.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.R;
import com.soft.blued.ui.user.views.PrivilegeDialogBuyNewOptionView;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/DialogPrivilegePayNewBinding.class */
public final class DialogPrivilegePayNewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f15026a;
    public final LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f15027c;
    public final TextView d;
    public final ConstraintLayout e;
    public final ImageView f;
    public final ImageView g;
    public final LinearLayout h;
    public final ShapeConstraintLayout i;
    public final LinearLayout j;
    public final LinearLayout k;
    public final ShapeRelativeLayout l;
    public final FrameLayout m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final ShapeTextView r;
    public final TextView s;
    public final ShapeTextView t;
    public final TextView u;
    public final PrivilegeDialogBuyNewOptionView v;
    public final PrivilegeDialogBuyNewOptionView w;
    public final PrivilegeDialogBuyNewOptionView x;
    private final FrameLayout y;

    private DialogPrivilegePayNewBinding(FrameLayout frameLayout, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2, ConstraintLayout constraintLayout, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout2, ShapeConstraintLayout shapeConstraintLayout, LinearLayout linearLayout3, LinearLayout linearLayout4, ShapeRelativeLayout shapeRelativeLayout, FrameLayout frameLayout2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, ShapeTextView shapeTextView, TextView textView7, ShapeTextView shapeTextView2, TextView textView8, PrivilegeDialogBuyNewOptionView privilegeDialogBuyNewOptionView, PrivilegeDialogBuyNewOptionView privilegeDialogBuyNewOptionView2, PrivilegeDialogBuyNewOptionView privilegeDialogBuyNewOptionView3) {
        this.y = frameLayout;
        this.f15026a = imageView;
        this.b = linearLayout;
        this.f15027c = textView;
        this.d = textView2;
        this.e = constraintLayout;
        this.f = imageView2;
        this.g = imageView3;
        this.h = linearLayout2;
        this.i = shapeConstraintLayout;
        this.j = linearLayout3;
        this.k = linearLayout4;
        this.l = shapeRelativeLayout;
        this.m = frameLayout2;
        this.n = textView3;
        this.o = textView4;
        this.p = textView5;
        this.q = textView6;
        this.r = shapeTextView;
        this.s = textView7;
        this.t = shapeTextView2;
        this.u = textView8;
        this.v = privilegeDialogBuyNewOptionView;
        this.w = privilegeDialogBuyNewOptionView2;
        this.x = privilegeDialogBuyNewOptionView3;
    }

    public static DialogPrivilegePayNewBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.agreement_btn);
        if (imageView != null) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.agreement_layout);
            if (linearLayout != null) {
                TextView textView = (TextView) view.findViewById(R.id.agreement_text);
                if (textView != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.cancel_buy_btn);
                    if (textView2 != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.fl_option);
                        if (constraintLayout != null) {
                            ImageView imageView2 = (ImageView) view.findViewById(R.id.img_close);
                            if (imageView2 != null) {
                                ImageView imageView3 = (ImageView) view.findViewById(2131365504);
                                if (imageView3 != null) {
                                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(2131367999);
                                    if (linearLayout2 != null) {
                                        ShapeConstraintLayout findViewById = view.findViewById(R.id.ll_mouth_card_item);
                                        if (findViewById != null) {
                                            LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.ll_mouth_card_times_count);
                                            if (linearLayout3 != null) {
                                                LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.ll_option_area);
                                                if (linearLayout4 != null) {
                                                    ShapeRelativeLayout findViewById2 = view.findViewById(R.id.rl_pay_type);
                                                    if (findViewById2 != null) {
                                                        FrameLayout frameLayout = (FrameLayout) view.findViewById(2131369468);
                                                        if (frameLayout != null) {
                                                            TextView textView3 = (TextView) view.findViewById(R.id.tv_buy_privilege);
                                                            if (textView3 != null) {
                                                                TextView textView4 = (TextView) view.findViewById(R.id.tv_item_choosed_desc);
                                                                if (textView4 != null) {
                                                                    TextView textView5 = (TextView) view.findViewById(R.id.tv_mouth_card_count);
                                                                    if (textView5 != null) {
                                                                        TextView textView6 = (TextView) view.findViewById(R.id.tv_mouth_card_desc);
                                                                        if (textView6 != null) {
                                                                            ShapeTextView findViewById3 = view.findViewById(R.id.tv_mouth_card_favourate);
                                                                            if (findViewById3 != null) {
                                                                                TextView textView7 = (TextView) view.findViewById(R.id.tv_mouth_card_per_amount);
                                                                                if (textView7 != null) {
                                                                                    ShapeTextView findViewById4 = view.findViewById(R.id.tv_mouth_card_tag);
                                                                                    if (findViewById4 != null) {
                                                                                        TextView textView8 = (TextView) view.findViewById(R.id.tv_pay_type);
                                                                                        if (textView8 != null) {
                                                                                            PrivilegeDialogBuyNewOptionView privilegeDialogBuyNewOptionView = (PrivilegeDialogBuyNewOptionView) view.findViewById(R.id.view_option_1);
                                                                                            if (privilegeDialogBuyNewOptionView != null) {
                                                                                                PrivilegeDialogBuyNewOptionView privilegeDialogBuyNewOptionView2 = (PrivilegeDialogBuyNewOptionView) view.findViewById(R.id.view_option_2);
                                                                                                if (privilegeDialogBuyNewOptionView2 != null) {
                                                                                                    PrivilegeDialogBuyNewOptionView privilegeDialogBuyNewOptionView3 = (PrivilegeDialogBuyNewOptionView) view.findViewById(R.id.view_option_3);
                                                                                                    if (privilegeDialogBuyNewOptionView3 != null) {
                                                                                                        return new DialogPrivilegePayNewBinding((FrameLayout) view, imageView, linearLayout, textView, textView2, constraintLayout, imageView2, imageView3, linearLayout2, findViewById, linearLayout3, linearLayout4, findViewById2, frameLayout, textView3, textView4, textView5, textView6, findViewById3, textView7, findViewById4, textView8, privilegeDialogBuyNewOptionView, privilegeDialogBuyNewOptionView2, privilegeDialogBuyNewOptionView3);
                                                                                                    }
                                                                                                    str = "viewOption3";
                                                                                                } else {
                                                                                                    str = "viewOption2";
                                                                                                }
                                                                                            } else {
                                                                                                str = "viewOption1";
                                                                                            }
                                                                                        } else {
                                                                                            str = "tvPayType";
                                                                                        }
                                                                                    } else {
                                                                                        str = "tvMouthCardTag";
                                                                                    }
                                                                                } else {
                                                                                    str = "tvMouthCardPerAmount";
                                                                                }
                                                                            } else {
                                                                                str = "tvMouthCardFavourate";
                                                                            }
                                                                        } else {
                                                                            str = "tvMouthCardDesc";
                                                                        }
                                                                    } else {
                                                                        str = "tvMouthCardCount";
                                                                    }
                                                                } else {
                                                                    str = "tvItemChoosedDesc";
                                                                }
                                                            } else {
                                                                str = "tvBuyPrivilege";
                                                            }
                                                        } else {
                                                            str = "rootLayout";
                                                        }
                                                    } else {
                                                        str = "rlPayType";
                                                    }
                                                } else {
                                                    str = "llOptionArea";
                                                }
                                            } else {
                                                str = "llMouthCardTimesCount";
                                            }
                                        } else {
                                            str = "llMouthCardItem";
                                        }
                                    } else {
                                        str = "llMain";
                                    }
                                } else {
                                    str = "ivIcon";
                                }
                            } else {
                                str = "imgClose";
                            }
                        } else {
                            str = "flOption";
                        }
                    } else {
                        str = "cancelBuyBtn";
                    }
                } else {
                    str = "agreementText";
                }
            } else {
                str = "agreementLayout";
            }
        } else {
            str = "agreementBtn";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.y;
    }
}
