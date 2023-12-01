package com.bumptech.glide.load.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/MediaStoreFileLoader.class */
public final class MediaStoreFileLoader implements ModelLoader<Uri, File> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f20882a;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/MediaStoreFileLoader$Factory.class */
    public static final class Factory implements ModelLoaderFactory<Uri, File> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f20883a;

        public Factory(Context context) {
            this.f20883a = context;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Uri, File> a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreFileLoader(this.f20883a);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/MediaStoreFileLoader$FilePathFetcher.class */
    public static class FilePathFetcher implements DataFetcher<File> {

        /* renamed from: a  reason: collision with root package name */
        private static final String[] f20884a = {"_data"};
        private final Context b;

        /* renamed from: c  reason: collision with root package name */
        private final Uri f20885c;

        FilePathFetcher(Context context, Uri uri) {
            this.b = context;
            this.f20885c = uri;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void a() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void a(Priority priority, DataFetcher.DataCallback<? super File> dataCallback) {
            Cursor query = this.b.getContentResolver().query(this.f20885c, f20884a, null, null, null);
            String str = null;
            if (query != null) {
                str = null;
                try {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    query.close();
                }
            }
            if (!TextUtils.isEmpty(str)) {
                dataCallback.a((DataFetcher.DataCallback<? super File>) new File(str));
                return;
            }
            dataCallback.a((Exception) new FileNotFoundException("Failed to find file path for: " + this.f20885c));
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class<File> c() {
            return File.class;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource d() {
            return DataSource.LOCAL;
        }
    }

    public MediaStoreFileLoader(Context context) {
        this.f20882a = context;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<File> a(Uri uri, int i, int i2, Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(uri), new FilePathFetcher(this.f20882a, uri));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean a(Uri uri) {
        return MediaStoreUtil.a(uri);
    }
}
