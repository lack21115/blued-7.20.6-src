package android.drm;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: source-9557208-dex2jar.jar:android/drm/DrmUtils.class */
public class DrmUtils {

    /* loaded from: source-9557208-dex2jar.jar:android/drm/DrmUtils$ExtendedMetadataParser.class */
    public static class ExtendedMetadataParser {
        HashMap<String, String> mMap;

        private ExtendedMetadataParser(byte[] bArr) {
            this.mMap = new HashMap<>();
            int i = 0;
            while (i < bArr.length) {
                int readByte = readByte(bArr, i);
                int i2 = i + 1;
                int readByte2 = readByte(bArr, i2);
                int i3 = i2 + 1;
                String readMultipleBytes = readMultipleBytes(bArr, readByte, i3);
                int i4 = i3 + readByte;
                String readMultipleBytes2 = readMultipleBytes(bArr, readByte2, i4);
                String str = readMultipleBytes2;
                if (readMultipleBytes2.equals(" ")) {
                    str = "";
                }
                i = i4 + readByte2;
                this.mMap.put(readMultipleBytes, str);
            }
        }

        private int readByte(byte[] bArr, int i) {
            return bArr[i];
        }

        private String readMultipleBytes(byte[] bArr, int i, int i2) {
            byte[] bArr2 = new byte[i];
            int i3 = i2;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i3 >= i2 + i) {
                    return new String(bArr2);
                }
                bArr2[i5] = bArr[i3];
                i3++;
                i4 = i5 + 1;
            }
        }

        public String get(String str) {
            return this.mMap.get(str);
        }

        public Iterator<String> iterator() {
            return this.mMap.values().iterator();
        }

        public Iterator<String> keyIterator() {
            return this.mMap.keySet().iterator();
        }
    }

    public static ExtendedMetadataParser getExtendedMetadataParser(byte[] bArr) {
        return new ExtendedMetadataParser(bArr);
    }

    private static void quietlyDispose(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }

    private static void quietlyDispose(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] readBytes(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        byte[] bArr = null;
        try {
            int available = bufferedInputStream.available();
            if (available > 0) {
                bArr = new byte[available];
                bufferedInputStream.read(bArr);
            }
            quietlyDispose(bufferedInputStream);
            quietlyDispose(fileInputStream);
            return bArr;
        } catch (Throwable th) {
            quietlyDispose(bufferedInputStream);
            quietlyDispose(fileInputStream);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] readBytes(String str) throws IOException {
        return readBytes(new File(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void removeFile(String str) throws IOException {
        new File(str).delete();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeToFile(String str, byte[] bArr) throws IOException {
        FileOutputStream fileOutputStream;
        if (str == null || bArr == null) {
            return;
        }
        try {
            fileOutputStream = new FileOutputStream(str);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            fileOutputStream.write(bArr);
            quietlyDispose(fileOutputStream);
        } catch (Throwable th2) {
            th = th2;
            quietlyDispose(fileOutputStream);
            throw th;
        }
    }
}
