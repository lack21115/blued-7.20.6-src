package com.android.server;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.IPackageManager;
import android.os.Build;
import android.os.DropBoxManager;
import android.os.FileObserver;
import android.os.FileUtils;
import android.os.RecoverySystem;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.provider.Downloads;
import android.util.Slog;
import java.io.File;
import java.io.IOException;

/* loaded from: source-4181928-dex2jar.jar:com/android/server/BootReceiver.class */
public class BootReceiver extends BroadcastReceiver {
    private static final int LOG_SIZE;
    private static final String OLD_UPDATER_CLASS = "com.google.android.systemupdater.SystemUpdateReceiver";
    private static final String OLD_UPDATER_PACKAGE = "com.google.android.systemupdater";
    private static final String TAG = "BootReceiver";
    private static final File TOMBSTONE_DIR;
    private static FileObserver sTombstoneObserver;

    static {
        LOG_SIZE = SystemProperties.getInt("ro.debuggable", 0) == 1 ? 98304 : 65536;
        TOMBSTONE_DIR = new File("/data/tombstones");
        sTombstoneObserver = null;
    }

    private static void addAuditErrorsToDropBox(DropBoxManager dropBoxManager, SharedPreferences sharedPreferences, String str, int i, String str2) throws IOException {
        if (dropBoxManager == null || !dropBoxManager.isTagEnabled(str2)) {
            return;
        }
        Slog.i(TAG, "Copying audit failures to DropBox");
        File file = new File("/proc/last_kmsg");
        long lastModified = file.lastModified();
        long j = lastModified;
        if (lastModified <= 0) {
            file = new File("/sys/fs/pstore/console-ramoops");
            j = file.lastModified();
        }
        if (j <= 0) {
            return;
        }
        if (sharedPreferences != null) {
            if (sharedPreferences.getLong(str2, 0L) == j) {
                return;
            }
            sharedPreferences.edit().putLong(str2, j).apply();
        }
        String readTextFile = FileUtils.readTextFile(file, i, "[[TRUNCATED]]\n");
        StringBuilder sb = new StringBuilder();
        String[] split = readTextFile.split("\n");
        int length = split.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                Slog.i(TAG, "Copied " + sb.toString().length() + " worth of audits to DropBox");
                dropBoxManager.addText(str2, str + sb.toString());
                return;
            }
            String str3 = split[i3];
            if (str3.contains("audit")) {
                sb.append(str3 + "\n");
            }
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void addFileToDropBox(DropBoxManager dropBoxManager, SharedPreferences sharedPreferences, String str, String str2, int i, String str3) throws IOException {
        addFileWithFootersToDropBox(dropBoxManager, sharedPreferences, str, "", str2, i, str3);
    }

    private static void addFileWithFootersToDropBox(DropBoxManager dropBoxManager, SharedPreferences sharedPreferences, String str, String str2, String str3, int i, String str4) throws IOException {
        if (dropBoxManager == null || !dropBoxManager.isTagEnabled(str4)) {
            return;
        }
        File file = new File(str3);
        if (file.isDirectory()) {
            return;
        }
        long lastModified = file.lastModified();
        if (lastModified > 0) {
            if (sharedPreferences != null) {
                if (sharedPreferences.getLong(str3, 0L) == lastModified) {
                    return;
                }
                sharedPreferences.edit().putLong(str3, lastModified).apply();
            }
            Slog.i(TAG, "Copying " + str3 + " to DropBox (" + str4 + ")");
            dropBoxManager.addText(str4, str + FileUtils.readTextFile(file, i, "[[TRUNCATED]]\n") + str2);
        }
    }

    private static void addFsckErrorsToDropBox(DropBoxManager dropBoxManager, SharedPreferences sharedPreferences, String str, int i, String str2) throws IOException {
        boolean z;
        if (dropBoxManager == null || !dropBoxManager.isTagEnabled(str2)) {
            return;
        }
        Slog.i(TAG, "Checking for fsck errors");
        File file = new File("/dev/fscklogs/log");
        if (file.lastModified() > 0) {
            String readTextFile = FileUtils.readTextFile(file, i, "[[TRUNCATED]]\n");
            new StringBuilder();
            String[] split = readTextFile.split("\n");
            int length = split.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                z = false;
                if (i3 >= length) {
                    break;
                } else if (split[i3].contains("FILE SYSTEM WAS MODIFIED")) {
                    z = true;
                    break;
                } else {
                    i2 = i3 + 1;
                }
            }
            if (z) {
                addFileToDropBox(dropBoxManager, sharedPreferences, str, "/dev/fscklogs/log", i, str2);
            }
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logBootEvents(Context context) throws IOException {
        final DropBoxManager dropBoxManager = (DropBoxManager) context.getSystemService("dropbox");
        final SharedPreferences sharedPreferences = context.getSharedPreferences("log_files", 0);
        final String sb = new StringBuilder(512).append("Build: ").append(Build.FINGERPRINT).append("\n").append("Hardware: ").append(Build.BOARD).append("\n").append("Revision: ").append(SystemProperties.get("ro.revision", "")).append("\n").append("Bootloader: ").append(Build.BOOTLOADER).append("\n").append("Radio: ").append(Build.RADIO).append("\n").append("Kernel: ").append(FileUtils.readTextFile(new File("/proc/version"), 1024, "...\n")).append("\n").toString();
        String str = SystemProperties.get("ro.boot.bootreason", (String) null);
        String handleAftermath = RecoverySystem.handleAftermath();
        if (handleAftermath != null && dropBoxManager != null) {
            dropBoxManager.addText("SYSTEM_RECOVERY_LOG", sb + handleAftermath);
        }
        String sb2 = str != null ? new StringBuilder(512).append("\n").append("Boot info:\n").append("Last boot reason: ").append(str).append("\n").toString() : "";
        if (SystemProperties.getLong("ro.runtime.firstboot", 0L) == 0) {
            if (!"encrypted".equals(SystemProperties.get("ro.crypto.state")) || !"trigger_restart_min_framework".equals(SystemProperties.get("vold.decrypt"))) {
                SystemProperties.set("ro.runtime.firstboot", Long.toString(System.currentTimeMillis()));
            }
            if (dropBoxManager != null) {
                dropBoxManager.addText("SYSTEM_BOOT", sb);
            }
            addFileWithFootersToDropBox(dropBoxManager, sharedPreferences, sb, sb2, "/proc/last_kmsg", -LOG_SIZE, "SYSTEM_LAST_KMSG");
            addFileWithFootersToDropBox(dropBoxManager, sharedPreferences, sb, sb2, "/sys/fs/pstore/console-ramoops", -LOG_SIZE, "SYSTEM_LAST_KMSG");
            addFileToDropBox(dropBoxManager, sharedPreferences, sb, "/cache/recovery/log", -LOG_SIZE, "SYSTEM_RECOVERY_LOG");
            addFileToDropBox(dropBoxManager, sharedPreferences, sb, "/cache/recovery/last_kmsg", -LOG_SIZE, "SYSTEM_RECOVERY_KMSG");
            addFileToDropBox(dropBoxManager, sharedPreferences, sb, "/data/dontpanic/apanic_console", -LOG_SIZE, "APANIC_CONSOLE");
            addFileToDropBox(dropBoxManager, sharedPreferences, sb, "/data/dontpanic/apanic_threads", -LOG_SIZE, "APANIC_THREADS");
            addAuditErrorsToDropBox(dropBoxManager, sharedPreferences, sb, -LOG_SIZE, "SYSTEM_AUDIT");
            addFsckErrorsToDropBox(dropBoxManager, sharedPreferences, sb, -LOG_SIZE, "SYSTEM_FSCK");
        } else if (dropBoxManager != null) {
            dropBoxManager.addText("SYSTEM_RESTART", sb);
        }
        File[] listFiles = TOMBSTONE_DIR.listFiles();
        int i = 0;
        while (true) {
            int i2 = i;
            if (listFiles == null || i2 >= listFiles.length) {
                break;
            }
            if (listFiles[i2].isFile()) {
                addFileToDropBox(dropBoxManager, sharedPreferences, sb, listFiles[i2].getPath(), LOG_SIZE, "SYSTEM_TOMBSTONE");
            }
            i = i2 + 1;
        }
        sTombstoneObserver = new FileObserver(TOMBSTONE_DIR.getPath(), 8) { // from class: com.android.server.BootReceiver.2
            @Override // android.os.FileObserver
            public void onEvent(int i3, String str2) {
                try {
                    File file = new File(BootReceiver.TOMBSTONE_DIR, str2);
                    if (file.isFile()) {
                        BootReceiver.addFileToDropBox(dropBoxManager, sharedPreferences, sb, file.getPath(), BootReceiver.LOG_SIZE, "SYSTEM_TOMBSTONE");
                    }
                } catch (IOException e) {
                    Slog.e(BootReceiver.TAG, "Can't log tombstone", e);
                }
            }
        };
        sTombstoneObserver.startWatching();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeOldUpdatePackages(Context context) {
        Downloads.removeAllDownloadsByPackage(context, OLD_UPDATER_PACKAGE, OLD_UPDATER_CLASS);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        if (intent.getBooleanExtra("from_quickboot", false)) {
            return;
        }
        new Thread() { // from class: com.android.server.BootReceiver.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    BootReceiver.this.logBootEvents(context);
                } catch (Exception e) {
                    Slog.e(BootReceiver.TAG, "Can't log boot events", e);
                }
                boolean z = false;
                try {
                    try {
                        z = IPackageManager.Stub.asInterface(ServiceManager.getService("package")).isOnlyCoreApps();
                    } catch (RemoteException e2) {
                    }
                    if (z) {
                        return;
                    }
                    BootReceiver.this.removeOldUpdatePackages(context);
                } catch (Exception e3) {
                    Slog.e(BootReceiver.TAG, "Can't remove old update packages", e3);
                }
            }
        }.start();
    }
}
