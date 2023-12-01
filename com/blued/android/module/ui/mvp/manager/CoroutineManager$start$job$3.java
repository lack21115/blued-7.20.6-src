package com.blued.android.module.ui.mvp.manager;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(b = "CoroutineManager.kt", c = {51}, d = "invokeSuspend", e = "com.blued.android.module.ui.mvp.manager.CoroutineManager$start$job$3")
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/ui/mvp/manager/CoroutineManager$start$job$3.class */
final class CoroutineManager$start$job$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int a;
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> b;
    final /* synthetic */ CoroutineManager c;
    final /* synthetic */ String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CoroutineManager$start$job$3(Function1<? super Continuation<? super Unit>, ? extends Object> function1, CoroutineManager coroutineManager, String str, Continuation<? super CoroutineManager$start$job$3> continuation) {
        super(2, continuation);
        this.b = function1;
        this.c = coroutineManager;
        this.d = str;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoroutineManager$start$job$3) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CoroutineManager$start$job$3(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ConcurrentHashMap concurrentHashMap;
        Object a = IntrinsicsKt.a();
        int i = this.a;
        if (i == 0) {
            ResultKt.a(obj);
            Function1<Continuation<? super Unit>, Object> function1 = this.b;
            this.a = 1;
            if (function1.invoke(this) == a) {
                return a;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
        }
        concurrentHashMap = this.c.b;
        concurrentHashMap.remove(this.d);
        return Unit.a;
    }
}
