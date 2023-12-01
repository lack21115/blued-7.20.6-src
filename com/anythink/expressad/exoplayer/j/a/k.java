package com.anythink.expressad.exoplayer.j.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/a/k.class */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Object> f4730a = new HashMap();
    private final List<String> b = new ArrayList();

    private k a(String str, Object obj) {
        this.f4730a.put((String) com.anythink.expressad.exoplayer.k.a.a(str), com.anythink.expressad.exoplayer.k.a.a(obj));
        this.b.remove(str);
        return this;
    }

    private k a(String str, byte[] bArr) {
        return a(str, (Object) Arrays.copyOf(bArr, bArr.length));
    }

    public final k a(String str) {
        this.b.add(str);
        this.f4730a.remove(str);
        return this;
    }

    public final k a(String str, long j) {
        return a(str, Long.valueOf(j));
    }

    public final k a(String str, String str2) {
        return a(str, (Object) str2);
    }

    public final List<String> a() {
        return Collections.unmodifiableList(new ArrayList(this.b));
    }

    public final Map<String, Object> b() {
        HashMap hashMap = new HashMap(this.f4730a);
        for (Map.Entry entry : hashMap.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                entry.setValue(Arrays.copyOf(bArr, bArr.length));
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
