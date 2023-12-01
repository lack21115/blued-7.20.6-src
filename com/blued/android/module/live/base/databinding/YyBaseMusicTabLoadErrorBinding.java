package com.blued.android.module.live.base.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live.base.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/databinding/YyBaseMusicTabLoadErrorBinding.class */
public final class YyBaseMusicTabLoadErrorBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f11400a;
    private final FrameLayout b;

    private YyBaseMusicTabLoadErrorBinding(FrameLayout frameLayout, ShapeTextView shapeTextView) {
        this.b = frameLayout;
        this.f11400a = shapeTextView;
    }

    public static YyBaseMusicTabLoadErrorBinding a(View view) {
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_reload);
        if (shapeTextView != null) {
            return new YyBaseMusicTabLoadErrorBinding((FrameLayout) view, shapeTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("tvReload"));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.b;
    }
}
