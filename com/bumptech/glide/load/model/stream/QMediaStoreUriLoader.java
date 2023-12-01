package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/stream/QMediaStoreUriLoader.class */
public final class QMediaStoreUriLoader<DataT> implements ModelLoader<Uri, DataT> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f20924a;
    private final ModelLoader<File, DataT> b;

    /* renamed from: c  reason: collision with root package name */
    private final ModelLoader<Uri, DataT> f20925c;
    private final Class<DataT> d;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/stream/QMediaStoreUriLoader$Factory.class */
    static abstract class Factory<DataT> implements ModelLoaderFactory<Uri, DataT> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f20926a;
        private final Class<DataT> b;

        Factory(Context context, Class<DataT> cls) {
            this.f20926a = context;
            this.b = cls;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<Uri, DataT> a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new QMediaStoreUriLoader(this.f20926a, multiModelLoaderFactory.b(File.class, this.b), multiModelLoaderFactory.b(Uri.class, this.b), this.b);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final void a() {
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/stream/QMediaStoreUriLoader$FileDescriptorFactory.class */
    public static final class FileDescriptorFactory extends Factory<ParcelFileDescriptor> {
        public FileDescriptorFactory(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/stream/QMediaStoreUriLoader$InputStreamFactory.class */
    public static final class InputStreamFactory extends Factory<InputStream> {
        public InputStreamFactory(Context context) {
            super(context, InputStream.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/stream/QMediaStoreUriLoader$QMediaStoreUriFetcher.class */
    public static final class QMediaStoreUriFetcher<DataT> implements DataFetcher<DataT> {

        /* renamed from: a  reason: collision with root package name */
        private static final String[] f20927a = {"_data"};
        private final Context b;

        /* renamed from: c  reason: collision with root package name */
        private final ModelLoader<File, DataT> f20928c;
        private final ModelLoader<Uri, DataT> d;
        private final Uri e;
        private final int f;
        private final int g;
        private final Options h;
        private final Class<DataT> i;
        private volatile boolean j;
        private volatile DataFetcher<DataT> k;

        QMediaStoreUriFetcher(Context context, ModelLoader<File, DataT> modelLoader, ModelLoader<Uri, DataT> modelLoader2, Uri uri, int i, int i2, Options options, Class<DataT> cls) {
            this.b = context.getApplicationContext();
            this.f20928c = modelLoader;
            this.d = modelLoader2;
            this.e = uri;
            this.f = i;
            this.g = i2;
            this.h = options;
            this.i = cls;
        }

        private File a(Uri uri) throws FileNotFoundException {
            AutoCloseable autoCloseable = null;
            try {
                Cursor query = this.b.getContentResolver().query(uri, f20927a, null, null, null);
                if (query == null || !query.moveToFirst()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to media store entry for: ");
                    sb.append(uri);
                    throw new FileNotFoundException(sb.toString());
                }
                String string = query.getString(query.getColumnIndexOrThrow("_data"));
                if (TextUtils.isEmpty(string)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("File path was empty in media store for: ");
                    sb2.append(uri);
                    throw new FileNotFoundException(sb2.toString());
                }
                File file = new File(string);
                if (query != null) {
                    query.close();
                }
                return file;
            } catch (Throwable th) {
                if (0 != 0) {
                    autoCloseable.close();
                }
                throw th;
            }
        }

        private DataFetcher<DataT> e() throws FileNotFoundException {
            ModelLoader.LoadData<DataT> f = f();
            if (f != null) {
                return f.f20891c;
            }
            return null;
        }

        private ModelLoader.LoadData<DataT> f() throws FileNotFoundException {
            if (Environment.isExternalStorageLegacy()) {
                return this.f20928c.a(a(this.e), this.f, this.g, this.h);
            }
            return this.d.a(g() ? MediaStore.setRequireOriginal(this.e) : this.e, this.f, this.g, this.h);
        }

        private boolean g() {
            return this.b.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void a() {
            DataFetcher<DataT> dataFetcher = this.k;
            if (dataFetcher != null) {
                dataFetcher.a();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void a(Priority priority, DataFetcher.DataCallback<? super DataT> dataCallback) {
            try {
                DataFetcher<DataT> e = e();
                if (e == null) {
                    dataCallback.a((Exception) new IllegalArgumentException("Failed to build fetcher for: " + this.e));
                    return;
                }
                this.k = e;
                if (this.j) {
                    b();
                } else {
                    e.a(priority, dataCallback);
                }
            } catch (FileNotFoundException e2) {
                dataCallback.a((Exception) e2);
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void b() {
            this.j = true;
            DataFetcher<DataT> dataFetcher = this.k;
            if (dataFetcher != null) {
                dataFetcher.b();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class<DataT> c() {
            return this.i;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource d() {
            return DataSource.LOCAL;
        }
    }

    QMediaStoreUriLoader(Context context, ModelLoader<File, DataT> modelLoader, ModelLoader<Uri, DataT> modelLoader2, Class<DataT> cls) {
        this.f20924a = context.getApplicationContext();
        this.b = modelLoader;
        this.f20925c = modelLoader2;
        this.d = cls;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<DataT> a(Uri uri, int i, int i2, Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(uri), new QMediaStoreUriFetcher(this.f20924a, this.b, this.f20925c, uri, i, i2, options, this.d));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean a(Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && MediaStoreUtil.a(uri);
    }
}
