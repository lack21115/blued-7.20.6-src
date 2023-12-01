package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyPrepayBackBinding.class */
public final class ItemYyPrepayBackBinding implements ViewBinding {
    public final SquareImageView a;
    public final TextView b;
    public final TextView c;
    private final RelativeLayout d;

    private ItemYyPrepayBackBinding(RelativeLayout relativeLayout, SquareImageView squareImageView, TextView textView, TextView textView2) {
        this.d = relativeLayout;
        this.a = squareImageView;
        this.b = textView;
        this.c = textView2;
    }

    public static ItemYyPrepayBackBinding a(View view) {
        String str;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv_gift_left);
        if (squareImageView != null) {
            TextView textView = (TextView) view.findViewById(R.id.tv_gift_left_name);
            if (textView != null) {
                TextView textView2 = (TextView) view.findViewById(R.id.tv_gift_left_num);
                if (textView2 != null) {
                    return new ItemYyPrepayBackBinding((RelativeLayout) view, squareImageView, textView, textView2);
                }
                str = "tvGiftLeftNum";
            } else {
                str = "tvGiftLeftName";
            }
        } else {
            str = "ivGiftLeft";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.d;
    }
}
