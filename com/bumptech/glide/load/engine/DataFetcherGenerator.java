package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/DataFetcherGenerator.class */
interface DataFetcherGenerator {

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/DataFetcherGenerator$FetcherReadyCallback.class */
    public interface FetcherReadyCallback {
        void a(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource);

        void a(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2);

        void c();
    }

    boolean a();

    void b();
}
