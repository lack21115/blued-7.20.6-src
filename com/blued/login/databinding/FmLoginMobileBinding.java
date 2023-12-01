package com.blued.login.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.login.R;

/* loaded from: source-7206380-dex2jar.jar:com/blued/login/databinding/FmLoginMobileBinding.class */
public final class FmLoginMobileBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f20521a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTextView f20522c;
    public final ShapeTextView d;
    public final TextView e;
    private final ConstraintLayout f;

    private FmLoginMobileBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout, ImageView imageView, ShapeTextView shapeTextView, ShapeTextView shapeTextView2, TextView textView) {
        this.f = constraintLayout;
        this.f20521a = frameLayout;
        this.b = imageView;
        this.f20522c = shapeTextView;
        this.d = shapeTextView2;
        this.e = textView;
    }

    public static FmLoginMobileBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fm_terms);
        if (frameLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
            if (imageView != null) {
                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_one_login);
                if (shapeTextView != null) {
                    ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_other);
                    if (shapeTextView2 != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_phone_num);
                        if (textView != null) {
                            return new FmLoginMobileBinding((ConstraintLayout) view, frameLayout, imageView, shapeTextView, shapeTextView2, textView);
                        }
                        str = "tvPhoneNum";
                    } else {
                        str = "tvOther";
                    }
                } else {
                    str = "tvOneLogin";
                }
            } else {
                str = "ivBack";
            }
        } else {
            str = "fmTerms";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f;
    }
}
