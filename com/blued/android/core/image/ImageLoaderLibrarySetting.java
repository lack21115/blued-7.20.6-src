package com.blued.android.core.image;

import android.content.Context;
import com.blued.android.core.image.apng.ByteBufferApngDecoder;
import com.blued.android.core.image.apng.StreamApngDecoder;
import com.blued.android.core.image.apng.drawable.APNGDrawable;
import com.blued.android.core.image.http.HttpModelLoader;
import com.blued.android.core.utils.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.LibraryGlideModule;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/ImageLoaderLibrarySetting.class */
public class ImageLoaderLibrarySetting extends LibraryGlideModule {
    @Override // com.bumptech.glide.module.LibraryGlideModule, com.bumptech.glide.module.RegistersComponents
    public void a(Context context, Glide glide, Registry registry) {
        if (ImageLoader.a()) {
            Log.e("IMAGE", "registerComponents ");
        }
        registry.b(GlideUrl.class, InputStream.class, new HttpModelLoader.Factory());
        ByteBufferApngDecoder byteBufferApngDecoder = new ByteBufferApngDecoder();
        registry.b(InputStream.class, APNGDrawable.class, new StreamApngDecoder(byteBufferApngDecoder));
        registry.b(ByteBuffer.class, APNGDrawable.class, byteBufferApngDecoder);
    }
}
