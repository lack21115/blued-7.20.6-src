package com.tencent.liteav.videoproducer.capture.a;

import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/a/c.class */
public final /* synthetic */ class c implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    private static final c f36855a = new c();

    private c() {
    }

    public static Comparator a() {
        return f36855a;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return a.a((int[]) obj, (int[]) obj2);
    }
}
