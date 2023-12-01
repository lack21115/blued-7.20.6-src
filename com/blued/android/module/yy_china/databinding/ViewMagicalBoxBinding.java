package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewMagicalBoxBinding.class */
public final class ViewMagicalBoxBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f16869a;
    public final ConstraintLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final ProgressBar f16870c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    private final ConstraintLayout h;

    private ViewMagicalBoxBinding(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, ProgressBar progressBar, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.h = constraintLayout;
        this.f16869a = imageView;
        this.b = constraintLayout2;
        this.f16870c = progressBar;
        this.d = textView;
        this.e = textView2;
        this.f = textView3;
        this.g = textView4;
    }

    public static ViewMagicalBoxBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_magical_box, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewMagicalBoxBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_magical_box);
        if (imageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.ll_box_info);
            if (constraintLayout != null) {
                ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
                if (progressBar != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_box_name);
                    if (textView != null) {
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_fall_down_time);
                        if (textView2 != null) {
                            TextView textView3 = (TextView) view.findViewById(R.id.tv_got_beans);
                            if (textView3 != null) {
                                TextView textView4 = (TextView) view.findViewById(R.id.tv_total_beans);
                                if (textView4 != null) {
                                    return new ViewMagicalBoxBinding((ConstraintLayout) view, imageView, constraintLayout, progressBar, textView, textView2, textView3, textView4);
                                }
                                str = "tvTotalBeans";
                            } else {
                                str = "tvGotBeans";
                            }
                        } else {
                            str = "tvFallDownTime";
                        }
                    } else {
                        str = "tvBoxName";
                    }
                } else {
                    str = "progressBar";
                }
            } else {
                str = "llBoxInfo";
            }
        } else {
            str = "ivMagicalBox";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.h;
    }
}
