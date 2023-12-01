package com.soft.blued.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/LayoutAdMiniAppDialogBinding.class */
public final class LayoutAdMiniAppDialogBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f29380a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTextView f29381c;
    public final TextView d;
    public final ShapeTextView e;
    public final TextView f;
    private final LinearLayout g;

    private LayoutAdMiniAppDialogBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ShapeTextView shapeTextView, TextView textView, ShapeTextView shapeTextView2, TextView textView2) {
        this.g = linearLayout;
        this.f29380a = imageView;
        this.b = imageView2;
        this.f29381c = shapeTextView;
        this.d = textView;
        this.e = shapeTextView2;
        this.f = textView2;
    }

    public static LayoutAdMiniAppDialogBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static LayoutAdMiniAppDialogBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_ad_mini_app_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LayoutAdMiniAppDialogBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(2131365208);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_mini_app_icon);
            if (imageView2 != null) {
                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_mini_app_cancel);
                if (shapeTextView != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_mini_app_des);
                    if (textView != null) {
                        ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_mini_app_sure);
                        if (shapeTextView2 != null) {
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_mini_app_title);
                            if (textView2 != null) {
                                return new LayoutAdMiniAppDialogBinding((LinearLayout) view, imageView, imageView2, shapeTextView, textView, shapeTextView2, textView2);
                            }
                            str = "tvMiniAppTitle";
                        } else {
                            str = "tvMiniAppSure";
                        }
                    } else {
                        str = "tvMiniAppDes";
                    }
                } else {
                    str = "tvMiniAppCancel";
                }
            } else {
                str = "ivMiniAppIcon";
            }
        } else {
            str = "ivCloseBtn";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.g;
    }
}
