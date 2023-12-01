package com.bumptech.glide.load.resource.bitmap;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/VideoDecoder.class */
public class VideoDecoder<T> implements ResourceDecoder<T, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public static final Option<Long> f20978a = Option.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new Option.CacheKeyUpdater<Long>() { // from class: com.bumptech.glide.load.resource.bitmap.VideoDecoder.1

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f20980a = ByteBuffer.allocate(8);

        @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
        public void update(byte[] bArr, Long l, MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f20980a) {
                this.f20980a.position(0);
                messageDigest.update(this.f20980a.putLong(l.longValue()).array());
            }
        }
    });
    public static final Option<Integer> b = Option.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new Option.CacheKeyUpdater<Integer>() { // from class: com.bumptech.glide.load.resource.bitmap.VideoDecoder.2

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f20981a = ByteBuffer.allocate(4);

        @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
        public void update(byte[] bArr, Integer num, MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.f20981a) {
                this.f20981a.position(0);
                messageDigest.update(this.f20981a.putInt(num.intValue()).array());
            }
        }
    });

    /* renamed from: c  reason: collision with root package name */
    private static final MediaMetadataRetrieverFactory f20979c = new MediaMetadataRetrieverFactory();
    private final MediaMetadataRetrieverInitializer<T> d;
    private final BitmapPool e;
    private final MediaMetadataRetrieverFactory f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/VideoDecoder$AssetFileDescriptorInitializer.class */
    public static final class AssetFileDescriptorInitializer implements MediaMetadataRetrieverInitializer<AssetFileDescriptor> {
        private AssetFileDescriptorInitializer() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverInitializer
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/VideoDecoder$ByteBufferInitializer.class */
    public static final class ByteBufferInitializer implements MediaMetadataRetrieverInitializer<ByteBuffer> {
        ByteBufferInitializer() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverInitializer
        public void a(MediaMetadataRetriever mediaMetadataRetriever, final ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(new MediaDataSource() { // from class: com.bumptech.glide.load.resource.bitmap.VideoDecoder.ByteBufferInitializer.1
                @Override // java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }

                @Override // android.media.MediaDataSource
                public long getSize() {
                    return byteBuffer.limit();
                }

                @Override // android.media.MediaDataSource
                public int readAt(long j, byte[] bArr, int i, int i2) {
                    if (j >= byteBuffer.limit()) {
                        return -1;
                    }
                    byteBuffer.position((int) j);
                    int min = Math.min(i2, byteBuffer.remaining());
                    byteBuffer.get(bArr, i, min);
                    return min;
                }
            });
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/VideoDecoder$MediaMetadataRetrieverFactory.class */
    static class MediaMetadataRetrieverFactory {
        MediaMetadataRetrieverFactory() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/VideoDecoder$MediaMetadataRetrieverInitializer.class */
    public interface MediaMetadataRetrieverInitializer<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/VideoDecoder$ParcelFileDescriptorInitializer.class */
    public static final class ParcelFileDescriptorInitializer implements MediaMetadataRetrieverInitializer<ParcelFileDescriptor> {
        ParcelFileDescriptorInitializer() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverInitializer
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    VideoDecoder(BitmapPool bitmapPool, MediaMetadataRetrieverInitializer<T> mediaMetadataRetrieverInitializer) {
        this(bitmapPool, mediaMetadataRetrieverInitializer, f20979c);
    }

    VideoDecoder(BitmapPool bitmapPool, MediaMetadataRetrieverInitializer<T> mediaMetadataRetrieverInitializer, MediaMetadataRetrieverFactory mediaMetadataRetrieverFactory) {
        this.e = bitmapPool;
        this.d = mediaMetadataRetrieverInitializer;
        this.f = mediaMetadataRetrieverFactory;
    }

    private static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j, int i) {
        return mediaMetadataRetriever.getFrameAtTime(j, i);
    }

    private static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, DownsampleStrategy downsampleStrategy) {
        Bitmap b2 = (Build.VERSION.SDK_INT < 27 || i2 == Integer.MIN_VALUE || i3 == Integer.MIN_VALUE || downsampleStrategy == DownsampleStrategy.f) ? null : b(mediaMetadataRetriever, j, i, i2, i3, downsampleStrategy);
        Bitmap bitmap = b2;
        if (b2 == null) {
            bitmap = a(mediaMetadataRetriever, j, i);
        }
        return bitmap;
    }

    public static ResourceDecoder<AssetFileDescriptor, Bitmap> a(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new AssetFileDescriptorInitializer());
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0035, code lost:
        if (r0 == 270) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap b(android.media.MediaMetadataRetriever r8, long r9, int r11, int r12, int r13, com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r14) {
        /*
            r0 = r8
            r1 = 18
            java.lang.String r0 = r0.extractMetadata(r1)     // Catch: java.lang.Throwable -> L65
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L65
            r18 = r0
            r0 = r8
            r1 = 19
            java.lang.String r0 = r0.extractMetadata(r1)     // Catch: java.lang.Throwable -> L65
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L65
            r16 = r0
            r0 = r8
            r1 = 24
            java.lang.String r0 = r0.extractMetadata(r1)     // Catch: java.lang.Throwable -> L65
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L65
            r20 = r0
            r0 = r20
            r1 = 90
            if (r0 == r1) goto L7a
            r0 = r18
            r17 = r0
            r0 = r16
            r19 = r0
            r0 = r20
            r1 = 270(0x10e, float:3.78E-43)
            if (r0 != r1) goto L3b
            goto L7a
        L3b:
            r0 = r14
            r1 = r17
            r2 = r19
            r3 = r12
            r4 = r13
            float r0 = r0.a(r1, r2, r3, r4)     // Catch: java.lang.Throwable -> L65
            r15 = r0
            r0 = r8
            r1 = r9
            r2 = r11
            r3 = r17
            float r3 = (float) r3     // Catch: java.lang.Throwable -> L65
            r4 = r15
            float r3 = r3 * r4
            int r3 = java.lang.Math.round(r3)     // Catch: java.lang.Throwable -> L65
            r4 = r15
            r5 = r19
            float r5 = (float) r5     // Catch: java.lang.Throwable -> L65
            float r4 = r4 * r5
            int r4 = java.lang.Math.round(r4)     // Catch: java.lang.Throwable -> L65
            android.graphics.Bitmap r0 = r0.getScaledFrameAtTime(r1, r2, r3, r4)     // Catch: java.lang.Throwable -> L65
            r8 = r0
            r0 = r8
            return r0
        L65:
            r8 = move-exception
            java.lang.String r0 = "VideoDecoder"
            r1 = 3
            boolean r0 = android.util.Log.isLoggable(r0, r1)
            if (r0 == 0) goto L78
            java.lang.String r0 = "VideoDecoder"
            java.lang.String r1 = "Exception trying to decode frame on oreo+"
            r2 = r8
            int r0 = android.util.Log.d(r0, r1, r2)
        L78:
            r0 = 0
            return r0
        L7a:
            r0 = r16
            r17 = r0
            r0 = r18
            r19 = r0
            goto L3b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.VideoDecoder.b(android.media.MediaMetadataRetriever, long, int, int, int, com.bumptech.glide.load.resource.bitmap.DownsampleStrategy):android.graphics.Bitmap");
    }

    public static ResourceDecoder<ParcelFileDescriptor, Bitmap> b(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new ParcelFileDescriptorInitializer());
    }

    public static ResourceDecoder<ByteBuffer, Bitmap> c(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new ByteBufferInitializer());
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<Bitmap> a(T t, int i, int i2, Options options) throws IOException {
        long longValue = ((Long) options.a(f20978a)).longValue();
        if (longValue < 0 && longValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
        Integer num = (Integer) options.a(b);
        Integer num2 = num;
        if (num == null) {
            num2 = 2;
        }
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.a(DownsampleStrategy.h);
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        if (downsampleStrategy == null) {
            downsampleStrategy2 = DownsampleStrategy.g;
        }
        MediaMetadataRetriever a2 = this.f.a();
        try {
            try {
                this.d.a(a2, t);
                Bitmap a3 = a(a2, longValue, num2.intValue(), i, i2, downsampleStrategy2);
                a2.release();
                return BitmapResource.a(a3, this.e);
            } catch (RuntimeException e) {
                throw new IOException(e);
            }
        } catch (Throwable th) {
            a2.release();
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean a(T t, Options options) {
        return true;
    }
}
