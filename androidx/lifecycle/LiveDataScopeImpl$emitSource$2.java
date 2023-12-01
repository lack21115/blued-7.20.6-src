package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DisposableHandle;

@Metadata
@DebugMetadata(b = "CoroutineLiveData.kt", c = {94}, d = "invokeSuspend", e = "androidx.lifecycle.LiveDataScopeImpl$emitSource$2")
/* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/LiveDataScopeImpl$emitSource$2.class */
final class LiveDataScopeImpl$emitSource$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DisposableHandle>, Object> {
    final /* synthetic */ LiveData<T> $source;
    int label;
    final /* synthetic */ LiveDataScopeImpl<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveDataScopeImpl$emitSource$2(LiveDataScopeImpl<T> liveDataScopeImpl, LiveData<T> liveData, Continuation<? super LiveDataScopeImpl$emitSource$2> continuation) {
        super(2, continuation);
        this.this$0 = liveDataScopeImpl;
        this.$source = liveData;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LiveDataScopeImpl$emitSource$2(this.this$0, this.$source, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super DisposableHandle> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object a2 = IntrinsicsKt.a();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.a(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.a(obj);
        this.label = 1;
        Object emitSource$lifecycle_livedata_ktx_release = this.this$0.getTarget$lifecycle_livedata_ktx_release().emitSource$lifecycle_livedata_ktx_release(this.$source, (Continuation) this);
        return emitSource$lifecycle_livedata_ktx_release == a2 ? a2 : emitSource$lifecycle_livedata_ktx_release;
    }
}
