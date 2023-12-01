package com.soft.blued.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.web.library.groups.webviewsdk.core.WMWebView;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/FragmentWmDetailBinding.class */
public final class FragmentWmDetailBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final WMWebView f15353a;
    private final LinearLayout b;

    private FragmentWmDetailBinding(LinearLayout linearLayout, WMWebView wMWebView) {
        this.b = linearLayout;
        this.f15353a = wMWebView;
    }

    public static FragmentWmDetailBinding a(View view) {
        WMWebView wMWebView = (WMWebView) view.findViewById(2131373384);
        if (wMWebView != null) {
            return new FragmentWmDetailBinding((LinearLayout) view, wMWebView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("webView"));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.b;
    }
}
