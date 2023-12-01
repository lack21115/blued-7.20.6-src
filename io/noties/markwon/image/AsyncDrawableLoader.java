package io.noties.markwon.image;

import android.graphics.drawable.Drawable;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/image/AsyncDrawableLoader.class */
public abstract class AsyncDrawableLoader {
    public static AsyncDrawableLoader noOp() {
        return new AsyncDrawableLoaderNoOp();
    }

    public abstract void cancel(AsyncDrawable asyncDrawable);

    public abstract void load(AsyncDrawable asyncDrawable);

    public abstract Drawable placeholder(AsyncDrawable asyncDrawable);
}
