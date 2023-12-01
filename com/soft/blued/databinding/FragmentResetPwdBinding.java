package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.module.common.view.ClearEditText;
import com.blued.android.module.common.view.CommonEdittextView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.soft.blued.R;
import com.soft.blued.utils.password.PasswordStatusView;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/FragmentResetPwdBinding.class */
public final class FragmentResetPwdBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f15265a;
    public final ClearEditText b;

    /* renamed from: c  reason: collision with root package name */
    public final CommonEdittextView f15266c;
    public final CommonEdittextView d;
    public final ImageView e;
    public final ShapeLinearLayout f;
    public final PasswordStatusView g;
    public final ShapeRelativeLayout h;
    public final CommonTopTitleNoTrans i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    private final LinearLayout m;

    private FragmentResetPwdBinding(LinearLayout linearLayout, TextView textView, ClearEditText clearEditText, CommonEdittextView commonEdittextView, CommonEdittextView commonEdittextView2, ImageView imageView, ShapeLinearLayout shapeLinearLayout, PasswordStatusView passwordStatusView, ShapeRelativeLayout shapeRelativeLayout, CommonTopTitleNoTrans commonTopTitleNoTrans, TextView textView2, TextView textView3, TextView textView4) {
        this.m = linearLayout;
        this.f15265a = textView;
        this.b = clearEditText;
        this.f15266c = commonEdittextView;
        this.d = commonEdittextView2;
        this.e = imageView;
        this.f = shapeLinearLayout;
        this.g = passwordStatusView;
        this.h = shapeRelativeLayout;
        this.i = commonTopTitleNoTrans;
        this.j = textView2;
        this.k = textView3;
        this.l = textView4;
    }

    public static FragmentResetPwdBinding a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.btn_confirm);
        if (textView != null) {
            ClearEditText findViewById = view.findViewById(R.id.edt_phone_vcode);
            if (findViewById != null) {
                CommonEdittextView findViewById2 = view.findViewById(R.id.et_new_pwd);
                if (findViewById2 != null) {
                    CommonEdittextView findViewById3 = view.findViewById(R.id.et_new_pwd_confirm);
                    if (findViewById3 != null) {
                        ImageView imageView = (ImageView) view.findViewById(R.id.iv_arrow);
                        if (imageView != null) {
                            ShapeLinearLayout findViewById4 = view.findViewById(R.id.ll_phone_vcode);
                            if (findViewById4 != null) {
                                PasswordStatusView passwordStatusView = (PasswordStatusView) view.findViewById(R.id.pwd_check_view);
                                if (passwordStatusView != null) {
                                    ShapeRelativeLayout findViewById5 = view.findViewById(R.id.rl_phone_num);
                                    if (findViewById5 != null) {
                                        CommonTopTitleNoTrans findViewById6 = view.findViewById(R.id.top_title);
                                        if (findViewById6 != null) {
                                            TextView textView2 = (TextView) view.findViewById(2131371675);
                                            if (textView2 != null) {
                                                TextView textView3 = (TextView) view.findViewById(2131372234);
                                                if (textView3 != null) {
                                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_vcode_desc);
                                                    if (textView4 != null) {
                                                        return new FragmentResetPwdBinding((LinearLayout) view, textView, findViewById, findViewById2, findViewById3, imageView, findViewById4, passwordStatusView, findViewById5, findViewById6, textView2, textView3, textView4);
                                                    }
                                                    str = "tvVcodeDesc";
                                                } else {
                                                    str = "tvPhoneNum";
                                                }
                                            } else {
                                                str = "tvHint";
                                            }
                                        } else {
                                            str = "topTitle";
                                        }
                                    } else {
                                        str = "rlPhoneNum";
                                    }
                                } else {
                                    str = "pwdCheckView";
                                }
                            } else {
                                str = "llPhoneVcode";
                            }
                        } else {
                            str = "ivArrow";
                        }
                    } else {
                        str = "etNewPwdConfirm";
                    }
                } else {
                    str = "etNewPwd";
                }
            } else {
                str = "edtPhoneVcode";
            }
        } else {
            str = "btnConfirm";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.m;
    }
}
