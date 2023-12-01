package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveRechargeGiftBagViewBinding.class */
public final class LiveRechargeGiftBagViewBinding implements ViewBinding {
    public final ImageView a;
    private final RelativeLayout b;

    private LiveRechargeGiftBagViewBinding(RelativeLayout relativeLayout, ImageView imageView) {
        this.b = relativeLayout;
        this.a = imageView;
    }

    public static LiveRechargeGiftBagViewBinding a(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_gift_bag);
        if (imageView != null) {
            return new LiveRechargeGiftBagViewBinding((RelativeLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("ivGiftBag"));
    }

    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.b;
    }
}
