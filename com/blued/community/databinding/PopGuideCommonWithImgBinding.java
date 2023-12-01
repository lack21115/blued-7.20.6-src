package com.blued.community.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/PopGuideCommonWithImgBinding.class */
public final class PopGuideCommonWithImgBinding implements ViewBinding {
    public final ImageView a;
    public final ImageView b;
    public final LinearLayout c;
    public final ImageView d;
    public final LinearLayout e;
    public final TextView f;
    private final LinearLayout g;

    private PopGuideCommonWithImgBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout2, ImageView imageView3, LinearLayout linearLayout3, TextView textView) {
        this.g = linearLayout;
        this.a = imageView;
        this.b = imageView2;
        this.c = linearLayout2;
        this.d = imageView3;
        this.e = linearLayout3;
        this.f = textView;
    }

    public static PopGuideCommonWithImgBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.guide_pop_triangle_down);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.guide_pop_triangle_up);
            if (imageView2 != null) {
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.pop_guide_content_ly);
                if (linearLayout != null) {
                    ImageView imageView3 = (ImageView) view.findViewById(R.id.pop_guide_iv);
                    if (imageView3 != null) {
                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.rootView);
                        if (linearLayout2 != null) {
                            TextView textView = (TextView) view.findViewById(R.id.tv_hint);
                            if (textView != null) {
                                return new PopGuideCommonWithImgBinding((LinearLayout) view, imageView, imageView2, linearLayout, imageView3, linearLayout2, textView);
                            }
                            str = "tvHint";
                        } else {
                            str = "rootView";
                        }
                    } else {
                        str = "popGuideIv";
                    }
                } else {
                    str = "popGuideContentLy";
                }
            } else {
                str = "guidePopTriangleUp";
            }
        } else {
            str = "guidePopTriangleDown";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.g;
    }
}
