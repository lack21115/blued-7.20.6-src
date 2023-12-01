package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveOperationBottomChildH5ViewBinding.class */
public final class LiveOperationBottomChildH5ViewBinding implements ViewBinding {
    public final ShapeRelativeLayout a;
    public final ImageView b;
    private final RelativeLayout c;

    private LiveOperationBottomChildH5ViewBinding(RelativeLayout relativeLayout, ShapeRelativeLayout shapeRelativeLayout, ImageView imageView) {
        this.c = relativeLayout;
        this.a = shapeRelativeLayout;
        this.b = imageView;
    }

    public static LiveOperationBottomChildH5ViewBinding a(View view) {
        String str;
        ShapeRelativeLayout shapeRelativeLayout = (ShapeRelativeLayout) view.findViewById(R.id.iv_h5_well_dot);
        if (shapeRelativeLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_icon);
            if (imageView != null) {
                return new LiveOperationBottomChildH5ViewBinding((RelativeLayout) view, shapeRelativeLayout, imageView);
            }
            str = "ivIcon";
        } else {
            str = "ivH5WellDot";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.c;
    }
}
