package android.app.backup;

import android.os.ParcelFileDescriptor;
import java.io.IOException;

/* loaded from: source-9557208-dex2jar.jar:android/app/backup/FullBackupAgent.class */
public class FullBackupAgent extends BackupAgent {
    @Override // android.app.backup.BackupAgent
    public void onBackup(ParcelFileDescriptor parcelFileDescriptor, BackupDataOutput backupDataOutput, ParcelFileDescriptor parcelFileDescriptor2) throws IOException {
    }

    @Override // android.app.backup.BackupAgent
    public void onRestore(BackupDataInput backupDataInput, int i, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
    }
}
