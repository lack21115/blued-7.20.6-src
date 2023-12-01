package com.bumptech.glide.request;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/ResourceCallback.class */
public interface ResourceCallback {
    void a(GlideException glideException);

    void a(Resource<?> resource, DataSource dataSource);

    Object h();
}
