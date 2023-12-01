package io.noties.markwon.image;

import android.graphics.drawable.Drawable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/image/AsyncDrawableLoaderNoOp.class */
public class AsyncDrawableLoaderNoOp extends AsyncDrawableLoader {
    @Override // io.noties.markwon.image.AsyncDrawableLoader
    public void cancel(AsyncDrawable asyncDrawable) {
    }

    @Override // io.noties.markwon.image.AsyncDrawableLoader
    public void load(AsyncDrawable asyncDrawable) {
    }

    @Override // io.noties.markwon.image.AsyncDrawableLoader
    public Drawable placeholder(AsyncDrawable asyncDrawable) {
        return null;
    }
}
