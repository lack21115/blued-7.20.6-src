package com.bumptech.glide.load.model;

import android.util.Base64;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/DataUrlLoader.class */
public final class DataUrlLoader<Model, Data> implements ModelLoader<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final DataDecoder<Data> f20867a;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/DataUrlLoader$DataDecoder.class */
    public interface DataDecoder<Data> {
        Class<Data> a();

        Data a(String str) throws IllegalArgumentException;

        void a(Data data) throws IOException;
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/DataUrlLoader$DataUriFetcher.class */
    static final class DataUriFetcher<Data> implements DataFetcher<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final String f20868a;
        private final DataDecoder<Data> b;

        /* renamed from: c  reason: collision with root package name */
        private Data f20869c;

        DataUriFetcher(String str, DataDecoder<Data> dataDecoder) {
            this.f20868a = str;
            this.b = dataDecoder;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void a() {
            try {
                this.b.a((DataDecoder<Data>) this.f20869c);
            } catch (IOException e) {
            }
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, Data] */
        @Override // com.bumptech.glide.load.data.DataFetcher
        public void a(Priority priority, DataFetcher.DataCallback<? super Data> dataCallback) {
            try {
                Data a2 = this.b.a(this.f20868a);
                this.f20869c = a2;
                dataCallback.a((DataFetcher.DataCallback<? super Data>) a2);
            } catch (IllegalArgumentException e) {
                dataCallback.a((Exception) e);
            }
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

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/DataUrlLoader$StreamFactory.class */
    public static final class StreamFactory<Model> implements ModelLoaderFactory<Model, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final DataDecoder<InputStream> f20870a = new DataDecoder<InputStream>() { // from class: com.bumptech.glide.load.model.DataUrlLoader.StreamFactory.1
            @Override // com.bumptech.glide.load.model.DataUrlLoader.DataDecoder
            public Class<InputStream> a() {
                return InputStream.class;
            }

            @Override // com.bumptech.glide.load.model.DataUrlLoader.DataDecoder
            public void a(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // com.bumptech.glide.load.model.DataUrlLoader.DataDecoder
            /* renamed from: b */
            public InputStream a(String str) {
                if (str.startsWith("data:image")) {
                    int indexOf = str.indexOf(44);
                    if (indexOf != -1) {
                        if (str.substring(0, indexOf).endsWith(";base64")) {
                            return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                        }
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                throw new IllegalArgumentException("Not a valid image data URL.");
            }
        };

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Model, InputStream> a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new DataUrlLoader(this.f20870a);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void a() {
        }
    }

    public DataUrlLoader(DataDecoder<Data> dataDecoder) {
        this.f20867a = dataDecoder;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Data> a(Model model, int i, int i2, Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(model), new DataUriFetcher(model.toString(), this.f20867a));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean a(Model model) {
        return model.toString().startsWith("data:image");
    }
}
