package com.bumptech.glide.load.data;

import android.content.IntentFilter;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/data/InputStreamRewinder.class */
public final class InputStreamRewinder implements DataRewinder<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final RecyclableBufferedInputStream f7115a;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/data/InputStreamRewinder$Factory.class */
    public static final class Factory implements DataRewinder.Factory<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayPool f7116a;

        public Factory(ArrayPool arrayPool) {
            this.f7116a = arrayPool;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public DataRewinder<InputStream> a(InputStream inputStream) {
            return new InputStreamRewinder(inputStream, this.f7116a);
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public Class<InputStream> a() {
            return InputStream.class;
        }
    }

    public InputStreamRewinder(InputStream inputStream, ArrayPool arrayPool) {
        RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        this.f7115a = recyclableBufferedInputStream;
        recyclableBufferedInputStream.mark(IntentFilter.MATCH_CATEGORY_PATH);
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    public void b() {
        this.f7115a.b();
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    /* renamed from: c */
    public InputStream a() throws IOException {
        this.f7115a.reset();
        return this.f7115a;
    }

    public void d() {
        this.f7115a.a();
    }
}
