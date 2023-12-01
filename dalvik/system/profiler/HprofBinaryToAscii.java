package dalvik.system.profiler;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-2895416-dex2jar.jar:dalvik/system/profiler/HprofBinaryToAscii.class */
public final class HprofBinaryToAscii {
    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    private static boolean convert(String[] strArr) {
        if (strArr.length != 1) {
            usage("binary hprof file argument expected");
            return false;
        }
        File file = new File(strArr[0]);
        if (!file.exists()) {
            usage("file " + file + " does not exist");
            return false;
        } else if (startsWithMagic(file)) {
            try {
                return write(readHprof(file));
            } catch (IOException e) {
                System.out.println("Problem reading binary hprof data from " + file + ": " + e.getMessage());
                return false;
            }
        } else {
            try {
                return write(readSnapshot(file));
            } catch (IOException e2) {
                System.out.println("Problem reading snapshot containing binary hprof data from " + file + ": " + e2.getMessage());
                return false;
            }
        }
    }

    public static void main(String[] strArr) {
        System.exit(convert(strArr) ? 0 : 1);
    }

    private static HprofData read(InputStream inputStream) throws IOException {
        BinaryHprofReader binaryHprofReader = new BinaryHprofReader(inputStream);
        binaryHprofReader.setStrict(false);
        binaryHprofReader.read();
        return binaryHprofReader.getHprofData();
    }

    private static HprofData readHprof(File file) throws IOException {
        BufferedInputStream bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        } catch (Throwable th) {
            th = th;
            bufferedInputStream = null;
        }
        try {
            HprofData read = read(bufferedInputStream);
            closeQuietly(bufferedInputStream);
            return read;
        } catch (Throwable th2) {
            th = th2;
            closeQuietly(bufferedInputStream);
            throw th;
        }
    }

    private static HprofData readSnapshot(File file) throws IOException {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            while (true) {
                try {
                    int read = bufferedInputStream.read();
                    if (read == -1) {
                        throw new EOFException("Could not find expected header");
                    }
                    if (read == 10 && bufferedInputStream.read() == 10) {
                        HprofData read2 = read(bufferedInputStream);
                        closeQuietly(bufferedInputStream);
                        return read2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    closeQuietly(bufferedInputStream);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            bufferedInputStream = null;
            th = th3;
        }
    }

    private static boolean startsWithMagic(File file) {
        DataInputStream dataInputStream;
        boolean z = false;
        try {
            dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        } catch (IOException e) {
            dataInputStream = null;
        } catch (Throwable th) {
            th = th;
            dataInputStream = null;
        }
        try {
            if (BinaryHprof.readMagic(dataInputStream) != null) {
                z = true;
            }
            closeQuietly(dataInputStream);
            return z;
        } catch (IOException e2) {
            closeQuietly(dataInputStream);
            return false;
        } catch (Throwable th2) {
            th = th2;
            closeQuietly(dataInputStream);
            throw th;
        }
    }

    private static void usage(String str) {
        System.out.print("ERROR: ");
        System.out.println(str);
        System.out.println();
        System.out.println("usage: HprofBinaryToAscii <binary-hprof-file>");
        System.out.println();
        System.out.println("Reads a binary hprof file and print it in ASCII format");
    }

    private static boolean write(HprofData hprofData) {
        try {
            AsciiHprofWriter.write(hprofData, System.out);
            return true;
        } catch (IOException e) {
            System.out.println("Problem writing ASCII hprof data: " + e.getMessage());
            return false;
        }
    }
}
