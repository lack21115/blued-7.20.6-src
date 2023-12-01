package com.soft.blued.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/FragmentOneLoginBinding.class */
public final class FragmentOneLoginBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f28921a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTextView f28922c;
    public final ImageView d;
    public final TextView e;
    public final ShapeTextView f;
    private final ConstraintLayout g;

    private FragmentOneLoginBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout, ImageView imageView, ShapeTextView shapeTextView, ImageView imageView2, TextView textView, ShapeTextView shapeTextView2) {
        this.g = constraintLayout;
        this.f28921a = frameLayout;
        this.b = imageView;
        this.f28922c = shapeTextView;
        this.d = imageView2;
        this.e = textView;
        this.f = shapeTextView2;
    }

    public static FragmentOneLoginBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(2131364005);
        if (frameLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.one_login_back);
            if (imageView != null) {
                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.one_login_btn);
                if (shapeTextView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.one_login_icon);
                    if (imageView2 != null) {
                        TextView textView = (TextView) view.findViewById(R.id.one_login_number);
                        if (textView != null) {
                            ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.one_login_other_btn);
                            if (shapeTextView2 != null) {
                                return new FragmentOneLoginBinding((ConstraintLayout) view, frameLayout, imageView, shapeTextView, imageView2, textView, shapeTextView2);
                            }
                            str = "oneLoginOtherBtn";
                        } else {
                            str = "oneLoginNumber";
                        }
                    } else {
                        str = "oneLoginIcon";
                    }
                } else {
                    str = "oneLoginBtn";
                }
            } else {
                str = "oneLoginBack";
            }
        } else {
            str = "fmTerms";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.g;
    }
}
