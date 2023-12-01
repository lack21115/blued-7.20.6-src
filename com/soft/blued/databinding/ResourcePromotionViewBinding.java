package com.soft.blued.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/ResourcePromotionViewBinding.class */
public final class ResourcePromotionViewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final CardView f29578a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final SVGAImageView f29579c;
    private final FrameLayout d;

    private ResourcePromotionViewBinding(FrameLayout frameLayout, CardView cardView, ImageView imageView, SVGAImageView sVGAImageView) {
        this.d = frameLayout;
        this.f29578a = cardView;
        this.b = imageView;
        this.f29579c = sVGAImageView;
    }

    public static ResourcePromotionViewBinding a(View view) {
        String str;
        CardView cardView = (CardView) view.findViewById(R.id.cv_view);
        if (cardView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_resource_promotion_close);
            if (imageView != null) {
                SVGAImageView sVGAImageView = (SVGAImageView) view.findViewById(R.id.siv_resource_promotion);
                if (sVGAImageView != null) {
                    return new ResourcePromotionViewBinding((FrameLayout) view, cardView, imageView, sVGAImageView);
                }
                str = "sivResourcePromotion";
            } else {
                str = "ivResourcePromotionClose";
            }
        } else {
            str = "cvView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.d;
    }
}
