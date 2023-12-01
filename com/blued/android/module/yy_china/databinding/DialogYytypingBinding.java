package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogYytypingBinding.class */
public final class DialogYytypingBinding implements ViewBinding {
    public final EditText a;
    public final ImageView b;
    public final LinearLayout c;
    public final ShapeTextView d;
    private final ConstraintLayout e;

    private DialogYytypingBinding(ConstraintLayout constraintLayout, EditText editText, ImageView imageView, LinearLayout linearLayout, ShapeTextView shapeTextView) {
        this.e = constraintLayout;
        this.a = editText;
        this.b = imageView;
        this.c = linearLayout;
        this.d = shapeTextView;
    }

    public static DialogYytypingBinding a(View view) {
        String str;
        EditText editText = (EditText) view.findViewById(R.id.et_chat_input);
        if (editText != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
            if (imageView != null) {
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_bottom);
                if (linearLayout != null) {
                    ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_send_msg);
                    if (shapeTextView != null) {
                        return new DialogYytypingBinding((ConstraintLayout) view, editText, imageView, linearLayout, shapeTextView);
                    }
                    str = "tvSendMsg";
                } else {
                    str = "llBottom";
                }
            } else {
                str = "ivBack";
            }
        } else {
            str = "etChatInput";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.e;
    }
}
