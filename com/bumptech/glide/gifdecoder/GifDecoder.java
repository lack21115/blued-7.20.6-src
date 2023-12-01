package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/gifdecoder/GifDecoder.class */
public interface GifDecoder {

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/gifdecoder/GifDecoder$BitmapProvider.class */
    public interface BitmapProvider {
        Bitmap a(int i, int i2, Bitmap.Config config);

        void a(Bitmap bitmap);

        void a(byte[] bArr);

        void a(int[] iArr);

        byte[] a(int i);

        int[] b(int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/gifdecoder/GifDecoder$GifDecodeStatus.class */
    public @interface GifDecodeStatus {
    }

    ByteBuffer a();

    void a(Bitmap.Config config);

    void b();

    int c();

    int d();

    int e();

    void f();

    int g();

    int h();

    Bitmap i();

    void j();
}
