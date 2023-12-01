package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogBeansClearBinding.class */
public final class DialogBeansClearBinding implements ViewBinding {
    public final ShapeTextView a;
    public final ShapeTextView b;
    public final View c;
    public final ImageView d;
    public final TextView e;
    private final ConstraintLayout f;

    private DialogBeansClearBinding(ConstraintLayout constraintLayout, ShapeTextView shapeTextView, ShapeTextView shapeTextView2, View view, ImageView imageView, TextView textView) {
        this.f = constraintLayout;
        this.a = shapeTextView;
        this.b = shapeTextView2;
        this.c = view;
        this.d = imageView;
        this.e = textView;
    }

    public static DialogBeansClearBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.btn_cancel);
        if (shapeTextView != null) {
            ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.btn_ok);
            if (shapeTextView2 != null) {
                View findViewById = view.findViewById(R.id.cover_view);
                if (findViewById != null) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.img_background);
                    if (imageView != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_dialog_content);
                        if (textView != null) {
                            return new DialogBeansClearBinding((ConstraintLayout) view, shapeTextView, shapeTextView2, findViewById, imageView, textView);
                        }
                        str = "tvDialogContent";
                    } else {
                        str = "imgBackground";
                    }
                } else {
                    str = "coverView";
                }
            } else {
                str = "btnOk";
            }
        } else {
            str = "btnCancel";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f;
    }
}
