package com.blued.login.utils;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "LoginPreLoad.kt", c = {39}, d = "invokeSuspend", e = "com.blued.login.utils.LoginPreLoad$requestLoginSplash$1")
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/utils/LoginPreLoad$requestLoginSplash$1.class */
public final class LoginPreLoad$requestLoginSplash$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f20594a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LoginPreLoad$requestLoginSplash$1(Continuation<? super LoginPreLoad$requestLoginSplash$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LoginPreLoad$requestLoginSplash$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoginPreLoad$requestLoginSplash$1(continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0119, code lost:
        if (r0 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x011f, code lost:
        kotlinx.coroutines.Job.DefaultImpls.a(r6, null, 1, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0130, code lost:
        if (r0 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0136, code lost:
        kotlinx.coroutines.Job.DefaultImpls.a(r6, null, 1, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01eb, code lost:
        if (r0 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01f8, code lost:
        if (r0 == null) goto L29;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            Method dump skipped, instructions count: 590
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.login.utils.LoginPreLoad$requestLoginSplash$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
