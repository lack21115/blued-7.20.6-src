package com.tencent.tinker.bsdiff;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.zip.GZIPInputStream;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/bsdiff/BSPatch.class */
public class BSPatch {
    public static final int RETURN_DIFF_FILE_ERR = 2;
    public static final int RETURN_NEW_FILE_ERR = 4;
    public static final int RETURN_OLD_FILE_ERR = 3;
    public static final int RETURN_SUCCESS = 1;

    public static int patchFast(File file, File file2, File file3, int i) throws IOException {
        if (file == null || file.length() <= 0) {
            return 3;
        }
        if (file2 == null) {
            return 4;
        }
        if (file3 == null || file3.length() <= 0) {
            return 2;
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        int length = (int) file3.length();
        byte[] bArr = new byte[length];
        FileInputStream fileInputStream = new FileInputStream(file3);
        try {
            BSUtil.readFromStream(fileInputStream, bArr, 0, length);
            fileInputStream.close();
            byte[] patchFast = patchFast(bufferedInputStream, (int) file.length(), bArr, i);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                fileOutputStream.write(patchFast);
                fileOutputStream.close();
                return 1;
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            fileInputStream.close();
            throw th2;
        }
    }

    public static int patchFast(InputStream inputStream, InputStream inputStream2, File file) throws IOException {
        if (inputStream == null) {
            return 3;
        }
        if (file == null) {
            return 4;
        }
        if (inputStream2 == null) {
            return 2;
        }
        byte[] inputStreamToByte = BSUtil.inputStreamToByte(inputStream);
        byte[] inputStreamToByte2 = BSUtil.inputStreamToByte(inputStream2);
        byte[] patchFast = patchFast(inputStreamToByte, inputStreamToByte.length, inputStreamToByte2, inputStreamToByte2.length, 0);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(patchFast);
            fileOutputStream.close();
            return 1;
        } catch (Throwable th) {
            fileOutputStream.close();
            throw th;
        }
    }

    public static byte[] patchFast(InputStream inputStream, int i, byte[] bArr, int i2) throws IOException {
        byte[] bArr2 = new byte[i];
        BSUtil.readFromStream(inputStream, bArr2, 0, i);
        inputStream.close();
        return patchFast(bArr2, i, bArr, bArr.length, i2);
    }

    public static byte[] patchFast(InputStream inputStream, InputStream inputStream2) throws IOException {
        if (inputStream == null || inputStream2 == null) {
            return null;
        }
        byte[] inputStreamToByte = BSUtil.inputStreamToByte(inputStream);
        byte[] inputStreamToByte2 = BSUtil.inputStreamToByte(inputStream2);
        return patchFast(inputStreamToByte, inputStreamToByte.length, inputStreamToByte2, inputStreamToByte2.length, 0);
    }

    public static byte[] patchFast(byte[] bArr, int i, byte[] bArr2, int i2, int i3) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr2, 0, i2));
        dataInputStream.skip(8L);
        long readLong = dataInputStream.readLong();
        long readLong2 = dataInputStream.readLong();
        int readLong3 = (int) dataInputStream.readLong();
        dataInputStream.close();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr2, 0, i2);
        byteArrayInputStream.skip(32L);
        DataInputStream dataInputStream2 = new DataInputStream(new GZIPInputStream(byteArrayInputStream));
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr2, 0, i2);
        byteArrayInputStream2.skip(readLong + 32);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream2);
        ByteArrayInputStream byteArrayInputStream3 = new ByteArrayInputStream(bArr2, 0, i2);
        byteArrayInputStream3.skip(readLong2 + readLong + 32);
        GZIPInputStream gZIPInputStream2 = new GZIPInputStream(byteArrayInputStream3);
        byte[] bArr3 = new byte[readLong3];
        int[] iArr = new int[3];
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i4 >= readLong3) {
                dataInputStream2.close();
                gZIPInputStream.close();
                gZIPInputStream2.close();
                return bArr3;
            }
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 > 2) {
                    break;
                }
                iArr[i8] = dataInputStream2.readInt();
                i7 = i8 + 1;
            }
            if (iArr[0] + i4 > readLong3) {
                throw new IOException("Corrupt by wrong patch file.");
            }
            if (!BSUtil.readFromStream(gZIPInputStream, bArr3, i4, iArr[0])) {
                throw new IOException("Corrupt by wrong patch file.");
            }
            int i9 = 0;
            while (true) {
                int i10 = i9;
                if (i10 >= iArr[0]) {
                    break;
                }
                int i11 = i6 + i10;
                if (i11 >= 0 && i11 < i) {
                    int i12 = i4 + i10;
                    bArr3[i12] = (byte) (bArr3[i12] + bArr[i11]);
                }
                i9 = i10 + 1;
            }
            int i13 = i4 + iArr[0];
            int i14 = iArr[0];
            if (iArr[1] + i13 > readLong3) {
                throw new IOException("Corrupt by wrong patch file.");
            }
            if (!BSUtil.readFromStream(gZIPInputStream2, bArr3, i13, iArr[1])) {
                throw new IOException("Corrupt by wrong patch file.");
            }
            i4 = i13 + iArr[1];
            i5 = i6 + i14 + iArr[2];
        }
    }

    public static int patchLessMemory(RandomAccessFile randomAccessFile, int i, byte[] bArr, int i2, File file, int i3) throws IOException {
        if (randomAccessFile == null || i <= 0) {
            return 3;
        }
        if (file == null) {
            return 4;
        }
        if (bArr == null || i2 <= 0) {
            return 2;
        }
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr, 0, i2));
        dataInputStream.skip(8L);
        long readLong = dataInputStream.readLong();
        long readLong2 = dataInputStream.readLong();
        int readLong3 = (int) dataInputStream.readLong();
        dataInputStream.close();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, 0, i2);
        byteArrayInputStream.skip(32L);
        DataInputStream dataInputStream2 = new DataInputStream(new GZIPInputStream(byteArrayInputStream));
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr, 0, i2);
        byteArrayInputStream2.skip(readLong + 32);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream2);
        ByteArrayInputStream byteArrayInputStream3 = new ByteArrayInputStream(bArr, 0, i2);
        byteArrayInputStream3.skip(readLong2 + readLong + 32);
        GZIPInputStream gZIPInputStream2 = new GZIPInputStream(byteArrayInputStream3);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            int[] iArr = new int[3];
            int i4 = 0;
            int i5 = 0;
            while (i4 < readLong3) {
                int i6 = 0;
                while (true) {
                    int i7 = i6;
                    if (i7 > 2) {
                        break;
                    }
                    iArr[i7] = dataInputStream2.readInt();
                    i6 = i7 + 1;
                }
                if (iArr[0] + i4 > readLong3) {
                    fileOutputStream.close();
                } else {
                    byte[] bArr2 = new byte[iArr[0]];
                    if (BSUtil.readFromStream(gZIPInputStream, bArr2, 0, iArr[0])) {
                        byte[] bArr3 = new byte[iArr[0]];
                        try {
                            if (randomAccessFile.read(bArr3, 0, iArr[0]) < iArr[0]) {
                                fileOutputStream.close();
                            } else {
                                int i8 = 0;
                                while (true) {
                                    int i9 = i8;
                                    if (i9 >= iArr[0]) {
                                        break;
                                    }
                                    int i10 = i5 + i9;
                                    if (i10 >= 0 && i10 < i) {
                                        bArr2[i9] = (byte) (bArr2[i9] + bArr3[i9]);
                                    }
                                    i8 = i9 + 1;
                                }
                                fileOutputStream.write(bArr2);
                                int i11 = i4 + iArr[0];
                                int i12 = iArr[0];
                                if (iArr[1] + i11 > readLong3) {
                                    fileOutputStream.close();
                                } else {
                                    byte[] bArr4 = new byte[iArr[1]];
                                    if (!BSUtil.readFromStream(gZIPInputStream2, bArr4, 0, iArr[1])) {
                                        fileOutputStream.close();
                                        randomAccessFile.close();
                                        fileOutputStream.close();
                                        return 2;
                                    }
                                    fileOutputStream.write(bArr4);
                                    fileOutputStream.flush();
                                    i4 = i11 + iArr[1];
                                    i5 = i5 + i12 + iArr[2];
                                    randomAccessFile.seek(i5);
                                }
                            }
                            randomAccessFile.close();
                            fileOutputStream.close();
                            return 2;
                        } catch (Throwable th) {
                            th = th;
                            randomAccessFile.close();
                            fileOutputStream.close();
                            throw th;
                        }
                    }
                    fileOutputStream.close();
                }
                randomAccessFile.close();
                fileOutputStream.close();
                return 2;
            }
            dataInputStream2.close();
            gZIPInputStream.close();
            gZIPInputStream2.close();
            randomAccessFile.close();
            fileOutputStream.close();
            return 1;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static int patchLessMemory(RandomAccessFile randomAccessFile, File file, File file2, int i) throws IOException {
        if (randomAccessFile == null || randomAccessFile.length() <= 0) {
            return 3;
        }
        if (file == null) {
            return 4;
        }
        if (file2 == null || file2.length() <= 0) {
            return 2;
        }
        int length = (int) file2.length();
        byte[] bArr = new byte[length];
        FileInputStream fileInputStream = new FileInputStream(file2);
        try {
            BSUtil.readFromStream(fileInputStream, bArr, 0, length);
            fileInputStream.close();
            return patchLessMemory(randomAccessFile, (int) randomAccessFile.length(), bArr, length, file, i);
        } catch (Throwable th) {
            fileInputStream.close();
            throw th;
        }
    }
}
