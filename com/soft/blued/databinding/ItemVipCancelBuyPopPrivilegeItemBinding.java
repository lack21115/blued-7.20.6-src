package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/ItemVipCancelBuyPopPrivilegeItemBinding.class */
public final class ItemVipCancelBuyPopPrivilegeItemBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f29349a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29350c;
    private final ShapeConstraintLayout d;

    private ItemVipCancelBuyPopPrivilegeItemBinding(ShapeConstraintLayout shapeConstraintLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.d = shapeConstraintLayout;
        this.f29349a = imageView;
        this.b = textView;
        this.f29350c = textView2;
    }

    public static ItemVipCancelBuyPopPrivilegeItemBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(2131365763);
        if (imageView != null) {
            TextView textView = (TextView) view.findViewById(2131372298);
            if (textView != null) {
                TextView textView2 = (TextView) view.findViewById(2131372299);
                if (textView2 != null) {
                    return new ItemVipCancelBuyPopPrivilegeItemBinding((ShapeConstraintLayout) view, imageView, textView, textView2);
                }
                str = "tvPrivilegeName";
            } else {
                str = "tvPrivilegeDesc";
            }
        } else {
            str = "ivPrivilege";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ShapeConstraintLayout getRoot() {
        return this.d;
    }
}
