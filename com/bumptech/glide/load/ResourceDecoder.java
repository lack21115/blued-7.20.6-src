package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/ResourceDecoder.class */
public interface ResourceDecoder<T, Z> {
    Resource<Z> a(T t, int i, int i2, Options options) throws IOException;

    boolean a(T t, Options options) throws IOException;
}
