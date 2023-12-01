package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/ParcelFileDescriptorBitmapDecoder.class */
public final class ParcelFileDescriptorBitmapDecoder implements ResourceDecoder<ParcelFileDescriptor, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final Downsampler f20964a;

    public ParcelFileDescriptorBitmapDecoder(Downsampler downsampler) {
        this.f20964a = downsampler;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<Bitmap> a(ParcelFileDescriptor parcelFileDescriptor, int i, int i2, Options options) throws IOException {
        return this.f20964a.a(parcelFileDescriptor, i, i2, options);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean a(ParcelFileDescriptor parcelFileDescriptor, Options options) {
        return this.f20964a.a(parcelFileDescriptor);
    }
}
