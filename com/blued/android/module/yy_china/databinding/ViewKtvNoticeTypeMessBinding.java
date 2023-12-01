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

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f16865a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTextView f16866c;
    public final TextView d;
    private final FrameLayout e;

    private ViewKtvNoticeTypeMessBinding(FrameLayout frameLayout, ImageView imageView, TextView textView, ShapeTextView shapeTextView, TextView textView2) {
        this.e = frameLayout;
        this.f16865a = imageView;
        this.b = textView;
        this.f16866c = shapeTextView;
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

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.e;
    }
}
