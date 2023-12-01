package com.soft.blued.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/DialogVipUpgradeBinding.class */
public final class DialogVipUpgradeBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f28732a;
    public final FrameLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f28733c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final LinearLayout h;
    public final LinearLayout i;
    public final LinearLayout j;
    public final RecyclerView k;
    public final ShapeConstraintLayout l;
    public final LinearLayout m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final TextView r;
    private final ShapeConstraintLayout s;

    private DialogVipUpgradeBinding(ShapeConstraintLayout shapeConstraintLayout, LinearLayout linearLayout, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, RecyclerView recyclerView, ShapeConstraintLayout shapeConstraintLayout2, LinearLayout linearLayout5, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.s = shapeConstraintLayout;
        this.f28732a = linearLayout;
        this.b = frameLayout;
        this.f28733c = imageView;
        this.d = imageView2;
        this.e = imageView3;
        this.f = imageView4;
        this.g = imageView5;
        this.h = linearLayout2;
        this.i = linearLayout3;
        this.j = linearLayout4;
        this.k = recyclerView;
        this.l = shapeConstraintLayout2;
        this.m = linearLayout5;
        this.n = textView;
        this.o = textView2;
        this.p = textView3;
        this.q = textView4;
        this.r = textView5;
    }

    public static DialogVipUpgradeBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogVipUpgradeBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_vip_upgrade, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogVipUpgradeBinding a(View view) {
        String str;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.agreement_layout);
        if (linearLayout != null) {
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.buy_btn);
            if (frameLayout != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.img_alipay_choose_status);
                if (imageView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.img_wechat_choose_status);
                    if (imageView2 != null) {
                        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_agreement_btn);
                        if (imageView3 != null) {
                            ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_buy_btn);
                            if (imageView4 != null) {
                                ImageView imageView5 = (ImageView) view.findViewById(2131365773);
                                if (imageView5 != null) {
                                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_alipay);
                                    if (linearLayout2 != null) {
                                        LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.ll_weixin);
                                        if (linearLayout3 != null) {
                                            LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.pay_type_layout);
                                            if (linearLayout4 != null) {
                                                RecyclerView recyclerView = (RecyclerView) view.findViewById(2131369105);
                                                if (recyclerView != null) {
                                                    ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(2131369468);
                                                    if (shapeConstraintLayout != null) {
                                                        LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.to_vip_buy_page);
                                                        if (linearLayout5 != null) {
                                                            TextView textView = (TextView) view.findViewById(R.id.tv_agreement_text);
                                                            if (textView != null) {
                                                                TextView textView2 = (TextView) view.findViewById(R.id.tv_ali_name);
                                                                if (textView2 != null) {
                                                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_buy_btn);
                                                                    if (textView3 != null) {
                                                                        TextView textView4 = (TextView) view.findViewById(R.id.tv_select_option_desc);
                                                                        if (textView4 != null) {
                                                                            TextView textView5 = (TextView) view.findViewById(2131372754);
                                                                            if (textView5 != null) {
                                                                                return new DialogVipUpgradeBinding((ShapeConstraintLayout) view, linearLayout, frameLayout, imageView, imageView2, imageView3, imageView4, imageView5, linearLayout2, linearLayout3, linearLayout4, recyclerView, shapeConstraintLayout, linearLayout5, textView, textView2, textView3, textView4, textView5);
                                                                            }
                                                                            str = "tvTitle";
                                                                        } else {
                                                                            str = "tvSelectOptionDesc";
                                                                        }
                                                                    } else {
                                                                        str = "tvBuyBtn";
                                                                    }
                                                                } else {
                                                                    str = "tvAliName";
                                                                }
                                                            } else {
                                                                str = "tvAgreementText";
                                                            }
                                                        } else {
                                                            str = "toVipBuyPage";
                                                        }
                                                    } else {
                                                        str = "rootLayout";
                                                    }
                                                } else {
                                                    str = "recyclerView";
                                                }
                                            } else {
                                                str = "payTypeLayout";
                                            }
                                        } else {
                                            str = "llWeixin";
                                        }
                                    } else {
                                        str = "llAlipay";
                                    }
                                } else {
                                    str = "ivQuestion";
                                }
                            } else {
                                str = "ivBuyBtn";
                            }
                        } else {
                            str = "ivAgreementBtn";
                        }
                    } else {
                        str = "imgWechatChooseStatus";
                    }
                } else {
                    str = "imgAlipayChooseStatus";
                }
            } else {
                str = "buyBtn";
            }
        } else {
            str = "agreementLayout";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ShapeConstraintLayout getRoot() {
        return this.s;
    }
}
