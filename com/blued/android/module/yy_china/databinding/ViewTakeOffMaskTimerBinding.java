package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewTakeOffMaskTimerBinding.class */
public final class ViewTakeOffMaskTimerBinding implements ViewBinding {
    public final TextView a;
    public final TextView b;
    private final ConstraintLayout c;

    private ViewTakeOffMaskTimerBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        this.c = constraintLayout;
        this.a = textView;
        this.b = textView2;
    }

    public static ViewTakeOffMaskTimerBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_take_off_mask_timer, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewTakeOffMaskTimerBinding a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.tv_timer_num);
        if (textView != null) {
            TextView textView2 = (TextView) view.findViewById(R.id.tv_timer_text);
            if (textView2 != null) {
                return new ViewTakeOffMaskTimerBinding((ConstraintLayout) view, textView, textView2);
            }
            str = "tvTimerText";
        } else {
            str = "tvTimerNum";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.c;
    }
}
