package kotlinx.coroutines.debug.internal;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;

@Metadata
/* renamed from: kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesSynchronized$lambda-21$$inlined$sortedBy$1  reason: invalid class name */
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/debug/internal/DebugProbesImpl$dumpCoroutinesSynchronized$lambda-21$$inlined$sortedBy$1.class */
public final class DebugProbesImpl$dumpCoroutinesSynchronized$lambda21$$inlined$sortedBy$1<T> implements Comparator<T> {
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return ComparisonsKt.a(Long.valueOf(((DebugProbesImpl.CoroutineOwner) t).b.f43028a), Long.valueOf(((DebugProbesImpl.CoroutineOwner) t2).b.f43028a));
    }
}
