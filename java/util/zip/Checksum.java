package java.util.zip;

/* loaded from: source-2895416-dex2jar.jar:java/util/zip/Checksum.class */
public interface Checksum {
    long getValue();

    void reset();

    void update(int i);

    void update(byte[] bArr, int i, int i2);
}
