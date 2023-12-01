package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyBadgeInfoBinding.class */
public final class ItemYyBadgeInfoBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f16679a;
    public final ShapeLinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f16680c;
    public final TextView d;
    public final TextView e;
    public final ShapeTextView f;
    public final TextView g;
    private final FrameLayout h;

    private ItemYyBadgeInfoBinding(FrameLayout frameLayout, ImageView imageView, ShapeLinearLayout shapeLinearLayout, TextView textView, TextView textView2, TextView textView3, ShapeTextView shapeTextView, TextView textView4) {
        this.h = frameLayout;
        this.f16679a = imageView;
        this.b = shapeLinearLayout;
        this.f16680c = textView;
        this.d = textView2;
        this.e = textView3;
        this.f = shapeTextView;
        this.g = textView4;
    }

    public static ItemYyBadgeInfoBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static ItemYyBadgeInfoBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_yy_badge_info, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ItemYyBadgeInfoBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.img_badge);
        if (imageView != null) {
            ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.ll_main);
            if (shapeLinearLayout != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_badge_name);
                if (textView != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_gained_cond);
                    if (textView2 != null) {
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_lvlup_cond);
                        if (textView3 != null) {
                            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_score);
                            if (shapeTextView != null) {
                                TextView textView4 = (TextView) view.findViewById(R.id.tv_valid_date);
                                if (textView4 != null) {
                                    return new ItemYyBadgeInfoBinding((FrameLayout) view, imageView, shapeLinearLayout, textView, textView2, textView3, shapeTextView, textView4);
                                }
                                str = "tvValidDate";
                            } else {
                                str = "tvScore";
                            }
                        } else {
                            str = "tvLvlupCond";
                        }
                    } else {
                        str = "tvGainedCond";
                    }
                } else {
                    str = "tvBadgeName";
                }
            } else {
                str = "llMain";
            }
        } else {
            str = "imgBadge";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.h;
    }
}
