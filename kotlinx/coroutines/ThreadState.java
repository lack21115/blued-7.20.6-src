package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/ThreadState.class */
final class ThreadState implements Function1<Throwable, Unit> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(ThreadState.class, "_state");
    private final Job a;
    private DisposableHandle d;
    private volatile /* synthetic */ int _state = 0;
    private final Thread c = Thread.currentThread();

    public ThreadState(Job job) {
        this.a = job;
    }

    private final Void a(int i) {
        throw new IllegalStateException(Intrinsics.a("Illegal state ", (Object) Integer.valueOf(i)).toString());
    }

    public final void a() {
        int i;
        this.d = this.a.a(true, true, this);
        do {
            i = this._state;
            if (i != 0) {
                if (i == 2 || i == 3) {
                    return;
                }
                a(i);
                throw new KotlinNothingValueException();
            }
        } while (!b.compareAndSet(this, i, 0));
    }

    public void a(Throwable th) {
        int i;
        do {
            i = this._state;
            if (i != 0) {
                if (i == 1 || i == 2 || i == 3) {
                    return;
                }
                a(i);
                throw new KotlinNothingValueException();
            }
        } while (!b.compareAndSet(this, i, 2));
        this.c.interrupt();
        this._state = 3;
    }

    public final void b() {
        while (true) {
            int i = this._state;
            if (i != 0) {
                if (i != 2) {
                    if (i == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        a(i);
                        throw new KotlinNothingValueException();
                    }
                }
            } else if (b.compareAndSet(this, i, 1)) {
                DisposableHandle disposableHandle = this.d;
                if (disposableHandle == null) {
                    return;
                }
                disposableHandle.dispose();
                return;
            }
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Throwable th) {
        a(th);
        return Unit.a;
    }
}
