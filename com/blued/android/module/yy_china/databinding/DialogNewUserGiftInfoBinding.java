package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogNewUserGiftInfoBinding.class */
public final class DialogNewUserGiftInfoBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ImageView b;
    public final RecyclerView c;
    public final ShapeTextView d;
    public final TextView e;
    private final ConstraintLayout f;

    private DialogNewUserGiftInfoBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, RecyclerView recyclerView, ShapeTextView shapeTextView, TextView textView) {
        this.f = constraintLayout;
        this.a = constraintLayout2;
        this.b = imageView;
        this.c = recyclerView;
        this.d = shapeTextView;
        this.e = textView;
    }

    public static DialogNewUserGiftInfoBinding a(View view) {
        String str;
        ConstraintLayout findViewById = view.findViewById(R.id.cl);
        if (findViewById != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_close);
            if (imageView != null) {
                RecyclerView findViewById2 = view.findViewById(R.id.rcv);
                if (findViewById2 != null) {
                    ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv);
                    if (shapeTextView != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_type);
                        if (textView != null) {
                            return new DialogNewUserGiftInfoBinding((ConstraintLayout) view, findViewById, imageView, findViewById2, shapeTextView, textView);
                        }
                        str = "tvType";
                    } else {
                        str = "tv";
                    }
                } else {
                    str = "rcv";
                }
            } else {
                str = "ivClose";
            }
        } else {
            str = "cl";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f;
    }
}
