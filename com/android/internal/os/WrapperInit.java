package com.android.internal.os;

import android.os.Process;
import android.util.Slog;
import com.android.internal.os.ZygoteInit;
import java.io.DataOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import libcore.io.IoUtils;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/WrapperInit.class */
public class WrapperInit {
    private static final String TAG = "AndroidRuntime";

    private WrapperInit() {
    }

    public static void execApplication(String str, String str2, int i, FileDescriptor fileDescriptor, String[] strArr) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(" /system/bin/app_process /system/bin --application");
        if (str2 != null) {
            sb.append(" '--nice-name=").append(str2).append("'");
        }
        sb.append(" com.android.internal.os.WrapperInit ");
        sb.append(fileDescriptor != null ? fileDescriptor.getInt$() : 0);
        sb.append(' ');
        sb.append(i);
        Zygote.appendQuotedShellArgs(sb, strArr);
        Zygote.execShell(sb.toString());
    }

    public static void execStandalone(String str, String str2, String str3, String[] strArr) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(" /system/bin/dalvikvm -classpath '").append(str2);
        sb.append("' ").append(str3);
        Zygote.appendQuotedShellArgs(sb, strArr);
        Zygote.execShell(sb.toString());
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0058 -> B:5:0x003d). Please submit an issue!!! */
    public static void main(String[] strArr) {
        try {
            int parseInt = Integer.parseInt(strArr[0], 10);
            int parseInt2 = Integer.parseInt(strArr[1], 10);
            if (parseInt != 0) {
                try {
                    FileDescriptor createFileDescriptor = ZygoteInit.createFileDescriptor(parseInt);
                    DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(createFileDescriptor));
                    dataOutputStream.writeInt(Process.myPid());
                    dataOutputStream.close();
                    IoUtils.closeQuietly(createFileDescriptor);
                } catch (IOException e) {
                    Slog.d(TAG, "Could not write pid of wrapped process to Zygote pipe.", e);
                }
            }
            ZygoteInit.preload();
            String[] strArr2 = new String[strArr.length - 2];
            System.arraycopy(strArr, 2, strArr2, 0, strArr2.length);
            RuntimeInit.wrapperInit(parseInt2, strArr2);
        } catch (ZygoteInit.MethodAndArgsCaller e2) {
            e2.run();
        }
    }
}
