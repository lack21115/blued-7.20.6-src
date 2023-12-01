package com.blued.android.module.live.base.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/databinding/YyMusicSearchNoDataBinding.class */
public final class YyMusicSearchNoDataBinding implements ViewBinding {
    private final LinearLayout a;

    private YyMusicSearchNoDataBinding(LinearLayout linearLayout) {
        this.a = linearLayout;
    }

    public static YyMusicSearchNoDataBinding a(View view) {
        if (view != null) {
            return new YyMusicSearchNoDataBinding((LinearLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.a;
    }
}
