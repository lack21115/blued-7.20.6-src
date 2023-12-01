package android.printservice;

import android.os.RemoteException;
import android.print.PrintJobId;
import android.print.PrintJobInfo;
import android.text.TextUtils;
import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/printservice/PrintJob.class */
public final class PrintJob {
    private static final String LOG_TAG = "PrintJob";
    private PrintJobInfo mCachedInfo;
    private final PrintDocument mDocument;
    private final IPrintServiceClient mPrintServiceClient;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PrintJob(PrintJobInfo printJobInfo, IPrintServiceClient iPrintServiceClient) {
        this.mCachedInfo = printJobInfo;
        this.mPrintServiceClient = iPrintServiceClient;
        this.mDocument = new PrintDocument(this.mCachedInfo.getId(), iPrintServiceClient, printJobInfo.getDocumentInfo());
    }

    private boolean isInImmutableState() {
        int state = this.mCachedInfo.getState();
        return state == 5 || state == 7 || state == 6;
    }

    private boolean setState(int i, String str) {
        try {
            if (this.mPrintServiceClient.setPrintJobState(this.mCachedInfo.getId(), i, str)) {
                this.mCachedInfo.setState(i);
                this.mCachedInfo.setStateReason(str);
                return true;
            }
            return false;
        } catch (RemoteException e) {
            Log.e(LOG_TAG, "Error setting the state of job: " + this.mCachedInfo.getId(), e);
            return false;
        }
    }

    public boolean block(String str) {
        PrintService.throwIfNotCalledOnMainThread();
        PrintJobInfo info = getInfo();
        int state = info.getState();
        if (state == 3 || (state == 4 && !TextUtils.equals(info.getStateReason(), str))) {
            return setState(4, str);
        }
        return false;
    }

    public boolean cancel() {
        PrintService.throwIfNotCalledOnMainThread();
        if (isInImmutableState()) {
            return false;
        }
        return setState(7, null);
    }

    public boolean complete() {
        PrintService.throwIfNotCalledOnMainThread();
        if (isStarted()) {
            return setState(5, null);
        }
        return false;
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

    public boolean fail(String str) {
        PrintService.throwIfNotCalledOnMainThread();
        if (isInImmutableState()) {
            return false;
        }
        return setState(6, str);
    }

    public int getAdvancedIntOption(String str) {
        PrintService.throwIfNotCalledOnMainThread();
        return getInfo().getAdvancedIntOption(str);
    }

    public String getAdvancedStringOption(String str) {
        PrintService.throwIfNotCalledOnMainThread();
        return getInfo().getAdvancedStringOption(str);
    }

    public PrintDocument getDocument() {
        PrintService.throwIfNotCalledOnMainThread();
        return this.mDocument;
    }

    public PrintJobId getId() {
        PrintService.throwIfNotCalledOnMainThread();
        return this.mCachedInfo.getId();
    }

    public PrintJobInfo getInfo() {
        PrintService.throwIfNotCalledOnMainThread();
        if (isInImmutableState()) {
            return this.mCachedInfo;
        }
        PrintJobInfo printJobInfo = null;
        try {
            printJobInfo = this.mPrintServiceClient.getPrintJobInfo(this.mCachedInfo.getId());
        } catch (RemoteException e) {
            Log.e(LOG_TAG, "Couldn't get info for job: " + this.mCachedInfo.getId(), e);
        }
        if (printJobInfo != null) {
            this.mCachedInfo = printJobInfo;
        }
        return this.mCachedInfo;
    }

    public String getTag() {
        PrintService.throwIfNotCalledOnMainThread();
        return getInfo().getTag();
    }

    public boolean hasAdvancedOption(String str) {
        PrintService.throwIfNotCalledOnMainThread();
        return getInfo().hasAdvancedOption(str);
    }

    public int hashCode() {
        return this.mCachedInfo.getId().hashCode();
    }

    public boolean isBlocked() {
        PrintService.throwIfNotCalledOnMainThread();
        return getInfo().getState() == 4;
    }

    public boolean isCancelled() {
        PrintService.throwIfNotCalledOnMainThread();
        return getInfo().getState() == 7;
    }

    public boolean isCompleted() {
        PrintService.throwIfNotCalledOnMainThread();
        return getInfo().getState() == 5;
    }

    public boolean isFailed() {
        PrintService.throwIfNotCalledOnMainThread();
        return getInfo().getState() == 6;
    }

    public boolean isQueued() {
        PrintService.throwIfNotCalledOnMainThread();
        return getInfo().getState() == 2;
    }

    public boolean isStarted() {
        PrintService.throwIfNotCalledOnMainThread();
        return getInfo().getState() == 3;
    }

    public boolean setTag(String str) {
        PrintService.throwIfNotCalledOnMainThread();
        if (isInImmutableState()) {
            return false;
        }
        try {
            return this.mPrintServiceClient.setPrintJobTag(this.mCachedInfo.getId(), str);
        } catch (RemoteException e) {
            Log.e(LOG_TAG, "Error setting tag for job: " + this.mCachedInfo.getId(), e);
            return false;
        }
    }

    public boolean start() {
        PrintService.throwIfNotCalledOnMainThread();
        int state = getInfo().getState();
        if (state == 2 || state == 4) {
            return setState(3, null);
        }
        return false;
    }
}
