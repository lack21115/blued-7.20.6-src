package com.blued.community.ui.feed.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.databinding.FragmentFeedBubbleSayHiBinding;
import com.blued.community.manager.CommunityManager;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.BubbleExhibitionModel;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.common.CommFullScreenDialog;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.das.client.feed.FeedProtos;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/dialog/FeedBubbleSayHiDlgFragment.class */
public final class FeedBubbleSayHiDlgFragment extends CommFullScreenDialog {
    private final Context a;
    private final BluedIngSelfFeed b;
    private final int c;
    private final IRequestHost d;
    private FragmentFeedBubbleSayHiBinding e;
    private CommonRecycleAdapter<BubbleExhibitionModel> f;
    private int g;
    private boolean h;
    private long i;
    private int j;
    private final float[] k;

    public FeedBubbleSayHiDlgFragment(Context mContext, BluedIngSelfFeed feedData, int i, IRequestHost fragmentActive) {
        Intrinsics.e(mContext, "mContext");
        Intrinsics.e(feedData, "feedData");
        Intrinsics.e(fragmentActive, "fragmentActive");
        this.a = mContext;
        this.b = feedData;
        this.c = i;
        this.d = fragmentActive;
        this.h = true;
        this.k = new float[2];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(View view, BubbleExhibitionModel bubbleExhibitionModel, int i) {
        if (UserInfoHelper.a(this.b.relationship)) {
            return;
        }
        LogData logData = new LogData();
        logData.from = FeedMethods.a(this.j, this.b.is_vote);
        logData.userFrom = FeedMethods.a(this.j, this.b.is_vote);
        logData.target_uid = this.b.feed_uid;
        logData.feed_id = this.b.feed_id;
        logData.is_call = "1";
        logData.bubble_exhibition_img = bubbleExhibitionModel.getImage();
        CommunityServiceManager.b().b(this.a, this.b, false, 0, logData, FeedMethods.b(this.j, 0));
        dismissAllowingStateLoss();
        EventTrackFeed.a(FeedProtos.Event.FEED_PUNCH_EMOJI_POP_ONE_CLICK, this.b, bubbleExhibitionModel.getPid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FeedBubbleSayHiDlgFragment this$0) {
        final FrameLayout frameLayout;
        FrameLayout frameLayout2;
        Intrinsics.e(this$0, "this$0");
        FragmentFeedBubbleSayHiBinding fragmentFeedBubbleSayHiBinding = this$0.e;
        if (fragmentFeedBubbleSayHiBinding != null && (frameLayout2 = fragmentFeedBubbleSayHiBinding.a) != null) {
            frameLayout2.setVisibility(0);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, this$0.h ? 1.0f : -1.0f, 1, 0.0f);
            translateAnimation.setDuration(200L);
            frameLayout2.startAnimation(translateAnimation);
        }
        FragmentFeedBubbleSayHiBinding fragmentFeedBubbleSayHiBinding2 = this$0.e;
        if (fragmentFeedBubbleSayHiBinding2 == null || (frameLayout = fragmentFeedBubbleSayHiBinding2.a) == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(frameLayout, "alpha", 0.1f, 1.0f);
        Intrinsics.c(ofFloat, "ofFloat(it, \"alpha\", 0.1f, 1f)");
        ObjectAnimator objectAnimator = ofFloat;
        objectAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.blued.community.ui.feed.dialog.FeedBubbleSayHiDlgFragment$showAnim$1$2$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrameLayout.this.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        objectAnimator.setDuration(200L);
        objectAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FeedBubbleSayHiDlgFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (SystemClock.elapsedRealtime() - this$0.i > 300) {
            this$0.i();
        }
    }

    private final void l() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        this.i = SystemClock.elapsedRealtime();
        if (this.c > FeedMethods.c(173) + StatusBarHelper.a(AppInfo.d())) {
            this.h = true;
            this.g = this.c - FeedMethods.c(107);
        } else {
            this.h = false;
            this.g = this.c + FeedMethods.c(21);
        }
        FragmentFeedBubbleSayHiBinding fragmentFeedBubbleSayHiBinding = this.e;
        if (fragmentFeedBubbleSayHiBinding != null && (frameLayout2 = fragmentFeedBubbleSayHiBinding.a) != null) {
            if (this.h) {
                frameLayout2.setPadding(0, 0, 0, FeedMethods.c(3));
            } else {
                frameLayout2.setPadding(0, FeedMethods.c(3), 0, 0);
            }
            if (CommunityManager.a.a().s()) {
                if (this.h) {
                    frameLayout2.setBackgroundResource(R.drawable.feed_bubble_say_hi_bg_dark);
                } else {
                    frameLayout2.setBackgroundResource(R.drawable.feed_bubble_say_hi_bottom_bg_dark);
                }
            } else if (this.h) {
                frameLayout2.setBackgroundResource(R.drawable.feed_bubble_say_hi_bg);
            } else {
                frameLayout2.setBackgroundResource(R.drawable.feed_bubble_say_hi_bottom_bg);
            }
            int c = FeedMethods.c(51);
            List<BubbleExhibitionModel> O = CommunityServiceManager.a().O();
            if (O != null) {
                Iterator<BubbleExhibitionModel> it = O.iterator();
                int i = c;
                while (true) {
                    int i2 = i;
                    c = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    BubbleExhibitionModel next = it.next();
                    next.setRealHeight(FeedMethods.c(36));
                    next.setRealWidth((int) ((next.getWidth() * next.getHeight()) / next.getRealHeight()));
                    i = i2 + next.getRealWidth() + FeedMethods.c(12);
                }
            }
            int i3 = c;
            if (c < FeedMethods.c(185)) {
                i3 = FeedMethods.c(185);
            }
            ViewGroup.LayoutParams layoutParams = frameLayout2.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.topMargin = this.g;
            layoutParams2.width = i3;
            frameLayout2.setLayoutParams(layoutParams2);
        }
        m();
        FragmentFeedBubbleSayHiBinding fragmentFeedBubbleSayHiBinding2 = this.e;
        if (fragmentFeedBubbleSayHiBinding2 == null || (frameLayout = fragmentFeedBubbleSayHiBinding2.d) == null) {
            return;
        }
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.dialog.-$$Lambda$FeedBubbleSayHiDlgFragment$yzJ_jrVVq9OXXK54m5ddPjuTGkM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedBubbleSayHiDlgFragment.a(FeedBubbleSayHiDlgFragment.this, view);
            }
        });
    }

    private final void m() {
        CommonRecycleAdapter<BubbleExhibitionModel> k;
        FragmentFeedBubbleSayHiBinding fragmentFeedBubbleSayHiBinding = this.e;
        RecyclerView recyclerView = fragmentFeedBubbleSayHiBinding == null ? null : fragmentFeedBubbleSayHiBinding.b;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        }
        this.f = new FeedBubbleSayHiDlgFragment$createAdapter$1(this, getContext());
        FragmentFeedBubbleSayHiBinding fragmentFeedBubbleSayHiBinding2 = this.e;
        RecyclerView recyclerView2 = fragmentFeedBubbleSayHiBinding2 == null ? null : fragmentFeedBubbleSayHiBinding2.b;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.f);
        }
        List<BubbleExhibitionModel> O = CommunityServiceManager.a().O();
        if (O == null || (k = k()) == null) {
            return;
        }
        k.setDataAndNotify(O);
    }

    private final void n() {
        FrameLayout frameLayout;
        FragmentFeedBubbleSayHiBinding fragmentFeedBubbleSayHiBinding = this.e;
        if (fragmentFeedBubbleSayHiBinding == null || (frameLayout = fragmentFeedBubbleSayHiBinding.a) == null) {
            return;
        }
        frameLayout.postDelayed(new Runnable() { // from class: com.blued.community.ui.feed.dialog.-$$Lambda$FeedBubbleSayHiDlgFragment$5yn6b4u_mzEmGY_Jsffba8wU-Mc
            @Override // java.lang.Runnable
            public final void run() {
                FeedBubbleSayHiDlgFragment.a(FeedBubbleSayHiDlgFragment.this);
            }
        }, 50L);
    }

    private final void o() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        FragmentFeedBubbleSayHiBinding fragmentFeedBubbleSayHiBinding = this.e;
        if (fragmentFeedBubbleSayHiBinding != null && (frameLayout2 = fragmentFeedBubbleSayHiBinding.a) != null) {
            frameLayout2.setVisibility(0);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
            translateAnimation.setDuration(200L);
            frameLayout2.startAnimation(translateAnimation);
        }
        FragmentFeedBubbleSayHiBinding fragmentFeedBubbleSayHiBinding2 = this.e;
        if (fragmentFeedBubbleSayHiBinding2 == null || (frameLayout = fragmentFeedBubbleSayHiBinding2.a) == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(frameLayout, "alpha", 1.0f, 0.0f);
        Intrinsics.c(ofFloat, "ofFloat(it, \"alpha\", 1f, 0f)");
        ObjectAnimator objectAnimator = ofFloat;
        objectAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.blued.community.ui.feed.dialog.FeedBubbleSayHiDlgFragment$dismissAnim$2$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FeedBubbleSayHiDlgFragment.this.dismissAllowingStateLoss();
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
        return R.layout.fragment_feed_bubble_say_hi;
    }

    @Override // com.blued.community.ui.common.CommFullScreenDialog
    public void i() {
        o();
    }

    public final IRequestHost j() {
        return this.d;
    }

    public final CommonRecycleAdapter<BubbleExhibitionModel> k() {
        return this.f;
    }

    @Override // com.blued.community.ui.common.CommFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, viewGroup, bundle);
        this.e = FragmentFeedBubbleSayHiBinding.a(onCreateView);
        return onCreateView;
    }

    @Override // com.blued.community.ui.common.CommFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        l();
        n();
        EventTrackFeed.a(FeedProtos.Event.FEED_PUNCH_EMOJI_POP_SHOW, this.b, "");
    }
}
