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
    public final ShapeFrameLayout f28995a;
    public final ShapeTextView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f28996c;
    public final ImageView d;
    public final ShapeFrameLayout e;
    public final ShapeLinearLayout f;
    public final ShapeTextView g;
    public final TextView h;
    private final FrameLayout i;

    private FragmentUserInfoPostFeedBinding(FrameLayout frameLayout, ShapeFrameLayout shapeFrameLayout, ShapeTextView shapeTextView, ImageView imageView, ImageView imageView2, ShapeFrameLayout shapeFrameLayout2, ShapeLinearLayout shapeLinearLayout, ShapeTextView shapeTextView2, TextView textView) {
        this.i = frameLayout;
        this.f28995a = shapeFrameLayout;
        this.b = shapeTextView;
        this.f28996c = imageView;
        this.d = imageView2;
        this.e = shapeFrameLayout2;
        this.f = shapeLinearLayout;
        this.g = shapeTextView2;
        this.h = textView;
    }

    public static FragmentUserInfoPostFeedBinding a(View view) {
        String str;
        ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) view.findViewById(R.id.content_View);
        if (shapeFrameLayout != null) {
            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(2131363239);
            if (shapeTextView != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_guide_view);
                if (imageView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(2131365761);
                    if (imageView2 != null) {
                        ShapeFrameLayout shapeFrameLayout2 = (ShapeFrameLayout) view.findViewById(R.id.layout_title);
                        if (shapeFrameLayout2 != null) {
                            ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.layout_topic);
                            if (shapeLinearLayout != null) {
                                ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(2131369700);
                                if (shapeTextView2 != null) {
                                    TextView textView = (TextView) view.findViewById(2131372816);
                                    if (textView != null) {
                                        return new FragmentUserInfoPostFeedBinding((FrameLayout) view, shapeFrameLayout, shapeTextView, imageView, imageView2, shapeFrameLayout2, shapeLinearLayout, shapeTextView2, textView);
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
