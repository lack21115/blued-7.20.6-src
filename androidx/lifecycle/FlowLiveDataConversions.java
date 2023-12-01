package androidx.lifecycle;

import java.time.Duration;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/FlowLiveDataConversions.class */
public final class FlowLiveDataConversions {
    public static final <T> Flow<T> asFlow(LiveData<T> liveData) {
        Intrinsics.e(liveData, "<this>");
        return FlowKt.a(new FlowLiveDataConversions$asFlow$1(liveData, null));
    }

    public static final <T> LiveData<T> asLiveData(Flow<? extends T> flow) {
        Intrinsics.e(flow, "<this>");
        return asLiveData$default(flow, (CoroutineContext) null, 0L, 3, (Object) null);
    }

    public static final <T> LiveData<T> asLiveData(Flow<? extends T> flow, CoroutineContext coroutineContext) {
        Intrinsics.e(flow, "<this>");
        Intrinsics.e(coroutineContext, "context");
        return asLiveData$default(flow, coroutineContext, 0L, 2, (Object) null);
    }

    public static final <T> LiveData<T> asLiveData(Flow<? extends T> flow, CoroutineContext coroutineContext, long j) {
        Intrinsics.e(flow, "<this>");
        Intrinsics.e(coroutineContext, "context");
        return CoroutineLiveDataKt.liveData(coroutineContext, j, new FlowLiveDataConversions$asLiveData$1(flow, null));
    }

    public static final <T> LiveData<T> asLiveData(Flow<? extends T> flow, CoroutineContext coroutineContext, Duration duration) {
        Intrinsics.e(flow, "<this>");
        Intrinsics.e(coroutineContext, "context");
        Intrinsics.e(duration, "timeout");
        return asLiveData(flow, coroutineContext, duration.toMillis());
    }

    public static /* synthetic */ LiveData asLiveData$default(Flow flow, CoroutineContext coroutineContext, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = (CoroutineContext) EmptyCoroutineContext.a;
        }
        if ((i & 2) != 0) {
            j = 5000;
        }
        return asLiveData(flow, coroutineContext, j);
    }

    public static /* synthetic */ LiveData asLiveData$default(Flow flow, CoroutineContext coroutineContext, Duration duration, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = (CoroutineContext) EmptyCoroutineContext.a;
        }
        return asLiveData(flow, coroutineContext, duration);
    }
}
