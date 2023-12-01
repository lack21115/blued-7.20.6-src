package com.soft.blued.ui.msg_group.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(b = "GroupIdentifyViewModel.kt", c = {43, 48}, d = "invokeSuspend", e = "com.soft.blued.ui.msg_group.viewmodel.GroupIdentifyViewModel$getIdentifyInfo$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/viewmodel/GroupIdentifyViewModel$getIdentifyInfo$1.class */
final class GroupIdentifyViewModel$getIdentifyInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f32846a;
    final /* synthetic */ GroupIdentifyViewModel b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupIdentifyViewModel$getIdentifyInfo$1(GroupIdentifyViewModel groupIdentifyViewModel, Continuation<? super GroupIdentifyViewModel$getIdentifyInfo$1> continuation) {
        super(2, continuation);
        this.b = groupIdentifyViewModel;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GroupIdentifyViewModel$getIdentifyInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GroupIdentifyViewModel$getIdentifyInfo$1(this.b, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01c7  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg_group.viewmodel.GroupIdentifyViewModel$getIdentifyInfo$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
