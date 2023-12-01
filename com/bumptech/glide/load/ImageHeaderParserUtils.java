package com.bumptech.glide.load;

import android.content.IntentFilter;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/ImageHeaderParserUtils.class */
public final class ImageHeaderParserUtils {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/ImageHeaderParserUtils$OrientationReader.class */
    public interface OrientationReader {
        int a(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/ImageHeaderParserUtils$TypeReader.class */
    public interface TypeReader {
        ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    private ImageHeaderParserUtils() {
    }

    private static int a(List<ImageHeaderParser> list, OrientationReader orientationReader) throws IOException {
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return -1;
            }
            int a2 = orientationReader.a(list.get(i2));
            if (a2 != -1) {
                return a2;
            }
            i = i2 + 1;
        }
    }

    public static int a(List<ImageHeaderParser> list, final ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, final ArrayPool arrayPool) throws IOException {
        return a(list, new OrientationReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.5
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader
            public int a(ImageHeaderParser imageHeaderParser) throws IOException {
                RecyclableBufferedInputStream recyclableBufferedInputStream = null;
                try {
                    RecyclableBufferedInputStream recyclableBufferedInputStream2 = new RecyclableBufferedInputStream(new FileInputStream(ParcelFileDescriptorRewinder.this.a().getFileDescriptor()), arrayPool);
                    try {
                        int a2 = imageHeaderParser.a(recyclableBufferedInputStream2, arrayPool);
                        try {
                            recyclableBufferedInputStream2.close();
                        } catch (IOException e) {
                        }
                        ParcelFileDescriptorRewinder.this.a();
                        return a2;
                    } catch (Throwable th) {
                        th = th;
                        recyclableBufferedInputStream = recyclableBufferedInputStream2;
                        if (recyclableBufferedInputStream != null) {
                            try {
                                recyclableBufferedInputStream.close();
                            } catch (IOException e2) {
                            }
                        }
                        ParcelFileDescriptorRewinder.this.a();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        });
    }

    public static int a(List<ImageHeaderParser> list, InputStream inputStream, final ArrayPool arrayPool) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        RecyclableBufferedInputStream recyclableBufferedInputStream = inputStream;
        if (!inputStream.markSupported()) {
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        recyclableBufferedInputStream.mark(IntentFilter.MATCH_CATEGORY_PATH);
        final InputStream inputStream2 = recyclableBufferedInputStream;
        return a(list, new OrientationReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.4
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader
            public int a(ImageHeaderParser imageHeaderParser) throws IOException {
                try {
                    return imageHeaderParser.a(InputStream.this, arrayPool);
                } finally {
                    InputStream.this.reset();
                }
            }
        });
    }

    private static ImageHeaderParser.ImageType a(List<ImageHeaderParser> list, TypeReader typeReader) throws IOException {
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            ImageHeaderParser.ImageType type = typeReader.getType(list.get(i2));
            if (type != ImageHeaderParser.ImageType.UNKNOWN) {
                return type;
            }
            i = i2 + 1;
        }
    }

    public static ImageHeaderParser.ImageType getType(List<ImageHeaderParser> list, final ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, final ArrayPool arrayPool) throws IOException {
        return a(list, new TypeReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.3
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
            public ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException {
                RecyclableBufferedInputStream recyclableBufferedInputStream;
                RecyclableBufferedInputStream recyclableBufferedInputStream2 = null;
                try {
                    recyclableBufferedInputStream = new RecyclableBufferedInputStream(new FileInputStream(ParcelFileDescriptorRewinder.this.a().getFileDescriptor()), arrayPool);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    ImageHeaderParser.ImageType type = imageHeaderParser.getType(recyclableBufferedInputStream);
                    try {
                        recyclableBufferedInputStream.close();
                    } catch (IOException e) {
                    }
                    ParcelFileDescriptorRewinder.this.a();
                    return type;
                } catch (Throwable th2) {
                    th = th2;
                    recyclableBufferedInputStream2 = recyclableBufferedInputStream;
                    if (recyclableBufferedInputStream2 != null) {
                        try {
                            recyclableBufferedInputStream2.close();
                        } catch (IOException e2) {
                        }
                    }
                    ParcelFileDescriptorRewinder.this.a();
                    throw th;
                }
            }
        });
    }

    public static ImageHeaderParser.ImageType getType(List<ImageHeaderParser> list, InputStream inputStream, ArrayPool arrayPool) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        RecyclableBufferedInputStream recyclableBufferedInputStream = inputStream;
        if (!inputStream.markSupported()) {
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        recyclableBufferedInputStream.mark(IntentFilter.MATCH_CATEGORY_PATH);
        final InputStream inputStream2 = recyclableBufferedInputStream;
        return a(list, new TypeReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.1
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
            public ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException {
                try {
                    return imageHeaderParser.getType(InputStream.this);
                } finally {
                    InputStream.this.reset();
                }
            }
        });
    }

    public static ImageHeaderParser.ImageType getType(List<ImageHeaderParser> list, final ByteBuffer byteBuffer) throws IOException {
        return byteBuffer == null ? ImageHeaderParser.ImageType.UNKNOWN : a(list, new TypeReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.2
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
            public ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException {
                return imageHeaderParser.getType(ByteBuffer.this);
            }
        });
    }
}
