package com.sobot.chat.widget.zxing.datamatrix.encoder;

import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/datamatrix/encoder/DefaultPlacement.class */
public class DefaultPlacement {
    private final byte[] bits;
    private final CharSequence codewords;
    private final int numcols;
    private final int numrows;

    public DefaultPlacement(CharSequence charSequence, int i, int i2) {
        this.codewords = charSequence;
        this.numcols = i;
        this.numrows = i2;
        byte[] bArr = new byte[i * i2];
        this.bits = bArr;
        Arrays.fill(bArr, (byte) -1);
    }

    private void corner1(int i) {
        module(this.numrows - 1, 0, i, 1);
        module(this.numrows - 1, 1, i, 2);
        module(this.numrows - 1, 2, i, 3);
        module(0, this.numcols - 2, i, 4);
        module(0, this.numcols - 1, i, 5);
        module(1, this.numcols - 1, i, 6);
        module(2, this.numcols - 1, i, 7);
        module(3, this.numcols - 1, i, 8);
    }

    private void corner2(int i) {
        module(this.numrows - 3, 0, i, 1);
        module(this.numrows - 2, 0, i, 2);
        module(this.numrows - 1, 0, i, 3);
        module(0, this.numcols - 4, i, 4);
        module(0, this.numcols - 3, i, 5);
        module(0, this.numcols - 2, i, 6);
        module(0, this.numcols - 1, i, 7);
        module(1, this.numcols - 1, i, 8);
    }

    private void corner3(int i) {
        module(this.numrows - 3, 0, i, 1);
        module(this.numrows - 2, 0, i, 2);
        module(this.numrows - 1, 0, i, 3);
        module(0, this.numcols - 2, i, 4);
        module(0, this.numcols - 1, i, 5);
        module(1, this.numcols - 1, i, 6);
        module(2, this.numcols - 1, i, 7);
        module(3, this.numcols - 1, i, 8);
    }

    private void corner4(int i) {
        module(this.numrows - 1, 0, i, 1);
        module(this.numrows - 1, this.numcols - 1, i, 2);
        module(0, this.numcols - 3, i, 3);
        module(0, this.numcols - 2, i, 4);
        module(0, this.numcols - 1, i, 5);
        module(1, this.numcols - 3, i, 6);
        module(1, this.numcols - 2, i, 7);
        module(1, this.numcols - 1, i, 8);
    }

    private void module(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        if (i < 0) {
            int i7 = this.numrows;
            i5 = i + i7;
            i6 = i2 + (4 - ((i7 + 4) % 8));
        }
        int i8 = i5;
        int i9 = i6;
        if (i6 < 0) {
            int i10 = this.numcols;
            i9 = i6 + i10;
            i8 = i5 + (4 - ((i10 + 4) % 8));
        }
        boolean z = true;
        if ((this.codewords.charAt(i3) & (1 << (8 - i4))) == 0) {
            z = false;
        }
        setBit(i9, i8, z);
    }

    private boolean noBit(int i, int i2) {
        return this.bits[(i2 * this.numcols) + i] < 0;
    }

    private void setBit(int i, int i2, boolean z) {
        this.bits[(i2 * this.numcols) + i] = z ? (byte) 1 : (byte) 0;
    }

    private void utah(int i, int i2, int i3) {
        int i4 = i - 2;
        int i5 = i2 - 2;
        module(i4, i5, i3, 1);
        int i6 = i2 - 1;
        module(i4, i6, i3, 2);
        int i7 = i - 1;
        module(i7, i5, i3, 3);
        module(i7, i6, i3, 4);
        module(i7, i2, i3, 5);
        module(i, i5, i3, 6);
        module(i, i6, i3, 7);
        module(i, i2, i3, 8);
    }

    public final boolean getBit(int i, int i2) {
        return this.bits[(i2 * this.numcols) + i] == 1;
    }

    final byte[] getBits() {
        return this.bits;
    }

    final int getNumcols() {
        return this.numcols;
    }

    final int getNumrows() {
        return this.numrows;
    }

    public final void place() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = 0;
        int i10 = 0;
        int i11 = 4;
        while (true) {
            int i12 = i10;
            if (i11 == this.numrows) {
                i12 = i10;
                if (i9 == 0) {
                    corner1(i10);
                    i12 = i10 + 1;
                }
            }
            int i13 = i12;
            if (i11 == this.numrows - 2) {
                i13 = i12;
                if (i9 == 0) {
                    i13 = i12;
                    if (this.numcols % 4 != 0) {
                        corner2(i12);
                        i13 = i12 + 1;
                    }
                }
            }
            int i14 = i13;
            if (i11 == this.numrows - 2) {
                i14 = i13;
                if (i9 == 0) {
                    i14 = i13;
                    if (this.numcols % 8 == 4) {
                        corner3(i13);
                        i14 = i13 + 1;
                    }
                }
            }
            int i15 = i9;
            int i16 = i14;
            int i17 = i11;
            if (i11 == this.numrows + 4) {
                i15 = i9;
                i16 = i14;
                i17 = i11;
                if (i9 == 2) {
                    i15 = i9;
                    i16 = i14;
                    i17 = i11;
                    if (this.numcols % 8 == 0) {
                        corner4(i14);
                        i16 = i14 + 1;
                        i17 = i11;
                        i15 = i9;
                    }
                }
            }
            do {
                i = i16;
                if (i17 < this.numrows) {
                    i = i16;
                    if (i15 >= 0) {
                        i = i16;
                        if (noBit(i15, i17)) {
                            utah(i17, i15, i16);
                            i = i16 + 1;
                        }
                    }
                }
                i2 = i17 - 2;
                i3 = i15 + 2;
                if (i2 < 0) {
                    break;
                }
                i15 = i3;
                i16 = i;
                i17 = i2;
            } while (i3 < this.numcols);
            int i18 = i2 + 1;
            int i19 = i;
            int i20 = i3 + 3;
            do {
                i4 = i19;
                if (i18 >= 0) {
                    i4 = i19;
                    if (i20 < this.numcols) {
                        i4 = i19;
                        if (noBit(i20, i18)) {
                            utah(i18, i20, i19);
                            i4 = i19 + 1;
                        }
                    }
                }
                i5 = i18 + 2;
                i6 = i20 - 2;
                if (i5 >= this.numrows) {
                    break;
                }
                i20 = i6;
                i19 = i4;
                i18 = i5;
            } while (i6 >= 0);
            int i21 = i5 + 3;
            int i22 = i6 + 1;
            i7 = this.numrows;
            i9 = i22;
            i10 = i4;
            i11 = i21;
            if (i21 >= i7) {
                i8 = this.numcols;
                i9 = i22;
                i10 = i4;
                i11 = i21;
                if (i22 >= i8) {
                    break;
                }
            }
        }
        if (noBit(i8 - 1, i7 - 1)) {
            setBit(this.numcols - 1, this.numrows - 1, true);
            setBit(this.numcols - 2, this.numrows - 2, true);
        }
    }
}
