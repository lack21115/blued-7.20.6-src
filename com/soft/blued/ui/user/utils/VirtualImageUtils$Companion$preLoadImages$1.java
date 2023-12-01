package com.soft.blued.ui.user.utils;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "VirtualImageUtils.kt", c = {59}, d = "invokeSuspend", e = "com.soft.blued.ui.user.utils.VirtualImageUtils$Companion$preLoadImages$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/utils/VirtualImageUtils$Companion$preLoadImages$1.class */
public final class VirtualImageUtils$Companion$preLoadImages$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f20650a;
    final /* synthetic */ CoroutineScope b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VirtualImageUtils$Companion$preLoadImages$1(CoroutineScope coroutineScope, Continuation<? super VirtualImageUtils$Companion$preLoadImages$1> continuation) {
        super(2, continuation);
        this.b = coroutineScope;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VirtualImageUtils$Companion$preLoadImages$1(this.b, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x009c, code lost:
        if (r0 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c5, code lost:
        if (r0 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00cb, code lost:
        com.soft.blued.ui.user.utils.VirtualImageUtils.Companion.b(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.user.utils.VirtualImageUtils$Companion$preLoadImages$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
