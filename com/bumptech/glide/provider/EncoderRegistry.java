package com.bumptech.glide.provider;

import com.bumptech.glide.load.Encoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/provider/EncoderRegistry.class */
public class EncoderRegistry {

    /* renamed from: a  reason: collision with root package name */
    private final List<Entry<?>> f7422a = new ArrayList();

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/provider/EncoderRegistry$Entry.class */
    static final class Entry<T> {

        /* renamed from: a  reason: collision with root package name */
        final Encoder<T> f7423a;
        private final Class<T> b;

        Entry(Class<T> cls, Encoder<T> encoder) {
            this.b = cls;
            this.f7423a = encoder;
        }

        boolean a(Class<?> cls) {
            return this.b.isAssignableFrom(cls);
        }
    }

    public <T> Encoder<T> a(Class<T> cls) {
        Entry<?> next;
        synchronized (this) {
            Iterator<Entry<?>> it = this.f7422a.iterator();
            do {
                if (!it.hasNext()) {
                    return null;
                }
                next = it.next();
            } while (!next.a(cls));
            return (Encoder<T>) next.f7423a;
        }
    }

    public <T> void a(Class<T> cls, Encoder<T> encoder) {
        synchronized (this) {
            this.f7422a.add(new Entry<>(cls, encoder));
        }
    }
}
