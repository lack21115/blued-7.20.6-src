package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.Preconditions;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/drawable/DrawableResource.class */
public abstract class DrawableResource<T extends Drawable> implements Initializable, Resource<T> {
    protected final T d;

    public DrawableResource(T t) {
        this.d = (T) Preconditions.a(t);
    }

    @Override // com.bumptech.glide.load.engine.Initializable
    public void d() {
        T t = this.d;
        if (t instanceof BitmapDrawable) {
            ((BitmapDrawable) t).getBitmap().prepareToDraw();
        } else if (t instanceof GifDrawable) {
            ((GifDrawable) t).b().prepareToDraw();
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    /* renamed from: e */
    public final T f() {
        Drawable.ConstantState constantState = this.d.getConstantState();
        return constantState == null ? this.d : (T) constantState.newDrawable();
    }
}
