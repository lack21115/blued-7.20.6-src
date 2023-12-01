package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewYyConsumptionBinding.class */
public final class ViewYyConsumptionBinding implements ViewBinding {
    public final TextView a;
    public final ShapeTextView b;
    public final TextView c;
    private final LinearLayout d;

    private ViewYyConsumptionBinding(LinearLayout linearLayout, TextView textView, ShapeTextView shapeTextView, TextView textView2) {
        this.d = linearLayout;
        this.a = textView;
        this.b = shapeTextView;
        this.c = textView2;
    }

    public static ViewYyConsumptionBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_yy_consumption, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewYyConsumptionBinding a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.tv_consumption_gap);
        if (textView != null) {
            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_consumption_total);
            if (shapeTextView != null) {
                TextView textView2 = (TextView) view.findViewById(R.id.tv_min_consumption);
                if (textView2 != null) {
                    return new ViewYyConsumptionBinding((LinearLayout) view, textView, shapeTextView, textView2);
                }
                str = "tvMinConsumption";
            } else {
                str = "tvConsumptionTotal";
            }
        } else {
            str = "tvConsumptionGap";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.d;
    }
}
