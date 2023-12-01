package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.module.yy_china.R;
import com.google.android.material.imageview.ShapeableImageView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewHostUpBinding.class */
public final class ViewHostUpBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeableImageView f16856a;
    public final ShapeConstraintLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f16857c;
    public final TextView d;
    private final ConstraintLayout e;

    private ViewHostUpBinding(ConstraintLayout constraintLayout, ShapeableImageView shapeableImageView, ShapeConstraintLayout shapeConstraintLayout, LinearLayout linearLayout, TextView textView) {
        this.e = constraintLayout;
        this.f16856a = shapeableImageView;
        this.b = shapeConstraintLayout;
        this.f16857c = linearLayout;
        this.d = textView;
    }

    public static ViewHostUpBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_host_up, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewHostUpBinding a(View view) {
        String str;
        ShapeableImageView shapeableImageView = (ShapeableImageView) view.findViewById(R.id.iv);
        if (shapeableImageView != null) {
            ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.sha_con);
            if (shapeConstraintLayout != null) {
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.sha_con_add);
                if (linearLayout != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_name);
                    if (textView != null) {
                        return new ViewHostUpBinding((ConstraintLayout) view, shapeableImageView, shapeConstraintLayout, linearLayout, textView);
                    }
                    str = "tvName";
                } else {
                    str = "shaConAdd";
                }
            } else {
                str = "shaCon";
            }
        } else {
            str = "iv";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.e;
    }
}
