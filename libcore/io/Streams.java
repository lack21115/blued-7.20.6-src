package libcore.io;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: source-2895416-dex2jar.jar:libcore/io/Streams.class */
public final class Streams {
    private static AtomicReference<byte[]> skipBuffer = new AtomicReference<>();

    private Streams() {
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        int i = 0;
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return i;
            }
            i += read;
            outputStream.write(bArr, 0, read);
        }
    }

    public static String readAsciiLine(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder(80);
        while (true) {
            int read = inputStream.read();
            if (read == -1) {
                throw new EOFException();
            }
            if (read == 10) {
                int length = sb.length();
                if (length > 0 && sb.charAt(length - 1) == '\r') {
                    sb.setLength(length - 1);
                }
                return sb.toString();
            }
            sb.append((char) read);
        }
    }

    public static String readFully(Reader reader) throws IOException {
        try {
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[1024];
            while (true) {
                int read = reader.read(cArr);
                if (read == -1) {
                    return stringWriter.toString();
                }
                stringWriter.write(cArr, 0, read);
            }
        } finally {
            reader.close();
        }
    }

    public static void readFully(InputStream inputStream, byte[] bArr) throws IOException {
        readFully(inputStream, bArr, 0, bArr.length);
    }

    public static void readFully(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return;
        }
        if (inputStream == null) {
            throw new NullPointerException("in == null");
        }
        if (bArr == null) {
            throw new NullPointerException("dst == null");
        }
        Arrays.checkOffsetAndCount(bArr.length, i, i2);
        while (i2 > 0) {
            int read = inputStream.read(bArr, i, i2);
            if (read < 0) {
                throw new EOFException();
            }
            i += read;
            i2 -= read;
        }
    }

    public static byte[] readFully(InputStream inputStream) throws IOException {
        try {
            return readFullyNoClose(inputStream);
        } finally {
            inputStream.close();
        }
    }

    public static byte[] readFullyNoClose(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static int readSingleByte(InputStream inputStream) throws IOException {
        int i = -1;
        byte[] bArr = new byte[1];
        if (inputStream.read(bArr, 0, 1) != -1) {
            i = bArr[0] & 255;
        }
        return i;
    }

    public static void skipAll(InputStream inputStream) throws IOException {
        do {
            inputStream.skip(Long.MAX_VALUE);
        } while (inputStream.read() != -1);
    }

    public static long skipByReading(InputStream inputStream, long j) throws IOException {
        long j2;
        byte[] andSet = skipBuffer.getAndSet(null);
        byte[] bArr = andSet;
        if (andSet == null) {
            bArr = new byte[4096];
        }
        long j3 = 0;
        while (true) {
            j2 = j3;
            if (j3 < j) {
                int min = (int) Math.min(j - j3, bArr.length);
                int read = inputStream.read(bArr, 0, min);
                if (read != -1) {
                    j2 = j3 + read;
                    j3 = j2;
                    if (read < min) {
                        break;
                    }
                } else {
                    j2 = j3;
                    break;
                }
            } else {
                break;
            }
        }
        skipBuffer.set(bArr);
        return j2;
    }

    public static void writeSingleByte(OutputStream outputStream, int i) throws IOException {
        outputStream.write(new byte[]{(byte) (i & 255)});
    }
}
