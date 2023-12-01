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
@DebugMetadata(b = "FinishProfileVM.kt", c = {55}, d = "invokeSuspend", e = "com.blued.login.vm.FinishProfileVM$checkNick$1")
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/vm/FinishProfileVM$checkNick$1.class */
public final class FinishProfileVM$checkNick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f20607a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f20608c;
    final /* synthetic */ FinishProfileVM d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FinishProfileVM$checkNick$1(String str, String str2, FinishProfileVM finishProfileVM, Continuation<? super FinishProfileVM$checkNick$1> continuation) {
        super(2, continuation);
        this.b = str;
        this.f20608c = str2;
        this.d = finishProfileVM;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FinishProfileVM$checkNick$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FinishProfileVM$checkNick$1(this.b, this.f20608c, this.d, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x017a A[Catch: all -> 0x0285, TRY_ENTER, TryCatch #1 {all -> 0x0285, blocks: (B:22:0x0100, B:24:0x0132, B:26:0x013f, B:28:0x014d, B:29:0x0153, B:31:0x016a, B:36:0x017a, B:38:0x0181, B:39:0x0187, B:41:0x018c, B:44:0x01aa, B:46:0x01dc, B:48:0x01e9, B:49:0x01f9, B:52:0x0212, B:57:0x0222, B:58:0x022b), top: B:72:0x00e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0187 A[Catch: all -> 0x0285, TRY_ENTER, TryCatch #1 {all -> 0x0285, blocks: (B:22:0x0100, B:24:0x0132, B:26:0x013f, B:28:0x014d, B:29:0x0153, B:31:0x016a, B:36:0x017a, B:38:0x0181, B:39:0x0187, B:41:0x018c, B:44:0x01aa, B:46:0x01dc, B:48:0x01e9, B:49:0x01f9, B:52:0x0212, B:57:0x0222, B:58:0x022b), top: B:72:0x00e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0222 A[Catch: all -> 0x0285, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0285, blocks: (B:22:0x0100, B:24:0x0132, B:26:0x013f, B:28:0x014d, B:29:0x0153, B:31:0x016a, B:36:0x017a, B:38:0x0181, B:39:0x0187, B:41:0x018c, B:44:0x01aa, B:46:0x01dc, B:48:0x01e9, B:49:0x01f9, B:52:0x0212, B:57:0x0222, B:58:0x022b), top: B:72:0x00e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x022b A[Catch: all -> 0x0285, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0285, blocks: (B:22:0x0100, B:24:0x0132, B:26:0x013f, B:28:0x014d, B:29:0x0153, B:31:0x016a, B:36:0x017a, B:38:0x0181, B:39:0x0187, B:41:0x018c, B:44:0x01aa, B:46:0x01dc, B:48:0x01e9, B:49:0x01f9, B:52:0x0212, B:57:0x0222, B:58:0x022b), top: B:72:0x00e9 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            Method dump skipped, instructions count: 659
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.login.vm.FinishProfileVM$checkNick$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
