package android.print;

import android.content.Context;
import android.content.pm.ParceledListSlice;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.print.IPrinterDiscoveryObserver;
import android.util.ArrayMap;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/print/PrinterDiscoverySession.class */
public final class PrinterDiscoverySession {
    private static final String LOG_TAG = "PrinterDiscoverySession";
    private static final int MSG_PRINTERS_ADDED = 1;
    private static final int MSG_PRINTERS_REMOVED = 2;
    private final Handler mHandler;
    private boolean mIsPrinterDiscoveryStarted;
    private OnPrintersChangeListener mListener;
    private final IPrintManager mPrintManager;
    private final int mUserId;
    private final LinkedHashMap<PrinterId, PrinterInfo> mPrinters = new LinkedHashMap<>();
    private IPrinterDiscoveryObserver mObserver = new PrinterDiscoveryObserver(this);

    /* loaded from: source-9557208-dex2jar.jar:android/print/PrinterDiscoverySession$OnPrintersChangeListener.class */
    public interface OnPrintersChangeListener {
        void onPrintersChanged();
    }

    /* loaded from: source-9557208-dex2jar.jar:android/print/PrinterDiscoverySession$PrinterDiscoveryObserver.class */
    private static final class PrinterDiscoveryObserver extends IPrinterDiscoveryObserver.Stub {
        private final WeakReference<PrinterDiscoverySession> mWeakSession;

        public PrinterDiscoveryObserver(PrinterDiscoverySession printerDiscoverySession) {
            this.mWeakSession = new WeakReference<>(printerDiscoverySession);
        }

        @Override // android.print.IPrinterDiscoveryObserver
        public void onPrintersAdded(ParceledListSlice parceledListSlice) {
            PrinterDiscoverySession printerDiscoverySession = this.mWeakSession.get();
            if (printerDiscoverySession != null) {
                printerDiscoverySession.mHandler.obtainMessage(1, parceledListSlice.getList()).sendToTarget();
            }
        }

        @Override // android.print.IPrinterDiscoveryObserver
        public void onPrintersRemoved(ParceledListSlice parceledListSlice) {
            PrinterDiscoverySession printerDiscoverySession = this.mWeakSession.get();
            if (printerDiscoverySession != null) {
                printerDiscoverySession.mHandler.obtainMessage(2, parceledListSlice.getList()).sendToTarget();
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/print/PrinterDiscoverySession$SessionHandler.class */
    private final class SessionHandler extends Handler {
        public SessionHandler(Looper looper) {
            super(looper, null, false);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    PrinterDiscoverySession.this.handlePrintersAdded((List) message.obj);
                    return;
                case 2:
                    PrinterDiscoverySession.this.handlePrintersRemoved((List) message.obj);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PrinterDiscoverySession(IPrintManager iPrintManager, Context context, int i) {
        this.mPrintManager = iPrintManager;
        this.mUserId = i;
        this.mHandler = new SessionHandler(context.getMainLooper());
        try {
            this.mPrintManager.createPrinterDiscoverySession(this.mObserver, this.mUserId);
        } catch (RemoteException e) {
            Log.e(LOG_TAG, "Error creating printer discovery session", e);
        }
    }

    private void destroyNoCheck() {
        stopPrinterDiscovery();
        try {
            this.mPrintManager.destroyPrinterDiscoverySession(this.mObserver, this.mUserId);
        } catch (RemoteException e) {
            Log.e(LOG_TAG, "Error destroying printer discovery session", e);
        } finally {
            this.mObserver = null;
            this.mPrinters.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePrintersAdded(List<PrinterInfo> list) {
        if (isDestroyed()) {
            return;
        }
        if (!this.mPrinters.isEmpty()) {
            ArrayMap arrayMap = new ArrayMap();
            int size = list.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                PrinterInfo printerInfo = list.get(i2);
                arrayMap.put(printerInfo.getId(), printerInfo);
                i = i2 + 1;
            }
            for (PrinterId printerId : this.mPrinters.keySet()) {
                PrinterInfo printerInfo2 = (PrinterInfo) arrayMap.remove(printerId);
                if (printerInfo2 != null) {
                    this.mPrinters.put(printerId, printerInfo2);
                }
            }
            this.mPrinters.putAll(arrayMap);
            notifyOnPrintersChanged();
            return;
        }
        int size2 = list.size();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size2) {
                notifyOnPrintersChanged();
                return;
            }
            PrinterInfo printerInfo3 = list.get(i4);
            this.mPrinters.put(printerInfo3.getId(), printerInfo3);
            i3 = i4 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePrintersRemoved(List<PrinterId> list) {
        if (isDestroyed()) {
            return;
        }
        boolean z = false;
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            if (this.mPrinters.remove(list.get(i2)) != null) {
                z = true;
            }
            i = i2 + 1;
        }
        if (z) {
            notifyOnPrintersChanged();
        }
    }

    private boolean isDestroyedNoCheck() {
        return this.mObserver == null;
    }

    private void notifyOnPrintersChanged() {
        if (this.mListener != null) {
            this.mListener.onPrintersChanged();
        }
    }

    private static void throwIfNotCalledOnMainThread() {
        if (!Looper.getMainLooper().isCurrentThread()) {
            throw new IllegalAccessError("must be called from the main thread");
        }
    }

    public final void destroy() {
        if (isDestroyed()) {
            Log.w(LOG_TAG, "Ignoring destroy - session destroyed");
        }
        destroyNoCheck();
    }

    protected final void finalize() throws Throwable {
        if (!isDestroyedNoCheck()) {
            Log.e(LOG_TAG, "Destroying leaked printer discovery session");
            destroyNoCheck();
        }
        super.finalize();
    }

    public final List<PrinterInfo> getPrinters() {
        if (isDestroyed()) {
            Log.w(LOG_TAG, "Ignoring get printers - session destroyed");
            return Collections.emptyList();
        }
        return new ArrayList(this.mPrinters.values());
    }

    public final boolean isDestroyed() {
        throwIfNotCalledOnMainThread();
        return isDestroyedNoCheck();
    }

    public final boolean isPrinterDiscoveryStarted() {
        throwIfNotCalledOnMainThread();
        return this.mIsPrinterDiscoveryStarted;
    }

    public final void setOnPrintersChangeListener(OnPrintersChangeListener onPrintersChangeListener) {
        throwIfNotCalledOnMainThread();
        this.mListener = onPrintersChangeListener;
    }

    public final void startPrinterDiscovery(List<PrinterId> list) {
        if (isDestroyed()) {
            Log.w(LOG_TAG, "Ignoring start printers discovery - session destroyed");
        } else if (this.mIsPrinterDiscoveryStarted) {
        } else {
            this.mIsPrinterDiscoveryStarted = true;
            try {
                this.mPrintManager.startPrinterDiscovery(this.mObserver, list, this.mUserId);
            } catch (RemoteException e) {
                Log.e(LOG_TAG, "Error starting printer discovery", e);
            }
        }
    }

    public final void startPrinterStateTracking(PrinterId printerId) {
        if (isDestroyed()) {
            Log.w(LOG_TAG, "Ignoring start printer state tracking - session destroyed");
            return;
        }
        try {
            this.mPrintManager.startPrinterStateTracking(printerId, this.mUserId);
        } catch (RemoteException e) {
            Log.e(LOG_TAG, "Error starting printer state tracking", e);
        }
    }

    public final void stopPrinterDiscovery() {
        if (isDestroyed()) {
            Log.w(LOG_TAG, "Ignoring stop printers discovery - session destroyed");
        } else if (this.mIsPrinterDiscoveryStarted) {
            this.mIsPrinterDiscoveryStarted = false;
            try {
                this.mPrintManager.stopPrinterDiscovery(this.mObserver, this.mUserId);
            } catch (RemoteException e) {
                Log.e(LOG_TAG, "Error stopping printer discovery", e);
            }
        }
    }

    public final void stopPrinterStateTracking(PrinterId printerId) {
        if (isDestroyed()) {
            Log.w(LOG_TAG, "Ignoring stop printer state tracking - session destroyed");
            return;
        }
        try {
            this.mPrintManager.stopPrinterStateTracking(printerId, this.mUserId);
        } catch (RemoteException e) {
            Log.e(LOG_TAG, "Error stopping printer state tracking", e);
        }
    }

    public final void validatePrinters(List<PrinterId> list) {
        if (isDestroyed()) {
            Log.w(LOG_TAG, "Ignoring validate printers - session destroyed");
            return;
        }
        try {
            this.mPrintManager.validatePrinters(list, this.mUserId);
        } catch (RemoteException e) {
            Log.e(LOG_TAG, "Error validating printers", e);
        }
    }
}
