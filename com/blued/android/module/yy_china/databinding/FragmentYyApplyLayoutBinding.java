package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentYyApplyLayoutBinding.class */
public final class FragmentYyApplyLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f16489a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f16490c;
    public final LinearLayout d;
    public final LinearLayout e;
    public final LinearLayout f;
    public final TextView g;
    public final EditText h;
    public final EditText i;
    public final TextView j;
    public final TextView k;
    public final ViewYyTitleBarLayoutBinding l;
    private final LinearLayout m;

    private FragmentYyApplyLayoutBinding(LinearLayout linearLayout, ShapeTextView shapeTextView, ImageView imageView, TextView textView, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView2, EditText editText, EditText editText2, TextView textView3, TextView textView4, ViewYyTitleBarLayoutBinding viewYyTitleBarLayoutBinding) {
        this.m = linearLayout;
        this.f16489a = shapeTextView;
        this.b = imageView;
        this.f16490c = textView;
        this.d = linearLayout2;
        this.e = linearLayout3;
        this.f = linearLayout4;
        this.g = textView2;
        this.h = editText;
        this.i = editText2;
        this.j = textView3;
        this.k = textView4;
        this.l = viewYyTitleBarLayoutBinding;
    }

    public static FragmentYyApplyLayoutBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.go_auth);
        if (shapeTextView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_terms);
            if (imageView != null) {
                TextView textView = (TextView) view.findViewById(R.id.live_agree);
                if (textView != null) {
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_clause);
                    if (linearLayout != null) {
                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_id);
                        if (linearLayout2 != null) {
                            LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.ll_name);
                            if (linearLayout3 != null) {
                                TextView textView2 = (TextView) view.findViewById(R.id.tv_bind_phone);
                                if (textView2 != null) {
                                    EditText editText = (EditText) view.findViewById(R.id.tv_cardnum);
                                    if (editText != null) {
                                        EditText editText2 = (EditText) view.findViewById(R.id.tv_name);
                                        if (editText2 != null) {
                                            TextView textView3 = (TextView) view.findViewById(R.id.tv_tip_one);
                                            if (textView3 != null) {
                                                TextView textView4 = (TextView) view.findViewById(R.id.tv_tip_two);
                                                if (textView4 != null) {
                                                    View findViewById = view.findViewById(R.id.x_title_bar);
                                                    if (findViewById != null) {
                                                        return new FragmentYyApplyLayoutBinding((LinearLayout) view, shapeTextView, imageView, textView, linearLayout, linearLayout2, linearLayout3, textView2, editText, editText2, textView3, textView4, ViewYyTitleBarLayoutBinding.a(findViewById));
                                                    }
                                                    str = "xTitleBar";
                                                } else {
                                                    str = "tvTipTwo";
                                                }
                                            } else {
                                                str = "tvTipOne";
                                            }
                                        } else {
                                            str = "tvName";
                                        }
                                    } else {
                                        str = "tvCardnum";
                                    }
                                } else {
                                    str = "tvBindPhone";
                                }
                            } else {
                                str = "llName";
                            }
                        } else {
                            str = "llId";
                        }
                    } else {
                        str = "llClause";
                    }
                } else {
                    str = "liveAgree";
                }
            } else {
                str = "ivTerms";
            }
        } else {
            str = "goAuth";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.m;
    }
}
