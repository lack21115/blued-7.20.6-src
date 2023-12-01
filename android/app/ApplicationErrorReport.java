package android.app;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Printer;
import android.util.Slog;
import com.android.internal.util.FastPrintWriter;
import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: source-9557208-dex2jar.jar:android/app/ApplicationErrorReport.class */
public class ApplicationErrorReport implements Parcelable {
    public static final Parcelable.Creator<ApplicationErrorReport> CREATOR = new Parcelable.Creator<ApplicationErrorReport>() { // from class: android.app.ApplicationErrorReport.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ApplicationErrorReport createFromParcel(Parcel parcel) {
            return new ApplicationErrorReport(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ApplicationErrorReport[] newArray(int i) {
            return new ApplicationErrorReport[i];
        }
    };
    static final String DEFAULT_ERROR_RECEIVER_PROPERTY = "ro.error.receiver.default";
    static final String SYSTEM_APPS_ERROR_RECEIVER_PROPERTY = "ro.error.receiver.system.apps";
    public static final int TYPE_ANR = 2;
    public static final int TYPE_BATTERY = 3;
    public static final int TYPE_CRASH = 1;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_RUNNING_SERVICE = 5;
    public AnrInfo anrInfo;
    public BatteryInfo batteryInfo;
    public CrashInfo crashInfo;
    public String installerPackageName;
    public String packageName;
    public String processName;
    public RunningServiceInfo runningServiceInfo;
    public boolean systemApp;
    public long time;
    public int type;

    /* loaded from: source-9557208-dex2jar.jar:android/app/ApplicationErrorReport$AnrInfo.class */
    public static class AnrInfo {
        public String activity;
        public String cause;
        public String info;

        public AnrInfo() {
        }

        public AnrInfo(Parcel parcel) {
            this.activity = parcel.readString();
            this.cause = parcel.readString();
            this.info = parcel.readString();
        }

        public void dump(Printer printer, String str) {
            printer.println(str + "activity: " + this.activity);
            printer.println(str + "cause: " + this.cause);
            printer.println(str + "info: " + this.info);
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.activity);
            parcel.writeString(this.cause);
            parcel.writeString(this.info);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/ApplicationErrorReport$BatteryInfo.class */
    public static class BatteryInfo {
        public String checkinDetails;
        public long durationMicros;
        public String usageDetails;
        public int usagePercent;

        public BatteryInfo() {
        }

        public BatteryInfo(Parcel parcel) {
            this.usagePercent = parcel.readInt();
            this.durationMicros = parcel.readLong();
            this.usageDetails = parcel.readString();
            this.checkinDetails = parcel.readString();
        }

        public void dump(Printer printer, String str) {
            printer.println(str + "usagePercent: " + this.usagePercent);
            printer.println(str + "durationMicros: " + this.durationMicros);
            printer.println(str + "usageDetails: " + this.usageDetails);
            printer.println(str + "checkinDetails: " + this.checkinDetails);
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.usagePercent);
            parcel.writeLong(this.durationMicros);
            parcel.writeString(this.usageDetails);
            parcel.writeString(this.checkinDetails);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/ApplicationErrorReport$CrashInfo.class */
    public static class CrashInfo {
        public String exceptionClassName;
        public String exceptionMessage;
        public String stackTrace;
        public String throwClassName;
        public String throwFileName;
        public int throwLineNumber;
        public String throwMethodName;

        public CrashInfo() {
        }

        public CrashInfo(Parcel parcel) {
            this.exceptionClassName = parcel.readString();
            this.exceptionMessage = parcel.readString();
            this.throwFileName = parcel.readString();
            this.throwClassName = parcel.readString();
            this.throwMethodName = parcel.readString();
            this.throwLineNumber = parcel.readInt();
            this.stackTrace = parcel.readString();
        }

        public CrashInfo(Throwable th) {
            StringWriter stringWriter = new StringWriter();
            FastPrintWriter fastPrintWriter = new FastPrintWriter(stringWriter, false, 256);
            th.printStackTrace((PrintWriter) fastPrintWriter);
            fastPrintWriter.flush();
            this.stackTrace = stringWriter.toString();
            this.exceptionMessage = th.getMessage();
            Throwable th2 = th;
            while (th.getCause() != null) {
                Throwable cause = th.getCause();
                Throwable th3 = th2;
                if (cause.getStackTrace() != null) {
                    th3 = th2;
                    if (cause.getStackTrace().length > 0) {
                        th3 = cause;
                    }
                }
                String message = cause.getMessage();
                th2 = th3;
                th = cause;
                if (message != null) {
                    th2 = th3;
                    th = cause;
                    if (message.length() > 0) {
                        this.exceptionMessage = message;
                        th2 = th3;
                        th = cause;
                    }
                }
            }
            this.exceptionClassName = th2.getClass().getName();
            if (th2.getStackTrace().length <= 0) {
                this.throwFileName = "unknown";
                this.throwClassName = "unknown";
                this.throwMethodName = "unknown";
                this.throwLineNumber = 0;
                return;
            }
            StackTraceElement stackTraceElement = th2.getStackTrace()[0];
            this.throwFileName = stackTraceElement.getFileName();
            this.throwClassName = stackTraceElement.getClassName();
            this.throwMethodName = stackTraceElement.getMethodName();
            this.throwLineNumber = stackTraceElement.getLineNumber();
        }

        public void dump(Printer printer, String str) {
            printer.println(str + "exceptionClassName: " + this.exceptionClassName);
            printer.println(str + "exceptionMessage: " + this.exceptionMessage);
            printer.println(str + "throwFileName: " + this.throwFileName);
            printer.println(str + "throwClassName: " + this.throwClassName);
            printer.println(str + "throwMethodName: " + this.throwMethodName);
            printer.println(str + "throwLineNumber: " + this.throwLineNumber);
            printer.println(str + "stackTrace: " + this.stackTrace);
        }

        public void writeToParcel(Parcel parcel, int i) {
            int dataPosition = parcel.dataPosition();
            parcel.writeString(this.exceptionClassName);
            parcel.writeString(this.exceptionMessage);
            parcel.writeString(this.throwFileName);
            parcel.writeString(this.throwClassName);
            parcel.writeString(this.throwMethodName);
            parcel.writeInt(this.throwLineNumber);
            parcel.writeString(this.stackTrace);
            if (parcel.dataPosition() - dataPosition > 20480) {
                Slog.d("Error", "ERR: exClass=" + this.exceptionClassName);
                Slog.d("Error", "ERR: exMsg=" + this.exceptionMessage);
                Slog.d("Error", "ERR: file=" + this.throwFileName);
                Slog.d("Error", "ERR: class=" + this.throwClassName);
                Slog.d("Error", "ERR: method=" + this.throwMethodName + " line=" + this.throwLineNumber);
                Slog.d("Error", "ERR: stack=" + this.stackTrace);
                Slog.d("Error", "ERR: TOTAL BYTES WRITTEN: " + (parcel.dataPosition() - dataPosition));
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/ApplicationErrorReport$RunningServiceInfo.class */
    public static class RunningServiceInfo {
        public long durationMillis;
        public String serviceDetails;

        public RunningServiceInfo() {
        }

        public RunningServiceInfo(Parcel parcel) {
            this.durationMillis = parcel.readLong();
            this.serviceDetails = parcel.readString();
        }

        public void dump(Printer printer, String str) {
            printer.println(str + "durationMillis: " + this.durationMillis);
            printer.println(str + "serviceDetails: " + this.serviceDetails);
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.durationMillis);
            parcel.writeString(this.serviceDetails);
        }
    }

    public ApplicationErrorReport() {
    }

    ApplicationErrorReport(Parcel parcel) {
        readFromParcel(parcel);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
        if (r0 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
        if (r0 == null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.ComponentName getErrorReportReceiver(android.content.Context r4, java.lang.String r5, int r6) {
        /*
            r0 = r4
            android.content.ContentResolver r0 = r0.getContentResolver()
            java.lang.String r1 = "send_action_app_error"
            r2 = 0
            int r0 = android.provider.Settings.Global.getInt(r0, r1, r2)
            if (r0 != 0) goto L11
            r0 = 0
            r4 = r0
        Lf:
            r0 = r4
            return r0
        L11:
            r0 = r4
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            r8 = r0
            r0 = 0
            r4 = r0
            r0 = r8
            r1 = r5
            java.lang.String r0 = r0.getInstallerPackageName(r1)     // Catch: java.lang.IllegalArgumentException -> L58
            r7 = r0
            r0 = r7
            r4 = r0
        L22:
            r0 = r4
            if (r0 == 0) goto L34
            r0 = r8
            r1 = r5
            r2 = r4
            android.content.ComponentName r0 = getErrorReportReceiver(r0, r1, r2)
            r7 = r0
            r0 = r7
            r4 = r0
            r0 = r7
            if (r0 != 0) goto Lf
        L34:
            r0 = r6
            r1 = 1
            r0 = r0 & r1
            if (r0 == 0) goto L4c
            r0 = r8
            r1 = r5
            java.lang.String r2 = "ro.error.receiver.system.apps"
            java.lang.String r2 = android.os.SystemProperties.get(r2)
            android.content.ComponentName r0 = getErrorReportReceiver(r0, r1, r2)
            r7 = r0
            r0 = r7
            r4 = r0
            r0 = r7
            if (r0 != 0) goto Lf
        L4c:
            r0 = r8
            r1 = r5
            java.lang.String r2 = "ro.error.receiver.default"
            java.lang.String r2 = android.os.SystemProperties.get(r2)
            android.content.ComponentName r0 = getErrorReportReceiver(r0, r1, r2)
            return r0
        L58:
            r7 = move-exception
            goto L22
        */
        throw new UnsupportedOperationException("Method not decompiled: android.app.ApplicationErrorReport.getErrorReportReceiver(android.content.Context, java.lang.String, int):android.content.ComponentName");
    }

    static ComponentName getErrorReportReceiver(PackageManager packageManager, String str, String str2) {
        if (str2 == null || str2.length() == 0 || str2.equals(str)) {
            return null;
        }
        Intent intent = new Intent(Intent.ACTION_APP_ERROR);
        intent.setPackage(str2);
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            return null;
        }
        return new ComponentName(str2, resolveActivity.activityInfo.name);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void dump(Printer printer, String str) {
        printer.println(str + "type: " + this.type);
        printer.println(str + "packageName: " + this.packageName);
        printer.println(str + "installerPackageName: " + this.installerPackageName);
        printer.println(str + "processName: " + this.processName);
        printer.println(str + "time: " + this.time);
        printer.println(str + "systemApp: " + this.systemApp);
        switch (this.type) {
            case 1:
                this.crashInfo.dump(printer, str);
                return;
            case 2:
                this.anrInfo.dump(printer, str);
                return;
            case 3:
                this.batteryInfo.dump(printer, str);
                return;
            case 4:
            default:
                return;
            case 5:
                this.runningServiceInfo.dump(printer, str);
                return;
        }
    }

    public void readFromParcel(Parcel parcel) {
        this.type = parcel.readInt();
        this.packageName = parcel.readString();
        this.installerPackageName = parcel.readString();
        this.processName = parcel.readString();
        this.time = parcel.readLong();
        this.systemApp = parcel.readInt() == 1;
        boolean z = parcel.readInt() == 1;
        switch (this.type) {
            case 1:
                this.crashInfo = z ? new CrashInfo(parcel) : null;
                this.anrInfo = null;
                this.batteryInfo = null;
                this.runningServiceInfo = null;
                return;
            case 2:
                this.anrInfo = new AnrInfo(parcel);
                this.crashInfo = null;
                this.batteryInfo = null;
                this.runningServiceInfo = null;
                return;
            case 3:
                this.batteryInfo = new BatteryInfo(parcel);
                this.anrInfo = null;
                this.crashInfo = null;
                this.runningServiceInfo = null;
                return;
            case 4:
            default:
                return;
            case 5:
                this.batteryInfo = null;
                this.anrInfo = null;
                this.crashInfo = null;
                this.runningServiceInfo = new RunningServiceInfo(parcel);
                return;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeString(this.packageName);
        parcel.writeString(this.installerPackageName);
        parcel.writeString(this.processName);
        parcel.writeLong(this.time);
        parcel.writeInt(this.systemApp ? 1 : 0);
        parcel.writeInt(this.crashInfo != null ? 1 : 0);
        switch (this.type) {
            case 1:
                if (this.crashInfo != null) {
                    this.crashInfo.writeToParcel(parcel, i);
                    return;
                }
                return;
            case 2:
                this.anrInfo.writeToParcel(parcel, i);
                return;
            case 3:
                this.batteryInfo.writeToParcel(parcel, i);
                return;
            case 4:
            default:
                return;
            case 5:
                this.runningServiceInfo.writeToParcel(parcel, i);
                return;
        }
    }
}
