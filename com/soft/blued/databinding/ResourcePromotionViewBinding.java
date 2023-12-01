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
    public final CardView f15888a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final SVGAImageView f15889c;
    private final FrameLayout d;

    private ResourcePromotionViewBinding(FrameLayout frameLayout, CardView cardView, ImageView imageView, SVGAImageView sVGAImageView) {
        this.d = frameLayout;
        this.f15888a = cardView;
        this.b = imageView;
        this.f15889c = sVGAImageView;
    }

    public static ResourcePromotionViewBinding a(View view) {
        String str;
        CardView cardView = (CardView) view.findViewById(R.id.cv_view);
        if (cardView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_resource_promotion_close);
            if (imageView != null) {
                SVGAImageView findViewById = view.findViewById(R.id.siv_resource_promotion);
                if (findViewById != null) {
                    return new ResourcePromotionViewBinding((FrameLayout) view, cardView, imageView, findViewById);
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
