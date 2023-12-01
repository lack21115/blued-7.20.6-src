package com.soft.blued.ui.setting.vm;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "MsgBackupVM.kt", c = {320}, d = "getTxCloudInfo", e = "com.soft.blued.ui.setting.vm.MsgBackupVM")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/vm/MsgBackupVM$getTxCloudInfo$1.class */
public final class MsgBackupVM$getTxCloudInfo$1 extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    Object f19976a;
    /* synthetic */ Object b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ MsgBackupVM f19977c;
    int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgBackupVM$getTxCloudInfo$1(MsgBackupVM msgBackupVM, Continuation<? super MsgBackupVM$getTxCloudInfo$1> continuation) {
        super(continuation);
        this.f19977c = msgBackupVM;
    }

    public final Object invokeSuspend(Object obj) {
        Object a2;
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        a2 = this.f19977c.a((Continuation) this);
        return a2;
    }
}
