package com.google.zxing.common;

import java.util.Arrays;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/common/BitMatrix.class */
public final class BitMatrix implements Cloneable {
    private final int[] bits;
    private final int height;
    private final int rowSize;
    private final int width;

    public BitMatrix(int i) {
        this(i, i);
    }

    public BitMatrix(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.width = i;
        this.height = i2;
        int i3 = (i + 31) / 32;
        this.rowSize = i3;
        this.bits = new int[i3 * i2];
    }

    private BitMatrix(int i, int i2, int i3, int[] iArr) {
        this.width = i;
        this.height = i2;
        this.rowSize = i3;
        this.bits = iArr;
    }

    private String buildToString(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.height * (this.width + 1));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.height) {
                return sb.toString();
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.width) {
                    sb.append(get(i4, i2) ? str : str2);
                    i3 = i4 + 1;
                }
            }
            sb.append(str3);
            i = i2 + 1;
        }
    }

    public static BitMatrix parse(String str, String str2, String str3) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        boolean[] zArr = new boolean[str.length()];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = -1;
        int i5 = 0;
        while (i < str.length()) {
            if (str.charAt(i) == '\n' || str.charAt(i) == '\r') {
                int i6 = i3;
                int i7 = i4;
                int i8 = i5;
                if (i2 > i3) {
                    if (i4 == -1) {
                        i4 = i2 - i3;
                    } else if (i2 - i3 != i4) {
                        throw new IllegalArgumentException("row lengths do not match");
                    }
                    i8 = i5 + 1;
                    i6 = i2;
                    i7 = i4;
                }
                i++;
                i3 = i6;
                i4 = i7;
                i5 = i8;
            } else {
                if (str.substring(i, str2.length() + i).equals(str2)) {
                    i += str2.length();
                    zArr[i2] = true;
                } else if (!str.substring(i, str3.length() + i).equals(str3)) {
                    throw new IllegalArgumentException("illegal character encountered: " + str.substring(i));
                } else {
                    i += str3.length();
                    zArr[i2] = false;
                }
                i2++;
            }
        }
        int i9 = i4;
        int i10 = i5;
        if (i2 > i3) {
            if (i4 == -1) {
                i4 = i2 - i3;
            } else if (i2 - i3 != i4) {
                throw new IllegalArgumentException("row lengths do not match");
            }
            i10 = i5 + 1;
            i9 = i4;
        }
        BitMatrix bitMatrix = new BitMatrix(i9, i10);
        int i11 = 0;
        while (true) {
            int i12 = i11;
            if (i12 >= i2) {
                return bitMatrix;
            }
            if (zArr[i12]) {
                bitMatrix.set(i12 % i9, i12 / i9);
            }
            i11 = i12 + 1;
        }
    }

    public static BitMatrix parse(boolean[][] zArr) {
        int length = zArr.length;
        int length2 = zArr[0].length;
        BitMatrix bitMatrix = new BitMatrix(length2, length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return bitMatrix;
            }
            boolean[] zArr2 = zArr[i2];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < length2) {
                    if (zArr2[i4]) {
                        bitMatrix.set(i4, i2);
                    }
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    public void clear() {
        int length = this.bits.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            this.bits[i2] = 0;
            i = i2 + 1;
        }
    }

    /* renamed from: clone */
    public BitMatrix m3847clone() {
        return new BitMatrix(this.width, this.height, this.rowSize, (int[]) this.bits.clone());
    }

    public boolean equals(Object obj) {
        if (obj instanceof BitMatrix) {
            BitMatrix bitMatrix = (BitMatrix) obj;
            return this.width == bitMatrix.width && this.height == bitMatrix.height && this.rowSize == bitMatrix.rowSize && Arrays.equals(this.bits, bitMatrix.bits);
        }
        return false;
    }

    public void flip(int i, int i2) {
        int i3 = (i2 * this.rowSize) + (i / 32);
        int[] iArr = this.bits;
        iArr[i3] = (1 << (i & 31)) ^ iArr[i3];
    }

    public boolean get(int i, int i2) {
        return ((this.bits[(i2 * this.rowSize) + (i / 32)] >>> (i & 31)) & 1) != 0;
    }

    public int[] getBottomRightOnBit() {
        int i;
        int length = this.bits.length;
        while (true) {
            i = length - 1;
            if (i < 0 || this.bits[i] != 0) {
                break;
            }
            length = i;
        }
        if (i < 0) {
            return null;
        }
        int i2 = this.rowSize;
        int i3 = i / i2;
        int i4 = this.bits[i];
        int i5 = 31;
        while (true) {
            int i6 = i5;
            if ((i4 >>> i6) != 0) {
                return new int[]{((i % i2) << 5) + i6, i3};
            }
            i5 = i6 - 1;
        }
    }

    public int[] getEnclosingRectangle() {
        int i;
        int i2;
        int i3 = this.width;
        int i4 = this.height;
        int i5 = -1;
        int i6 = -1;
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= this.height) {
                break;
            }
            int i9 = 0;
            while (true) {
                int i10 = this.rowSize;
                if (i9 < i10) {
                    int i11 = this.bits[(i10 * i8) + i9];
                    int i12 = i3;
                    int i13 = i4;
                    int i14 = i5;
                    int i15 = i6;
                    if (i11 != 0) {
                        int i16 = i4;
                        if (i8 < i4) {
                            i16 = i8;
                        }
                        int i17 = i6;
                        if (i8 > i6) {
                            i17 = i8;
                        }
                        int i18 = i9 << 5;
                        int i19 = i3;
                        if (i18 < i3) {
                            int i20 = 0;
                            while (true) {
                                i2 = i20;
                                if ((i11 << (31 - i2)) != 0) {
                                    break;
                                }
                                i20 = i2 + 1;
                            }
                            int i21 = i2 + i18;
                            i19 = i3;
                            if (i21 < i3) {
                                i19 = i21;
                            }
                        }
                        i12 = i19;
                        i13 = i16;
                        i14 = i5;
                        i15 = i17;
                        if (i18 + 31 > i5) {
                            int i22 = 31;
                            while (true) {
                                i = i22;
                                if ((i11 >>> i) != 0) {
                                    break;
                                }
                                i22 = i - 1;
                            }
                            int i23 = i18 + i;
                            i12 = i19;
                            i13 = i16;
                            i14 = i5;
                            i15 = i17;
                            if (i23 > i5) {
                                i14 = i23;
                                i15 = i17;
                                i13 = i16;
                                i12 = i19;
                            }
                        }
                    }
                    i9++;
                    i3 = i12;
                    i4 = i13;
                    i5 = i14;
                    i6 = i15;
                }
            }
            i7 = i8 + 1;
        }
        if (i5 < i3 || i6 < i4) {
            return null;
        }
        return new int[]{i3, i4, (i5 - i3) + 1, (i6 - i4) + 1};
    }

    public int getHeight() {
        return this.height;
    }

    public BitArray getRow(int i, BitArray bitArray) {
        if (bitArray == null || bitArray.getSize() < this.width) {
            bitArray = new BitArray(this.width);
        } else {
            bitArray.clear();
        }
        int i2 = this.rowSize;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.rowSize) {
                return bitArray;
            }
            bitArray.setBulk(i4 << 5, this.bits[(i * i2) + i4]);
            i3 = i4 + 1;
        }
    }

    public int getRowSize() {
        return this.rowSize;
    }

    public int[] getTopLeftOnBit() {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            int[] iArr = this.bits;
            if (i >= iArr.length || iArr[i] != 0) {
                break;
            }
            i2 = i + 1;
        }
        int[] iArr2 = this.bits;
        if (i == iArr2.length) {
            return null;
        }
        int i3 = this.rowSize;
        int i4 = i / i3;
        int i5 = iArr2[i];
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if ((i5 << (31 - i7)) != 0) {
                return new int[]{((i % i3) << 5) + i7, i4};
            }
            i6 = i7 + 1;
        }
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int i = this.width;
        return (((((((i * 31) + i) * 31) + this.height) * 31) + this.rowSize) * 31) + Arrays.hashCode(this.bits);
    }

    public void rotate180() {
        int width = getWidth();
        int height = getHeight();
        BitArray bitArray = new BitArray(width);
        BitArray bitArray2 = new BitArray(width);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= (height + 1) / 2) {
                return;
            }
            bitArray = getRow(i2, bitArray);
            int i3 = (height - 1) - i2;
            bitArray2 = getRow(i3, bitArray2);
            bitArray.reverse();
            bitArray2.reverse();
            setRow(i2, bitArray2);
            setRow(i3, bitArray);
            i = i2 + 1;
        }
    }

    public void set(int i, int i2) {
        int i3 = (i2 * this.rowSize) + (i / 32);
        int[] iArr = this.bits;
        iArr[i3] = (1 << (i & 31)) | iArr[i3];
    }

    public void setRegion(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i4 <= 0 || i3 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i5 = i3 + i;
        int i6 = i4 + i2;
        if (i6 > this.height || i5 > this.width) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i2 < i6) {
            int i7 = this.rowSize;
            int i8 = i;
            while (true) {
                int i9 = i8;
                if (i9 < i5) {
                    int[] iArr = this.bits;
                    int i10 = (i9 / 32) + (i7 * i2);
                    iArr[i10] = iArr[i10] | (1 << (i9 & 31));
                    i8 = i9 + 1;
                }
            }
            i2++;
        }
    }

    public void setRow(int i, BitArray bitArray) {
        int[] bitArray2 = bitArray.getBitArray();
        int[] iArr = this.bits;
        int i2 = this.rowSize;
        System.arraycopy(bitArray2, 0, iArr, i * i2, i2);
    }

    public String toString() {
        return toString("X ", "  ");
    }

    public String toString(String str, String str2) {
        return buildToString(str, str2, "\n");
    }

    @Deprecated
    public String toString(String str, String str2, String str3) {
        return buildToString(str, str2, str3);
    }

    public void unset(int i, int i2) {
        int i3 = (i2 * this.rowSize) + (i / 32);
        int[] iArr = this.bits;
        iArr[i3] = (1 << (i & 31)) & iArr[i3];
    }

    public void xor(BitMatrix bitMatrix) {
        if (this.width != bitMatrix.getWidth() || this.height != bitMatrix.getHeight() || this.rowSize != bitMatrix.getRowSize()) {
            throw new IllegalArgumentException("input matrix dimensions do not match");
        }
        BitArray bitArray = new BitArray(this.width);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.height) {
                return;
            }
            int i3 = this.rowSize;
            int[] bitArray2 = bitMatrix.getRow(i2, bitArray).getBitArray();
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < this.rowSize) {
                    int[] iArr = this.bits;
                    int i6 = (i3 * i2) + i5;
                    iArr[i6] = iArr[i6] ^ bitArray2[i5];
                    i4 = i5 + 1;
                }
            }
            i = i2 + 1;
        }
    }
}
