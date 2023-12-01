package android.os;

import android.util.Slog;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;

/* loaded from: source-9557208-dex2jar.jar:android/os/SELinux.class */
public class SELinux {
    private static final int SELINUX_ANDROID_RESTORECON_DATADATA = 16;
    private static final int SELINUX_ANDROID_RESTORECON_FORCE = 8;
    private static final int SELINUX_ANDROID_RESTORECON_NOCHANGE = 1;
    private static final int SELINUX_ANDROID_RESTORECON_RECURSE = 4;
    private static final int SELINUX_ANDROID_RESTORECON_VERBOSE = 2;
    private static final String TAG = "SELinux";

    public static final native boolean checkSELinuxAccess(String str, String str2, String str3, String str4);

    public static final native String[] getBooleanNames();

    public static final native boolean getBooleanValue(String str);

    public static final native String getContext();

    public static final native String getFileContext(String str);

    public static final native String getPeerContext(FileDescriptor fileDescriptor);

    public static final native String getPidContext(int i);

    public static final native boolean isSELinuxEnabled();

    public static final native boolean isSELinuxEnforced();

    private static native boolean native_restorecon(String str, int i);

    public static boolean restorecon(File file) throws NullPointerException {
        try {
            return native_restorecon(file.getCanonicalPath(), 0);
        } catch (IOException e) {
            Slog.e(TAG, "Error getting canonical path. Restorecon failed for " + file.getPath(), e);
            return false;
        }
    }

    public static boolean restorecon(String str) throws NullPointerException {
        if (str == null) {
            throw new NullPointerException();
        }
        return native_restorecon(str, 0);
    }

    public static boolean restoreconRecursive(File file) {
        try {
            return native_restorecon(file.getCanonicalPath(), 4);
        } catch (IOException e) {
            Slog.e(TAG, "Error getting canonical path. Restorecon failed for " + file.getPath(), e);
            return false;
        }
    }

    public static final native boolean setBooleanValue(String str, boolean z);

    public static final native boolean setFSCreateContext(String str);

    public static final native boolean setFileContext(String str, String str2);

    public static final native boolean setSELinuxEnforce(boolean z);
}
