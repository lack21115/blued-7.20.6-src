package com.soft.blued.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/FragmentBluedInterstitialBinding.class */
public final class FragmentBluedInterstitialBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f28788a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTextView f28789c;
    private final FrameLayout d;

    private FragmentBluedInterstitialBinding(FrameLayout frameLayout, ShapeTextView shapeTextView, ImageView imageView, ShapeTextView shapeTextView2) {
        this.d = frameLayout;
        this.f28788a = shapeTextView;
        this.b = imageView;
        this.f28789c = shapeTextView2;
    }

    public static FragmentBluedInterstitialBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.iv_ad_close);
        if (shapeTextView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_ad_picture);
            if (imageView != null) {
                ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_ad_icon);
                if (shapeTextView2 != null) {
                    return new FragmentBluedInterstitialBinding((FrameLayout) view, shapeTextView, imageView, shapeTextView2);
                }
                str = "tvAdIcon";
            } else {
                str = "ivAdPicture";
            }
        } else {
            str = "ivAdClose";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.d;
    }
}
