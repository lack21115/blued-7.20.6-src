package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemHomeBottBinding.class */
public final class ItemHomeBottBinding implements ViewBinding {
    public final SquareImageView a;
    public final ImageView b;
    public final ImageView c;
    public final LinearLayout d;
    public final TextView e;
    private final ConstraintLayout f;

    private ItemHomeBottBinding(ConstraintLayout constraintLayout, SquareImageView squareImageView, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, TextView textView) {
        this.f = constraintLayout;
        this.a = squareImageView;
        this.b = imageView;
        this.c = imageView2;
        this.d = linearLayout;
        this.e = textView;
    }

    public static ItemHomeBottBinding a(View view) {
        String str;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv);
        if (squareImageView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_more);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_rydj_red);
                if (imageView2 != null) {
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.rl_);
                    if (linearLayout != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_name);
                        if (textView != null) {
                            return new ItemHomeBottBinding((ConstraintLayout) view, squareImageView, imageView, imageView2, linearLayout, textView);
                        }
                        str = "tvName";
                    } else {
                        str = "rl";
                    }
                } else {
                    str = "ivRydjRed";
                }
            } else {
                str = "ivMore";
            }
        } else {
            str = "iv";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f;
    }
}
