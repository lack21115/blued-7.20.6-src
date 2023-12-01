package com.blued.android.module.ui.mvp.manager;

import com.blued.android.framework.pool.ThreadExecutor;
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
@DebugMetadata(b = "CoroutineManager.kt", c = {}, d = "invokeSuspend", e = "com.blued.android.module.ui.mvp.manager.CoroutineManager$start$job$2")
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/ui/mvp/manager/CoroutineManager$start$job$2.class */
final class CoroutineManager$start$job$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f16045a;
    final /* synthetic */ ThreadExecutor b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ CoroutineManager f16046c;
    final /* synthetic */ String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoroutineManager$start$job$2(ThreadExecutor threadExecutor, CoroutineManager coroutineManager, String str, Continuation<? super CoroutineManager$start$job$2> continuation) {
        super(2, continuation);
        this.b = threadExecutor;
        this.f16046c = coroutineManager;
        this.d = str;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoroutineManager$start$job$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CoroutineManager$start$job$2(this.b, this.f16046c, this.d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ConcurrentHashMap concurrentHashMap;
        IntrinsicsKt.a();
        if (this.f16045a == 0) {
            ResultKt.a(obj);
            this.b.run();
            concurrentHashMap = this.f16046c.b;
            concurrentHashMap.remove(this.d);
            return Unit.f42314a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
