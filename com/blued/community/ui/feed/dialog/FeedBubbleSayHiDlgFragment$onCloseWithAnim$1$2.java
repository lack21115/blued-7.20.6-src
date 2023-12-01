package com.blued.community.ui.feed.dialog;

import android.animation.Animator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import kotlin.Metadata;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/dialog/FeedBubbleSayHiDlgFragment$onCloseWithAnim$1$2.class */
public final class FeedBubbleSayHiDlgFragment$onCloseWithAnim$1$2 implements Animator.AnimatorListener {
    final /* synthetic */ FrameLayout a;
    final /* synthetic */ ImageView b;
    final /* synthetic */ FeedBubbleSayHiDlgFragment c;

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.a.removeView(this.b);
        this.c.i();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}
