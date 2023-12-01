package com.blued.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/ItemNearbyViewFlipperBinding.class */
public final class ItemNearbyViewFlipperBinding implements ViewBinding {
    public final ImageView a;
    public final ViewFlipper b;
    private final CardView c;

    private ItemNearbyViewFlipperBinding(CardView cardView, ImageView imageView, ViewFlipper viewFlipper) {
        this.c = cardView;
        this.a = imageView;
        this.b = viewFlipper;
    }

    public static ItemNearbyViewFlipperBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static ItemNearbyViewFlipperBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_nearby_view_flipper, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ItemNearbyViewFlipperBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_bg);
        if (imageView != null) {
            ViewFlipper viewFlipper = (ViewFlipper) view.findViewById(R.id.view_flipper);
            if (viewFlipper != null) {
                return new ItemNearbyViewFlipperBinding((CardView) view, imageView, viewFlipper);
            }
            str = "viewFlipper";
        } else {
            str = "ivBg";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public CardView getRoot() {
        return this.c;
    }
}
