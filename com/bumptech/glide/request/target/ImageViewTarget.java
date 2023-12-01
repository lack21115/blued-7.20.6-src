package com.bumptech.glide.request.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/target/ImageViewTarget.class */
public abstract class ImageViewTarget<Z> extends ViewTarget<ImageView, Z> implements Transition.ViewAdapter {
    private Animatable b;

    public ImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    private void b(Z z) {
        a(z);
        c(z);
    }

    private void c(Z z) {
        if (!(z instanceof Animatable)) {
            this.b = null;
            return;
        }
        Animatable animatable = (Animatable) z;
        this.b = animatable;
        animatable.start();
    }

    @Override // com.bumptech.glide.request.transition.Transition.ViewAdapter
    public Drawable a() {
        return ((ImageView) this.f21072a).getDrawable();
    }

    protected abstract void a(Z z);

    @Override // com.bumptech.glide.request.transition.Transition.ViewAdapter
    public void b(Drawable drawable) {
        ((ImageView) this.f21072a).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
        super.onLoadCleared(drawable);
        Animatable animatable = this.b;
        if (animatable != null) {
            animatable.stop();
        }
        b((ImageViewTarget<Z>) null);
        b(drawable);
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadFailed(Drawable drawable) {
        super.onLoadFailed(drawable);
        b((ImageViewTarget<Z>) null);
        b(drawable);
    }

    @Override // com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadStarted(Drawable drawable) {
        super.onLoadStarted(drawable);
        b((ImageViewTarget<Z>) null);
        b(drawable);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onResourceReady(Z z, Transition<? super Z> transition) {
        if (transition == null || !transition.a(z, this)) {
            b((ImageViewTarget<Z>) z);
        } else {
            c(z);
        }
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        Animatable animatable = this.b;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        Animatable animatable = this.b;
        if (animatable != null) {
            animatable.stop();
        }
    }
}
