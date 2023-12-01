package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/PopGroupHelpDetailBinding.class */
public final class PopGroupHelpDetailBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f29529a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTextView f29530c;
    public final ShapeTextView d;
    private final LinearLayout e;

    private PopGroupHelpDetailBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ShapeTextView shapeTextView, ShapeTextView shapeTextView2) {
        this.e = linearLayout;
        this.f29529a = imageView;
        this.b = imageView2;
        this.f29530c = shapeTextView;
        this.d = shapeTextView2;
    }

    public static PopGroupHelpDetailBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(2131365207);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(2131365477);
            if (imageView2 != null) {
                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_help);
                if (shapeTextView != null) {
                    ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(2131372046);
                    if (shapeTextView2 != null) {
                        return new PopGroupHelpDetailBinding((LinearLayout) view, imageView, imageView2, shapeTextView, shapeTextView2);
                    }
                    str = "tvName";
                } else {
                    str = "tvHelp";
                }
            } else {
                str = "ivHeader";
            }
        } else {
            str = "ivClose";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.e;
    }
}
