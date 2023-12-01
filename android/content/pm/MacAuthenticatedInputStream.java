package android.content.pm;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.crypto.Mac;

/* loaded from: source-9557208-dex2jar.jar:android/content/pm/MacAuthenticatedInputStream.class */
public class MacAuthenticatedInputStream extends FilterInputStream {
    private final Mac mMac;

    public MacAuthenticatedInputStream(InputStream inputStream, Mac mac) {
        super(inputStream);
        this.mMac = mac;
    }

    public boolean isTagEqual(byte[] bArr) {
        byte[] doFinal = this.mMac.doFinal();
        if (bArr == null || doFinal == null || bArr.length != doFinal.length) {
            return false;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= bArr.length) {
                break;
            }
            i |= bArr[i3] ^ doFinal[i3];
            i2 = i3 + 1;
        }
        return i == 0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = super.read();
        if (read >= 0) {
            this.mMac.update((byte) read);
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        if (read > 0) {
            this.mMac.update(bArr, i, read);
        }
        return read;
    }
}
