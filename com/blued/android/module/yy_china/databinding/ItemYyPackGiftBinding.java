package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyPackGiftBinding.class */
public final class ItemYyPackGiftBinding implements ViewBinding {
    public final SquareImageView a;
    public final ShapeTextView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    private final ConstraintLayout f;

    private ItemYyPackGiftBinding(ConstraintLayout constraintLayout, SquareImageView squareImageView, ShapeTextView shapeTextView, TextView textView, TextView textView2, TextView textView3) {
        this.f = constraintLayout;
        this.a = squareImageView;
        this.b = shapeTextView;
        this.c = textView;
        this.d = textView2;
        this.e = textView3;
    }

    public static ItemYyPackGiftBinding a(View view) {
        String str;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv_gift);
        if (squareImageView != null) {
            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.iv_select);
            if (shapeTextView != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_beans);
                if (textView != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_name);
                    if (textView2 != null) {
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_send_num);
                        if (textView3 != null) {
                            return new ItemYyPackGiftBinding((ConstraintLayout) view, squareImageView, shapeTextView, textView, textView2, textView3);
                        }
                        str = "tvSendNum";
                    } else {
                        str = "tvName";
                    }
                } else {
                    str = "tvBeans";
                }
            } else {
                str = "ivSelect";
            }
        } else {
            str = "ivGift";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f;
    }
}
