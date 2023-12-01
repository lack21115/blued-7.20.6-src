package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/Utf8.class */
public abstract class Utf8 {

    /* renamed from: a  reason: collision with root package name */
    private static Utf8 f2874a;

    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/Utf8$DecodeUtil.class */
    static class DecodeUtil {
        DecodeUtil() {
        }

        private static char a(int i) {
            return (char) ((i >>> 10) + okio.Utf8.HIGH_SURROGATE_HEADER);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static void a(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws IllegalArgumentException {
            if (d(b2) || (((b << 28) + (b2 + 112)) >> 30) != 0 || d(b3) || d(b4)) {
                throw new IllegalArgumentException("Invalid UTF-8");
            }
            int e = ((b & 7) << 18) | (e(b2) << 12) | (e(b3) << 6) | e(b4);
            cArr[i] = a(e);
            cArr[i + 1] = b(e);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static void a(byte b, byte b2, byte b3, char[] cArr, int i) throws IllegalArgumentException {
            if (d(b2) || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || d(b3)))) {
                throw new IllegalArgumentException("Invalid UTF-8");
            }
            cArr[i] = (char) (((b & 15) << 12) | (e(b2) << 6) | e(b3));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static void a(byte b, byte b2, char[] cArr, int i) throws IllegalArgumentException {
            if (b < -62) {
                throw new IllegalArgumentException("Invalid UTF-8: Illegal leading byte in 2 bytes utf");
            }
            if (d(b2)) {
                throw new IllegalArgumentException("Invalid UTF-8: Illegal trailing byte in 2 bytes utf");
            }
            cArr[i] = (char) (((b & 31) << 6) | e(b2));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static void a(byte b, char[] cArr, int i) {
            cArr[i] = (char) b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static boolean a(byte b) {
            return b >= 0;
        }

        private static char b(int i) {
            return (char) ((i & 1023) + 56320);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static boolean b(byte b) {
            return b < -32;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static boolean c(byte b) {
            return b < -16;
        }

        private static boolean d(byte b) {
            return b > -65;
        }

        private static int e(byte b) {
            return b & 63;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/Utf8$UnpairedSurrogateException.class */
    static class UnpairedSurrogateException extends IllegalArgumentException {
    }

    public static Utf8 getDefault() {
        if (f2874a == null) {
            f2874a = new Utf8Safe();
        }
        return f2874a;
    }

    public static void setDefault(Utf8 utf8) {
        f2874a = utf8;
    }

    public abstract String decodeUtf8(ByteBuffer byteBuffer, int i, int i2);

    public abstract void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer);

    public abstract int encodedLength(CharSequence charSequence);
}
