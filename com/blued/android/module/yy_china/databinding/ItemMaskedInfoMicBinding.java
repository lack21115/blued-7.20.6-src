package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemMaskedInfoMicBinding.class */
public final class ItemMaskedInfoMicBinding implements ViewBinding {
    public final SquareImageView a;
    public final ImageView b;
    public final TextView c;
    private final ConstraintLayout d;

    private ItemMaskedInfoMicBinding(ConstraintLayout constraintLayout, SquareImageView squareImageView, ImageView imageView, TextView textView) {
        this.d = constraintLayout;
        this.a = squareImageView;
        this.b = imageView;
        this.c = textView;
    }

    public static ItemMaskedInfoMicBinding a(View view) {
        String str;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv);
        if (squareImageView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_select);
            if (imageView != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_name);
                if (textView != null) {
                    return new ItemMaskedInfoMicBinding((ConstraintLayout) view, squareImageView, imageView, textView);
                }
                str = "tvName";
            } else {
                str = "ivSelect";
            }
        } else {
            str = "iv";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.d;
    }
}
