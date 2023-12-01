package com.blued.android.module.common.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/databinding/PopGuideCommonBinding.class */
public final class PopGuideCommonBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f10749a;
    public final LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f10750c;
    private final LinearLayout d;

    private PopGuideCommonBinding(LinearLayout linearLayout, FrameLayout frameLayout, LinearLayout linearLayout2, TextView textView) {
        this.d = linearLayout;
        this.f10749a = frameLayout;
        this.b = linearLayout2;
        this.f10750c = textView;
    }

    public static PopGuideCommonBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.bubble);
        if (frameLayout != null) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.rootView);
            if (linearLayout != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_hint);
                if (textView != null) {
                    return new PopGuideCommonBinding((LinearLayout) view, frameLayout, linearLayout, textView);
                }
                str = "tvHint";
            } else {
                str = "rootView";
            }
        } else {
            str = "bubble";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.d;
    }
}
