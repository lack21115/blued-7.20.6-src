package com.bumptech.glide.load.data;

import java.io.IOException;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/data/DataRewinder.class */
public interface DataRewinder<T> {

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/data/DataRewinder$Factory.class */
    public interface Factory<T> {
        DataRewinder<T> a(T t);

        Class<T> a();
    }

    T a() throws IOException;

    void b();
}
