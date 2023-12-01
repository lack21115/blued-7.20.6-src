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
    private final RecyclableBufferedInputStream f20721a;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/data/InputStreamRewinder$Factory.class */
    public static final class Factory implements DataRewinder.Factory<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayPool f20722a;

        public Factory(ArrayPool arrayPool) {
            this.f20722a = arrayPool;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public DataRewinder<InputStream> a(InputStream inputStream) {
            return new InputStreamRewinder(inputStream, this.f20722a);
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public Class<InputStream> a() {
            return InputStream.class;
        }
    }

    public InputStreamRewinder(InputStream inputStream, ArrayPool arrayPool) {
        RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        this.f20721a = recyclableBufferedInputStream;
        recyclableBufferedInputStream.mark(IntentFilter.MATCH_CATEGORY_PATH);
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    public void b() {
        this.f20721a.b();
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    /* renamed from: c */
    public InputStream a() throws IOException {
        this.f20721a.reset();
        return this.f20721a;
    }

    public void d() {
        this.f20721a.a();
    }
}
