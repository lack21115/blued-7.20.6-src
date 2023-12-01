package com.blued.community.ui.feed.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.community.R;
import com.blued.community.databinding.FragmentFeedBubbleRewardBinding;
import com.blued.community.manager.CommunityManager;
import com.blued.community.ui.common.CommFullScreenDialog;
import com.blued.community.ui.send.fragment.FeedPostSignStateFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/dialog/FeedBubbleRewardDlgFragment.class */
public final class FeedBubbleRewardDlgFragment extends CommFullScreenDialog {
    private final Context a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private FragmentFeedBubbleRewardBinding f;

    public FeedBubbleRewardDlgFragment(Context mContext, String str, String str2, String str3, String str4) {
        Intrinsics.e(mContext, "mContext");
        this.a = mContext;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FeedBubbleRewardDlgFragment this$0) {
        final CardView cardView;
        Intrinsics.e(this$0, "this$0");
        FragmentFeedBubbleRewardBinding fragmentFeedBubbleRewardBinding = this$0.f;
        if (fragmentFeedBubbleRewardBinding == null || (cardView = fragmentFeedBubbleRewardBinding.c) == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(cardView, "alpha", 0.1f, 1.0f);
        Intrinsics.c(ofFloat, "ofFloat(it, \"alpha\", 0.1f, 1f)");
        ObjectAnimator objectAnimator = ofFloat;
        objectAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.blued.community.ui.feed.dialog.FeedBubbleRewardDlgFragment$showAnim$1$1$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                cardView.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                cardView.setVisibility(0);
            }
        });
        objectAnimator.setDuration(200L);
        objectAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FeedBubbleRewardDlgFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FeedBubbleRewardDlgFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.i();
    }

    private final void j() {
        FrameLayout frameLayout;
        ImageView imageView;
        TextView textView;
        CardView cardView;
        FragmentFeedBubbleRewardBinding fragmentFeedBubbleRewardBinding = this.f;
        if (fragmentFeedBubbleRewardBinding != null && (cardView = fragmentFeedBubbleRewardBinding.c) != null) {
            cardView.setCardBackgroundColor(CommunityManager.a.a().s() ? Color.parseColor("#2C2C2C") : -1);
        }
        if (this.b != null) {
            ImageWrapper a = ImageLoader.a(a(), this.b);
            FragmentFeedBubbleRewardBinding fragmentFeedBubbleRewardBinding2 = this.f;
            a.a(fragmentFeedBubbleRewardBinding2 == null ? null : fragmentFeedBubbleRewardBinding2.d);
        }
        FragmentFeedBubbleRewardBinding fragmentFeedBubbleRewardBinding3 = this.f;
        TextView textView2 = fragmentFeedBubbleRewardBinding3 == null ? null : fragmentFeedBubbleRewardBinding3.g;
        if (textView2 != null) {
            String str = this.c;
            String str2 = str;
            if (str == null) {
                str2 = "获得成就标识";
            }
            textView2.setText(str2);
        }
        FragmentFeedBubbleRewardBinding fragmentFeedBubbleRewardBinding4 = this.f;
        TextView textView3 = fragmentFeedBubbleRewardBinding4 == null ? null : fragmentFeedBubbleRewardBinding4.f;
        if (textView3 != null) {
            String str3 = this.d;
            String str4 = str3;
            if (str3 == null) {
                str4 = "24小时内所有新冒泡将会获得更多曝光！";
            }
            textView3.setText(str4);
        }
        FragmentFeedBubbleRewardBinding fragmentFeedBubbleRewardBinding5 = this.f;
        TextView textView4 = fragmentFeedBubbleRewardBinding5 == null ? null : fragmentFeedBubbleRewardBinding5.a;
        if (textView4 != null) {
            String str5 = this.e;
            String str6 = str5;
            if (str5 == null) {
                str6 = "去冒泡";
            }
            textView4.setText(str6);
        }
        FragmentFeedBubbleRewardBinding fragmentFeedBubbleRewardBinding6 = this.f;
        if (fragmentFeedBubbleRewardBinding6 != null && (textView = fragmentFeedBubbleRewardBinding6.a) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.dialog.-$$Lambda$FeedBubbleRewardDlgFragment$JGOBoBnDFdtslXh8qY7jOIV6L8c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedBubbleRewardDlgFragment.a(FeedBubbleRewardDlgFragment.this, view);
                }
            });
        }
        FragmentFeedBubbleRewardBinding fragmentFeedBubbleRewardBinding7 = this.f;
        if (fragmentFeedBubbleRewardBinding7 != null && (imageView = fragmentFeedBubbleRewardBinding7.b) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.dialog.-$$Lambda$FeedBubbleRewardDlgFragment$uxY1377Hkek7PIzUBP6PTOmtnpg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedBubbleRewardDlgFragment.b(FeedBubbleRewardDlgFragment.this, view);
                }
            });
        }
        FragmentFeedBubbleRewardBinding fragmentFeedBubbleRewardBinding8 = this.f;
        if (fragmentFeedBubbleRewardBinding8 == null || (frameLayout = fragmentFeedBubbleRewardBinding8.e) == null) {
            return;
        }
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.dialog.-$$Lambda$FeedBubbleRewardDlgFragment$3HgLwN9Fbufg6PDGhNAUNDasDrQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedBubbleRewardDlgFragment.a(view);
            }
        });
    }

    private final void k() {
        Context activity = getActivity();
        if (activity != null) {
            FeedPostSignStateFragment.a.a(activity, 1);
        }
        dismissAllowingStateLoss();
    }

    private final void l() {
        CardView cardView;
        FragmentFeedBubbleRewardBinding fragmentFeedBubbleRewardBinding = this.f;
        if (fragmentFeedBubbleRewardBinding == null || (cardView = fragmentFeedBubbleRewardBinding.c) == null) {
            return;
        }
        cardView.postDelayed(new Runnable() { // from class: com.blued.community.ui.feed.dialog.-$$Lambda$FeedBubbleRewardDlgFragment$X2mkzCRS36NgtftmIGq0JAhgLBA
            @Override // java.lang.Runnable
            public final void run() {
                FeedBubbleRewardDlgFragment.a(FeedBubbleRewardDlgFragment.this);
            }
        }, 50L);
    }

    private final void m() {
        CardView cardView;
        FragmentFeedBubbleRewardBinding fragmentFeedBubbleRewardBinding = this.f;
        if (fragmentFeedBubbleRewardBinding == null || (cardView = fragmentFeedBubbleRewardBinding.c) == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(cardView, "alpha", 1.0f, 0.0f);
        Intrinsics.c(ofFloat, "ofFloat(it, \"alpha\", 1f, 0f)");
        ObjectAnimator objectAnimator = ofFloat;
        objectAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.blued.community.ui.feed.dialog.FeedBubbleRewardDlgFragment$dismissAnim$1$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FeedBubbleRewardDlgFragment.this.dismissAllowingStateLoss();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        objectAnimator.setDuration(200L);
        objectAnimator.start();
    }

    @Override // com.blued.community.ui.common.CommFullScreenDialog
    public int e() {
        return R.layout.fragment_feed_bubble_reward;
    }

    @Override // com.blued.community.ui.common.CommFullScreenDialog
    public void i() {
        m();
    }

    @Override // com.blued.community.ui.common.CommFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, viewGroup, bundle);
        this.f = FragmentFeedBubbleRewardBinding.a(onCreateView);
        return onCreateView;
    }

    @Override // com.blued.community.ui.common.CommFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        j();
        l();
    }
}
