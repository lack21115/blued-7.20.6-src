package com.blued.android.module.ui.mvp.manager;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(b = "CoroutineManager.kt", c = {}, d = "invokeSuspend", e = "com.blued.android.module.ui.mvp.manager.CoroutineManager$start$job$1")
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/ui/mvp/manager/CoroutineManager$start$job$1.class */
final class CoroutineManager$start$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f16043a;
    final /* synthetic */ Runnable b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ CoroutineManager f16044c;
    final /* synthetic */ String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoroutineManager$start$job$1(Runnable runnable, CoroutineManager coroutineManager, String str, Continuation<? super CoroutineManager$start$job$1> continuation) {
        super(2, continuation);
        this.b = runnable;
        this.f16044c = coroutineManager;
        this.d = str;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoroutineManager$start$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CoroutineManager$start$job$1(this.b, this.f16044c, this.d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ConcurrentHashMap concurrentHashMap;
        IntrinsicsKt.a();
        if (this.f16043a == 0) {
            ResultKt.a(obj);
            this.b.run();
            concurrentHashMap = this.f16044c.b;
            concurrentHashMap.remove(this.d);
            return Unit.f42314a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}