package android.app.backup;

import android.os.ParcelFileDescriptor;

/* loaded from: source-9557208-dex2jar.jar:android/app/backup/BackupHelper.class */
public interface BackupHelper {
    void performBackup(ParcelFileDescriptor parcelFileDescriptor, BackupDataOutput backupDataOutput, ParcelFileDescriptor parcelFileDescriptor2);

    void restoreEntity(BackupDataInputStream backupDataInputStream);

    void writeNewStateDescription(ParcelFileDescriptor parcelFileDescriptor);
}
