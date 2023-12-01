package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/ItemVipCancelBuyPopPrivilegeItemBinding.class */
public final class ItemVipCancelBuyPopPrivilegeItemBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f15659a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f15660c;
    private final ShapeConstraintLayout d;

    private ItemVipCancelBuyPopPrivilegeItemBinding(ShapeConstraintLayout shapeConstraintLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.d = shapeConstraintLayout;
        this.f15659a = imageView;
        this.b = textView;
        this.f15660c = textView2;
    }

    public static ItemVipCancelBuyPopPrivilegeItemBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_privilege);
        if (imageView != null) {
            TextView textView = (TextView) view.findViewById(R.id.tv_privilege_desc);
            if (textView != null) {
                TextView textView2 = (TextView) view.findViewById(R.id.tv_privilege_name);
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
