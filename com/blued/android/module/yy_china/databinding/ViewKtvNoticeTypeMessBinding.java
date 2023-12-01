package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewKtvNoticeTypeMessBinding.class */
public final class ViewKtvNoticeTypeMessBinding implements ViewBinding {
    public final ImageView a;
    public final TextView b;
    public final ShapeTextView c;
    public final TextView d;
    private final FrameLayout e;

    private ViewKtvNoticeTypeMessBinding(FrameLayout frameLayout, ImageView imageView, TextView textView, ShapeTextView shapeTextView, TextView textView2) {
        this.e = frameLayout;
        this.a = imageView;
        this.b = textView;
        this.c = shapeTextView;
        this.d = textView2;
    }

    public static ViewKtvNoticeTypeMessBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
        if (imageView != null) {
            TextView textView = (TextView) view.findViewById(R.id.tv_cancel);
            if (textView != null) {
                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_sha_qd);
                if (shapeTextView != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_title);
                    if (textView2 != null) {
                        return new ViewKtvNoticeTypeMessBinding((FrameLayout) view, imageView, textView, shapeTextView, textView2);
                    }
                    str = "tvTitle";
                } else {
                    str = "tvShaQd";
                }
            } else {
                str = "tvCancel";
            }
        } else {
            str = "ivBack";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.e;
    }
}
