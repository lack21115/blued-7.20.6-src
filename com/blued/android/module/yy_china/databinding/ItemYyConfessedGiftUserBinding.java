package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyConfessedGiftUserBinding.class */
public final class ItemYyConfessedGiftUserBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final SquareImageView f16684a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    private final ConstraintLayout f16685c;

    private ItemYyConfessedGiftUserBinding(ConstraintLayout constraintLayout, SquareImageView squareImageView, ImageView imageView) {
        this.f16685c = constraintLayout;
        this.f16684a = squareImageView;
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

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f16685c;
    }
}
