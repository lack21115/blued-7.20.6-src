package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.HollowView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyRoomSettingLaberBinding.class */
public final class ItemYyRoomSettingLaberBinding implements ViewBinding {
    public final ShapeTextView a;
    public final HollowView b;
    private final FrameLayout c;

    private ItemYyRoomSettingLaberBinding(FrameLayout frameLayout, ShapeTextView shapeTextView, HollowView hollowView) {
        this.c = frameLayout;
        this.a = shapeTextView;
        this.b = hollowView;
    }

    public static ItemYyRoomSettingLaberBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_type);
        if (shapeTextView != null) {
            HollowView hollowView = (HollowView) view.findViewById(R.id.view_border);
            if (hollowView != null) {
                return new ItemYyRoomSettingLaberBinding((FrameLayout) view, shapeTextView, hollowView);
            }
            str = "viewBorder";
        } else {
            str = "tvType";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.c;
    }
}
