package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/target/BitmapImageViewTarget.class */
public class BitmapImageViewTarget extends ImageViewTarget<Bitmap> {
    public BitmapImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.target.ImageViewTarget
    public void a(Bitmap bitmap) {
        ((ImageView) this.f7466a).setImageBitmap(bitmap);
    }
}
