package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/gif/ByteBufferGifDecoder.class */
public class ByteBufferGifDecoder implements ResourceDecoder<ByteBuffer, GifDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private static final GifDecoderFactory f7381a = new GifDecoderFactory();
    private static final GifHeaderParserPool b = new GifHeaderParserPool();

    /* renamed from: c  reason: collision with root package name */
    private final Context f7382c;
    private final List<ImageHeaderParser> d;
    private final GifHeaderParserPool e;
    private final GifDecoderFactory f;
    private final GifBitmapProvider g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/gif/ByteBufferGifDecoder$GifDecoderFactory.class */
    public static class GifDecoderFactory {
        GifDecoderFactory() {
        }

        GifDecoder a(GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
            return new StandardGifDecoder(bitmapProvider, gifHeader, byteBuffer, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/gif/ByteBufferGifDecoder$GifHeaderParserPool.class */
    public static class GifHeaderParserPool {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<GifHeaderParser> f7383a = Util.a(0);

        GifHeaderParserPool() {
        }

        GifHeaderParser a(ByteBuffer byteBuffer) {
            GifHeaderParser a2;
            synchronized (this) {
                GifHeaderParser poll = this.f7383a.poll();
                GifHeaderParser gifHeaderParser = poll;
                if (poll == null) {
                    gifHeaderParser = new GifHeaderParser();
                }
                a2 = gifHeaderParser.a(byteBuffer);
            }
            return a2;
        }

        void a(GifHeaderParser gifHeaderParser) {
            synchronized (this) {
                gifHeaderParser.a();
                this.f7383a.offer(gifHeaderParser);
            }
        }
    }

    public ByteBufferGifDecoder(Context context, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this(context, list, bitmapPool, arrayPool, b, f7381a);
    }

    ByteBufferGifDecoder(Context context, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool, GifHeaderParserPool gifHeaderParserPool, GifDecoderFactory gifDecoderFactory) {
        this.f7382c = context.getApplicationContext();
        this.d = list;
        this.f = gifDecoderFactory;
        this.g = new GifBitmapProvider(bitmapPool, arrayPool);
        this.e = gifHeaderParserPool;
    }

    private static int a(GifHeader gifHeader, int i, int i2) {
        int min = Math.min(gifHeader.a() / i2, gifHeader.b() / i);
        int max = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
        if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i + "x" + i2 + "], actual dimens: [" + gifHeader.b() + "x" + gifHeader.a() + "]");
        }
        return max;
    }

    private GifDrawableResource a(ByteBuffer byteBuffer, int i, int i2, GifHeaderParser gifHeaderParser, Options options) {
        long a2 = LogTime.a();
        try {
            GifHeader b2 = gifHeaderParser.b();
            if (b2.c() > 0 && b2.d() == 0) {
                Bitmap.Config config = options.a(GifOptions.f7394a) == DecodeFormat.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                GifDecoder a3 = this.f.a(this.g, b2, byteBuffer, a(b2, i, i2));
                a3.a(config);
                a3.b();
                Bitmap i3 = a3.i();
                if (i3 == null) {
                }
                GifDrawableResource gifDrawableResource = new GifDrawableResource(new GifDrawable(this.f7382c, a3, UnitTransformation.a(), i, i2, i3));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    Log.v("BufferGifDecoder", "Decoded GIF from stream in " + LogTime.a(a2));
                }
                return gifDrawableResource;
            }
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + LogTime.a(a2));
                return null;
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + LogTime.a(a2));
            }
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public GifDrawableResource a(ByteBuffer byteBuffer, int i, int i2, Options options) {
        GifHeaderParser a2 = this.e.a(byteBuffer);
        try {
            return a(byteBuffer, i, i2, a2, options);
        } finally {
            this.e.a(a2);
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean a(ByteBuffer byteBuffer, Options options) throws IOException {
        return !((Boolean) options.a(GifOptions.b)).booleanValue() && ImageHeaderParserUtils.getType(this.d, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }
}
