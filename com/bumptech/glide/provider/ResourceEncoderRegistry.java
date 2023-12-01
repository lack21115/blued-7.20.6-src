package com.bumptech.glide.provider;

import com.bumptech.glide.load.ResourceEncoder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/provider/ResourceEncoderRegistry.class */
public class ResourceEncoderRegistry {

    /* renamed from: a  reason: collision with root package name */
    private final List<Entry<?>> f21037a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/provider/ResourceEncoderRegistry$Entry.class */
    public static final class Entry<T> {

        /* renamed from: a  reason: collision with root package name */
        final ResourceEncoder<T> f21038a;
        private final Class<T> b;

        Entry(Class<T> cls, ResourceEncoder<T> resourceEncoder) {
            this.b = cls;
            this.f21038a = resourceEncoder;
        }

        boolean a(Class<?> cls) {
            return this.b.isAssignableFrom(cls);
        }
    }

    public <Z> ResourceEncoder<Z> a(Class<Z> cls) {
        synchronized (this) {
            int size = this.f21037a.size();
            for (int i = 0; i < size; i++) {
                Entry<?> entry = this.f21037a.get(i);
                if (entry.a(cls)) {
                    return (ResourceEncoder<Z>) entry.f21038a;
                }
            }
            return null;
        }
    }

    public <Z> void a(Class<Z> cls, ResourceEncoder<Z> resourceEncoder) {
        synchronized (this) {
            this.f21037a.add(new Entry<>(cls, resourceEncoder));
        }
    }
}
