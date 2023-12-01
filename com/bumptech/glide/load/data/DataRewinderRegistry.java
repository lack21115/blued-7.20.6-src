package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/data/DataRewinderRegistry.class */
public class DataRewinderRegistry {
    private static final DataRewinder.Factory<?> b = new DataRewinder.Factory<Object>() { // from class: com.bumptech.glide.load.data.DataRewinderRegistry.1
        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public DataRewinder<Object> a(Object obj) {
            return new DefaultRewinder(obj);
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public Class<Object> a() {
            throw new UnsupportedOperationException("Not implemented");
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, DataRewinder.Factory<?>> f7109a = new HashMap();

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/data/DataRewinderRegistry$DefaultRewinder.class */
    static final class DefaultRewinder implements DataRewinder<Object> {

        /* renamed from: a  reason: collision with root package name */
        private final Object f7110a;

        DefaultRewinder(Object obj) {
            this.f7110a = obj;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder
        public Object a() {
            return this.f7110a;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder
        public void b() {
        }
    }

    public <T> DataRewinder<T> a(T t) {
        DataRewinder<T> dataRewinder;
        synchronized (this) {
            Preconditions.a(t);
            DataRewinder.Factory<?> factory = this.f7109a.get(t.getClass());
            DataRewinder.Factory<?> factory2 = factory;
            if (factory == null) {
                Iterator<DataRewinder.Factory<?>> it = this.f7109a.values().iterator();
                do {
                    factory2 = factory;
                    if (!it.hasNext()) {
                        break;
                    }
                    factory2 = it.next();
                } while (!factory2.a().isAssignableFrom(t.getClass()));
            }
            DataRewinder.Factory<?> factory3 = factory2;
            if (factory2 == null) {
                factory3 = b;
            }
            dataRewinder = (DataRewinder<T>) factory3.a(t);
        }
        return dataRewinder;
    }

    public void a(DataRewinder.Factory<?> factory) {
        synchronized (this) {
            this.f7109a.put(factory.a(), factory);
        }
    }
}
