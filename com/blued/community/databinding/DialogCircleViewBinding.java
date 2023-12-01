package com.blued.community.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/DialogCircleViewBinding.class */
public final class DialogCircleViewBinding implements ViewBinding {
    public final ImageView a;
    public final ImageView b;
    public final ShapeTextView c;
    public final TextView d;
    private final ShapeConstraintLayout e;

    private DialogCircleViewBinding(ShapeConstraintLayout shapeConstraintLayout, ImageView imageView, ImageView imageView2, ShapeTextView shapeTextView, TextView textView) {
        this.e = shapeConstraintLayout;
        this.a = imageView;
        this.b = imageView2;
        this.c = shapeTextView;
        this.d = textView;
    }

    public static DialogCircleViewBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_close);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_header);
            if (imageView2 != null) {
                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.iv_view_circle);
                if (shapeTextView != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_name);
                    if (textView != null) {
                        return new DialogCircleViewBinding((ShapeConstraintLayout) view, imageView, imageView2, shapeTextView, textView);
                    }
                    str = "tvName";
                } else {
                    str = "ivViewCircle";
                }
            } else {
                str = "ivHeader";
            }
        } else {
            str = "ivClose";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ShapeConstraintLayout getRoot() {
        return this.e;
    }
}
