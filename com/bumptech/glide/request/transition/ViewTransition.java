package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/transition/ViewTransition.class */
public class ViewTransition<R> implements Transition<R> {

    /* renamed from: a  reason: collision with root package name */
    private final ViewTransitionAnimationFactory f21089a;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/transition/ViewTransition$ViewTransitionAnimationFactory.class */
    interface ViewTransitionAnimationFactory {
        Animation a(Context context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewTransition(ViewTransitionAnimationFactory viewTransitionAnimationFactory) {
        this.f21089a = viewTransitionAnimationFactory;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public boolean a(R r, Transition.ViewAdapter viewAdapter) {
        View d = viewAdapter.d();
        if (d != null) {
            d.clearAnimation();
            d.startAnimation(this.f21089a.a(d.getContext()));
            return false;
        }
        return false;
    }
}
