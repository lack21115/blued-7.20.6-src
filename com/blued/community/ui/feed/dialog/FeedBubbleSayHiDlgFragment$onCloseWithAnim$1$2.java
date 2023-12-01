package com.blued.community.ui.feed.dialog;

import android.animation.Animator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import kotlin.Metadata;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/dialog/FeedBubbleSayHiDlgFragment$onCloseWithAnim$1$2.class */
public final class FeedBubbleSayHiDlgFragment$onCloseWithAnim$1$2 implements Animator.AnimatorListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrameLayout f19722a;
    final /* synthetic */ ImageView b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ FeedBubbleSayHiDlgFragment f19723c;

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f19722a.removeView(this.b);
        this.f19723c.i();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}
