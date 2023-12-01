package com.android.server.backup;

import android.app.ActivityManagerNative;
import android.app.IWallpaperManager;
import android.app.backup.BackupAgentHelper;
import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.app.backup.FullBackup;
import android.app.backup.FullBackupDataOutput;
import android.app.backup.RecentsBackupHelper;
import android.app.backup.WallpaperBackupHelper;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Slog;
import com.android.internal.util.cm.NavigationRingConstants;
import com.anythink.core.common.b.g;
import java.io.File;
import java.io.IOException;

/* loaded from: source-4181928-dex2jar.jar:com/android/server/backup/SystemBackupAgent.class */
public class SystemBackupAgent extends BackupAgentHelper {
    private static final String TAG = "SystemBackupAgent";
    private static final String WALLPAPER_IMAGE_FILENAME = "wallpaper";
    private static final String WALLPAPER_IMAGE_KEY = "/data/data/com.android.settings/files/wallpaper";
    private static final String WALLPAPER_INFO_FILENAME = "wallpaper_info.xml";
    private static final String WALLPAPER_INFO_KEY = "/data/system/wallpaper_info.xml";
    private static final String WALLPAPER_IMAGE_DIR = Environment.getUserSystemDirectory(0).getAbsolutePath();
    private static final String WALLPAPER_IMAGE = WallpaperBackupHelper.WALLPAPER_IMAGE;
    private static final String WALLPAPER_INFO_DIR = Environment.getUserSystemDirectory(0).getAbsolutePath();
    private static final String WALLPAPER_INFO = WallpaperBackupHelper.WALLPAPER_INFO;

    private void fullWallpaperBackup(FullBackupDataOutput fullBackupDataOutput) {
        FullBackup.backupToTar(getPackageName(), g.o.o, (String) null, WALLPAPER_INFO_DIR, WALLPAPER_INFO, fullBackupDataOutput.getData());
        FullBackup.backupToTar(getPackageName(), g.o.o, (String) null, WALLPAPER_IMAGE_DIR, WALLPAPER_IMAGE, fullBackupDataOutput.getData());
    }

    @Override // android.app.backup.BackupAgentHelper, android.app.backup.BackupAgent
    public void onBackup(ParcelFileDescriptor parcelFileDescriptor, BackupDataOutput backupDataOutput, ParcelFileDescriptor parcelFileDescriptor2) throws IOException {
        IWallpaperManager service = ServiceManager.getService(WALLPAPER_IMAGE_FILENAME);
        String[] strArr = {WALLPAPER_IMAGE, WALLPAPER_INFO};
        String[] strArr2 = {WALLPAPER_IMAGE_KEY, WALLPAPER_INFO_KEY};
        String[] strArr3 = strArr;
        String[] strArr4 = strArr2;
        if (service != null) {
            try {
                String name = service.getName();
                strArr3 = strArr;
                strArr4 = strArr2;
                if (name != null) {
                    strArr3 = strArr;
                    strArr4 = strArr2;
                    if (name.length() > 0) {
                        strArr3 = new String[]{WALLPAPER_INFO};
                        strArr4 = new String[]{WALLPAPER_INFO_KEY};
                    }
                }
            } catch (RemoteException e) {
                strArr3 = strArr;
                Slog.e(TAG, "Couldn't get wallpaper name\n" + e);
                strArr4 = strArr2;
            }
        }
        addHelper(WALLPAPER_IMAGE_FILENAME, new WallpaperBackupHelper(this, strArr3, strArr4));
        addHelper(NavigationRingConstants.ACTION_RECENTS, new RecentsBackupHelper(this));
        super.onBackup(parcelFileDescriptor, backupDataOutput, parcelFileDescriptor2);
    }

    @Override // android.app.backup.BackupAgent
    public void onFullBackup(FullBackupDataOutput fullBackupDataOutput) throws IOException {
        fullWallpaperBackup(fullBackupDataOutput);
    }

    @Override // android.app.backup.BackupAgentHelper, android.app.backup.BackupAgent
    public void onRestore(BackupDataInput backupDataInput, int i, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        addHelper(WALLPAPER_IMAGE_FILENAME, new WallpaperBackupHelper(this, new String[]{WALLPAPER_IMAGE, WALLPAPER_INFO}, new String[]{WALLPAPER_IMAGE_KEY, WALLPAPER_INFO_KEY}));
        addHelper("system_files", new WallpaperBackupHelper(this, new String[]{WALLPAPER_IMAGE}, new String[]{WALLPAPER_IMAGE_KEY}));
        addHelper(NavigationRingConstants.ACTION_RECENTS, new RecentsBackupHelper(this));
        try {
            super.onRestore(backupDataInput, i, parcelFileDescriptor);
            IWallpaperManager service = ServiceManager.getService(WALLPAPER_IMAGE_FILENAME);
            if (service != null) {
                try {
                    service.settingsRestored();
                } catch (RemoteException e) {
                    Slog.e(TAG, "Couldn't restore settings\n" + e);
                }
            }
        } catch (IOException e2) {
            Slog.d(TAG, "restore failed", e2);
            new File(WALLPAPER_IMAGE).delete();
            new File(WALLPAPER_INFO).delete();
        }
    }

    public void onRestoreFile(ParcelFileDescriptor parcelFileDescriptor, long j, int i, String str, String str2, long j2, long j3) throws IOException {
        IWallpaperManager service;
        Slog.i(TAG, "Restoring file domain=" + str + " path=" + str2);
        File file = null;
        boolean z = false;
        if (str.equals(g.o.o)) {
            if (str2.equals(WALLPAPER_INFO_FILENAME)) {
                file = new File(WALLPAPER_INFO);
                z = true;
            } else {
                file = null;
                z = false;
                if (str2.equals(WALLPAPER_IMAGE_FILENAME)) {
                    file = new File(WALLPAPER_IMAGE);
                    z = true;
                }
            }
        }
        if (file == null) {
            try {
                Slog.w(TAG, "Skipping unrecognized system file: [ " + str + " : " + str2 + " ]");
            } catch (IOException e) {
                if (z) {
                    new File(WALLPAPER_IMAGE).delete();
                    new File(WALLPAPER_INFO).delete();
                    return;
                }
                return;
            }
        }
        FullBackup.restoreFile(parcelFileDescriptor, j, i, j2, j3, file);
        if (!z || (service = ServiceManager.getService(WALLPAPER_IMAGE_FILENAME)) == null) {
            return;
        }
        try {
            service.settingsRestored();
        } catch (RemoteException e2) {
            Slog.e(TAG, "Couldn't restore settings\n" + e2);
        }
    }

    @Override // android.app.backup.BackupAgent
    public void onRestoreFinished() {
        try {
            ActivityManagerNative.getDefault().systemBackupRestored();
        } catch (RemoteException e) {
        }
    }
}
