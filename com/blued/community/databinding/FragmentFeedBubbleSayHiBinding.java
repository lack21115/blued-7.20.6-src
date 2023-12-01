package com.blued.community.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/FragmentFeedBubbleSayHiBinding.class */
public final class FragmentFeedBubbleSayHiBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f18866a;
    public final RecyclerView b;

    /* renamed from: c  reason: collision with root package name */
    public final View f18867c;
    public final FrameLayout d;
    private final FrameLayout e;

    private FragmentFeedBubbleSayHiBinding(FrameLayout frameLayout, FrameLayout frameLayout2, RecyclerView recyclerView, View view, FrameLayout frameLayout3) {
        this.e = frameLayout;
        this.f18866a = frameLayout2;
        this.b = recyclerView;
        this.f18867c = view;
        this.d = frameLayout3;
    }

    public static FragmentFeedBubbleSayHiBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.content_layout);
        if (frameLayout != null) {
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.emotion_rv);
            if (recyclerView != null) {
                View findViewById = view.findViewById(R.id.feed_interact_anim_end_view);
                if (findViewById != null) {
                    FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.root_layout);
                    if (frameLayout2 != null) {
                        return new FragmentFeedBubbleSayHiBinding((FrameLayout) view, frameLayout, recyclerView, findViewById, frameLayout2);
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

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.e;
    }
}
