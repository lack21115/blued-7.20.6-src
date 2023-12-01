package com.blued.login.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.login.R;
import com.blued.login.view.TagIndicator;
import com.blued.login.view.TagViewPager;

/* loaded from: source-7206380-dex2jar.jar:com/blued/login/databinding/LoginFmSetTagBinding.class */
public final class LoginFmSetTagBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f6921a;
    public final TagIndicator b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f6922c;
    public final TagViewPager d;
    private final ConstraintLayout e;

    private LoginFmSetTagBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, TagIndicator tagIndicator, TextView textView, TagViewPager tagViewPager) {
        this.e = constraintLayout;
        this.f6921a = linearLayout;
        this.b = tagIndicator;
        this.f6922c = textView;
        this.d = tagViewPager;
    }

    public static LoginFmSetTagBinding a(View view) {
        String str;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_title);
        if (linearLayout != null) {
            TagIndicator tagIndicator = (TagIndicator) view.findViewById(R.id.lpi_line);
            if (tagIndicator != null) {
                TextView textView = (TextView) view.findViewById(R.id.skipped);
                if (textView != null) {
                    TagViewPager tagViewPager = (TagViewPager) view.findViewById(R.id.viewPager);
                    if (tagViewPager != null) {
                        return new LoginFmSetTagBinding((ConstraintLayout) view, linearLayout, tagIndicator, textView, tagViewPager);
                    }
                    str = "viewPager";
                } else {
                    str = "skipped";
                }
            } else {
                str = "lpiLine";
            }
        } else {
            str = "llTitle";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.e;
    }
}
