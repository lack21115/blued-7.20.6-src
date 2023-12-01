package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import java.io.File;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/cache/DiskCache.class */
public interface DiskCache {

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/cache/DiskCache$Factory.class */
    public interface Factory {
        DiskCache a();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/cache/DiskCache$Writer.class */
    public interface Writer {
        boolean a(File file);
    }

    File a(Key key);

    void a();

    void a(Key key, Writer writer);

    void delete(Key key);
}
