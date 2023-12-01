package java.util;

/* loaded from: source-2895416-dex2jar.jar:java/util/TimerTask.class */
public abstract class TimerTask implements Runnable {
    boolean cancelled;
    boolean fixedRate;
    final Object lock = new Object();
    long period;
    private long scheduledTime;
    long when;

    public boolean cancel() {
        boolean z = true;
        synchronized (this.lock) {
            if (this.cancelled || this.when <= 0) {
                z = false;
            }
            this.cancelled = true;
        }
        return z;
    }

    long getWhen() {
        long j;
        synchronized (this.lock) {
            j = this.when;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isScheduled() {
        boolean z;
        synchronized (this.lock) {
            if (this.when <= 0 && this.scheduledTime <= 0) {
                z = false;
            }
            z = true;
        }
        return z;
    }

    @Override // java.lang.Runnable
    public abstract void run();

    public long scheduledExecutionTime() {
        long j;
        synchronized (this.lock) {
            j = this.scheduledTime;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setScheduledTime(long j) {
        synchronized (this.lock) {
            this.scheduledTime = j;
        }
    }
}
