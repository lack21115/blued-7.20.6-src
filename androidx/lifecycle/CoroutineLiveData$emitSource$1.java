package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "CoroutineLiveData.kt", c = {227, 228}, d = "emitSource$lifecycle_livedata_ktx_release", e = "androidx.lifecycle.CoroutineLiveData")
/* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/CoroutineLiveData$emitSource$1.class */
public final class CoroutineLiveData$emitSource$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CoroutineLiveData<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineLiveData$emitSource$1(CoroutineLiveData<T> coroutineLiveData, Continuation<? super CoroutineLiveData$emitSource$1> continuation) {
        super(continuation);
        this.this$0 = coroutineLiveData;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emitSource$lifecycle_livedata_ktx_release(null, (Continuation) this);
    }
}
