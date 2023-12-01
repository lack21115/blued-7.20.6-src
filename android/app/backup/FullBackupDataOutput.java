package android.app.backup;

import android.os.ParcelFileDescriptor;

/* loaded from: source-9557208-dex2jar.jar:android/app/backup/FullBackupDataOutput.class */
public class FullBackupDataOutput {
    private BackupDataOutput mData;

    public FullBackupDataOutput(ParcelFileDescriptor parcelFileDescriptor) {
        this.mData = new BackupDataOutput(parcelFileDescriptor.getFileDescriptor());
    }

    public BackupDataOutput getData() {
        return this.mData;
    }
}
