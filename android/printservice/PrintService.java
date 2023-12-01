package android.printservice;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.print.PrintJobInfo;
import android.print.PrinterId;
import android.printservice.IPrintService;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/printservice/PrintService.class */
public abstract class PrintService extends Service {
    private static final boolean DEBUG = false;
    public static final String EXTRA_PRINTER_INFO = "android.intent.extra.print.EXTRA_PRINTER_INFO";
    public static final String EXTRA_PRINT_JOB_INFO = "android.intent.extra.print.PRINT_JOB_INFO";
    private static final String LOG_TAG = "PrintService";
    public static final String SERVICE_INTERFACE = "android.printservice.PrintService";
    public static final String SERVICE_META_DATA = "android.printservice";
    private IPrintServiceClient mClient;
    private PrinterDiscoverySession mDiscoverySession;
    private Handler mHandler;
    private int mLastSessionId = -1;

    /* loaded from: source-9557208-dex2jar.jar:android/printservice/PrintService$ServiceHandler.class */
    private final class ServiceHandler extends Handler {
        public static final int MSG_CREATE_PRINTER_DISCOVERY_SESSION = 1;
        public static final int MSG_DESTROY_PRINTER_DISCOVERY_SESSION = 2;
        public static final int MSG_ON_PRINTJOB_QUEUED = 8;
        public static final int MSG_ON_REQUEST_CANCEL_PRINTJOB = 9;
        public static final int MSG_SET_CLEINT = 10;
        public static final int MSG_START_PRINTER_DISCOVERY = 3;
        public static final int MSG_START_PRINTER_STATE_TRACKING = 6;
        public static final int MSG_STOP_PRINTER_DISCOVERY = 4;
        public static final int MSG_STOP_PRINTER_STATE_TRACKING = 7;
        public static final int MSG_VALIDATE_PRINTERS = 5;

        public ServiceHandler(Looper looper) {
            super(looper, null, true);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            switch (i) {
                case 1:
                    PrinterDiscoverySession onCreatePrinterDiscoverySession = PrintService.this.onCreatePrinterDiscoverySession();
                    if (onCreatePrinterDiscoverySession == null) {
                        throw new NullPointerException("session cannot be null");
                    }
                    if (onCreatePrinterDiscoverySession.getId() == PrintService.this.mLastSessionId) {
                        throw new IllegalStateException("cannot reuse session instances");
                    }
                    PrintService.this.mDiscoverySession = onCreatePrinterDiscoverySession;
                    PrintService.this.mLastSessionId = onCreatePrinterDiscoverySession.getId();
                    onCreatePrinterDiscoverySession.setObserver(PrintService.this.mClient);
                    return;
                case 2:
                    if (PrintService.this.mDiscoverySession != null) {
                        PrintService.this.mDiscoverySession.destroy();
                        PrintService.this.mDiscoverySession = null;
                        return;
                    }
                    return;
                case 3:
                    if (PrintService.this.mDiscoverySession != null) {
                        PrintService.this.mDiscoverySession.startPrinterDiscovery((ArrayList) message.obj);
                        return;
                    }
                    return;
                case 4:
                    if (PrintService.this.mDiscoverySession != null) {
                        PrintService.this.mDiscoverySession.stopPrinterDiscovery();
                        return;
                    }
                    return;
                case 5:
                    if (PrintService.this.mDiscoverySession != null) {
                        PrintService.this.mDiscoverySession.validatePrinters((List) message.obj);
                        return;
                    }
                    return;
                case 6:
                    if (PrintService.this.mDiscoverySession != null) {
                        PrintService.this.mDiscoverySession.startPrinterStateTracking((PrinterId) message.obj);
                        return;
                    }
                    return;
                case 7:
                    if (PrintService.this.mDiscoverySession != null) {
                        PrintService.this.mDiscoverySession.stopPrinterStateTracking((PrinterId) message.obj);
                        return;
                    }
                    return;
                case 8:
                    PrintService.this.onPrintJobQueued(new PrintJob((PrintJobInfo) message.obj, PrintService.this.mClient));
                    return;
                case 9:
                    PrintService.this.onRequestCancelPrintJob(new PrintJob((PrintJobInfo) message.obj, PrintService.this.mClient));
                    return;
                case 10:
                    PrintService.this.mClient = (IPrintServiceClient) message.obj;
                    if (PrintService.this.mClient != null) {
                        PrintService.this.onConnected();
                        return;
                    } else {
                        PrintService.this.onDisconnected();
                        return;
                    }
                default:
                    throw new IllegalArgumentException("Unknown message: " + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void throwIfNotCalledOnMainThread() {
        if (!Looper.getMainLooper().isCurrentThread()) {
            throw new IllegalAccessError("must be called from the main thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        this.mHandler = new ServiceHandler(context.getMainLooper());
    }

    public final PrinterId generatePrinterId(String str) {
        throwIfNotCalledOnMainThread();
        return new PrinterId(new ComponentName(getPackageName(), getClass().getName()), str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0064, code lost:
        if (r9 == null) goto L21;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<android.printservice.PrintJob> getActivePrintJobs() {
        /*
            r6 = this;
            throwIfNotCalledOnMainThread()
            r0 = r6
            android.printservice.IPrintServiceClient r0 = r0.mClient
            if (r0 != 0) goto L12
            java.util.List r0 = java.util.Collections.emptyList()
            r10 = r0
        Lf:
            r0 = r10
            return r0
        L12:
            r0 = 0
            r9 = r0
            r0 = r6
            android.printservice.IPrintServiceClient r0 = r0.mClient     // Catch: android.os.RemoteException -> L6b
            java.util.List r0 = r0.getPrintJobInfos()     // Catch: android.os.RemoteException -> L6b
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L60
            r0 = r10
            int r0 = r0.size()     // Catch: android.os.RemoteException -> L6b
            r8 = r0
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: android.os.RemoteException -> L6b
            r1 = r0
            r2 = r8
            r1.<init>(r2)     // Catch: android.os.RemoteException -> L6b
            r9 = r0
            r0 = 0
            r7 = r0
        L37:
            r0 = r7
            r1 = r8
            if (r0 >= r1) goto L60
            r0 = r9
            android.printservice.PrintJob r1 = new android.printservice.PrintJob     // Catch: android.os.RemoteException -> L78
            r2 = r1
            r3 = r10
            r4 = r7
            java.lang.Object r3 = r3.get(r4)     // Catch: android.os.RemoteException -> L78
            android.print.PrintJobInfo r3 = (android.print.PrintJobInfo) r3     // Catch: android.os.RemoteException -> L78
            r4 = r6
            android.printservice.IPrintServiceClient r4 = r4.mClient     // Catch: android.os.RemoteException -> L78
            r2.<init>(r3, r4)     // Catch: android.os.RemoteException -> L78
            boolean r0 = r0.add(r1)     // Catch: android.os.RemoteException -> L78
            r0 = r7
            r1 = 1
            int r0 = r0 + r1
            r7 = r0
            goto L37
        L60:
            r0 = r9
            r10 = r0
            r0 = r9
            if (r0 != 0) goto Lf
        L67:
            java.util.List r0 = java.util.Collections.emptyList()
            return r0
        L6b:
            r9 = move-exception
        L6c:
            java.lang.String r0 = "PrintService"
            java.lang.String r1 = "Error calling getPrintJobs()"
            r2 = r9
            int r0 = android.util.Log.e(r0, r1, r2)
            goto L67
        L78:
            r9 = move-exception
            goto L6c
        */
        throw new UnsupportedOperationException("Method not decompiled: android.printservice.PrintService.getActivePrintJobs():java.util.List");
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return new IPrintService.Stub() { // from class: android.printservice.PrintService.1
            @Override // android.printservice.IPrintService
            public void createPrinterDiscoverySession() {
                PrintService.this.mHandler.sendEmptyMessage(1);
            }

            @Override // android.printservice.IPrintService
            public void destroyPrinterDiscoverySession() {
                PrintService.this.mHandler.sendEmptyMessage(2);
            }

            @Override // android.printservice.IPrintService
            public void onPrintJobQueued(PrintJobInfo printJobInfo) {
                PrintService.this.mHandler.obtainMessage(8, printJobInfo).sendToTarget();
            }

            @Override // android.printservice.IPrintService
            public void requestCancelPrintJob(PrintJobInfo printJobInfo) {
                PrintService.this.mHandler.obtainMessage(9, printJobInfo).sendToTarget();
            }

            @Override // android.printservice.IPrintService
            public void setClient(IPrintServiceClient iPrintServiceClient) {
                PrintService.this.mHandler.obtainMessage(10, iPrintServiceClient).sendToTarget();
            }

            @Override // android.printservice.IPrintService
            public void startPrinterDiscovery(List<PrinterId> list) {
                PrintService.this.mHandler.obtainMessage(3, list).sendToTarget();
            }

            @Override // android.printservice.IPrintService
            public void startPrinterStateTracking(PrinterId printerId) {
                PrintService.this.mHandler.obtainMessage(6, printerId).sendToTarget();
            }

            @Override // android.printservice.IPrintService
            public void stopPrinterDiscovery() {
                PrintService.this.mHandler.sendEmptyMessage(4);
            }

            @Override // android.printservice.IPrintService
            public void stopPrinterStateTracking(PrinterId printerId) {
                PrintService.this.mHandler.obtainMessage(7, printerId).sendToTarget();
            }

            @Override // android.printservice.IPrintService
            public void validatePrinters(List<PrinterId> list) {
                PrintService.this.mHandler.obtainMessage(5, list).sendToTarget();
            }
        };
    }

    protected void onConnected() {
    }

    protected abstract PrinterDiscoverySession onCreatePrinterDiscoverySession();

    protected void onDisconnected() {
    }

    protected abstract void onPrintJobQueued(PrintJob printJob);

    protected abstract void onRequestCancelPrintJob(PrintJob printJob);
}
