package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/gif/GifBitmapProvider.class */
public final class GifBitmapProvider implements GifDecoder.BitmapProvider {

    /* renamed from: a  reason: collision with root package name */
    private final BitmapPool f20990a;
    private final ArrayPool b;

    public GifBitmapProvider(BitmapPool bitmapPool, ArrayPool arrayPool) {
        this.f20990a = bitmapPool;
        this.b = arrayPool;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        return this.f20990a.b(i, i2, config);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public void a(Bitmap bitmap) {
        this.f20990a.a(bitmap);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public void a(byte[] bArr) {
        ArrayPool arrayPool = this.b;
        if (arrayPool == null) {
            return;
        }
        arrayPool.a((ArrayPool) bArr);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public void a(int[] iArr) {
        ArrayPool arrayPool = this.b;
        if (arrayPool == null) {
            return;
        }
        arrayPool.a((ArrayPool) iArr);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public byte[] a(int i) {
        ArrayPool arrayPool = this.b;
        return arrayPool == null ? new byte[i] : (byte[]) arrayPool.a(i, byte[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public int[] b(int i) {
        ArrayPool arrayPool = this.b;
        return arrayPool == null ? new int[i] : (int[]) arrayPool.a(i, int[].class);
    }
}
