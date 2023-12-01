package com.blued.login.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.login.R;

/* loaded from: source-7206380-dex2jar.jar:com/blued/login/databinding/LoginPopFaceSucceedBinding.class */
public final class LoginPopFaceSucceedBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f20529a;
    public final ShapeTextView b;

    /* renamed from: c  reason: collision with root package name */
    private final FrameLayout f20530c;

    private LoginPopFaceSucceedBinding(FrameLayout frameLayout, TextView textView, ShapeTextView shapeTextView) {
        this.f20530c = frameLayout;
        this.f20529a = textView;
        this.b = shapeTextView;
    }

    public static LoginPopFaceSucceedBinding a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.tv_hint);
        if (textView != null) {
            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_identify);
            if (shapeTextView != null) {
                return new LoginPopFaceSucceedBinding((FrameLayout) view, textView, shapeTextView);
            }
            str = "tvIdentify";
        } else {
            str = "tvHint";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.f20530c;
    }
}
