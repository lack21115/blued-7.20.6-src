package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/gif/StreamGifDecoder.class */
public class StreamGifDecoder implements ResourceDecoder<InputStream, GifDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final List<ImageHeaderParser> f7395a;
    private final ResourceDecoder<ByteBuffer, GifDrawable> b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayPool f7396c;

    public StreamGifDecoder(List<ImageHeaderParser> list, ResourceDecoder<ByteBuffer, GifDrawable> resourceDecoder, ArrayPool arrayPool) {
        this.f7395a = list;
        this.b = resourceDecoder;
        this.f7396c = arrayPool;
    }

    private static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (IOException e) {
            if (Log.isLoggable("StreamGifDecoder", 5)) {
                Log.w("StreamGifDecoder", "Error reading data from stream", e);
                return null;
            }
            return null;
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<GifDrawable> a(InputStream inputStream, int i, int i2, Options options) throws IOException {
        byte[] a2 = a(inputStream);
        if (a2 == null) {
            return null;
        }
        return this.b.a(ByteBuffer.wrap(a2), i, i2, options);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean a(InputStream inputStream, Options options) throws IOException {
        return !((Boolean) options.a(GifOptions.b)).booleanValue() && ImageHeaderParserUtils.getType(this.f7395a, inputStream, this.f7396c) == ImageHeaderParser.ImageType.GIF;
    }
}
