package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.DebugKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/LockFreeTaskQueueCore.class */
public final class LockFreeTaskQueueCore<E> {
    public static final Companion a = new Companion(null);
    public static final Symbol b = new Symbol("REMOVE_FROZEN");
    private static final /* synthetic */ AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, Object.class, "_next");
    private static final /* synthetic */ AtomicLongFieldUpdater g = AtomicLongFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, "_state");
    private volatile /* synthetic */ Object _next = null;
    private volatile /* synthetic */ long _state = 0;
    private final int c;
    private final boolean d;
    private final int e;
    private /* synthetic */ AtomicReferenceArray h;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(long j) {
            return (j & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long a(long j, int i) {
            return a(j, 1073741823L) | (i << 0);
        }

        public final long a(long j, long j2) {
            return j & j2;
        }

        public final long b(long j, int i) {
            return a(j, 1152921503533105152L) | (i << 30);
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/LockFreeTaskQueueCore$Placeholder.class */
    public static final class Placeholder {
        public final int a;

        public Placeholder(int i) {
            this.a = i;
        }
    }

    public LockFreeTaskQueueCore(int i, boolean z) {
        this.c = i;
        this.d = z;
        this.e = i - 1;
        this.h = new AtomicReferenceArray(this.c);
        if (!(this.e <= 1073741823)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!((this.c & this.e) == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    private final LockFreeTaskQueueCore<E> a(int i, int i2) {
        long j;
        int i3;
        do {
            j = this._state;
            boolean z = false;
            i3 = (int) ((1073741823 & j) >> 0);
            if (DebugKt.a()) {
                if (i3 == i) {
                    z = true;
                }
                if (!z) {
                    throw new AssertionError();
                }
            }
            if ((1152921504606846976L & j) != 0) {
                return e();
            }
        } while (!g.compareAndSet(this, j, a.a(j, i2)));
        this.h.set(this.e & i3, null);
        return null;
    }

    private final LockFreeTaskQueueCore<E> a(int i, E e) {
        Object obj = this.h.get(this.e & i);
        if ((obj instanceof Placeholder) && ((Placeholder) obj).a == i) {
            this.h.set(i & this.e, e);
            return this;
        }
        return null;
    }

    private final LockFreeTaskQueueCore<E> a(long j) {
        while (true) {
            LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = (LockFreeTaskQueueCore) this._next;
            if (lockFreeTaskQueueCore != null) {
                return lockFreeTaskQueueCore;
            }
            f.compareAndSet(this, null, b(j));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final LockFreeTaskQueueCore<E> b(long j) {
        LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = new LockFreeTaskQueueCore<>(this.c * 2, this.d);
        int i = (int) ((1073741823 & j) >> 0);
        int i2 = (int) ((1152921503533105152L & j) >> 30);
        while (true) {
            int i3 = this.e;
            if ((i & i3) == (i2 & i3)) {
                lockFreeTaskQueueCore._state = a.a(j, 1152921504606846976L);
                return lockFreeTaskQueueCore;
            }
            Object obj = this.h.get(i3 & i);
            Placeholder placeholder = obj;
            if (obj == null) {
                placeholder = new Placeholder(i);
            }
            lockFreeTaskQueueCore.h.set(lockFreeTaskQueueCore.e & i, placeholder);
            i++;
        }
    }

    private final long f() {
        long j;
        long j2;
        do {
            j = this._state;
            if ((j & 1152921504606846976L) != 0) {
                return j;
            }
            j2 = j | 1152921504606846976L;
        } while (!g.compareAndSet(this, j, j2));
        return j2;
    }

    public final int a(E e) {
        while (true) {
            long j = this._state;
            if ((3458764513820540928L & j) != 0) {
                return a.a(j);
            }
            int i = (int) ((1073741823 & j) >> 0);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            int i3 = this.e;
            if (((i2 + 2) & i3) == (i & i3)) {
                return 1;
            }
            if (!this.d && this.h.get(i2 & i3) != null) {
                int i4 = this.c;
                if (i4 < 1024 || ((i2 - i) & 1073741823) > (i4 >> 1)) {
                    return 1;
                }
            } else if (g.compareAndSet(this, j, a.b(j, (i2 + 1) & 1073741823))) {
                this.h.set(i2 & i3, e);
                LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = this;
                while ((lockFreeTaskQueueCore._state & 1152921504606846976L) != 0) {
                    LockFreeTaskQueueCore<E> a2 = lockFreeTaskQueueCore.e().a(i2, (int) e);
                    lockFreeTaskQueueCore = a2;
                    if (a2 == null) {
                        return 0;
                    }
                }
                return 0;
            }
        }
    }

    public final boolean a() {
        long j = this._state;
        boolean z = false;
        if (((int) ((1073741823 & j) >> 0)) == ((int) ((j & 1152921503533105152L) >> 30))) {
            z = true;
        }
        return z;
    }

    public final int b() {
        long j = this._state;
        return 1073741823 & (((int) ((j & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j) >> 0)));
    }

    public final boolean c() {
        long j;
        do {
            j = this._state;
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!g.compareAndSet(this, j, j | 2305843009213693952L));
        return true;
    }

    public final Object d() {
        LockFreeTaskQueueCore<E> a2;
        while (true) {
            long j = this._state;
            if ((1152921504606846976L & j) != 0) {
                return b;
            }
            int i = (int) ((1073741823 & j) >> 0);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            int i3 = this.e;
            if ((i2 & i3) == (i & i3)) {
                return null;
            }
            Object obj = this.h.get(i3 & i);
            if (obj == null) {
                if (this.d) {
                    return null;
                }
            } else if (obj instanceof Placeholder) {
                return null;
            } else {
                int i4 = (i + 1) & 1073741823;
                if (g.compareAndSet(this, j, a.a(j, i4))) {
                    this.h.set(this.e & i, null);
                    return obj;
                } else if (this.d) {
                    LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = this;
                    do {
                        a2 = lockFreeTaskQueueCore.a(i, i4);
                        lockFreeTaskQueueCore = a2;
                    } while (a2 != null);
                    return obj;
                }
            }
        }
    }

    public final LockFreeTaskQueueCore<E> e() {
        return a(f());
    }
}
