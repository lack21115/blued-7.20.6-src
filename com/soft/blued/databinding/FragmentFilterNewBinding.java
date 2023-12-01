package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.soft.blued.R;
import com.soft.blued.customview.FilterScrollView;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/FragmentFilterNewBinding.class */
public final class FragmentFilterNewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f28822a;
    public final View b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f28823c;
    public final ImageView d;
    public final LinearLayout e;
    public final LinearLayout f;
    public final ImageView g;
    public final FilterScrollView h;
    public final ShapeConstraintLayout i;
    private final ShapeConstraintLayout j;

    private FragmentFilterNewBinding(ShapeConstraintLayout shapeConstraintLayout, LinearLayout linearLayout, View view, ImageView imageView, ImageView imageView2, LinearLayout linearLayout2, LinearLayout linearLayout3, ImageView imageView3, FilterScrollView filterScrollView, ShapeConstraintLayout shapeConstraintLayout2) {
        this.j = shapeConstraintLayout;
        this.f28822a = linearLayout;
        this.b = view;
        this.f28823c = imageView;
        this.d = imageView2;
        this.e = linearLayout2;
        this.f = linearLayout3;
        this.g = imageView3;
        this.h = filterScrollView;
        this.i = shapeConstraintLayout2;
    }

    public static FragmentFilterNewBinding a(View view) {
        String str;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.complete_btn);
        if (linearLayout != null) {
            View findViewById = view.findViewById(R.id.filter_lay);
            if (findViewById != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.img_filter_dot);
                if (imageView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(2131365207);
                    if (imageView2 != null) {
                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_fiter_onoff);
                        if (linearLayout2 != null) {
                            LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.ll_root_view);
                            if (linearLayout3 != null) {
                                ImageView imageView3 = (ImageView) view.findViewById(R.id.sbt_fiter_onoff);
                                if (imageView3 != null) {
                                    FilterScrollView filterScrollView = (FilterScrollView) view.findViewById(2131369645);
                                    if (filterScrollView != null) {
                                        ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(2131370699);
                                        if (shapeConstraintLayout != null) {
                                            return new FragmentFilterNewBinding((ShapeConstraintLayout) view, linearLayout, findViewById, imageView, imageView2, linearLayout2, linearLayout3, imageView3, filterScrollView, shapeConstraintLayout);
                                        }
                                        str = "titleBar";
                                    } else {
                                        str = "scrollView";
                                    }
                                } else {
                                    str = "sbtFiterOnoff";
                                }
                            } else {
                                str = "llRootView";
                            }
                        } else {
                            str = "llFiterOnoff";
                        }
                    } else {
                        str = "ivClose";
                    }
                } else {
                    str = "imgFilterDot";
                }
            } else {
                str = "filterLay";
            }
        } else {
            str = "completeBtn";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ShapeConstraintLayout getRoot() {
        return this.j;
    }
}
