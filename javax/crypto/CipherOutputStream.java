package javax.crypto;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import libcore.io.Streams;

/* loaded from: source-2895416-dex2jar.jar:javax/crypto/CipherOutputStream.class */
public class CipherOutputStream extends FilterOutputStream {
    private final Cipher cipher;

    protected CipherOutputStream(OutputStream outputStream) {
        this(outputStream, new NullCipher());
    }

    public CipherOutputStream(OutputStream outputStream, Cipher cipher) {
        super(outputStream);
        this.cipher = cipher;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        byte[] doFinal;
        try {
            try {
                if (this.cipher != null && (doFinal = this.cipher.doFinal()) != null) {
                    this.out.write(doFinal);
                }
                if (this.out != null) {
                    this.out.flush();
                }
            } catch (BadPaddingException e) {
                throw new IOException(e.getMessage());
            } catch (IllegalBlockSizeException e2) {
                throw new IOException(e2.getMessage());
            }
        } finally {
            if (this.out != null) {
                this.out.close();
            }
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        Streams.writeSingleByte(this, i);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        byte[] update;
        if (i2 == 0 || (update = this.cipher.update(bArr, i, i2)) == null) {
            return;
        }
        this.out.write(update);
    }
}
