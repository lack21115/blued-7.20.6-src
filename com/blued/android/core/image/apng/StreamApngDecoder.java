package com.blued.android.core.image.apng;

import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageLoaderOptions;
import com.blued.android.core.image.apng.decode.APNGParser;
import com.blued.android.core.image.apng.drawable.APNGDrawable;
import com.blued.android.core.image.apng.io.StreamReader;
import com.blued.android.core.utils.Log;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/StreamApngDecoder.class */
public class StreamApngDecoder implements ResourceDecoder<InputStream, APNGDrawable> {
    private final ResourceDecoder<ByteBuffer, APNGDrawable> a;

    public StreamApngDecoder(ResourceDecoder<ByteBuffer, APNGDrawable> resourceDecoder) {
        this.a = resourceDecoder;
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
            return null;
        }
    }

    public Resource<APNGDrawable> a(InputStream inputStream, int i, int i2, Options options) throws IOException {
        byte[] a = a(inputStream);
        if (a != null) {
            return this.a.a(ByteBuffer.wrap(a), i, i2, options);
        } else if (ImageLoader.a()) {
            Log.e("IMAGE", "StreamApngDecoder -- decode null!!!");
            return null;
        } else {
            return null;
        }
    }

    public boolean a(InputStream inputStream, Options options) {
        if (ImageLoader.a()) {
            boolean booleanValue = ((Boolean) options.a(ImageLoaderOptions.b)).booleanValue();
            Log.e("IMAGE", "StreamApngDecoder -- OPTION_IMAGE_LOADER_FROMAT_APNG = " + booleanValue);
            if (booleanValue) {
                Log.e("IMAGE", "StreamApngDecoder -- isApng = " + APNGParser.a(new StreamReader(inputStream)));
            }
        }
        return ((Boolean) options.a(ImageLoaderOptions.b)).booleanValue() && APNGParser.a(new StreamReader(inputStream));
    }
}
