package com.blued.login.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.CommonEdittextView;
import com.blued.login.R;

/* loaded from: source-7206380-dex2jar.jar:com/blued/login/databinding/FragmentLoginTestBinding.class */
public final class FragmentLoginTestBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f6917a;
    public final CommonEdittextView b;

    /* renamed from: c  reason: collision with root package name */
    public final EditText f6918c;
    public final EditText d;
    public final EditText e;
    public final EditText f;
    public final LinearLayout g;
    public final LinearLayout h;
    public final RecyclerView i;
    public final ToggleButton j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    private final LinearLayout p;

    private FragmentLoginTestBinding(LinearLayout linearLayout, ImageView imageView, CommonEdittextView commonEdittextView, EditText editText, EditText editText2, EditText editText3, EditText editText4, LinearLayout linearLayout2, LinearLayout linearLayout3, RecyclerView recyclerView, ToggleButton toggleButton, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.p = linearLayout;
        this.f6917a = imageView;
        this.b = commonEdittextView;
        this.f6918c = editText;
        this.d = editText2;
        this.e = editText3;
        this.f = editText4;
        this.g = linearLayout2;
        this.h = linearLayout3;
        this.i = recyclerView;
        this.j = toggleButton;
        this.k = textView;
        this.l = textView2;
        this.m = textView3;
        this.n = textView4;
        this.o = textView5;
    }

    public static FragmentLoginTestBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.aariv_captcha);
        if (imageView != null) {
            CommonEdittextView findViewById = view.findViewById(R.id.cev_captcha);
            if (findViewById != null) {
                EditText editText = (EditText) view.findViewById(R.id.edt_account);
                if (editText != null) {
                    EditText editText2 = (EditText) view.findViewById(R.id.edt_area_code);
                    if (editText2 != null) {
                        EditText editText3 = (EditText) view.findViewById(R.id.edt_code);
                        if (editText3 != null) {
                            EditText editText4 = (EditText) view.findViewById(R.id.edt_password);
                            if (editText4 != null) {
                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_captcha);
                                if (linearLayout != null) {
                                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_code);
                                    if (linearLayout2 != null) {
                                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_login);
                                        if (recyclerView != null) {
                                            ToggleButton toggleButton = (ToggleButton) view.findViewById(R.id.tb_swich);
                                            if (toggleButton != null) {
                                                TextView textView = (TextView) view.findViewById(R.id.tv_code_login);
                                                if (textView != null) {
                                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_email_login);
                                                    if (textView2 != null) {
                                                        TextView textView3 = (TextView) view.findViewById(R.id.tv_mobile_login);
                                                        if (textView3 != null) {
                                                            TextView textView4 = (TextView) view.findViewById(R.id.tv_phone_code_login);
                                                            if (textView4 != null) {
                                                                TextView textView5 = (TextView) view.findViewById(R.id.tv_phone_code_send);
                                                                if (textView5 != null) {
                                                                    return new FragmentLoginTestBinding((LinearLayout) view, imageView, findViewById, editText, editText2, editText3, editText4, linearLayout, linearLayout2, recyclerView, toggleButton, textView, textView2, textView3, textView4, textView5);
                                                                }
                                                                str = "tvPhoneCodeSend";
                                                            } else {
                                                                str = "tvPhoneCodeLogin";
                                                            }
                                                        } else {
                                                            str = "tvMobileLogin";
                                                        }
                                                    } else {
                                                        str = "tvEmailLogin";
                                                    }
                                                } else {
                                                    str = "tvCodeLogin";
                                                }
                                            } else {
                                                str = "tbSwich";
                                            }
                                        } else {
                                            str = "rvLogin";
                                        }
                                    } else {
                                        str = "llCode";
                                    }
                                } else {
                                    str = "llCaptcha";
                                }
                            } else {
                                str = "edtPassword";
                            }
                        } else {
                            str = "edtCode";
                        }
                    } else {
                        str = "edtAreaCode";
                    }
                } else {
                    str = "edtAccount";
                }
            } else {
                str = "cevCaptcha";
            }
        } else {
            str = "aarivCaptcha";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.p;
    }
}
