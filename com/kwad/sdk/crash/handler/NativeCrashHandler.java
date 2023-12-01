package com.kwad.sdk.crash.handler;

import android.os.Build;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.NativeExceptionMessage;
import com.kwad.sdk.crash.report.e;
import com.kwad.sdk.crash.utils.g;
import java.io.File;
import java.util.concurrent.CountDownLatch;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/handler/NativeCrashHandler.class */
public final class NativeCrashHandler extends b {
    private static final String NATIVE_CRASH_HAPPENED_BEGIN = "------ Native Crash Happened Begin ------\n";
    private static final String TAG = "NativeCrashHandler";
    private static ExceptionMessage mMessage = new NativeExceptionMessage();
    private File mMessageFile;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/handler/NativeCrashHandler$a.class */
    public static final class a {
        private static final NativeCrashHandler aru = new NativeCrashHandler();
    }

    private NativeCrashHandler() {
    }

    public static native void doCrash();

    public static NativeCrashHandler getInstance() {
        return a.aru;
    }

    public static native void install(String str, boolean z, String str2, int i);

    /* JADX WARN: Finally extract failed */
    public static void onCallFromNative() {
        com.kwad.sdk.core.d.b.d(TAG, "onCallFromNative NativeCrashHandler.doCrash()");
        File file = getInstance().mLogDir;
        File file2 = getInstance().mMessageFile;
        File file3 = getInstance().mJavaTraceFile;
        File file4 = getInstance().mMemoryInfoFile;
        e uploader = getInstance().getUploader();
        File file5 = file2;
        File file6 = file3;
        File file7 = file4;
        try {
            if (!file.exists() && !file.mkdirs()) {
                StringBuilder sb = new StringBuilder();
                ExceptionMessage exceptionMessage = mMessage;
                sb.append(exceptionMessage.mErrorMessage);
                sb.append("create ");
                sb.append(file.getPath());
                sb.append(" failed!\n");
                exceptionMessage.mErrorMessage = sb.toString();
                if (uploader != null) {
                    mMessage.toJson();
                }
            }
            File file8 = file2;
            if (file2 == null) {
                StringBuilder sb2 = new StringBuilder();
                getInstance();
                sb2.append(FILE_NAME_BASE);
                sb2.append(".msg");
                file8 = new File(file, sb2.toString());
            }
            File file9 = file3;
            if (file3 == null) {
                StringBuilder sb3 = new StringBuilder();
                File file10 = file8;
                getInstance();
                File file11 = file8;
                sb3.append(FILE_NAME_BASE);
                File file12 = file8;
                sb3.append(".jtrace");
                File file13 = file8;
                file9 = new File(file, sb3.toString());
            }
            File file14 = file4;
            if (file4 == null) {
                StringBuilder sb4 = new StringBuilder();
                File file15 = file8;
                getInstance();
                File file16 = file8;
                sb4.append(FILE_NAME_BASE);
                File file17 = file8;
                sb4.append(".minfo");
                File file18 = file8;
                file14 = new File(file, sb4.toString());
            }
            File file19 = file8;
            g.b(null, mMessage, com.kwad.sdk.crash.e.zy().getContext());
            File file20 = file8;
            g.a(mMessage, getInstance().getCrashType());
            File file21 = file8;
            if (getInstance().mExceptionListener != null) {
                file5 = file8;
                file6 = file9;
                file7 = file14;
                getInstance().mExceptionListener.a(getInstance().getCrashType(), mMessage);
            }
            if (file8 != null) {
                try {
                    g.a(file8, mMessage.toJson().toString());
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                    if (uploader != null) {
                        g.k(th);
                        return;
                    }
                    return;
                }
            }
            g.B(file9);
            getInstance().backupLogFiles(file);
            g.a(uploader, TAG, getInstance().mDumpFile);
            getInstance().uploadRemainingExceptions();
            g.C(file14);
        } catch (Throwable th2) {
            try {
                StringBuilder sb5 = new StringBuilder();
                ExceptionMessage exceptionMessage2 = mMessage;
                sb5.append(exceptionMessage2.mErrorMessage);
                sb5.append(th2);
                exceptionMessage2.mErrorMessage = sb5.toString();
                com.kwad.sdk.core.d.b.printStackTraceOnly(th2);
                if (file5 != null) {
                    try {
                        g.a(file5, mMessage.toJson().toString());
                    } catch (Throwable th3) {
                        com.kwad.sdk.core.d.b.printStackTraceOnly(th3);
                        if (uploader != null) {
                            g.k(th3);
                            return;
                        }
                        return;
                    }
                }
                g.B(file6);
                getInstance().backupLogFiles(file);
                g.a(uploader, TAG, getInstance().mDumpFile);
                getInstance().uploadRemainingExceptions();
                g.C(file7);
            } catch (Throwable th4) {
                if (file5 != null) {
                    try {
                        g.a(file5, mMessage.toJson().toString());
                    } catch (Throwable th5) {
                        com.kwad.sdk.core.d.b.printStackTraceOnly(th5);
                        if (uploader != null) {
                            g.k(th5);
                        }
                        throw th4;
                    }
                }
                g.B(file6);
                getInstance().backupLogFiles(file);
                g.a(uploader, TAG, getInstance().mDumpFile);
                getInstance().uploadRemainingExceptions();
                g.C(file7);
                throw th4;
            }
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    protected final int getCrashType() {
        return 4;
    }

    public final void init(File file, boolean z, String str, com.kwad.sdk.crash.report.c cVar) {
        super.init(file, null, cVar);
        if (com.kwad.sdk.crash.b.zi()) {
            this.mLogDir = file;
            if (!this.mLogDir.exists()) {
                this.mLogDir.mkdirs();
            }
            this.mDumpFile = new File(file, FILE_NAME_BASE + ".dump");
            this.mJavaTraceFile = new File(file, FILE_NAME_BASE + ".jtrace");
            this.mMemoryInfoFile = new File(file, FILE_NAME_BASE + ".minfo");
            try {
                com.kwad.sdk.core.d.b.d(TAG, "ANR init2 " + this.mDumpFile.getPath());
                install(this.mDumpFile.getPath(), z, str, Build.VERSION.SDK_INT);
                this.mMessageFile = new File(file, FILE_NAME_BASE + ".msg");
            } catch (Throwable th) {
                getUploader();
            }
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    protected final void reportException(File[] fileArr, CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.g gVar = new com.kwad.sdk.crash.report.g();
        gVar.a(getUploader());
        int length = fileArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            gVar.a(fileArr[i2], countDownLatch);
            i = i2 + 1;
        }
    }
}
