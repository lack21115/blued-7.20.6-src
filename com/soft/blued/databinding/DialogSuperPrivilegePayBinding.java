package com.soft.blued.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.R;
import com.soft.blued.ui.user.views.PrivilegeDialogBuyNewOptionView;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/DialogSuperPrivilegePayBinding.class */
public final class DialogSuperPrivilegePayBinding implements ViewBinding {
    public final TextView A;
    public final ShapeTextView B;
    public final TextView C;
    public final ShapeTextView D;
    public final TextView E;
    public final TextView F;
    public final PrivilegeDialogBuyNewOptionView G;
    public final PrivilegeDialogBuyNewOptionView H;
    public final PrivilegeDialogBuyNewOptionView I;
    private final RelativeLayout J;

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f28724a;
    public final LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f28725c;
    public final TextView d;
    public final TextView e;
    public final ConstraintLayout f;
    public final ImageView g;
    public final ImageView h;
    public final ImageView i;
    public final ImageView j;
    public final ImageView k;
    public final LinearLayout l;
    public final ShapeConstraintLayout m;
    public final LinearLayout n;
    public final LinearLayout o;
    public final LinearLayout p;
    public final LinearLayout q;
    public final LinearLayout r;
    public final FrameLayout s;
    public final ShapeRelativeLayout t;
    public final RelativeLayout u;
    public final ShapeLinearLayout v;
    public final FrameLayout w;
    public final TextView x;
    public final TextView y;
    public final TextView z;

    private DialogSuperPrivilegePayBinding(RelativeLayout relativeLayout, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, ConstraintLayout constraintLayout, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, LinearLayout linearLayout2, ShapeConstraintLayout shapeConstraintLayout, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, FrameLayout frameLayout, ShapeRelativeLayout shapeRelativeLayout, RelativeLayout relativeLayout2, ShapeLinearLayout shapeLinearLayout, FrameLayout frameLayout2, TextView textView4, TextView textView5, TextView textView6, TextView textView7, ShapeTextView shapeTextView, TextView textView8, ShapeTextView shapeTextView2, TextView textView9, TextView textView10, PrivilegeDialogBuyNewOptionView privilegeDialogBuyNewOptionView, PrivilegeDialogBuyNewOptionView privilegeDialogBuyNewOptionView2, PrivilegeDialogBuyNewOptionView privilegeDialogBuyNewOptionView3) {
        this.J = relativeLayout;
        this.f28724a = imageView;
        this.b = linearLayout;
        this.f28725c = textView;
        this.d = textView2;
        this.e = textView3;
        this.f = constraintLayout;
        this.g = imageView2;
        this.h = imageView3;
        this.i = imageView4;
        this.j = imageView5;
        this.k = imageView6;
        this.l = linearLayout2;
        this.m = shapeConstraintLayout;
        this.n = linearLayout3;
        this.o = linearLayout4;
        this.p = linearLayout5;
        this.q = linearLayout6;
        this.r = linearLayout7;
        this.s = frameLayout;
        this.t = shapeRelativeLayout;
        this.u = relativeLayout2;
        this.v = shapeLinearLayout;
        this.w = frameLayout2;
        this.x = textView4;
        this.y = textView5;
        this.z = textView6;
        this.A = textView7;
        this.B = shapeTextView;
        this.C = textView8;
        this.D = shapeTextView2;
        this.E = textView9;
        this.F = textView10;
        this.G = privilegeDialogBuyNewOptionView;
        this.H = privilegeDialogBuyNewOptionView2;
        this.I = privilegeDialogBuyNewOptionView3;
    }

    public static DialogSuperPrivilegePayBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.agreement_btn);
        if (imageView != null) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.agreement_layout);
            if (linearLayout != null) {
                TextView textView = (TextView) view.findViewById(R.id.agreement_text);
                if (textView != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.dialog_subtitle);
                    if (textView2 != null) {
                        TextView textView3 = (TextView) view.findViewById(2131363227);
                        if (textView3 != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.fl_option);
                            if (constraintLayout != null) {
                                ImageView imageView2 = (ImageView) view.findViewById(2131364488);
                                if (imageView2 != null) {
                                    ImageView imageView3 = (ImageView) view.findViewById(R.id.img_privilege_tab_bg);
                                    if (imageView3 != null) {
                                        ImageView imageView4 = (ImageView) view.findViewById(R.id.img_super_privilege_tab_bg);
                                        if (imageView4 != null) {
                                            ImageView imageView5 = (ImageView) view.findViewById(2131364702);
                                            if (imageView5 != null) {
                                                ImageView imageView6 = (ImageView) view.findViewById(2131365504);
                                                if (imageView6 != null) {
                                                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(2131367999);
                                                    if (linearLayout2 != null) {
                                                        ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.ll_mouth_card_item);
                                                        if (shapeConstraintLayout != null) {
                                                            LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.ll_mouth_card_times_count);
                                                            if (linearLayout3 != null) {
                                                                LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.ll_option);
                                                                if (linearLayout4 != null) {
                                                                    LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.ll_option_area);
                                                                    if (linearLayout5 != null) {
                                                                        LinearLayout linearLayout6 = (LinearLayout) view.findViewById(2131368267);
                                                                        if (linearLayout6 != null) {
                                                                            LinearLayout linearLayout7 = (LinearLayout) view.findViewById(R.id.privilege_layout_view);
                                                                            if (linearLayout7 != null) {
                                                                                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.privilege_tab);
                                                                                if (frameLayout != null) {
                                                                                    ShapeRelativeLayout shapeRelativeLayout = (ShapeRelativeLayout) view.findViewById(R.id.rl_pay_type);
                                                                                    if (shapeRelativeLayout != null) {
                                                                                        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(2131369468);
                                                                                        if (relativeLayout != null) {
                                                                                            ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.super_privilege_item);
                                                                                            if (shapeLinearLayout != null) {
                                                                                                FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.super_privilege_tab);
                                                                                                if (frameLayout2 != null) {
                                                                                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_buy_privilege);
                                                                                                    if (textView4 != null) {
                                                                                                        TextView textView5 = (TextView) view.findViewById(R.id.tv_item_choosed_desc);
                                                                                                        if (textView5 != null) {
                                                                                                            TextView textView6 = (TextView) view.findViewById(R.id.tv_mouth_card_count);
                                                                                                            if (textView6 != null) {
                                                                                                                TextView textView7 = (TextView) view.findViewById(R.id.tv_mouth_card_desc);
                                                                                                                if (textView7 != null) {
                                                                                                                    ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_mouth_card_favourate);
                                                                                                                    if (shapeTextView != null) {
                                                                                                                        TextView textView8 = (TextView) view.findViewById(R.id.tv_mouth_card_per_amount);
                                                                                                                        if (textView8 != null) {
                                                                                                                            ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_mouth_card_tag);
                                                                                                                            if (shapeTextView2 != null) {
                                                                                                                                TextView textView9 = (TextView) view.findViewById(R.id.tv_pay_type);
                                                                                                                                if (textView9 != null) {
                                                                                                                                    TextView textView10 = (TextView) view.findViewById(R.id.tv_super_privilege_option);
                                                                                                                                    if (textView10 != null) {
                                                                                                                                        PrivilegeDialogBuyNewOptionView privilegeDialogBuyNewOptionView = (PrivilegeDialogBuyNewOptionView) view.findViewById(R.id.view_option_1);
                                                                                                                                        if (privilegeDialogBuyNewOptionView != null) {
                                                                                                                                            PrivilegeDialogBuyNewOptionView privilegeDialogBuyNewOptionView2 = (PrivilegeDialogBuyNewOptionView) view.findViewById(R.id.view_option_2);
                                                                                                                                            if (privilegeDialogBuyNewOptionView2 != null) {
                                                                                                                                                PrivilegeDialogBuyNewOptionView privilegeDialogBuyNewOptionView3 = (PrivilegeDialogBuyNewOptionView) view.findViewById(R.id.view_option_3);
                                                                                                                                                if (privilegeDialogBuyNewOptionView3 != null) {
                                                                                                                                                    return new DialogSuperPrivilegePayBinding((RelativeLayout) view, imageView, linearLayout, textView, textView2, textView3, constraintLayout, imageView2, imageView3, imageView4, imageView5, imageView6, linearLayout2, shapeConstraintLayout, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, frameLayout, shapeRelativeLayout, relativeLayout, shapeLinearLayout, frameLayout2, textView4, textView5, textView6, textView7, shapeTextView, textView8, shapeTextView2, textView9, textView10, privilegeDialogBuyNewOptionView, privilegeDialogBuyNewOptionView2, privilegeDialogBuyNewOptionView3);
                                                                                                                                                }
                                                                                                                                                str = "viewOption3";
                                                                                                                                            } else {
                                                                                                                                                str = "viewOption2";
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            str = "viewOption1";
                                                                                                                                        }
                                                                                                                                    } else {
                                                                                                                                        str = "tvSuperPrivilegeOption";
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
                                                                                                    str = "superPrivilegeTab";
                                                                                                }
                                                                                            } else {
                                                                                                str = "superPrivilegeItem";
                                                                                            }
                                                                                        } else {
                                                                                            str = "rootLayout";
                                                                                        }
                                                                                    } else {
                                                                                        str = "rlPayType";
                                                                                    }
                                                                                } else {
                                                                                    str = "privilegeTab";
                                                                                }
                                                                            } else {
                                                                                str = "privilegeLayoutView";
                                                                            }
                                                                        } else {
                                                                            str = "llTab";
                                                                        }
                                                                    } else {
                                                                        str = "llOptionArea";
                                                                    }
                                                                } else {
                                                                    str = "llOption";
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
                                                str = "imgTopBg";
                                            }
                                        } else {
                                            str = "imgSuperPrivilegeTabBg";
                                        }
                                    } else {
                                        str = "imgPrivilegeTabBg";
                                    }
                                } else {
                                    str = "imgClose";
                                }
                            } else {
                                str = "flOption";
                            }
                        } else {
                            str = WbCloudFaceContant.DIALOG_TITLE;
                        }
                    } else {
                        str = "dialogSubtitle";
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
    public RelativeLayout getRoot() {
        return this.J;
    }
}
