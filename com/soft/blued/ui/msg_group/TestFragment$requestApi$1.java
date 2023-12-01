package com.soft.blued.ui.msg_group;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "TestFragment.kt", c = {65, 67, 73, 73}, d = "invokeSuspend", e = "com.soft.blued.ui.msg_group.TestFragment$requestApi$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/TestFragment$requestApi$1.class */
public final class TestFragment$requestApi$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    Object f18932a;
    int b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ TestFragment f18933c;
    private /* synthetic */ Object d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TestFragment$requestApi$1(TestFragment testFragment, Continuation<? super TestFragment$requestApi$1> continuation) {
        super(2, continuation);
        this.f18933c = testFragment;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> testFragment$requestApi$1 = new TestFragment$requestApi$1(this.f18933c, continuation);
        testFragment$requestApi$1.d = obj;
        return testFragment$requestApi$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            Method dump skipped, instructions count: 453
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg_group.TestFragment$requestApi$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
