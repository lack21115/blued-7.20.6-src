package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/DataCacheWriter.class */
class DataCacheWriter<DataType> implements DiskCache.Writer {

    /* renamed from: a  reason: collision with root package name */
    private final Encoder<DataType> f7137a;
    private final DataType b;

    /* renamed from: c  reason: collision with root package name */
    private final Options f7138c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataCacheWriter(Encoder<DataType> encoder, DataType datatype, Options options) {
        this.f7137a = encoder;
        this.b = datatype;
        this.f7138c = options;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache.Writer
    public boolean a(File file) {
        return this.f7137a.a(this.b, file, this.f7138c);
    }
}
