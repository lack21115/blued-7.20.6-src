package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/InputStreamBitmapImageDecoderResourceDecoder.class */
public final class InputStreamBitmapImageDecoderResourceDecoder implements ResourceDecoder<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final BitmapImageDecoderResourceDecoder f20962a = new BitmapImageDecoderResourceDecoder();

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<Bitmap> a(InputStream inputStream, int i, int i2, Options options) throws IOException {
        return this.f20962a.a(ImageDecoder.createSource(ByteBufferUtil.a(inputStream)), i, i2, options);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean a(InputStream inputStream, Options options) throws IOException {
        return true;
    }
}
