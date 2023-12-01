package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/ResourceLoader.class */
public class ResourceLoader<Data> implements ModelLoader<Integer, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final ModelLoader<Uri, Data> f20902a;
    private final Resources b;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/ResourceLoader$AssetFileDescriptorFactory.class */
    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Integer, AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f20903a;

        public AssetFileDescriptorFactory(Resources resources) {
            this.f20903a = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Integer, AssetFileDescriptor> a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f20903a, multiModelLoaderFactory.b(Uri.class, AssetFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void a() {
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/ResourceLoader$FileDescriptorFactory.class */
    public static class FileDescriptorFactory implements ModelLoaderFactory<Integer, ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f20904a;

        public FileDescriptorFactory(Resources resources) {
            this.f20904a = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Integer, ParcelFileDescriptor> a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f20904a, multiModelLoaderFactory.b(Uri.class, ParcelFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void a() {
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/ResourceLoader$StreamFactory.class */
    public static class StreamFactory implements ModelLoaderFactory<Integer, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f20905a;

        public StreamFactory(Resources resources) {
            this.f20905a = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Integer, InputStream> a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f20905a, multiModelLoaderFactory.b(Uri.class, InputStream.class));
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void a() {
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/ResourceLoader$UriFactory.class */
    public static class UriFactory implements ModelLoaderFactory<Integer, Uri> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f20906a;

        public UriFactory(Resources resources) {
            this.f20906a = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Integer, Uri> a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f20906a, UnitModelLoader.a());
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void a() {
        }
    }

    public ResourceLoader(Resources resources, ModelLoader<Uri, Data> modelLoader) {
        this.b = resources;
        this.f20902a = modelLoader;
    }

    private Uri b(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.b.getResourcePackageName(num.intValue()) + '/' + this.b.getResourceTypeName(num.intValue()) + '/' + this.b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                Log.w("ResourceLoader", "Received invalid resource id: " + num, e);
                return null;
            }
            return null;
        }
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Data> a(Integer num, int i, int i2, Options options) {
        Uri b = b(num);
        if (b == null) {
            return null;
        }
        return this.f20902a.a(b, i, i2, options);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean a(Integer num) {
        return true;
    }
}
