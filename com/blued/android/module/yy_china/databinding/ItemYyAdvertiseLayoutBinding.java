package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.ban.BGABanner;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyAdvertiseLayoutBinding.class */
public final class ItemYyAdvertiseLayoutBinding implements ViewBinding {
    public final BGABanner a;
    private final FrameLayout b;

    private ItemYyAdvertiseLayoutBinding(FrameLayout frameLayout, BGABanner bGABanner) {
        this.b = frameLayout;
        this.a = bGABanner;
    }

    public static ItemYyAdvertiseLayoutBinding a(View view) {
        BGABanner bGABanner = (BGABanner) view.findViewById(R.id.banner);
        if (bGABanner != null) {
            return new ItemYyAdvertiseLayoutBinding((FrameLayout) view, bGABanner);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("banner"));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.b;
    }
}
