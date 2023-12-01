package com.blued.community.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/FragmentFeedMineVisitTipsBinding.class */
public final class FragmentFeedMineVisitTipsBinding implements ViewBinding {
    public final ImageView a;
    public final ImageView b;
    public final ImageView c;
    public final FrameLayout d;
    public final FrameLayout e;
    private final FrameLayout f;

    private FragmentFeedMineVisitTipsBinding(FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, FrameLayout frameLayout2, FrameLayout frameLayout3) {
        this.f = frameLayout;
        this.a = imageView;
        this.b = imageView2;
        this.c = imageView3;
        this.d = frameLayout2;
        this.e = frameLayout3;
    }

    public static FragmentFeedMineVisitTipsBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.arrow_down);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.arrow_up);
            if (imageView2 != null) {
                ImageView imageView3 = (ImageView) view.findViewById(R.id.bg_view);
                if (imageView3 != null) {
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.content_layout);
                    if (frameLayout != null) {
                        FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.root_layout);
                        if (frameLayout2 != null) {
                            return new FragmentFeedMineVisitTipsBinding((FrameLayout) view, imageView, imageView2, imageView3, frameLayout, frameLayout2);
                        }
                        str = "rootLayout";
                    } else {
                        str = "contentLayout";
                    }
                } else {
                    str = "bgView";
                }
            } else {
                str = "arrowUp";
            }
        } else {
            str = "arrowDown";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.f;
    }
}
