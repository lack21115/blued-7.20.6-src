package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyHotTopicAllBinding.class */
public final class ItemYyHotTopicAllBinding implements ViewBinding {
    public final SVGAImageView a;
    public final ImageView b;
    public final ShapeTextView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    private final ConstraintLayout g;

    private ItemYyHotTopicAllBinding(ConstraintLayout constraintLayout, SVGAImageView sVGAImageView, ImageView imageView, ShapeTextView shapeTextView, TextView textView, TextView textView2, TextView textView3) {
        this.g = constraintLayout;
        this.a = sVGAImageView;
        this.b = imageView;
        this.c = shapeTextView;
        this.d = textView;
        this.e = textView2;
        this.f = textView3;
    }

    public static ItemYyHotTopicAllBinding a(View view) {
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
                            TextView textView3 = (TextView) view.findViewById(R.id.tv_topic);
                            if (textView3 != null) {
                                return new ItemYyHotTopicAllBinding((ConstraintLayout) view, sVGAImageView, imageView, shapeTextView, textView, textView2, textView3);
                            }
                            str = "tvTopic";
                        } else {
                            str = "tvNum";
                        }
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

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.g;
    }
}
