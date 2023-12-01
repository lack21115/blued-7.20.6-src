package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/FragmentAdTestBinding.class */
public final class FragmentAdTestBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f28778a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f28779c;
    public final ImageView d;
    public final ImageView e;
    public final LinearLayout f;
    public final LinearLayout g;
    public final LinearLayout h;
    public final LinearLayout i;
    public final CommonTopTitleNoTrans j;
    private final LinearLayout k;

    private FragmentAdTestBinding(LinearLayout linearLayout, ShapeTextView shapeTextView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, CommonTopTitleNoTrans commonTopTitleNoTrans) {
        this.k = linearLayout;
        this.f28778a = shapeTextView;
        this.b = imageView;
        this.f28779c = imageView2;
        this.d = imageView3;
        this.e = imageView4;
        this.f = linearLayout2;
        this.g = linearLayout3;
        this.h = linearLayout4;
        this.i = linearLayout5;
        this.j = commonTopTitleNoTrans;
    }

    public static FragmentAdTestBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(2131362611);
        if (shapeTextView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_splash_ref);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_splash_ref_banner1);
                if (imageView2 != null) {
                    ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_splash_ref_banner2);
                    if (imageView3 != null) {
                        ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_splash_ref_top);
                        if (imageView4 != null) {
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_ref);
                            if (linearLayout != null) {
                                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_ref_banner1);
                                if (linearLayout2 != null) {
                                    LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.ll_ref_banner2);
                                    if (linearLayout3 != null) {
                                        LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.ll_ref_top);
                                        if (linearLayout4 != null) {
                                            CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) view.findViewById(2131370749);
                                            if (commonTopTitleNoTrans != null) {
                                                return new FragmentAdTestBinding((LinearLayout) view, shapeTextView, imageView, imageView2, imageView3, imageView4, linearLayout, linearLayout2, linearLayout3, linearLayout4, commonTopTitleNoTrans);
                                            }
                                            str = "topTitle";
                                        } else {
                                            str = "llRefTop";
                                        }
                                    } else {
                                        str = "llRefBanner2";
                                    }
                                } else {
                                    str = "llRefBanner1";
                                }
                            } else {
                                str = "llRef";
                            }
                        } else {
                            str = "ivSplashRefTop";
                        }
                    } else {
                        str = "ivSplashRefBanner2";
                    }
                } else {
                    str = "ivSplashRefBanner1";
                }
            } else {
                str = "ivSplashRef";
            }
        } else {
            str = "btnOk";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.k;
    }
}
