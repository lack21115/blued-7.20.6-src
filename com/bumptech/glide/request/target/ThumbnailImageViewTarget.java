package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/target/ThumbnailImageViewTarget.class */
public abstract class ThumbnailImageViewTarget<T> extends ImageViewTarget<T> {
    @Override // com.bumptech.glide.request.target.ImageViewTarget
    protected void a(T t) {
        ViewGroup.LayoutParams layoutParams = ((ImageView) this.f7466a).getLayoutParams();
        Drawable b = b((ThumbnailImageViewTarget<T>) t);
        FixedSizeDrawable fixedSizeDrawable = b;
        if (layoutParams != null) {
            fixedSizeDrawable = b;
            if (layoutParams.width > 0) {
                fixedSizeDrawable = b;
                if (layoutParams.height > 0) {
                    fixedSizeDrawable = new FixedSizeDrawable(b, layoutParams.width, layoutParams.height);
                }
            }
        }
        ((ImageView) this.f7466a).setImageDrawable(fixedSizeDrawable);
    }

    protected abstract Drawable b(T t);
}
