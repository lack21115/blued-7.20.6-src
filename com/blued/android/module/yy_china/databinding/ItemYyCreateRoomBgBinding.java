package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyCreateRoomBgBinding.class */
public final class ItemYyCreateRoomBgBinding implements ViewBinding {
    public final ImageView a;
    public final ImageView b;
    public final ShapeTextView c;
    public final ShapeTextView d;
    private final ConstraintLayout e;

    private ItemYyCreateRoomBgBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ShapeTextView shapeTextView, ShapeTextView shapeTextView2) {
        this.e = constraintLayout;
        this.a = imageView;
        this.b = imageView2;
        this.c = shapeTextView;
        this.d = shapeTextView2;
    }

    public static ItemYyCreateRoomBgBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_ani);
            if (imageView2 != null) {
                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.iv_select);
                if (shapeTextView != null) {
                    ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_mess);
                    if (shapeTextView2 != null) {
                        return new ItemYyCreateRoomBgBinding((ConstraintLayout) view, imageView, imageView2, shapeTextView, shapeTextView2);
                    }
                    str = "tvMess";
                } else {
                    str = "ivSelect";
                }
            } else {
                str = "ivAni";
            }
        } else {
            str = "iv";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.e;
    }
}
