package com.bumptech.glide.load.engine;

import androidx.core.util.Pools;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/LoadPath.class */
public class LoadPath<Data, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<Data> f7182a;
    private final Pools.Pool<List<Throwable>> b;

    /* renamed from: c  reason: collision with root package name */
    private final List<? extends DecodePath<Data, ResourceType, Transcode>> f7183c;
    private final String d;

    public LoadPath(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<DecodePath<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.f7182a = cls;
        this.b = pool;
        this.f7183c = (List) Preconditions.a(list);
        this.d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private Resource<Transcode> a(DataRewinder<Data> dataRewinder, Options options, int i, int i2, DecodePath.DecodeCallback<ResourceType> decodeCallback, List<Throwable> list) throws GlideException {
        Resource<Transcode> resource;
        int size = this.f7183c.size();
        Resource<Transcode> resource2 = null;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            resource = resource2;
            if (i4 >= size) {
                break;
            }
            try {
                resource2 = this.f7183c.get(i4).a(dataRewinder, i, i2, options, decodeCallback);
            } catch (GlideException e) {
                list.add(e);
            }
            if (resource2 != null) {
                resource = resource2;
                break;
            }
            i3 = i4 + 1;
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.d, new ArrayList(list));
    }

    public Resource<Transcode> a(DataRewinder<Data> dataRewinder, Options options, int i, int i2, DecodePath.DecodeCallback<ResourceType> decodeCallback) throws GlideException {
        List<Throwable> list = (List) Preconditions.a(this.b.acquire());
        try {
            return a(dataRewinder, options, i, i2, decodeCallback, list);
        } finally {
            this.b.release(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f7183c.toArray()) + '}';
    }
}
