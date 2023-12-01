package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/data/LocalUriFetcher.class */
public abstract class LocalUriFetcher<T> implements DataFetcher<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f7117a;
    private final ContentResolver b;

    /* renamed from: c  reason: collision with root package name */
    private T f7118c;

    public LocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        this.b = contentResolver;
        this.f7117a = uri;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void a() {
        T t = this.f7118c;
        if (t != null) {
            try {
                a(t);
            } catch (IOException e) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void a(Priority priority, DataFetcher.DataCallback<? super T> dataCallback) {
        try {
            T b = b(this.f7117a, this.b);
            this.f7118c = b;
            dataCallback.a((DataFetcher.DataCallback<? super T>) b);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e);
            }
            dataCallback.a((Exception) e);
        }
    }

    protected abstract void a(T t) throws IOException;

    protected abstract T b(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void b() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public DataSource d() {
        return DataSource.LOCAL;
    }
}
