package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogNoAnchorBinding.class */
public final class DialogNoAnchorBinding implements ViewBinding {
    public final ShapeTextView a;
    public final View b;
    public final ImageView c;
    public final ImageView d;
    public final TextView e;
    public final TextView f;
    private final ConstraintLayout g;

    private DialogNoAnchorBinding(ConstraintLayout constraintLayout, ShapeTextView shapeTextView, View view, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2) {
        this.g = constraintLayout;
        this.a = shapeTextView;
        this.b = view;
        this.c = imageView;
        this.d = imageView2;
        this.e = textView;
        this.f = textView2;
    }

    public static DialogNoAnchorBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.btn_cancel);
        if (shapeTextView != null) {
            View findViewById = view.findViewById(R.id.cover_view);
            if (findViewById != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.img_background);
                if (imageView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv);
                    if (imageView2 != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_dialog_content);
                        if (textView != null) {
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_dialog_title);
                            if (textView2 != null) {
                                return new DialogNoAnchorBinding((ConstraintLayout) view, shapeTextView, findViewById, imageView, imageView2, textView, textView2);
                            }
                            str = "tvDialogTitle";
                        } else {
                            str = "tvDialogContent";
                        }
                    } else {
                        str = "iv";
                    }
                } else {
                    str = "imgBackground";
                }
            } else {
                str = "coverView";
            }
        } else {
            str = "btnCancel";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.g;
    }
}
