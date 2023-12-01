package android.os;

/* loaded from: source-9557208-dex2jar.jar:android/os/ConditionVariable.class */
public class ConditionVariable {
    private volatile boolean mCondition;

    public ConditionVariable() {
        this.mCondition = false;
    }

    public ConditionVariable(boolean z) {
        this.mCondition = z;
    }

    public void block() {
        synchronized (this) {
            while (!this.mCondition) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x004c -> B:13:0x002d). Please submit an issue!!! */
    public boolean block(long j) {
        boolean z;
        if (j == 0) {
            block();
            return true;
        }
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = currentTimeMillis + j;
            for (long j3 = currentTimeMillis; !this.mCondition && j3 < j2; j3 = System.currentTimeMillis()) {
                try {
                    wait(j2 - j3);
                } catch (InterruptedException e) {
                }
            }
            z = this.mCondition;
        }
        return z;
    }

    public void close() {
        synchronized (this) {
            this.mCondition = false;
        }
    }

    public void open() {
        synchronized (this) {
            boolean z = this.mCondition;
            this.mCondition = true;
            if (!z) {
                notifyAll();
            }
        }
    }
}
