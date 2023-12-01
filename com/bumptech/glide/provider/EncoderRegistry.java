package com.bumptech.glide.provider;

import com.bumptech.glide.load.Encoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/provider/EncoderRegistry.class */
public class EncoderRegistry {

    /* renamed from: a  reason: collision with root package name */
    private final List<Entry<?>> f21028a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/provider/EncoderRegistry$Entry.class */
    public static final class Entry<T> {

        /* renamed from: a  reason: collision with root package name */
        final Encoder<T> f21029a;
        private final Class<T> b;

        Entry(Class<T> cls, Encoder<T> encoder) {
            this.b = cls;
            this.f21029a = encoder;
        }

        boolean a(Class<?> cls) {
            return this.b.isAssignableFrom(cls);
        }
    }

    public <T> Encoder<T> a(Class<T> cls) {
        Entry<?> next;
        synchronized (this) {
            Iterator<Entry<?>> it = this.f21028a.iterator();
            do {
                if (!it.hasNext()) {
                    return null;
                }
                next = it.next();
            } while (!next.a(cls));
            return (Encoder<T>) next.f21029a;
        }
    }

    public <T> void a(Class<T> cls, Encoder<T> encoder) {
        synchronized (this) {
            this.f21028a.add(new Entry<>(cls, encoder));
        }
    }
}
