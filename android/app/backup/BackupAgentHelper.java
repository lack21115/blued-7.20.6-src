package android.app.backup;

import android.os.ParcelFileDescriptor;
import java.io.IOException;

/* loaded from: source-9557208-dex2jar.jar:android/app/backup/BackupAgentHelper.class */
public class BackupAgentHelper extends BackupAgent {
    static final String TAG = "BackupAgentHelper";
    BackupHelperDispatcher mDispatcher = new BackupHelperDispatcher();

    public void addHelper(String str, BackupHelper backupHelper) {
        this.mDispatcher.addHelper(str, backupHelper);
    }

    public BackupHelperDispatcher getDispatcher() {
        return this.mDispatcher;
    }

    @Override // android.app.backup.BackupAgent
    public void onBackup(ParcelFileDescriptor parcelFileDescriptor, BackupDataOutput backupDataOutput, ParcelFileDescriptor parcelFileDescriptor2) throws IOException {
        this.mDispatcher.performBackup(parcelFileDescriptor, backupDataOutput, parcelFileDescriptor2);
    }

    @Override // android.app.backup.BackupAgent
    public void onRestore(BackupDataInput backupDataInput, int i, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        this.mDispatcher.performRestore(backupDataInput, i, parcelFileDescriptor);
    }
}
