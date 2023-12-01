package android.app.backup;

import java.io.FileDescriptor;
import java.io.IOException;

/* loaded from: source-9557208-dex2jar.jar:android/app/backup/BackupDataInput.class */
public class BackupDataInput {
    long mBackupReader;
    private EntityHeader mHeader = new EntityHeader();
    private boolean mHeaderReady;

    /* loaded from: source-9557208-dex2jar.jar:android/app/backup/BackupDataInput$EntityHeader.class */
    private static class EntityHeader {
        int dataSize;
        String key;

        private EntityHeader() {
        }
    }

    public BackupDataInput(FileDescriptor fileDescriptor) {
        if (fileDescriptor == null) {
            throw new NullPointerException();
        }
        this.mBackupReader = ctor(fileDescriptor);
        if (this.mBackupReader == 0) {
            throw new RuntimeException("Native initialization failed with fd=" + fileDescriptor);
        }
    }

    private static native long ctor(FileDescriptor fileDescriptor);

    private static native void dtor(long j);

    private native int readEntityData_native(long j, byte[] bArr, int i, int i2);

    private native int readNextHeader_native(long j, EntityHeader entityHeader);

    private native int skipEntityData_native(long j);

    protected void finalize() throws Throwable {
        try {
            dtor(this.mBackupReader);
        } finally {
            super.finalize();
        }
    }

    public int getDataSize() {
        if (this.mHeaderReady) {
            return this.mHeader.dataSize;
        }
        throw new IllegalStateException("Entity header not read");
    }

    public String getKey() {
        if (this.mHeaderReady) {
            return this.mHeader.key;
        }
        throw new IllegalStateException("Entity header not read");
    }

    public int readEntityData(byte[] bArr, int i, int i2) throws IOException {
        if (this.mHeaderReady) {
            int readEntityData_native = readEntityData_native(this.mBackupReader, bArr, i, i2);
            if (readEntityData_native >= 0) {
                return readEntityData_native;
            }
            throw new IOException("result=0x" + Integer.toHexString(readEntityData_native));
        }
        throw new IllegalStateException("Entity header not read");
    }

    public boolean readNextHeader() throws IOException {
        int readNextHeader_native = readNextHeader_native(this.mBackupReader, this.mHeader);
        if (readNextHeader_native == 0) {
            this.mHeaderReady = true;
            return true;
        } else if (readNextHeader_native > 0) {
            this.mHeaderReady = false;
            return false;
        } else {
            this.mHeaderReady = false;
            throw new IOException("failed: 0x" + Integer.toHexString(readNextHeader_native));
        }
    }

    public void skipEntityData() throws IOException {
        if (!this.mHeaderReady) {
            throw new IllegalStateException("Entity header not read");
        }
        skipEntityData_native(this.mBackupReader);
    }
}
