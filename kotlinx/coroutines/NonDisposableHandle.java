package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/NonDisposableHandle.class */
public final class NonDisposableHandle implements ChildHandle, DisposableHandle {

    /* renamed from: a  reason: collision with root package name */
    public static final NonDisposableHandle f42847a = new NonDisposableHandle();

    private NonDisposableHandle() {
    }

    @Override // kotlinx.coroutines.ChildHandle
    public Job a() {
        return null;
    }

    @Override // kotlinx.coroutines.ChildHandle
    public boolean b(Throwable th) {
        return false;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
    }

    public String toString() {
        return "NonDisposableHandle";
    }
}
