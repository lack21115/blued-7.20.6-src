package com.blued.android.core.image.apng;

import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageLoaderOptions;
import com.blued.android.core.image.apng.decode.APNGParser;
import com.blued.android.core.image.apng.drawable.APNGDrawable;
import com.blued.android.core.image.apng.io.ByteBufferReader;
import com.blued.android.core.image.apng.loader.ByteBufferLoader;
import com.blued.android.core.utils.Log;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableResource;
import java.nio.ByteBuffer;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/ByteBufferApngDecoder.class */
public class ByteBufferApngDecoder implements ResourceDecoder<ByteBuffer, APNGDrawable> {
    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<APNGDrawable> a(final ByteBuffer byteBuffer, int i, int i2, Options options) {
        if (ImageLoader.a()) {
            Log.e("IMAGE", "ApngStreamDecoder -- decode ");
        }
        final APNGDrawable aPNGDrawable = new APNGDrawable(new ByteBufferLoader() { // from class: com.blued.android.core.image.apng.ByteBufferApngDecoder.1
            @Override // com.blued.android.core.image.apng.loader.ByteBufferLoader
            public ByteBuffer a() {
                byteBuffer.position(0);
                return byteBuffer;
            }
        });
        return new DrawableResource<APNGDrawable>(aPNGDrawable) { // from class: com.blued.android.core.image.apng.ByteBufferApngDecoder.2
            @Override // com.bumptech.glide.load.engine.Resource
            public Class<APNGDrawable> a() {
                return APNGDrawable.class;
            }

            @Override // com.bumptech.glide.load.engine.Resource
            public int b() {
                if (ImageLoader.a()) {
                    Log.e("IMAGE", "ApngStreamDecoder -- decode size : " + byteBuffer.limit());
                }
                return byteBuffer.limit();
            }

            @Override // com.bumptech.glide.load.engine.Resource
            public void c() {
                if (ImageLoader.a()) {
                    Log.e("IMAGE", "ApngStreamDecoder -- apngDrawable -- recycle ");
                }
                aPNGDrawable.c();
            }
        };
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean a(ByteBuffer byteBuffer, Options options) {
        if (ImageLoader.a()) {
            boolean booleanValue = ((Boolean) options.a(ImageLoaderOptions.b)).booleanValue();
            Log.e("IMAGE", "ByteBufferApngDecoder -- OPTION_IMAGE_LOADER_FROMAT_APNG = " + booleanValue + " source.length=" + byteBuffer.capacity());
            if (booleanValue) {
                Log.e("IMAGE", "ByteBufferApngDecoder -- isApng = " + APNGParser.a(new ByteBufferReader(byteBuffer)));
            }
        }
        return ((Boolean) options.a(ImageLoaderOptions.b)).booleanValue() && APNGParser.a(new ByteBufferReader(byteBuffer));
    }
}
