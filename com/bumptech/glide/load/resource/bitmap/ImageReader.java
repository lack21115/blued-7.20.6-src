package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/ImageReader.class */
public interface ImageReader {

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/ImageReader$InputStreamImageReader.class */
    public static final class InputStreamImageReader implements ImageReader {

        /* renamed from: a  reason: collision with root package name */
        private final InputStreamRewinder f7352a;
        private final ArrayPool b;

        /* renamed from: c  reason: collision with root package name */
        private final List<ImageHeaderParser> f7353c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public InputStreamImageReader(InputStream inputStream, List<ImageHeaderParser> list, ArrayPool arrayPool) {
            this.b = (ArrayPool) Preconditions.a(arrayPool);
            this.f7353c = (List) Preconditions.a(list);
            this.f7352a = new InputStreamRewinder(inputStream, arrayPool);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public Bitmap a(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeStream(this.f7352a.a(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public ImageHeaderParser.ImageType a() throws IOException {
            return ImageHeaderParserUtils.getType(this.f7353c, this.f7352a.a(), this.b);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public int b() throws IOException {
            return ImageHeaderParserUtils.a(this.f7353c, this.f7352a.a(), this.b);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public void c() {
            this.f7352a.d();
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/ImageReader$ParcelFileDescriptorImageReader.class */
    public static final class ParcelFileDescriptorImageReader implements ImageReader {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayPool f7354a;
        private final List<ImageHeaderParser> b;

        /* renamed from: c  reason: collision with root package name */
        private final ParcelFileDescriptorRewinder f7355c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ParcelFileDescriptorImageReader(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, ArrayPool arrayPool) {
            this.f7354a = (ArrayPool) Preconditions.a(arrayPool);
            this.b = (List) Preconditions.a(list);
            this.f7355c = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public Bitmap a(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeFileDescriptor(this.f7355c.a().getFileDescriptor(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public ImageHeaderParser.ImageType a() throws IOException {
            return ImageHeaderParserUtils.getType(this.b, this.f7355c, this.f7354a);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public int b() throws IOException {
            return ImageHeaderParserUtils.a(this.b, this.f7355c, this.f7354a);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public void c() {
        }
    }

    Bitmap a(BitmapFactory.Options options) throws IOException;

    ImageHeaderParser.ImageType a() throws IOException;

    int b() throws IOException;

    void c();
}
