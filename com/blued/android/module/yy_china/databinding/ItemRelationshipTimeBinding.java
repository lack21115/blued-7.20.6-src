package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemRelationshipTimeBinding.class */
public final class ItemRelationshipTimeBinding implements ViewBinding {
    public final ShapeTextView a;
    private final RelativeLayout b;

    private ItemRelationshipTimeBinding(RelativeLayout relativeLayout, ShapeTextView shapeTextView) {
        this.b = relativeLayout;
        this.a = shapeTextView;
    }

    public static ItemRelationshipTimeBinding a(View view) {
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_time);
        if (shapeTextView != null) {
            return new ItemRelationshipTimeBinding((RelativeLayout) view, shapeTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("tvTime"));
    }

    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.b;
    }
}
