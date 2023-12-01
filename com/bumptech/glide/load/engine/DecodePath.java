package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.core.util.Pools;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/DecodePath.class */
public class DecodePath<DataType, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<DataType> f7154a;
    private final List<? extends ResourceDecoder<DataType, ResourceType>> b;

    /* renamed from: c  reason: collision with root package name */
    private final ResourceTranscoder<ResourceType, Transcode> f7155c;
    private final Pools.Pool<List<Throwable>> d;
    private final String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/DecodePath$DecodeCallback.class */
    public interface DecodeCallback<ResourceType> {
        Resource<ResourceType> a(Resource<ResourceType> resource);
    }

    public DecodePath(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends ResourceDecoder<DataType, ResourceType>> list, ResourceTranscoder<ResourceType, Transcode> resourceTranscoder, Pools.Pool<List<Throwable>> pool) {
        this.f7154a = cls;
        this.b = list;
        this.f7155c = resourceTranscoder;
        this.d = pool;
        this.e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private Resource<ResourceType> a(DataRewinder<DataType> dataRewinder, int i, int i2, Options options) throws GlideException {
        List<Throwable> list = (List) Preconditions.a(this.d.acquire());
        try {
            return a(dataRewinder, i, i2, options, list);
        } finally {
            this.d.release(list);
        }
    }

    private Resource<ResourceType> a(DataRewinder<DataType> dataRewinder, int i, int i2, Options options, List<Throwable> list) throws GlideException {
        Resource<ResourceType> resource;
        int size = this.b.size();
        Resource<ResourceType> resource2 = null;
        int i3 = 0;
        while (true) {
            resource = resource2;
            if (i3 >= size) {
                break;
            }
            ResourceDecoder<DataType, ResourceType> resourceDecoder = this.b.get(i3);
            resource = resource2;
            try {
                if (resourceDecoder.a(dataRewinder.a(), options)) {
                    resource = resourceDecoder.a(dataRewinder.a(), i, i2, options);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + resourceDecoder, e);
                }
                list.add(e);
                resource = resource2;
            }
            if (resource != null) {
                break;
            }
            i3++;
            resource2 = resource;
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.e, new ArrayList(list));
    }

    public Resource<Transcode> a(DataRewinder<DataType> dataRewinder, int i, int i2, Options options, DecodeCallback<ResourceType> decodeCallback) throws GlideException {
        return this.f7155c.a(decodeCallback.a(a(dataRewinder, i, i2, options)), options);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f7154a + ", decoders=" + this.b + ", transcoder=" + this.f7155c + '}';
    }
}
