package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogConfessedRankBinding.class */
public final class DialogConfessedRankBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f16311a;
    public final ShapeConstraintLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTextView f16312c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final ShapeTextView h;
    public final TextView i;
    public final TextView j;
    public final ViewPager k;
    private final ConstraintLayout l;

    private DialogConfessedRankBinding(ConstraintLayout constraintLayout, TextView textView, ShapeConstraintLayout shapeConstraintLayout, ShapeTextView shapeTextView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ShapeTextView shapeTextView2, TextView textView2, TextView textView3, ViewPager viewPager) {
        this.l = constraintLayout;
        this.f16311a = textView;
        this.b = shapeConstraintLayout;
        this.f16312c = shapeTextView;
        this.d = imageView;
        this.e = imageView2;
        this.f = imageView3;
        this.g = imageView4;
        this.h = shapeTextView2;
        this.i = textView2;
        this.j = textView3;
        this.k = viewPager;
    }

    public static DialogConfessedRankBinding a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.btn_about);
        if (textView != null) {
            ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.con);
            if (shapeConstraintLayout != null) {
                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.iv_allb_select);
                if (shapeTextView != null) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
                    if (imageView != null) {
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_bg);
                        if (imageView2 != null) {
                            ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_close);
                            if (imageView3 != null) {
                                ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_top_bg);
                                if (imageView4 != null) {
                                    ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.iv_zb_select);
                                    if (shapeTextView2 != null) {
                                        TextView textView2 = (TextView) view.findViewById(R.id.tit_allb);
                                        if (textView2 != null) {
                                            TextView textView3 = (TextView) view.findViewById(R.id.tit_zb);
                                            if (textView3 != null) {
                                                ViewPager viewPager = (ViewPager) view.findViewById(R.id.vp);
                                                if (viewPager != null) {
                                                    return new DialogConfessedRankBinding((ConstraintLayout) view, textView, shapeConstraintLayout, shapeTextView, imageView, imageView2, imageView3, imageView4, shapeTextView2, textView2, textView3, viewPager);
                                                }
                                                str = "vp";
                                            } else {
                                                str = "titZb";
                                            }
                                        } else {
                                            str = "titAllb";
                                        }
                                    } else {
                                        str = "ivZbSelect";
                                    }
                                } else {
                                    str = "ivTopBg";
                                }
                            } else {
                                str = "ivClose";
                            }
                        } else {
                            str = "ivBg";
                        }
                    } else {
                        str = "ivBack";
                    }
                } else {
                    str = "ivAllbSelect";
                }
            } else {
                str = "con";
            }
        } else {
            str = "btnAbout";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.l;
    }
}
