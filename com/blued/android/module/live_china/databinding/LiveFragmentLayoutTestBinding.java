package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveFragmentLayoutTestBinding.class */
public final class LiveFragmentLayoutTestBinding implements ViewBinding {
    public final LinearLayout a;
    public final TextView b;
    public final TextView c;
    public final RelativeLayout d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final ViewPager h;
    private final ConstraintLayout i;

    private LiveFragmentLayoutTestBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, TextView textView, TextView textView2, RelativeLayout relativeLayout, TextView textView3, TextView textView4, TextView textView5, ViewPager viewPager) {
        this.i = constraintLayout;
        this.a = linearLayout;
        this.b = textView;
        this.c = textView2;
        this.d = relativeLayout;
        this.e = textView3;
        this.f = textView4;
        this.g = textView5;
        this.h = viewPager;
    }

    public static LiveFragmentLayoutTestBinding a(View view) {
        String str;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_view);
        if (linearLayout != null) {
            TextView textView = (TextView) view.findViewById(R.id.name);
            if (textView != null) {
                TextView textView2 = (TextView) view.findViewById(R.id.open_live);
                if (textView2 != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.title);
                    if (relativeLayout != null) {
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_exit);
                        if (textView3 != null) {
                            TextView textView4 = (TextView) view.findViewById(R.id.tv_follow);
                            if (textView4 != null) {
                                TextView textView5 = (TextView) view.findViewById(R.id.tv_hot);
                                if (textView5 != null) {
                                    ViewPager findViewById = view.findViewById(R.id.view_pager);
                                    if (findViewById != null) {
                                        return new LiveFragmentLayoutTestBinding((ConstraintLayout) view, linearLayout, textView, textView2, relativeLayout, textView3, textView4, textView5, findViewById);
                                    }
                                    str = "viewPager";
                                } else {
                                    str = "tvHot";
                                }
                            } else {
                                str = "tvFollow";
                            }
                        } else {
                            str = "tvExit";
                        }
                    } else {
                        str = "title";
                    }
                } else {
                    str = "openLive";
                }
            } else {
                str = "name";
            }
        } else {
            str = "llView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.i;
    }
}
