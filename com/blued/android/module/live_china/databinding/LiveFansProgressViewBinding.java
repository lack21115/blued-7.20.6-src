package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveFansProgressViewBinding.class */
public final class LiveFansProgressViewBinding implements ViewBinding {
    public final LinearLayout a;
    public final ShapeTextView b;
    public final ShapeTextView c;
    public final ImageView d;
    public final ProgressBar e;
    public final ShapeTextView f;
    private final LinearLayout g;

    private LiveFansProgressViewBinding(LinearLayout linearLayout, LinearLayout linearLayout2, ShapeTextView shapeTextView, ShapeTextView shapeTextView2, ImageView imageView, ProgressBar progressBar, ShapeTextView shapeTextView3) {
        this.g = linearLayout;
        this.a = linearLayout2;
        this.b = shapeTextView;
        this.c = shapeTextView2;
        this.d = imageView;
        this.e = progressBar;
        this.f = shapeTextView3;
    }

    public static LiveFansProgressViewBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.live_fans_progress_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LiveFansProgressViewBinding a(View view) {
        String str;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.fl_root);
        if (linearLayout != null) {
            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_dot);
            if (shapeTextView != null) {
                ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_level);
                if (shapeTextView2 != null) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.tv_point);
                    if (imageView != null) {
                        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.tv_progress);
                        if (progressBar != null) {
                            ShapeTextView shapeTextView3 = (ShapeTextView) view.findViewById(R.id.tv_progress_value);
                            if (shapeTextView3 != null) {
                                return new LiveFansProgressViewBinding((LinearLayout) view, linearLayout, shapeTextView, shapeTextView2, imageView, progressBar, shapeTextView3);
                            }
                            str = "tvProgressValue";
                        } else {
                            str = "tvProgress";
                        }
                    } else {
                        str = "tvPoint";
                    }
                } else {
                    str = "tvLevel";
                }
            } else {
                str = "tvDot";
            }
        } else {
            str = "flRoot";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.g;
    }
}
