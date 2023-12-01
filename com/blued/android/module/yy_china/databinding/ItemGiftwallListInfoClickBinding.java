package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;
import com.google.android.material.imageview.ShapeableImageView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemGiftwallListInfoClickBinding.class */
public final class ItemGiftwallListInfoClickBinding implements ViewBinding {
    public final SquareImageView a;
    public final ImageView b;
    public final ShapeableImageView c;
    public final ProgressBar d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    private final ConstraintLayout i;

    private ItemGiftwallListInfoClickBinding(ConstraintLayout constraintLayout, SquareImageView squareImageView, ImageView imageView, ShapeableImageView shapeableImageView, ProgressBar progressBar, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.i = constraintLayout;
        this.a = squareImageView;
        this.b = imageView;
        this.c = shapeableImageView;
        this.d = progressBar;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
        this.h = textView4;
    }

    public static ItemGiftwallListInfoClickBinding a(View view) {
        String str;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv);
        if (squareImageView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
            if (imageView != null) {
                ShapeableImageView findViewById = view.findViewById(R.id.iv_user);
                if (findViewById != null) {
                    ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.pro);
                    if (progressBar != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_alls);
                        if (textView != null) {
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_gift_name);
                            if (textView2 != null) {
                                TextView textView3 = (TextView) view.findViewById(R.id.tv_left_info);
                                if (textView3 != null) {
                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_right_info);
                                    if (textView4 != null) {
                                        return new ItemGiftwallListInfoClickBinding((ConstraintLayout) view, squareImageView, imageView, findViewById, progressBar, textView, textView2, textView3, textView4);
                                    }
                                    str = "tvRightInfo";
                                } else {
                                    str = "tvLeftInfo";
                                }
                            } else {
                                str = "tvGiftName";
                            }
                        } else {
                            str = "tvAlls";
                        }
                    } else {
                        str = "pro";
                    }
                } else {
                    str = "ivUser";
                }
            } else {
                str = "ivBack";
            }
        } else {
            str = "iv";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.i;
    }
}
