package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentYyBackgroundMusicBinding.class */
public final class FragmentYyBackgroundMusicBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f16491a;
    private final LinearLayout b;

    private FragmentYyBackgroundMusicBinding(LinearLayout linearLayout, LinearLayout linearLayout2) {
        this.b = linearLayout;
        this.f16491a = linearLayout2;
    }

    public static FragmentYyBackgroundMusicBinding a(View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll);
        if (linearLayout != null) {
            return new FragmentYyBackgroundMusicBinding((LinearLayout) view, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("ll"));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.b;
    }
}
