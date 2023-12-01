package com.blued.login.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.login.R;

/* loaded from: source-7206380-dex2jar.jar:com/blued/login/databinding/PopOtherLoginBinding.class */
public final class PopOtherLoginBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f20533a;
    private final FrameLayout b;

    private PopOtherLoginBinding(FrameLayout frameLayout, TextView textView) {
        this.b = frameLayout;
        this.f20533a = textView;
    }

    public static PopOtherLoginBinding a(View view) {
        TextView textView = (TextView) view.findViewById(R.id.tv_email);
        if (textView != null) {
            return new PopOtherLoginBinding((FrameLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("tvEmail"));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.b;
    }
}
