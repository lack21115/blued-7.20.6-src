package androidx.lifecycle;

import java.time.Duration;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/FlowLiveDataConversions.class */
public final class FlowLiveDataConversions {
    public static final <T> Flow<T> asFlow(LiveData<T> liveData) {
        Intrinsics.e(liveData, "<this>");
        return FlowKt.a((Function2) new FlowLiveDataConversions$asFlow$1(liveData, null));
    }

    public static final <T> LiveData<T> asLiveData(Flow<? extends T> flow) {
        Intrinsics.e(flow, "<this>");
        return asLiveData$default(flow, (CoroutineContext) null, 0L, 3, (Object) null);
    }

    public static final <T> LiveData<T> asLiveData(Flow<? extends T> flow, CoroutineContext context) {
        Intrinsics.e(flow, "<this>");
        Intrinsics.e(context, "context");
        return asLiveData$default(flow, context, 0L, 2, (Object) null);
    }

    public static final <T> LiveData<T> asLiveData(Flow<? extends T> flow, CoroutineContext context, long j) {
        Intrinsics.e(flow, "<this>");
        Intrinsics.e(context, "context");
        return CoroutineLiveDataKt.liveData(context, j, new FlowLiveDataConversions$asLiveData$1(flow, null));
    }

    public static final <T> LiveData<T> asLiveData(Flow<? extends T> flow, CoroutineContext context, Duration timeout) {
        Intrinsics.e(flow, "<this>");
        Intrinsics.e(context, "context");
        Intrinsics.e(timeout, "timeout");
        return asLiveData(flow, context, timeout.toMillis());
    }

    public static /* synthetic */ LiveData asLiveData$default(Flow flow, CoroutineContext coroutineContext, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f42457a;
        }
        if ((i & 2) != 0) {
            j = 5000;
        }
        return asLiveData(flow, coroutineContext, j);
    }

    public static /* synthetic */ LiveData asLiveData$default(Flow flow, CoroutineContext coroutineContext, Duration duration, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f42457a;
        }
        return asLiveData(flow, coroutineContext, duration);
    }
}
