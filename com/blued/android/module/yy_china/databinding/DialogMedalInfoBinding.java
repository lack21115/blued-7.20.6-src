package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogMedalInfoBinding.class */
public final class DialogMedalInfoBinding implements ViewBinding {
    public final FrameLayout a;
    public final ViewPager b;
    private final FrameLayout c;

    private DialogMedalInfoBinding(FrameLayout frameLayout, FrameLayout frameLayout2, ViewPager viewPager) {
        this.c = frameLayout;
        this.a = frameLayout2;
        this.b = viewPager;
    }

    public static DialogMedalInfoBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.con);
        if (frameLayout != null) {
            ViewPager findViewById = view.findViewById(R.id.vp);
            if (findViewById != null) {
                return new DialogMedalInfoBinding((FrameLayout) view, frameLayout, findViewById);
            }
            str = "vp";
        } else {
            str = "con";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.c;
    }
}
