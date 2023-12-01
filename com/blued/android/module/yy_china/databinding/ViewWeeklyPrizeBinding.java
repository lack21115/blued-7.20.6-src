package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.DailyPrizeView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewWeeklyPrizeBinding.class */
public final class ViewWeeklyPrizeBinding implements ViewBinding {
    public final DailyPrizeView a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    private final LinearLayout f;

    private ViewWeeklyPrizeBinding(LinearLayout linearLayout, DailyPrizeView dailyPrizeView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f = linearLayout;
        this.a = dailyPrizeView;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
        this.e = textView4;
    }

    public static ViewWeeklyPrizeBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_weekly_prize, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewWeeklyPrizeBinding a(View view) {
        String str;
        DailyPrizeView dailyPrizeView = (DailyPrizeView) view.findViewById(R.id.prize_view);
        if (dailyPrizeView != null) {
            TextView textView = (TextView) view.findViewById(R.id.tv_can_got);
            if (textView != null) {
                TextView textView2 = (TextView) view.findViewById(R.id.tv_current_value);
                if (textView2 != null) {
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_min_value);
                    if (textView3 != null) {
                        TextView textView4 = (TextView) view.findViewById(R.id.tv_small_prize);
                        if (textView4 != null) {
                            return new ViewWeeklyPrizeBinding((LinearLayout) view, dailyPrizeView, textView, textView2, textView3, textView4);
                        }
                        str = "tvSmallPrize";
                    } else {
                        str = "tvMinValue";
                    }
                } else {
                    str = "tvCurrentValue";
                }
            } else {
                str = "tvCanGot";
            }
        } else {
            str = "prizeView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.f;
    }
}
