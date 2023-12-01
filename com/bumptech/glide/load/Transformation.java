package com.bumptech.glide.load;

import android.content.Context;
import com.bumptech.glide.load.engine.Resource;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/Transformation.class */
public interface Transformation<T> extends Key {
    Resource<T> a(Context context, Resource<T> resource, int i, int i2);
}
