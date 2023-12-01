package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/target/DrawableImageViewTarget.class */
public class DrawableImageViewTarget extends ImageViewTarget<Drawable> {
    public DrawableImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.target.ImageViewTarget
    public void a(Drawable drawable) {
        ((ImageView) this.f7466a).setImageDrawable(drawable);
    }
}
