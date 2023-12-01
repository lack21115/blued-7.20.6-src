package com.bumptech.glide.provider;

import com.bumptech.glide.load.ResourceEncoder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/provider/ResourceEncoderRegistry.class */
public class ResourceEncoderRegistry {

    /* renamed from: a  reason: collision with root package name */
    private final List<Entry<?>> f7431a = new ArrayList();

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/provider/ResourceEncoderRegistry$Entry.class */
    static final class Entry<T> {

        /* renamed from: a  reason: collision with root package name */
        final ResourceEncoder<T> f7432a;
        private final Class<T> b;

        Entry(Class<T> cls, ResourceEncoder<T> resourceEncoder) {
            this.b = cls;
            this.f7432a = resourceEncoder;
        }

        boolean a(Class<?> cls) {
            return this.b.isAssignableFrom(cls);
        }
    }

    public <Z> ResourceEncoder<Z> a(Class<Z> cls) {
        synchronized (this) {
            int size = this.f7431a.size();
            for (int i = 0; i < size; i++) {
                Entry<?> entry = this.f7431a.get(i);
                if (entry.a(cls)) {
                    return (ResourceEncoder<Z>) entry.f7432a;
                }
            }
            return null;
        }
    }

    public <Z> void a(Class<Z> cls, ResourceEncoder<Z> resourceEncoder) {
        synchronized (this) {
            this.f7431a.add(new Entry<>(cls, resourceEncoder));
        }
    }
}
