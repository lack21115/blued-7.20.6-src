package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewYySubscriptionLayoutBinding.class */
public final class ViewYySubscriptionLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f16962a;
    private final ShapeLinearLayout b;

    private ViewYySubscriptionLayoutBinding(ShapeLinearLayout shapeLinearLayout, ShapeTextView shapeTextView) {
        this.b = shapeLinearLayout;
        this.f16962a = shapeTextView;
    }

    public static ViewYySubscriptionLayoutBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_yy_subscription_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewYySubscriptionLayoutBinding a(View view) {
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_subscription);
        if (shapeTextView != null) {
            return new ViewYySubscriptionLayoutBinding((ShapeLinearLayout) view, shapeTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("tvSubscription"));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ShapeLinearLayout getRoot() {
        return this.b;
    }
}
