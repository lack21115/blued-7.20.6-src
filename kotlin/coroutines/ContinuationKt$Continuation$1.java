package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/coroutines/ContinuationKt$Continuation$1.class */
public final class ContinuationKt$Continuation$1<T> implements Continuation<T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CoroutineContext f42455a;
    final /* synthetic */ Function1<Result<? extends T>, Unit> b;

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.f42455a;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        this.b.invoke(Result.g(obj));
    }
}
