package android.print;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.ICancellationSignal;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.print.IPrintDocumentAdapter;
import android.print.IPrintJobStateChangeListener;
import android.print.PrintDocumentAdapter;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import com.android.internal.os.SomeArgs;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import libcore.io.IoUtils;

/* loaded from: source-9557208-dex2jar.jar:android/print/PrintManager.class */
public final class PrintManager {
    public static final String ACTION_PRINT_DIALOG = "android.print.PRINT_DIALOG";
    public static final int APP_ID_ANY = -2;
    private static final boolean DEBUG = false;
    public static final String EXTRA_PRINT_DIALOG_INTENT = "android.print.intent.extra.EXTRA_PRINT_DIALOG_INTENT";
    public static final String EXTRA_PRINT_DOCUMENT_ADAPTER = "android.print.intent.extra.EXTRA_PRINT_DOCUMENT_ADAPTER";
    public static final String EXTRA_PRINT_JOB = "android.print.intent.extra.EXTRA_PRINT_JOB";
    private static final String LOG_TAG = "PrintManager";
    private static final int MSG_NOTIFY_PRINT_JOB_STATE_CHANGED = 1;
    private final int mAppId;
    private final Context mContext;
    private final Handler mHandler;
    private Map<PrintJobStateChangeListener, PrintJobStateChangeListenerWrapper> mPrintJobStateChangeListeners;
    private final IPrintManager mService;
    private final int mUserId;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/print/PrintManager$PrintDocumentAdapterDelegate.class */
    public static final class PrintDocumentAdapterDelegate extends IPrintDocumentAdapter.Stub implements Application.ActivityLifecycleCallbacks {
        private Activity mActivity;
        private PrintDocumentAdapter mDocumentAdapter;
        private Handler mHandler;
        private final Object mLock = new Object();
        private IPrintDocumentAdapterObserver mObserver;
        private DestroyableCallback mPendingCallback;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-9557208-dex2jar.jar:android/print/PrintManager$PrintDocumentAdapterDelegate$DestroyableCallback.class */
        public interface DestroyableCallback {
            void destroy();
        }

        /* loaded from: source-9557208-dex2jar.jar:android/print/PrintManager$PrintDocumentAdapterDelegate$MyHandler.class */
        private final class MyHandler extends Handler {
            public static final int MSG_ON_FINISH = 4;
            public static final int MSG_ON_KILL = 5;
            public static final int MSG_ON_LAYOUT = 2;
            public static final int MSG_ON_START = 1;
            public static final int MSG_ON_WRITE = 3;

            public MyHandler(Looper looper) {
                super(looper, null, true);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        ((PrintDocumentAdapter) message.obj).onStart();
                        return;
                    case 2:
                        SomeArgs someArgs = (SomeArgs) message.obj;
                        someArgs.recycle();
                        ((PrintDocumentAdapter) someArgs.arg1).onLayout((PrintAttributes) someArgs.arg2, (PrintAttributes) someArgs.arg3, (CancellationSignal) someArgs.arg4, (PrintDocumentAdapter.LayoutResultCallback) someArgs.arg5, (Bundle) someArgs.arg6);
                        return;
                    case 3:
                        SomeArgs someArgs2 = (SomeArgs) message.obj;
                        someArgs2.recycle();
                        ((PrintDocumentAdapter) someArgs2.arg1).onWrite((PageRange[]) someArgs2.arg2, (ParcelFileDescriptor) someArgs2.arg3, (CancellationSignal) someArgs2.arg4, (PrintDocumentAdapter.WriteResultCallback) someArgs2.arg5);
                        return;
                    case 4:
                        ((PrintDocumentAdapter) message.obj).onFinish();
                        synchronized (PrintDocumentAdapterDelegate.this.mLock) {
                            PrintDocumentAdapterDelegate.this.destroyLocked();
                        }
                        return;
                    case 5:
                        throw new RuntimeException((String) message.obj);
                    default:
                        throw new IllegalArgumentException("Unknown message: " + message.what);
                }
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/print/PrintManager$PrintDocumentAdapterDelegate$MyLayoutResultCallback.class */
        private final class MyLayoutResultCallback extends PrintDocumentAdapter.LayoutResultCallback implements DestroyableCallback {
            private ILayoutResultCallback mCallback;
            private final int mSequence;

            public MyLayoutResultCallback(ILayoutResultCallback iLayoutResultCallback, int i) {
                this.mCallback = iLayoutResultCallback;
                this.mSequence = i;
            }

            @Override // android.print.PrintManager.PrintDocumentAdapterDelegate.DestroyableCallback
            public void destroy() {
                synchronized (PrintDocumentAdapterDelegate.this.mLock) {
                    this.mCallback = null;
                    PrintDocumentAdapterDelegate.this.mPendingCallback = null;
                }
            }

            @Override // android.print.PrintDocumentAdapter.LayoutResultCallback
            public void onLayoutCancelled() {
                ILayoutResultCallback iLayoutResultCallback;
                synchronized (PrintDocumentAdapterDelegate.this.mLock) {
                    iLayoutResultCallback = this.mCallback;
                }
                try {
                    if (iLayoutResultCallback == null) {
                        Log.e(PrintManager.LOG_TAG, "PrintDocumentAdapter is destroyed. Did you finish the printing activity before print completion or did you invoke a callback after finish?");
                    } else {
                        iLayoutResultCallback.onLayoutCanceled(this.mSequence);
                    }
                } catch (RemoteException e) {
                    Log.e(PrintManager.LOG_TAG, "Error calling onLayoutFailed", e);
                } finally {
                    destroy();
                }
            }

            @Override // android.print.PrintDocumentAdapter.LayoutResultCallback
            public void onLayoutFailed(CharSequence charSequence) {
                ILayoutResultCallback iLayoutResultCallback;
                synchronized (PrintDocumentAdapterDelegate.this.mLock) {
                    iLayoutResultCallback = this.mCallback;
                }
                try {
                    if (iLayoutResultCallback == null) {
                        Log.e(PrintManager.LOG_TAG, "PrintDocumentAdapter is destroyed. Did you finish the printing activity before print completion or did you invoke a callback after finish?");
                    } else {
                        iLayoutResultCallback.onLayoutFailed(charSequence, this.mSequence);
                    }
                } catch (RemoteException e) {
                    Log.e(PrintManager.LOG_TAG, "Error calling onLayoutFailed", e);
                } finally {
                    destroy();
                }
            }

            @Override // android.print.PrintDocumentAdapter.LayoutResultCallback
            public void onLayoutFinished(PrintDocumentInfo printDocumentInfo, boolean z) {
                ILayoutResultCallback iLayoutResultCallback;
                synchronized (PrintDocumentAdapterDelegate.this.mLock) {
                    iLayoutResultCallback = this.mCallback;
                }
                if (iLayoutResultCallback == null) {
                    Log.e(PrintManager.LOG_TAG, "PrintDocumentAdapter is destroyed. Did you finish the printing activity before print completion or did you invoke a callback after finish?");
                    return;
                }
                try {
                    if (printDocumentInfo == null) {
                        throw new NullPointerException("document info cannot be null");
                    }
                    try {
                        iLayoutResultCallback.onLayoutFinished(printDocumentInfo, z, this.mSequence);
                    } catch (RemoteException e) {
                        Log.e(PrintManager.LOG_TAG, "Error calling onLayoutFinished", e);
                    }
                } finally {
                    destroy();
                }
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/print/PrintManager$PrintDocumentAdapterDelegate$MyWriteResultCallback.class */
        private final class MyWriteResultCallback extends PrintDocumentAdapter.WriteResultCallback implements DestroyableCallback {
            private IWriteResultCallback mCallback;
            private ParcelFileDescriptor mFd;
            private final int mSequence;

            public MyWriteResultCallback(IWriteResultCallback iWriteResultCallback, ParcelFileDescriptor parcelFileDescriptor, int i) {
                this.mFd = parcelFileDescriptor;
                this.mSequence = i;
                this.mCallback = iWriteResultCallback;
            }

            @Override // android.print.PrintManager.PrintDocumentAdapterDelegate.DestroyableCallback
            public void destroy() {
                synchronized (PrintDocumentAdapterDelegate.this.mLock) {
                    IoUtils.closeQuietly(this.mFd);
                    this.mCallback = null;
                    this.mFd = null;
                    PrintDocumentAdapterDelegate.this.mPendingCallback = null;
                }
            }

            @Override // android.print.PrintDocumentAdapter.WriteResultCallback
            public void onWriteCancelled() {
                IWriteResultCallback iWriteResultCallback;
                synchronized (PrintDocumentAdapterDelegate.this.mLock) {
                    iWriteResultCallback = this.mCallback;
                }
                try {
                    if (iWriteResultCallback == null) {
                        Log.e(PrintManager.LOG_TAG, "PrintDocumentAdapter is destroyed. Did you finish the printing activity before print completion or did you invoke a callback after finish?");
                    } else {
                        iWriteResultCallback.onWriteCanceled(this.mSequence);
                    }
                } catch (RemoteException e) {
                    Log.e(PrintManager.LOG_TAG, "Error calling onWriteCanceled", e);
                } finally {
                    destroy();
                }
            }

            @Override // android.print.PrintDocumentAdapter.WriteResultCallback
            public void onWriteFailed(CharSequence charSequence) {
                IWriteResultCallback iWriteResultCallback;
                synchronized (PrintDocumentAdapterDelegate.this.mLock) {
                    iWriteResultCallback = this.mCallback;
                }
                try {
                    if (iWriteResultCallback == null) {
                        Log.e(PrintManager.LOG_TAG, "PrintDocumentAdapter is destroyed. Did you finish the printing activity before print completion or did you invoke a callback after finish?");
                    } else {
                        iWriteResultCallback.onWriteFailed(charSequence, this.mSequence);
                    }
                } catch (RemoteException e) {
                    Log.e(PrintManager.LOG_TAG, "Error calling onWriteFailed", e);
                } finally {
                    destroy();
                }
            }

            @Override // android.print.PrintDocumentAdapter.WriteResultCallback
            public void onWriteFinished(PageRange[] pageRangeArr) {
                IWriteResultCallback iWriteResultCallback;
                synchronized (PrintDocumentAdapterDelegate.this.mLock) {
                    iWriteResultCallback = this.mCallback;
                }
                if (iWriteResultCallback == null) {
                    Log.e(PrintManager.LOG_TAG, "PrintDocumentAdapter is destroyed. Did you finish the printing activity before print completion or did you invoke a callback after finish?");
                    return;
                }
                try {
                    if (pageRangeArr == null) {
                        throw new IllegalArgumentException("pages cannot be null");
                    }
                    if (pageRangeArr.length == 0) {
                        throw new IllegalArgumentException("pages cannot be empty");
                    }
                    try {
                        iWriteResultCallback.onWriteFinished(pageRangeArr, this.mSequence);
                    } catch (RemoteException e) {
                        Log.e(PrintManager.LOG_TAG, "Error calling onWriteFinished", e);
                    }
                } finally {
                    destroy();
                }
            }
        }

        public PrintDocumentAdapterDelegate(Activity activity, PrintDocumentAdapter printDocumentAdapter) {
            this.mActivity = activity;
            this.mDocumentAdapter = printDocumentAdapter;
            this.mHandler = new MyHandler(this.mActivity.getMainLooper());
            this.mActivity.getApplication().registerActivityLifecycleCallbacks(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroyLocked() {
            this.mActivity.getApplication().unregisterActivityLifecycleCallbacks(this);
            this.mActivity = null;
            this.mDocumentAdapter = null;
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mHandler.removeMessages(4);
            this.mHandler = null;
            this.mObserver = null;
            if (this.mPendingCallback != null) {
                this.mPendingCallback.destroy();
                this.mPendingCallback = null;
            }
        }

        private boolean isDestroyedLocked() {
            return this.mActivity == null;
        }

        @Override // android.print.IPrintDocumentAdapter
        public void finish() {
            synchronized (this.mLock) {
                if (!isDestroyedLocked()) {
                    this.mHandler.obtainMessage(4, this.mDocumentAdapter).sendToTarget();
                }
            }
        }

        @Override // android.print.IPrintDocumentAdapter
        public void kill(String str) {
            synchronized (this.mLock) {
                if (!isDestroyedLocked()) {
                    this.mHandler.obtainMessage(5, str).sendToTarget();
                }
            }
        }

        @Override // android.print.IPrintDocumentAdapter
        public void layout(PrintAttributes printAttributes, PrintAttributes printAttributes2, ILayoutResultCallback iLayoutResultCallback, Bundle bundle, int i) {
            ICancellationSignal createTransport = CancellationSignal.createTransport();
            try {
                iLayoutResultCallback.onLayoutStarted(createTransport, i);
                synchronized (this.mLock) {
                    if (isDestroyedLocked()) {
                        return;
                    }
                    CancellationSignal fromTransport = CancellationSignal.fromTransport(createTransport);
                    SomeArgs obtain = SomeArgs.obtain();
                    obtain.arg1 = this.mDocumentAdapter;
                    obtain.arg2 = printAttributes;
                    obtain.arg3 = printAttributes2;
                    obtain.arg4 = fromTransport;
                    obtain.arg5 = new MyLayoutResultCallback(iLayoutResultCallback, i);
                    obtain.arg6 = bundle;
                    this.mHandler.obtainMessage(2, obtain).sendToTarget();
                }
            } catch (RemoteException e) {
                Log.e(PrintManager.LOG_TAG, "Error notifying for layout start", e);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            IPrintDocumentAdapterObserver iPrintDocumentAdapterObserver = null;
            synchronized (this.mLock) {
                if (activity == this.mActivity) {
                    iPrintDocumentAdapterObserver = this.mObserver;
                    destroyLocked();
                }
            }
            if (iPrintDocumentAdapterObserver != null) {
                try {
                    iPrintDocumentAdapterObserver.onDestroy();
                } catch (RemoteException e) {
                    Log.e(PrintManager.LOG_TAG, "Error announcing destroyed state", e);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.print.IPrintDocumentAdapter
        public void setObserver(IPrintDocumentAdapterObserver iPrintDocumentAdapterObserver) {
            boolean isDestroyedLocked;
            synchronized (this.mLock) {
                this.mObserver = iPrintDocumentAdapterObserver;
                isDestroyedLocked = isDestroyedLocked();
            }
            if (!isDestroyedLocked || iPrintDocumentAdapterObserver == null) {
                return;
            }
            try {
                iPrintDocumentAdapterObserver.onDestroy();
            } catch (RemoteException e) {
                Log.e(PrintManager.LOG_TAG, "Error announcing destroyed state", e);
            }
        }

        @Override // android.print.IPrintDocumentAdapter
        public void start() {
            synchronized (this.mLock) {
                if (!isDestroyedLocked()) {
                    this.mHandler.obtainMessage(1, this.mDocumentAdapter).sendToTarget();
                }
            }
        }

        @Override // android.print.IPrintDocumentAdapter
        public void write(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, IWriteResultCallback iWriteResultCallback, int i) {
            ICancellationSignal createTransport = CancellationSignal.createTransport();
            try {
                iWriteResultCallback.onWriteStarted(createTransport, i);
                synchronized (this.mLock) {
                    if (isDestroyedLocked()) {
                        return;
                    }
                    CancellationSignal fromTransport = CancellationSignal.fromTransport(createTransport);
                    SomeArgs obtain = SomeArgs.obtain();
                    obtain.arg1 = this.mDocumentAdapter;
                    obtain.arg2 = pageRangeArr;
                    obtain.arg3 = parcelFileDescriptor;
                    obtain.arg4 = fromTransport;
                    obtain.arg5 = new MyWriteResultCallback(iWriteResultCallback, parcelFileDescriptor, i);
                    this.mHandler.obtainMessage(3, obtain).sendToTarget();
                }
            } catch (RemoteException e) {
                Log.e(PrintManager.LOG_TAG, "Error notifying for write start", e);
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/print/PrintManager$PrintJobStateChangeListener.class */
    public interface PrintJobStateChangeListener {
        void onPrintJobStateChanged(PrintJobId printJobId);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/print/PrintManager$PrintJobStateChangeListenerWrapper.class */
    private static final class PrintJobStateChangeListenerWrapper extends IPrintJobStateChangeListener.Stub {
        private final WeakReference<Handler> mWeakHandler;
        private final WeakReference<PrintJobStateChangeListener> mWeakListener;

        public PrintJobStateChangeListenerWrapper(PrintJobStateChangeListener printJobStateChangeListener, Handler handler) {
            this.mWeakListener = new WeakReference<>(printJobStateChangeListener);
            this.mWeakHandler = new WeakReference<>(handler);
        }

        public void destroy() {
            this.mWeakListener.clear();
        }

        public PrintJobStateChangeListener getListener() {
            return this.mWeakListener.get();
        }

        @Override // android.print.IPrintJobStateChangeListener
        public void onPrintJobStateChanged(PrintJobId printJobId) {
            Handler handler = this.mWeakHandler.get();
            PrintJobStateChangeListener printJobStateChangeListener = this.mWeakListener.get();
            if (handler == null || printJobStateChangeListener == null) {
                return;
            }
            SomeArgs obtain = SomeArgs.obtain();
            obtain.arg1 = this;
            obtain.arg2 = printJobId;
            handler.obtainMessage(1, obtain).sendToTarget();
        }
    }

    public PrintManager(Context context, IPrintManager iPrintManager, int i, int i2) {
        this.mContext = context;
        this.mService = iPrintManager;
        this.mUserId = i;
        this.mAppId = i2;
        this.mHandler = new Handler(context.getMainLooper(), null, false) { // from class: android.print.PrintManager.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        SomeArgs someArgs = (SomeArgs) message.obj;
                        PrintJobStateChangeListener listener = ((PrintJobStateChangeListenerWrapper) someArgs.arg1).getListener();
                        if (listener != null) {
                            listener.onPrintJobStateChanged((PrintJobId) someArgs.arg2);
                        }
                        someArgs.recycle();
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void addPrintJobStateChangeListener(PrintJobStateChangeListener printJobStateChangeListener) {
        if (this.mService == null) {
            Log.w(LOG_TAG, "Feature android.software.print not available");
            return;
        }
        if (this.mPrintJobStateChangeListeners == null) {
            this.mPrintJobStateChangeListeners = new ArrayMap();
        }
        PrintJobStateChangeListenerWrapper printJobStateChangeListenerWrapper = new PrintJobStateChangeListenerWrapper(printJobStateChangeListener, this.mHandler);
        try {
            this.mService.addPrintJobStateChangeListener(printJobStateChangeListenerWrapper, this.mAppId, this.mUserId);
            this.mPrintJobStateChangeListeners.put(printJobStateChangeListener, printJobStateChangeListenerWrapper);
        } catch (RemoteException e) {
            Log.e(LOG_TAG, "Error adding print job state change listener", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cancelPrintJob(PrintJobId printJobId) {
        if (this.mService == null) {
            Log.w(LOG_TAG, "Feature android.software.print not available");
            return;
        }
        try {
            this.mService.cancelPrintJob(printJobId, this.mAppId, this.mUserId);
        } catch (RemoteException e) {
            Log.e(LOG_TAG, "Error canceling a print job: " + printJobId, e);
        }
    }

    public PrinterDiscoverySession createPrinterDiscoverySession() {
        if (this.mService == null) {
            Log.w(LOG_TAG, "Feature android.software.print not available");
            return null;
        }
        return new PrinterDiscoverySession(this.mService, this.mContext, this.mUserId);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:
        if (r0 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<android.printservice.PrintServiceInfo> getEnabledPrintServices() {
        /*
            r4 = this;
            r0 = r4
            android.print.IPrintManager r0 = r0.mService
            if (r0 != 0) goto L15
            java.lang.String r0 = "PrintManager"
            java.lang.String r1 = "Feature android.software.print not available"
            int r0 = android.util.Log.w(r0, r1)
            java.util.List r0 = java.util.Collections.emptyList()
            r5 = r0
        L13:
            r0 = r5
            return r0
        L15:
            r0 = r4
            android.print.IPrintManager r0 = r0.mService     // Catch: android.os.RemoteException -> L2d
            r1 = r4
            int r1 = r1.mUserId     // Catch: android.os.RemoteException -> L2d
            java.util.List r0 = r0.getEnabledPrintServices(r1)     // Catch: android.os.RemoteException -> L2d
            r6 = r0
            r0 = r6
            r5 = r0
            r0 = r6
            if (r0 != 0) goto L13
        L29:
            java.util.List r0 = java.util.Collections.emptyList()
            return r0
        L2d:
            r5 = move-exception
            java.lang.String r0 = "PrintManager"
            java.lang.String r1 = "Error getting the enabled print services"
            r2 = r5
            int r0 = android.util.Log.e(r0, r1, r2)
            goto L29
        */
        throw new UnsupportedOperationException("Method not decompiled: android.print.PrintManager.getEnabledPrintServices():java.util.List");
    }

    public PrintManager getGlobalPrintManagerForUser(int i) {
        if (this.mService == null) {
            Log.w(LOG_TAG, "Feature android.software.print not available");
            return null;
        }
        return new PrintManager(this.mContext, this.mService, i, -2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:
        if (r0 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<android.printservice.PrintServiceInfo> getInstalledPrintServices() {
        /*
            r4 = this;
            r0 = r4
            android.print.IPrintManager r0 = r0.mService
            if (r0 != 0) goto L15
            java.lang.String r0 = "PrintManager"
            java.lang.String r1 = "Feature android.software.print not available"
            int r0 = android.util.Log.w(r0, r1)
            java.util.List r0 = java.util.Collections.emptyList()
            r5 = r0
        L13:
            r0 = r5
            return r0
        L15:
            r0 = r4
            android.print.IPrintManager r0 = r0.mService     // Catch: android.os.RemoteException -> L2d
            r1 = r4
            int r1 = r1.mUserId     // Catch: android.os.RemoteException -> L2d
            java.util.List r0 = r0.getInstalledPrintServices(r1)     // Catch: android.os.RemoteException -> L2d
            r6 = r0
            r0 = r6
            r5 = r0
            r0 = r6
            if (r0 != 0) goto L13
        L29:
            java.util.List r0 = java.util.Collections.emptyList()
            return r0
        L2d:
            r5 = move-exception
            java.lang.String r0 = "PrintManager"
            java.lang.String r1 = "Error getting the installed print services"
            r2 = r5
            int r0 = android.util.Log.e(r0, r1, r2)
            goto L29
        */
        throw new UnsupportedOperationException("Method not decompiled: android.print.PrintManager.getInstalledPrintServices():java.util.List");
    }

    public PrintJob getPrintJob(PrintJobId printJobId) {
        if (this.mService == null) {
            Log.w(LOG_TAG, "Feature android.software.print not available");
            return null;
        }
        try {
            PrintJobInfo printJobInfo = this.mService.getPrintJobInfo(printJobId, this.mAppId, this.mUserId);
            if (printJobInfo != null) {
                return new PrintJob(printJobInfo, this);
            }
            return null;
        } catch (RemoteException e) {
            Log.e(LOG_TAG, "Error getting print job", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PrintJobInfo getPrintJobInfo(PrintJobId printJobId) {
        try {
            return this.mService.getPrintJobInfo(printJobId, this.mAppId, this.mUserId);
        } catch (RemoteException e) {
            Log.e(LOG_TAG, "Error getting a print job info:" + printJobId, e);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v24, types: [java.util.List] */
    public List<PrintJob> getPrintJobs() {
        ArrayList arrayList;
        if (this.mService == null) {
            Log.w(LOG_TAG, "Feature android.software.print not available");
            arrayList = Collections.emptyList();
        } else {
            try {
                List<PrintJobInfo> printJobInfos = this.mService.getPrintJobInfos(this.mAppId, this.mUserId);
                if (printJobInfos != null) {
                    int size = printJobInfos.size();
                    ArrayList arrayList2 = new ArrayList(size);
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        arrayList = arrayList2;
                        if (i2 >= size) {
                            break;
                        }
                        arrayList2.add(new PrintJob(printJobInfos.get(i2), this));
                        i = i2 + 1;
                    }
                } else {
                    return Collections.emptyList();
                }
            } catch (RemoteException e) {
                Log.e(LOG_TAG, "Error getting print jobs", e);
                return Collections.emptyList();
            }
        }
        return arrayList;
    }

    public PrintJob print(String str, PrintDocumentAdapter printDocumentAdapter, PrintAttributes printAttributes) {
        if (this.mService == null) {
            Log.w(LOG_TAG, "Feature android.software.print not available");
            return null;
        } else if (this.mContext instanceof Activity) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("printJobName cannot be empty");
            }
            if (printDocumentAdapter == null) {
                throw new IllegalArgumentException("documentAdapter cannot be null");
            }
            try {
                Bundle print = this.mService.print(str, new PrintDocumentAdapterDelegate((Activity) this.mContext, printDocumentAdapter), printAttributes, this.mContext.getPackageName(), this.mAppId, this.mUserId);
                if (print != null) {
                    PrintJobInfo printJobInfo = (PrintJobInfo) print.getParcelable(EXTRA_PRINT_JOB);
                    IntentSender intentSender = (IntentSender) print.getParcelable(EXTRA_PRINT_DIALOG_INTENT);
                    if (printJobInfo == null || intentSender == null) {
                        return null;
                    }
                    try {
                        this.mContext.startIntentSender(intentSender, null, 0, 0, 0);
                        return new PrintJob(printJobInfo, this);
                    } catch (IntentSender.SendIntentException e) {
                        Log.e(LOG_TAG, "Couldn't start print job config activity.", e);
                        return null;
                    }
                }
                return null;
            } catch (RemoteException e2) {
                Log.e(LOG_TAG, "Error creating a print job", e2);
                return null;
            }
        } else {
            throw new IllegalStateException("Can print only from an activity");
        }
    }

    public void removePrintJobStateChangeListener(PrintJobStateChangeListener printJobStateChangeListener) {
        PrintJobStateChangeListenerWrapper remove;
        if (this.mService == null) {
            Log.w(LOG_TAG, "Feature android.software.print not available");
        } else if (this.mPrintJobStateChangeListeners == null || (remove = this.mPrintJobStateChangeListeners.remove(printJobStateChangeListener)) == null) {
        } else {
            if (this.mPrintJobStateChangeListeners.isEmpty()) {
                this.mPrintJobStateChangeListeners = null;
            }
            remove.destroy();
            try {
                this.mService.removePrintJobStateChangeListener(remove, this.mUserId);
            } catch (RemoteException e) {
                Log.e(LOG_TAG, "Error removing print job state change listener", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void restartPrintJob(PrintJobId printJobId) {
        if (this.mService == null) {
            Log.w(LOG_TAG, "Feature android.software.print not available");
            return;
        }
        try {
            this.mService.restartPrintJob(printJobId, this.mAppId, this.mUserId);
        } catch (RemoteException e) {
            Log.e(LOG_TAG, "Error restarting a print job: " + printJobId, e);
        }
    }
}
