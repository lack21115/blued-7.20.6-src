package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/ItemMineHealthEntryExperienceMidChildBinding.class */
public final class ItemMineHealthEntryExperienceMidChildBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeConstraintLayout f29229a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29230c;
    private final ShapeConstraintLayout d;

    private ItemMineHealthEntryExperienceMidChildBinding(ShapeConstraintLayout shapeConstraintLayout, ShapeConstraintLayout shapeConstraintLayout2, ImageView imageView, TextView textView) {
        this.d = shapeConstraintLayout;
        this.f29229a = shapeConstraintLayout2;
        this.b = imageView;
        this.f29230c = textView;
    }

    public static ItemMineHealthEntryExperienceMidChildBinding a(View view) {
        String str;
        ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(2131363075);
        if (shapeConstraintLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(2131365504);
            if (imageView != null) {
                TextView textView = (TextView) view.findViewById(2131372754);
                if (textView != null) {
                    return new ItemMineHealthEntryExperienceMidChildBinding((ShapeConstraintLayout) view, shapeConstraintLayout, imageView, textView);
                }
                str = "tvTitle";
            } else {
                str = "ivIcon";
            }
        } else {
            str = "contentView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ShapeConstraintLayout getRoot() {
        return this.d;
    }
}
