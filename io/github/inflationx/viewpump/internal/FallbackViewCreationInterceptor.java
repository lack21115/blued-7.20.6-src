package io.github.inflationx.viewpump.internal;

import io.github.inflationx.viewpump.Interceptor;
import kotlin.Metadata;

@Metadata
/* renamed from: io.github.inflationx.viewpump.internal.-FallbackViewCreationInterceptor  reason: invalid class name */
/* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/internal/-FallbackViewCreationInterceptor.class */
public final class FallbackViewCreationInterceptor implements Interceptor {
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003a, code lost:
        if (r8 != null) goto L7;
     */
    @Override // io.github.inflationx.viewpump.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public io.github.inflationx.viewpump.InflateResult intercept(io.github.inflationx.viewpump.Interceptor.Chain r8) {
        /*
            r7 = this;
            r0 = r8
            java.lang.String r1 = "chain"
            kotlin.jvm.internal.Intrinsics.d(r0, r1)
            r0 = r8
            io.github.inflationx.viewpump.InflateRequest r0 = r0.request()
            r9 = r0
            r0 = r9
            io.github.inflationx.viewpump.FallbackViewCreator r0 = r0.fallbackViewCreator()
            r1 = r9
            android.view.View r1 = r1.parent()
            r2 = r9
            java.lang.String r2 = r2.name()
            r3 = r9
            android.content.Context r3 = r3.context()
            r4 = r9
            android.util.AttributeSet r4 = r4.attrs()
            android.view.View r0 = r0.onCreateView(r1, r2, r3, r4)
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L40
            r0 = r10
            java.lang.Class r0 = r0.getClass()
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L40
            r0 = r8
            java.lang.String r0 = r0.getName()
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L40
            goto L45
        L40:
            r0 = r9
            java.lang.String r0 = r0.name()
            r8 = r0
        L45:
            io.github.inflationx.viewpump.InflateResult r0 = new io.github.inflationx.viewpump.InflateResult
            r1 = r0
            r2 = r10
            r3 = r8
            r4 = r9
            android.content.Context r4 = r4.context()
            r5 = r9
            android.util.AttributeSet r5 = r5.attrs()
            r1.<init>(r2, r3, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.github.inflationx.viewpump.internal.FallbackViewCreationInterceptor.intercept(io.github.inflationx.viewpump.Interceptor$Chain):io.github.inflationx.viewpump.InflateResult");
    }
}
