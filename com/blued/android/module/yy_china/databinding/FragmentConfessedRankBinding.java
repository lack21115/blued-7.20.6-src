package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentConfessedRankBinding.class */
public final class FragmentConfessedRankBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeConstraintLayout f16470a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f16471c;
    public final TextView d;
    public final ViewPager e;
    private final ConstraintLayout f;

    private FragmentConfessedRankBinding(ConstraintLayout constraintLayout, ShapeConstraintLayout shapeConstraintLayout, ImageView imageView, TextView textView, TextView textView2, ViewPager viewPager) {
        this.f = constraintLayout;
        this.f16470a = shapeConstraintLayout;
        this.b = imageView;
        this.f16471c = textView;
        this.d = textView2;
        this.e = viewPager;
    }

    public static FragmentConfessedRankBinding a(View view) {
        String str;
        ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.con);
        if (shapeConstraintLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_select);
            if (imageView != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_gbz);
                if (textView != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_zxsc);
                    if (textView2 != null) {
                        ViewPager viewPager = (ViewPager) view.findViewById(R.id.vp);
                        if (viewPager != null) {
                            return new FragmentConfessedRankBinding((ConstraintLayout) view, shapeConstraintLayout, imageView, textView, textView2, viewPager);
                        }
                        str = "vp";
                    } else {
                        str = "tvZxsc";
                    }
                } else {
                    str = "tvGbz";
                }
            } else {
                str = "ivSelect";
            }
        } else {
            str = "con";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f;
    }
}
