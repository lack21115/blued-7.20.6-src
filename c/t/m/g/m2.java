package c.t.m.g;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/m2.class */
public class m2 {
    public static void a(byte[] bArr, int i, boolean z) {
        if (z) {
            int i2 = i / 8;
            bArr[i2] = (byte) ((1 << (i % 8)) | bArr[i2]);
            return;
        }
        int i3 = i / 8;
        bArr[i3] = (byte) ((1 << (i % 8)) & bArr[i3]);
    }

    public static boolean a(byte[] bArr, int i) {
        return (bArr[i / 8] & (1 << (i % 8))) != 0;
    }
}
