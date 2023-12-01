package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.google.android.material.imageview.ShapeableImageView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogPrizeOfActivityBinding.class */
public final class DialogPrizeOfActivityBinding implements ViewBinding {
    public final View a;
    public final ShapeTextView b;
    public final ShapeableImageView c;
    public final TextView d;
    public final TextView e;
    public final ImageView f;
    private final ConstraintLayout g;

    private DialogPrizeOfActivityBinding(ConstraintLayout constraintLayout, View view, ShapeTextView shapeTextView, ShapeableImageView shapeableImageView, TextView textView, TextView textView2, ImageView imageView) {
        this.g = constraintLayout;
        this.a = view;
        this.b = shapeTextView;
        this.c = shapeableImageView;
        this.d = textView;
        this.e = textView2;
        this.f = imageView;
    }

    public static DialogPrizeOfActivityBinding a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.cover_view);
        if (findViewById != null) {
            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.dialog_btn_ok);
            if (shapeTextView != null) {
                ShapeableImageView findViewById2 = view.findViewById(R.id.dialog_prize_img);
                if (findViewById2 != null) {
                    TextView textView = (TextView) view.findViewById(R.id.dialog_prize_name);
                    if (textView != null) {
                        TextView textView2 = (TextView) view.findViewById(R.id.dialog_title);
                        if (textView2 != null) {
                            ImageView imageView = (ImageView) view.findViewById(R.id.img_background);
                            if (imageView != null) {
                                return new DialogPrizeOfActivityBinding((ConstraintLayout) view, findViewById, shapeTextView, findViewById2, textView, textView2, imageView);
                            }
                            str = "imgBackground";
                        } else {
                            str = "dialogTitle";
                        }
                    } else {
                        str = "dialogPrizeName";
                    }
                } else {
                    str = "dialogPrizeImg";
                }
            } else {
                str = "dialogBtnOk";
            }
        } else {
            str = "coverView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.g;
    }
}
