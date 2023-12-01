package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemRoomPkTimeBinding.class */
public final class ItemRoomPkTimeBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f16657a;
    private final RelativeLayout b;

    private ItemRoomPkTimeBinding(RelativeLayout relativeLayout, ShapeTextView shapeTextView) {
        this.b = relativeLayout;
        this.f16657a = shapeTextView;
    }

    public static ItemRoomPkTimeBinding a(View view) {
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_pk_time);
        if (shapeTextView != null) {
            return new ItemRoomPkTimeBinding((RelativeLayout) view, shapeTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("tvPkTime"));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.b;
    }
}
