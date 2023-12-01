package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyPackGiftUserBinding.class */
public final class ItemYyPackGiftUserBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final SquareImageView f16775a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f16776c;
    private final ConstraintLayout d;

    private ItemYyPackGiftUserBinding(ConstraintLayout constraintLayout, SquareImageView squareImageView, ImageView imageView, TextView textView) {
        this.d = constraintLayout;
        this.f16775a = squareImageView;
        this.b = imageView;
        this.f16776c = textView;
    }

    public static ItemYyPackGiftUserBinding a(View view) {
        String str;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv);
        if (squareImageView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_select);
            if (imageView != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_name);
                if (textView != null) {
                    return new ItemYyPackGiftUserBinding((ConstraintLayout) view, squareImageView, imageView, textView);
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

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.d;
    }
}
