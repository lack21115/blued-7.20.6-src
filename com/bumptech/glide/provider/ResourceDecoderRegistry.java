package com.bumptech.glide.provider;

import com.bumptech.glide.load.ResourceDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/provider/ResourceDecoderRegistry.class */
public class ResourceDecoderRegistry {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f21034a = new ArrayList();
    private final Map<String, List<Entry<?, ?>>> b = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/provider/ResourceDecoderRegistry$Entry.class */
    public static class Entry<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final Class<R> f21035a;
        final ResourceDecoder<T, R> b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<T> f21036c;

        public Entry(Class<T> cls, Class<R> cls2, ResourceDecoder<T, R> resourceDecoder) {
            this.f21036c = cls;
            this.f21035a = cls2;
            this.b = resourceDecoder;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.f21036c.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f21035a);
        }
    }

    private List<Entry<?, ?>> a(String str) {
        ArrayList arrayList;
        synchronized (this) {
            if (!this.f21034a.contains(str)) {
                this.f21034a.add(str);
            }
            List<Entry<?, ?>> list = this.b.get(str);
            arrayList = list;
            if (list == null) {
                arrayList = new ArrayList();
                this.b.put(str, arrayList);
            }
        }
        return arrayList;
    }

    public <T, R> List<ResourceDecoder<T, R>> a(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList();
            for (String str : this.f21034a) {
                List<Entry<?, ?>> list = this.b.get(str);
                if (list != null) {
                    for (Entry<?, ?> entry : list) {
                        if (entry.a(cls, cls2)) {
                            arrayList.add(entry.b);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public <T, R> void a(String str, ResourceDecoder<T, R> resourceDecoder, Class<T> cls, Class<R> cls2) {
        synchronized (this) {
            a(str).add(new Entry<>(cls, cls2, resourceDecoder));
        }
    }

    public void a(List<String> list) {
        synchronized (this) {
            ArrayList<String> arrayList = new ArrayList(this.f21034a);
            this.f21034a.clear();
            for (String str : list) {
                this.f21034a.add(str);
            }
            for (String str2 : arrayList) {
                if (!list.contains(str2)) {
                    this.f21034a.add(str2);
                }
            }
        }
    }

    public <T, R> List<Class<R>> b(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList();
            for (String str : this.f21034a) {
                List<Entry<?, ?>> list = this.b.get(str);
                if (list != null) {
                    for (Entry<?, ?> entry : list) {
                        if (entry.a(cls, cls2) && !arrayList.contains(entry.f21035a)) {
                            arrayList.add(entry.f21035a);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public <T, R> void b(String str, ResourceDecoder<T, R> resourceDecoder, Class<T> cls, Class<R> cls2) {
        synchronized (this) {
            a(str).add(0, new Entry<>(cls, cls2, resourceDecoder));
        }
    }
}
