package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.TabPageIndicatorWithDot;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveHostFinishDetailLayoutBinding.class */
public final class LiveHostFinishDetailLayoutBinding implements ViewBinding {
    public final TabPageIndicatorWithDot a;
    public final ShapeLinearLayout b;
    public final ShapeTextView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final ViewPager g;
    private final LinearLayout h;

    private LiveHostFinishDetailLayoutBinding(LinearLayout linearLayout, TabPageIndicatorWithDot tabPageIndicatorWithDot, ShapeLinearLayout shapeLinearLayout, ShapeTextView shapeTextView, TextView textView, TextView textView2, TextView textView3, ViewPager viewPager) {
        this.h = linearLayout;
        this.a = tabPageIndicatorWithDot;
        this.b = shapeLinearLayout;
        this.c = shapeTextView;
        this.d = textView;
        this.e = textView2;
        this.f = textView3;
        this.g = viewPager;
    }

    public static LiveHostFinishDetailLayoutBinding a(View view) {
        String str;
        TabPageIndicatorWithDot tabPageIndicatorWithDot = (TabPageIndicatorWithDot) view.findViewById(R.id.indicator_label);
        if (tabPageIndicatorWithDot != null) {
            ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.main_view);
            if (shapeLinearLayout != null) {
                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_atten);
                if (shapeTextView != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_lable_name);
                    if (textView != null) {
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_look_tip);
                        if (textView2 != null) {
                            TextView textView3 = (TextView) view.findViewById(R.id.tv_tip);
                            if (textView3 != null) {
                                ViewPager findViewById = view.findViewById(R.id.view_pager);
                                if (findViewById != null) {
                                    return new LiveHostFinishDetailLayoutBinding((LinearLayout) view, tabPageIndicatorWithDot, shapeLinearLayout, shapeTextView, textView, textView2, textView3, findViewById);
                                }
                                str = "viewPager";
                            } else {
                                str = "tvTip";
                            }
                        } else {
                            str = "tvLookTip";
                        }
                    } else {
                        str = "tvLableName";
                    }
                } else {
                    str = "tvAtten";
                }
            } else {
                str = "mainView";
            }
        } else {
            str = "indicatorLabel";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.h;
    }
}
