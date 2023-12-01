package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.ViewPropertyTransition;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/transition/ViewPropertyAnimationFactory.class */
public class ViewPropertyAnimationFactory<R> implements TransitionFactory<R> {

    /* renamed from: a  reason: collision with root package name */
    private final ViewPropertyTransition.Animator f7481a;
    private ViewPropertyTransition<R> b;

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<R> a(DataSource dataSource, boolean z) {
        if (dataSource == DataSource.MEMORY_CACHE || !z) {
            return NoTransition.b();
        }
        if (this.b == null) {
            this.b = new ViewPropertyTransition<>(this.f7481a);
        }
        return this.b;
    }
}
