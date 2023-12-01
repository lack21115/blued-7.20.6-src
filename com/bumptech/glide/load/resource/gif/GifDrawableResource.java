package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.resource.drawable.DrawableResource;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/gif/GifDrawableResource.class */
public class GifDrawableResource extends DrawableResource<GifDrawable> implements Initializable {
    public GifDrawableResource(GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class<GifDrawable> a() {
        return GifDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int b() {
        return ((GifDrawable) this.d).a();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void c() {
        ((GifDrawable) this.d).stop();
        ((GifDrawable) this.d).g();
    }

    @Override // com.bumptech.glide.load.resource.drawable.DrawableResource, com.bumptech.glide.load.engine.Initializable
    public void d() {
        ((GifDrawable) this.d).b().prepareToDraw();
    }
}
