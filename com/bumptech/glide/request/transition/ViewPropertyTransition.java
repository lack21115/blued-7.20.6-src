package com.bumptech.glide.request.transition;

import android.view.View;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/transition/ViewPropertyTransition.class */
public class ViewPropertyTransition<R> implements Transition<R> {

    /* renamed from: a  reason: collision with root package name */
    private final Animator f7482a;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/transition/ViewPropertyTransition$Animator.class */
    public interface Animator {
        void a(View view);
    }

    public ViewPropertyTransition(Animator animator) {
        this.f7482a = animator;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public boolean a(R r, Transition.ViewAdapter viewAdapter) {
        if (viewAdapter.d() != null) {
            this.f7482a.a(viewAdapter.d());
            return false;
        }
        return false;
    }
}
