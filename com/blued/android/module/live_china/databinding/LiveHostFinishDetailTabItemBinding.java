package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveHostFinishDetailTabItemBinding.class */
public final class LiveHostFinishDetailTabItemBinding implements ViewBinding {
    public final ShapeFrameLayout a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    private final ShapeFrameLayout e;

    private LiveHostFinishDetailTabItemBinding(ShapeFrameLayout shapeFrameLayout, ShapeFrameLayout shapeFrameLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.e = shapeFrameLayout;
        this.a = shapeFrameLayout2;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
    }

    public static LiveHostFinishDetailTabItemBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static LiveHostFinishDetailTabItemBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.live_host_finish_detail_tab_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LiveHostFinishDetailTabItemBinding a(View view) {
        String str;
        ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) view.findViewById(R.id.sl_select);
        if (shapeFrameLayout != null) {
            TextView textView = (TextView) view.findViewById(R.id.tv_name);
            if (textView != null) {
                TextView textView2 = (TextView) view.findViewById(R.id.tv_name_1);
                if (textView2 != null) {
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_num);
                    if (textView3 != null) {
                        return new LiveHostFinishDetailTabItemBinding((ShapeFrameLayout) view, shapeFrameLayout, textView, textView2, textView3);
                    }
                    str = "tvNum";
                } else {
                    str = "tvName1";
                }
            } else {
                str = "tvName";
            }
        } else {
            str = "slSelect";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ShapeFrameLayout getRoot() {
        return this.e;
    }
}
