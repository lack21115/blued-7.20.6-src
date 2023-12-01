package android.printservice;

import android.content.pm.ParceledListSlice;
import android.os.RemoteException;
import android.print.PrinterId;
import android.print.PrinterInfo;
import android.util.ArrayMap;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/printservice/PrinterDiscoverySession.class */
public abstract class PrinterDiscoverySession {
    private static final String LOG_TAG = "PrinterDiscoverySession";
    private static int sIdCounter = 0;
    private final int mId;
    private boolean mIsDestroyed;
    private boolean mIsDiscoveryStarted;
    private ArrayMap<PrinterId, PrinterInfo> mLastSentPrinters;
    private IPrintServiceClient mObserver;
    private final ArrayMap<PrinterId, PrinterInfo> mPrinters = new ArrayMap<>();
    private final List<PrinterId> mTrackedPrinters = new ArrayList();

    public PrinterDiscoverySession() {
        int i = sIdCounter;
        sIdCounter = i + 1;
        this.mId = i;
    }

    private void sendOutOfDiscoveryPeriodPrinterChanges() {
        if (this.mLastSentPrinters == null || this.mLastSentPrinters.isEmpty()) {
            this.mLastSentPrinters = null;
            return;
        }
        ArrayList arrayList = null;
        for (PrinterInfo printerInfo : this.mPrinters.values()) {
            PrinterInfo printerInfo2 = this.mLastSentPrinters.get(printerInfo.getId());
            if (printerInfo2 == null || !printerInfo2.equals(printerInfo)) {
                ArrayList arrayList2 = arrayList;
                if (arrayList == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(printerInfo);
                arrayList = arrayList2;
            }
        }
        if (arrayList != null) {
            try {
                this.mObserver.onPrintersAdded(new ParceledListSlice(arrayList));
            } catch (RemoteException e) {
                Log.e(LOG_TAG, "Error sending added printers", e);
            }
        }
        ArrayList arrayList3 = null;
        for (PrinterInfo printerInfo3 : this.mLastSentPrinters.values()) {
            if (!this.mPrinters.containsKey(printerInfo3.getId())) {
                ArrayList arrayList4 = arrayList3;
                if (arrayList3 == null) {
                    arrayList4 = new ArrayList();
                }
                arrayList4.add(printerInfo3.getId());
                arrayList3 = arrayList4;
            }
        }
        if (arrayList3 != null) {
            try {
                this.mObserver.onPrintersRemoved(new ParceledListSlice(arrayList3));
            } catch (RemoteException e2) {
                Log.e(LOG_TAG, "Error sending removed printers", e2);
            }
        }
        this.mLastSentPrinters = null;
    }

    public final void addPrinters(List<PrinterInfo> list) {
        ArrayList arrayList;
        PrintService.throwIfNotCalledOnMainThread();
        if (this.mIsDestroyed) {
            Log.w(LOG_TAG, "Not adding printers - session destroyed.");
        } else if (this.mIsDiscoveryStarted) {
            ArrayList arrayList2 = null;
            int size = list.size();
            int i = 0;
            while (i < size) {
                PrinterInfo printerInfo = list.get(i);
                PrinterInfo put = this.mPrinters.put(printerInfo.getId(), printerInfo);
                if (put != null) {
                    arrayList = arrayList2;
                    if (put.equals(printerInfo)) {
                        i++;
                        arrayList2 = arrayList;
                    }
                }
                arrayList = arrayList2;
                if (arrayList2 == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(printerInfo);
                i++;
                arrayList2 = arrayList;
            }
            if (arrayList2 != null) {
                try {
                    this.mObserver.onPrintersAdded(new ParceledListSlice(arrayList2));
                } catch (RemoteException e) {
                    Log.e(LOG_TAG, "Error sending added printers", e);
                }
            }
        } else {
            if (this.mLastSentPrinters == null) {
                this.mLastSentPrinters = new ArrayMap<>(this.mPrinters);
            }
            int size2 = list.size();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size2) {
                    return;
                }
                PrinterInfo printerInfo2 = list.get(i3);
                if (this.mPrinters.get(printerInfo2.getId()) == null) {
                    this.mPrinters.put(printerInfo2.getId(), printerInfo2);
                }
                i2 = i3 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void destroy() {
        if (this.mIsDestroyed) {
            return;
        }
        this.mIsDestroyed = true;
        this.mIsDiscoveryStarted = false;
        this.mPrinters.clear();
        this.mLastSentPrinters = null;
        this.mObserver = null;
        onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getId() {
        return this.mId;
    }

    public final List<PrinterInfo> getPrinters() {
        PrintService.throwIfNotCalledOnMainThread();
        return this.mIsDestroyed ? Collections.emptyList() : new ArrayList(this.mPrinters.values());
    }

    public final List<PrinterId> getTrackedPrinters() {
        PrintService.throwIfNotCalledOnMainThread();
        return this.mIsDestroyed ? Collections.emptyList() : new ArrayList(this.mTrackedPrinters);
    }

    public final boolean isDestroyed() {
        PrintService.throwIfNotCalledOnMainThread();
        return this.mIsDestroyed;
    }

    public final boolean isPrinterDiscoveryStarted() {
        PrintService.throwIfNotCalledOnMainThread();
        return this.mIsDiscoveryStarted;
    }

    public abstract void onDestroy();

    public abstract void onStartPrinterDiscovery(List<PrinterId> list);

    public abstract void onStartPrinterStateTracking(PrinterId printerId);

    public abstract void onStopPrinterDiscovery();

    public abstract void onStopPrinterStateTracking(PrinterId printerId);

    public abstract void onValidatePrinters(List<PrinterId> list);

    public final void removePrinters(List<PrinterId> list) {
        PrintService.throwIfNotCalledOnMainThread();
        if (this.mIsDestroyed) {
            Log.w(LOG_TAG, "Not removing printers - session destroyed.");
        } else if (this.mIsDiscoveryStarted) {
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                PrinterId printerId = list.get(i2);
                if (this.mPrinters.remove(printerId) != null) {
                    arrayList.add(printerId);
                }
                i = i2 + 1;
            }
            if (arrayList.isEmpty()) {
                return;
            }
            try {
                this.mObserver.onPrintersRemoved(new ParceledListSlice(arrayList));
            } catch (RemoteException e) {
                Log.e(LOG_TAG, "Error sending removed printers", e);
            }
        } else {
            if (this.mLastSentPrinters == null) {
                this.mLastSentPrinters = new ArrayMap<>(this.mPrinters);
            }
            int size2 = list.size();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= size2) {
                    return;
                }
                this.mPrinters.remove(list.get(i4));
                i3 = i4 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setObserver(IPrintServiceClient iPrintServiceClient) {
        this.mObserver = iPrintServiceClient;
        if (this.mPrinters.isEmpty()) {
            return;
        }
        try {
            this.mObserver.onPrintersAdded(new ParceledListSlice(getPrinters()));
        } catch (RemoteException e) {
            Log.e(LOG_TAG, "Error sending added printers", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startPrinterDiscovery(List<PrinterId> list) {
        if (this.mIsDestroyed) {
            return;
        }
        this.mIsDiscoveryStarted = true;
        sendOutOfDiscoveryPeriodPrinterChanges();
        List<PrinterId> list2 = list;
        if (list == null) {
            list2 = Collections.emptyList();
        }
        onStartPrinterDiscovery(list2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startPrinterStateTracking(PrinterId printerId) {
        if (this.mIsDestroyed || this.mObserver == null || this.mTrackedPrinters.contains(printerId)) {
            return;
        }
        this.mTrackedPrinters.add(printerId);
        onStartPrinterStateTracking(printerId);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopPrinterDiscovery() {
        if (this.mIsDestroyed) {
            return;
        }
        this.mIsDiscoveryStarted = false;
        onStopPrinterDiscovery();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopPrinterStateTracking(PrinterId printerId) {
        if (this.mIsDestroyed || this.mObserver == null || !this.mTrackedPrinters.remove(printerId)) {
            return;
        }
        onStopPrinterStateTracking(printerId);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void validatePrinters(List<PrinterId> list) {
        if (this.mIsDestroyed || this.mObserver == null) {
            return;
        }
        onValidatePrinters(list);
    }
}
