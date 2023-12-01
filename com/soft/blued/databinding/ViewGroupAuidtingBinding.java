package com.soft.blued.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/ViewGroupAuidtingBinding.class */
public final class ViewGroupAuidtingBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeFrameLayout f29619a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    private final ShapeFrameLayout f29620c;

    private ViewGroupAuidtingBinding(ShapeFrameLayout shapeFrameLayout, ShapeFrameLayout shapeFrameLayout2, TextView textView) {
        this.f29620c = shapeFrameLayout;
        this.f29619a = shapeFrameLayout2;
        this.b = textView;
    }

    public static ViewGroupAuidtingBinding a(View view) {
        String str;
        ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) view.findViewById(R.id.fm_auditing);
        if (shapeFrameLayout != null) {
            TextView textView = (TextView) view.findViewById(R.id.tv_auditing);
            if (textView != null) {
                return new ViewGroupAuidtingBinding((ShapeFrameLayout) view, shapeFrameLayout, textView);
            }
            str = "tvAuditing";
        } else {
            str = "fmAuditing";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ShapeFrameLayout getRoot() {
        return this.f29620c;
    }
}
