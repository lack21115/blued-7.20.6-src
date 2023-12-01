package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/FileLoader.class */
public class FileLoader<Data> implements ModelLoader<File, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final FileOpener<Data> f20872a;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/FileLoader$Factory.class */
    public static class Factory<Data> implements ModelLoaderFactory<File, Data> {

        /* renamed from: a  reason: collision with root package name */
        private final FileOpener<Data> f20873a;

        public Factory(FileOpener<Data> fileOpener) {
            this.f20873a = fileOpener;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<File, Data> a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new FileLoader(this.f20873a);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final void a() {
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/FileLoader$FileDescriptorFactory.class */
    public static class FileDescriptorFactory extends Factory<ParcelFileDescriptor> {
        public FileDescriptorFactory() {
            super(new FileOpener<ParcelFileDescriptor>() { // from class: com.bumptech.glide.load.model.FileLoader.FileDescriptorFactory.1
                @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
                /* renamed from: a */
                public ParcelFileDescriptor b(File file) throws FileNotFoundException {
                    return ParcelFileDescriptor.open(file, 268435456);
                }

                @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
                public Class<ParcelFileDescriptor> a() {
                    return ParcelFileDescriptor.class;
                }

                @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
                public void a(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                    parcelFileDescriptor.close();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/FileLoader$FileFetcher.class */
    public static final class FileFetcher<Data> implements DataFetcher<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final File f20874a;
        private final FileOpener<Data> b;

        /* renamed from: c  reason: collision with root package name */
        private Data f20875c;

        FileFetcher(File file, FileOpener<Data> fileOpener) {
            this.f20874a = file;
            this.b = fileOpener;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void a() {
            Data data = this.f20875c;
            if (data != null) {
                try {
                    this.b.a(data);
                } catch (IOException e) {
                }
            }
        }

        /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Object, Data] */
        @Override // com.bumptech.glide.load.data.DataFetcher
        public void a(Priority priority, DataFetcher.DataCallback<? super Data> dataCallback) {
            try {
                Data b = this.b.b(this.f20874a);
                this.f20875c = b;
                dataCallback.a((DataFetcher.DataCallback<? super Data>) b);
            } catch (FileNotFoundException e) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e);
                }
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

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/FileLoader$FileOpener.class */
    public interface FileOpener<Data> {
        Class<Data> a();

        void a(Data data) throws IOException;

        Data b(File file) throws FileNotFoundException;
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/FileLoader$StreamFactory.class */
    public static class StreamFactory extends Factory<InputStream> {
        public StreamFactory() {
            super(new FileOpener<InputStream>() { // from class: com.bumptech.glide.load.model.FileLoader.StreamFactory.1
                @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
                /* renamed from: a */
                public InputStream b(File file) throws FileNotFoundException {
                    return new FileInputStream(file);
                }

                @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
                public Class<InputStream> a() {
                    return InputStream.class;
                }

                @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
                public void a(InputStream inputStream) throws IOException {
                    inputStream.close();
                }
            });
        }
    }

    public FileLoader(FileOpener<Data> fileOpener) {
        this.f20872a = fileOpener;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Data> a(File file, int i, int i2, Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(file), new FileFetcher(file, this.f20872a));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean a(File file) {
        return true;
    }
}
