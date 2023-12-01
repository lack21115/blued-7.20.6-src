package com.blued.android.module.yy_china.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.ban.BGABanner;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyHomeRoomsBannerBinding.class */
public final class ItemYyHomeRoomsBannerBinding implements ViewBinding {
    public final BGABanner a;
    private final ConstraintLayout b;

    private ItemYyHomeRoomsBannerBinding(ConstraintLayout constraintLayout, BGABanner bGABanner) {
        this.b = constraintLayout;
        this.a = bGABanner;
    }

    public static ItemYyHomeRoomsBannerBinding a(View view) {
        BGABanner bGABanner = (BGABanner) view.findViewById(R.id.banner);
        if (bGABanner != null) {
            return new ItemYyHomeRoomsBannerBinding((ConstraintLayout) view, bGABanner);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("banner"));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.b;
    }
}
