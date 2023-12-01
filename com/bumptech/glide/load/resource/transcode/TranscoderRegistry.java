package com.bumptech.glide.load.resource.transcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/transcode/TranscoderRegistry.class */
public class TranscoderRegistry {

    /* renamed from: a  reason: collision with root package name */
    private final List<Entry<?, ?>> f21007a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/transcode/TranscoderRegistry$Entry.class */
    public static final class Entry<Z, R> {

        /* renamed from: a  reason: collision with root package name */
        final ResourceTranscoder<Z, R> f21008a;
        private final Class<Z> b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<R> f21009c;

        Entry(Class<Z> cls, Class<R> cls2, ResourceTranscoder<Z, R> resourceTranscoder) {
            this.b = cls;
            this.f21009c = cls2;
            this.f21008a = resourceTranscoder;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.b.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f21009c);
        }
    }

    public <Z, R> ResourceTranscoder<Z, R> a(Class<Z> cls, Class<R> cls2) {
        Entry<?, ?> next;
        synchronized (this) {
            if (cls2.isAssignableFrom(cls)) {
                return UnitTranscoder.a();
            }
            Iterator<Entry<?, ?>> it = this.f21007a.iterator();
            do {
                if (!it.hasNext()) {
                    throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
                }
                next = it.next();
            } while (!next.a(cls, cls2));
            return (ResourceTranscoder<Z, R>) next.f21008a;
        }
    }

    public <Z, R> void a(Class<Z> cls, Class<R> cls2, ResourceTranscoder<Z, R> resourceTranscoder) {
        synchronized (this) {
            this.f21007a.add(new Entry<>(cls, cls2, resourceTranscoder));
        }
    }

    public <Z, R> List<Class<R>> b(Class<Z> cls, Class<R> cls2) {
        synchronized (this) {
            ArrayList arrayList = new ArrayList();
            if (cls2.isAssignableFrom(cls)) {
                arrayList.add(cls2);
                return arrayList;
            }
            for (Entry<?, ?> entry : this.f21007a) {
                if (entry.a(cls, cls2)) {
                    arrayList.add(cls2);
                }
            }
            return arrayList;
        }
    }
}
