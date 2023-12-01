package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.ViewTransition;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/transition/ViewAnimationFactory.class */
public class ViewAnimationFactory<R> implements TransitionFactory<R> {

    /* renamed from: a  reason: collision with root package name */
    private final ViewTransition.ViewTransitionAnimationFactory f21084a;
    private Transition<R> b;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/transition/ViewAnimationFactory$ConcreteViewTransitionAnimationFactory.class */
    static class ConcreteViewTransitionAnimationFactory implements ViewTransition.ViewTransitionAnimationFactory {

        /* renamed from: a  reason: collision with root package name */
        private final Animation f21085a;

        @Override // com.bumptech.glide.request.transition.ViewTransition.ViewTransitionAnimationFactory
        public Animation a(Context context) {
            return this.f21085a;
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/transition/ViewAnimationFactory$ResourceViewTransitionAnimationFactory.class */
    static class ResourceViewTransitionAnimationFactory implements ViewTransition.ViewTransitionAnimationFactory {

        /* renamed from: a  reason: collision with root package name */
        private final int f21086a;

        @Override // com.bumptech.glide.request.transition.ViewTransition.ViewTransitionAnimationFactory
        public Animation a(Context context) {
            return AnimationUtils.loadAnimation(context, this.f21086a);
        }
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<R> a(DataSource dataSource, boolean z) {
        if (dataSource == DataSource.MEMORY_CACHE || !z) {
            return NoTransition.b();
        }
        if (this.b == null) {
            this.b = new ViewTransition(this.f21084a);
        }
        return this.b;
    }
}
