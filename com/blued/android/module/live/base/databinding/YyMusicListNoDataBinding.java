package com.blued.android.module.live.base.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/databinding/YyMusicListNoDataBinding.class */
public final class YyMusicListNoDataBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11402a;

    private YyMusicListNoDataBinding(LinearLayout linearLayout) {
        this.f11402a = linearLayout;
    }

    public static YyMusicListNoDataBinding a(View view) {
        if (view != null) {
            return new YyMusicListNoDataBinding((LinearLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.f11402a;
    }
}
