package com.blued.community.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/FragmentFeedBubbleSayHiBinding.class */
public final class FragmentFeedBubbleSayHiBinding implements ViewBinding {
    public final FrameLayout a;
    public final RecyclerView b;
    public final View c;
    public final FrameLayout d;
    private final FrameLayout e;

    private FragmentFeedBubbleSayHiBinding(FrameLayout frameLayout, FrameLayout frameLayout2, RecyclerView recyclerView, View view, FrameLayout frameLayout3) {
        this.e = frameLayout;
        this.a = frameLayout2;
        this.b = recyclerView;
        this.c = view;
        this.d = frameLayout3;
    }

    public static FragmentFeedBubbleSayHiBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.content_layout);
        if (frameLayout != null) {
            RecyclerView findViewById = view.findViewById(R.id.emotion_rv);
            if (findViewById != null) {
                View findViewById2 = view.findViewById(R.id.feed_interact_anim_end_view);
                if (findViewById2 != null) {
                    FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.root_layout);
                    if (frameLayout2 != null) {
                        return new FragmentFeedBubbleSayHiBinding((FrameLayout) view, frameLayout, findViewById, findViewById2, frameLayout2);
                    }
                    str = "rootLayout";
                } else {
                    str = "feedInteractAnimEndView";
                }
            } else {
                str = "emotionRv";
            }
        } else {
            str = "contentLayout";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.e;
    }
}
