package com.soft.blued.ui.msg_group.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(b = "GroupIdentifyViewModel.kt", c = {62, 68}, d = "invokeSuspend", e = "com.soft.blued.ui.msg_group.viewmodel.GroupIdentifyViewModel$submit$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/viewmodel/GroupIdentifyViewModel$submit$1.class */
final class GroupIdentifyViewModel$submit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f32847a;
    final /* synthetic */ GroupIdentifyViewModel b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f32848c;
    final /* synthetic */ String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupIdentifyViewModel$submit$1(GroupIdentifyViewModel groupIdentifyViewModel, String str, String str2, Continuation<? super GroupIdentifyViewModel$submit$1> continuation) {
        super(2, continuation);
        this.b = groupIdentifyViewModel;
        this.f32848c = str;
        this.d = str2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GroupIdentifyViewModel$submit$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GroupIdentifyViewModel$submit$1(this.b, this.f32848c, this.d, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x015f  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            Method dump skipped, instructions count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg_group.viewmodel.GroupIdentifyViewModel$submit$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
