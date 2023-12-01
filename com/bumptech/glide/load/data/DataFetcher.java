package com.bumptech.glide.load.data;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/data/DataFetcher.class */
public interface DataFetcher<T> {

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/data/DataFetcher$DataCallback.class */
    public interface DataCallback<T> {
        void a(Exception exc);

        void a(T t);
    }

    void a();

    void a(Priority priority, DataCallback<? super T> dataCallback);

    void b();

    Class<T> c();

    DataSource d();
}
