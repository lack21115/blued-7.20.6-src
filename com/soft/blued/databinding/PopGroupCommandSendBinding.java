package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.framework.view.shape.ShapeTextView;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/PopGroupCommandSendBinding.class */
public final class PopGroupCommandSendBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f29523a;
    public final ShapeTextView b;

    /* renamed from: c  reason: collision with root package name */
    private final ShapeRelativeLayout f29524c;

    private PopGroupCommandSendBinding(ShapeRelativeLayout shapeRelativeLayout, ImageView imageView, ShapeTextView shapeTextView) {
        this.f29524c = shapeRelativeLayout;
        this.f29523a = imageView;
        this.b = shapeTextView;
    }

    public static PopGroupCommandSendBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(2131365207);
        if (imageView != null) {
            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(2131371733);
            if (shapeTextView != null) {
                return new PopGroupCommandSendBinding((ShapeRelativeLayout) view, imageView, shapeTextView);
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
        return this.f29524c;
    }
}
