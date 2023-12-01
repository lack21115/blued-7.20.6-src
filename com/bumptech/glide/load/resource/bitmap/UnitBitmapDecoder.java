package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Util;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/UnitBitmapDecoder.class */
public final class UnitBitmapDecoder implements ResourceDecoder<Bitmap, Bitmap> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/UnitBitmapDecoder$NonOwnedBitmapResource.class */
    public static final class NonOwnedBitmapResource implements Resource<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        private final Bitmap f7371a;

        NonOwnedBitmapResource(Bitmap bitmap) {
            this.f7371a = bitmap;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public Class<Bitmap> a() {
            return Bitmap.class;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public int b() {
            return Util.a(this.f7371a);
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public void c() {
        }

        @Override // com.bumptech.glide.load.engine.Resource
        /* renamed from: d */
        public Bitmap f() {
            return this.f7371a;
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<Bitmap> a(Bitmap bitmap, int i, int i2, Options options) {
        return new NonOwnedBitmapResource(bitmap);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean a(Bitmap bitmap, Options options) {
        return true;
    }
}
