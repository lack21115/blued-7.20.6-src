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
    public final ShapeTextView f15098a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTextView f15099c;
    private final FrameLayout d;

    private FragmentBluedInterstitialBinding(FrameLayout frameLayout, ShapeTextView shapeTextView, ImageView imageView, ShapeTextView shapeTextView2) {
        this.d = frameLayout;
        this.f15098a = shapeTextView;
        this.b = imageView;
        this.f15099c = shapeTextView2;
    }

    public static FragmentBluedInterstitialBinding a(View view) {
        String str;
        ShapeTextView findViewById = view.findViewById(R.id.iv_ad_close);
        if (findViewById != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_ad_picture);
            if (imageView != null) {
                ShapeTextView findViewById2 = view.findViewById(R.id.tv_ad_icon);
                if (findViewById2 != null) {
                    return new FragmentBluedInterstitialBinding((FrameLayout) view, findViewById, imageView, findViewById2);
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
