package com.soft.blued.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/PopOpenCallTwiceBinding.class */
public final class PopOpenCallTwiceBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f29550a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f29551c;
    public final ImageView d;
    public final LinearLayout e;
    public final TextView f;
    private final FrameLayout g;

    private PopOpenCallTwiceBinding(FrameLayout frameLayout, ShapeTextView shapeTextView, TextView textView, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, TextView textView2) {
        this.g = frameLayout;
        this.f29550a = shapeTextView;
        this.b = textView;
        this.f29551c = imageView;
        this.d = imageView2;
        this.e = linearLayout;
        this.f = textView2;
    }

    public static PopOpenCallTwiceBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.btn_open_once);
        if (shapeTextView != null) {
            TextView textView = (TextView) view.findViewById(R.id.btn_open_twice);
            if (textView != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_btn_twice_tag);
                if (imageView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(2131365504);
                    if (imageView2 != null) {
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_subtitle);
                        if (linearLayout != null) {
                            TextView textView2 = (TextView) view.findViewById(2131372754);
                            if (textView2 != null) {
                                return new PopOpenCallTwiceBinding((FrameLayout) view, shapeTextView, textView, imageView, imageView2, linearLayout, textView2);
                            }
                            str = "tvTitle";
                        } else {
                            str = "llSubtitle";
                        }
                    } else {
                        str = "ivIcon";
                    }
                } else {
                    str = "ivBtnTwiceTag";
                }
            } else {
                str = "btnOpenTwice";
            }
        } else {
            str = "btnOpenOnce";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.g;
    }
}
