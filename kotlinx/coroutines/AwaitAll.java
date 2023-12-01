package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/AwaitAll.class */
public final class AwaitAll<T> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ AtomicIntegerFieldUpdater f42776a = AtomicIntegerFieldUpdater.newUpdater(AwaitAll.class, "notCompletedCount");
    private final Deferred<T>[] b;
    volatile /* synthetic */ int notCompletedCount;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/AwaitAll$AwaitAllNode.class */
    public final class AwaitAllNode extends JobNode {
        private volatile /* synthetic */ Object _disposer;

        /* renamed from: a  reason: collision with root package name */
        public DisposableHandle f42777a;
        final /* synthetic */ AwaitAll<T> b;
        private final CancellableContinuation<List<? extends T>> d;

        public final DisposableHandle a() {
            DisposableHandle disposableHandle = this.f42777a;
            if (disposableHandle != null) {
                return disposableHandle;
            }
            Intrinsics.c("handle");
            throw null;
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        public void a(Throwable th) {
            if (th != null) {
                Object a2 = this.d.a(th);
                if (a2 != null) {
                    this.d.a(a2);
                    AwaitAll<T>.DisposeHandlersOnCancel b = b();
                    if (b == null) {
                        return;
                    }
                    b.a();
                    return;
                }
                return;
            }
            if (AwaitAll.f42776a.decrementAndGet(this.b) != 0) {
                return;
            }
            CancellableContinuation<List<? extends T>> cancellableContinuation = this.d;
            Deferred[] deferredArr = ((AwaitAll) this.b).b;
            ArrayList arrayList = new ArrayList(deferredArr.length);
            int length = deferredArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    ArrayList arrayList2 = arrayList;
                    Result.Companion companion = Result.f42293a;
                    cancellableContinuation.resumeWith(Result.f(arrayList2));
                    return;
                }
                arrayList.add(deferredArr[i2].f());
                i = i2 + 1;
            }
        }

        public final AwaitAll<T>.DisposeHandlersOnCancel b() {
            return (DisposeHandlersOnCancel) this._disposer;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(Throwable th) {
            a(th);
            return Unit.f42314a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel.class */
    public final class DisposeHandlersOnCancel extends CancelHandler {

        /* renamed from: a  reason: collision with root package name */
        private final AwaitAll<T>.AwaitAllNode[] f42778a;

        public final void a() {
            AwaitAll<T>.AwaitAllNode[] awaitAllNodeArr = this.f42778a;
            int length = awaitAllNodeArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                awaitAllNodeArr[i2].a().dispose();
                i = i2 + 1;
            }
        }

        @Override // kotlinx.coroutines.CancelHandlerBase
        public void a(Throwable th) {
            a();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(Throwable th) {
            a(th);
            return Unit.f42314a;
        }

        public String toString() {
            return "DisposeHandlersOnCancel[" + this.f42778a + ']';
        }
    }
}
