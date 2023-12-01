package androidx.multidex;

import android.widget.ExpandableListView;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/multidex/ZipUtil.class */
public final class ZipUtil {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/multidex/ZipUtil$CentralDirectory.class */
    public static class CentralDirectory {

        /* renamed from: a  reason: collision with root package name */
        long f3183a;
        long b;

        CentralDirectory() {
        }
    }

    ZipUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long a(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            return a(randomAccessFile, a(randomAccessFile));
        } finally {
            randomAccessFile.close();
        }
    }

    static long a(RandomAccessFile randomAccessFile, CentralDirectory centralDirectory) throws IOException {
        CRC32 crc32 = new CRC32();
        long j = centralDirectory.b;
        randomAccessFile.seek(centralDirectory.f3183a);
        byte[] bArr = new byte[16384];
        int read = randomAccessFile.read(bArr, 0, (int) Math.min(16384L, j));
        while (true) {
            int i = read;
            if (i == -1) {
                break;
            }
            crc32.update(bArr, 0, i);
            j -= i;
            if (j == 0) {
                break;
            }
            read = randomAccessFile.read(bArr, 0, (int) Math.min(16384L, j));
        }
        return crc32.getValue();
    }

    static CentralDirectory a(RandomAccessFile randomAccessFile) throws IOException, ZipException {
        long length = randomAccessFile.length() - 22;
        long j = 0;
        if (length < 0) {
            throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
        }
        long j2 = length - 65536;
        if (j2 >= 0) {
            j = j2;
        }
        int reverseBytes = Integer.reverseBytes(101010256);
        do {
            randomAccessFile.seek(length);
            if (randomAccessFile.readInt() == reverseBytes) {
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                CentralDirectory centralDirectory = new CentralDirectory();
                centralDirectory.b = Integer.reverseBytes(randomAccessFile.readInt()) & ExpandableListView.PACKED_POSITION_VALUE_NULL;
                centralDirectory.f3183a = Integer.reverseBytes(randomAccessFile.readInt()) & ExpandableListView.PACKED_POSITION_VALUE_NULL;
                return centralDirectory;
            }
            length--;
        } while (length >= j);
        throw new ZipException("End Of Central Directory signature not found");
    }
}
