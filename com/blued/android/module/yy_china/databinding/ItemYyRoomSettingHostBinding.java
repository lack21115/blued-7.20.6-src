package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyRoomSettingHostBinding.class */
public final class ItemYyRoomSettingHostBinding implements ViewBinding {
    public final SquareImageView a;
    public final ShapeTextView b;
    public final TextView c;
    public final ShapeTextView d;
    private final ConstraintLayout e;

    private ItemYyRoomSettingHostBinding(ConstraintLayout constraintLayout, SquareImageView squareImageView, ShapeTextView shapeTextView, TextView textView, ShapeTextView shapeTextView2) {
        this.e = constraintLayout;
        this.a = squareImageView;
        this.b = shapeTextView;
        this.c = textView;
        this.d = shapeTextView2;
    }

    public static ItemYyRoomSettingHostBinding a(View view) {
        String str;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv_user);
        if (squareImageView != null) {
            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_cancle);
            if (shapeTextView != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_name);
                if (textView != null) {
                    ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_type);
                    if (shapeTextView2 != null) {
                        return new ItemYyRoomSettingHostBinding((ConstraintLayout) view, squareImageView, shapeTextView, textView, shapeTextView2);
                    }
                    str = "tvType";
                } else {
                    str = "tvName";
                }
            } else {
                str = "tvCancle";
            }
        } else {
            str = "ivUser";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.e;
    }
}
