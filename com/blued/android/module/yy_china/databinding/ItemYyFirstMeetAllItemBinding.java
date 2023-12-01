package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyFirstMeetAllItemBinding.class */
public final class ItemYyFirstMeetAllItemBinding implements ViewBinding {
    public final SquareImageView a;
    public final TextView b;
    public final ShapeTextView c;
    public final ShapeTextView d;
    private final LinearLayout e;

    private ItemYyFirstMeetAllItemBinding(LinearLayout linearLayout, SquareImageView squareImageView, TextView textView, ShapeTextView shapeTextView, ShapeTextView shapeTextView2) {
        this.e = linearLayout;
        this.a = squareImageView;
        this.b = textView;
        this.c = shapeTextView;
        this.d = shapeTextView2;
    }

    public static ItemYyFirstMeetAllItemBinding a(View view) {
        String str;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv);
        if (squareImageView != null) {
            TextView textView = (TextView) view.findViewById(R.id.tv_name);
            if (textView != null) {
                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_num);
                if (shapeTextView != null) {
                    ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_time);
                    if (shapeTextView2 != null) {
                        return new ItemYyFirstMeetAllItemBinding((LinearLayout) view, squareImageView, textView, shapeTextView, shapeTextView2);
                    }
                    str = "tvTime";
                } else {
                    str = "tvNum";
                }
            } else {
                str = "tvName";
            }
        } else {
            str = "iv";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.e;
    }
}
