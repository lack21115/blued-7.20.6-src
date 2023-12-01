package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.module.common.view.TabPageIndicatorWithDot;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/DialogLivePocketBinding.class */
public final class DialogLivePocketBinding implements ViewBinding {
    public final LinearLayout a;
    public final LinearLayout b;
    public final TabPageIndicatorWithDot c;
    public final TextView d;
    public final View e;
    public final ViewPager f;
    private final FrameLayout g;

    private DialogLivePocketBinding(FrameLayout frameLayout, LinearLayout linearLayout, LinearLayout linearLayout2, TabPageIndicatorWithDot tabPageIndicatorWithDot, TextView textView, View view, ViewPager viewPager) {
        this.g = frameLayout;
        this.a = linearLayout;
        this.b = linearLayout2;
        this.c = tabPageIndicatorWithDot;
        this.d = textView;
        this.e = view;
        this.f = viewPager;
    }

    public static DialogLivePocketBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogLivePocketBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_live_pocket, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogLivePocketBinding a(View view) {
        String str;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_dialog_root);
        if (linearLayout != null) {
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_record);
            if (linearLayout2 != null) {
                TabPageIndicatorWithDot tabPageIndicatorWithDot = (TabPageIndicatorWithDot) view.findViewById(R.id.tab_layout);
                if (tabPageIndicatorWithDot != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_title);
                    if (textView != null) {
                        View findViewById = view.findViewById(R.id.view_bg_top);
                        if (findViewById != null) {
                            ViewPager findViewById2 = view.findViewById(R.id.view_pager);
                            if (findViewById2 != null) {
                                return new DialogLivePocketBinding((FrameLayout) view, linearLayout, linearLayout2, tabPageIndicatorWithDot, textView, findViewById, findViewById2);
                            }
                            str = "viewPager";
                        } else {
                            str = "viewBgTop";
                        }
                    } else {
                        str = "tvTitle";
                    }
                } else {
                    str = "tabLayout";
                }
            } else {
                str = "llRecord";
            }
        } else {
            str = "llDialogRoot";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.g;
    }
}
