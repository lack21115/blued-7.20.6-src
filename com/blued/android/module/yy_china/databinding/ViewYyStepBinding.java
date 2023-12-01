package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewYyStepBinding.class */
public final class ViewYyStepBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f16960a;
    public final View b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f16961c;
    public final View d;
    public final TextView e;
    private final ConstraintLayout f;

    private ViewYyStepBinding(ConstraintLayout constraintLayout, View view, View view2, ImageView imageView, View view3, TextView textView) {
        this.f = constraintLayout;
        this.f16960a = view;
        this.b = view2;
        this.f16961c = imageView;
        this.d = view3;
        this.e = textView;
    }

    public static ViewYyStepBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_yy_step, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewYyStepBinding a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.pink_space_view);
        if (findViewById != null) {
            View findViewById2 = view.findViewById(R.id.space_view);
            if (findViewById2 != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.step_line);
                if (imageView != null) {
                    View findViewById3 = view.findViewById(R.id.step_line_pink);
                    if (findViewById3 != null) {
                        TextView textView = (TextView) view.findViewById(R.id.step_name);
                        if (textView != null) {
                            return new ViewYyStepBinding((ConstraintLayout) view, findViewById, findViewById2, imageView, findViewById3, textView);
                        }
                        str = "stepName";
                    } else {
                        str = "stepLinePink";
                    }
                } else {
                    str = "stepLine";
                }
            } else {
                str = "spaceView";
            }
        } else {
            str = "pinkSpaceView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f;
    }
}
