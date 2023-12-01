package java.security;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: source-2895416-dex2jar.jar:java/security/DigestOutputStream.class */
public class DigestOutputStream extends FilterOutputStream {
    protected MessageDigest digest;
    private boolean isOn;

    public DigestOutputStream(OutputStream outputStream, MessageDigest messageDigest) {
        super(outputStream);
        this.isOn = true;
        this.digest = messageDigest;
    }

    public MessageDigest getMessageDigest() {
        return this.digest;
    }

    public void on(boolean z) {
        this.isOn = z;
    }

    public void setMessageDigest(MessageDigest messageDigest) {
        this.digest = messageDigest;
    }

    public String toString() {
        return super.toString() + ", " + this.digest.toString() + (this.isOn ? ", is on" : ", is off");
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        if (this.isOn) {
            this.digest.update((byte) i);
        }
        this.out.write(i);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.isOn) {
            this.digest.update(bArr, i, i2);
        }
        this.out.write(bArr, i, i2);
    }
}
