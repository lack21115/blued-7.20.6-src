package com.soft.blued.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/FragmentUserInfoPostFeedBinding.class */
public final class FragmentUserInfoPostFeedBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeFrameLayout f15305a;
    public final ShapeTextView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f15306c;
    public final ImageView d;
    public final ShapeFrameLayout e;
    public final ShapeLinearLayout f;
    public final ShapeTextView g;
    public final TextView h;
    private final FrameLayout i;

    private FragmentUserInfoPostFeedBinding(FrameLayout frameLayout, ShapeFrameLayout shapeFrameLayout, ShapeTextView shapeTextView, ImageView imageView, ImageView imageView2, ShapeFrameLayout shapeFrameLayout2, ShapeLinearLayout shapeLinearLayout, ShapeTextView shapeTextView2, TextView textView) {
        this.i = frameLayout;
        this.f15305a = shapeFrameLayout;
        this.b = shapeTextView;
        this.f15306c = imageView;
        this.d = imageView2;
        this.e = shapeFrameLayout2;
        this.f = shapeLinearLayout;
        this.g = shapeTextView2;
        this.h = textView;
    }

    public static FragmentUserInfoPostFeedBinding a(View view) {
        String str;
        ShapeFrameLayout findViewById = view.findViewById(R.id.content_View);
        if (findViewById != null) {
            ShapeTextView findViewById2 = view.findViewById(R.id.discard_btn);
            if (findViewById2 != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_guide_view);
                if (imageView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_pre_topic);
                    if (imageView2 != null) {
                        ShapeFrameLayout findViewById3 = view.findViewById(R.id.layout_title);
                        if (findViewById3 != null) {
                            ShapeLinearLayout findViewById4 = view.findViewById(R.id.layout_topic);
                            if (findViewById4 != null) {
                                ShapeTextView findViewById5 = view.findViewById(R.id.send_btn);
                                if (findViewById5 != null) {
                                    TextView textView = (TextView) view.findViewById(R.id.tv_topic);
                                    if (textView != null) {
                                        return new FragmentUserInfoPostFeedBinding((FrameLayout) view, findViewById, findViewById2, imageView, imageView2, findViewById3, findViewById4, findViewById5, textView);
                                    }
                                    str = "tvTopic";
                                } else {
                                    str = "sendBtn";
                                }
                            } else {
                                str = "layoutTopic";
                            }
                        } else {
                            str = "layoutTitle";
                        }
                    } else {
                        str = "ivPreTopic";
                    }
                } else {
                    str = "ivGuideView";
                }
            } else {
                str = "discardBtn";
            }
        } else {
            str = "contentView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.i;
    }
}
