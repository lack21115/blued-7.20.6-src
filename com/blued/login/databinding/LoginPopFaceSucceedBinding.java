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
    public final TextView f6923a;
    public final ShapeTextView b;

    /* renamed from: c  reason: collision with root package name */
    private final FrameLayout f6924c;

    private LoginPopFaceSucceedBinding(FrameLayout frameLayout, TextView textView, ShapeTextView shapeTextView) {
        this.f6924c = frameLayout;
        this.f6923a = textView;
        this.b = shapeTextView;
    }

    public static LoginPopFaceSucceedBinding a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.tv_hint);
        if (textView != null) {
            ShapeTextView findViewById = view.findViewById(R.id.tv_identify);
            if (findViewById != null) {
                return new LoginPopFaceSucceedBinding((FrameLayout) view, textView, findViewById);
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
        return this.f6924c;
    }
}
