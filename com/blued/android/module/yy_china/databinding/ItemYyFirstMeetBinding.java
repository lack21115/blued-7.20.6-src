package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyFirstMeetBinding.class */
public final class ItemYyFirstMeetBinding implements ViewBinding {
    public final ShapeConstraintLayout a;
    private final LinearLayout b;

    private ItemYyFirstMeetBinding(LinearLayout linearLayout, ShapeConstraintLayout shapeConstraintLayout) {
        this.b = linearLayout;
        this.a = shapeConstraintLayout;
    }

    public static ItemYyFirstMeetBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_yy_first_meet, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ItemYyFirstMeetBinding a(View view) {
        ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.fl_main);
        if (shapeConstraintLayout != null) {
            return new ItemYyFirstMeetBinding((LinearLayout) view, shapeConstraintLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("flMain"));
    }

    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.b;
    }
}
