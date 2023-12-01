package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyConfessedGiftUserBinding.class */
public final class ItemYyConfessedGiftUserBinding implements ViewBinding {
    public final SquareImageView a;
    public final ImageView b;
    private final ConstraintLayout c;

    private ItemYyConfessedGiftUserBinding(ConstraintLayout constraintLayout, SquareImageView squareImageView, ImageView imageView) {
        this.c = constraintLayout;
        this.a = squareImageView;
        this.b = imageView;
    }

    public static ItemYyConfessedGiftUserBinding a(View view) {
        String str;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv);
        if (squareImageView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_select);
            if (imageView != null) {
                return new ItemYyConfessedGiftUserBinding((ConstraintLayout) view, squareImageView, imageView);
            }
            str = "ivSelect";
        } else {
            str = "iv";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.c;
    }
}
