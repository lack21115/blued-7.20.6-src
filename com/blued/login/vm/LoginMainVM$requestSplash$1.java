package com.blued.login.vm;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "LoginMainVM.kt", c = {35}, d = "invokeSuspend", e = "com.blued.login.vm.LoginMainVM$requestSplash$1")
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/vm/LoginMainVM$requestSplash$1.class */
public final class LoginMainVM$requestSplash$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f20619a;
    final /* synthetic */ LoginMainVM b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginMainVM$requestSplash$1(LoginMainVM loginMainVM, Continuation<? super LoginMainVM$requestSplash$1> continuation) {
        super(2, continuation);
        this.b = loginMainVM;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LoginMainVM$requestSplash$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoginMainVM$requestSplash$1(this.b, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00d2, code lost:
        if (r7 != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00d5, code lost:
        r0.d().postValue(com.blued.login.utils.LoginPreLoad.f20592a.a());
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0146, code lost:
        if ((r0 != null && r0.is_open() == 1) != false) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            Method dump skipped, instructions count: 377
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.login.vm.LoginMainVM$requestSplash$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
