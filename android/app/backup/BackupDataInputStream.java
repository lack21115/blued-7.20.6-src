package android.app.backup;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-9557208-dex2jar.jar:android/app/backup/BackupDataInputStream.class */
public class BackupDataInputStream extends InputStream {
    int dataSize;
    String key;
    BackupDataInput mData;
    byte[] mOneByte;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BackupDataInputStream(BackupDataInput backupDataInput) {
        this.mData = backupDataInput;
    }

    public String getKey() {
        return this.key;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        byte[] bArr = this.mOneByte;
        if (this.mOneByte == null) {
            bArr = new byte[1];
            this.mOneByte = bArr;
        }
        this.mData.readEntityData(bArr, 0, 1);
        return bArr[0];
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return this.mData.readEntityData(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.mData.readEntityData(bArr, i, i2);
    }

    public int size() {
        return this.dataSize;
    }
}
