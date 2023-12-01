package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewDailyPrizeBinding.class */
public final class ViewDailyPrizeBinding implements ViewBinding {
    public final ImageView a;
    public final FrameLayout b;
    public final ShapeTextView c;
    public final TextView d;
    private final LinearLayout e;

    private ViewDailyPrizeBinding(LinearLayout linearLayout, ImageView imageView, FrameLayout frameLayout, ShapeTextView shapeTextView, TextView textView) {
        this.e = linearLayout;
        this.a = imageView;
        this.b = frameLayout;
        this.c = shapeTextView;
        this.d = textView;
    }

    public static ViewDailyPrizeBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_daily_prize, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewDailyPrizeBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.btn_got);
        if (imageView != null) {
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_prize_view);
            if (frameLayout != null) {
                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.img_done);
                if (shapeTextView != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_task_value);
                    if (textView != null) {
                        return new ViewDailyPrizeBinding((LinearLayout) view, imageView, frameLayout, shapeTextView, textView);
                    }
                    str = "tvTaskValue";
                } else {
                    str = "imgDone";
                }
            } else {
                str = "flPrizeView";
            }
        } else {
            str = "btnGot";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.e;
    }
}
