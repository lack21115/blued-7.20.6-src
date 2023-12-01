package com.bumptech.glide.provider;

import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.resource.transcode.UnitTranscoder;
import com.bumptech.glide.util.MultiClassKey;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/provider/LoadPathCache.class */
public class LoadPathCache {

    /* renamed from: a  reason: collision with root package name */
    private static final LoadPath<?, ?, ?> f7425a = new LoadPath<>(Object.class, Object.class, Object.class, Collections.singletonList(new DecodePath(Object.class, Object.class, Object.class, Collections.emptyList(), new UnitTranscoder(), null)), null);
    private final ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> b = new ArrayMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final AtomicReference<MultiClassKey> f7426c = new AtomicReference<>();

    private MultiClassKey b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        MultiClassKey andSet = this.f7426c.getAndSet(null);
        MultiClassKey multiClassKey = andSet;
        if (andSet == null) {
            multiClassKey = new MultiClassKey();
        }
        multiClassKey.a(cls, cls2, cls3);
        return multiClassKey;
    }

    public <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        LoadPath<Data, TResource, Transcode> loadPath;
        MultiClassKey b = b(cls, cls2, cls3);
        synchronized (this.b) {
            loadPath = (LoadPath<Data, TResource, Transcode>) this.b.get(b);
        }
        this.f7426c.set(b);
        return loadPath;
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3, LoadPath<?, ?, ?> loadPath) {
        synchronized (this.b) {
            ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> arrayMap = this.b;
            MultiClassKey multiClassKey = new MultiClassKey(cls, cls2, cls3);
            if (loadPath == null) {
                loadPath = f7425a;
            }
            arrayMap.put(multiClassKey, loadPath);
        }
    }

    public boolean a(LoadPath<?, ?, ?> loadPath) {
        return f7425a.equals(loadPath);
    }
}
