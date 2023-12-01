package com.blued.community.ui.feed.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Metadata;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/dialog/FeedBubblePostGuideDlgFragment$dismissAnim$1$1.class */
public final class FeedBubblePostGuideDlgFragment$dismissAnim$1$1 extends AnimatorListenerAdapter {
    final /* synthetic */ FeedBubblePostGuideDlgFragment a;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.a.dismissAllowingStateLoss();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}
