package java.util.concurrent;

import com.android.ims.ImsConferenceState;
import sun.misc.Unsafe;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/CountedCompleter.class */
public abstract class CountedCompleter<T> extends ForkJoinTask<T> {
    private static final long PENDING;
    private static final Unsafe U;
    private static final long serialVersionUID = 5232453752276485070L;
    final CountedCompleter<?> completer;
    volatile int pending;

    static {
        try {
            U = Unsafe.getUnsafe();
            PENDING = U.objectFieldOffset(CountedCompleter.class.getDeclaredField(ImsConferenceState.STATUS_PENDING));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    protected CountedCompleter() {
        this.completer = null;
    }

    protected CountedCompleter(CountedCompleter<?> countedCompleter) {
        this.completer = countedCompleter;
    }

    protected CountedCompleter(CountedCompleter<?> countedCompleter, int i) {
        this.completer = countedCompleter;
        this.pending = i;
    }

    public final void addToPendingCount(int i) {
        Unsafe unsafe;
        long j;
        int i2;
        do {
            unsafe = U;
            j = PENDING;
            i2 = this.pending;
        } while (!unsafe.compareAndSwapInt(this, j, i2, i2 + i));
    }

    public final boolean compareAndSetPendingCount(int i, int i2) {
        return U.compareAndSwapInt(this, PENDING, i, i2);
    }

    @Override // java.util.concurrent.ForkJoinTask
    public void complete(T t) {
        setRawResult(t);
        onCompletion(this);
        quietlyComplete();
        CountedCompleter<?> countedCompleter = this.completer;
        if (countedCompleter != null) {
            countedCompleter.tryComplete();
        }
    }

    public abstract void compute();

    public final int decrementPendingCountUnlessZero() {
        int i;
        do {
            i = this.pending;
            if (i == 0) {
                break;
            }
        } while (!U.compareAndSwapInt(this, PENDING, i, i - 1));
        return i;
    }

    @Override // java.util.concurrent.ForkJoinTask
    protected final boolean exec() {
        compute();
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final CountedCompleter<?> firstComplete() {
        int i;
        do {
            i = this.pending;
            if (i == 0) {
                return this;
            }
        } while (!U.compareAndSwapInt(this, PENDING, i, i - 1));
        return null;
    }

    public final CountedCompleter<?> getCompleter() {
        return this.completer;
    }

    public final int getPendingCount() {
        return this.pending;
    }

    @Override // java.util.concurrent.ForkJoinTask
    public T getRawResult() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final CountedCompleter<?> getRoot() {
        CountedCompleter countedCompleter = this;
        while (true) {
            CountedCompleter countedCompleter2 = countedCompleter;
            CountedCompleter countedCompleter3 = countedCompleter2.completer;
            if (countedCompleter3 == null) {
                return countedCompleter2;
            }
            countedCompleter = countedCompleter3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.ForkJoinTask
    void internalPropagateException(Throwable th) {
        CountedCompleter countedCompleter = this;
        CountedCompleter countedCompleter2 = countedCompleter;
        while (countedCompleter.onExceptionalCompletion(th, countedCompleter2)) {
            countedCompleter2 = countedCompleter;
            CountedCompleter countedCompleter3 = countedCompleter.completer;
            if (countedCompleter3 == null || countedCompleter3.status < 0) {
                return;
            }
            countedCompleter = countedCompleter3;
            if (countedCompleter3.recordExceptionalCompletion(th) != Integer.MIN_VALUE) {
                return;
            }
        }
    }

    public final CountedCompleter<?> nextComplete() {
        CountedCompleter<?> countedCompleter = this.completer;
        if (countedCompleter != null) {
            return countedCompleter.firstComplete();
        }
        quietlyComplete();
        return null;
    }

    public void onCompletion(CountedCompleter<?> countedCompleter) {
    }

    public boolean onExceptionalCompletion(Throwable th, CountedCompleter<?> countedCompleter) {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void propagateCompletion() {
        CountedCompleter countedCompleter = this;
        while (true) {
            CountedCompleter countedCompleter2 = countedCompleter;
            int i = countedCompleter2.pending;
            if (i == 0) {
                CountedCompleter countedCompleter3 = countedCompleter2.completer;
                countedCompleter = countedCompleter3;
                if (countedCompleter3 == null) {
                    countedCompleter2.quietlyComplete();
                    return;
                }
            } else {
                countedCompleter = countedCompleter2;
                if (U.compareAndSwapInt(countedCompleter2, PENDING, i, i - 1)) {
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void quietlyCompleteRoot() {
        CountedCompleter countedCompleter = this;
        while (true) {
            CountedCompleter countedCompleter2 = countedCompleter;
            CountedCompleter countedCompleter3 = countedCompleter2.completer;
            if (countedCompleter3 == null) {
                countedCompleter2.quietlyComplete();
                return;
            }
            countedCompleter = countedCompleter3;
        }
    }

    public final void setPendingCount(int i) {
        this.pending = i;
    }

    @Override // java.util.concurrent.ForkJoinTask
    protected void setRawResult(T t) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void tryComplete() {
        CountedCompleter countedCompleter = this;
        CountedCompleter countedCompleter2 = countedCompleter;
        while (true) {
            int i = countedCompleter.pending;
            if (i == 0) {
                countedCompleter.onCompletion(countedCompleter2);
                CountedCompleter countedCompleter3 = countedCompleter;
                CountedCompleter countedCompleter4 = countedCompleter.completer;
                countedCompleter = countedCompleter4;
                countedCompleter2 = countedCompleter3;
                if (countedCompleter4 == null) {
                    countedCompleter3.quietlyComplete();
                    return;
                }
            } else if (U.compareAndSwapInt(countedCompleter, PENDING, i, i - 1)) {
                return;
            }
        }
    }
}
