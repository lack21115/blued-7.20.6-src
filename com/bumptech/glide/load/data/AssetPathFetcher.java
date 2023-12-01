package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.IOException;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/data/AssetPathFetcher.class */
public abstract class AssetPathFetcher<T> implements DataFetcher<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f20711a;
    private final AssetManager b;

    /* renamed from: c  reason: collision with root package name */
    private T f20712c;

    public AssetPathFetcher(AssetManager assetManager, String str) {
        this.b = assetManager;
        this.f20711a = str;
    }

    protected abstract T a(AssetManager assetManager, String str) throws IOException;

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void a() {
        T t = this.f20712c;
        if (t == null) {
            return;
        }
        try {
            a(t);
        } catch (IOException e) {
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void a(Priority priority, DataFetcher.DataCallback<? super T> dataCallback) {
        try {
            T a2 = a(this.b, this.f20711a);
            this.f20712c = a2;
            dataCallback.a((DataFetcher.DataCallback<? super T>) a2);
        } catch (IOException e) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e);
            }
            dataCallback.a((Exception) e);
        }
    }

    protected abstract void a(T t) throws IOException;

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void b() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public DataSource d() {
        return DataSource.LOCAL;
    }
}
