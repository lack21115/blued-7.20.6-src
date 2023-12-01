package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/ByteBufferBitmapDecoder.class */
public class ByteBufferBitmapDecoder implements ResourceDecoder<ByteBuffer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final Downsampler f20941a;

    public ByteBufferBitmapDecoder(Downsampler downsampler) {
        this.f20941a = downsampler;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<Bitmap> a(ByteBuffer byteBuffer, int i, int i2, Options options) throws IOException {
        return this.f20941a.a(ByteBufferUtil.b(byteBuffer), i, i2, options);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean a(ByteBuffer byteBuffer, Options options) {
        return this.f20941a.a(byteBuffer);
    }
}
