package android.app.backup;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: source-9557208-dex2jar.jar:android/app/backup/BackupHelperDispatcher.class */
public class BackupHelperDispatcher {
    private static final String TAG = "BackupHelperDispatcher";
    TreeMap<String, BackupHelper> mHelpers = new TreeMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/backup/BackupHelperDispatcher$Header.class */
    public static class Header {
        int chunkSize;
        String keyPrefix;

        private Header() {
        }
    }

    private static native int allocateHeader_native(Header header, FileDescriptor fileDescriptor);

    private void doOneBackup(ParcelFileDescriptor parcelFileDescriptor, BackupDataOutput backupDataOutput, ParcelFileDescriptor parcelFileDescriptor2, Header header, BackupHelper backupHelper) throws IOException {
        FileDescriptor fileDescriptor = parcelFileDescriptor2.getFileDescriptor();
        int allocateHeader_native = allocateHeader_native(header, fileDescriptor);
        if (allocateHeader_native < 0) {
            throw new IOException("allocateHeader_native failed (error " + allocateHeader_native + ")");
        }
        backupDataOutput.setKeyPrefix(header.keyPrefix);
        backupHelper.performBackup(parcelFileDescriptor, backupDataOutput, parcelFileDescriptor2);
        int writeHeader_native = writeHeader_native(header, fileDescriptor, allocateHeader_native);
        if (writeHeader_native != 0) {
            throw new IOException("writeHeader_native failed (error " + writeHeader_native + ")");
        }
    }

    private static native int readHeader_native(Header header, FileDescriptor fileDescriptor);

    private static native int skipChunk_native(FileDescriptor fileDescriptor, int i);

    private static native int writeHeader_native(Header header, FileDescriptor fileDescriptor, int i);

    public void addHelper(String str, BackupHelper backupHelper) {
        this.mHelpers.put(str, backupHelper);
    }

    public void performBackup(ParcelFileDescriptor parcelFileDescriptor, BackupDataOutput backupDataOutput, ParcelFileDescriptor parcelFileDescriptor2) throws IOException {
        Header header = new Header();
        TreeMap treeMap = (TreeMap) this.mHelpers.clone();
        if (parcelFileDescriptor != null) {
            FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
            while (true) {
                int readHeader_native = readHeader_native(header, fileDescriptor);
                if (readHeader_native < 0) {
                    break;
                } else if (readHeader_native == 0) {
                    BackupHelper backupHelper = (BackupHelper) treeMap.get(header.keyPrefix);
                    Log.d(TAG, "handling existing helper '" + header.keyPrefix + "' " + backupHelper);
                    if (backupHelper != null) {
                        doOneBackup(parcelFileDescriptor, backupDataOutput, parcelFileDescriptor2, header, backupHelper);
                        treeMap.remove(header.keyPrefix);
                    } else {
                        skipChunk_native(fileDescriptor, header.chunkSize);
                    }
                }
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            header.keyPrefix = (String) entry.getKey();
            Log.d(TAG, "handling new helper '" + header.keyPrefix + "'");
            doOneBackup(parcelFileDescriptor, backupDataOutput, parcelFileDescriptor2, header, (BackupHelper) entry.getValue());
        }
    }

    public void performRestore(BackupDataInput backupDataInput, int i, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        boolean z;
        boolean z2 = false;
        BackupDataInputStream backupDataInputStream = new BackupDataInputStream(backupDataInput);
        while (backupDataInput.readNextHeader()) {
            String key = backupDataInput.getKey();
            int indexOf = key.indexOf(58);
            if (indexOf > 0) {
                BackupHelper backupHelper = this.mHelpers.get(key.substring(0, indexOf));
                if (backupHelper != null) {
                    backupDataInputStream.dataSize = backupDataInput.getDataSize();
                    backupDataInputStream.key = key.substring(indexOf + 1);
                    backupHelper.restoreEntity(backupDataInputStream);
                    z = z2;
                } else {
                    z = z2;
                    if (!z2) {
                        Log.w(TAG, "Couldn't find helper for: '" + key + "'");
                        z = true;
                    }
                }
            } else {
                z = z2;
                if (!z2) {
                    Log.w(TAG, "Entity with no prefix: '" + key + "'");
                    z = true;
                }
            }
            backupDataInput.skipEntityData();
            z2 = z;
        }
        for (BackupHelper backupHelper2 : this.mHelpers.values()) {
            backupHelper2.writeNewStateDescription(parcelFileDescriptor);
        }
    }
}
