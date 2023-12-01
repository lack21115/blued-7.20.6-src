package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyHotTopicItemBinding.class */
public final class ItemYyHotTopicItemBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final SVGAImageView f16741a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTextView f16742c;
    public final TextView d;
    public final TextView e;
    private final ConstraintLayout f;

    private ItemYyHotTopicItemBinding(ConstraintLayout constraintLayout, SVGAImageView sVGAImageView, ImageView imageView, ShapeTextView shapeTextView, TextView textView, TextView textView2) {
        this.f = constraintLayout;
        this.f16741a = sVGAImageView;
        this.b = imageView;
        this.f16742c = shapeTextView;
        this.d = textView;
        this.e = textView2;
    }

    public static ItemYyHotTopicItemBinding a(View view) {
        String str;
        SVGAImageView sVGAImageView = (SVGAImageView) view.findViewById(R.id.iv_svga);
        if (sVGAImageView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_us);
            if (imageView != null) {
                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_click);
                if (shapeTextView != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_name);
                    if (textView != null) {
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_num);
                        if (textView2 != null) {
                            return new ItemYyHotTopicItemBinding((ConstraintLayout) view, sVGAImageView, imageView, shapeTextView, textView, textView2);
                        }
                        str = "tvNum";
                    } else {
                        str = "tvName";
                    }
                } else {
                    str = "tvClick";
                }
            } else {
                str = "ivUs";
            }
        } else {
            str = "ivSvga";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f;
    }
}
