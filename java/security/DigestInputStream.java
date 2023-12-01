package java.security;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-2895416-dex2jar.jar:java/security/DigestInputStream.class */
public class DigestInputStream extends FilterInputStream {
    protected MessageDigest digest;
    private boolean isOn;

    public DigestInputStream(InputStream inputStream, MessageDigest messageDigest) {
        super(inputStream);
        this.isOn = true;
        this.digest = messageDigest;
    }

    public MessageDigest getMessageDigest() {
        return this.digest;
    }

    public void on(boolean z) {
        this.isOn = z;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = this.in.read();
        if (this.isOn && read != -1) {
            this.digest.update((byte) read);
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.in.read(bArr, i, i2);
        if (this.isOn && read != -1) {
            this.digest.update(bArr, i, read);
        }
        return read;
    }

    public void setMessageDigest(MessageDigest messageDigest) {
        this.digest = messageDigest;
    }

    public String toString() {
        return super.toString() + ", " + this.digest.toString() + (this.isOn ? ", is on" : ", is off");
    }
}
