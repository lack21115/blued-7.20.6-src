package com.blued.community.databinding;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/DialogEventSignUpBinding.class */
public final class DialogEventSignUpBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final CheckBox f18797a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f18798c;
    public final LinearLayout d;
    public final ShapeLinearLayout e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final ShapeTextView j;
    private final ConstraintLayout k;

    private DialogEventSignUpBinding(ConstraintLayout constraintLayout, CheckBox checkBox, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, ShapeLinearLayout shapeLinearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, ShapeTextView shapeTextView) {
        this.k = constraintLayout;
        this.f18797a = checkBox;
        this.b = imageView;
        this.f18798c = linearLayout;
        this.d = linearLayout2;
        this.e = shapeLinearLayout;
        this.f = textView;
        this.g = textView2;
        this.h = textView3;
        this.i = textView4;
        this.j = shapeTextView;
    }

    public static DialogEventSignUpBinding a(View view) {
        String str;
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.cb_event);
        if (checkBox != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_event_dialog_close);
            if (imageView != null) {
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_cb);
                if (linearLayout != null) {
                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_cb_event);
                    if (linearLayout2 != null) {
                        ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.ll_security_reminders);
                        if (shapeLinearLayout != null) {
                            TextView textView = (TextView) view.findViewById(R.id.markdown_view);
                            if (textView != null) {
                                TextView textView2 = (TextView) view.findViewById(R.id.tv_content);
                                if (textView2 != null) {
                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_event_dialog_desc);
                                    if (textView3 != null) {
                                        TextView textView4 = (TextView) view.findViewById(R.id.tv_event_dialog_title);
                                        if (textView4 != null) {
                                            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_event_sign_up_btn);
                                            if (shapeTextView != null) {
                                                return new DialogEventSignUpBinding((ConstraintLayout) view, checkBox, imageView, linearLayout, linearLayout2, shapeLinearLayout, textView, textView2, textView3, textView4, shapeTextView);
                                            }
                                            str = "tvEventSignUpBtn";
                                        } else {
                                            str = "tvEventDialogTitle";
                                        }
                                    } else {
                                        str = "tvEventDialogDesc";
                                    }
                                } else {
                                    str = "tvContent";
                                }
                            } else {
                                str = "markdownView";
                            }
                        } else {
                            str = "llSecurityReminders";
                        }
                    } else {
                        str = "llCbEvent";
                    }
                } else {
                    str = "llCb";
                }
            } else {
                str = "ivEventDialogClose";
            }
        } else {
            str = "cbEvent";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.k;
    }
}
