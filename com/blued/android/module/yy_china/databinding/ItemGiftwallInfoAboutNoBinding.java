package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemGiftwallInfoAboutNoBinding.class */
public final class ItemGiftwallInfoAboutNoBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final SquareImageView f16607a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f16608c;
    public final TextView d;
    private final ConstraintLayout e;

    private ItemGiftwallInfoAboutNoBinding(ConstraintLayout constraintLayout, SquareImageView squareImageView, ImageView imageView, TextView textView, TextView textView2) {
        this.e = constraintLayout;
        this.f16607a = squareImageView;
        this.b = imageView;
        this.f16608c = textView;
        this.d = textView2;
    }

    public static ItemGiftwallInfoAboutNoBinding a(View view) {
        String str;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv);
        if (squareImageView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
            if (imageView != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_gift_name);
                if (textView != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_info);
                    if (textView2 != null) {
                        return new ItemGiftwallInfoAboutNoBinding((ConstraintLayout) view, squareImageView, imageView, textView, textView2);
                    }
                    str = "tvInfo";
                } else {
                    str = "tvGiftName";
                }
            } else {
                str = "ivBack";
            }
        } else {
            str = "iv";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.e;
    }
}
