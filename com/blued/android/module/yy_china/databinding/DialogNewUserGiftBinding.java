package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogNewUserGiftBinding.class */
public final class DialogNewUserGiftBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ImageView b;
    public final ImageView c;
    public final RecyclerView d;
    public final ShapeTextView e;
    private final ConstraintLayout f;

    private DialogNewUserGiftBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, RecyclerView recyclerView, ShapeTextView shapeTextView) {
        this.f = constraintLayout;
        this.a = constraintLayout2;
        this.b = imageView;
        this.c = imageView2;
        this.d = recyclerView;
        this.e = shapeTextView;
    }

    public static DialogNewUserGiftBinding a(View view) {
        String str;
        ConstraintLayout findViewById = view.findViewById(R.id.cl);
        if (findViewById != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_close);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_wenh);
                if (imageView2 != null) {
                    RecyclerView findViewById2 = view.findViewById(R.id.rcv);
                    if (findViewById2 != null) {
                        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv);
                        if (shapeTextView != null) {
                            return new DialogNewUserGiftBinding((ConstraintLayout) view, findViewById, imageView, imageView2, findViewById2, shapeTextView);
                        }
                        str = "tv";
                    } else {
                        str = "rcv";
                    }
                } else {
                    str = "ivWenh";
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
