package com.blued.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/ItemNearbyTransformersFlipperEventBinding.class */
public final class ItemNearbyTransformersFlipperEventBinding implements ViewBinding {
    public final ImageView a;
    private final FrameLayout b;

    private ItemNearbyTransformersFlipperEventBinding(FrameLayout frameLayout, ImageView imageView) {
        this.b = frameLayout;
        this.a = imageView;
    }

    public static ItemNearbyTransformersFlipperEventBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static ItemNearbyTransformersFlipperEventBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_nearby_transformers_flipper_event, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ItemNearbyTransformersFlipperEventBinding a(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_header);
        if (imageView != null) {
            return new ItemNearbyTransformersFlipperEventBinding((FrameLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("ivHeader"));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.b;
    }
}
