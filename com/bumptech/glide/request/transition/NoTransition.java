package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/transition/NoTransition.class */
public class NoTransition<R> implements Transition<R> {

    /* renamed from: a  reason: collision with root package name */
    static final NoTransition<?> f21083a = new NoTransition<>();
    private static final TransitionFactory<?> b = new NoAnimationFactory();

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/transition/NoTransition$NoAnimationFactory.class */
    public static class NoAnimationFactory<R> implements TransitionFactory<R> {
        @Override // com.bumptech.glide.request.transition.TransitionFactory
        public Transition<R> a(DataSource dataSource, boolean z) {
            return NoTransition.f21083a;
        }
    }

    public static <R> TransitionFactory<R> a() {
        return (TransitionFactory<R>) b;
    }

    public static <R> Transition<R> b() {
        return f21083a;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public boolean a(Object obj, Transition.ViewAdapter viewAdapter) {
        return false;
    }
}
