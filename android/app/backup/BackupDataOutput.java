package android.app.backup;

import java.io.FileDescriptor;
import java.io.IOException;

/* loaded from: source-9557208-dex2jar.jar:android/app/backup/BackupDataOutput.class */
public class BackupDataOutput {
    long mBackupWriter;

    public BackupDataOutput(FileDescriptor fileDescriptor) {
        if (fileDescriptor == null) {
            throw new NullPointerException();
        }
        this.mBackupWriter = ctor(fileDescriptor);
        if (this.mBackupWriter == 0) {
            throw new RuntimeException("Native initialization failed with fd=" + fileDescriptor);
        }
    }

    private static native long ctor(FileDescriptor fileDescriptor);

    private static native void dtor(long j);

    private static native void setKeyPrefix_native(long j, String str);

    private static native int writeEntityData_native(long j, byte[] bArr, int i);

    private static native int writeEntityHeader_native(long j, String str, int i);

    protected void finalize() throws Throwable {
        try {
            dtor(this.mBackupWriter);
        } finally {
            super.finalize();
        }
    }

    public void setKeyPrefix(String str) {
        setKeyPrefix_native(this.mBackupWriter, str);
    }

    public int writeEntityData(byte[] bArr, int i) throws IOException {
        int writeEntityData_native = writeEntityData_native(this.mBackupWriter, bArr, i);
        if (writeEntityData_native >= 0) {
            return writeEntityData_native;
        }
        throw new IOException("result=0x" + Integer.toHexString(writeEntityData_native));
    }

    public int writeEntityHeader(String str, int i) throws IOException {
        int writeEntityHeader_native = writeEntityHeader_native(this.mBackupWriter, str, i);
        if (writeEntityHeader_native >= 0) {
            return writeEntityHeader_native;
        }
        throw new IOException("result=0x" + Integer.toHexString(writeEntityHeader_native));
    }
}
