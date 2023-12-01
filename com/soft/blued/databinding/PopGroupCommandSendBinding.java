package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/PopGroupCommandSendBinding.class */
public final class PopGroupCommandSendBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f15833a;
    public final ShapeTextView b;

    /* renamed from: c  reason: collision with root package name */
    private final ShapeRelativeLayout f15834c;

    private PopGroupCommandSendBinding(ShapeRelativeLayout shapeRelativeLayout, ImageView imageView, ShapeTextView shapeTextView) {
        this.f15834c = shapeRelativeLayout;
        this.f15833a = imageView;
        this.b = shapeTextView;
    }

    public static PopGroupCommandSendBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(2131365207);
        if (imageView != null) {
            ShapeTextView findViewById = view.findViewById(R.id.tv_invite);
            if (findViewById != null) {
                return new PopGroupCommandSendBinding((ShapeRelativeLayout) view, imageView, findViewById);
            }
            str = "tvInvite";
        } else {
            str = "ivClose";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ShapeRelativeLayout getRoot() {
        return this.f15834c;
    }
}
