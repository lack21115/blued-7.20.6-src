package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.bumptech.glide.request.transition.TransitionFactory;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/drawable/DrawableTransitionOptions.class */
public final class DrawableTransitionOptions extends TransitionOptions<DrawableTransitionOptions, Drawable> {
    public static DrawableTransitionOptions a(int i) {
        return new DrawableTransitionOptions().b(i);
    }

    public static DrawableTransitionOptions a(DrawableCrossFadeFactory drawableCrossFadeFactory) {
        return new DrawableTransitionOptions().b(drawableCrossFadeFactory);
    }

    public DrawableTransitionOptions a(DrawableCrossFadeFactory.Builder builder) {
        return b(builder.a());
    }

    public DrawableTransitionOptions b(int i) {
        return a(new DrawableCrossFadeFactory.Builder(i));
    }

    public DrawableTransitionOptions b(DrawableCrossFadeFactory drawableCrossFadeFactory) {
        return a((TransitionFactory) drawableCrossFadeFactory);
    }
}
