package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/FlowExtKt.class */
public final class FlowExtKt {
    public static final <T> Flow<T> flowWithLifecycle(Flow<? extends T> flow, Lifecycle lifecycle, Lifecycle.State state) {
        Intrinsics.e(flow, "<this>");
        Intrinsics.e(lifecycle, "lifecycle");
        Intrinsics.e(state, "minActiveState");
        return FlowKt.b(new FlowExtKt$flowWithLifecycle$1(lifecycle, state, flow, null));
    }

    public static /* synthetic */ Flow flowWithLifecycle$default(Flow flow, Lifecycle lifecycle, Lifecycle.State state, int i, Object obj) {
        if ((i & 2) != 0) {
            state = Lifecycle.State.STARTED;
        }
        return flowWithLifecycle(flow, lifecycle, state);
    }
}
