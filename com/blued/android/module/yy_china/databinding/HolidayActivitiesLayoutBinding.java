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

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/HolidayActivitiesLayoutBinding.class */
public final class HolidayActivitiesLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ProgressBar f16557a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f16558c;
    private final ConstraintLayout d;

    private HolidayActivitiesLayoutBinding(ConstraintLayout constraintLayout, ProgressBar progressBar, ImageView imageView, TextView textView) {
        this.d = constraintLayout;
        this.f16557a = progressBar;
        this.b = imageView;
        this.f16558c = textView;
    }

    public static HolidayActivitiesLayoutBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holiday_activities_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static HolidayActivitiesLayoutBinding a(View view) {
        String str;
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.activities_progress_bar);
        if (progressBar != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.img_activity_entrance);
            if (imageView != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_progress);
                if (textView != null) {
                    return new HolidayActivitiesLayoutBinding((ConstraintLayout) view, progressBar, imageView, textView);
                }
                str = "tvProgress";
            } else {
                str = "imgActivityEntrance";
            }
        } else {
            str = "activitiesProgressBar";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.d;
    }
}
