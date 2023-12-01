package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/qrcode/decoder/BitMatrixParser.class */
final class BitMatrixParser {
    private final BitMatrix bitMatrix;
    private boolean mirror;
    private FormatInformation parsedFormatInfo;
    private Version parsedVersion;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BitMatrixParser(BitMatrix bitMatrix) throws FormatException {
        int height = bitMatrix.getHeight();
        if (height < 21 || (height & 3) != 1) {
            throw FormatException.getFormatInstance();
        }
        this.bitMatrix = bitMatrix;
    }

    private int copyBit(int i, int i2, int i3) {
        return this.mirror ? this.bitMatrix.get(i2, i) : this.bitMatrix.get(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mirror() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.bitMatrix.getWidth()) {
                return;
            }
            int i3 = i2 + 1;
            int i4 = i3;
            while (true) {
                int i5 = i4;
                if (i5 < this.bitMatrix.getHeight()) {
                    if (this.bitMatrix.get(i2, i5) != this.bitMatrix.get(i5, i2)) {
                        this.bitMatrix.flip(i5, i2);
                        this.bitMatrix.flip(i2, i5);
                    }
                    i4 = i5 + 1;
                }
            }
            i = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] readCodewords() throws FormatException {
        FormatInformation readFormatInformation = readFormatInformation();
        Version readVersion = readVersion();
        DataMask dataMask = DataMask.values()[readFormatInformation.getDataMask()];
        int height = this.bitMatrix.getHeight();
        dataMask.unmaskBitMatrix(this.bitMatrix, height);
        BitMatrix buildFunctionPattern = readVersion.buildFunctionPattern();
        byte[] bArr = new byte[readVersion.getTotalCodewords()];
        int i = height - 1;
        boolean z = true;
        int i2 = i;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i2 > 0) {
            int i6 = i2;
            if (i2 == 6) {
                i6 = i2 - 1;
            }
            int i7 = 0;
            while (i7 < height) {
                int i8 = z ? i - i7 : i7;
                int i9 = 0;
                int i10 = i5;
                int i11 = i4;
                while (i9 < 2) {
                    int i12 = i6 - i9;
                    int i13 = i3;
                    int i14 = i11;
                    int i15 = i10;
                    if (!buildFunctionPattern.get(i12, i8)) {
                        int i16 = i11 + 1;
                        int i17 = i10 << 1;
                        int i18 = i17;
                        if (this.bitMatrix.get(i12, i8)) {
                            i18 = i17 | 1;
                        }
                        i13 = i3;
                        i14 = i16;
                        i15 = i18;
                        if (i16 == 8) {
                            bArr[i3] = (byte) i18;
                            i13 = i3 + 1;
                            i14 = 0;
                            i15 = 0;
                        }
                    }
                    i9++;
                    i3 = i13;
                    i11 = i14;
                    i10 = i15;
                }
                i7++;
                i4 = i11;
                i5 = i10;
            }
            z = !z;
            i2 = i6 - 2;
        }
        if (i3 == readVersion.getTotalCodewords()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FormatInformation readFormatInformation() throws FormatException {
        FormatInformation formatInformation = this.parsedFormatInfo;
        if (formatInformation != null) {
            return formatInformation;
        }
        int i = 0;
        for (int i2 = 0; i2 < 6; i2++) {
            i = copyBit(i2, 8, i);
        }
        int copyBit = copyBit(8, 7, copyBit(8, 8, copyBit(7, 8, i)));
        int i3 = 5;
        while (true) {
            int i4 = i3;
            if (i4 < 0) {
                break;
            }
            copyBit = copyBit(8, i4, copyBit);
            i3 = i4 - 1;
        }
        int height = this.bitMatrix.getHeight();
        int i5 = 0;
        for (int i6 = height - 1; i6 >= height - 7; i6--) {
            i5 = copyBit(8, i6, i5);
        }
        int i7 = height - 8;
        while (true) {
            int i8 = i7;
            if (i8 >= height) {
                break;
            }
            i5 = copyBit(i8, 8, i5);
            i7 = i8 + 1;
        }
        FormatInformation decodeFormatInformation = FormatInformation.decodeFormatInformation(copyBit, i5);
        this.parsedFormatInfo = decodeFormatInformation;
        if (decodeFormatInformation != null) {
            return decodeFormatInformation;
        }
        throw FormatException.getFormatInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Version readVersion() throws FormatException {
        Version version = this.parsedVersion;
        if (version != null) {
            return version;
        }
        int height = this.bitMatrix.getHeight();
        int i = (height - 17) / 4;
        if (i <= 6) {
            return Version.getVersionForNumber(i);
        }
        int i2 = height - 11;
        int i3 = 0;
        for (int i4 = 5; i4 >= 0; i4--) {
            int i5 = height;
            int i6 = 9;
            while (true) {
                int i7 = i5 - i6;
                if (i7 >= i2) {
                    i3 = copyBit(i7, i4, i3);
                    i5 = i7;
                    i6 = 1;
                }
            }
        }
        Version decodeVersionInformation = Version.decodeVersionInformation(i3);
        int i8 = 5;
        int i9 = 0;
        if (decodeVersionInformation != null) {
            i8 = 5;
            i9 = 0;
            if (decodeVersionInformation.getDimensionForVersion() == height) {
                this.parsedVersion = decodeVersionInformation;
                return decodeVersionInformation;
            }
        }
        while (i8 >= 0) {
            int i10 = height;
            int i11 = 9;
            while (true) {
                int i12 = i10 - i11;
                if (i12 >= i2) {
                    i9 = copyBit(i8, i12, i9);
                    i10 = i12;
                    i11 = 1;
                }
            }
            i8--;
        }
        Version decodeVersionInformation2 = Version.decodeVersionInformation(i9);
        if (decodeVersionInformation2 == null || decodeVersionInformation2.getDimensionForVersion() != height) {
            throw FormatException.getFormatInstance();
        }
        this.parsedVersion = decodeVersionInformation2;
        return decodeVersionInformation2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void remask() {
        if (this.parsedFormatInfo == null) {
            return;
        }
        DataMask.values()[this.parsedFormatInfo.getDataMask()].unmaskBitMatrix(this.bitMatrix, this.bitMatrix.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMirror(boolean z) {
        this.parsedVersion = null;
        this.parsedFormatInfo = null;
        this.mirror = z;
    }
}
