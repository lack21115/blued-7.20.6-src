package com.blued.community.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/FragmentFeedInteractBinding.class */
public final class FragmentFeedInteractBinding implements ViewBinding {
    public final View a;
    public final FrameLayout b;
    public final FrameLayout c;
    public final RecyclerView d;
    private final FrameLayout e;

    private FragmentFeedInteractBinding(FrameLayout frameLayout, View view, FrameLayout frameLayout2, FrameLayout frameLayout3, RecyclerView recyclerView) {
        this.e = frameLayout;
        this.a = view;
        this.b = frameLayout2;
        this.c = frameLayout3;
        this.d = recyclerView;
    }

    public static FragmentFeedInteractBinding a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.feed_interact_anim_end_view);
        if (findViewById != null) {
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.feed_interact_content_cv);
            if (frameLayout != null) {
                FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.feed_interact_layout);
                if (frameLayout2 != null) {
                    RecyclerView findViewById2 = view.findViewById(R.id.feed_interact_rv);
                    if (findViewById2 != null) {
                        return new FragmentFeedInteractBinding((FrameLayout) view, findViewById, frameLayout, frameLayout2, findViewById2);
                    }
                    str = "feedInteractRv";
                } else {
                    str = "feedInteractLayout";
                }
            } else {
                str = "feedInteractContentCv";
            }
        } else {
            str = "feedInteractAnimEndView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.e;
    }
}
