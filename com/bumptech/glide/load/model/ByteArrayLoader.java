package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/ByteArrayLoader.class */
public class ByteArrayLoader<Data> implements ModelLoader<byte[], Data> {

    /* renamed from: a  reason: collision with root package name */
    private final Converter<Data> f20862a;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/ByteArrayLoader$ByteBufferFactory.class */
    public static class ByteBufferFactory implements ModelLoaderFactory<byte[], ByteBuffer> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<byte[], ByteBuffer> a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteArrayLoader(new Converter<ByteBuffer>() { // from class: com.bumptech.glide.load.model.ByteArrayLoader.ByteBufferFactory.1
                @Override // com.bumptech.glide.load.model.ByteArrayLoader.Converter
                public Class<ByteBuffer> a() {
                    return ByteBuffer.class;
                }

                @Override // com.bumptech.glide.load.model.ByteArrayLoader.Converter
                /* renamed from: a */
                public ByteBuffer b(byte[] bArr) {
                    return ByteBuffer.wrap(bArr);
                }
            });
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void a() {
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/ByteArrayLoader$Converter.class */
    public interface Converter<Data> {
        Class<Data> a();

        Data b(byte[] bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/ByteArrayLoader$Fetcher.class */
    public static class Fetcher<Data> implements DataFetcher<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f20864a;
        private final Converter<Data> b;

        Fetcher(byte[] bArr, Converter<Data> converter) {
            this.f20864a = bArr;
            this.b = converter;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void a() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void a(Priority priority, DataFetcher.DataCallback<? super Data> dataCallback) {
            dataCallback.a((DataFetcher.DataCallback<? super Data>) ((Data) this.b.b(this.f20864a)));
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class<Data> c() {
            return this.b.a();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource d() {
            return DataSource.LOCAL;
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/ByteArrayLoader$StreamFactory.class */
    public static class StreamFactory implements ModelLoaderFactory<byte[], InputStream> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<byte[], InputStream> a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteArrayLoader(new Converter<InputStream>() { // from class: com.bumptech.glide.load.model.ByteArrayLoader.StreamFactory.1
                @Override // com.bumptech.glide.load.model.ByteArrayLoader.Converter
                /* renamed from: a */
                public InputStream b(byte[] bArr) {
                    return new ByteArrayInputStream(bArr);
                }

                @Override // com.bumptech.glide.load.model.ByteArrayLoader.Converter
                public Class<InputStream> a() {
                    return InputStream.class;
                }
            });
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void a() {
        }
    }

    public ByteArrayLoader(Converter<Data> converter) {
        this.f20862a = converter;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Data> a(byte[] bArr, int i, int i2, Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(bArr), new Fetcher(bArr, this.f20862a));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean a(byte[] bArr) {
        return true;
    }
}
