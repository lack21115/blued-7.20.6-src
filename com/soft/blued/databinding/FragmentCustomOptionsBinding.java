package com.soft.blued.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ToggleButton;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/FragmentCustomOptionsBinding.class */
public final class FragmentCustomOptionsBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f28806a;
    public final ToggleButton b;

    /* renamed from: c  reason: collision with root package name */
    public final CommonTopTitleNoTrans f28807c;
    private final LinearLayout d;

    private FragmentCustomOptionsBinding(LinearLayout linearLayout, LinearLayout linearLayout2, ToggleButton toggleButton, CommonTopTitleNoTrans commonTopTitleNoTrans) {
        this.d = linearLayout;
        this.f28806a = linearLayout2;
        this.b = toggleButton;
        this.f28807c = commonTopTitleNoTrans;
    }

    public static FragmentCustomOptionsBinding a(View view) {
        String str;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_privacy_name);
        if (linearLayout != null) {
            ToggleButton toggleButton = (ToggleButton) view.findViewById(R.id.tglbtnCustomRecommend);
            if (toggleButton != null) {
                CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) view.findViewById(2131370694);
                if (commonTopTitleNoTrans != null) {
                    return new FragmentCustomOptionsBinding((LinearLayout) view, linearLayout, toggleButton, commonTopTitleNoTrans);
                }
                str = "title";
            } else {
                str = "tglbtnCustomRecommend";
            }
        } else {
            str = "llPrivacyName";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.d;
    }
}
