package kotlinx.coroutines.flow;

import com.android.internal.util.cm.SpamFilter;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "Count.kt", c = {39}, d = SpamFilter.SpamContract.NotificationTable.COUNT, e = "kotlinx.coroutines.flow.FlowKt__CountKt")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__CountKt$count$3.class */
public final class FlowKt__CountKt$count$3<T> extends ContinuationImpl {
    Object a;
    /* synthetic */ Object b;
    int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlowKt__CountKt$count$3(Continuation<? super FlowKt__CountKt$count$3> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.c |= Integer.MIN_VALUE;
        return FlowKt.b(null, null, this);
    }
}
