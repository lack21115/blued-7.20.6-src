package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/target/BitmapThumbnailImageViewTarget.class */
public class BitmapThumbnailImageViewTarget extends ThumbnailImageViewTarget<Bitmap> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.target.ThumbnailImageViewTarget
    /* renamed from: a */
    public Drawable b(Bitmap bitmap) {
        return new BitmapDrawable(((ImageView) this.f7466a).getResources(), bitmap);
    }
}
