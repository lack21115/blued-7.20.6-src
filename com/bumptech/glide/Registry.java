package com.bumptech.glide;

import androidx.core.util.Pools;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.data.DataRewinderRegistry;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ModelLoaderRegistry;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.TranscoderRegistry;
import com.bumptech.glide.provider.EncoderRegistry;
import com.bumptech.glide.provider.ImageHeaderParserRegistry;
import com.bumptech.glide.provider.LoadPathCache;
import com.bumptech.glide.provider.ModelToResourceClassCache;
import com.bumptech.glide.provider.ResourceDecoderRegistry;
import com.bumptech.glide.provider.ResourceEncoderRegistry;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/Registry.class */
public class Registry {

    /* renamed from: a  reason: collision with root package name */
    private final ModelLoaderRegistry f20662a;
    private final EncoderRegistry b;

    /* renamed from: c  reason: collision with root package name */
    private final ResourceDecoderRegistry f20663c;
    private final ResourceEncoderRegistry d;
    private final DataRewinderRegistry e;
    private final TranscoderRegistry f;
    private final ImageHeaderParserRegistry g;
    private final ModelToResourceClassCache h = new ModelToResourceClassCache();
    private final LoadPathCache i = new LoadPathCache();
    private final Pools.Pool<List<Throwable>> j;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/Registry$MissingComponentException.class */
    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(String str) {
            super(str);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/Registry$NoImageHeaderParserException.class */
    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/Registry$NoModelLoaderAvailableException.class */
    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(Class<?> cls, Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }

        public NoModelLoaderAvailableException(Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public <M> NoModelLoaderAvailableException(M m, List<ModelLoader<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/Registry$NoResultEncoderAvailableException.class */
    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/Registry$NoSourceEncoderAvailableException.class */
    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public Registry() {
        Pools.Pool<List<Throwable>> a2 = FactoryPools.a();
        this.j = a2;
        this.f20662a = new ModelLoaderRegistry(a2);
        this.b = new EncoderRegistry();
        this.f20663c = new ResourceDecoderRegistry();
        this.d = new ResourceEncoderRegistry();
        this.e = new DataRewinderRegistry();
        this.f = new TranscoderRegistry();
        this.g = new ImageHeaderParserRegistry();
        a(Arrays.asList("Gif", "Bitmap", "BitmapDrawable"));
    }

    private <Data, TResource, Transcode> List<DecodePath<Data, TResource, Transcode>> c(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.f20663c.b(cls, cls2)) {
            for (Class cls5 : this.f.b(cls4, cls3)) {
                arrayList.add(new DecodePath(cls, cls4, cls5, this.f20663c.a(cls, cls4), this.f.a(cls4, cls5), this.j));
            }
        }
        return arrayList;
    }

    public Registry a(ImageHeaderParser imageHeaderParser) {
        this.g.a(imageHeaderParser);
        return this;
    }

    public Registry a(DataRewinder.Factory<?> factory) {
        this.e.a(factory);
        return this;
    }

    public <Data> Registry a(Class<Data> cls, Encoder<Data> encoder) {
        this.b.a(cls, encoder);
        return this;
    }

    public <TResource> Registry a(Class<TResource> cls, ResourceEncoder<TResource> resourceEncoder) {
        this.d.a(cls, resourceEncoder);
        return this;
    }

    public <Data, TResource> Registry a(Class<Data> cls, Class<TResource> cls2, ResourceDecoder<Data, TResource> resourceDecoder) {
        a("legacy_append", cls, cls2, resourceDecoder);
        return this;
    }

    public <Model, Data> Registry a(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<Model, Data> modelLoaderFactory) {
        this.f20662a.a(cls, cls2, modelLoaderFactory);
        return this;
    }

    public <TResource, Transcode> Registry a(Class<TResource> cls, Class<Transcode> cls2, ResourceTranscoder<TResource, Transcode> resourceTranscoder) {
        this.f.a(cls, cls2, resourceTranscoder);
        return this;
    }

    public <Data, TResource> Registry a(String str, Class<Data> cls, Class<TResource> cls2, ResourceDecoder<Data, TResource> resourceDecoder) {
        this.f20663c.a(str, resourceDecoder, cls, cls2);
        return this;
    }

    public final Registry a(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        this.f20663c.a(arrayList);
        return this;
    }

    public <X> Encoder<X> a(X x) throws NoSourceEncoderAvailableException {
        Encoder<X> a2 = this.b.a(x.getClass());
        if (a2 != null) {
            return a2;
        }
        throw new NoSourceEncoderAvailableException(x.getClass());
    }

    public <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        LoadPath<?, ?, ?> a2 = this.i.a(cls, cls2, cls3);
        if (this.i.a(a2)) {
            return null;
        }
        LoadPath<?, ?, ?> loadPath = a2;
        if (a2 == null) {
            List<DecodePath<Data, TResource, Transcode>> c2 = c(cls, cls2, cls3);
            loadPath = c2.isEmpty() ? null : new LoadPath<>(cls, cls2, cls3, c2, this.j);
            this.i.a(cls, cls2, cls3, loadPath);
        }
        return loadPath;
    }

    public List<ImageHeaderParser> a() {
        List<ImageHeaderParser> a2 = this.g.a();
        if (a2.isEmpty()) {
            throw new NoImageHeaderParserException();
        }
        return a2;
    }

    public boolean a(Resource<?> resource) {
        return this.d.a(resource.a()) != null;
    }

    public <Data, TResource> Registry b(Class<Data> cls, Class<TResource> cls2, ResourceDecoder<Data, TResource> resourceDecoder) {
        b("legacy_prepend_all", cls, cls2, resourceDecoder);
        return this;
    }

    public <Model, Data> Registry b(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.f20662a.b(cls, cls2, modelLoaderFactory);
        return this;
    }

    public <Data, TResource> Registry b(String str, Class<Data> cls, Class<TResource> cls2, ResourceDecoder<Data, TResource> resourceDecoder) {
        this.f20663c.b(str, resourceDecoder, cls, cls2);
        return this;
    }

    public <X> ResourceEncoder<X> b(Resource<X> resource) throws NoResultEncoderAvailableException {
        ResourceEncoder<X> a2 = this.d.a(resource.a());
        if (a2 != null) {
            return a2;
        }
        throw new NoResultEncoderAvailableException(resource.a());
    }

    public <X> DataRewinder<X> b(X x) {
        return this.e.a((DataRewinderRegistry) x);
    }

    public <Model, TResource, Transcode> List<Class<?>> b(Class<Model> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        List<Class<?>> a2 = this.h.a(cls, cls2, cls3);
        ArrayList arrayList = a2;
        if (a2 == null) {
            arrayList = new ArrayList();
            for (Class<?> cls4 : this.f20662a.a((Class<?>) cls)) {
                for (Class<?> cls5 : this.f20663c.b(cls4, cls2)) {
                    if (!this.f.b(cls5, cls3).isEmpty() && !arrayList.contains(cls5)) {
                        arrayList.add(cls5);
                    }
                }
            }
            this.h.a(cls, cls2, cls3, Collections.unmodifiableList(arrayList));
        }
        return arrayList;
    }

    public <Model> List<ModelLoader<Model, ?>> c(Model model) {
        return this.f20662a.a((ModelLoaderRegistry) model);
    }
}
