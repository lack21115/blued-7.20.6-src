package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewHeartBoyLayoutBinding.class */
public final class ViewHeartBoyLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f16854a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f16855c;
    public final TextView d;
    public final TextView e;
    private final ConstraintLayout f;

    private ViewHeartBoyLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout2, TextView textView, TextView textView2) {
        this.f = constraintLayout;
        this.f16854a = imageView;
        this.b = imageView2;
        this.f16855c = constraintLayout2;
        this.d = textView;
        this.e = textView2;
    }

    public static ViewHeartBoyLayoutBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_heart_boy_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewHeartBoyLayoutBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.img_bg_view);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.img_light);
            if (imageView2 != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.root_view);
                if (constraintLayout != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_light_text);
                    if (textView != null) {
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_light_timer);
                        if (textView2 != null) {
                            return new ViewHeartBoyLayoutBinding((ConstraintLayout) view, imageView, imageView2, constraintLayout, textView, textView2);
                        }
                        str = "tvLightTimer";
                    } else {
                        str = "tvLightText";
                    }
                } else {
                    str = "rootView";
                }
            } else {
                str = "imgLight";
            }
        } else {
            str = "imgBgView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f;
    }
}
