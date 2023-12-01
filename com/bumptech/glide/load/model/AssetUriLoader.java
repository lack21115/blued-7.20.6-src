package com.bumptech.glide.load.model;

import android.content.ContentResolver;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.FileDescriptorAssetPathFetcher;
import com.bumptech.glide.load.data.StreamAssetPathFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/AssetUriLoader.class */
public class AssetUriLoader<Data> implements ModelLoader<Uri, Data> {

    /* renamed from: a  reason: collision with root package name */
    private static final int f20858a = 22;
    private final AssetManager b;

    /* renamed from: c  reason: collision with root package name */
    private final AssetFetcherFactory<Data> f20859c;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/AssetUriLoader$AssetFetcherFactory.class */
    public interface AssetFetcherFactory<Data> {
        DataFetcher<Data> a(AssetManager assetManager, String str);
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/AssetUriLoader$FileDescriptorFactory.class */
    public static class FileDescriptorFactory implements AssetFetcherFactory<ParcelFileDescriptor>, ModelLoaderFactory<Uri, ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final AssetManager f20860a;

        public FileDescriptorFactory(AssetManager assetManager) {
            this.f20860a = assetManager;
        }

        @Override // com.bumptech.glide.load.model.AssetUriLoader.AssetFetcherFactory
        public DataFetcher<ParcelFileDescriptor> a(AssetManager assetManager, String str) {
            return new FileDescriptorAssetPathFetcher(assetManager, str);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Uri, ParcelFileDescriptor> a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new AssetUriLoader(this.f20860a, this);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void a() {
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/AssetUriLoader$StreamFactory.class */
    public static class StreamFactory implements AssetFetcherFactory<InputStream>, ModelLoaderFactory<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final AssetManager f20861a;

        public StreamFactory(AssetManager assetManager) {
            this.f20861a = assetManager;
        }

        @Override // com.bumptech.glide.load.model.AssetUriLoader.AssetFetcherFactory
        public DataFetcher<InputStream> a(AssetManager assetManager, String str) {
            return new StreamAssetPathFetcher(assetManager, str);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Uri, InputStream> a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new AssetUriLoader(this.f20861a, this);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void a() {
        }
    }

    public AssetUriLoader(AssetManager assetManager, AssetFetcherFactory<Data> assetFetcherFactory) {
        this.b = assetManager;
        this.f20859c = assetFetcherFactory;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Data> a(Uri uri, int i, int i2, Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(uri), this.f20859c.a(this.b, uri.toString().substring(f20858a)));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean a(Uri uri) {
        boolean z = false;
        if (ContentResolver.SCHEME_FILE.equals(uri.getScheme())) {
            z = false;
            if (!uri.getPathSegments().isEmpty()) {
                z = false;
                if ("android_asset".equals(uri.getPathSegments().get(0))) {
                    z = true;
                }
            }
        }
        return z;
    }
}
