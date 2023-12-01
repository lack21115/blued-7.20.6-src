package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogMedalInfoBinding.class */
public final class DialogMedalInfoBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f16364a;
    public final ViewPager b;

    /* renamed from: c  reason: collision with root package name */
    private final FrameLayout f16365c;

    private DialogMedalInfoBinding(FrameLayout frameLayout, FrameLayout frameLayout2, ViewPager viewPager) {
        this.f16365c = frameLayout;
        this.f16364a = frameLayout2;
        this.b = viewPager;
    }

    public static DialogMedalInfoBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.con);
        if (frameLayout != null) {
            ViewPager viewPager = (ViewPager) view.findViewById(R.id.vp);
            if (viewPager != null) {
                return new DialogMedalInfoBinding((FrameLayout) view, frameLayout, viewPager);
            }
            str = "vp";
        } else {
            str = "con";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.f16365c;
    }
}
