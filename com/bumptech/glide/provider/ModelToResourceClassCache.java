package com.bumptech.glide.provider;

import androidx.collection.ArrayMap;
import com.bumptech.glide.util.MultiClassKey;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/provider/ModelToResourceClassCache.class */
public class ModelToResourceClassCache {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<MultiClassKey> f21033a = new AtomicReference<>();
    private final ArrayMap<MultiClassKey, List<Class<?>>> b = new ArrayMap<>();

    public List<Class<?>> a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        MultiClassKey multiClassKey;
        List<Class<?>> list;
        MultiClassKey andSet = this.f21033a.getAndSet(null);
        if (andSet == null) {
            multiClassKey = new MultiClassKey(cls, cls2, cls3);
        } else {
            andSet.a(cls, cls2, cls3);
            multiClassKey = andSet;
        }
        synchronized (this.b) {
            list = this.b.get(multiClassKey);
        }
        this.f21033a.set(multiClassKey);
        return list;
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3, List<Class<?>> list) {
        synchronized (this.b) {
            this.b.put(new MultiClassKey(cls, cls2, cls3), list);
        }
    }
}
