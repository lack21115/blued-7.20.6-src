package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYHomeThemeTabView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogGiftExhibitionLayoutBinding.class */
public final class DialogGiftExhibitionLayoutBinding implements ViewBinding {
    public final ImageView a;
    public final ImageView b;
    public final ImageView c;
    public final ShapeConstraintLayout d;
    public final YYHomeThemeTabView e;
    public final TextView f;
    public final ViewPager g;
    private final ConstraintLayout h;

    private DialogGiftExhibitionLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ShapeConstraintLayout shapeConstraintLayout, YYHomeThemeTabView yYHomeThemeTabView, TextView textView, ViewPager viewPager) {
        this.h = constraintLayout;
        this.a = imageView;
        this.b = imageView2;
        this.c = imageView3;
        this.d = shapeConstraintLayout;
        this.e = yYHomeThemeTabView;
        this.f = textView;
        this.g = viewPager;
    }

    public static DialogGiftExhibitionLayoutBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_about);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_back);
            if (imageView2 != null) {
                ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_backg);
                if (imageView3 != null) {
                    ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.shap_con);
                    if (shapeConstraintLayout != null) {
                        YYHomeThemeTabView yYHomeThemeTabView = (YYHomeThemeTabView) view.findViewById(R.id.tab_layout);
                        if (yYHomeThemeTabView != null) {
                            TextView textView = (TextView) view.findViewById(R.id.tv_title_text);
                            if (textView != null) {
                                ViewPager findViewById = view.findViewById(R.id.view_pager);
                                if (findViewById != null) {
                                    return new DialogGiftExhibitionLayoutBinding((ConstraintLayout) view, imageView, imageView2, imageView3, shapeConstraintLayout, yYHomeThemeTabView, textView, findViewById);
                                }
                                str = "viewPager";
                            } else {
                                str = "tvTitleText";
                            }
                        } else {
                            str = "tabLayout";
                        }
                    } else {
                        str = "shapCon";
                    }
                } else {
                    str = "ivBackg";
                }
            } else {
                str = "ivBack";
            }
        } else {
            str = "ivAbout";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.h;
    }
}
