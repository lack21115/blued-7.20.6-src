package android.printservice;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.print.PrintDocumentInfo;
import android.print.PrintJobId;
import android.util.Log;
import java.io.IOException;

/* loaded from: source-9557208-dex2jar.jar:android/printservice/PrintDocument.class */
public final class PrintDocument {
    private static final String LOG_TAG = "PrintDocument";
    private final PrintDocumentInfo mInfo;
    private final PrintJobId mPrintJobId;
    private final IPrintServiceClient mPrintServiceClient;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PrintDocument(PrintJobId printJobId, IPrintServiceClient iPrintServiceClient, PrintDocumentInfo printDocumentInfo) {
        this.mPrintJobId = printJobId;
        this.mPrintServiceClient = iPrintServiceClient;
        this.mInfo = printDocumentInfo;
    }

    public ParcelFileDescriptor getData() {
        PrintService.throwIfNotCalledOnMainThread();
        ParcelFileDescriptor parcelFileDescriptor = null;
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        ParcelFileDescriptor parcelFileDescriptor3 = null;
        try {
            try {
                try {
                    ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                    ParcelFileDescriptor parcelFileDescriptor4 = createPipe[0];
                    ParcelFileDescriptor parcelFileDescriptor5 = createPipe[1];
                    parcelFileDescriptor3 = parcelFileDescriptor5;
                    parcelFileDescriptor = parcelFileDescriptor5;
                    parcelFileDescriptor2 = parcelFileDescriptor5;
                    this.mPrintServiceClient.writePrintJobData(parcelFileDescriptor5, this.mPrintJobId);
                    if (parcelFileDescriptor5 != null) {
                        try {
                            parcelFileDescriptor5.close();
                        } catch (IOException e) {
                        }
                    }
                    return parcelFileDescriptor4;
                } catch (RemoteException e2) {
                    Log.e(LOG_TAG, "Error calling getting print job data!", e2);
                    if (parcelFileDescriptor != null) {
                        try {
                            parcelFileDescriptor.close();
                            return null;
                        } catch (IOException e3) {
                            return null;
                        }
                    }
                    return null;
                }
            } catch (IOException e4) {
                Log.e(LOG_TAG, "Error calling getting print job data!", e4);
                if (parcelFileDescriptor3 != null) {
                    try {
                        parcelFileDescriptor3.close();
                        return null;
                    } catch (IOException e5) {
                        return null;
                    }
                }
                return null;
            }
        } catch (Throwable th) {
            if (parcelFileDescriptor2 != null) {
                try {
                    parcelFileDescriptor2.close();
                } catch (IOException e6) {
                }
            }
            throw th;
        }
    }

    public PrintDocumentInfo getInfo() {
        PrintService.throwIfNotCalledOnMainThread();
        return this.mInfo;
    }
}
