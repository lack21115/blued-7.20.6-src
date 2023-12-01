package com.bumptech.glide.request.transition;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/transition/BitmapContainerTransitionFactory.class */
public abstract class BitmapContainerTransitionFactory<R> implements TransitionFactory<R> {

    /* renamed from: a  reason: collision with root package name */
    private final TransitionFactory<Drawable> f21077a;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/transition/BitmapContainerTransitionFactory$BitmapGlideAnimation.class */
    final class BitmapGlideAnimation implements Transition<R> {
        private final Transition<Drawable> b;

        BitmapGlideAnimation(Transition<Drawable> transition) {
            this.b = transition;
        }

        @Override // com.bumptech.glide.request.transition.Transition
        public boolean a(R r, Transition.ViewAdapter viewAdapter) {
            return this.b.a(new BitmapDrawable(viewAdapter.d().getResources(), BitmapContainerTransitionFactory.this.a(r)), viewAdapter);
        }
    }

    protected abstract Bitmap a(R r);

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<R> a(DataSource dataSource, boolean z) {
        return new BitmapGlideAnimation(this.f21077a.a(dataSource, z));
    }
}
