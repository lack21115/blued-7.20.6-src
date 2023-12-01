package com.tencent.liteav.videoproducer.capture;

import java.util.Comparator;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/ag.class */
final /* synthetic */ class ag implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    private static final ag f36863a = new ag();

    private ag() {
    }

    public static Comparator a() {
        return f36863a;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ((com.tencent.liteav.base.util.n) obj2).b() - ((com.tencent.liteav.base.util.n) obj).b();
    }
}
