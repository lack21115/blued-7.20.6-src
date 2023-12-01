package io.github.inflationx.viewpump.internal;

import io.github.inflationx.viewpump.InflateRequest;
import io.github.inflationx.viewpump.InflateResult;
import io.github.inflationx.viewpump.Interceptor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* renamed from: io.github.inflationx.viewpump.internal.-InterceptorChain  reason: invalid class name */
/* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/internal/-InterceptorChain.class */
public final class InterceptorChain implements Interceptor.Chain {
    private final int index;
    private final List<Interceptor> interceptors;
    private final InflateRequest request;

    /* JADX WARN: Multi-variable type inference failed */
    public InterceptorChain(List<? extends Interceptor> list, int i, InflateRequest inflateRequest) {
        Intrinsics.d(list, "interceptors");
        Intrinsics.d(inflateRequest, "request");
        this.interceptors = list;
        this.index = i;
        this.request = inflateRequest;
    }

    @Override // io.github.inflationx.viewpump.Interceptor.Chain
    public InflateResult proceed(InflateRequest inflateRequest) {
        Intrinsics.d(inflateRequest, "request");
        if (this.index < this.interceptors.size()) {
            return this.interceptors.get(this.index).intercept(new InterceptorChain(this.interceptors, this.index + 1, inflateRequest));
        }
        throw new AssertionError("no interceptors added to the chain");
    }

    @Override // io.github.inflationx.viewpump.Interceptor.Chain
    public InflateRequest request() {
        return this.request;
    }
}
