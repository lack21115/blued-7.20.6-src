package com.blued.community.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/FragmentFeedBubblePostGuideBinding.class */
public final class FragmentFeedBubblePostGuideBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeLinearLayout f18862a;
    public final ShapeTextView b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f18863c;
    public final FrameLayout d;
    public final TextView e;
    public final TextView f;
    private final FrameLayout g;

    private FragmentFeedBubblePostGuideBinding(FrameLayout frameLayout, ShapeLinearLayout shapeLinearLayout, ShapeTextView shapeTextView, RecyclerView recyclerView, FrameLayout frameLayout2, TextView textView, TextView textView2) {
        this.g = frameLayout;
        this.f18862a = shapeLinearLayout;
        this.b = shapeTextView;
        this.f18863c = recyclerView;
        this.d = frameLayout2;
        this.e = textView;
        this.f = textView2;
    }

    public static FragmentFeedBubblePostGuideBinding a(View view) {
        String str;
        ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.content_layout);
        if (shapeLinearLayout != null) {
            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.discard_btn);
            if (shapeTextView != null) {
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
                if (recyclerView != null) {
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.root_layout);
                    if (frameLayout != null) {
                        TextView textView = (TextView) view.findViewById(R.id.send_btn);
                        if (textView != null) {
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_title);
                            if (textView2 != null) {
                                return new FragmentFeedBubblePostGuideBinding((FrameLayout) view, shapeLinearLayout, shapeTextView, recyclerView, frameLayout, textView, textView2);
                            }
                            str = "tvTitle";
                        } else {
                            str = "sendBtn";
                        }
                    } else {
                        str = "rootLayout";
                    }
                } else {
                    str = "recycleView";
                }
            } else {
                str = "discardBtn";
            }
        } else {
            str = "contentLayout";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.g;
    }
}
