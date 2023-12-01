package com.tencent.ugc;

import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/br.class */
final /* synthetic */ class br implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner f26579a;
    private final List b;

    private br(TXVideoJoiner tXVideoJoiner, List list) {
        this.f26579a = tXVideoJoiner;
        this.b = list;
    }

    public static Runnable a(TXVideoJoiner tXVideoJoiner, List list) {
        return new br(tXVideoJoiner, list);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoJoiner.lambda$setVideoPathList$0(this.f26579a, this.b);
    }
}
