package android.print;

/* loaded from: source-9557208-dex2jar.jar:android/print/PrintJob.class */
public final class PrintJob {
    private PrintJobInfo mCachedInfo;
    private final PrintManager mPrintManager;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PrintJob(PrintJobInfo printJobInfo, PrintManager printManager) {
        this.mCachedInfo = printJobInfo;
        this.mPrintManager = printManager;
    }

    private boolean isInImmutableState() {
        int state = this.mCachedInfo.getState();
        return state == 5 || state == 7;
    }

    public void cancel() {
        int state = getInfo().getState();
        if (state == 2 || state == 3 || state == 4 || state == 6) {
            this.mPrintManager.cancelPrintJob(this.mCachedInfo.getId());
        }
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            z = true;
        } else {
            z = false;
            if (obj != null) {
                z = false;
                if (getClass() == obj.getClass()) {
                    return this.mCachedInfo.getId().equals(((PrintJob) obj).mCachedInfo.getId());
                }
            }
        }
        return z;
    }

    public PrintJobId getId() {
        return this.mCachedInfo.getId();
    }

    public PrintJobInfo getInfo() {
        if (isInImmutableState()) {
            return this.mCachedInfo;
        }
        PrintJobInfo printJobInfo = this.mPrintManager.getPrintJobInfo(this.mCachedInfo.getId());
        if (printJobInfo != null) {
            this.mCachedInfo = printJobInfo;
        }
        return this.mCachedInfo;
    }

    public int hashCode() {
        return this.mCachedInfo.getId().hashCode();
    }

    public boolean isBlocked() {
        return getInfo().getState() == 4;
    }

    public boolean isCancelled() {
        return getInfo().getState() == 7;
    }

    public boolean isCompleted() {
        return getInfo().getState() == 5;
    }

    public boolean isFailed() {
        return getInfo().getState() == 6;
    }

    public boolean isQueued() {
        return getInfo().getState() == 2;
    }

    public boolean isStarted() {
        return getInfo().getState() == 3;
    }

    public void restart() {
        if (isFailed()) {
            this.mPrintManager.restartPrintJob(this.mCachedInfo.getId());
        }
    }
}
