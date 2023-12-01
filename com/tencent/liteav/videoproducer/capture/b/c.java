package com.tencent.liteav.videoproducer.capture.b;

import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/b/c.class */
public final /* synthetic */ class c implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    private static final c f36902a = new c();

    private c() {
    }

    public static Comparator a() {
        return f36902a;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return a.a((int[]) obj, (int[]) obj2);
    }
}
